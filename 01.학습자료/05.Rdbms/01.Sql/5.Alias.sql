/* Alias
 * 	- 테이블 혹은 컬럼에 붙이는 약어를 뜻한다.
 * 	- as 명칭의 방식으로 별칭 표현이 가능하다.
 * 	- 지정하는 명칭에 공백문자, 대소문자 구분, #, _, $ 등의 특수문자를 사용하는 경우 쌍따음표로 감싸야한다.
 * 	- where절 뒤에는 별칭 사용이 불가능하다.
 */
select salary * 12 "ANN_SAL", employee_id as "ID#" from employees;