<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.PersonVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	PersonVo p1 = new PersonVo();
	p1.setName("홍길동");
	p1.setAge(20);
	p1.setPhone("010-111-1111");
	//
	PersonVo p2 = new PersonVo();
	p2.setName("김길동");
	p2.setAge(30);
	p2.setPhone("010-222-2222");
	//	
	PersonVo p3 = new PersonVo();
	p3.setName("박길동");
	p3.setAge(40);
	p3.setPhone("010-333-3333");
	
	// List자료형은 ArrayList 클래스의 자식 개념 인터페이스이다.
	List<PersonVo> pList = new ArrayList();
	pList.add(p1);
	pList.add(p2);
	pList.add(p3);
%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			table{border-collapse: collapse;}
			td{width: 100px; text-align: center;}
			.td3 {width:150px;}		
		</style>
	
	</head>
	<body>
		<table border="1">
			<caption>::개인 정보::</caption>
			<tr>
				<th>이름</th>
				<th>나이</th>
				<th>전화번호</th>
			</tr>
						
			<% for(int i=0;i<pList.size();i++){%>
				<tr>
				<td> <%= pList.get(i).getName() %> </td>
				<td> <%= pList.get(i).getAge() %> </td>
				<td class="td3"> <%= pList.get(i).getPhone() %> </td>
				</tr>
			<% }%>
		
		</table>
	</body>
</html>