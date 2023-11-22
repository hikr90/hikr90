<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link
	href="${pageContext.request.contextPath}/resources/css/manager_return.css"
	rel="stylesheet" type="text/css">
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
</head>

<body>
<div id="wrap">
	<jsp:include page="common_top.jsp"></jsp:include>	
	<jsp:include page="common_menu.jsp"></jsp:include>
		<div id="main">
			<div id="delivery">
				<h2>취소/교환/환불</h2>
				<div class="deli1">
					<div class="pic">
						<a href="manager_cancel.do"><img
							src="${pageContext.request.contextPath}/resources/image/cancel1_2.png"
							alt="" width="80" height="80" border="0" /></a>
					</div>
					<div class="title">
						<a href="manager_cancel.do">취소</a>
					</div>
					<div class="number">0</div>
				</div>

				<div class="deli2">
					<div class="pic">
						<a href="manager_change.do"><img
							src="${pageContext.request.contextPath}/resources/image/cancel2_2.png"
							width="80" height="80" alt="" /></a>
					</div>
					<div class="title">
						<a href="manager_change.do">교환</a>
					</div>
					<div class="number">0</div>
				</div>

				<div class="deli3">
					<div class="pic1">
						<a href="manager_return.do"><img
							src="${pageContext.request.contextPath}/resources/image/cancel3_1.png"
							width="80" height="80" alt="" /></a>
					</div>
					<div class="title1">
						<a href="manager_return.do">반품</a>
					</div>
					<div class="number">0</div>
				</div>

				<div class="deli4">
					<div class="pic">
						<a href="manager_refund.do"><img
							src="${pageContext.request.contextPath}/resources/image/cancel4_2.png"
							width="80" height="80" alt="" /></a>
					</div>
					<div class="title">
						<a href="manager_refund.do">환불</a>
					</div>
					<div class="number">0</div>
				</div>
			</div>


			<div id="search">
				<form id="searchform">
					<table border="0" cellspacing="0"
						cellpadding="0">
						<tbody>
							<tr>
								<th colspan="2" scope="row">&nbsp;</th>
							</tr>
							<tr>
								<th width="239" scope="row" height="60">주문번호</th>
								<td width="1189"><input type="text" name="textfield"
									id="textfield"></td>
							</tr>
							<tr>
								<th scope="row" height="60">상품구분</th>
								<td><input type="radio" name="radio" id="radio1"
									value="radio" checked> 전체 &nbsp;&nbsp;&nbsp; <input
									type="radio" name="radio" id="radio2" value="radio2">
									나무 &nbsp;&nbsp;&nbsp; <input type="radio" name="radio"
									id="radio3" value="radio3"> 바닥재 &nbsp;&nbsp;&nbsp; <input
									type="radio" name="radio" id="radio4" value="radio4">
									조형물 &nbsp;&nbsp;&nbsp; <input type="radio" name="radio"
									id="radio5" value="radio5"> 조경용품</td>
							</tr>
						</tbody>
					</table>
					<p>
						<img
							src="${pageContext.request.contextPath}/resources/image/search.png"
							alt="" />
					</p>
				</form>
			</div>
			<div id="productlist">
				<h2>반품 목록</h2>
				<form id="listform">
					<table  border="0" cellspacing="0"
						cellpadding="0">
						<tbody>
							<tr>
								<th scope="row" width="103" height="65">No</th>
								<th width="162">반품신청일</th>
								<th width="162">주문번호</th>
								<th width="382">상품명</th>
								<th width="132">주문자</th>
								<th width="132">수량</th>
								<th width="223">운송장번호</th>
								<th width="132">반품처리</th>
							</tr>
							<tr>
								<td scope="row" width="103" height="75">&nbsp;</td>
								<td width="162" height="75">&nbsp;</td>
								<td width="162" height="75">&nbsp;</td>
								<td width="382" height="75">&nbsp;</td>
								<td width="132" height="75">&nbsp;</td>
								<td width="132" height="75">&nbsp;</td>
								<td width="223" height="75">&nbsp;</td>
								<td width="132" height="75">&nbsp;</td>
							</tr>

						</tbody>
					</table>
				</form>

			</div>

		</div>
	</div>


</body>
</html>
