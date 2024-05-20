/* 서브 쿼리
 * 	- 셀렉트문 안에 셀렉트문 구조를 가지는 쿼리문
 * 	- 비교하는 데이터가 동 테이블 내에 존재하지 않아 찾아와야하는 경우에 사용한다.
 * 	- 서브쿼리의 값과 where절 (혹은 having절)의 컬럼의 데이터 타입은 같아야한다.
 */
select
   employee_id,
   last_name
from employees
where salary < (select min(salary) from employees where last_name = 'King');


/* 단일행 서브 쿼리 
 *	- 서브쿼리의 셀렉트문의 결과가 단일행이 나오는 형태로 아래 형태의 서브 쿼리가 단일행 서브쿼리에 속한다. 
 *	- 단일행 비교 연산자는 =, >, >=, <, <=, <>, !=, ^= 가 있다.
 */
-- 예) 서브 쿼리의 작성 순서 (평균 연봉이 가장 높은 부서를 조회하고자하는 경우)
-- (1) 평균 연봉이 가장 높은 부서를 조회
select max(avg(salary)) from employees group by department_id;

-- (2) 각 부서별 평균 연봉 확인
select avg(salary), department_id from employees group by department_id;

-- (3) 1번과 2번의 쿼리를 병합 (1번이 메인 쿼리, 2번이 서브 쿼리가 된다.)
select 
     avg(salary), department_id
from employees group by department_id
having avg(salary) = (select max(avg(salary)) from employees group by department_id);


-- 예) last_name King인 사원보다 연봉이 높은 사원의 employee_id와 last_name 확인
-- (King 사원은 두명이 존재하므로 두 King중 연봉이 낮은 사원보다 높은 사원 정보를 뽑아야하므로 min(salary) 처리를 한다.)
select
     employee_id, last_name
from employees
where salary < (select min(salary) from employees where last_name = 'King');

-- 예) 서브쿼리의 GROUP BY 사용 (평균급여가 가장 낮은 JOB_ID를 검색)
select
     job_id, avg(salary) from employees group by job_id
having avg(salary) = (select min(avg(salary)) from employees group by job_id);


/* 중첩 서브 쿼리 
 * 	- Nested Sub Query
 * 	- 서브쿼리가 먼저 수행되고 메인쿼리가 수행되는 형태의 쿼리
 * 	- and를 통해서 새로운 중복 쿼리가 생성되는 방식
 */

-- 예) 중첩 서브 쿼리 (employee_id 110번인 사원의 job_id이면서 salary가 job_id가 'FI_ACCOUNT' 인 사원중 최소 연봉인 사원의 정보)
select * from employees
where job_id = (select job_id from employees where employee_id = 110)
and salary > (select min(salary) from employees where job_id = 'FI_ACCOUNT');


/* 다중행 서브 쿼리 
 * 	- 서브 쿼리의 값이 여러개의 행이 나오는 쿼리
 * 	- 여러행 비교연산자에는 in, any, all이 속한다.
 * 	- any는 or의 역할로서 all은 and의 역할로서 동작한다.
 * 
 * 	(1) any
 * 		- or의 역할을 수행한다.
 * 		- 이름이 King이 들어가는 사람 중 가장 적은 연봉을 가진 King보다 많은 연봉을 받는 사원 검색
 * 		- 예) 가장 작은 연봉이므로 salary > 10 or salary > 20 or salary > 30 이 되어야 가장 최소값 10을 잡으므로 any가 사용된다. 
 * 
 * 	(2) all
 * 		- and의 역할을 수행한다.
 * 		- 이름이 King이 들어가는 사람 중 가장 높은 연봉보다 많은 연봉을 받는 사원 검색
 * 		- 예)가장 높은 연봉이므로 salary > 10 and salary > 20 and salary > 30 이되어야 최고값 30을 잡으므로 and가 사용된다.
 */

-- (1) any
select * from employees
where salary > any (select salary from employees where last_name = 'King');

-- (2) all
select * from employees
where salary > all (select salary from employees where last_name = 'King');

-- (3) in
select * from employees where employee_id in (select manager_id from employees);


/* 다중행 비교 연산자 
 * 	- all, and, any, or가 해당된다.
 * 	
 * 	(1) 비교 값이 더 큰 상황에서 any(or)
 * 		- salary가 100보다 크거나 200보다 크거나, 300보다 크다. 는 뜻은 값이 100보다 큰 경우 200, 300이던 전부 뽑아낸다는 뜻이 된다.
 * 		- 즉, 최소값의 역할로서 최소값보다 큰 값은 다 뿌린다.
 * 
 * 		(1.1) any
 * 			- where salary > any(100,200,300)
 * 			- any는 or의 의미를 가지므로 where salary > 100 or salary > 200 or salary > 300 와 같다.
 * 
 * 	(2) 비교 값이 더 작은 상황에서 any(or)
 * 		- salary가 100보다 작거나 200보다 작거나 300보다 작다. 는 뜻은 100보다 작은 것만 뿌린다는 뜻이 된다.
 * 		- 공통적으로 100보다 작은 값만 뿌린다고 생각하면 200, 300은 자동으로 포함이 된다.
 * 		- 즉, 최소값의 역할로서 최소값보다 작은 값은 다 뿌린다.
 * 
 * 		(2.1) any
 * 			- where salary < any(100,200,300)
 * 			- any는 or의 의미를 가지므로 where salary < 100 or salary < 200 or salary < 300 와 같다.
 * 
 * 	(3) 비교 값이 더 큰 상황에서 all(and)
 * 		- salary가 100보다 높고 200보다 높고, 300보다도 높아야한다는 뜻으로 적어도 최대값보다는 높아야만 범주안의 모든 값이 다 포함된다.
 * 		- 즉, 최대값의 역할로서 최대값보다 높은 값은 다 뽑아낸다.
 * 		
 * 		(3.1) all
 * 			- where salary > all(100,200,300)
 * 			- all은 and의 의미를 가지므로 where salary > 100 and salary > 200 and salary > 300 와 같다.
 * 
 * 	(4) 비교 값이 더 작은 상황에서 all(and)
 * 		- saalry가 300보다 작아야하고 200보다 작아야하며, 100보다도 작아야한다는 뜻으로 적어도 최소값보다는 작아야만 범주안의 모든 값이 포함된다는 의미이다.
 * 		- 즉, 최소값의 역할로서 최소값보다 작은 값은 다 뽑아낸다.
 * 
 * 		(4.1) all
 * 			- where salary < all(100,200,300)
 * 			- all은 and의 의미를 가지므로 where salary < 100 and salary < 200 and salary < 300 와 같다.
 */

-- (1.1) job_id가 'IT_PROG'인 사원들의 연봉중 최소값보다  연봉을 많이 받는 사원의 정보를 확인
-- # any 표현
select * from employees where salary > any (select salary from employees where job_id = 'IT_PROG');
-- # min 표현
select * from employees where salary < (select min(salary) from employees where job_id = 'IT_PROG');

-- (2.1) job_id가 'IT_PROG'인 사원들의 연봉 중 최소값보다 연봉을 적게 받는 사원의 정보를 확인
-- # any 표현
select * from employees where salary < any (select salary from employees where job_id = 'IT_PROG');
-- # max 표현
select * from employees where salary < (select max(salary) from employees where job_id = 'IT_PROG');

-- (3.1) job_id가 'IT_PROG'인 사원들의 연봉 중 최대값보다 연봉을 더 많이 받는 사원의 정보를 확인
-- # all 표현
select * from employees where salary > all (select salary from employees where job_id = 'IT_PROG');
-- # max 표현
select * from employees where salary > (select max(salary) from employees where job_id = 'IT_PROG');

-- (4.1) job_id가 'IT_PROG'인 사원들의 연봉 중 최소값보다  연봉을 더 적게 받는 사원의 정보를 확인
-- # all 표현
select * from employees where salary < all (select salary from employees where job_id = 'IT_PROG');
-- # min 표현
select * from employees where salary < (select min(salary) from employees where job_id = 'IT_PROG');


/* 다중열, 다중행 서브 쿼리 
 *	- 다중 행과 열의 서브쿼리는 쌍비교와 비쌍비교 방식 두가지가 있다.
 *	- 쌍비교는 두가지 컬럼의 비교 상황에서 두가지 컬럼을 동시에 함께 비교하는 방식이다.
 *	- 비쌍비교는 한쪽의 컬럼을 가지고 경우의 수처럼 한가지 컬럼의 값은 나머지 한쪽의 컬럼과 경우의 수처럼 비교하는 방식이다. 
 */

-- (1) 쌍비교 : 100 10을 가지고 함께 비교하는 방식 (100 10을 비교, 200 20을 비교)
select
   *
from employees
where (manager_id, department_id) in (select manager_id, department_id from employees where first_name = 'John');

-- (2) 비쌍비교 : 100을 가지고 경우의 수처럼 10, 20, 30, 10의 순서로 비교하는 방식 (100과 10을 비교, 100과 20을 비교)
select
   *
from employees where manager_id in (select manager_id from employees where first_name = 'John');


/* 상호관련 서브 쿼리 
 * 	- 서브 쿼리와 메인 쿼리간에 서로 상관참조하는 쿼리 형태로서 서브 쿼리가 메인 쿼리를 참조하는 형식이다.
 * 	- 서브쿼리가 메인쿼리의 데이터를 통하여 결과를 내면 그 결과를 다시 메인 쿼리에서 이용하는 구조로서 서브 쿼리는 그 값을 확인하는 확인자 역할을 하게 된다.
 * 	
 * 	# 동작 순서
 * 		(1) 메인 쿼리가 수행된다.
 * 		(2) 메인 쿼리의 첫번째 행을 후보행으로 잡은 뒤 후보행의 데이터를 서브 쿼리로 전송한다.
 * 		(3) 서브 쿼리의 결과를 가져온 뒤 후보행의 값과 비교해서 참인 경우 출력 영역에 놓고 거짓이면 메인 쿼리의 다음 행으로 이동한다.
 * 		(4) 두번째 행을 후보행으로 잡고 위의 순서를 반복한다.
 * 
 * 	# 단점
 * 		​- 상호관련 서브쿼리의 단점은 ROW의 개수만큼 집계값을 반복해서 수행된다는 점이다.
 * 		- 즉, 행 수만큼 반복적으로 수행해야하므로 full scan의 방식으로 동작한다.
 * 		- 그래서 가상의 테이블을 생성하는 인라인 뷰 방식으로 대체하여 사용한다.
 */

-- 예) 자신의 부서 평균 급여보다 더 많이 받는 직원
select emp1.department_id, emp1.last_name, emp1.salary from employees emp1 
where salary = (select max(salary) from employees where emp1.department_id = department_id);
