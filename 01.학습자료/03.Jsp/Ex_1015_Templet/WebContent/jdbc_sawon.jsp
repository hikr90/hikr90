<%@page import="vo.SawonVO"%>
<%@page import="java.util.List"%>
<%@page import="dao.SawonDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	SawonDAO s_dao = SawonDAO.getInstance();
	List<SawonVO> sawon_list = s_dao.selectList();
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		
		<table border="1">
			<caption>사원목록</caption>
			<tr>
				<th>사번</th>
				<th>사원이름</th>
				<th>부서번호</th>
				<th>급여</th>
			</tr>
			<%for(int i=0;i<sawon_list.size();i++){ 
				SawonVO vo = sawon_list.get(i);
			%>
				<tr>
					<td><%=vo.getSabun()%></td>
					<td><%=vo.getSaname()%></td>
					<td><%=vo.getDeptno()%></td>
					<td><%=vo.getSapay()%></td>
				</tr>
			<% } %>
		</table>
	</body>
</html>