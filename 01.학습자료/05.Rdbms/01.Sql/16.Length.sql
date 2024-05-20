/* Length, Lengthb
 * 	(1) length
 * 		- 문자의 길이를 숫자 값으로 변환하는 함수
 * 
 * 	(2) lengthb
 * 		- 문자를 byte값으로 변환하는 함수
 * 		- 영어는 1byte, 한글은 3byte이다.
 */

-- (1) length
select
   last_name,
   length(last_name)
from employees;

-- (2) lengthgb
select
   lengthb('가나다라')
from dual;