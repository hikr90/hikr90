/* 데이터베이스 명령어
 * 	(1) DML
 * 		- 데이터 조작어 (Data Manipulation Language)
 * 		- 데이터의 값을 조작하는 언어이다. 
 * 		- insert, update, delete
 * 
 * 		(1.1) insert
 * 			- 테이블 내 새로운 행을 등록하는 명령어
 * 			- 예) insert into dept values ('60','IT','606');
 * 
 * 			[참고] insert의 여러 방식
 * 				(1.1.1) 특정 컬럼에 default값을 직접 입력하여 생성
 * 					- 예) insert into test(id, name, day) values(1,’홍길동’,DEFAULT);
 * 					- (null은 default보다 더 높은 우선순위를 가진다.)
 * 
 * 				(1.1.2) default값을 넣을 컬럼 자체를 무시하여 생성
 * 					- 예) insert into test(id, name) values(1,’홍길동’);
 * 
 * 				(1.1.3) null값을 입력하여 생성
 * 					- insert into test(id, name,day) values(1,’홍길동’,NULL);
 * 
 * 		(1.2) update
 * 			- 테이블 내 행의 데이터를 수정하는 명령어
 * 			- where절을 통해서 특정 행의 선택이 가능하다. (만약 특정 행의 선택이 없는 경우 테이블 내 모든 행의 정보가 수정된다.)
 * 			- 예) update dept set loc = 600 where dept_no = '60';
 * 
 * 		(1.3) delete
 * 			- 테이블 내 행을 삭제하는 명령어
 * 			- where절을 통해서 특정 행의 선택이 가능하다. (만약 특정 행의 선택이 없는 경우 테이블 내 모든 행의 정보가 삭제된다.)
 * 			- 예) delete from dept where dept_no = 10; 
 * 
 * 	(2) DDL
 * 		- 데이터 정의어 (Data Definition Language)
 * 		- 데이터의 구조를 정의하는 언어이다. 
 * 		- create, alter, drop, rename, trunc
 * 
 * 	(3) DCL
 * 		- 데이터 제어어 (Data Control Language)
 * 		- 데이터의 권한 등을 제어하는 언어이다. 
 * 		- grant, revoke
 * 
 * 	(4) DQL
 * 		- 데이터 쿼리어 (Data QUERY Language)
 * 		- 데이터를 가져오는데 사용하는 언어이다.
 * 		- select
 * 
 * 	(5) TCL
 * 		- 트랜젝션 제어어 (Transaction Control Language)
 * 		- 데이터 작업의 트랜젝션을 제어하는 언어이다.
 * 		- commit, rollback, savepoint
 */