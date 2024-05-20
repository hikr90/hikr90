/* Inline View 
 * 	- 행의 수만큼 반복해서 동작하는 상호관련 서브쿼리를 보완하기위한 용도의 가상 테이블
 * 	- 셀렉트문의 from절 안에 셀렉트문를 생성하는 방식으로 동작한다.
 * 	- where절에서 함수가 동작하는 경우를 방지하기위해서 인라인뷰에서 그룹 함수를 사용하는 경우, 반드시 명칭이 있어야한다.
 * 	- 인라인 뷰에서는 원래의 인라인 뷰 밖의 셀렉트문과 비교할 수 있는 데이터가 있어야한다.
 * 
 */

-- 예) 부서별 평균 급여
-- (1) 자신의 부서 평균 급여보다 더 많은 사원 조회
select department_id, avg(salary) as sal from employees group by department_id;

-- (2) 1번 쿼리와 인라인 뷰 병합
select emp2.* from (
     select department_id, avg(salary) as SAL from employees group by department_id
) emp1, employees emp2
where emp1.department_id = emp2.department_id
and emp1.sal > emp2.salary;