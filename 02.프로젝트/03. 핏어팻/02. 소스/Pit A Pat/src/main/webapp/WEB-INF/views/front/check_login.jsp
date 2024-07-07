<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 웹 페이지들 간에 클라인언트 상태 유지를 위해 세션이 필요.
    	서로 연관이 없는 페이지들간에 연관성을 부여하기 위한 방법
    	서버에 데이터를 저장하여 사용자와 웹사이트 사이를 매개해주는 정보가 세션! -->
    	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    	
    <c:if test="${empty sessionScope.user }">
		<script>
			alert("로그인 후 이용가능한 페이지 입니다!");	
			location.href="piptLoginInqy1010.do";
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