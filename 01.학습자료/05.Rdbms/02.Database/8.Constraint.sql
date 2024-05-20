/* 제약조건 
 * 	- 테이블 내 잘못된 데이터가 입력되지 않게 막기위한 규칙
 * 	- 생성 시 명칭이 따로 지정하지 않으면 오라클에서 임의의 명칭으로 생성한다.
 * 
 * 	제약조건의 조회
 * 		(1) 제약조건
 * 			- 예) select * from user_constraints where table_name = '테이블명';
 * 		(2) 인덱스
 * 			- 예) select * from user_indexes where table_name = '테이블명';
 * 
 * 		(3) 인덱스 컬럼
 * 			- 예) select * from user_ind_columns where table_name = '테이블명';
 * 
 * 	제약조건 종류
 * 		(1) primary key
 * 			- 테이블 내 대표 컬럼 값임을 나타내는 키 (기본키이자 아이덴티티가 되는 고유 값)
 * 			- 중복 값이나 null을 허용하지 않는다.
 * 			- 테이블 당 하나의 pk를 필수로 가진다.
 * 			- 유니크 인덱스 (중복을 허용하지 않는 인덱스) 가 자동으로 생성된다.
 * 			- 예) alter table 테이블명 add constraint 제약조건명 primary key(컬럼);
 * 	
 * 		(2) foreign key
 * 			- 테이블의 컬럼을 참조하는 제약조건
 * 			- 타 테이블의 primary key나 unique 제약조건이 있는 컬럼을 참조한다.
 * 			- null과 중복 데이터를 허용하나 인덱스는 생성되지 않는다.
 * 			
 * 			- 예) alter table 테이블명 add constraint 제약조건명 foreign key(컬럼) references 테이블명(컬럼);
 * 			- 예) 테이블 생성과 동시에 생성
 * 				create table 테이블명
 *					(
 *						test_no varchar2(10) primary key,
 *						test_nm varchar2(20),
 *						test_cd varchar2(20), foreign key(컬럼)
 *						references 참조하는 테이블명(컬럼)
 *					);
 * 
 * 		(3) unique
 * 			- 중복 데이터를 허용하지 않는 제약조건 (null은 허용한다.)
 * 			- 자동으로 유니크 인덱스를 생성한다.
 * 			- 예) alter table 테이블명 add constraint 제약조건명 unique(컬럼);
 * 
 * 		(4) check
 * 			- 특정 조건을 부여하는 제약조건 (제약조건에 위배되지 않는 한에서 입력 및 수정이 가능하다.)
 * 			- null과 중복 데이터를 허용한다.
 * 			- 동일 명칭이 아니라면 check 제약조건은 중복으로 생성이 가능하다.
 * 			- 예) alter table 테이블명 add constraint 제약조건명 check(조건);
 * 
 * 		(5) not null
 * 			- null 데이터를 허용하지 않는다. (중복 데이터는 허용)
 * 			- not null 제약조건은 생성시 modify를 사용한다.
 * 			- 예) alter table 테이블명 modify 컬럼명 constraint 제약조건명 not null;
 * 
 * 	제약조건의 삭제
 * 		# 기본 형태
 *	 		- 예) alter table 테이블명 drop constraint 제약조건명
 * 
 * 		(1) primary key
 * 			- 삭제되는 경우, unique index가 함께 삭제된다.
 * 			- 예) alter table 테이블명 drop primary key;
 * 
 * 		(2) foreign key
 * 			- cascade는 foreign key와 상관없이 제약조건을 삭제하는 명령어이다.
 * 			- 예) alter table 테이블명 drop constraint 제약조건명 cascde;
 * 
 * 	[참고] null 및 중복 값 허용 여부 
 * 		- primary key 	: null(X), 중복(X)
 * 		- foreign key 	: null(o), 중복(o)
 * 		- unique 		: null(o), 중복(x)
 * 		- check 		: null(o), 중복(o)
 * 		- not null 		: null(x), 중복(o)
 * 
 * 
 * 	레벨
 * 		- 테이블 생성 시, 제약조건을 함께 생성하는 문법
 * 		- not null 제약조건은 column level 방식으로만 생성 가능하다.
 * 		- primary key를 두가지의 컬럼으로 구성하는 경우, table level 문법으로만 가능하다.
 *
 * 
 * 		- 예) 기본 형태
 * 			create table 테이블명
 *			(
 *			   col1 타입(자리수),
 *			   col2 타입(자리수) constraint 제약조건 명칭 제약조건 타입,
 *			   constraint 제약조건 명칭 primary key (col1, col3)
 *			);
 *  
 * 		- 예) 외래키 생성
 * 			create table 테이블명
 *			(
 *			   col1 타입(자리수),
 *			   col2 타입(자리수)
 * 			   constraint 제약조건명 제약조건 타입,
 *   		   constraint 제약조건명 foreign key(참조 컬럼)
 *  		   references 테이블명(참조 대상)
 *			);
 * 
 * 		- 예) 다중 제약조건 레벨 생성
 * 			create table 테이블명
 *			(
 *			   col1 타입(자리수),
 *  		   col2 타입(자리수)
 *  		   constraint 제약조건명 제약조건 타입,
 * 			   constraint 제약조건명 제약조건 타입
 * 			   constraint 제약조건명 제약조건 타입
 *			);
 *
 */