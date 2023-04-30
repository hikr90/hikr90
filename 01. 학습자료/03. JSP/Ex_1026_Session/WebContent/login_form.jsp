<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="js/httpRequest.js"></script>
		
		<script type="text/javascript">
			function send(f) {
				var id = f.id.value;
				var pwd = f.pwd.value;
				
				if(id==""){
					alert("아이디를 입력하세요.");
					return;
				}
				
				if(pwd==""){
					alert("비밀번호를 입력하세요.");
					return;
				}
				
				var url = "login.do";
				// ajax으로 두가지의 파라미터를 보내는 방법
				var param = "id="+encodeURIComponent(id) + "&pwd="+encodeURIComponent(pwd);
				
				
				sendRequest(url,param,resultFn,"POST");	
				
			}
			
			function resultFn() {
				if(xhr.readyState==4 && xhr.status==200){
					
					var data = xhr.responseText;
					var json = eval(data);
					
					if(json[0].param=='no_id'){
						alert("아이디가 없습니다.");
					}else if(json[0].param=='no_pwd'){
						alert("비밀번호가 틀렸습니다.");							
					}else{
						alert("환영합니다.");
						location.href="main_content.jsp";
					}
				}
			}
		</script>		
	</head>
	<body>
		
		<form>
			<table border="1" align="center">
				<caption>::로그인 페이지::</caption>
				<tr>
					<th>아이디</th>
					<td>
						<!-- placeholder : 입력상자에 처음에 나타나는 설명 문자 -->
						<input name="id" placeholder="아이디를 입력해야합니다.">
					</td>
				</tr>

				<tr>
					<th>비밀번호</th>
					<td>
						<!-- placeholder : 입력상자에 처음에 나타나는 설명 문자 -->
						<input type="password" name="pwd" placeholder="비밀번호를 입력해야합니다.">
					</td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
						<input type="button" value="로그인" onclick="send(this.form);">
						<!-- reset은 버튼을 눌렀을 시 폼 태그안의 모든 입력상자의 값을 초기화 시킨다. -->
						<input type="reset" value="취소">
					</td>
				</tr>
				
			</table>
		</form>
			
	</body>
</html>