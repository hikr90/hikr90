<%@page import="vo.PersonVO"%>
<%@page import="java.util.ArrayList"%> 
<%@page import="java.util.List"%> 
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- LIBRARY가 제대로 등록되었는지 확인 (만약 오류가 나면 PROJECT에서 CLEAN을 해보자)
		prefix는 임의대로 쓰지만 보통 core의 약자인 c를 쓴다.
		c(CORE)는 core라이브러리를 참조하고있는데 FOR EACH, IF등의 제어문을 사용할 수 있도록 해준다. -->

<!-- JSTL이 제대로 등록되었는지 확인
		- prefix는 약어로서 임의로 작성하나 Core(c), Format(fmt)기본적으로 사용하는 방식이 있다.
		- 만약 제대로 동작되지 않는 경우 Project > Clean을 동작한다.
-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
	/* JSTL
		- Jsp Standard Tag Library
		- 커스텀 태그 중 보편적으로 사용되는 태그를 표준화한 라이브러리
		- Jsp내에서 스크립트릿없이 if, for문등을 사용할 수 있게 돕는다.
		- 라이브러리 임포트 시 사용하는 prefix(약어)와 JSTL 사용 시 사용하는 명칭은 같아야한다.
		
		사용을 위한 준비
			(1) https://tomcat.apache.org 에서 taglib 검색
			(2) tomcat이 설치된 경로 > webapps > example > WEB-INF > lib 내 붙여넣기한다.
			(3) taglibs-standard-impl / taglibs-standard-spec을 다운로드
			(4) Jsp 위에 taglib prefix="약어" uri="주소" 형식으로 사용한다.
		
		라이브러리 종류
			(1) 코어
				- 변수 지원, 흐름 제어, 반복문등의 작업을 지원한다.
				- http://java.sun.com/jsp/jstl/core
					
			(2) 국제화
				- 지역, 메세지 형식, 숫자 및 날짜 포맷등의 작업을 지원한다.
				- http://java.sun.com/jsp/jstl/fmt
					
			(3) XML
				- XML 코어, XML 변환의 작업을 지원한다.
				- http://java.sun.com/jsp/jstl/xml
					
			(4) 데이터베이스
				- Sql 관련 작업을 지원한다.
				- http://java.sun.com/jsp/jstl/sql
			
			(5) 함수
				- 컬렉션, 문자열 처리 작업을 지원한다.
				- http://java.sun.com/jsp/jstl/functions
	*/
	Date today = new Date();	// Date클래스를 선언하여 오늘 날짜 정보를 얻는다.
	int money = 1200000000;
	//
	request.setAttribute("today", today);
	request.setAttribute("money", money);
	
	// 배열
	String [] arr = {"사과","배","포도","참외","복숭아"};
	request.setAttribute("arr", arr);
	//	
	for(String s :arr){
		System.out.println(s);
	}
	
	// ArrayList (String)
	List<String> sido = new ArrayList();
	sido.add("서울");	sido.add("인천"); sido.add("부산");
	sido.add("광주");	sido.add("대전"); sido.add("대구");
	request.setAttribute("sido", sido);
	
	
	// ArrayList (VO)
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
		<!-- fmt 라이브러리 
			(1) formatDate
				- 날짜 타입을 문자 형식으로 포맷
				
				속성
					- value 	: 포맷할 데이터
					- var 		: 파싱 결과를 저장하는 변수명
					- pattern	: 출력될 포맷 형식
					- type		: 포맷할 타입 지정 (Date인 경우 날짜, Time인 경우 시간, Both인 경우 모두 지정)
					- dateStyle : 날짜의 출력 형식 지정 (DateFormat 클래스의 full, long, medium, short등이 사용)
					- timeStyle : 시간의 출력 형식 지정
					- timeZone 	: 특정 국가의 시간대로 지정
				
				방법 : <fmt:formatDate value="${dt}" pattern="패턴"/>
		
			(2) parseDate 
				- 문자 타입을 날짜 타입으로 포맷
				 
				속성
					- value 	: 파싱할 문자열
					- var 		: 파싱 결과를 저장하는 변수 명칭
					- pattern 	: 출력될 포맷 형식
				
				방법	: <fmt:parseDate var="dt" value="${dt}" pattern="패턴"/>
		
			(3) formatNumber
				- 숫자 타입을 통화 구분 표시하는 함수
				- 천원 단위로 콤마를 찍는 경우 사용한다.
				
				속성
					- value 		: 출력될 숫자
					- var			: 태그 결과를 저장할 변수명
					- scope			: 변수 접근 범위 지정
					- pattern		: 숫자가 출력될 양식 지정
					- type			: 출력될 타입 지정 (퍼센트 : %, Number : 숫자, 통화 : 통화 형식)
					- dateStyle 	: 날짜의 출력 형식 지정 (DateFormat 클래스의 full, long, medium, short등이 지정)
					- groupingUsed 	: 숫자의 구분 기호 지정 (기본 값은 true값으로 1,000등의 표시를 뜻한다.) 
					- currenyCode	: 통화 코드 지정 (원화의 경우 KRW)
					- currentSimbol : 통화 표시 시, 사용할 기호 지정
				
				방법 : <fmt:formatNumber value="숫자"/>
				
			(4) 다국어
				(4.1) setLocale
					- 다국어 태그를 사용할 언어 지정
					- 언어 지정 시, 기본 언어 값이 setLocale에서 지정한 국가 형태로 출력된다.
					- 한국 (ko_kr), 미국 (en_us), 일본 (ja_jp), 중국 (zh_cn)
					
					방법 : <fmt:setLocale value="국가 언어"/>
				
				(4.2) message, setBunble
					- 자원 번들을 명칭으로 저장
					- 하나의 Jsp에서 다국어 화면을 관리하는 경우 사용한다.
					- 자원 번들을 사용하기위해서는 국가 언어에 해당하는 properties파일이 있어야한다.
					- 한글이 깨지지 않기 위해서는 한글 명칭을 아스키코드로 변환하는 Properties Editor를 설치해야한다.
				
		-->
		JSTL을 통한 날짜 포맷 지정<br>
		<fmt:formatDate value="${ today }"/><br>
		<fmt:formatDate value="${ today }" pattern="YYYY년 MM월 dd일"/><br>
		
		JSTL을 통한 숫자 포맷 지정<br>
		금액 : &#8361;<fmt:formatNumber value="${ money }"/><br>
		<hr>
		
		JSTL을 통한(CORE) FOREACH, IF문 생성<br>
		<!-- Core 라이브러리
			(1) set
				- Jsp에서 변수를 지정
				- 속성 scope는 저장되는 영역ㅇ으로 기본 값은 pageScope이다.
				- 지정한 변수는 EL표기법으로 접근 가능하다.
				
				방법 : <c:set var="변수 명칭" value="변수 값" />
		
			(2) remove
				- set으로 생성된 변수를 제거
				- 속성 scope는 저장되는 영역ㅇ으로 기본 값은 pageScope이다.
				
				방법 : <c:remove var="변수 명칭" />
				
			(3) if
				- 조건문으로 사용
				- test의 내용에 조건문을 넣는다.
				
				방법
					<c:if test="${조건식}" />
     					본문 내용
					</c:if>
					
			(4) choose
				- switch문과 동일한 기능
				- when은 조건문을 담고 otherwise는 else의 역할을 수행한다.
			
				방법	
					<c:choose>
					     <c:when test="조건식1">본문 내용1</c:when>
	    				 <c:when test="조건식2">본문 내용2</c:when>
	    					 ..
	   					  <c:otherwise>본문 내용3</c:otherwise>
					</c:choose>
							
			(5) forEach
				- 반복문을 사용하는 함수
				- 시작 태그와 종료 태그로 구성되어있다.
				
				forEach 속성
					- item 		: 반복문에 담을 영역에 저장된 데이터 집합
					- var 		: 반복마다 사용할 한 행의 데이터
					- begin 	: 시작 값
					- end 		: 종료 값
					- step 		: 증감 값 (없는 경우 기본 값 1)
					- varStatus : 반복 상태 속성
						- ${약어.current} 	: 현재 반복문에서 해당하는 현재 반복 차수의 번호
						- ${약어.index} 		: 0부터의 순서
						- ${약어.count} 		: 1부터의 순서
						- ${약어.first} 		: 첫번째 순서인지 참거짓 반환
						- ${약어.last} 		: 마지막 순서인지 참거짓 반환
						- ${약어.begin}		: 반복문 시작 번호
						- ${약어.end}		: 반복문 끝 번호
						- ${약어.step}		: 반복문 증감값
						
				방법
					<c:forEach var="변수 명칭" items="${반복할 객체 명칭}" begin="시작값" end="마지막값" step="증가값" varStatus="속성 명칭">
					     ...
					</c:forEach>
					
			(6) url
				- Jsp에서 url을 사용
				- 상황에따라서 param태그를 사용하여 값을 동적으로 전송할 수도 있다.
		
				방법		
					<c:url> var="변수 명칭" value="URL경로">
    					<c:param name="매개 변수 명칭" value="전달 값" />
					     ...
					</c:url> 
					
			(7) redirect
				- Jsp에서 지정된 Jsp로 이동하는 기능
				- url태그처럼 param태그를 사용할 수 있다.
				
				방법
					<c:redirect> url="리다이렉트할 URL">
					     <c:param name="매개 변수 명칭" value="전달 값" />
					     ...
					</c:redirect>
					
			(8) out
				- Jsp에서 화면에 지정한 값을 출력
				- EL표기법과 동일하지만 기본 값 설정 등의 기능을 제공하므로 더 편리하게 사용할 수 있다.
				
				속성
					- value 	: 출력할 변수 
					- default	: value 속성에 지정된 값이 없는 경우 출력할 값
					- escapeXml	: 이스케이프 문자 (\n등)를 변환하는 기능, 기본 값은 true값이며 생략 가능하다.
					
					[참고] 이스케이프 속성으로 변환되는 문자
						- <		: &lt;
						- >		: &gt;
						- &		: &amp;
						- '		: &#039;
						- "		: &#034;
						- 공백 	: &nbsp;
		-->
		<c:forEach var="n" begin="1" end="5" step="1">
			<c:if test="${ n mod 2 eq 1 }">
				<font color="red">안녕${ n }</font><br>
			</c:if>

			<c:if test="${ n mod 2 eq 0 }">
				<font color="blue">안녕${ n }</font><br>
			</c:if>
		</c:forEach>
		<hr>

		<!-- 배열 형태의 forEach 사용
				- ${arr} 에 담겨있는 배열이 순서대로 fruit변수에 담겨 반복문이 진행된다.
		-->
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
		
		<c:forEach var="value" items="${ sido }" varStatus="in">
			<c:if test="${ in.index eq 3  }">			
				${ value }<br>
			</c:if>
		</c:forEach>
		<hr>
	
		<c:forEach var="p" items="${ list }" varStatus="cnt">
			${ cnt.index } : ${ cnt.count } : ${ p.name } / ${ p.age }<br>
		</c:forEach>
		
		
		<!-- function 라이브러리
				(1) contains(String a, String b) 
					- 문자열 a에 문자열 b를 포함 여부를 참거짓으로 반환한다.
					
				(2) endwith(String a, String b)
					- 문자열 a의 끝이 b로 끝나는지 여부를 참거짓으로 반환한다.
				
ㅇ				(3) indexOf(String a)
					- 문자열 a에서 b가 처음으로 나오는 위치를 숫자형으로 반환한다.
					
				(4) length(String a)
					- 문자열 a의 길이를 숫자형으로 반환한다.
					
				(5) replace(String a, String b, String c)
					- 문자열 a에서 b까지 해당되는 문자를 찾아서 문자열 c로 변환
					
				(6) toLowerCase(String a)
					- a를 모두 소문자로 문자열 반환
					
				(7) toUpperCase(String a)
					- a를 모두 대문자로 문자열 반환
					
				(8) substring(int a, int b, int c)
					- a에서 인덱스 번호 b부터 c까지 해당하는 문자열을 반환
					
				(9) split(String a, String b)
					- a에서 b로 지정한 문자열을 기준으로 나누어 배열로 반환
					
				(10) trim(String a)
					- 문자열 a에서 앞 뒤 공백을 제거한 문자열을 반환
		-->
	</body>
</html>