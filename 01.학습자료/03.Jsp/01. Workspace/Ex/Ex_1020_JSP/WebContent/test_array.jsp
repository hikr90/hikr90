<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 문제  
		- 바디 영역에서 ul태그와 li태그를 사용하여 아래의 결과를 보여주세요.
		----------------------------
		- 과일목록 
		- ● 사과
		- ● 배
		- ● 등등..
-->
<%
	String [] fruit_array = {"사과","배","참외","오렌지","복숭아"};
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	
		<style type="text/css">
			li{list-style: none;}
		</style>
	
	</head>
	<body>
		<ul>
		<% 	for(int i=0;i<fruit_array.length;i++){%>
			<li><%=fruit_array[i]%></li>
		<% }%>		
		</ul>
	</body>
</html>