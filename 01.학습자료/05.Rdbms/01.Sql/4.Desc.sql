/* Desc
 * 	- 테이블의 정보를 확인하는 명령어로 데이터 타입과 제약조건에대한 정보를 제공한다.
 * 	- 예)desc employees;	
 * 
 * 	예) Departments의 정보
 * 		- NUMBER(4) : 숫자타입, 4자리까지 허용
 * 		- VARCHAR2(30) : 문자타입, 30자리까지 허용
 * 		- NUMBER(8,2) : 숫자 8자리 중 두자리를 소수점으로 표시
 * 
 * 	[참고] DBeaver에서는 f4를 눌러서 확인한다.
 */
select * from departments;