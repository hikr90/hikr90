<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="utf-8"%>

<!-- SPRING 시작
		SRC/MAIN/WEBAPP/WEB-INF/VIEWS의 경로를 통해서 HOME.JSP가 브라우저에 실행된다.
		
		:: 프로젝트는 PROJECT 우클릭후 RUN AS > RUN ON SERVER로 동작이 가능하다.
		:: 상단의 PAGEENCODING의 UFT-8속성값으로 한글의 깨지는 것을 방지할 수 있다.
		:: SERVERTIME은 JAVARESOURCE/COM.KOREA.TEST/HOMECONTROLLER에서 전달받는 형태
		:: 기본적으로 JSP파일은 WEBAPP 폴더에 생성하여 사용한다.	
-->

<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<!-- MODEL은 REQUEST로부터 HELLO라는 영역을 위임받았으므로 REQUESTSCOPE 영역으로 호출하거나
		EL표기법 HELLO로도 확인이 가능하다.   -->
<p>${ hello }</p>
</body>
</html>
