<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<!-- check_login은 페이지 시작시 제일 처음에 거쳐가는 페이지로
	처음 시작시 웹페이지들간의 클라이언트 상태 유지를 위해 session이 필요하다. 
	서로 연관이 없는 없는 페이지들간에 연관성을 부여하기 위한 방법
	
	서버에 데이터를 저장해뒀다가 사용자와 웹사이트사이를 매개해주는 정보가 session이다.
	-->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!-- session영역에 "user"라는 이름으로 저장된 것이 없으면 if문 실행  -->
<c:if test="${ empty sessionScope.user }">
	<script>
		alert("로그인 후 이용가능한 페이지입니다.");
		// 로그인 페이지로 이동
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