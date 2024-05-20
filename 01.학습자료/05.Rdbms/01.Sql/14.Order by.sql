/* Order by
 * 	- 데이터를 정렬하는 키워드
 * 	- 문자, 숫자, 날짜 모두 사용 가능하다.
 * 	- 정렬하는 컬럼은 실제 컬럼 혹은 실제 컬럼이 사용하는 별칭과 일치해야한다.
 * 	- 기본 값은 오름차순(asc)으로 내림차순(desc)은 따로 기입해야한다.
 */
select
   employee_id,
   last_name,
   salary as sal
from employees
order by sal;

/* order by 와 null
 *	(1) asc
 *		- null 값은 가장 아래로 정렬된다.
 * 
 * 	(2) desc 
 * 		- null 값은 가장 위로 정렬된다.
 */
select employee_id, last_name, commission_pct * 12 as comm_pct from employees order by comm_pct desc;


/* order by 숫자 표현
 *	- 셀렉트 문장에서 컬럼의 위치를 숫자로 표현할 수 있다.
 * 	- 컬럼 좌측부터 1번으로 시작한다.
 */
select
   employee_id,
   last_name,
   salary * 12 as sal
from employees
order by 3 desc;


/* order by 다중 정렬 
 * 	- order by 뒤에 하나 이상의 컬럼을 추가하여 정렬 시 두가지 이상의 조건을 걸 수 있다.
 * 	- 첫번째 조건의 상황에서 같은 값이 있는 경우 두번째 컬럼을 기준으로 정렬한다.
 */
select
   department_id,
   salary,
   last_name
from employees
order by 1 asc, 2 desc;


/* order by 조건 정렬 
 *	- 컬럼의 특정 값을 기준으로 정렬의 우선순위를 잡을 수 있다.
 */
-- (1) decode
select
   *
from employees
order by decode(job_id,'IT_PROG', 1, 'FI_ACCOUNT', 2), salary desc;

-- (2) case when
select 
   *
from employees order by 
case job_id when 'IT_PROG' then 1
	when 'FI_ACCOUNT' then 2
    else 3 end, salary desc;