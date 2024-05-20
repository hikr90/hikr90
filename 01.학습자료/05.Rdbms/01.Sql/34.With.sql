/* With절 
 * 	- 인라인 뷰의 제약을 보완하기위한 가상 테이블
 * 	- 복합 쿼리문안에서 같은 셀렉트문을 두번 이상 반복할 경우에 성능적으로 사용이 용이하다.
 * 	- with절의 작성 영역인 쿼리 블록의 수는 원하는 만큼 사용이 가능하다.
 * 	- 쿼리 블록 간에는 반드시 콤마로 구분이 되어야한다.
 * 
 * 	[참고] 작성 순서
 * 		(1) 부서별 급여를 dept_avg라는 가상 테이블로 저장
 * 		(2) 전체 부서의 평균값 (전체 부서의 급여의 합 / 부서의 수) 데이터 avg_cost라는 가상 테이블에 저장
 * 		(3) 다중 with문을 생성하여 (1)과 (2)를 연결한 뒤 마지막 셀렉트문에서 dept_cost와 avg_cost의 급여 비교
 */

-- 예) 부서 급여가 전체 부서 평균 연봉보다 많은 부서
with dept_cost as
(
   select
   		sum(salary) as sal, department_name
   from employees e, departments d
   where e.department_id = d.department_id(+)
   group by department_name
), avg_cost as (
 select sum(sal)/count(department_name) as dept_avg from dept_cost
)
select * from dept_cost where sal > (select dept_avg from avg_cost);

