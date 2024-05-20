/* 그룹 함수 
 * 	- 여러 행 당 하나의 결과를 반환하는 함수
 * 	- 행의 집합을 생성하는 함수
 */

-- (1) max, min : 최고 값과 최소 값을 뜻한다. 숫자, 문자, 날짜등 데이터의 형에 영향받지 않는다.
select
     max(salary), min(salary),
     max(hire_date), min(hire_date),
     max(last_name), min(last_name)
from employees;

-- (2) count : 행의 수를 구하는 함수, *를 사용할 시 null 데이터를 포함하여 출력하고 *가 아닌 특정 컬럼에 사용하는 경우 null 데이터는 포함되지 않는다.
select count(*) from employees where department_id = 50;
select count(commission_pct) from employees where department_id = 50;

-- (3) sum : 특정 값의 합
select round(sum(salary) / count(commission_pct),2) COMM_SAL from employees; 

-- (4) avg : 특정 값의 평균
select round(avg(salary),2) avg_sal from employees;

-- (5) medium : 중앙값
select median(salary) from employees;

-- (6) variance : 분산 (편차^2 합의 평균)
select round(variance(salary),2) VAR_SAL from employees;

-- (7) stddev : 표준편차 (편차는 각 관측값과 평균값의 차이를 뜻한다.)
select stddev(salary) from employees;