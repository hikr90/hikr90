<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/pipt_include_1020.jsp"%>
<link
	href="${pageContext.request.contextPath}/resources/css/changeOk.css"
	rel="stylesheet" type="text/css">
<div id="objectbanner">
	<div class="bannertxt">마이페이지</div>
	<img
		src="${pageContext.request.contextPath}/resources/image/mypage.png">
</div>
<div id="wrap">
	<jsp:include page="mypage_submenu.jsp"></jsp:include>
	<div id="product">
		<form id="productform">
			<h2 style="font-size: 28px">주문 취소 / 변경</h2>
			<p>&nbsp;</p>

			<p>
				* 주문취소 시에는 고객님께서 결제한 계좌로 환불처리 됩니다. (신용카드 : 즉시, 계좌이체 : 최대3일 소요)<br>
				* 일부 환불이 불가능한 경우에는 온라인 예치금으로 자동 예치됩니다.
			</p>
			<p>* 이미 출고된 상품이 있는 경우 주문을 취소할 수 없습니다. 반품 메뉴를 이용하시기 바랍니다.</p>
			<p>&nbsp;</p>
			<table width="980" height="251" border="0" cellpadding="10"
				cellspacing="0">
				<tbody>
					<tr>
						<th width="116" height="50" scope="row">주문번호</th>
						<th width="425">상품명</th>
						<th width="116">판매가</th>
						<th width="116">수량</th>
						<th width="116">가격</th>
					</tr>
					<c:set var="price" value="${vo.oi_price }" />
					<c:set var="count" value="${vo.oi_count}" />
					<c:set var="delivery" value="100" />
					<c:set var="sum" value="${price*count + delivery}" />
					<tr>
						<td height="121" scope="row">${vo.idx}</td>
						<td>${vo.g_name}</td>
						<td>${vo.oi_price}</td>
						<td>${vo.oi_count}</td>
						<td>${vo.oi_price * vo.oi_count}</td>
					</tr>
					<tr>
						<td height="50" scope="row">&nbsp;</td>
						<td colspan="2"><span class="productTotal">(상품금액 +
								배송비(100원))(원)</span></td>
						<td colspan="2"><c:out value="${sum}" />(원)</td>
					</tr>
				</tbody>
			</table>

			<h2>&nbsp;</h2>
			<h2>&nbsp;</h2>
			<h2 style="font-size: 26px">교환신청</h2>
			<p>&nbsp;</p>
			<table id="payform" width="980" height="160" border="0"
				cellpadding="10" cellspacing="0">

				<tbody>
					<tr>
						<th width="179" height="80" scope="row">반송 방법</th>
						<td width="703"><input type="radio" name="radio" id="radio"
							value="radio" checked> <label for="radio">업체
								배송&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio" name="radio2"
								id="radio2" value="radio2"> 타 배송업체
						</label></td>
					</tr>

					<tr>
						<th width="179" height="80" scope="row">교환사유</th>
						<td><select id="bank">
								<option value="우리은행" selected>상품의 파손 및 기스
								<option value="국민은행">상품의 고장
								<option value="신한은행">상품의 품질저하
						</select></td>
				</tbody>
			</table>
			<p>&nbsp;</p>
			<p>
				<span class="refund"><img
					src="${pageContext.request.contextPath}/resources/image/changebutton.png"
					alt="" /></span>
			</p>
			<div id="process">
				<h2 style="font-size: 26px">교환처리안내</h2>
				<div class="processimg">
					<div class="img1">
						<p>&nbsp;</p>
						<p>
							<img
								src="${pageContext.request.contextPath}/resources/image/change1.png"
								width="80" height="80" alt="" />
						</p>
						<div class="imgtext">
							<h3>교환접수</h3>
							<p>&nbsp;</p>
							<p>&nbsp;</p>
						</div>

					</div>
					<div class="next">
						<img
							src="${pageContext.request.contextPath}/resources/image/next.png"
							width="62" height="200" alt="" />
					</div>

					<div class="img1">
						<p>&nbsp;</p>
						<p>
							<img
								src="${pageContext.request.contextPath}/resources/image/change2.png"
								width="80" height="80" alt="" />
						</p>
						<div class="imgtext">
							<h3>상품 회수</h3>
						</div>
					</div>
					<div class="next">
						<img
							src="${pageContext.request.contextPath}/resources/image/next.png"
							width="62" height="200" alt="" />
					</div>

					<div class="img1">
						<p>&nbsp;</p>
						<p>
							<img
								src="${pageContext.request.contextPath}/resources/image/change3.png"
								width="80" height="80" alt="" />
						</p>
						<div class="imgtext">
							<h3>하자상품교환</h3>
						</div>
					</div>
					<div class="next">
						<img
							src="${pageContext.request.contextPath}/resources/image/next.png"
							width="62" height="200" alt="" />
					</div>

					<div class="img1">
						<p>&nbsp;</p>
						<p>
							<img
								src="${pageContext.request.contextPath}/resources/image/change4.png"
								width="120" height="100" alt="" />
						</p>
						<div class="imgtext1">
							<h3>교환상품 발송</h3>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>
<%@include file="/WEB-INF/views/include/pipt_include_1030.jsp"%>