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
	href="${pageContext.request.contextPath}/resources/css/manage_prepare.css"
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
				<h2>배송관리</h2>
				<div class="deli1" style="cursor: pointer;"
					onclick="location.href='manager_payok.do';">
					<div class="pic">
						<a href="manager_payok.do"><img
							src="${pageContext.request.contextPath}/resources/image/delivery1_2.png"
							alt="" width="80" height="80" border="0" /></a>
					</div>
					<div class="title">
						<a href="manager_payok.do">입금확인</a>
					</div>
					<div class="number">0</div>
				</div>

				<div class="deli2" style="cursor: pointer;"
					onclick="location.href='manager_prepere.do';">
					<div class="pic1">
						<a href="manager_prepare.do"><img
							src="${pageContext.request.contextPath}/resources/image/delivery2_1.png"
							width="80" height="80" alt="" /></a>
					</div>
					<div class="title1">
						<a href="manager_prepare.do">배송준비</a>
					</div>
					<div class="number">0</div>
				</div>

				<div class="deli3" style="cursor: pointer;"
					onclick="location.href='manager_delivery.do';">
					<div class="pic">
						<a href="manager_delivery.do"><img
							src="${pageContext.request.contextPath}/resources/image/delivery3_2.png"
							width="80" height="80" alt="" /></a>
					</div>
					<div class="title">
						<a href="manager_delivery.do">배송중</a>
					</div>
					<div class="number">0</div>
				</div>

				<div class="deli4" style="cursor: pointer;"
					onclick="location.href='manager_deliveryok.do';">
					<div class="pic">
						<a href="manager_deliveryok.do"><img
							src="${pageContext.request.contextPath}/resources/image/delivery4_2.png"
							width="80" height="80" alt="" /></a>
					</div>
					<div class="title">
						<a href="manager_deliveryok.do">배송완료</a>
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
				<h2>배송준비중</h2>
				<form id="listform">
					<table border="0" cellspacing="0"
						cellpadding="0">
						<tbody>
							<tr>
								<th scope="row" width="80" height="65">No</th>
								<th width="136">주문일</th>
								<th width="125">주문번호</th>
								<th width="262">상품명</th>
								<th width="118">주문자</th>
								<th width="118">금액</th>
								<th width="118">수량</th>
								<th width="349">주소</th>
								<th width="122">배송중</th>
							</tr>
							<tr>
								<td scope="row" width="80" height="75">&nbsp;</td>
								<td width="136" height="75">&nbsp;</td>
								<td width="125" height="75">&nbsp;</td>
								<td width="262" height="75">&nbsp;</td>
								<td width="118" height="75">&nbsp;</td>
								<td width="118" height="75">&nbsp;</td>
								<td width="118" height="75">&nbsp;</td>
								<td width="349" height="75">&nbsp;</td>
								<td><img
									src="${pageContext.request.contextPath}/resources/image/deliverybutton.png"
									width="90" height="40" alt="" /></td>
							</tr>

						</tbody>
					</table>
				</form>

			</div>

		</div>
	</div>


</body>
</html>
