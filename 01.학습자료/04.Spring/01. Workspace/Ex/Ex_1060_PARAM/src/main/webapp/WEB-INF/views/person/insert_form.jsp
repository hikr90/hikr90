<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	// 유효성 검증
	function validation(){
		//
		var name = document.getElementById("name").value;
		var age = document.getElementById("age").value;
		var tel = document.getElementById("tel").value;
		//
		var chkYn = true;
		
		// 0 ~ 9의 숫자 세자리
		var pattern = /^[0-9]{1,3}$/;
		//
		if(name==""){
			alert("이름을 입력해주세요.");
			chkYn = false;
		}
		if(age==""){
			alert("나이를 입력해주세요.");
			chkYn = false;
		}
		if(tel==""){
			alert("전화번호를 입력해주세요.");
			chkYn = false;
		}
		
		// 정규식.test(값)은 정규식을 체크하는 메소드이다.
		// 통과하는 경우 참, 위반하는 경우 거짓을 반환한다.
		if(!pattern.test(age)){
			alert("나이는 정수로 두자리까지만 가능합니다.");
			chkYn = false;
		}
		//
		return chkYn;
	}
	
	// 파라미터 낱개로 보내기
	function send1(f) {
		//
		if(!validation(f)) return;
		//
		f.action = "insert1.do";
		f.submit();
	}
	
	// VO 객체로 보내기
	function send2(f) {
		//
		if(!validation()) return;
		//
		f.action = "insert2.do";
		f.submit();
	}
	
	// HashMap으로 보내기
	function send3(f) {
		//
		if(!validation()) return;
		//
		f.action = "insert3.do";
		f.submit();
	}
</script>
</head>
<body>
	<form>
		<table border="1" align="center">
			<caption>::정보 입력::</caption>
			<tr>
				<th>이름</th>
				<td><input id="name" name="name"></td>
			</tr>
			<tr>
				<th>나이</th>
				<td><input id="age" name="age"></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input id="tel" name="tel"></td>
			</tr>
			<tr>
				<td colspan="3" align="center">
					<input type="button" value="PARAMTER" onclick="send1(this.form);">
					<input type="button" value="VO" onclick="send2(this.form);">
					<input type="button" value="HASHMAP" onclick="send3(this.form);">
				</td>
			</tr>		
		</table>
	</form>
</body>
</html>