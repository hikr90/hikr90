/* 셀렉트문 
 * 	- DQL(Data Query Language)문이라고도 한다.
 * 	- 검색문으로서 테이블에서 특정 데이터를 찾고자할 때 사용한다.
 *
 * 	- *는 테이블 내의 모든 컬럼의 데이터를 출력한다는 뜻이다.
 * 	- Sql문장은 ; 표시로 쿼리문이 종료되었음을 의미한다.
 *
 *	컬럼 & 로우
 *  	- 쿼리문 검색 시 세로 영역을 컬럼, 가로 행의 영역을 로우라고 부른다.
 * 		- 컬럼과 로우의 교차 영역은 데이터로서 필드 값이라고 한다.
 * 
 * 	셀렉트의 기능
 * 		(1) Projection
 * 			- 특정 컬럼을 지정하여 출력하는 기능
 * 			- 예) select department_id, department_name from employees;
 * 
 * 		(2) Selection
 * 			- 데이터의 범위를 지정하여 출력하는 기능
 * 			- where절은 자원 검색 시 사용자가 원하는 자원을 연산자등을 통해서 비교할 수 있는 키워드이다.
 * 			- where절은 데이터 행을 제한하는 역할을 한다.
 * 			- 예) select * from employees where employee_id = 100;
 * 
 * 	[참고] 타 계정에서의 셀렉트 사용
 * 		- Sys계정에서는 employees 테이블이 존재하지 않는데 Sys 계정에서 hr계정에 있는 테이블에 접근하려고 할 때
 * 		- hr.employees 방식으로 검색해야한다.
 * 		- 예) select * from 계정명.테이블명;
 */

-- DB내 전체 유저 조회 
select * from all_users;

