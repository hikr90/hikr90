<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="/WEB-INF/views/include/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IslandScape</title>
<style type="text/css">
a:link {
	text-decoration: none;
}
</style>
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
	
	function updateMember() {

		var f = document.ff;
		
		var m_pwd = f.m_pwd.value.trim();
		var m_pwdCk = f.m_pwdCk.value.trim();
		var m_phone = f.hp1.value+'-'+f.hp2.value+'-'+f.hp3.value;
		var m_addr = f.zipcode.value+ ' ' +f.addr.value+ + ''+ f.address.value;
		var m_email = f.email1.value + '@' + f.email2.value;

		var pwd_pattern = /^[a-zA-Z0-9]{10,15}$/;
		var email_pattern = /^[-A-Za-z0-9_]+[-A-Za-z0-9_.]*[@]{1}[-A-Za-z0-9_]+[-A-Za-z0-9_.]*[.]{1}[A-Za-z]{1,5}$/;

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

		if(m_phone == ''){
			alert("휴대폰 번호를 입력해야 합니다!");
			document.getElementById('m_phone').focus();
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
		
		alert("수정 성공!");
		
		f.submit();
	}
</script>

<link
	href="${ pageContext.request.contextPath }/resources/css/updateMember.css"
	rel="stylesheet" type="text/css">
<link
	href="${ pageContext.request.contextPath }/resources/css/menu1.css"
	rel="stylesheet" type="text/css">
<script
	src="${ pageContext.request.contextPath }/resources/js/jquery-3.2.1.min.js"></script>
<script src="${ pageContext.request.contextPath }/resources/js/index.js"></script>
<script
	src="${ pageContext.request.contextPath }/resources/js/navmenu.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/httpRequest.js"></script>
<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<div id="objectbanner">
	<div id="bannertxt">마이페이지</div>
	<img
		src="${pageContext.request.contextPath}/resources/image/mypage.png">
</div>
<div id="wrap">
	<jsp:include page="mypage_submenu.jsp"></jsp:include>

	<div id="update">
		<form id="ljiForm" name="ff" action="update_memberInfo.do"
			method="POST">
			<h2 style="font-size: 28px">회원정보 수정</h2>
			<p>&nbsp;</p>

			<p>* 고객님의 주소와 연락처 등 개인정보를 수정하실 수 있습니다.</p>
			<p>* 휴대전화번호와 이메일은 한번 더 확인하시어, 주문하신 상품에 대한 배송 안내와 다양한 이벤트정보를 제공해
				드리는 SMS,</p>
			<p>메일서비스 혜택을 받으시기 바랍니다.</p>
			<p>&nbsp;</p>
			<table width="980" height="640" border="0" cellpadding="10">

				<thead>

					<tr>
						<th width="173" height="80">ID</th>
						<td width="683">${vo.m_id}</td>
					</tr>
					<tr>
						<th width="173" height="80">비밀번호</th>
						<td><input type="password" id="m_pwd" name="m_pwd" size="30"><span
							class="sub"> 10~15자 영문 대 소문자, 숫자만 사용하세요.</span></td>
					</tr>
					<tr>
						<th width="173" height="80">비밀번호 확인</th>
						<td><input type="password" id="m_pwdCk" name="m_pwdCk"
							size="30"></td>
					</tr>
					<tr>
						<th width="173" height="80">이름</th>
						<td>${vo.m_name }</td>
					</tr>
					<tr>
						<th width="173" height="80">생년월일</th>
						<td>${vo.m_birth }</td>
					</tr>

					<tr>
						<th width="173" height="80">휴대폰 번호</th>
						<td><input type="text" id="m_phone" name="hp1" size="4">
							- <input type="text" id="hp2" name="hp2" size="4"> - <input
							type="text" id="hp3" name="hp3" size="4"></td>
					</tr>
					<tr>
						<th width="173" height="80">성별</th>
						<td>${vo.m_gender }</td>
					</tr>
					<tr>
						<th width="173" height="80">주소</th>
						<td><input id="zipcode" name="zipcode"> <img
							src="${pageContext.request.contextPath}/resources/image/postaddress.png"
							value="우편번호찾기" onclick="javascript:goPopup();"><br> <input
							id="addr" name="addr" size="35"> <input id="m_addr"
							name="address" size="40"> <span class="sub">상세 주소
								입력</span></td>
					</tr>
					<tr>
						<th width="173" height="80">E-mail</th>
						<td><input type="text" id="m_email" name="email1" size="15">@
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
					src="${ pageContext.request.contextPath }/resources/image/update.png"
					alt="" onclick="updateMember();" /></span>
			</p>


		</form>
	</div>

</div>
<%@include file="/WEB-INF/views/include/footer.jsp"%>