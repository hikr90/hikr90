<%@page import="java.util.ArrayList"%>
<%@page import="vo.SawonVO"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	//
	InitialContext ic = new InitialContext();
	Context ctx = (Context)ic.lookup("java:comp/env");
	DataSource ds = (DataSource)ctx.lookup("jdbc/oracle_test");
	Connection conn = ds.getConnection();
	//
	String deptno = request.getParameter("deptno");
	
	// 쿼리문 작성
	String sql = "select deptno, sabun, sajob, saname from SAWON where deptno = "+deptno;
	PreparedStatement pstmt = conn.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery();
	List<SawonVO> sawon_list = new ArrayList();
	//	
	while(rs.next()){
		SawonVO vo = new SawonVO();
		vo.setDeptno(rs.getInt("deptno"));
		vo.setSabun(rs.getInt("sabun"));
		vo.setSajob(rs.getString("sajob"));
		vo.setSaname(rs.getString("saname"));
		//
		sawon_list.add(vo);
	}
	//
	rs.close();
	pstmt.close();
	conn.close();
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	
	<style type="text/css">
		table{border-collapse: collapse;}
	</style>
	</head>
	<body>
		<table border="1">
			<caption>::부서 인원::</caption>
			<tr>
				<th>부서번호</th>
				<th>사번</th>
				<th>직책</th>
				<th>성함</th>
			</tr>
			
				<%
				for(int i=0;i<sawon_list.size();i++){ 
					SawonVO sv = sawon_list.get(i);
				%>
				<tr>
				<td><%=sv.getDeptno() %></td>
				<td><%=sv.getSabun() %></td>
				<td><%=sv.getSajob() %></td>
				<td><%=sv.getSaname() %></td>
				</tr>
			<% } %>
		</table>	
	</body>
</html>