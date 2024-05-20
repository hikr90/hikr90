/* 대소문자 
 * 	(1) lower
 * 		- 문자를 소문자로 변환
 * 	
 * 	(2) upper
 * 		- 문자를 대문자로 변환
 * 
 * 	(3) initcap
 * 		- 첫문자는 대문자, 마지막 문자는 소문자로 변환
 */

-- (1) lower
select
   last_name
from employees
where lower(last_name) = 'king';

-- (2) upper
select
   last_name
from employees
where upper(last_name) = 'KING';


-- (3) initcap
select
   last_name
from employees
where initcap(last_name) = 'King';