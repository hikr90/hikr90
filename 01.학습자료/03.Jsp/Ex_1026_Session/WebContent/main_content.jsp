<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- include
		- 특정 페이지를 연관시키는 지시어
		- 로그인, 세션체크 등 웹페이지 공통 영역을 처리하는데 사용한다.
		
		동작 순서
			- a.jsp : include하고자하는 화면
			- b.jsp : include태그를 사용하는 메인 화면
			
			(1) a.jsp의 코드가 b.jsp에 포함된다.
			(2) b.jsp의 코드가 java로 변환
			(3) java파일이 서블릿 클래스로 변환
			(4) 브라우저에 요청
		
		[참고] include에 해당하는 jsp의 java파일은 단 하나만 생성된다.
-->
<%@ include file="check_login.jsp"  %>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	</head>
	<body>
		메인 페이지 <br>
		${ user.name }님 환영합니다. <br>
		
		<input type="button" value="logout" onclick="location.href='logout.do'">
	</body>
</html>