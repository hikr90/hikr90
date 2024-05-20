/* 집합 연산자 
 * 	- 데이터의 합집합, 교집합 등의 데이터를 뽑아내는 함수
 * 	- 각 집합을 조회하는 셀렉트문의 컬럼과 데이터 컬럼과 타입은 서로 같아야 한다.
 * 
 * 	종류
 * 		(1) union
 * 			- 중복 데이터를 제거한 뒤, 뽑아내는 방식이다.
 * 			- 함수 자체에 중복 제거를 위한 정렬과 해쉬 작업이 존재한다.
 * 			- 함수는 제한없이 사용할 수 있다.
 * 
 * 		(2) union all
 * 			- 중복 데이터를 포함하는 합집합이다.
 * 	
 * 		(3) intersect
 * 			- 교집합
 * 			- 현장에서는 정렬 (sort)이 자동으로 낭비되는 점 때문에 잘 사용하지 않는다.
 * 			- 대신 성능이 더 좋은 exists로 포함이 되는지 여부를 체크하는 방식을 사용한다.
 * 
 * 		(4) minus
 * 			- 차집합
 * 			- a-b의 경우, b에 속하지 않는 a의 데이터의 집합이다.
 * 			- intersect와 마찬가지로 exists를 많이 사용한다.
 */

-- (1) union (사원의 직업 이력의 정보를 중복없이 전부 출력)
select employee_id, job_id from employees
union
select employee_id, job_id from job_history;

-- (2) union all (사원과 직업 이력의 정보 중복 포함하여 전부 출력)
select employee_id, job_id from employees
union all
select employee_id, job_id from job_history;


/* 예) 위와 아래의 데이터를 강제로 맞추는 방법
 	- ''으로 빈 컬럼을 채우거나, null 등으로 컬럼의 종류를 맞춘다. */
select
     employee_id, department_id, null as department_name, '' as dept_nm
from employees
union
select 
     e.employee_id, e.department_id, d.department_name, d.department_name as dept_nm
from departments d join employees e on d.department_id = e.department_id;

-- (3) intersect (직업 이력과 직원에서 직원id와 직업id가 중복되는 행만 확인)
select employee_id, job_id from employees
intersect
select employee_id, job_id from job_history;

-- (3.1) exists 대체
select employee_id, job_id from employees e 
	where exists (select 'x' from job_history where employee_id = employee_id and e.job_id = job_id);

-- (4) minus (직업 이력과 직원에서 직원id와 직업id가 존재하지 않는 행만 확인)
select employee_id, job_id from employees
minus
select employee_id, job_id from job_history;

-- (4.1) exists 대체
select employee_id, job_id from employees e 
	where not exists (select 'x' from job_history where employee_id = employee_id and e.job_id = job_id);
