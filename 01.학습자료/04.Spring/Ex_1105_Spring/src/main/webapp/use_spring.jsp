<%@page import="org.springframework.web.context.request.RequestScope"%>
<%@page import="com.korea.vo.PersonVO"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 

<%
	/*	SPRING FRAMEWORK에서의 빈객체 사용
			- ROOT-CONTEXT에서 생성된 객체는 APPLICATION 영역에 저장된다.
			- SPRING에서는 서블릿의 내장객체로 바로 접근이 안되므로 WEBAPPLICATIONCONTEXT 객체를 통해서 접근해야한다.
	*/
	
	// WEBAPPLICATIONCONTEXT 객체 생성
	WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(application);
	
	/* GETBEAN
			- 컴파일러는 P1 객체에 저장된 값이 뭔지 모르기에 가지고오는 객체가 PERSONVO타입이라는 것을 명시하기위해 캐스팅을 해줘야한다.
			- (추후에는 사용하지 않음)
	*/	
	PersonVO p1 = (PersonVO)wac.getBean("p1");			// 방식 1
	PersonVO p2 = wac.getBean("p2", PersonVO.class);	// 방식 2
	
	// BODY에서 사용할 수 있도록 REQUESTSCOPE영역에 저장
	request.setAttribute("p1", p1);
	request.setAttribute("p2", p2);
	
	// DI로 가지고온 객체 정보
	PersonVO p3 = (PersonVO)wac.getBean("p3");
	PersonVO p4 = (PersonVO)wac.getBean("p4");
	
	// REQUEST영역에 저장
	request.setAttribute("p3", p3);
	request.setAttribute("p4", p4);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 위에서의 BEAN은 싱글톤 객체 생성이므로 새로고침을 해도 생성자(PERSONVO 기본 생성자) 호출이 되지 않는다.  -->
	${ p1.name } / ${ p1.age } / ${ p1.tel }
	${ p2.name } / ${ p2.age } / ${ p2.tel }
	
	<hr>
	<!-- PROTOTYPE으로 작성한 P4의 경우, JSP를 새로고침하면 생성자("파라미터를 받는 생성자")가 계속 실행되는 것을 알 수 있다. -->
	${ p3.name } / ${ p3.age } / ${ p3.tel }<br>
	${ p4.name } / ${ p4.age } / ${ p4.tel }
	
</body>
</html>