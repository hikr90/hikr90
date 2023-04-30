<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 메인 페이지는 로그인 주소를 친다고해서 아무나 들어올 수 없게 해야한다. -->

<!-- 인클루드는 특정 페이지를 연관시킨다. 진행 순서상 위에서 아래로 진행되는데 인클루드가 통과해야 메인 내용이 보인다. 
		지금은 세션 영역에 저장된게 없으니 로그인폼으로 강제로 가기 때문에 메인 페이지 글자가 확인이 안된다.
		즉 로그인 체크 화면의 if문에서 참값이 안되면 메인페이지로 갈 수 없다.
		
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
		<!-- sessionScope에 저장해두었으니 불러오는 것이 가능하다. -->
		${ user.name }님 환영합니다. <br>
		
		<!-- 로그아웃 
				보낼 것은 딱히 없으니 location으로 바로 이동
				(유저의 데이터를 삭제) -->
		<input type="button" value="logout" onclick="location.href='logout.do'">
	</body>
</html>