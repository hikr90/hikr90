<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- CORE LIBRARY사용법
	C:\spring_1105_kth\util\apache-tomcat-8.5.58\webapps\examples\WEB-INF\lib 에서 라이브러리 두개 복사후
	C:\spring_1105_kth\util\apache-tomcat-8.5.58\lib 에 붙여넣기한다.
	
	CONTROLLER에서 실행할때는 VIEWS안에서 JSP에서 단순 실행할 것은 WEBAPPS에서 JSP생성하면 된다.
	
		 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- http://localhost:9090/test_di/board/list.do로 검색 -->
	게시판 목록입니다.
	<ul>
		<c:forEach var="vo" items="${ list }">
			<li>${ vo }</li>
		</c:forEach>
	</ul>
</body>
</html>