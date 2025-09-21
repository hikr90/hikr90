<%@page import="vo.SungjukVO"%>
<%@page import="java.util.List"%>
<%@page import="dao.SungjukDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%	
	request.setCharacterEncoding("utf-8");
	//
	String name = request.getParameter("name");
	int kor = Integer.parseInt(request.getParameter("kor"));
	int eng = Integer.parseInt(request.getParameter("eng"));
	int mat = Integer.parseInt(request.getParameter("mat"));
	
	// VO 객체에 저장
	SungjukVO vo = new SungjukVO();
	vo.setName(name);
	vo.setKor(kor);
	vo.setEng(eng);
	vo.setMat(mat);
	// 인서트 작업 동작
	SungjukDAO.getInstance().insert(vo);
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