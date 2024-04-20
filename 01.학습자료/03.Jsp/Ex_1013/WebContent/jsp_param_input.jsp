<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 


%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
		<script type="text/javascript">
			function send(f) {
				var id = f.id.value.trim();
				var pwd = f.pwd.value.trim();
				var age = f.age.value.trim();
				
				if(id==""){
					alert("아이디를 입력해주세요.");
					return;
				}
				
				if(pwd==""){
					alert("비밀번호를 입력해주세요.");
					return;
				}
				if(age==""){
					alert("나이를 입력해주세요.");
					return;
				}
				
				// 파라미터를 전달할 페이지
				f.action = "result_input.jsp";
				// POST인 경우, 전송데이터를 한글로 보내면 글자가 깨진다.
				f.method = "POST";
				f.submit();
			}
		</script>
		
	</head>
	<body>
		
		<form>
			ID : <input name="id" type="text"><br>
			PWD : <input name="pwd" type="password"><br>
			AGE : <input name="age" type="text"><br>
			
			<input type="button" value="파라미터 전달" onclick="send(this.form)">
		</form>
			
	</body>
</html>