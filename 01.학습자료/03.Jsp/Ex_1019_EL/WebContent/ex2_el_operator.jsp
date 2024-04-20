<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<!-- EL표기법 연산자 -->
		EL산술연산자 <br>
		<!-- EL표기법안에서 연산자를 사용하면 계산이 완료되서 나온다. 
				EL표기법 앞에 \을 붙이면 문자형식이 된다. -->
		\${ 1+1 } = ${ 1+1 }<br>
		\${ 4-2 } = ${ 4-2 }<br>
		\${ 5*3 } = ${ 5*3 }<br>
		\${ 10/3 } = ${ 10/3 }<br>
		\${ 10/3 } = ${ 10 div 3 }<br>
		\${ 10%3 } = ${ 10%3 }<br>
		\${ 10%3 } = ${ 10 mod 3 }<br>

		<hr>
		
	<!-- EL표기법 비교연산자 -->
		\${ 3>2 } = ${ 3>2 }<br>
		\${ 3>2 } = ${ 3 gt 2 }<br>
		<!-- ge는 greater equal로 크거나 같다를 뜻한다. -->
		\${ 3>2 } = ${ 3 gt 2 }<br>
				
		<!-- le는 lesser equal로 작거나 같다를 뜻한다. -->
		\${ 3<2 } = ${ 3 lt 2 }<br>
		\${ 3<=2 } = ${ 3 le 2 }<br>
		
		<!-- eq는 같다. / ne는 not equal로 같지 않다를 뜻한다. -->
		\${ 3==3 } = ${ 3 eq 3 }<br>
		\${ 3!=2 } = ${ 3 ne 2 }<br>
		
		<hr>
		
	<!-- EL표기법 삼항연산자 -->
		<!-- 파라미터로 넘어온 값(test.jsp?msg="안녕") 삼항연산자의 참과 거짓 조건을 EL에서 판단 
			empty : msg라는 파라미터가 비어있는가? 
			?msg='' 와 ?___도 판별이 가능하다. -->
		
		${ empty param.msg ? '비었음' : '안녕' }<br>
		
		<hr>
	
	<!-- EL논리연산자 
			?__도 적용되며 ||보다는 or을 더 많이 사용한다. -->
		${ param.msg eq null or param.msg eq '' ? '비었다(X)' : '있다(O)'}<br>
		
		
	</body>
</html>