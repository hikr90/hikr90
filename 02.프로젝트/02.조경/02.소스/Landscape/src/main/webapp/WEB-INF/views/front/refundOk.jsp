<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/header.jsp"%>
<link
	href="${pageContext.request.contextPath}/resources/css/refundOk.css"
	rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>	
	

  <!-- iamport.payment.js -->
  <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
	
<!-- jQuery CDN --->
<script>
	 function cancelPay(idx) {	
		 var f = document.productform;
		 
		 f.action="refund_check.do";
		 f.submit(); 		
	  }
</script>
<div id="objectbanner">
	<div id="bannertxt">마이페이지</div>
	<img
		src="${pageContext.request.contextPath}/resources/image/mypage.png">
</div>
<div id="wrap">
	<jsp:include page="mypage_submenu.jsp"></jsp:include>
	<div id="product">
		<form id="productform" name="productform">
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
 					<input type="hidden" name="idx" value="${vo.idx }">
						<th width="116" height="50" scope="row">주문번호</th>
						<th width="425">상품명</th>
						<th width="116">판매가</th>
						<th width="116">수량</th>
						<th width="116">가격</th>
					</tr>
					<c:set var="price" value="${vo.oi_price }" />
					<c:set var="count" value="${vo.oi_count}" />
					<c:set var="delivery" value="3000" />
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
								배송비(3000원))(원)</span></td>
						<td colspan="2"><c:out value="${sum}" />(원)</td>
					</tr>
				</tbody>
			</table>

			<h2>&nbsp;</h2>
			<h2>&nbsp;</h2>
			<h2 style="font-size: 26px">환불계좌입력</h2>
			<p>&nbsp;</p>
			<table id="payform" width="980" height="240" border="0"
				cellpadding="10" cellspacing="0">

				<tbody>
					<tr>
						<th width="179" height="80" scope="row">예금주</th>
						<td width="703"><input type="text" id="bankname"> <span
							class="sub"></span></td>
					</tr>

					<tr>
						<th width="179" height="80" scope="row">은행선택</th>
						<td><select id="bank">
								<option value="우리은행" selected>우리은행&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;







								
								<option value="국민은행">국민은행&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;







								
								<option value="신한은행">신한은행
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<option value="하나은행">하나은행
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<option value="농협은행">농협은행
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</select></td>
					<tr>
						<th width="179" height="80" scope="row">계좌번호</th>
						<td colspan="3"><input type="text" id="account"> <span
							class="sub"> '-' 없이 숫자만 입력해주세요. </span></td>

					</tr>
				</tbody>
			</table>
			<p>&nbsp;</p>
			<p>
				<span class="refund"><img src="${pageContext.request.contextPath}/resources/image/refund.png" alt="" onclick="javascript:cancelPay('${vo.idx}');"/></span>
				</p>
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
<%@include file="/WEB-INF/views/include/footer.jsp"%>