/* 스칼라 서브 쿼리 
 * 	- 셀렉트문안의 컬럼 요소에 셀렉트문를 넣어서 컬럼 데이터를 넣는 방식
 * 	- 조인없이 조인하는 경우 조인되는 데이터를 확인가능하면서 성능이 뛰어나 많이 사용된다.
 * 	- 단, 한행에서 정확히 하나의 컬럼만 반환하는 쿼리문으로 다중값의 리턴이 안된다.
 * 	- 스칼라 서브 쿼리는 동작 횟수를 최소화하기위해서, 입력값과 출력값을 캐시영역 (query execution cache)에 저장한다.
 * 	- 다중 리턴 값이 나오는 경우 에러가 발생한다.
 * 
 * 	[참고] 스칼라 서브 쿼리와 조인의 차이
 * 		(1) 스칼라 서브 쿼리
 * 			- 조인하는 데이터를 바로 확인이 가능하다.
 * 			- null 데이터를 포함한다.
 * 
 * 		(2) 등가 조인
 * 			- 조인하는 데이터의 확인이 따로 불가능하다.
 * 			- null 데이터를 포함하지 않는다.
 * 
 * 	예) 동작 순서
 * 		(1) 사원 테이블의 부서번호가 90인 경우
 * 		(2) 부서 테이블에서 부서번호에 해당하는 부서명을 반환한다.
 * 		(3) 반환과 동시에 입력값과 출력값 데이터를 캐시 영역에 저장한다.
 * 		(4) 다음 후보행에서 부서 번호를 검색한다.
 * 		(5) 부서 번호가 같은 경우 부서 테이블을 건드리지 않고 캐시 영역에 저장한 값을 그대로 반환한다.
 * 		(6) 부서 번호가 다른 경우 부서 테이블에 접근하여 입력값과 출력값을 위의 작업과 같이 동일하게 저장하여 사용한다.
 * 
 * 		즉, 직원의 부서의 행의 수만큼만 스칼라 서브 쿼리가 동작하므로 중복값이 많으면 많을수록 더 좋은 성능을 보인다.
 */
select
   e.employee_id,
   e.department_id,
   (select department_name from departments d where d.department_id = e.department_id) as department_name
from employees e;
​

/* 캐시 
 * 	- 반복적으로 사용하는 데이터를 바로바로 사용할 수 있도록 저장하는 임시 저장소를 뜻한다.
 * 	- 셀렉트문에서 바인드 변수에 해당하는 데이터를 기억하여 같은 값이 들어오는 경우 바로 리턴할 수 있도록 한다.
 */
