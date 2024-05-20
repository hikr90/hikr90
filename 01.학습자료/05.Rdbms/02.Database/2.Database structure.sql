/* 데이터베이스 구조 
 * 	# 데이터베이스 저장 구조
 * 		(1) (논리적) databaes, (물리적) OS (data file)
 * 			- 다수가 사용하기위한 목적으로 설계된 데이터의 저장 공간
 * 
 * 		(2) (논리적) tablespace, (물리적) data file
 * 			- 객체 (Object)를 저장하는 공간으로 파티션의 개념을 가진다.
 * 			- 객체는 테이블, 인덱스, 프로시저, 뷰등을 뜻한다.
 * 			- database에는 여러 tablespace가 저장된다.
 * 			- tablespace는 1:다수의 관계로 여러 data file로 구성된다.
 * 
 * 			(2.1) data file의 구성
 * 				- OS block으로 구성되어있으며 대부분 8k (block내 8천개의 row가 존재) 이다.
 * 
 * 			(2.2) tablespace의 구성
 * 				- segment, extend, block으로 구성되어있다.
 * 
 * 		(3) (논리적) table (segment) 
 * 			- 테이블, 인덱스, 프로시저, 트리거, 패키지등 저장공간을 가지고있는 객체를 뜻한다.
 * 			- 하나 이상의 extend가 모여 생성된다.
 * 			- 예) 책
 * 
 * 		(4) (논리적) extend OS block (512byte)
 * 			- block이 구성되어있는 형태의 논리적 단위이다.
 * 			- oracle의 최소 I/O단위
 * 			- 예) 책의 목차
 * 
 * 		(5) (논리적) block
 * 			- oracle의 기본 I/O단위 (검색 단위)
 * 			- DB의 모든 데이터는 block으로 구성되어있다.
 * 			- 2,4,8,16,32kb등의 사이즈로 생성된다.
 * 			- 예) 책의 한 페이지
 * 
 * 		(6) (논리적) row
 * 			- 사용자가 눈으로 확인 가능한 데이터의 행
 * 			- 예) 페이지의 내 문장
 * 
 * 	# 물리적 공간
 * 		- users는 샘플 tablespace가 저장되는 곳이다.
 * 		- SYSAUX는 사용자가 잘못 작성한 쿼리문을 저장하는 공간으로, 밤 동안 해당 데이터를 분석하여 사용자에게 조언하는 역할로 사용된다.
 * 		- UNDOTBS1은 특정 쿼리문 동작 시, 그 이전의 데이터를 저장하는 공간으로 워드의 ctrl + z와 같다.
 * 		- system 계정에서 조회한다.
 * 
 * 	# 디스크 작업 위치
 * 		- sql은 정렬등의 대용량 작업을 메모리에서 할 수 없어, 디스크 (temp)로 내려서 작업을 진행하게된다.
 * 		- system 계정에서 조회한다.
 */

-- # 물리적 저장 공간 조회
select * from dba_data_files;

-- # 디스크 작업 위치 조회
select * from dba_temp_files;