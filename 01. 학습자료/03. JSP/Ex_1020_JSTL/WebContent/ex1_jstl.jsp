<%@page import="vo.PersonVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- JSTL(JSP Standard Tag Library)
		JSP영역안에서 스크립트 릿 없이 IF, FOR문등을 사용 가능하게 해주는 LIBRARY
		
		IF, FOR문 FOMATER등의 속성 설정
		JSP의 TOMCAT -> WEBAPPS -> EXAMPLES -> WEB-INF -> LIB -> LIBRART두개다 복사
		복사한 라이브러리를 톰캣의 LIB폴더에 붙여넣기
 -->

<!-- LIBRARY가 제대로 등록되었는지 확인 (만약 오류가 나면 PROJECT에서 CLEAN을 해보자)
		prefix는 임의대로 쓰지만 보통 core의 약자인 c를 쓴다.
		c(CORE)는 core라이브러리를 참조하고있는데 FOR EACH, IF등의 제어문을 사용할 수 있도록 해준다. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- FMT(FORMAT) 
		날짜나 숫자형식을 포멧팅하는 LIBRARY -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
	// JAVA에서 Date 클래스는 오늘 날짜를 찍는 것이 가능하다.
	Date today = new Date();
	int money = 1200000000;
	request.setAttribute("today", today);
	request.setAttribute("money", money);
	
	// 배열
	String [] arr = {"사과","배","포도","참외","복숭아"};
	request.setAttribute("arr", arr);
	
	// foreach, foif를 사용하기위해서는 반드시 해당 값이 Scope영역에 저장되어있어야한다. 
	// 배열의 경우 향상된 FOR문과 방식이 비슷하다.
	for(String s :arr){
		System.out.println(s);
	}
	
	
	// ARRAYLIST
	List<String> sido = new ArrayList();
	sido.add("서울");	sido.add("인천"); sido.add("부산");
	sido.add("광주");	sido.add("대전"); sido.add("대구");
	request.setAttribute("sido", sido);
	
	
	// ARRARYLIST VO
	List<PersonVO> person_list = new ArrayList();
	
	person_list.add(new PersonVO("김태현",31));	
	person_list.add(new PersonVO("김나영",28));	
	
	request.setAttribute("list", person_list);
	
%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		
		JSTL을 통한 날짜 포맷 지정<br>
		<!-- formatDate : 날짜 형식을 변경하는 속성
				fmt는 taglib에서 fmt와 같아야한다. -->
		<fmt:formatDate value="${ today }"/><br>
		<!-- pattern : 날짜 데이터의 포맷 형식을 변경한다. 
				대문자, 소문자에따라 값이 다르다.
				예 :: dd : 오늘 날짜 / DD : 올해부터 지금까지의 지나간 날짜 -->
		<fmt:formatDate value="${ today }" pattern="YYYY년 MM월 dd일"/>
		
		JSTL을 통한 숫자 포맷 지정<br>
		<!-- 숫자타입은 천원 단위로 ,를 찍는 경우에만 사용한다. -->
		금액 : &#8361;<fmt:formatNumber value="${ money }"/><br>
		
		<hr>
		JSTL을 통한(CORE) FOREACH, IF문 생성<br>
		<!-- for문이 열리고 /으로 닫힌다. var:초기값 begin부터 시작해서 end에서 끝나는데 1씩 증가한다.
				var : (초기값)1회전마다 갱신되는 begin값을 담는 변수 / begin : 시작값 / end : 끝값 / step : 증감값 -->
		<c:forEach var="n" begin="1" end="5" step="1">
			<!-- TEST : 조건식 -->
			<c:if test="${ n mod 2 eq 1 }">
			<!-- FOREACH의 요소는 EL표기법으로 따로 SCOPE에 저장없이 사용가능하다. -->
			<font color="red">안녕${ n }</font><br>
			</c:if>

			<c:if test="${ n mod 2 eq 0 }">
			<font color="blue">안녕${ n }</font><br>
			</c:if>
		</c:forEach>
		
		<hr>
		
		<!-- for(String fruit:arr)과 같다. 
		{arr}에 담겨있는 첫번째 배열의 값을 var fruit에 담고 for문진행하고 다음 것 반복 -->
		<c:forEach var="fruit" items="${ arr }">
			${ fruit }<br>
		</c:forEach>
		
		<hr>
		
		<ul>
		<c:forEach var="sido" items="${ sido }">
				<li>${ sido }</li><br>
		</c:forEach>
		</ul>
		
		
		<hr>
		
		<!-- foreach를 사용한 index접근 
				varStatus는 index번호를 매기는 역할을 한다. -->
		<c:forEach var="value" items="${ sido }" varStatus="in">
			<c:if test="${ in.index eq 3  }">			
				${ value }<br>
			</c:if>
		</c:forEach>
	
		<hr>
	
		<!-- ARRAYLIST에 담긴 VO값 출력 
			index : 방번호 (0번 부터 시작)
			count : 숫자 (1번부터 시작)-->
		<c:forEach var="p" items="${ list }" varStatus="cnt">
			${ cnt.index } : ${ cnt.count } : ${ p.name } / ${ p.age }<br>
		</c:forEach>
	
	</body>
</html>