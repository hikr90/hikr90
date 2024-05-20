/* 계층형 쿼리 
 * 	- 데이터를 계층형 형태로 변형시켜 이를 조회하는 방식의 쿼리 형태이다.
 * 	- level, order siblings by를 같이 사용한다.
 * 	- 테이블 내의 서로 다른 컬럼이 상위와 하위 구조로 연결되어있는 경우 같이 사용할 수 있다.
 * 
 * 	[참고] 계층형 쿼리 기능 설명
 * 		(1) start with는 최상위 컬럼을 의미한다.
 * 		(2) connect by는 하위 컬럼과 상위 컬럼이 연결되는 조건을 의미한다.
 * 		(3) prior는 전단계라는 뜻으로 컬럼의 앞, 뒤 어디에 위치하냐에따라 탑다운, 버튼업의 동작을 수행한다.
 * 		(4) order siblings by는 계층 쿼리 데이터 내의 정렬을 지정한다.
 */

/* (1) 탑다운 
 *	(1.1) 사원번호가 100인 King의 정보를 찾는다.
 * 	(1.2) connect by의 조건을 계속해서 찾는다. (내 관리자 번호가 사원번호인 = 내 상관인 사람) 상관이 King인 직원의 정보를 조회한다.
 * 	(1.3) Kochhar외에 다른 사람이 없으므로 Kochhar를 상관으로 삼는 직원의 정보를 조회한다.
 * 	(1.4) Greenberg 부터 Popp까지의 항목을 조회한 뒤 더이상 조건에 맞는 데이터가 없다면 Greenberg가 상관인 직원의 정보를 조회한다.
 * 	(1.5) 위의 작업을 데이터 끝까지 계속해서 반복한다.
 */
select employee_id, last_name, manager_id from employees
start with employee_id = 100
connect by prior employee_id = manager_id;


/* (2) 버튼업 
 * 	(2.1) 사원번호가 108인 Greenberg의 정보를 찾는다.
 * 	(2.2) Greenberg의 관리자 번호인 101번에 해당하는 직원 Kochhar의 정보를 조회한다.
 * 	(2.3) Kochhar의 관리자 번호인 100번에 해당하는 직원 King을 조회한다.
 * 	(2.4) 위 작업을 상위 데이터가 존재하는 한 계속해서 반복한다.
 */
select employee_id, last_name, manager_id from employees
connect by employee_id = prior manager_id;
start with employee_id = 108

/* Level 
 * 	- 번호가 매겨지는 가상의 컬럼
 * 	- 계층형 쿼리 사용 시, 어떤 단계에서 가져오는 정보인지 분간할 수 없을 때 가상 컬럼인 level을 사용하여 분간할 수 있다.
 * 	- start with 없이 level 함수를 사용할 수 없다.
 */

-- 예) level로 값의 수치에따라서 lpad로 들여쓰기 출력
select level, lpad(' ', 2*level-2, ' ') || last_name from employees
start with employee_id = 100
connect by prior employee_id = manager_id;

-- 예) 숫자 1 ~ 100 확인
select level from dual connect by level < 100;


/* order siblings by
 * 	- 계층 단계 내에 있는 데이터를 정렬하는 기능
 * 	- order와 마찬가지로 셀렉트문 맨 뒤에 위치한다.
 * 	- 특정 행을 제외하는 방식으로도 많이 사용된다.
 */

-- 예) level값을 last_name으로 정렬
select level, lpad(' ', 2*level-2, ' ') || last_name from employees
start with employee_id = 100
connect by prior employee_id = manager_id
order siblings by last_name;

-- 예) 특정 행에 제한을 거는 방법 (100번 사원 제외)
select level, lpad(' ', 2*level-2, ' ') || last_name as emp_nm, employee_id from employees
start with employee_id != 100
connect by prior employee_id = manager_id
order siblings by employee_id;

