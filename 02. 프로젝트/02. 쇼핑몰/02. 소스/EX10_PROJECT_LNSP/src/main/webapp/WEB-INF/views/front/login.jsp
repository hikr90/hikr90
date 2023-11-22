<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/login.css">
<script>
	function MM_openBrWindow(theURL, winName, features) { //v2.0
		window.open(theURL, winName, features);
	}

	function login() {

		var f = document.ff;
		var id = f.id.value;
		var pwd = f.pwd.value.trim();

		if (id == "") {
			alert("아이디를 입력해야 합니다!");
			return;
		}

		if (pwd == "") {
			alert("비밀번호를 입력해야 합니다!");
			return;
		}

		f.submit();
	}
</script>
</head>
<body>
	<div id="wrap">
		<article>
			<div id="join">
				<img
					src="${pageContext.request.contextPath}/resources/image/login.png"
					width="160" height="60">
			</div>
		</article>
		<div id="form">
			<form method="POST" action="login.do" name="ff">
				<center>

					<table width="500" height="230">
							<tr>
								<th width="192" height="50">아이디
							</tr>
							<tr>
								<td width="180" height="65"><input id="id" name="id"
									placeholder="아이디 입력"></td>
							</tr>
							<tr>
								<th width="192" height="50">비밀번호
							</tr>
							<tr>
								<td width="192" height="65"><input type="password"
									id="password" name="pwd" placeholder="비밀번호 입력"></td>
							</tr>

					</table>
					<div id="loginbutton">
						<img
							src="${pageContext.request.contextPath}/resources/image/loginbutton.png"
							width="500" height="62" onclick="login();" />
					</div>

				</center>
			</form>
		</div>
		<div id="search">
			<div class="searchid">
				<a href="#"
					onClick="MM_openBrWindow('searchID.do','','width=520,height=420')">아이디찾기
				</a>
			</div>
			<div class="searchpw">
				<a href="#"
					onClick="MM_openBrWindow('searchPW.do','','width=520,height=420')"
					value="비밀번호찾기">비밀번호 찾기</a>
			</div>
		</div>


		<!-- <div class="manager">
			<a href="#" onClick="MM_openBrWindow('managerlogin.html','','width=520,height=420')">관리자 로그인</a>
	</div> -->

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
					src="${pageContext.request.contextPath}/resources/image/btn_faq.png"
					width="318" height="164">
			</div>


		</div>
	</div>
	<%@include file="footer.jsp"%>