/* Merge 
 * 	- DML을 한번에 수행하는 기능
 * 	
 * 	merge 구조
 * 		- 타겟 테이블은 merge가 수행되는 테이블이다.
 * 		- 소스 테이블에는 서브 쿼리가 사용될 수도 있으며, 타겟과 동일한 테이블일 경우에는 dual로 대체 사용 가능하다.
 * 		- on절에서 사용하는 조건은 update 할 수 없으므로 BYPASS_UJVC를 사용하거나 rowid로 대체하여 사용해야한다.
 * 		- DML 문장은 1개 혹은 2개 이상의 작업이 가능하다.
 * 
 * 		merge into 타겟 테이블 t1
 * 			using 소스 테이블 t2 on t1.컬럼 = t2.컬럼			-- 비교 대상이 없는 경우, dual로 대체
 * 			when matched then
 * 				DML 문장									-- on절의 조건이 참인 경우 수행되는 영역
 * 			when not matched then
 * 				DML 문장									-- on절의 조건이 거짓인 경우 수행되는 영역
 */

/* 문제 
 * 	- dw_emp, oltp 양측 테이블에 포함된 사원은 salary의 1년치를 곱한 뒤, 그 중 oltp의 flag 컬럼이 'd'인 사원의 정보를 제외하여
 * 	- dw_emp 테이블에 해당 사원의 employee_id, salary, department_id가 보여주세요.
 * 	- 만약 위 조건에 해당하지 않는 경우, oltp_emp의 데이터를 보여주세요.
 */
-- table 생성
-- (1) oltp_emp 생성
create table oltp_emp
as select employee_id, last_name, salary, department_id from employees;

-- (2) dw_emp 생성
create table dw_emp
as select employee_id, last_name, salary, department_id from employees where department_id = 20;

-- (3) oltp_emp에 flag 컬럼 추가
alter table oltp_emp add flag char(1);

-- (4) oltp_emp의 employee_id가 202인 사람의 flag를 'd'로 변경
update oltp_emp
set flag = 'd'
where employee_id = 202;

-- (5) oltp_emp의 employee_id가 201인 사람의 salary를 2만으로 변경
update oltp_emp
set salary = 20000
where employee_id = 201;


-- merge문
merge into dw_emp d
using oltp o
on (d.department_id = o.employee_id)
when matched then 
update set d.salary = o.salary * 12
delete where o.flag = 'd'

when not matched then
insert (d.employee_id, d.last_name, d.salary, d.department_id) values (o.employee_id, o.last_name, o.salary, o.department_id);
