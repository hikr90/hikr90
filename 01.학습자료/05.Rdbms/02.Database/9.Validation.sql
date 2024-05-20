/* 데이터 검증 
 * 	- 데이터 내 제약조건에 위반되는 데이터가 존재하는지 검증하는 작업
 * 	
 * 	# 관련 용어
 * 		(1) disable
 * 			- 제약조건 비활성화 (default:disable no validate)
 * 			- 비활성화 상태에서는 제약조건에 위배되는 값도 입력 가능
 * 
 * 		(2) enable
 * 			- 제약조건 활성화 (default:enable validate)
 * 
 * 		(3) validate
 * 			- 기존 데이터 검증
 * 
 * 		(4) novalidate
 * 			- 기존 데이터 검증 x
 * 	
 * 
 * 	# 검증
 * 		(1) enable validate
 * 			- 기존 데이터 검증 & 제약조건 활성화 (새로운 데이터 검증)
 * 			- 예) alter table 테이블명 enable validate constraint 제약조건명;
 * 
 * 		(2) enable novalidate
 * 			- 기존 데이터 검증 x & 제약조건 활성화 (새로운 데이터 검증)
 * 			- 예) alter table 테이블명 enable novalidate constraint 제약조건명;
 * 
 * 		(3) disable validate
 * 			- 기존 데이터 검증 & 제약조건 비활성화 (새로운 데이터 검증 x)
 * 			- 예) alter table 테이블명 disable novalidate constraint 제약조건명;
 * 
 * 		(4) disable novalidate
 * 			- 기존 데이터 검증 x & 제약조건 비활성화 (새로운 데이터 검증 x)
 * 			- 예) alter table 테이블명 disable novalidate constraint 제약조건명;
 */