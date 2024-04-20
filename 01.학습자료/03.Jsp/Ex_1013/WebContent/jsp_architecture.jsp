<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%! 
	// <%! : 선언부 (전역변수 개념)
	// 전역변수 개념은 스크립트 릿에서도 사용가능하다.
	int n = 0;

	// jsp header에 random 클래스가 import된다.
	Random rnd = new Random();
	
	public int plus(int a, int b){
		return a+b;
	}
	
%>

<% 
	// 스크립트 릿은 지역변수 개념이다
	int random = rnd.nextInt(10)+1;
	System.out.println(random);
	
	int n2 = 0;
	
%>

<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<!-- 후행 증감으로 지역변수도 증가는 하지만 지역변수는 출력시마다 계속 초기화된다, 그래서 전역변수는 n은 계속 증가하지만 지역변수는 n2는 초기화가 된다. -->
		<p> <%= "n++ : "+ n++ %></p>
		<p> <%= "n2++ : "+ n2++ %></p>
		<p> <%= plus(random, random) %></p>
		
		
	</body>
</html>