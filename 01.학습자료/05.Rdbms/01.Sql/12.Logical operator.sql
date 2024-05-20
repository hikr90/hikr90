/* 논리 연산자 
 * 	- 논리 연산자의 순서는 (1) and (2) or (3) not이다.
 * 		
 * 	(1) and
 * 		- false값이 한가지라도 있는 경우 false값이다.
 * 		- null은 true, false 값 중 어떤 값이 들어올 지 알 수 없는 상태이다.
 * 			
 * 		(1.1) true + true = true
 * 		(1.2) true + false = false
 * 		(1.3) true + null = nul
 * 		(1.4) false + null = false
 * 		(1.5) false + false = false
 * 
 * 	(2) or
 * 		- true값이 한가지라도 있는 경우 true값이다.
 * 
 * 		(2.1) true + true = true
 * 		(2.2) true + false = true
 * 		(2.3) true + null = true (최소 하나 이상의 값이 true이므로)
 * 		(2.4) false + null = null
 * 
 * 		
 * 		# in과 and, or의 관계
 * 			- ()의 값이 존재하는가? 를 뜻하는 in은 or의 의미를 가진다.
 * 			- in (a, b, c)는 a or b or c와 같다.
 *			
 *			- 예1) select * from employees where employee_id in (100, 101, 200);
 *			- 예2) select * from employees where employee_id = 100 or employee_id = 101 or employee_id = 200;
 *
 *			[참고] employee_id의 찾는 값의 범위가 촘촘하다면 (100부터 102까지 값의 텀이 없음) between을 사용하는 것이 성능면에서 더 좋다.
 *
 *		# not in과 and, or의 관계
 *			- ()값이 존재하지 않는가? 를 뜻하는 not in은 and의 의미를 가진다.
 *			- not in (a, b, c)는 a 그리고 b, 그리고 c가 아닌 데이터를 찾으시오와 같다.
 *
 *			- 예1) select * from employees where employee_id not in (100, 101, 200);
 *			- 예2) select * from employees where employee_id != 100 and employee_id != 101 and employee_id != 200;
 *
 *
 *		# in, not in과 null의 관계
 *			(1) in (or)
 * 				(1.1) in(true, true, null) = true
 * 				(1.2) in(false, false, null) = null
 * 				(1.3) in(true, false, null) = true
 * 
 * 			(2) not in (and)
 * 				(2.1) not in(true, true, null) = null
 * 				(2.2) not in(false, false, null) = null
 * 				(2.3) not in(true, false, null) = null
 *
 *			[참고] not in 사용 시 null값이 하나라도 있으면 행의 정보를 보여주지 않으므로 not in 대신 not exists를 사용한다.
 */
-- (1) in(null, true, true, true) = true
select * from employees where employee_id in (null, 100, 101, 102);

-- (2) not in(null, true, true, true) = null
select * from employees where employee_id not in (null, 100, 101, 102); 