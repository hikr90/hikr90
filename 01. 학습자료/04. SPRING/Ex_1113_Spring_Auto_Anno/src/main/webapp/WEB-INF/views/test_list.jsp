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
			<th>테스트 번호</th>
			<th>테스트 명</th>
			<th>테스트 조회순서</th>
		</tr>
		
		<c:forEach var="vo" items="${ list }">
		<tr>
			<td>${ vo.testNo }</td>
			<td>${ vo.testNm }</td>
			<td>${ vo.dispOrder }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>