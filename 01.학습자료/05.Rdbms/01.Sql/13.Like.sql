/* Like 
 * 	- 특정한 문자 패턴을 찾는 함수
 * 	- 컬럼은 문자 타입의 데이터만 가능하며 문자타입의 컬럼이 아닌 경우 to_char로 암시적 변환이 된다.
 * 	- 몇몇 특수문자를 사용하여 패턴의 추가가 가능하며 해당 특수문자는 연산자 내에서 하나의 기능으로서 인식된다.
 * 
 * 	# 특수문자
 * 		(1) %문자
 * 			- 0개 이상의 패턴을 찾는다.
 * 			- 예) where last_name like 'K%' (last_name이 K로 시작하는 값 검색)
 * 			
 * 		(2) _문자
 * 			- 1개의 패턴을 찾는다.
 * 			- 예) where last_name like 'L__' (첫글자가 L이면서 뒤에 두 글자가 붙는 값 검색)
 * 			
 * 		(3) %문자와 _ 동시 사용
 * 			- 두 패턴을 혼용하여 사용한다.
 * 			- 예) where last_name like '_K%' (last_name중 두번째 글자가 K인 값 검색)
 */
select * from employees where last_name like '_a%';


/* Like와 스캔 방식 
 *	(1) like 'K%' 
 *		- like 연산자 내에서 %를 사용하는 경우, range scan방식으로 색인에서 해당 데이터를 전부 수집한다.
 * 		- K로 시작하는 색인에서 단번에 찾아내므로 속도가 빠르다.		
 * 
 * 	(2) like '_i%'
 * 		- 앞에 임의의 단어가 있으므로 첫단어를 알 수 없기에 full scan 방식으로 모든 값을 찾아본다.
 * 		- 모든 데이터에서 값을 찾아내므로 속도가 느리다.
 */
select * from employees where last_name like 'L__';


/* 날짜형과 Like연산자 
 * 	- Date형에서도 사용할 수는 있으나 컬럼에 암시적 형변환이 걸리면서 full scan이 되어버린다.
 * 	- 즉, like연산자는 문자 컬럼에서만 취급해야한다.
 * 	
 * 	- 예) 쿼리문 select * from employees where hire_date like '%05';은 
 * 			암시적 형변환을 통해서 select * from employees where to_char(hire_date) like '%05'; 가 되어 full scan이 된다.
 */
select * from employees where hire_date like '%05'


/* Escape 식별자 
 * 	- \ 문자로서 like 연산자에서 '%' 혹은 '_' 표시를 문자로 쓰고싶은 경우 사용한다.
 * 	- \ 뒤에 있는 특수문자를 문자 그대로 인식하게한다.
 */
select * from employees where job_id like 'SA\_%' ESCAPE '\';