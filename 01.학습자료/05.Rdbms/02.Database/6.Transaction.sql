/* 트랜젝션 
 * 	- DML을 하나로 묶어서 처리하는 논리적 작업 단위
 * 	- insert, update, delete, merge 작업 시 트랜젝션 상태가 된다.
 * 	- 트랜젝션 상태는 영구 반영이 되지 않은 상태로 commit, rollback등의 명령어로 완료 처리를 해야한다.
 * 
 * 	TCL 명령어
 * 		(1) commit : 트랜젝션 상태가 종료되며 DML 작업의 변경 내용을 영구히 저장
 * 			(1.1) auto commit
 * 				- 트랜젝션 상태가 없어지며 입력했던 DML 명령어가 바로 영구적용되는 기능
 * 				- 상황에따라서 오토커밋이 진행되는 경우가 있다.
 * 				
 * 				(1.1.1) DCL 명령어 : grant, revoke등 DCL명령어 수행 시 (DCL 작업과 DML 작업은 같은 곳에서 진행하지 않는다.)
 * 				(1.1.2) sqlplus에서 exit 명령어 입력 : sqlplus에서 exit 명령어를 입력 시 그 이전에 작업한 transaction은 자동 커밋이 된다.
 * 
 * 			(1.2) auto rollback
 * 				- 트랜젝션 상태가 없어지며 입력했던 DML 명령어가 전부 초기화된다.
 * 
 * 				(1.2.1) sqlplus가 강제로 종료 : 시스템이 비정상적으로 종료되는 경우 (상단의 x버튼이 클릭되거나 네트워크가 끊어진 경우)
 * 
 * 			(1.3) savepoint
 * 				- 작업 중 특정 부분만 commit하고 나머지 부분은 rollback한다.
 * 				- 1, 3데이터를 커밋 후 2만 롤백할 수는 없으며 2를 롤백하기위해서는 1,3도 롤백이 되어야한다.
 * 
 * 				# create table test(id, number);
 * 				# insert into test(id) values(1);
 * 				# savepoint a;							-- rollback to a (데이터 1은 커밋, 나머지는 롤백)
 * 				# insert into test(id) values(2);
 * 				# savepoint b;							-- rollback to b (데이터 1,2는 커밋, 나머지는 롤백)
 * 				# insert into test(id) values(3);
 * 
 * 
 * 		(2) rollback : 트랜젝션 상태가 종료되며 진행한 DML 작업을 트랜젝션 상태 전으로 복원
 * 		(3) savepoint : 트랜젝션 상태에서 특정 부분만 커밋 혹은 롤백
 * 
 * 	Dead Lock
 * 		- 교착상태라고 부르며, 트랜젝션이 서로 꼬여있는 상태이다.
 * 		- 여러 인원이 하나의 테이블을 수정할 수 없도록 하기위해서 존재하는 기능이다.
 * 		- 먼저 트랜젝션을 진행한 사용자가 커밋 혹은 롤백을 진행하면 대기 상태에 있는 후 순위의 사용자 작업이 진행된다.
 * 
 */
