/* Instr
 * 	- 값 중, 해당 문자가 처음으로 나오는 위치를 반환하는 함수
 * 	- 대소문자를 구분하며 존재하지 않는 경우 0으로 반환한다.
 * 	- instr(데이터, 찾고자하는 값, 검색 시작 위치, n번째로 나오는 숫자)로 사용한다.
 * 	- 검색 위치 -1은 데이터의 맨 뒤 숫자를 뜻한다.
 */
select
   last_name,
   instr(last_name,'A')
from employees;


-- 예시
select
   instr('AABBCCDAA','A',-1,1)
from dual;

