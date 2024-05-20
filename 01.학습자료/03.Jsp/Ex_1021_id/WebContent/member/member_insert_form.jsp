<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	
	<script src="../js/httpRequest.js"></script>
	<script type="text/javascript">
		var b_idCheck = false;
		// 전송		
		function send(f) {
			//
			var name = f.name.value;
			var id = f.id.value;
			var pwd = f.pwd.value;
			var email = f.email.value;
			var addr = f.addr.value;
			//			
			var pwd_pattern = /^[0-9]+$/;
			var email_pattern = /^[-A-Za-z0-9_]+[-A-Za-z0-9_.]*[@]{1}[-A-Za-z0-9_]+[-A-Za-z0-9_.]*[.]{1}[A-Za-z]{1,5}$/;
			//
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
			//
			f.action = "insert.do";
			f.method = "POST";
			
			// 중복체크가 한 뒤에 가입이 가능하도록 해야한다.
			if(!b_idCheck){
				alert("아이디 중복확인을 해주세요.");
				return;
			}
			//			
			f.submit();
		}
		
		// 아이디 중복 체크
		function check_id() {
			// 
			var id = document.getElementById("id").value.trim();
			//			
			if(id==''){
				alert("아이디를 입력해주세요.");
				return;
			}
			
			/* encodeURIComponent
				- 파라미터로 전송하고자하는 값에 @, #등 특수문자가 포함되어있어도 전달하기위한 인코딩 메소드
			*/
			var url = "check_id.do"
			var param = "id="+ encodeURIComponent(id);
			//			
			sendRequest(url,param,resultFn,"POST");
		}
		
		// 콜백 메소드
		function resultFn() {
			//			
			if(xhr.readyState==4 && xhr.status==200){
				var data = xhr.responseText;
				var json = eval(data);	// eval : Json형태로 받아온 String을 Json형태로 변환
				//				
				if(json[0].result=='no'){
					alert(json[1].id+"는 이미 사용중인 아이디입니다.");
					return;
				}
				//
				alert(json[1].id+"는 사용가능합니다.");
				b_idCheck = true;
				
				// 수정할 수 없도록 readOnly 속성 변경
				document.getElementById("id").readOnly = true;
			}
		}
	</script>
	
	</head>
	<body>
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