<%@page import="java.io.PrintWriter"%>
<%@page import="com.pipt.vo.MemberVO"%>
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
	
	/* if(user_check == null || !user_check.getM_id().equals("admin")) {
		PrintWriter write = response.getWriter();
		write.println("<script>alert('관리자만 접속가능한 화면입니다'); location.href='piptMainInqy1010.do';"
				+ "</script>");
} */
%>
</body>
</html>