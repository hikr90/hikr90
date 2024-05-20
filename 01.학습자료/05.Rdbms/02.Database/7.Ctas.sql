/* CTAS 
 * 	- create table as select의 약자로, 테이블 자료를 복사하여 이전시키는 기능
 * 	- 셀렉트문을 통해서 복사할 범위를 지정할 수 있다.
 * 
 * 	(1) 전체 복사
 * 		- 예) create table test as select * from hr.employees;	
 * 
 * 	(2) 구조만 복사
 * 		- create table test as select employee_id, last_name as name from hr.employees where 1=2;
 * 
 * 	
 * 	insert select
 * 		- 한번에 여러 행을 인서트하고자하는 경우 사용한다.
 * 		- 문법 상 as를 사용할 수 없으며 where절을 통해서 인서트할 대상을 지정할 수 있다.
 * 		- 데이터를 전송받는, 전송하는 테이블의 구조가 맞아야한다.
 * 		- 예) insert into 세션명.테이블명 select * from 전송대상 세션명.전송대상 테이블명;
 */
