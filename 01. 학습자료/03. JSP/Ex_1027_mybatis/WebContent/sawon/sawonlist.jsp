<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript">
		function find() {
			var deptno = document.getElementById("deptno").value;
			// 서버로 DEPTNO 전송 
			location.href="sawonlist.do?deptno="+deptno;
		}
	</script>
	</head>
	<body>
		<div align="center">
			부서번호 : 
			<select id="deptno">
				<option value="0">부서를 선택하십시오.</option>
				<option value="10">총무부</option>
				<option value="20">영엽부</option>
				<option value="30">전산실</option>
				<option value="40">관리부</option>
				<option value="50">경리부</option>
			</select>
			
			<input type="button" value="검색" onclick="find();">
		</div>
	
		<table border="1" align="center">
			<caption>::사원 테이블::</caption>
			<tr>
				<th>사번</th>
				<th>이름</th>
				<th>성별</th>
				<th>부서번호</th>
				<th>직책</th>
				<th>입사일</th>
				<th>상사번호</th>
				<th>급여</th>
			</tr>
			
			<c:forEach var="vo" items="${ list }">
				<tr>
					<td>${ vo.sabun }</td>
					<td>${ vo.saname }</td>
					<td>${ vo.sagen }</td>
					<td>${ vo.deptno }</td>
					<td>${ vo.sajob }</td>
					<td>${ vo.sahire }</td>
					<td>${ vo.samgr }</td>
					<td>${ vo.sapay }</td>
				</tr>
			</c:forEach>
		</table>	
	</body>
</html>