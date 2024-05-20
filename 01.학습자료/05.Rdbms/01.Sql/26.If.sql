/* 조건문 
 * 	- sql에서는 if문이 따로 없다.
 * 	- 이를 대체하는 용도로 decode함수와 case 표현식이 존재한다.
 * 
 * 	(1) decode
 * 		- 내부적으로 ~와 같다의 표현만 가능하다.
 * 		- 조건은 계속해서 추가할 수 있다.
 * 
 * 	(2) case
 * 		- case문 안에서는 , 를 사용하지 않는다.
 * 		- else는 if문의 else와 같으며 case문은 end로 완료한다.
 * 		- when문안에 조건은 in, > 등의 연산자나 함수 사용이 가능하다.
 */

-- (1) decode
select
   employee_id,
   job_id,
   salary,
   decode(job_id, 'IT_PROG', salary*1.1,
    'ST_CLERK', salary*1.2, 'SA_REP', salary*1.3)
    decode_sal
from employees;

-- (2) case
-- (2.1) case 컬럼 when 방식
select
   employee_id,
   job_id,
   salary,
   case job_id
   when 'IT_PROG' then salary * 1.1
   when 'ST_CLERK' then salary * 1.2
   when 'SA_RPE' then salary * 1.3
   else salary end as case_sal
from employees;

-- (2.2) case when 컬럼 방식
select
   employee_id,
   job_id,
   salary, case
   when job_id = 'IT_PROG' then salary * 1.1
   when employee_id = 100 then salary * 1.2
   when salary >= '10000' then salary * 1.3
else salary end as case_sal
from employees;