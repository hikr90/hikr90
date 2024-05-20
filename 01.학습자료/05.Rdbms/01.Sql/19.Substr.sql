/* Substr
 * 	- 찾고자하는 문자를 확인하는 함수
 * 	- instr처럼 -1로 맨 뒤부터 검색이 가능하다.
 */
select
   last_name,
   substr(last_name,1,3)
from employees;


/* Substrb
 * 	- 문자를 byte 단위로 확인하는 함수
 * 	- substrb(찾고자하는 데이터, 검색 시작 위치, 검색할 용량 byte용량)
 */
select
   substrb('AAABC', 0, 3)
from dual;

