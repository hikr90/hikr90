/* Rowid
 *	- 데이터베이스 내 데이터 데이터 공유의 주소로서, 이 값을 이용하여 데이터에 접근할 수 있다.
 *	- 데이터베이스에서 각 데이터의 고유한 주소를 의미한다.
 *	- 총 18자리 (10byte)의 구조로 생성된다. 
 * 
 */
select employee_id, rowid, last_name from employees;

/* Rowid의 구조 
 *		[AAAEAb][AAE][AAAADN][AAA] 
 *		  (1)    (2)   (3)    (4)
 * 		- 위 Rowid는 employee_id 100번의 주소를 뜻한다.
 * 		- Rowid를 확인할 수 있다는 것은 해당 데이터에 접근할 수 있음을 뜻한다.
 * 
 * 		(1) Object Number
 * 			- 해당 데이터가 속하는 번호값, 오브젝트마다 고유값을 가지고있다.
 * 
 * 		(2) Data File Number 
 * 			- 오라클의 테이블 스페이스는 여러개의 데이터파일을 생성할 수 있다.
 * 			- 오라클 8i부터는 테이블 스페이스당 1023개의 데이터파일을 추가할 수 있다.
 * 			- 데이터 파일은 해당 테이블 스페이스의 상대 파일 번호를 뜻하며 각 데이터마다 고유 값을 가진다.
 * 
 * 		(3) Block Number
 * 			- 파일 블록 번호이며, 책 메커니즘에서 문자가 페이지 내에 있는 것으로 비유할 수 있다.
 * 
 * 		(4) Slot Number
 * 			- 블록의 헤더 부분에서 해당 데이터의 위치값을 저장하는 DATA DIRECTORY SLOT을 뜻한다.
 */

-- Rowid Scan : Rowid를 통해서 값을 찾는 방식으로 스캔 방식 중 속도가 가장 빠르다.
select * from employees where rowid = 'AAAEAbAAEAAAADNAAA';