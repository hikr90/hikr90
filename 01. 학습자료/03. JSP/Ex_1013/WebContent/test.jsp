<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- JSP
		내부적으로 연산 능력을 가지고있는 HTML이다.
		JSP로 작업이 완료된 후 실행되면 SERVLET으로 자동으로 변환되어 SERVLET만으로는 한계가 있는 화면 UI의 디자인을 
		쉽게 할 수 있다. -->

<!-- 스크립트 릿(SCRIPTLET) : JSP에서 자바 코드를 쓸 수 있도록 해주는 영역 
		스크립트 릿이 실행될 때, 서블릿이 동작되면서 서블릿의 request가 동작된다고 보면 된다. -->
<% 
	// request는 서블릿의 객체이지만 구조상 jsp가 실행될 때, 서블릿으로 변환되기 때문에 jsp에서도 requeset, response등의 내장객체를 사용할 수 있다.
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