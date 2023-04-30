<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${ pageContext.request.contextPath }/resources/httpRequest.js"></script>
<script src="${ pageContext.request.contextPath }/resources/jquery-1.12.4.js"></script>
<script type="text/javascript">
	// 로그아웃
	function logout(f) {
		//
		alert("로그아웃에 성공하였습니다.");
		location.href = "test_logout.do";
	}
</script>
</head>
<body>
<form id="form">
	<h1>메인 화면</h1>
	<table border="1">
		<caption>:: 메인 화면 ::</caption>
		<tr>
			<th>아이디</th>
			<td>
				${loginVO.test_id}	
			</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>
				${loginVO.test_pwd}
			</td>
		</tr>
		<tr>
			<th>조회순서</th>
			<td>
				${loginVO.test_nm}
			</td>
		</tr>
		<tr>
			<th>비고</th>
			<td>
				${loginVO.remark}
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" id="btn" name="btn" value="로그아웃" onclick="logout(this.form);" />
			</td>
		</tr>
	</table>
</form>
</body>
</html>