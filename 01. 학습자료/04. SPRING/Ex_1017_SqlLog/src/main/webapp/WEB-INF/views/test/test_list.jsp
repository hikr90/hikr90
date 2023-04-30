<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${ pageContext.request.contextPath }/resources/httpRequest.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
	<h1>테스트 목록</h1>
	<table border="1">
		<caption>:: 테스트 화면 ::</caption>
		<tr>
			<th>테스트 순번</th>
			<th>테스트 명칭</th>
			<th>조회순서</th>
			<th>비고</th>
		</tr>
		<c:forEach var="list" items="${ list }">
			<tr>
				<td>${list.test_no}</td>
				<td>${list.test_nm}</td>
				<td>${list.disp_order}</td>
				<td>${list.remark}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>