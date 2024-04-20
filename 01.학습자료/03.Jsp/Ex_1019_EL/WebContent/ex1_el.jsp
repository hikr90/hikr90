<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- (녹음 33분부터 시작) -->
<%
	/* EL(Expression Language) (request, session만 사용한다.)
		jsp에서 사용하는 표현식을 좀 더 간결하게 쓸 수 있도록 도와주는 표현 언어
		(request를 제외하고 jsp에서 만들어진 객체여서 jsp에서만 사용이 가능하다.)
		EL로 값을 표기하기위해서는 4개의 영역에 실제로 존재하는 데이터만 사용가능하다.
	*/
	
	/* 객체의 유효기간
		1) pageScope영역 : page에 저장된 데이터는 현재 페이지에서만 사용이 가능하다. (private개념)
		2) requestScope영역(가장 많이 쓰는 영역) : 두개의 페이지에서 키값을 공유할 수 있다. 예) a.jsp에서 지정해두면  b.jsp에서 사용이 가능 
		3) sessionScope영역(다음으로 많이 사용하는 영역) : 전역 개념으로서, 페이지가 닫혀도 메모리상에 남아있다. 
				하나의 웹 브라우저에서 공유가 가능하다.
				-- 네이버에서 로그인한 뒤, 네이버 창 끄고 다시 열어도 로그인이 그대로 되어있는 상황, session으로 저장된 데이터는 인터넷창이 확실하게 꺼지기전에는 데이터가 그대로 남아있다.
					(브라우저가 여러가지 섞여있어도 상관없음)
		4) applicationScope영역 : 하나의 프로젝트에서만 값을 공유한다. 
	*/

	String msg = "안녕";

	/* (1) pageScope영역 (Servlet)
		pageScope안의 저장된 키값("msg")을 찾아서 값(msg)에 해당하는 값을 꺼내온다.
	*/
	pageContext.setAttribute("msg", msg);	
		
	
	/* (2) requestScope영역 (servlet에서도 사용가능)
		requestScope의 영역에 저장된 것은 request영역의 "msg"을 찾아서 "request영역의 값"을 꺼내온다.
	*/
	request.setAttribute("msg", "request영역의 값");	
	
	
	/* (3) sessionScope영역 
		requestScope와 같은 방식으로도 가능하다.  
		단 하나만 저장이 되어있는 경우 : Scope지정 없이 실행이 가능하다. 
		
		서로 다른 영역에 같은 명칭이 저장되어있는 경우
			생략식을 사용한 EL표기법 적용시 영역 참조 순서
			1) pageScope
			2) requestScope
			3) sessionScope
			4) applicationScope
		위에서 부터 영역마다 찾아보는데 찾은 경우 해당 키값에 해당하는 영역을 사용한다.
		
		주의 사항 :: EL표현식은 주석을 달아도 컴퓨터가 인식하는 경우가 있으므로 EL표현식은 쓰는 경우 확실하게 사용하고 절대로 주석으로 처리하면 안된다.
		
	*/
	session.setAttribute("msg2", "session영역의 값");
	
	/* (4) applicationScope영역 */
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
		
		<!-- test.jsp?greet=hi로 작성하는 경우 hi라는 데이터를 가져오는 역할을 한다.-->
		EL표현식(파라미터) : ${ param.greet }<br>
	</body>
</html>