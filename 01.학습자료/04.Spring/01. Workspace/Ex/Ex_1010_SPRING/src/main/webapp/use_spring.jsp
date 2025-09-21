<%@page import="org.springframework.web.context.request.RequestScope"%>
<%@page import="com.korea.vo.PersonVO"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 

<%
	/*	WebApplicationContext
			- root-context.xml에서 생성된 객체는 application 영역에 저장된다.
			- 스프링에서는 서블릿의 내장객체로 바로 접근이 안되므로 해당 객체를 통해서 접근한다.
			
			메소드
				- (1) getBean
					- 빈객체를 가져오는 메소드
					- 컴파일러가 객체에 저장된 값이 어떤 값인지 알 수 없으므로 형변환을 해줘야한다.
	*/
	// 객체 생성
	WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(application);
	// 객체 저장
	PersonVO p1 = (PersonVO)wac.getBean("p1");			// 방식 1
	PersonVO p2 = wac.getBean("p2", PersonVO.class);	// 방식 2
	
	// Request영역 저장
	request.setAttribute("p1", p1);
	request.setAttribute("p2", p2);
	
	// 객체 저장
	PersonVO p3 = (PersonVO)wac.getBean("p3");
	PersonVO p4 = (PersonVO)wac.getBean("p4");
	
	// Request영역 저장
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
	<!-- 위에서의 Bean은 싱글톤 객체 생성이므로 새로고침을 해도 생성자(PersonVO 기본 생성자) 호출이 되지 않는다.  -->
	${ p1.name } / ${ p1.age } / ${ p1.tel }
	${ p2.name } / ${ p2.age } / ${ p2.tel }
	<hr>
	
	<!-- Prototype으로 작성한 P4의 경우, Jsp를 새로고침하면 생성자("파라미터를 받는 생성자")가 계속 실행되는 것을 알 수 있다. -->
	${ p3.name } / ${ p3.age } / ${ p3.tel }<br>
	${ p4.name } / ${ p4.age } / ${ p4.tel }
</body>
</html>