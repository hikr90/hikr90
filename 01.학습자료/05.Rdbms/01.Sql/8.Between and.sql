/* Between And 
 * 	- 조건이 다수이거나 특정 범위안에 있는 값을 찾고자하는 함수
 */

-- (1) and 방식
select
   salary
from employees
where salary >= 2500 and salary <= 3000;

-- (2) between and 방식
select
   salary
from employees
where salary BETWEEN 2500 and 3000;