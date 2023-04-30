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
	<p>나라별 인사말</p>
	사용자 ${ ip }님이 접속하셨습니다.<br>
	<c:forEach var="vo" items="${ msg }">
		${ vo }<br>
	</c:forEach>
</body>
</html>