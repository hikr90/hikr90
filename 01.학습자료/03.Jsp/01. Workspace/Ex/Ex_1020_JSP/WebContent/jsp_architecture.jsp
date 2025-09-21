<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%! 
	//
	int n = 0;
	Random rnd = new Random();
	//	
	public int plus(int a, int b){
		return a+b;
	}
%>

<% 
	// 
	int random = rnd.nextInt(10)+1;
	int n2 = 0;
	System.out.println(random);
%>

<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<p> <%= "n++ : "+ n++ %></p>
		<p> <%= "n2++ : "+ n2++ %></p>
		<p> <%= plus(random, random) %></p>
	</body>
</html>