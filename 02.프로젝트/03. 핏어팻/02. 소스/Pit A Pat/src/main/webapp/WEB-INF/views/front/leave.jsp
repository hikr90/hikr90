<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="/WEB-INF/views/include/pipt_include_1020.jsp"%>
<link
	href="${pageContext.request.contextPath}/resources/css/leave.css"
	rel="stylesheet" type="text/css">
<html>
<head>
<script src="${pageContext.request.contextPath}/resources/js/httpRequest.js"></script>
<script type="text/javascript">
	function button_action() {
		var f = document.ff;
		var id = f.id.value;
		var pwd = f.password.value;
		var hp1 = f.hp1.value;
		var hp2 = f.hp2.value;
		var hp3 = f.hp3.value;
		
		// null 체크
		if(id == ""){
			alert('아이디를 입력하세요');
			return;
		}
		if(pwd == ""){
			alert('비밀번호를 입력하세요');
			return;
		}
		if(hp1 == ""){
			alert('연락처를 입력하세요');
			return;
		}
		if(hp2 == ""){
			alert('연락처를 입력하세요');
			return;
		}
		if(hp3 == ""){
			alert('연락처를 입력하세요');
			return;
		}
		
		if(!confirm('회원탈퇴하면 이후 이 계정을 사용할 수 없게 됩니다. 정말 탈퇴하시겠습니까?')){
			return;
		}
		if(!confirm('정말 탈퇴하시겠습니까?')){
			return;
		}
		
		var url = "mypage_leave_action.do";
		var param = "id=" + id + "&pwd=" + pwd + "&tel1=" + hp1 + "&tel2=" + hp2 + "&tel3=" + hp3; 
		
		sendRequest(url, param, resultFn, "POST");
	}
	function resultFn() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			
			//서버로 부터 도착한 데이터
			var data = xhr.responseText;
			
			var json = eval(data);
			
			if( json[0].result == 'no' ){
				alert('입력하신 회원정보가 일치하지 않습니다!');
				return;
			}
			
			alert('정상 회원탈퇴 되었습니다');
			location.href='piptMainInqy1010.do';
		}
	}
</script>
</head>
<body>
	<div id="objectbanner">
		<div id="bannertxt">마이페이지</div>
		<img
			src="${pageContext.request.contextPath}/resources/image/mypage.png">
	</div>

	<div id="wrap">
		<jsp:include page="mypage_submenu.jsp"></jsp:include>

		<div id="leave">
			<div id="leaveform">
				<h2 style="font-size: 28px">회원 탈퇴</h2>
				<p>&nbsp;</p>

				<p>* 회원탈퇴 시 고객님의 정보는 상품 반품 및 A/S를 위해 전자상거래 등에서의 소비자 보호에 관한 법률에
					의거한</p>
				<p>고객정보 보호정책에 따라 관리됩니다.</p>
				<p>* 한 번 탈퇴한 아이디는 다시 사용할 수 없습니다.</p>

				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<h2 style="font-size: 24px">본인 확인</h2>
				<p>&nbsp;</p>
				<form name="ff">
				<table width="980" height="240" border="0" cellpadding="10"
					cellspacing="0">

					<tbody>
						<tr>
							<th width="140" height="80" scope="row">아이디</th>
							<td width="469"><input type="text" name="id" id="id"></td>
						</tr>

						<tr>
							<th width="141" height="80" scope="row">비밀번호</th>
							<td><input type="password" name="password" id="password"></td>
						<tr>
							<th width="141" height="80" scope="row">본인 확인</th>
							<td colspan="3"><p>
									<input type="text" name="hp1" id="hp1" size="4"> - <input
										type="text" name="hp2" id="hp2" size="4"> - <input type="text"
										name="hp3" id="hp3" size="4">
								</p>
								<p>
									<span class="sub">회원정보에 등록된 휴대전화를 입력하여 주세요. </span>
								</p></td>

						</tr>
					</tbody>
				</table>
				</form>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>
					<span class="leaveimg">
					<img src="${pageContext.request.contextPath}/resources/image/leave.png"
						alt="탈퇴하기" onclick="button_action();"/>&nbsp;&nbsp;&nbsp; 
					<img src="${pageContext.request.contextPath}/resources/image/qnacancel.png"
						alt="취소하기" /></span>
				</p>
			</div>




		</div>

	</div>

<%@include file="/WEB-INF/views/include/pipt_include_1030.jsp"%>