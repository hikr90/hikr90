<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/pipt_include_1020.jsp"%>
<link href="${pageContext.request.contextPath}/resources/css/refund.css"
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
			<h2 style="font-size: 28px">주문 취소 / 변경</h2>
			<p>&nbsp;</p>

			<p>
				* 주문취소 시에는 고객님께서 결제한 계좌로 환불처리 됩니다. (신용카드 : 즉시, 계좌이체 : 최대3일 소요)<br>
				* 일부 환불이 불가능한 경우에는 온라인 예치금으로 자동 예치됩니다.
			</p>
			<p>* 이미 출고된 상품이 있는 경우 주문을 취소할 수 없습니다. 반품 메뉴를 이용하시기 바랍니다.</p>
			<p>&nbsp;</p>
			<table width="980" height="190" border="0" cellpadding="10"
				cellspacing="0">

				<tbody>
					<tr>
						<th width="110" height="60" scope="row">주문번호</th>
						<th width="130">주문일시</th>
						<th width="300">주문상품</th>
						<th width="110">주문금액</th>
						<th width="110">주문상태</th>
						<th width="110">취소</th>
						<th width="110">교환</th>
					</tr>
					<c:forEach var="vo" items="${list}">
						<tr>
							<td width="110" height="130" scope="row">${vo.idx }</td>
							<td>${vo.oi_date }</td>
							<td>${vo.g_name }</td>
							<td>${vo.oi_price * vo.oi_count + 3000 }</td>
							<td><c:choose>
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
							<td><c:choose>
									<c:when test="${vo.oi_status eq 1}">
									환불신청됨							
								</c:when>
									<c:when test="${vo.oi_status eq 4}">
									환불완료							
								</c:when>
									<c:otherwise>
										<a href="refundOk.do?idx=${vo.idx}"><img
											src="${pageContext.request.contextPath}/resources/image/refundButton.png"
											alt="" /></a>
									</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${vo.oi_status eq 1}">
									환불신청됨							
								</c:when>
									<c:when test="${vo.oi_status eq 4}">
									환불완료							
								</c:when>
									<c:otherwise>
										<a href="changeOk.do?idx=${vo.idx}"><img
											src="${pageContext.request.contextPath}/resources/image/change.png"
											alt="" /></a>
									</c:otherwise>
								</c:choose></td>
						</tr>
					</c:forEach>
					<c:if test="${empty list }">
						<tr>
							<td align="center" colspan="7">현재 주문 목록이 비어있습니다.</td>
						</tr>
					</c:if>
					<tr align="center">
						<td colspan="7">${pageMenu }</td>
					</tr>
				</tbody>
			</table>
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