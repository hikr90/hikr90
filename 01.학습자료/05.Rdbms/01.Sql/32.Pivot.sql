/* Pivot 
 * 	- 행 데이터를 컬럼으로 변경하는 함수
 * 	- 피벗 문장에서는 반드시 그룹함수가 존재해야한다.
 */

-- 예) 부서별 인원 출력
select
   *
from (select department_id from employees)
pivot(count(*) for department_id in (10,20,30,40,50,60,70,80,90,100,null));

-- 예) 부서별 연봉 총액
select 
	* 
from (select salary, department_id from employees)
pivot (sum(salary) for department_id in (10,20,30,40,50,60,70,80,90,100,110,null));

-- 예) 연도별 입사 인원
select 
	*
from (select to_char(hire_date,'YYYY') year from employees)
pivot (count(*) for year in (2001,2002,2003,2004,2005,2006,2007,2008,2009));