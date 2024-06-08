<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/header.jsp"%>
<link
	href="${ pageContext.request.contextPath }/resources/css/updateMemberOk.css"
	rel="stylesheet" type="text/css">
<html>
<body>
	<div id="objectbanner">
		<div id="bannertxt">마이페이지</div>
		<img
			src="${ pageContext.request.contextPath }/resources/image/mypage.png">
	</div>
	<div id="wrap">
		<jsp:include page="mypage_submenu.jsp"></jsp:include>

		<div id="updateOk">
			<form id="ljiForm" action="newMemberOk.jsp">
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
							<td width="683" class="sub">
							</th> .
						</tr>
						<tr>
							<th width="173" height="80">비밀번호</th>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<th width="173" height="80">이름</th>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<th width="173" height="80">생년월일</th>
							<td>&nbsp;</td>
						</tr>

						<tr>
							<th width="173" height="80">휴대폰 번호</th>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<th width="173" height="80">성별</th>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<th width="173" height="80">주소</th>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<th width="173" height="80">E-mail</th>
							<td>&nbsp;</td>
						</tr>

					</thead>

				</table>
				<p>&nbsp;</p>
				<p>
					<span class="update"><img
						src="${ pageContext.request.contextPath }/resources/image/update.png"
						alt="" /></span>
				</p>


			</form>





		</div>

	</div>

	</div>

<%@include file="/WEB-INF/views/include/footer.jsp"%>