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
	
	${ ip }님 접속을 환영합니다.<br>

	<c:forEach var="vo" items="${ msg }">
		${ vo }<br>
	</c:forEach>
</body>
</html>