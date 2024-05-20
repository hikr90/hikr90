/* Group by 
 * 	- 행의 데이터를 특정 컬럼의 그룹 함수 단위로 묶는 용도
 * 	- 그룹 함수 사용 시, 그룹 함수에 포함되지 않은 컬럼은 group절 뒤에 넣어줘야한다.
 * 	- group절에서는 컬럼에 별칭을 사용할 수 없다.
 */

-- 예) 부서 번호 기준으로 그룹하여 salary의 합계 표시
select
   department_id,
   sum(salary)
from employees
group by department_id;


/* Having 
 * 	- group절의 행을 제어한다. (group절의 where절)
 * 	- 그룹 함수가 적용되는 컬럼에는 having절을 사용한다.
 */
select
   department_id,
   sum(salary)
from employees
where last_name like '%i%'
group BY department_id
having sum(salary) >= 1000
order by department_id asc;


/* Group by의 순서 
 * 	(1) select
 * 	(2) from
 * 	(3) where
 * 	(4) group by
 * 	(5) having
 * 	(6) order by
 */
select 
	department_id, sum(salary)
from employees
where last_name like '%i%'
group by department_id
having sum(salary) >= 1000
order by department_id asc;


/* Group by 연산자 
 * 	(1) rollup
 * 		- 그룹 절에서 지정된 컬럼들을 좌측에서 우측 순서로 인자 하나씩 그룹화하는 방식
 * 		- rollup의 인자를 오른쪽에서 하나씩 빼면서 그룹화한다.
 * 
 * 		(1.1) rollup 그룹화 순서
 * 			- 그룹화 순서는 좌측부터 진행된다. (아래 방식 참고)
 * 			- {} 는 전체 그룹화이다.
 * 	
 * 			SUM(SALARY) = {DEPARTMENT_ID,EMPLOYEE_ID,LAST_NAME}
 * 			SUM(SALARY) = {DEPARTMENT_ID,EMPLOYEE_ID}
 * 			SUM(SALARY) = {DEPARTMENT_ID}
 * 			SUM(SALARY) = {}
 * 
 * 	(2) cube
 * 		- group절에 포함되어있는 모든 컬럼을 가지고 생성 가능한 모든 경우를 그룹화하는 방식
 * 		- 조합이 가능한 모든 경우를 그룹화한다는 장점이 있으나 원치 않는 부분마저 그룹화한다는 단점도 있다.
 * 		- 중복되는 그룹화의 행은 없다.
 * 
 * 		(2.1) cube의 그룹화 순서
 * 			- cube의 그룹화는 경우의 수 방식으로 생성된다.
 * 			- 자세한 사항은 rollup 그룹화 방식 참고
 * 
 * 			​SUM(SALARY) = {DEPARTMENT_ID, EMPLOYEE_ID, LAST_NAME}
 * 			SUM(SALARY) = {DEPARTMENT_ID, EMPLOYEE_ID}
 * 			SUM(SALARY) = {DEPARTMENT_ID, LAST_NAME}
 * 			SUM(SALARY) = {EMPLOYEE_ID, LAST_NAME}
 * 			SUM(SALARY) = {DEPARTMENT_ID}
 * 			SUM(SALARY) = {EMPLOYEE_ID}
 * 			SUM(SALARY) = {LAST_NAME}
 * 
 * 	[참고] rollup과 cube의 차이
 * 		- rollup : 인자안의 파라미터를 우측에서 좌측 순서로 그룹화
 * 		- cube : 생성할 수 있는 모든 경우의 수를 그룹화
 * 
 * 	(3) grouping sets
 * 		- 사용자가 직접 원하는 그룹을 생성할 때 사용한다.
 * 		- 인자에서 () 는 전체 컬럼에대한 집계를 가져오는 것을 뜻한다.
 */

-- (1) rollup
select
     department_id as dept_id,
     employee_id as emp_id,
     last_name,
     sum(salary)
from employees 
group by rollup(department_id, employee_id, last_name);


-- 예) rollup의 다중 인자 : 인자 내 따로 괄호로 묶여있는 컬럼은 하나로 취급된다.
select
     department_id as dept_id,
     employee_id as emp_id,
     last_name,
     first_name,
     sum(salary)
from employees group by rollup(department_id, employee_id, (last_name, first_name));


-- (2) cube
select
     department_id, 
     last_name, sum(salary)
from employees group by cube(department_id, last_name);


-- (3) grouping sets
select
   department_id,
   job_id,
   manager_id,
   sum(salary)
from employees
group by grouping sets((department_id,job_Id),(department_id, manager_id),());