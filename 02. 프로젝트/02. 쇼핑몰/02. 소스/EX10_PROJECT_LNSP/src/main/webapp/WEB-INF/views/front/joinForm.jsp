<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>

<style type="text/css">
a:link {
	text-decoration: none;
}
</style>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/join.css">
<!-- <link rel="stylesheet" type="text/css" -->
<%-- 	href="${pageContext.request.contextPath}/resources/css/menu1.css"> --%>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/httpRequest.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/navmenu.js"></script>
<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	function goPopup() {
		new daum.Postcode({
			oncomplete : function(data) {
				var addr = '';

				if (data.userSelectedType == 'R') {
					addr = data.roadAddress;
				} else {
					addr = data.jibunAddress;
				}

				document.getElementById('zipcode').value = data.zonecode;
				document.getElementById("addr").value = addr;

				document.getElementById("addr").focus();

			}
		}).open();
	}

	var b_idCheck = false;
	
	function signup() {

		var f = document.ff;
		
		if (!b_idCheck) {
			alert("아이디 중복체크를 먼저 하십시오!");
			return;
		}

		var m_id = f.m_id.value;
		var m_pwd = f.m_pwd.value.trim();
		var m_pwdCk = f.m_pwdCk.value.trim();
		var m_name = f.m_name.value;
		var m_birth = f.birth1.value+ '-'+ f.birth2.value+ '-' + f.birth3.value;
		var m_phone = f.hp1.value+'-'+f.hp2.value+'-'+f.hp3.value;
		var oi_detel = f.tel1.value + '-' + f.tel2.value + '-' + f.tel3.value;
		var m_gender = f.m_gender.value;
		var m_addr = f.zipcode.value+ ' ' +f.addr.value+ + ''+ f.address.value;
		var m_email = f.email1.value + '@' + f.email2.value;

		var pwd_pattern = /^[a-zA-Z0-9]{10,15}$/;
		var email_pattern = /^[-A-Za-z0-9_]+[-A-Za-z0-9_.]*[@]{1}[-A-Za-z0-9_]+[-A-Za-z0-9_.]*[.]{1}[A-Za-z]{1,5}$/;

		if (m_id == '') {
			alert("아이디를 입력해야 합니다!");
			document.getElementById('m_id').focus();
			return;
		}

		if (m_pwd == '' || !pwd_pattern.test(m_pwd)|| !pwd_pattern.test(m_pwdCk) || m_pwdCk !== m_pwd) {
			alert("비밀번호를 정확하게 입력하세요!");
			document.getElementById('m_pwd').focus();
			return;
		}
		
		if(m_pwdCk == ''){
			alert("비밀번호를 다시 한번 입력해주세요!");
			document.getElementById('m_pwdCk').focus();
			return;
		}
		
		if(m_name == ''){
			alert("이름을 입력해야 합니다!");
			document.getElementById('m_name').focus();
			return;
		}
		
		if(m_birth == ''){
			alert("생일을 입력해야 합니다!");
			document.getElementById('m_birth').focus();
			return;
		}
		
		if(m_phone == ''){
			alert("휴대폰 번호를 입력해야 합니다!");
			document.getElementById('m_phone').focus();
			return;
		}
		
		if(m_gender == ''){
			alert("성별을 선택하여 주세요!");
			return;
		}
		
		if(m_addr == ''){
			alert("주소를 입력해야 합니다!");
			document.getElementById('m_addr').focus();
			return;
		}
		
		if(m_email == '' || !email_pattern.test(m_email)){
			alert("이메일을 입력해야 합니다!");
			document.getElementById('m_email').focus();
			return;
		}
		
		alert("회원 가입 성공하셨습니다!");
		
		f.submit();
	}
	
	//아이디 중복체크를 위한 함수
	function check_id() {

		var m_id = document.getElementById("m_id").value.trim();

		if (m_id == '') {
			alert("아이디를 입력하세요!");
			m_id.focus();
			return;
		}

		//Ajax를 통해 id를 서버로 전송
		var url = "check_id.do";

		//encodeURIComponent : 파라미터로 전송하고자 하는 값에
		//@, #등 특수문자가 포함되어 있어도 정상전달하기 위한 인코딩 메서드
		var param = "m_id=" + encodeURIComponent(m_id);
	
		sendRequest(url, param, resultFn, "POST");
	}

	function resultFn() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			
			//서버로 부터 도착한 데이터
			var data = xhr.responseText;
			
			var json = eval(data);
			
			
			if( json[0].result == 'no' ){
				alert(json[1].m_id + "은 이미 사용 중입니다!");
				return;
			}
			
			alert(json[1].m_id + "은(는) 사용 가능합니다!");
			b_idCheck = true;
			
			//사용가능한 아이디라면 readOnly처리
			document.getElementById("m_id").readOnly = true;
		}
	}
</script>
</head>

<body>
<body>
	<div id="wrap">
		<section>
			<article>
				<div id="join">
					<img
						src="${pageContext.request.contextPath}/resources/image/join.png"
						width="160" height="60">
				</div>
			</article>

			<div>
				<center>
					<form method="POST" action="signup.do" name="ff">
						<p>&nbsp;</p>

						<table width="980" height="640" border="0" cellpadding="10">

							<thead>

								<tr>
									<th width="173" height="80">ID*</th>
									<td width="683" class="sub"><input type="text" id="m_id"
										name="m_id"> <img
										src="${pageContext.request.contextPath}/resources/image/check.gif"
										value="아이디중복" onclick="check_id();"></td>
								</tr>
								<tr>
									<th width="173" height="80">비밀번호*</th>
									<td><input type="password" name="m_pwd" id="m_pwd" size="30">
										<span class="sub"> 10~15자 영문 대 소문자, 숫자만 사용하세요.</span></td>
								</tr>
								<tr>
									<th width="173" height="80">비밀번호 확인</th>
									<td><input type="password" id="m_pwdCk" name="m_pwdCk"
										size="30"></td>
								</tr>
								<tr>
									<th width="173" height="80">이름*</th>
									<td><input type="text" id="m_name" name="m_name" size="21"></td>
								</tr>
								<tr>
									<th width="173" height="80">생년월일*</th>
									<td><input type="text" name="birth1" id="m_birth"
										size="4">년 &nbsp; <input type="text" name="birth2"
										id="birth2" size="4">월 &nbsp; <input type="text"
										name="birth3" id="birthDay" size="4">일 &nbsp;&nbsp;</td>
								</tr>
								<tr>
									<th width="173" height="80">휴대폰 번호*</th>
									<td><input type="text" id="m_phone" name="hp1" size="5">-
										<input type="text" id="hp2" name="hp2" size="5">- <input
										type="text" id="hp3" name="hp3" size="5"></td>
								</tr>
								<th width="182" scope="row">전화번호</th>
								<td><input type="text" id="tel1" name="tel1" size="4">
									- <input type="text" id="tel2" name="tel2" size="4"> -
									<input type="text" id="tel3" name="tel3" size="4"></td>
								<tr>
									<th width="173" height="80">성별*</th>
									<td><input type="radio" id="woman" name="m_gender"
										value="여">여성 &nbsp; <input type="radio" id="man"
										name="m_gender" value="남"> 남성</td>
								</tr>
								<tr>
									<th width="173" height="80">주소*</th>
									<td><input id="zipcode" name="zipcode"> <img
										src="${pageContext.request.contextPath}/resources/image/postaddress.png"
										value="우편번호찾기" onclick="javascript:goPopup();"><br>
										<input id="addr" name="addr" size="35"> <input
										id="m_addr" name="address" size="40"> <span
										class="sub">상세 주소 입력</span></td>
								</tr>
								<tr>
									<th width="173" height="80">E-mail*</th>
									<td><input name="email1" id="m_email" size="15"> @
										<select id="email2" name="email2">
											<option value="naver.com" selected>naver.com
											<option value="hanmail.net">hanmail.net
											<option value="gmail.com">gmail.com
											<option value="nate.com">nate.com
									</select></td>
								</tr>

							</thead>

						</table>
						<p>&nbsp;</p>
						<p>
							<span class="update"><img
								src="${pageContext.request.contextPath}/resources/image/register.png"
								onclick="signup();" /></span>
						</p>


					</form>
				</center>
			</div>

			<article>
				<div id="customer">
					<div class="custmer1">
						<ul>
							<span class="notice">NOTICE</span>
							<br>
							<br>

							<li><a href="#">[공지] 2020년 설 연휴 기간 배송 안내</a></li>
							<li><a href="#">[공지] 2019년 추석 연휴 배송 안내</a></li>
							<li><a href="#">[공지] 2019년 설 연휴 기간 배송 안내</a></li>
							<li><a href="#">[공지] 2018 추석 연휴 배송 안내</a></li>
						</ul>
					</div>
					<div class="custmer2">
						CUSTOMER CENTER <br> <br> <span class="question">매장문의/
							AS문의 : 02-111-3243 <br> 실시간 상담 문의 : 02-435-4342
						</span>
					</div>
					<div class="custmer3">
						<img
							src="${pageContext.request.contextPath}/resources/image/btn_faq.png">
					</div>


				</div>
			</article>
		</section>
	</div>
	<%@include file="footer.jsp"%>