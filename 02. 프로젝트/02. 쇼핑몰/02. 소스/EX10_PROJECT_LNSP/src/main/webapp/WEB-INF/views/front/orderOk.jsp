<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<style type="text/css">
a:link {
	text-decoration: none;;
	font-family: "나눔스퀘어";
}
</style>

<link
	href="${pageContext.request.contextPath}/resources/css/orderOK.css"
	rel="stylesheet" type="text/css">
<div id="wrap">

	<div id="orderOK">
		<div class="orderOKtxt">주문이 완료되었습니다.</div>
	</div>

	<div id="product">
		<form id="producttable">
			<h2>주문 상품</h2>
			<p>&nbsp;</p>
			<table width="1200" height="300" border="0" cellpadding="10"
				cellspacing="0">
				<tbody>
					<tr>
						<th width="116" height="50" scope="row">상품코드</th>
						<th width="425">상품명</th>
						<th width="116">판매가</th>
						<th width="116">수량</th>
						<th width="116">가격</th>
					</tr>
					<tr>
						<td height="121" scope="row">${vo.g_num }</td>
						<td>${vo.g_name }</td>
						<td>${vo.oi_price }원</td>
						<td>${vo.oi_count }그루</td>
						<td>${vo.oi_price * vo.oi_count }원</td>
					</tr>
					<tr>
						<td height="50" scope="row">&nbsp;</td>
						<td height="50" colspan="2"><span class="productTotal">상품금액
								+ 배송비(3000원)</span></td>
						<td height="50" colspan="2">${vo.oi_price * vo.oi_count + 3000}원</td>
					</tr>
				</tbody>
			</table>
			<h2>&nbsp;</h2>
			<h2>&nbsp;</h2>
			<h2 style="font-size: 26px">주문 정보 확인</h2>
			<p>&nbsp;</p>
			<table id="orderOKform" width="1200" height="640" cellspacing="0">

				<thead>

					<tr>
						<th width="170" height="80">주문번호</th>
						<td width="683">${vo.idx }</td>
					</tr>
					<tr>
						<th width="170" height="80">주문자 명</th>
						<td>${vo.oi_dename }</td>
					</tr>
					<tr>
						<th width="170" height="80">휴대폰 번호</th>
						<td>${vo.oi_dephone }</td>
					</tr>
					<tr>
						<th width="170" height="80">이메일</th>
						<td>${vo.oi_deemail }</td>
					</tr>
					<tr>
						<th width="170" height="80">주소</th>
						<td>${vo.oi_deaddr }</td>
					</tr>
					<tr>
						<th width="170" height="80">결제 방법</th>
						<td>신용카드</td>
					</tr>
					<tr>
						<th width="170" height="80">결제 일시</th>
						<td>${vo.oi_date }</td>
					</tr>
					<tr>
						<th width="170" height="80">배송 요청사항</th>
						<td>
						<c:choose>
								<c:when test="${vo.oi_derequest eq 1}">
										배송 요청사항 없음						
								</c:when>
									<c:when test="${vo.oi_derequest eq 2}">
										부재시 경비실에 맡겨주세요.					
								</c:when>
									<c:when test="${vo.oi_derequest eq 3}">
										배송 전 연락바랍니다.			
								</c:when>
									<c:when test="${vo.oi_derequest eq 4}">
										부재시 핸드폰으로 연락바랍니다.					
								</c:when>									
							</c:choose>						
						</td>
					</tr>

				</thead>

			</table>

			<p>&nbsp;</p>
			<p>&nbsp;</p>
			<p>
				<span class="orderimg">
					<img src="${pageContext.request.contextPath}/resources/image/checkorder.png" alt="" onclick="location.href='mypage.do'"/>&nbsp;&nbsp;&nbsp;&nbsp;
					<img src="${pageContext.request.contextPath}/resources/image/keep.png" alt="" onclick="location.href='tree.do'"/></span>
			</p>
		</form>
	</div>

</div>

<%@include file="footer.jsp"%>