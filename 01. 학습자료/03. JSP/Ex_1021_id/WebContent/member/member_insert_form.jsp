<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	
	<!-- ajax사용할 스크립트 -->
	<script src="../js/httpRequest.js"></script>
	
	<script type="text/javascript">
		var b_idCheck = false;
		
		function send(f) {
			//유효성 체크(나중에 하자)
			var name = f.name.value;
			var id = f.id.value;
			var pwd = f.pwd.value;
			var email = f.email.value;
			var addr = f.addr.value;
			
			var pwd_pattern = /^[0-9]+$/;
			var email_pattern = /^[-A-Za-z0-9_]+[-A-Za-z0-9_.]*[@]{1}[-A-Za-z0-9_]+[-A-Za-z0-9_.]*[.]{1}[A-Za-z]{1,5}$/;
			
			if(name==""){
				alert("이름을 입력해주세요.");
				return;
			}
			if(id==""){
				alert("아이디를 입력해주세요.");
				return;
			}
			if(pwd==""){
				alert("비밀번호를 입력해주세요.");
				return;
			}
			if(!pwd_pattern.test(pwd)){
				alert("비밀번호는 숫자만 가능합니다.");
				return;
			}
			if(!email_pattern.test(email)){
				alert("이메일 형식에 맞지 않습니다.");
				return;
			}
			
			f.action = "insert.do";
			f.method = "POST";
			
			// 중복체크가 한 뒤에 가입이 가능하도록 해야한다.
			if(!b_idCheck){//b_idCheck == false
				alert("아이디 중복확인을 해주세요.");
				return;
			}
			
			f.submit();
		}
		
		// 아이디 중복체크를 위한 함수
		function check_id() {
			
			// select는 반환되는 것이 없으므로 selectone으로 중복되는 아이디가 있는지 확인해야한다. (파라미터에 f.id해도 상관없다.)
			var id = document.getElementById("id").value.trim();
			
			if(id==''){
				alert("아이디를 입력해주세요.");
				return;
			}
			
			// 반환값에따라서 중복여부를 알려줘야하기 때문에 id를 보내고 결과 값을 받아야한다.
			// 즉 ajax를 사용하여 id를 서버로 전송해야한다.
			var url = "check_id.do"
			// encodeURIComponent 파라미터로 전송하고하자는 값에 @,#등 특수문자가 포함되어있어도 정상전달하기 위한 인코딩 메서드
			var param = "id="+ encodeURIComponent(id); // ?id=id명칭;
			
			sendRequest(url,param,resultFn,"POST");
		}
		
		function resultFn() {
			
			if(xhr.readyState==4 && xhr.status==200){
				// [{'result':'%s'},{'id':'%s'}] 이 문자열로 넘어옴
				var data = xhr.responseText;
				// [{'result':'%s'},{'id':'%s'}]의 json형태로 해준다.
				var json = eval(data);
				
				if(json[0].result=='no'){
					alert(json[1].id+"는 이미 사용중인 아이디입니다.");
					return;
				}
				
				alert(json[1].id+"는 사용가능합니다.");
				b_idCheck = true;
				
				// readOnly : 아이디가 중복되지 않는 경우 아이디는 수정이 안되는 상태가 된다.
				document.getElementById("id").readOnly = true;
				
				
			}
		}
		
	</script>
	
	</head>
	<body>
		
		<!-- db로 다시 insert될 내용이기에 다시 보낼 수 있도록 form태그로 묶어야한다. -->
		<form>
			<table border="1" align="center">
				<caption>::회원 가입::</caption>
				<tr>
					<th>아이디</th>
					<td>
						<input name="id" id="id">
						<input type="button" value="중복체크" onclick="check_id();">
					</td>
				</tr>
				
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="password" name="pwd">
					</td>
				</tr>

				<tr>
					<th>이름</th>
					<td>
						<input name="name">
					</td>
				</tr>
				
				<tr>
					<th>이메일</th>
					<td>
						<input name="email">
					</td>
				</tr>

				<tr>
					<th>주소</th>
					<td >
						<input name="addr">
					</td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
						<input type="button" value="가입" onclick="send(this.form);">
						<!-- 취소로 돌아갈 때는 jsp가 아닌 do로 가야한다. jsp는 단지 request영역에 있는 list를 출력만했을 뿐이고 list가 없기에 데이터가 안나온다. -->
						<input type="button" value="취소" onclick="location.href='member_list.do'">
					</td>
				</tr>
				
				
			</table>
		</form>
		
	</body>
</html>