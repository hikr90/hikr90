/* Trim
 * 	- 접두, 접미의 문자를 자르는 함수
 * 	- Trim은 기준 값이 연속으로 있어도 포함해서 제거한다. (A를 자르는 상황에서 원본 데이터가 AABC인 경우 AA를 삭제한 BC로 처리)
 * 	- 양측에서 자르므로 중간에 있는 기준문자는 삭제할 수 없다. (A를 자르는 상황에서 원본데이터가 AABACA인경우 양측의 A가 제거된 BAC만 남게 된다.)
 */

-- (1) trim 방식
select
   trim(last_name)
from employees;

-- (2) a from trim 방식
select
   trim('A' from last_name)
from employees;


-- ltrim : 접두 (좌측)의 문자를 자르는 함수
-- rtrim : 접미 (우측)의 문자를 자르는 함수
select
   rtrim(last_name),
   ltrim(last_name)
from employees;