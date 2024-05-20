<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	int dan = Integer.parseInt(request.getParameter("dan"));
	String str = "";
	
	for(int i=1;i<=9;i++){
		str += String.format("%d * %d = %d<br>",dan,i,dan*i);
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 출력 스크립트릿으로 보내는 경우, 페이지 전체가 넘어간다. -->
	<%= str %>
</body>
</html>