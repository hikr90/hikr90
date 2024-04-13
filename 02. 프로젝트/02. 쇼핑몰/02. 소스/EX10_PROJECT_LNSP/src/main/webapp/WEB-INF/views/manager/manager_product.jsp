<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	href="${pageContext.request.contextPath}/resources/css/manager_product.css"
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
				<h2 style="font-size: 24px">상품 현황</h2>
				<form id="totalform">
					<table cellspacing="0" cellpadding="0">
						<tbody>
							<tr>
								<th scope="row" width="354" height="60">전체 등록상품</th>
								<th width="354">판매중 상품</th>
								<th width="354">품절 상품</th>
								<th width="354">삭제 상품</th>

							</tr>
							<tr>
								<td scope="row" height="90">${goodcount.total}건</td>
								<td>${goodcount.sale}건</td>
								<td>${goodcount.soldout }건</td>
								<td>${goodcount.delete }건</td>

							</tr>
						</tbody>
					</table>
				</form>
			</div>
			<div id="productlist">
				<h2>상품 목록</h2>
				<form id="listform">
					<table cellspacing="0" cellpadding="0">
						<tbody>
							<div class="button">
								<a href="manager_productlist.do"><img
									src="${pageContext.request.contextPath}/resources/image/soldout.png"
									width="90" height="40" alt="" /></a>&nbsp;&nbsp;&nbsp;<a
									href="manager_productlist.do"><img
									src="${pageContext.request.contextPath}/resources/image/delete.png"
									width="90" height="40" alt="" /></a>
							</div>
							<th scope="row" width="120" height="70">No</th>
							<th width="250">상품코드</th>
							<th width="400">상품명</th>
							<th width="300">상품구분</th>
							<th width="200">상품상태</th>
							<th width="200">판매가</th>
							</tr>
							<c:forEach var="vo" items="${ list }">
								<tr>
									<td scope="row" height="70">${ vo.idx }</td>
									<td height="70">${ vo.g_num }</td>
									<td height="70">${ vo.g_name }</td>
									<td height="70">${ vo.category }</td>
									<td height="70"><c:choose>
											<c:when test="${vo.g_condition eq 1}">
									판매상품							
								</c:when>
											<c:when test="${vo.g_condition eq 2}">
									품절상품							
								</c:when>
											<c:when test="${vo.g_condition eq 3}">
									삭제상품					
								</c:when>
										</c:choose></td>
									<td height="70">${ vo.g_price }</td>
								</tr>
							</c:forEach>
							<c:if test="${empty list }">
								<tr>
									<td align="center" colspan="11">현재 견적 신청 목록이 비어있습니다.</td>
								</tr>
							</c:if>
							<tr align="center">
								<td colspan="11">${pageMenu }</td>
							</tr>
						</tbody>
					</table>
				</form>

			</div>

		</div>
	</div>


</body>
</html>
