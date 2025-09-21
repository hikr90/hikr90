<%@page import="dao.SungjukDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%	
	request.setCharacterEncoding("utf-8");
	//	요청 객체 내의 값을 받아온다.
	int no = Integer.parseInt(request.getParameter("no"));
	int res = SungjukDAO.getInstance().delete(no);	// 삭제 메소드 (지운 행의 수를 반환한다.)
	
	// sendRedirect
	// 	- 특정 화면 혹은 주소로 이동하는 방식
	//	- html에서 location.href를 사용한다면 자바에서는 sendRedirect를 사용한다.
	response.sendRedirect("jdbc_Sungjuk.jsp");
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