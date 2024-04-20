<%@page import="com.korea.vo.PersonVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- SPRING방식이 아닌 JSP형식의 구조
		- REQUSET에 저장하여 BODY에서 EL표기법으로 사용 
		- (기존에 JSP에서 사용하던 방식)
-->

<%
	PersonVO p1 = new PersonVO();
	p1.setName("일길동");
	p1.setAge(31);
	p1.setTel("010-111-1111");
	request.setAttribute("p1", p1);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>${ p1.name } / ${ p1.age } / ${ p1.tel }</p>
</body>
</html>