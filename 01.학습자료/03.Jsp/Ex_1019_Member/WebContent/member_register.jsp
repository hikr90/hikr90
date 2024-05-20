<%@page import="vo.MemberVO"%>
<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	MemberVO mvo = new MemberVO();
	mvo.setName(request.getParameter("name"));
	mvo.setId(request.getParameter("id"));
	mvo.setPwd(request.getParameter("pwd"));
	mvo.setEmail(request.getParameter("email"));
	mvo.setAddr(request.getParameter("addr"));
	//
	MemberDAO.getInstance().insert(mvo);
	response.sendRedirect("jdbc_member.jsp");
%>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	</head>
	<body>
	
	</body>
</html>