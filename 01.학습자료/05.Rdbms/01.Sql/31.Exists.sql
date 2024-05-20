/* Exists 
 * 	- 서브 쿼리의 컬럼에 해당하는 집합행이 있는지 검색하는 경우 사용하는 연산자
 * 	- 후보행의 데이터가 서브쿼리에 존재하면 true값을 반환하며 검색 종료
 * 	- 후보행의 데이터가 서브쿼리에 존재하지 않는 경우, false값을 반환하며 검색 종료
 *	- in과 비슷한 의미를 가지지만, exists앞과 뒤에는 컬럼을 사용하지 않는다. 
 *	- 단, 서브쿼리의 문법상 셀렉트문의 컬럼 위치에 아무 내용이 없는 경우 오류가 발생하므로 특정 의미가 없는 'x'를 사용한다. 
 *
 *	# 동작 순서
 *		(1) 메인 쿼리를 먼저 수행하여, 후보 데이터를 잡은 뒤 그 값이 서브 쿼리에 있는지 확인
 *		(2) 있는 경우, true값으로 해당 데이터(행)를 뽑아낸다.
 *		(3) 없는 경우, 다음 후보 데이터(행)를 잡아서 위의 순서를 반복
 */

-- 예) 관리자인 직원의 정보
select e.* from employees e where exists (select 'x' from employees where manager_id = e.employee_id);


/* Not Exists 
 * 	- exists의 반대로 후보행의 값이 아닌 데이터를 뽑아낸다.
 * 	- not in의 대용으로서 많이 사용한다.
 * 	- 값이 있는가, 없는가의 판단 방식은 같다.
 */

-- 예) 관리자가 아닌 직원의 정보
select e.* from employees e where not exists (select 'x' from employees where manager_id = e.employee_id);

