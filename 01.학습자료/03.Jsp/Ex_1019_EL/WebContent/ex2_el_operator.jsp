<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<!-- EL표기법 연산자
				- EL표기법안에서 연산자를 사용하면 계산이 완료되어서 나온다.
				- 앞에 \을 붙이면 문자형식으로 표현된다.
		-->
	
		<!-- 비교연산자 -->
		EL 산술연산자 <br>
		\${ 1+1 } = ${ 1+1 }<br>
		\${ 4-2 } = ${ 4-2 }<br>
		\${ 5*3 } = ${ 5*3 }<br>
		\${ 10/3 } = ${ 10/3 }<br>
		\${ 10/3 } = ${ 10 div 3 }<br>
		\${ 10%3 } = ${ 10%3 }<br>
		\${ 10%3 } = ${ 10 mod 3 }<br>
		<hr>
		
		<!-- 비교연산자 -->
		EL 비교연산자 <br>
		\${ 3>2 } = ${ 3>2 }<br>
		\${ 3>2 } = ${ 3 gt 2 }<br>
		\${ 3>2 } = ${ 3 gt 2 }<br>
		\${ 3<2 } = ${ 3 lt 2 }<br>
		\${ 3<=2 } = ${ 3 le 2 }<br>
		
		\${ 3==3 } = ${ 3 eq 3 }<br>
		\${ 3!=2 } = ${ 3 ne 2 }<br>
		<hr>
		
		<!-- 삼항연산자 -->
		${ empty param.msg ? '비었음' : '안녕' }<br>
		<hr>
	
		<!-- 논리연산자 -->
		${ param.msg eq null or param.msg eq '' ? '비었다(X)' : '있다(O)'}<br>
	</body>
</html>