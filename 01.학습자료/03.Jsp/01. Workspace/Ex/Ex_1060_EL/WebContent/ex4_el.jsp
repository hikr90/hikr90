<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="vo.PersonVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	/* VO의 EL표기법
		- 전체 표현 : ${영역.객체.getName()}
		- 영역 생략 : ${객체["값"]}
		- 가장 보편적인 형태 : ${객체.값}		// 따로 getter와 setter가 있어야 사용 가능하다.
	*/
	PersonVO vo = new PersonVO("김태현",31);
	request.setAttribute("vo", vo);
	//	
	PersonVO vo2 = new PersonVO("김나영",28);
	request.setAttribute("vo2", vo2);

	/* List의 EL표기법
		- 가장 보편적인 형태 : ${list[인덱스].값}
	*/
	List<PersonVO> arr_list = new ArrayList();
	//	
	arr_list.add(vo);
	arr_list.add(vo2);
	request.setAttribute("m_arr", arr_list);
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		# VO
		전체 표현 : ${requestScope.vo.getName() }<br>
		<hr>
		영역 생략 : ${ vo['name']}<br>
		<hr>
		가장 보편적인 형태 : : ${ vo.name }<br>
		
		<hr><hr>

		# List
		가장 보편적인 형태 : ${ m_arr[0].name }<br>
	</body>
</html>