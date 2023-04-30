<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" align="center">
		<caption>::테스트 목록::</caption>
		<tr>
			<th>순서</th>
			<th>테스트 번호</th>
			<th>테스트명</th>
			<th>비고</th>
		</tr>
		
		<c:forEach var="vo" items="${ list }">
		<tr>
			<td>${ vo.disp_order }</td>
			<td>${ vo.test_no }</td>	
			<td>${ vo.test_nm }</td>	
			<td>${ vo.remark }</td>	
		</tr>
		</c:forEach>
	</table>
</body>
</html>