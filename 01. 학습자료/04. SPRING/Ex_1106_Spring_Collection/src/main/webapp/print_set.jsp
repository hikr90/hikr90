<%@page import="coll.MySet"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- SET은 인덱스가 없는 데이터의 집합이지만 FOR EACH에서는 사용할 수 있다. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% 
	WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(application);
	
	MySet mySet = (MySet)wac.getBean("MySetBean");
	
	// MYSET은 SET에대한 객체 정보만 들어있는 상태이므로 GETSET메소드를 통해서 값을 꺼내와야한다. 
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