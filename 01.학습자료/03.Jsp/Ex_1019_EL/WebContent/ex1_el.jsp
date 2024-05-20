<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	/*	EL 표기법 
			- Expression Language
			- Jsp에서 사용하는 표현식을 간결하게 사용하기위한 표현 언어
			- 변수와 여러가지 함수를 통한 연산자 및 JSTL 함수의 사용이 가능하다.
			- Page, Request, Session, Application의 영역에서 데이터를 사용 및 조회가 가능하다.
			
			객체의 유효기간 (사용 영역)
				(1) pageScope
					- page에 저장된 데이터는 현재 페이지에서만 사용가능하다.
					- private의 개념과 동일하다.
					
				(2) requestScope
					- 보편적으로 사용하는 영역으로 두 페이지간 서로 값의 공유가 가능하다.
					- 서블릿에서 사용가능하다.
					- a.jsp에서 지정해두면 b.jsp에서 사용이 가능하다.
				
				(3) sessionScope
					- 보편적으로 사용하는 영역으로 전역 개념으로서 페이지가 닫혀도 메모리 상에 남아있다.
					- 하나의 웹 브라우저에서 공유가 가능하다.
					- 세션에 저장된 데이터는 인터넷 창이 확실하게 종료되기 전까지는 데이터가 남아있다.
				
				(4) applicationScope
					- 하나의 프로젝트 내에서 값을 공유한다.
				
			[참고] 영역의 우선순위
				- 단 하나의 값만 저장된 경우 ${명칭}으로도 동작된다.
				- 서로 다른 영역에 같은 명칭이 저장된 경우 아래의 순서대로 값이 조회된다.
					(1) pageScope
					(2) requestScope
					(3) sessionScope
					(4) applicationScope
	*/
	String msg = "안녕";

	// pageScope 영역에 저장
	pageContext.setAttribute("msg", msg);	
		
	// requestScope 영역에 저장
	request.setAttribute("msg", "request영역의 값");	
	
	// sessionScope 영역에 저장	
	session.setAttribute("msg2", "session영역의 값");
	
	// application 영역에 저장
	application.setAttribute("msg4", "application영역의 값");
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		JSP의 기본적인 출력 코드 : <%= msg %><br>
		EL표현식(pageScope) : ${ pageScope.msg }<br>
		EL표현식(requestScope) : ${ requestScope.msg }<br>
		EL표현식(sessionScope) : ${ sessionScope.msg2 }<br>
		EL표현식(생략식) : ${ msg2 }<br>
		EL표현식(생략식) : ${ msg }<br>
		
		<!-- param.변수 
				- 요청으로 jsp에서 보내준 변수는 ${param.변수명}으로 데이터를 가져온다.
				- 요청은 test.do?param1=1처럼 보내준 값을 의미한다.
		-->
		EL표현식(파라미터) : ${ param.greet }<br>
	</body>
</html>