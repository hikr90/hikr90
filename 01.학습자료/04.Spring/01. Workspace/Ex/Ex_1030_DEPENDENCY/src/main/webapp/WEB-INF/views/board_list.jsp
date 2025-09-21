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
	<!-- http://localhost:9090/test_di/board/list.do -->
	게시판 목록입니다.
	<ul>
		<c:forEach var="vo" items="${ list }">
			<li>${ vo }</li>
		</c:forEach>
	</ul>
</body>
</html>