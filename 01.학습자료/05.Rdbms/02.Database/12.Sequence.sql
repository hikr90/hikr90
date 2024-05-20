/* Sequence 
 * 	- 테이블에 데이터를 저장할 때, 순서가 순차적으로 자동 지정되도록 하는 객체
 * 	- 값은 1부터 시작하며 중복되지 않는다. (기존 존재하는 번호가 중복되는 경우 에러가 발생한다.)
 * 	- 자동 커밋으로 DCL 작업이 따로 요구되지 않는다.
 * 
 * 	(1) 기본 생성
 * 		- 예) create sequence 시퀀스명;
 * 
 * 	(2) 특정 번호부터 시퀀스 생성
 * 		- 예) create sequence 시퀀스명 start with 번호;
 * 
 * 	(3) 조회
 * 		- 유저 내 생성한 시퀀스 조회
 * 		- 예) select * from user_sequences;
 * 
 * 	(4) 삭제
 * 		- 특정 시퀀스 삭제
 * 		- 예) drop sequence 시퀀스명;
 * 
 * 	메소드
 * 		(1) currVal
 * 			- 시퀀스의 현재 번호
 * 			- 예) insert into test values(seq_test.currVal, 'test', 1111);
 * 			- 예) select seq_test.currVal from dual;
 * 
 * 		(2) nextVal
 * 			- 시퀀스의 다음 번호
 * 			- 예) insert into test values(seq_test.nextVal, 'test', 1111);
 * 			- 예) select seq_test.nextVal from dual;
 */

