<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!-- - 해당 Jsp는 유저정보가 남아있는지 확인하는 용도로
	 - 세션 영역에 유저정보가 존재하는 경우 main_content.jsp로 이동하며
	 - 정보가 없는 경우 분기문을 통해서 login_form.jsp로 이동한다.
-->
<c:if test="${ empty sessionScope.user }">
	<script>
		alert("로그인 후 이용가능한 페이지입니다.");
		location.href="login_form.jsp";
	</script>
</c:if>
	
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	</head>
	<body>
	
	</body>
</html>