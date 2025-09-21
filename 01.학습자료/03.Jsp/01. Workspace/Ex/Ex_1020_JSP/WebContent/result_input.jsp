<%@page import="vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	// setCharacterEncoding
	// 	- post 타입 전송 시 전송 데이터가 한글인 경우 인코딩 타입을 지정해줘야한다.
	request.setCharacterEncoding("utf-8");
	//
	String id = request.getParameter("id");
	int pwd = Integer.parseInt(request.getParameter("pwd"));
	int age = Integer.parseInt(request.getParameter("age"));
	//
	UserVo vo = new UserVo();
	vo.setId(id);
	vo.setPwd(pwd);
	vo.setAge(age);
%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	
		<style type="text/css">
			table{border-collapse: collapse;}
			.info{width: 150px;}
		</style>
	</head>
	<body>
		<table border="1">
			<caption>:: 수신된 데이터 ::</caption>
			<tr>
				<td>ID</td>
				<td class="info"><%= vo.getId() %></td>
			</tr>
			<tr>
				<td>PWD</td>
				<td class="info"><%= vo.getPwd() %></td>
			</tr>
			<tr>
				<td>AGE</td>
				<td class="info"><%= vo.getAge() %></td>
			</tr>
		</table>
	</body>
</html>