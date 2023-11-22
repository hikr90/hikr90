<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 확인창</title>
<style>
.modal_wrap {
	display: none;
	width: 500px;
	height: 500px;
	position: absolute;
	top: 50%;
	left: 50%;
	margin: -250px 0 0 -250px;
	background: #eee;
	z-index: 2;
}

.black_bg {
	display: none;
	position: absolute;
	content: "";
	width: 100%;
	height: 100%;
	background-color: rgba(0, 0, 0, 0.5);
	top: 0;
	left: 0;
	z-index: 1;
}

.modal_close {
	width: 26px;
	height: 26px;
	position: absolute;
	top: -30px;
	right: 0;
}

.modal_close>a {
	display: block;
	width: 100%;
	height: 100%;
	background: url(https://img.icons8.com/metro/26/000000/close-window.png);
	text-indent: -9999px;
}

 .btnArea{
	text-align: center;
}
</style>
<script>
window.onload = function() {

    document.querySelector('.modal_wrap').style.display ='block';
    document.querySelector('.black_bg').style.display ='block';
	document.querySelector('.modal_close').addEventListener('click', offClick);
  
function offClick() {
    document.querySelector('.modal_wrap').style.display ='none';
    document.querySelector('.black_bg').style.display ='none';
}


};

	function updateMember_form() {

		var f = document.ff;

		var m_pwd = f.m_pwd.value.trim();
		var m_pwdCk = f.m_pwdCk.value.trim();
		var origin_pwd = f.origin_pwd.value.trim();

		console.log(m_pwd);
		console.log(m_pwdCk);
		console.log(origin_pwd);
		
		if (m_pwd !== origin_pwd || m_pwdCk !== m_pwd) {
			alert("비밀번호를 정확하게 입력하세요!");
			document.getElementById('m_pwd').focus();
			return;
		}

		if (m_pwdCk == '' || m_pwd == '' ) {
			alert("비밀번호를 다시 한번 입력해주세요!");
			document.getElementById('m_pwd').focus();
			return;
		}

		alert("수정 페이지로 이동합니다");
		
		f.action="updateMember_form.do";
		f.method="POST";		
		f.submit();
	}
</script>
</head>
<body>
	<form name="ff">
	<input type="hidden" name="origin_pwd" value="${vo.m_pwd }">
		<!-- 		<button type='button' id="modal_btn">비밀번호 확인</button> -->
		<div class="black_bg"></div>
		<div class="modal_wrap">
			<!-- 			<div class="modal_close"> -->
			<!-- 				<a href="mypage.do">close</a> -->
			<!-- 			</div> -->
			<div>
				<table width="980" height="640" border="0" cellpadding="10">
					<thead>
						<tr>
							<th width="173" height="80">비밀번호</th>
							<td><input type="password" id="m_pwd" name="m_pwd" size="30"></td>
						</tr>
						<tr>
							<th width="173" height="80">비밀번호 확인</th>
							<td><input type="password" id="m_pwdCk" name="m_pwdCk" size="30"></td>
						</tr>
					</thead>
				</table>
			</div>
			<div class="btnArea">
				<a class="btn" id="modal_btn" href="javascript:updateMember_form();">이동</a>
				<a class="btn" id="modal_btn" href="mypage.do">취소</a>
			</div>
		</div>
	</form>
</body>
</html>