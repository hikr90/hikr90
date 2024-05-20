/* Date 함수 
 * 	- 날짜의 표기법은 국가(지역)에 따라서 포맷에 차이가 있다.
 * 	- 한국에서 프로그램 구동 시 yyyy-mm-dd로 표현된다.
 * 		
 * 		# 날짜 데이터의 변환
 * 			(1) 암시적 변환
 * 				- where절의 컬럼과 값의 데이터 타입이 같지 않은 경우, 오라클에서 암시적으로 형태를 변환시켜주는 방식이다.
 * 				- 국가에따라서 포맷이 다르므로 날짜 데이터의 변환이 안되는 경우가 있다.
 * 			
 * 				(1.1) 암시적 변환 전
 * 					select hire_date from employees where hire_date = '2003-06-17';
 * 															Date		  Char
 * 
 * 				(1.2) 암시적 변환 후
 * 					select hire_date from employees where hire_date = to_date('2003-06-17');
 *															Date		  Date 
 * 
 * 			(2) 명시적 변환
 * 				(2.1) to_date
 * 				- 문자열을 날짜 타입으로 변환시키는 함수
 */

-- (2.1) to_date
select
   *
from employees
where hire_date = to_date('20010113','YYYY-MM-DD');


/* # Sysdate 
 * 	- 오라클 서버의 시간 표현
 * 	- dual은 가상의 테이블을 뜻한다.
 */
select sysdate from dual;


/* # 날짜의 계산
 * 	(1) 날짜 + 숫자 : 날짜
 * 	(2) 날짜 - 숫자 : 날짜
 * 	(3) 날짜 - 날짜 : 숫자 (일수)
 * 	(4) 날짜 + 시간 : 날짜
 * 	(5) 날짜 - 시간 : 날짜
 * 	(6) 날짜 + 날짜 : 오류
 */

-- (1) 날짜 + 숫자, (2) 날짜 - 숫자
select
   sysdate + 100,
   sysdate - 100
from dual;

-- (2) 날짜 - 날짜
select
   to_date('2020-05-09','YYYY-MM-DD') - to_date('2020-05-01','YYYY-MM-DD')
from dual;

-- (3) 날짜 + 시간, (4) 날짜 - 시간
select
   sysdate+10/24
from dual;

/* # 날짜와 시간의 계산 
 * 	(1) Date 방식
 * 		- 숫자만큼 일의 수가 더해지는 방식
 * 		- 일수를 시간으로 환산하기위해서는 하루의 시간을 환산한 10/24로 표현한다.
 * 			
 * 	(2) Char 방식
 * 		- 문자 방식인 to_char를 사용한다.
 * 
 * # 날짜와 분의 계산
 * 	(3) Date 방식
 *		- 24시간에서 60를 곱하여 분 처리한다.
 * 
 * 	(4) Char 방식
 * 		- 만약 시분초까지 표현하고자한다면 Char형으로 작성하는 것이 더 쉽다.
 */

-- (1) 날짜와 시간의 계산 (Date)
select
   sysdate+10/24
from dual;

-- (2) 날짜와 시간의 계산 (Char)
select
   to_char(sysdate+10/24,
   'YYYY-MM-DD HH24:MI:SS')
from dual;

-- (3) 날짜와 분의 계산 (Date)
select
   sysdate+10/(24*60)
from dual;

-- (4) 날짜와 분의 계산 (Char)
select
   to_char(sysdate+10/(24*60),
   'YYYY-MM-DD HH24:MI:SS')
from dual;


/* 날짜 함수 */
-- (1) months_between : 두 날짜간의 달의 수를 반환하는 함수
select
   months_between(sysdate,hire_date)
from employees;

-- (2) add_months : 두 날짜간의 달수를 더하거나 빼는 함수
select
  add_months(sysdate, 6),
  add_months(sysdate, -6)
from dual;

-- (3) next_day : 입력한 날짜를 기준으로 찾고자하는 요일의 첫번째 일자를 반환하는 함수 (''은 문자열로 암시적 변환이 존재)
select
   next_day(sysdate,'월요일')
from dual;

-- (4) last_day : 입력한 날짜를 기준으로 해당 달의 마지막 날짜를 반환하는 함수
select
   last_day(sysdate)
from dual;

/* (5) round 
 * 	- 날짜를 반올림하여 다음달 1일로 나타내는 함수
 * 	- 문자형과 날짜형 데이터에 사용이 가능하다.
 * 	- month를 기준으로 하는 경우 16일을 기준으로 year는 7월을 기준으로 반올림한다.
 */
-- (5.1) month
select
   round(to_date('2020-05-16','YYYY-MM-DD'),'month')
from dual;

-- (5.2) year
select
   round(to_date('2020-07-16','YYYY-MM-DD'),'year')
from dual;

-- (6) trunc : 월 상관없이 1월 1일로 반환하는 함수
select
   trunc(to_date('2020-05-10','YYYY-MM-DD'),'year')
from dual;

/* (7) to_yminterval 
 * 	- 문자를 날짜로 표현해주는 함수로, 날짜 + 날짜 계산을 가능하게 한다.
 * 	- 연도없이 월만 추가하는 경우 00-05등의 방식을 사용한다.
 * 	- 단 00-12는 사용이 안된다. 12개월은 1년과 같으므로 to_yminterval 11개월까지만 사용이 가능하다.
 */
select
   sysdate + to_yminterval('10-02')
from dual;

/* (8) to_dsinterval 
 * 	- to_yminterval와 같으나 시분초만 계산하는 경우에 사용한다.
 * 	- day는 구분자를 사용하지 않는다. 시간은 23시까지, 분과 초는 59까지만 적을 수 있다.
 */
select
   sysdate + to_dsinterval('10 10:59:10')
from dual;

-- (9) to_timestamp : 시분초 표현식
select
   TO_TIMESTAMP('2020-05-10 16:49:31.04239', 'YYYY-MM-DD HH24:MI:SS.FF')
from dual;

-- (10) to_timestamp_tz : 개발자가 정한 시간을 timestamp with zone형식으로 확인 (시분초 표현식에서는 tzh와 tzm으로 표현한다.)
select
   TO_TIMESTAMP_TZ('2020-05-10 16:49:31.04239 +09:00', 'YYYY-MM-DD HH24:MI:SS.FF TZH:TZM')
from dual;


/* Date의 정렬
 * 	- order by는 정렬 시 한글 명칭인 금요일부터 정렬된다.
 * 	- 요일의 숫자값 1부터 7까지 숫자로 나타내는 'd' 기준으로 정렬하면 월요일부터 정렬할 수 있다.
 */

-- (1) 금요일부터 정렬
select
   employee_id,
   to_char(hire_date,'day')
from employees
order by 2;

-- (2) 일요일부터 정렬
select
   employee_id,
   to_char(hire_date,'day')
from employees
order by to_char(hire_date,'D');

-- (3) 월요일부터 정렬
select
   employee_id,
   to_char(hire_date,'day')
from employees
order by to_char(hire_date-1,'d');


/* Date형의 문자 표현 방식
 * 	- 문자로 표현하는 방식으로 to_char 함수를 사용한다.
 * 
 * 	# 연도		
 *		(1) yyyy : 2020
 * 		(2) year : twenty twenty
 * 	
 * 	# 월
 * 		(1) month : 5월
 * 		(2) mon : 5월
 * 		(3) mm : 05
 * 
 * 	# 일
 * 		(1) ddd : 올해부터의 일수
 * 		(2) dd : 이번달부터의 일수
 * 		(3) d : 요일의 숫자 (일요일 : 1)
 * 		(4) day : 요일
 * 		(5) dy : 요일의 약어
 * 		
 * 	# 분기
 * 		(1) q : 분기
 * 		(2) am / pm : 오전 / 오후
 */
select to_char(sysdate, 'yyyy, year') from dual;


/* 서수 표현 
 *	- rr type은 현재 년도의 세기를 반영하지 않는 식으로 표현하는 포맷 방식이다. 
 *	- yy type은 현재 년도의 세기를 반영하는 식으로 표현하는 포맷 방식이다. (20세기는 1995로 표현)
 *	- yy type이 2095년인 이유는 세기 4자리를 쓰지 않았기 때문이다. 
 */

-- (1) rr type
select to_char(to_date('95-05-27','rr-mm-dd'),'yyyy') from dual;

-- (2) yy type
SELECT TO_CHAR(TO_DATE('95-05-27','yy-mm-dd'),'yyyy') from dual;

