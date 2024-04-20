<%@page import="coll.MyMap"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(application);
	MyMap MyMap = (MyMap)wac.getBean("MyMapBean");
	
	request.setAttribute("map", MyMap.getMap());
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- MAP은 KEY값을 통해서 VALUE값에 접근하므로 FOR EACH를 사용할 필요가 없다. -->
	${ map.hong }<br>
	${ map.kim }
</body>
</html>