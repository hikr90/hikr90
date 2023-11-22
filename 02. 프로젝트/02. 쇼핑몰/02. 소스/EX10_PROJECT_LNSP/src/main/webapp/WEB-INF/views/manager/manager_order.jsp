<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link
	href="${pageContext.request.contextPath}/resources/css/manager_order.css"
	rel="stylesheet" type="text/css">
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
</head>

<body>
<div id="wrap">
	<jsp:include page="common_top.jsp"></jsp:include>
	<jsp:include page="common_menu.jsp"></jsp:include>
	<div id="main">
		<div class="totalbar">
			<h2 style="font-size: 24px">주문 현황</h2>
			<form id="totalform">
				<table cellspacing="0" cellpadding="0">
					<tbody>
						<tr>
							<th scope="row" width="354" height="60">총 주문 건수</th>
							<th width="354">취소/환불 건수</th>
							<th width="354">교환 건수</th>
							<th width="354">총 결제금액</th>

						</tr>
						<tr>
							<td scope="row" height="90">${count.total }건</td>
							<td>${count.refund }건</td>
							<td>${count.change }건</td>
							<td>${count.sum }원</td>
						</tr>
					</tbody>
				</table>

			</form>
		</div>
		<div id="productlist">
			<h2>주문 목록</h2>
			<form id="listform">
				<table border="0" cellspacing="0"
					cellpadding="0">
					<tbody>
						<tr>
							<th scope="row" width="106" height="65">번호</th>
							<th width="170">주문일(결제일)</th>
							<th width="136">주문번호</th>
							<th width="133">주문자</th>
							<th width="231">상품명</th>
							<th width="128">결제금액</th>
							<th width="117">결제수단</th>
							<th width="106">입금확인</th>
							<th width="106">배송중</th>
							<th width="195">취소/교환/환불</th>
						</tr>
						<c:forEach var="vo" items="${list }">
							<tr>
								<td scope="row" width="106" height="75">${vo.idx }</td>
								<td width="170" height="75">${vo.oi_date }</td>
								<td width="136" height="75">${vo.imp_uid }</td>
								<td width="133" height="75">${vo.m_name }</td>
								<td width="231" height="75">${vo.g_name }</td>
								<td width="128" height="75">${vo.oi_count * vo.oi_price }</td>
								<td width="117" height="75">카드 결제</td>
								<td width="106" height="75"><c:choose>
									<c:when test="${vo.oi_status eq 4}">
									환불 완료							
								</c:when>
								<c:when test="${vo.oi_status eq 1}">
									환불신청됨
								</c:when>
								<c:otherwise>
									확인
								</c:otherwise>
									</c:choose></td>
								<td width="106" height="75"><c:choose>
										<c:when test="${vo.oi_status eq 1}">
									환불신청됨							
								</c:when>
										<c:when test="${vo.oi_status eq 4}">
									환불 완료							
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
								<td width="195" height="75"><c:choose>
										<c:when test="${vo.oi_status eq 0}">
									해당 없음				
								</c:when>
										<c:when test="${vo.oi_status eq 1}">
									환불신청됨							
								</c:when>
										<c:when test="${vo.oi_status eq 2}">
									교환신청됨					
								</c:when>
										<c:when test="${vo.oi_status eq 4}">
									환불 완료					
								</c:when>
									</c:choose></td>
							</tr>
						</c:forEach>
						<c:if test="${empty list }">
							<tr>
								<td align="center" colspan="10">현재 주문 목록이 비어있습니다.</td>
							</tr>
						</c:if>
						<tr align="center">
							<td colspan="10">${pageMenu }</td>
						</tr>
					</tbody>
				</table>
			</form>

		</div>

	</div>
	</div>


</body>
</html>
