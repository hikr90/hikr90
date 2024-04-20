<%@page import="dao.SungjukDAO"%>
<%@page import="vo.SungjukVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name2");
	int kor = Integer.parseInt(request.getParameter("kor2"));
	int eng = Integer.parseInt(request.getParameter("eng2"));
	int mat = Integer.parseInt(request.getParameter("mat2"));
	int no = Integer.parseInt(request.getParameter("no"));
	
	// 받아온 파라미터를 vo객체에 저장
	SungjukVO vo = new SungjukVO();
	vo.setName(name);
	vo.setKor(kor);
	vo.setEng(eng);
	vo.setMat(mat);
	vo.setNo(no);
	
	int res = SungjukDAO.getInstance().update(vo);
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