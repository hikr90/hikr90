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
	//
	function login(f){
		//
		var param = $("#form").serialize() ;
		$.ajax({
			type: "post",
			async: false,
			url: "test_check.do",
			data: param,
			success: function(data){
				//
				var json = eval(data);
				var res = json[0].res;
				//
				if(res=="YES"){
					//
					alert("로그인에 성공했습니다.");
					location.href = "test_main.do";
					
				}else if(res=="NO_ID"){
					//
					alert("아이디가 없습니다.");
				}else{
					//
					alert("비밀번호가 틀렸습니다.");
				}
				
			},
			error: function(data){
				alert("로그인에 실패했습니다.");
			}
		});
	}
</script>
</head>
<body>
<form id="form">
	<h1>로그인 화면</h1>
	<table border="1">
		<caption>:: 로그인 ::</caption>
		<tr>
			<th>아이디</th>
			<td>
				<input type="text" id="test_id" name="test_id" value="" />
			</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>
				<input type="text" id="test_pwd" name="test_pwd" value="" />			
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" id="btn" name="btn" value="로그인" onclick="login(this.form);" />
			</td>
		</tr>
	</table>
</form>
</body>
</html>