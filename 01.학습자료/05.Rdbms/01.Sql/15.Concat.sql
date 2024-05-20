/* Concat 
 * 	- 컬럼과 컬럼을 연결하는 함수
 * 	- 연결 연산자와 같은 역할을 한다.
 * 
 * 	# 방식
 * 		(1) concat(컬럼, 컬럼) : 두가지의 컬럼만 사용 가능하다.
 * 		(2) 컬럼 || 컬럼 : 원하는 컬럼을 제한없이 사용할 수 있다.
 */
select
   last_name||' '||first_name,
   concat(last_name, first_name)
from employees;

