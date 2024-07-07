<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/pipt_include_1020.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IslandScape</title>
<style type="text/css">
a:link {
	text-decoration: none;
	;
}
</style>

<link href="${pageContext.request.contextPath}/resources/css/cart.css"
	rel="stylesheet" type="text/css">
<script
	src="${pageContext.request.contextPath}/resources/js/js_package.js"></script>
<!-- <script type="text/javascript">
	function del(idx, m_num) {
		if (!confirm("정말로 삭제하시겠습니까?")) {
			return;
		}

		location.href = "cart_delete.do?idx=" + idx + "&m_num=" + m_num;
	}
	function modify(g_num, count, m_num) {
		var url = "cart_update.do";
		var param = "g_num="+g_num + "&count=" + count + "&m_num=" + m_num;
		sendRequest(url, param, resultFn, "get");
		
		function resultFn() {
			
			if(xhr.readyState == 4 && xhr.status == 200 ) {
				var data = xhr.responseText;
				
				if(data == 'yes'){
					alert("수량이 변경되었습니다");
						return;	
					}
				location.href = "piptFaveInqy1010.do";
			}
			
		}
	
	/* function modify(g_num, count, m_num) {
		var count = f.count.value;
		var g_num = f.g_num.value;
		var m_num = f.m_num.value;
		var number = /^[0-9]+$/;
		
		if(!number.cart(count)) {
			alert("수량은 정수로 입력하세요");
			return;
		}
		
		location.href = "cart_update.do?g_num=" + g_num + "&count=" + count + "&m_num=" + m_num;
		
	} */
	
</script> -->
</head>

<div id="wrap">

	<div id="producttxt">장바구니</div>

	<div id="product">
		<form id="producttable" name="cart">
			<h2>배송 상품</h2>
			<p>&nbsp;</p>
			<table width="1200" height="251" border="0" cellpadding="10"
				cellspacing="0">
				<tbody>
					<tr>

						<th width="110" height="60" scope="row">상품코드</th>
						<th width="600">상품명</th>
						<th width="110">판매가</th>
						<th width="110">수량</th>
						<th width="110">가격</th>
						<th width="110" height="50" scope="row">취소</th>
					</tr>

					<c:set var="price" value="${vo.g_price }" />
					<c:set var="count" value="${vo.count}" />
					<c:set var="delivery" value="3000" />
					<c:set var="sum" value="0" />

					<c:forEach var="vo" items="${ list }">

						<tr>

							<td height="121" scope="row">${ vo.g_num }</td>
							<td>${ vo.g_name }</td>
							<td>${ vo.g_price }</td>
							<td><input name="count" value="${vo.count}" size="4"
								align="center"> <input type="button" value="수정"
								onclick="modify('${vo.g_num}','${vo.count}','${vo.m_num}')">

							</td>
							<td><fmt:formatNumber value="${vo.g_price * vo.count }" /></td>
							<td height="121" scope="row">
								<button type="button" onclick="del('${vo.idx}', '${vo.m_num}')">
									<img
										src="${pageContext.request.contextPath}/resources/image/cartCancel.png"
										alt="" />
								</button>
							</td>
						</tr>
						<c:set var="sum" value="${sum + (vo.g_price * vo.count)}" />
					</c:forEach>

					<tr>

						<td height="80" colspan="3"><span class="productTotal">상품금액</span></td>
						<td colspan="2"><fmt:formatNumber pattern="###,###,###"
								value="${sum}" />원</td>
						<td>&nbsp;</td>
					</tr>
				</tbody>
			</table>
			<div id="total">
				<div class="total1">
					<div class="totaltxt">
						<p>&nbsp;</p>
						주문합계
					</div>
					<p>&nbsp;</p>
					<table id="totalform" width="600" height="200" border="0"
						cellpadding="10" cellspacing="0">

						<tbody>
							<tr>
								<th width="239" height="80" scope="row">주문금액</th>
								<td width="321"><fmt:formatNumber pattern="###,###,###"
										value="${sum}" />원</td>
							<tr>
								<th width="239" height="80" scope="row">배송비</th>
								<td>3000원</td>
							<tr>
								<th width="239" height="80" scope="row">총 주문금액</th>
								<td colspan="3"><fmt:formatNumber pattern="###,###,###"
										value="${sum+3000}" /></td>

							</tr>
						</tbody>
					</table>

				</div>
				<p>&nbsp;</p>
				<p>
					<button type="button" onclick="location.href='piptProdInqy1010.do'">
						<img
							src="${pageContext.request.contextPath}/resources/image/keep.png"
							alt="" />
					</button>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<button type="submit">
						<img
							src="${pageContext.request.contextPath}/resources/image/order.png"
							alt="" />
					</button>
				</p>


			</div>


		</form>



	</div>

</div>

<footer>
	<div id="footer">



		<div class="footercontent">
			<div class="footerlogo">
				<img
					src="${pageContext.request.contextPath}/resources/image/landscape.png"
					width="169" height="53" alt="" />
			</div>
			<div class="company">
				<p>회사명 (주)샌드박스네트워크대표 이필성대표전화 02-556-1551</p>
				<p>
					주소06180 서울특별시 강남구 테헤란로 518 (대치동) 한국섬유산업연합회 15층사업자 등록번호
					220-88-89136통신판매업 COPYRIGHT ⓒ 샌드박스 스토어.<br> ALL RIGHTS
					RESERVED.
				</p>
			</div>
		</div>

		<div class="bgfooter">
			<img
				src="${pageContext.request.contextPath}/resources/image/bg_footer.png"
				width="1920" height="300" alt="" />
		</div>
	</div>
</footer>
</body>
</html>