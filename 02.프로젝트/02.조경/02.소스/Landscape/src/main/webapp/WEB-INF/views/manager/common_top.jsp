<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common_logincheck.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/resources/js/httpRequest.js"></script>
<script type="text/javascript">
	function logout() {

		var url = "logout.do";

		sendRequest(url, null, resultFn, "POST");

	}
	function resultFn() {
		if (xhr.readyState == 4 && xhr.status == 200) {

			var data = xhr.responseText;
			var json = eval(data);

			if (json[0].result == 'yes') {
				alert("로그아웃 성공");
			} else {
				alert("로그아웃 실패");
			}

			location.href = "index.do";
		}
	}
</script>
</head>
<body>

<div id="top">
	<div id="toplogo">
		<a href="manager.do"><img
			src="${pageContext.request.contextPath}/resources/image/landscape.png"
			width="162" height="50"></a>
	</div>
	<div id="logout"><a href="javascript:logout();">로그아웃</a></div>
	<div id="login">
		<a href="index.do">메인페이지 바로가기</a> | <%-- <%if(user_check != null){ %><%=user_check.getM_name() %><% } %> --%> 님 &nbsp;
	</div>
</div>
</body>
</html>