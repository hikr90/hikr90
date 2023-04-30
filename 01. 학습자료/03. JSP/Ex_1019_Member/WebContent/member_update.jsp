<%@page import="dao.MemberDAO"%>
<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name2");
	String id = request.getParameter("id2");
	String pwd = request.getParameter("pwd2");
	String email = request.getParameter("email2");
	String addr = request.getParameter("addr2");
	int idx = Integer.parseInt(request.getParameter("idx"));
	
	MemberVO mvo = new MemberVO();
	mvo.setName(name);
	mvo.setId(id);
	mvo.setPwd(pwd);
	mvo.setEmail(email);
	mvo.setAddr(addr);
	mvo.setIdx(idx);
	
	int res = MemberDAO.getInstance().update(mvo);
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