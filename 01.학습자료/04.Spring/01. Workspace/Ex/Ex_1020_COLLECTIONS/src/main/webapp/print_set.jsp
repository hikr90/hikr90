<%@page import="coll.MySet"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% 
	WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(application);
	MySet mySet = (MySet)wac.getBean("MySetBean");
	request.setAttribute("set", mySet.getSet());
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="sido" items="${ set }">
		${ sido }<br>
	</c:forEach>
</body>
</html>