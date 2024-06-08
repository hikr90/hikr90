<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/header.jsp"%>
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

<link href="${ pageContext.request.contextPath }/resources/css/cart.css"
	rel="stylesheet" type="text/css">
<script
	src="${ pageContext.request.contextPath }/resources/js/js_package.js"></script>
<script type="text/javascript">
	function del(idx, m_num) {
		if (!confirm("정말로 삭제하시겠습니까?")) {
			return;
		}

		location.href = "cart_delete.do?idx=" + idx + "&m_num=" + m_num;
	}

	function modify(g_num, m_num, f) {
		var number = /^[0-9]+$/;

		if (!number.test(f.cnt.value)) {
			alert("수량은 정수로 입력하세요");
			return;
		}

		var count = f.data;
		location.href = "cart_update.do?g_num=" + g_num + "&count="
				+ f.cnt.value + "&m_num=" + m_num;

	}
</script>
</head>

<div id="wrap">

	<div id="producttxt">장바구니</div>
	<form name="product" action="order_temp2.do">
		<div id="product">
			<div id="producttable" name="cart" action="cart_update.do">
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
						<%
							int i = 0;
						%>
						<c:forEach var="vo" items="${ list }">
							<input type="hidden" name="g_num" value="${vo.g_num }">
							<input type="hidden" name="g_name" value="${vo.g_name }">
							<input type="hidden" name="g_price" value="${vo.g_price }">

							<tr>

								<td height="121" scope="row">${ vo.g_num }</td>
								<td>${ vo.g_name }</td>
								<td>${ vo.g_price }</td>
								<td>
									<form>
										<input name="cnt" value="${vo.count}" size="4"> <input
											type="button" value="수정"
											onclick="modify('${vo.g_num}','${vo.m_num}',this.form)">
									</form>
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
						<c:if test="${ empty list }">
							<tr>
								<td colspan="6" height="80">
									<center>장바구니가 비었습니다</center>
								</td>
							</tr>
						</c:if>
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
											value="${sum+3000}" />원</td>

								</tr>
							</tbody>
						</table>

					</div>
					<p>&nbsp;</p>
					<p>
						<button type="button" onclick="location.href='tree.do'">
							<img
								src="${pageContext.request.contextPath}/resources/image/keep.png"
								alt="" />
						</button>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="submit" onclick="location.href='order_temp.do'">
							<img
								src="${pageContext.request.contextPath}/resources/image/order.png"
								alt="" />
						</button>
					</p>


				</div>


			</div>



		</div>
	</form>
</div>

<%@include file="/WEB-INF/views/include/footer.jsp"%>