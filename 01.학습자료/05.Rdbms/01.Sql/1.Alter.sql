/* Alter 
 * 	- 계정, 권한 등의 수정 작업을 허용하는 명령어이다.
 * 	- 계정을 잠금하거나 해제, 비밀번호 수정 등의 작업이 가능하다.
 * 
 * 	예시
 * 		(1) 계정의 잠금을 해제 (hr : 유저명)
 * 			- 예) alter user hr account unlock;
 * 
 * 		(2) 계정을 잠금으로 변경
 * 			- 예) alter uesr hr account lock;
 * 
 * 		(3) 계정의 비밀번호를 변경하여 잠금을 해제
 * 			- 예) alter user hr identified by 1234 unlock;
 * 
 * 		(4) 계정의 비밀번호를 변경하여 잠금으로 변경
 * 			- 예) alter user hr identified by 1234 lock;
 * 
 * 		(5) 계정의 잠금 유효기간을 무제한으로 변경
 * 			- 예) alter profile default limit password_life_time_unlimited;
 * 
 * 	계정 잠금 해제
 * 		- 오라클 계정은 기본적으로 생성 후 180일이 지나면 잠금이 된다.
 * 		- 이를 풀기위해서는 오라클 시작 시 생성한 System 계정으로 접속하여 비밀번호를 alter문으로 해제해야한다.
 * 
 * 		(1) cmd 접속 후 System계정 정보 입력
 * 			- 시스템 계정의 아이디, 비밀번호는 사용자별 상이
 *  		- 예) conn system 입력
 * 			
 * 		(2) alter문으로 잠금 해제
 * 			- 예) alter user 계정명 account unlock;
 * 
 * 		(3) 오라클 잠금 유효기간 확인
 * 			- 예) select * from dba_profiles where resouce_name = "PASSWORD_LIFE_TIME"; 
 * 
 * 		(4) 오라클 잠금 유효기간 무제한으로 변경
 * 			- 예) alter profile default limit password_life_time unlimited;
 */