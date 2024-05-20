/* 유저 
 * 	- 오라클의 사용자
 * 	- 테이블 생성 시 특정 위치를 지정하지 않을 경우 tablespace 내 Users에 저장된다.
 * 
 * 	동작 설명
 * 		(1) create user ORA1				(ORA1이라는 유저를 생성)
 * 		(2) identified by ORA1				(비밀번호는 ORA1로 설정) 
 * 		(3) default tablespace USERS		(생성되는 정보는 tablespace USERS에 저장)
 * 		(4) temporary tablespace TEMP		(정렬 시 임시데이터는 tablespace TEMP에 저장)
 * 		(5) quota 10m on USERS				(유저가 사용할 수 있는 공간은 10m으로 지정)
 * 		(6) password expire;				(비밀번호의 유효기간이 만료될 시 내가 생성할 수 있도록 지정)
 * 
 * 	Quotas
 * 		- 테이블의 할당 용량을 뜻한다.
 * 		- max_bytes가 10485760은 10mb를 의미한다.
 * 		- max_bytes가 -1인 경우 무제한으로 사용 가능함을 의미한다.
 * 		- quota가 0인 경우 테이블 생성이 안된다.
 * 
 * 		(1) 용량 확인
 * 			- 예) select * from user_ts_quotas;
 * 
 * 		(2) 용량 수정
 * 			- 예) alter user hr quota 수정할 양 on user;
 * 
 * 		(3) 용량 무한 수정
 * 			- 예) alter user ORA1 quota unlimited on user;
 *
 * 	
 *  동작 종류
 * 		(1) 유저 삭제
 * 			- 유저를 관리하는 system에서 접속 후 drop 명령어를 사용한다.
 * 			- 예) drop user 유저명 cascade;
 * 
 * 		(2) 유저 수정
 * 			- 사용자가 수정하고자하는 데이터를 문장을 추가하여 변환하면 된다.
 * 			- account unlock 등의 문장도 붙여서 사용이 가능하다.
 * 			- 예) alter user ORA1 identified by ORA1 default tablespace temp quota 10m on users;
 * 
 * 		(3) 유저 권한 변경
 * 			- 예) grant connect, resource, dba to 생성한 유저;
 */