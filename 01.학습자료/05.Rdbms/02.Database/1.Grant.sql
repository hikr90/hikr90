/* 권한 
 * 	- 특정 sql 쿼리문을 수행할 수 있는 권리를 뜻한다.
 * 
 * 	종류
 * 		(1) connect
 * 			- DB에 접속할 수 있는 권한	
 * 
 * 		(2) alter session
 * 			- 환경 변수를 설정할 수 있는 권한
 * 
 * 		(3) unlimited tablespace
 * 			- DB내의 테이블 스페이스를 사용할 수 있는 권한
 * 
 * 		(4) resource
 * 			- 객체 및 데이터 조작 권한
 * 
 * 		(5) dba 
 * 			- 테이블 접근 권한
 * 
 * 	권한의 부여
 * 		(1) 직접 부여
 * 			- grant 권한 명칭 to 권한 부여 대상;
 * 
 * 
 * 		(2) role을 통해서 부여
 * 			- role이란 DB 엔지니어가 특정 용도를 위해서 남겨둔 권한을 의미한다.
 * 			- 기본적으로 유저를 생성할 때 create session, create table의 두가지 권한이 필요하다.
 * 	
 * 	권한 회수
 * 		- revoke 권한명 from 권한 회수할 테이블 명칭; 
 * 
 */

-- # user
-- (1) 받은 권한을 확인
select * from session_privs;

-- (2) DB로부터 직접 받은 시스템 권한 확인
select * from user_sys_privs;

-- (3) 부여받은 role 확인
select * from session_roles;

-- (4) DB로부터 부여받은 role안의 시스템 권한 확인
select * from role_sys_privs;


-- # DB
-- (1) 시스템 권한을 어떤 유저한테 부여했는지 확인
select * from dba_tab_privs;

-- (2) DB에 생성된 role에대한 정보를 확인
select * from dba_roles;

-- (3) role을 어떤 유저에게 부여했는지 확인
select * from dba_role_privs;

-- (4) DB가 어떤 유저에게 테이블 사용을 허락했는지 확인
select * from dba_ts_quotas;
