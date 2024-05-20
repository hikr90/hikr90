/* View 
 * 	- 가상의 테이블, 조인 등의 기능으로 여러 테이블이 얽힌 쿼리문을 간단하게 조회하기위한 기능
 * 	- 기존에 뷰가 존재하는 경우 수정하는 create or replace 명령어를 사용한다.
 * 	- view는 단순 조회 용도로서 추가, 수정, 삭제 등의 DML 작업은 테이블에서 처리해야한다.
 * 
 * 	(1) 생성
 * 		create or replace view
 * 			뷰 명칭(뷰 컬럼 명칭) as 셀렉트문;
 * 
 * 	(2) 조회
 * 		select * from 뷰 명칭;
 * 
 * 	(3) 삭제
 * 		drop view test_emp;
 * 
 */

-- (1) 뷰 생성
create or replace view
test_emp(empno, hire, dept_id, dept_name) as
select 
	e.employee_id,
	e.hire_date,
	e.department_id,
	d.department_name 
from employees e join departments d on e.department_id = d.department_id;

-- (2) 조회
select * from test_emp;

-- (3) 삭제
drop view test_emp;