<%@page import="vo.SungjukVO"%>
<%@page import="java.util.List"%>
<%@page import="dao.SungjukDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%	// tip : VO클래스가 수정된 경우, 
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	int kor = Integer.parseInt(request.getParameter("kor"));
	int eng = Integer.parseInt(request.getParameter("eng"));
	int mat = Integer.parseInt(request.getParameter("mat"));
	
	// 받아온 파라미터를 vo객체에 저장
	SungjukVO vo = new SungjukVO();
	vo.setName(name);
	vo.setKor(kor);
	vo.setEng(eng);
	vo.setMat(mat);
	
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