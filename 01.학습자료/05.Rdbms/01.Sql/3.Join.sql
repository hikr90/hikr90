/* Join 
 * 	- 테이블 간 서로 같은 조건의 값을 맵핑하여 조회하는 셀렉트문의 기능
 * 	- 데이터의 관리와 유지보수 효율을 높이는데 목적
 * 
 * 		카다시안의 곱
 * 			- 조인의 조건이 생략되었거나 조건 절을 잘못 묶은 경우 발생한다.
 * 			- 카다시안의 곱이 발생하면 경우의 수처럼 테이블에 존재하는 모든 행 갯수를 곱한만큼의 결과 값이 반환된다.
 * 			- 특히 카다시안의 곱은 시스템 상의 오류가 아니므로 파악이 쉽지 않다.
 * 			
 * 			- 조인 관계에서 on절의 조건이 없다면 카다시안의 곱이 발생한다.
 * 			- 문법상으로는 전혀 문제없는 쿼리문이지만 하나의 부서당 사원 전체 목록이 경우의 수처럼 연산되어 나온다.
 * 			- 예) select e.employee_id, d.department_name from employees e, departments d;
 * 
 * 		조인의 속도
 * 			(1) outer join 위치
 * 				- 아우터 조인이 이너 조인 사이에 존재하는 경우 속도의 문제가 발생한다.
 * 				- 일반적으로는 아우터 조인은 이너 조인 작업이 완료된 뒤 가장 마지막에 나오는 것이 좋다.
 * 
 * 			(2) on절의 컬럼 위치
 * 				- on절은 메인 테이블이 먼저 나오는 것이 속도 측면에서 좋다.
 */

/* (1) equi join
 * 	- 등가조인, inner join, simple join이라고도 한다.
 * 	- 가장 기본적인 형태의 조인으로, 조건절에 부합하는 데이터를 맵핑하여 조회한다.
 * 	- 조건에 해당하지 않으면 가져오지 않는다.
 */
select * from employees e, departments d where e.department_id = d.department_id;

/* (2) outer join
 * 	- 등가조인의 제약을 피하기위한 용도의 null값인 데이터도 조회할 수 있도록 하는 비등가 조인
 * 	- 키 값(조건)이 일치하지 않아도 데이터를 뽑아낸다.
 * 	- equi join이 양측의 교집합을 조회한다면,  outer join은 원하는 측의 null값을 포함한 데이터를 조회한다.
 * 
 * 	[참고] (+)가 없는 쪽의 데이터는 null 여부 상관없이 조회하며, (+)가 양쪽에 있으면 오류가 난다.
 */
select
   e.last_name,
   d.department_id,
   d.department_name,
   l.city
from employees e, departments d, locations l
where e.department_id = d.department_id(+)
	and d.location_id = l.location_id(+);
   
/* (3) self join
 * 	- 하나의 테이블로 조인을 걸어야하는 경우 사용한다.
 * 	- 아래의 쿼리문은 self join을 통해서 직원과 관리자 관계를 나타내는 쿼리문이다.
 */
select
   m.employee_id as m_employee_id,
   m.last_name as m_last_name,
   w.employee_id as w_employee_id,
   w.last_name as w_last_name
from employees m, employees w
where m.manager_id = w.employee_id;

/* (4) non equi join
 * 	- 키 값에서 = 가 아닌 다른 연산자를 이용해서 조인할 때 사용한다.
 * 	- between이 보편적으로 사용된다.
 * 
 * 		select
 *		   e.employee_id,
 *		   e.salary,
 *		   j.grade_level
 *		from employees e, job_grades j
 *		where e.salary
 * 			between j.lowest_sal and j.highest_sal;
 */


/* ANSI 표준 방식
 *	- American National Standards Institue
 *	- 여러 dbms에서 같은 형식의 조인문을 사용하도록 미국표준협회에서 지정한 방식
 *	- 기존의 키 값이 연산자가 아닌 on절로 처리되도록 변경되었다. 
 */

-- (1) equi join
select
   *
from employees e join departments d
on e.department_id = d.department_id;

/* (2) natural join 
 * 	- 양측에 같은 컬럼이 존재한다는 가정하에 where절이 없어도 동일한 컬럼을 찾아서 조인을 수행한다.
 * 	- 동일한 컬럼이 다수인 경우, 모든 컬럼이 정보가 조인되는 카다시안 곱이 발생할 수 있다.
 */
select
   department_name,
   city
from departments natural join locations;

/* (3) join using 
 * 	- 내츄럴 조인에서 키 값이 되는 컬럼을 따로 지정해주는 방식
 * 	- 문법 상 별칭을 사용할 수 없다. 
 */
select
   employee_id,
   department_name
from employees e join departments d
using(department_id);

/* (4) outer join
 * 	- (+)와 다르게 ANSI 방식에서는 원하는 측에따라서 left, right를 사용해야한다.
 * 	- left, right, full로 구분한다.
 * 
 * 	종류
 * 		(1) left outer join  : 키값이 일치되는 데이터 뿌리고 왼쪽 데이터 출력
 * 		(2) right outer join : 키값이 일치되는 데이터 뿌리고 오른쪽 데이터 출력
 * 		(3) full outer join	 : 양측의 모든 데이터를 출력
 */
select
   *
from employees e left outer join departments d
on e.department_id = d.department_id;

/* 조인의 순서
 * 	- on절의 내용은 where절보다 먼저 처리된다.
 * 	- on과 where의 차이는 등가 조인에서는 차이가 없으나 비등가 조인에서는 범위가 달라진다는 차이가 있다.
 * 	- 순서) from - on - join - where
 * 
 *  	(1) where 문장은 outer join으로 가져온 뒤 where조건으로 조건에 들어맞는 행만 가져오므로 사실상 equi join과 같다.
 * 		(2) 성능적인 측면에서는 on조건 한번으로 목록을 가져오는 방법이 더 뛰어나다.
 */

/* (1) where
 * 	- Join이 먼저 동작하여 null값까지 가져온 뒤, where절이 동작하여 행을 제어한다.
 * 	- Join의 처리 후 where절까지 두번의 동작이 있으므로 성능적으로는 (2)보다 떨어진다.
 */
select 
   *
from departments d
left outer join employees e on d.department_id = e.department_id
where e.salary >= 10000;

/* (2) on
 * 	- on 절만 동작하여 Salary가 1000이상인, null값을 포함한 목록을 가져온다.
 */
select 
   *
from departments d left outer join employees e
on d.department_id = e.department_id and e.salary >= 10000;
