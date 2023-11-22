<%@page import="java.io.PrintWriter"%>
<%@page import="com.lnsp.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IslandScape</title>

</head>
<body>
<%
	MemberVO user_check = null;
	if(session.getAttribute("user") != null) {
		user_check = (MemberVO)(session.getAttribute("user"));
	}
	
	if(user_check == null) {
		PrintWriter write = response.getWriter();
		write.println("<script>alert('로그인이 필요한 페이지입니다'); location.href='login_form.do';"
				+ "</script>");
}
%>
</body>
</html>