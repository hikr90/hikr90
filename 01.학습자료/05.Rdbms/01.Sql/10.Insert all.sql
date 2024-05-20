/* insert all 
 * 	- 한번에 여러 인서트문을 처리하는 기능
 * 	- 서로 같은 구조의 다른 테이블이 존재하는 경우, 같은 데이터를 양측에 한번에 넣을 수도 있다.
 * 
 * 	(1) insert all (셀렉트문)
 * 		- 한번에 데이터를 모은 뒤 분류 작업하여 여러 테이블에 던지는 인서트 방식
 * 		- 소스 데이터는 모아서 한번에 던지는 데이터를 뜻하며 타겟 테이블은 데이터를 받는 공간이다.
 * 		- insert all은 소스 데이터를 타겟 테이블에 던지는 작업이라고 할 수 있다.
 * 		- 만약 소스 데이터에 명칭을 따로 부여한다면 insert all에서도 맞춰서 사용해줘야한다.
 * 
 * 	(2) insert all (직접 등록)
 * 		- 소스 데이터가 타 테이블이 아닌 직접 입력하는 방식인 경우 select * from dual을 입력한다.
 * 
 * 	(3) insert all (조건부)
 * 		- 조건에 부합하는 데이터만 인서트하는 식
 * 		- 조건 서식은 when, then으로 표현한다.
 * 		- when의 조건식이 참인 경우 인서트, 거짓인 경우 다음 데이터로 넘어간다.
 * 		- 해당 과정은 셀렉트문의 행 수 만큼 반복된다.
 * 
 * 	(4) insert first
 * 		- 입력 순서대로 인서트하는 방식
 * 		- 서브 쿼리를 사용하여 한번에 인서트 처리가 가능하다.
 * 		- when의 조건이 참인 경우 인서트문이 동작하고 거짓인 경우 다음 when의 조건을 검증한다. 
 */

-- # 테이블 생성
create table sal_history
as select employee_id, hire_date, salary from employees where 1=2;

create table mgr_history
as select employee_id, manager_id, salary from employees where 1=2;

-- (1) insert all (셀렉트문)
-- (1.1) target table
insert all
into sal_history(employee_id, hire_date, salary)
values(id, hire, sal)
​
into mgr_history(employee_id, manager_id, salary)
value(id, mgr, sal)

-- (1.2) source data
select employee_id, hire_date as hire, manager_id as mgr, salary as sal from employees;


-- (2) insert all (직접 등록)
-- (2.1) target table
insert all
into sal_history(employee_id, hire_date, salary)
values('998', '20240101', null)
​
INTO sal_history(employee_id, hire_date, salary)
values('998', '20240101', null)

-- (2.2) source data
select * from dual;


-- (3) insert all (조건부)
-- (3.1) target table
insert all
when hire_date < to_date('2005-01-01','YYYY-MM-DD') then 
into emp_history(employee_id, hire_date, salary)
value(id, hire, sal)

when commission_pct is not null then
into emp_sal(employee_id, commission_pct, salary)
value(id, comm, sal)

-- (3.2) source data
select employee_id as as hire_date as hire, salary sal, commission_pct as comm from employees;


-- # 테이블 생성
create table sal_low
as select employee_id, last_name, salary from employees where 1=2;

create table sal_mid
as select employee_id, last_name, salary from employees where 1=2;

create table sal_high
as select employee_id, last_name, salary from employees where 1=2;


-- (4) insert first
-- (4.1) target table
insert first
when salary < 5000 then
into sal_low(employee_id, last_name, salary) values(employee_id, last_name, salary)

when salary between 5000 and 10000 then
into sal_mid(employee_id, last_name, salary) values(employee_id, last_name, salary)

else into sal_high(employee_id, last_name, salary)
values(employee_id, last_name, salary)

-- (4.2) source data
select employee_id as id, last_name as name, salary as sal from employees;
