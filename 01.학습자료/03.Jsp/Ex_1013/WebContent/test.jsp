<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- JSP
		- Java Server Page의 약자로, Html에 자바 코드를 입력하여 동적으로 웹페이지를 생성하여 웹브라우저에 띄우는 언어
		- 내부적으로 연산 능력을 가지고있는 Html이다.
		
		- 서블릿의 비즈니스 로직과 화면 기능을 분리하여 간단한 화면 구현과 유지 관리를 목적으로 도입되었다.
		- 맵핑 동작 시 Jsp가 서블릿으로 변환되어 웹 컨테이너에서 동적 데이터를 처리한 뒤 Html으로 웹 브라우저에 띄워주는 방식
		
		- Jsp가 실행되면 서블릿으로 자동으로 변환된 뒤, 요청을 서버에서 처리하여 브라우저로 응답을 반환한다.
-->

<!-- 스크립트릿
		- Server + Let
		- Jsp에서 동적 결과를 얻기위해서 사용되며 Jsp내에서 자바 코드를 사용할 수 있게 하는 영역 
		- 스크립트 릿이 실행될 때, Jsp가 서블릿으로 변환되며 request가 동작된다.
-->
<% 
	// 요청은 서블릿의 객체이나 Jsp 실행되며 서블릿으로 변환되므로
	// Jsp에서도 request, response 등의 내장 객체를 사용할 수 있다.
	String ip = request.getRemoteAddr();
	String msg = "반갑습니다.";
%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<p>&lt;%@ 내용%&gt;
			: jsp header : 전송시 인코딩 타입, 페이지 인코딩, import등을 설정하기 위한 반드시 필요한 영역이다.</p>
			
		<p>&lt;%자바 코드%&gt;
			: 스크립트릿 : jsp에서 자바 코드를 사용할 수 있게하는 영역</p>
			
		<p>&lt;%= 변수명%&gt;
			: 스크립트릿에서 생성한 변수를 출력하기 위한 영역</p>
			
		<p>&lt;%= 변수명;%&gt;
			: 출력 코드 사용시 ;이 있으면 오류가 난다.</p>
		
		<%= ip %>님 접속을 환영합니다.<br>
		<%= msg %>
		
	</body>
</html>