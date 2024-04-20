<%@page import="dao.SungjukDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%	
	request.setCharacterEncoding("utf-8");
	
 	// delete에 해당하는 자료형에 맞게 파라미터를 가지고 오자
	int no = Integer.parseInt(request.getParameter("no"));
	
 	// 삭제 (잘 지웠으면 1, 못지웠으면 0으로 반환)
	int res = SungjukDAO.getInstance().delete(no);
	
	// 자바코드로 화면 전환하는 방법 (html의 경우에는 location)
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