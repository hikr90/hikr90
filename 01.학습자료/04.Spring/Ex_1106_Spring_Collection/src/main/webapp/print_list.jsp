<%@page import="coll.MyList"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(application);

	MyList list = (MyList)wac.getBean("MyListBean");
	request.setAttribute("list", list.getList());
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<c:forEach var="vo" items="${ list }">
			<li>${ vo }</li><br>
		</c:forEach>
	</ul>
</body>
</html>