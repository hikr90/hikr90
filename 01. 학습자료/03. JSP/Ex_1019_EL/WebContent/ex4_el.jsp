<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="vo.PersonVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	PersonVO vo = new PersonVO("김태현",31);
	/* 객체를 저장 */
	request.setAttribute("vo", vo);
	
	PersonVO vo2 = new PersonVO("김나영",28);
	request.setAttribute("vo2", vo2);
	
	/* arrayList 생성 */
	List<PersonVO> arr_list = new ArrayList();
	
	arr_list.add(vo);
	arr_list.add(vo2);
	
	/* arr_list를 통째로 저장한다 */
	request.setAttribute("m_arr", arr_list);
	
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		풀코딩(안씀) : ${requestScope.vo.getName() }<br>
		<hr>
		약간 줄인 코딩(가끔 씀)(\${ vo['name']}) : ${ vo['name']}<br>
		<hr>
		<!-- 아래의 방식을 사용하기위해서는 Setter와 Getter가 반드시 있어야한다. -->
		최종형태(\${ vo.age }) : ${ vo.name }<br>
		
		<hr>
		<hr>
		<!-- 배열 처리하듯이 데이터를 꺼내오는 것이 가능하다. -->
		ArrayList m_arr에 담겨있는 정보 출력(\${ m_arr[0].name }) : ${ m_arr[0].name }<br>
		
				
	</body>
</html>