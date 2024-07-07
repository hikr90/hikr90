<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/pipt_include_1020.jsp"%>
<%@include file="check_login.jsp"%>
<link
	href="${pageContext.request.contextPath}/resources/css/mypage.css"
	rel="stylesheet" type="text/css">
<div id="objectbanner">
	<div id="bannertxt">마이페이지</div>
	<img
		src="${pageContext.request.contextPath}/resources/image/mypage.png">
</div>
<div id="wrap">

	<jsp:include page="mypage_submenu.jsp"></jsp:include>

	<div id="product">
		<form id="productform">
			<h2 style="font-size: 28px">주문 / 배송조회</h2>
			<p>&nbsp;</p>
			<p>* 최근 6개월간의 주문내역을 기본으로 보여드립니다.</p>
			<p>* 주문번호, 상품명을 클릭하시면 주문상세내역 및 배송현황을 확인하실 수 있습니다.</p>
			<p>
				<b>* 상품준비 이전 단계까지만 주문 취소가 가능합니다.</b>
			</p>
			<p>&nbsp;</p>
			<table width="980" height="200" border="0" cellpadding="10"
				cellspacing="0">
				<tbody>
					<tr>
						<th width="102" height="50" scope="row">주문번호</th>
						<th width="128">주문일시</th>
						<th width="400">주문상품</th>
						<th width="120">주문금액</th>
						<th width="120">주문상태</th>
					</tr>
					<c:forEach var="vo" items="${list }">
						<tr>
							<td height="121" scope="row">${vo.idx }</td>
							<td>${vo.oi_date }</td>
							<td>${vo.g_name }</td>
							<td>${vo.oi_price * vo.oi_count + 3000 }</td>
							<td>
							<c:choose>
									<c:when test="${vo.oi_status eq 1}">
									환불신청됨							
								</c:when>
									<c:when test="${vo.oi_status eq 4}">
									환불완료							
								</c:when>
									<c:when test="${vo.oi_destatus eq 1}">
									주문완료							
								</c:when>
									<c:when test="${vo.oi_destatus eq 2}">
									결재완료							
								</c:when>
									<c:when test="${vo.oi_destatus eq 3}">
									상품준비					
								</c:when>
									<c:when test="${vo.oi_destatus eq 4}">
									배송중						
								</c:when>
									<c:when test="${vo.oi_destatus eq 5}">
									배송완료							
								</c:when>
								</c:choose></td>
						</tr>
					</c:forEach>
					<c:if test="${empty list }">
						<tr>
							<td align="center" colspan="5">현재 주문 목록이 비어있습니다.</td>
						</tr>
					</c:if>
					<tr align="center">
						<td colspan="5">${pageMenu }</td>
					</tr>
				</tbody>
			</table>
			<p>&nbsp;</p>
			<p>&nbsp;</p>

			<div id="process">
				<h2 style="font-size: 26px">주문처리안내</h2>
				<div class="processimg">
					<div class="img1">
						<p>&nbsp;</p>
						<p>
							<img
								src="${pageContext.request.contextPath}/resources/image/process1.png"
								width="80" height="80" alt="" />
						</p>
						<div class="imgtext">
							<h3>주문완료</h3>
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
								src="${pageContext.request.contextPath}/resources/image/process2.png"
								width="80" height="80" alt="" />
						</p>
						<div class="imgtext">
							<h3>결제완료</h3>
							<p>&nbsp;</p>
							결제내역 확인
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
								src="${pageContext.request.contextPath}/resources/image/process3.png"
								width="80" height="80" alt="" />
						</p>
						<div class="imgtext">
							<h3>상품준비</h3>
							<p>&nbsp;</p>
							상품출고지시
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
								src="${pageContext.request.contextPath}/resources/image/process4.png"
								width="120" height="100" alt="" />
						</p>
						<div class="imgtext1">
							<h3>배송중</h3>
							<p>&nbsp;</p>
							상품 출고완료
							</p>
						</div>
					</div>
					<div class="next">
						<img
							src="${pageContext.request.contextPath}/resources/image/next.png"
							width="62" height="200" alt="" />
					</div>

					<div class="img2">
						<p>&nbsp;</p>
						<p>
							<img
								src="${pageContext.request.contextPath}/resources/image/process5.png"
								width="80" height="80" alt="" />
						</p>
						<div class="imgtext">
							<h3>배송완료</h3>
							<p>&nbsp;</p>
							<p>&nbsp;</p>
						</div>
					</div>
				</div>


			</div>
		</form>
	</div>
</div>
<%@include file="/WEB-INF/views/include/pipt_include_1030.jsp"%>