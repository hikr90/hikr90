<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IslandScape</title>
<style type="text/css">
a:link {
	text-decoration: none;
}
</style>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<link
	href="${pageContext.request.contextPath}/resources/css/manager_refund.css"
	rel="stylesheet" type="text/css">
<script
	type="${pageContext.request.contextPath}/resources/js/httpRequest.js"></script>
<script>
	function refund(imp, idx) {
		var url = "refundAction.do";

		var param = "imp=" + imp + "&idx=" + idx;

		sendRequest(url, param, resultFn3, "GET");
	}

	function resultFn3() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var data = xhr.responseText;
			var json = eval(data);

			if (json[0].result == null) {
				alert("환불 처리 성공");
			} else {
				alert("환불 처리 실패");
			}

			location.href = "manager_refund.do";
		}
	}
	
	function search(){
		
		var f = document.ff;

		f.action = "search_on_refund.do";
		f.submit();
		
	}
</script>
</head>

<body>
<div id="wrap">
	<jsp:include page="common_top.jsp"></jsp:include>
	<jsp:include page="common_menu.jsp"></jsp:include>
	<div id="main">
		<div id="delivery">
			<h2>취소/교환/환불</h2>
			<div class="deli1" style="cursor: pointer;"
				onclick="location.href='manager_cancel.do';">
				<div class="pic">
					<a href="manager_cancel.do"><img
						src="${pageContext.request.contextPath}/resources/image/cancel1_2.png"
						alt="" width="80" height="80" border="0" /></a>
				</div>
				<div class="title">
					<a href="manager_cancel.do">취소</a>
				</div>
				<div class="number">0</div>
			</div>

			<div class="deli2" style="cursor: pointer;"
				onclick="location.href='manager_change.do';">
				<div class="pic">
					<a href="manager_change.do"><img
						src="${pageContext.request.contextPath}/resources/image/cancel2_2.png"
						width="80" height="80" alt="" /></a>
				</div>
				<div class="title">
					<a href="manager_change.do">교환</a>
				</div>
				<div class="number">0</div>
			</div>


			<div class="deli4" style="cursor: pointer;"
				onclick="location.href='manager_refund.do';">
				<div class="pic1">
					<a href="manager_refund.do"><img
						src="${pageContext.request.contextPath}/resources/image/cancel4_1.png"
						width="80" height="80" alt="" /></a>
				</div>
				<div class="title1">
					<a href="manager_refund.do">환불</a>
				</div>
				<div class="number">${count.refund }</div>
			</div>
		</div>


		<div id="search">
			<form id="searchform" name="ff">
				<table border="0" cellspacing="0"
					cellpadding="0">
					<tbody>
						<tr>
							<th colspan="2" scope="row">&nbsp;</th>
						</tr>
						<tr>
							<th width="239" scope="row" height="60">주문번호</th>
							<td width="1189"><input name="orderCode" id="textfield"></td>
						</tr>
						<tr>
							<th scope="row" height="60">상품구분</th>
							<td><input type="radio" name="radio" id="radio1" value="all" checked> 전체 &nbsp;&nbsp;&nbsp;
							    <input type="radio" name="radio" id="radio2" value="tree"> 나무 &nbsp;&nbsp;&nbsp; 
							    <input type="radio" name="radio" id="radio3" value="ground"> 바닥재 &nbsp;&nbsp;&nbsp;
							    <input type="radio" name="radio" id="radio4" value="object"> 조형물 &nbsp;&nbsp;&nbsp;
							    <input type="radio" name="radio" id="radio5" value="product"> 조경용품</td>
						</tr>
					</tbody>
				</table>
				<p>
					<img src="${pageContext.request.contextPath}/resources/image/search.png" onclick="javascript:search();"/>
				</p>
			</form>
		</div>
		<div id="productlist">
			<h2>환불 목록</h2>
			<div id="listform">
				<table border="0" cellspacing="0"
					cellpadding="0">
					<tbody>
						<tr>
							<th scope="row" width="84" height="65">No</th>
							<th width="141">환불신청일</th>
							<th width="126">주문번호</th>
							<th width="297">상품명</th>
							<th width="112">주문자</th>
							<th width="108">수량</th>
							<th width="117">환불금액</th>
							<th width="116">은행</th>
							<th width="222">계좌번호</th>
							<th width="105">환불처리</th>
						</tr>
						<c:forEach var="vo" items="${list }">
							<tr>
								<td scope="row" width="84" height="75">${vo.idx }</td>
								<td width="141" height="75">${vo.oi_date }</td>
								<td width="126" height="75">${vo.imp_uid }</td>
								<td width="297" height="75">${vo.g_name }</td>
								<td width="112" height="75">${vo.m_name }</td>
								<td width="108" height="75">${vo.oi_count }</td>
								<td width="117" height="75">${vo.oi_price * vo.oi_count }</td>
								<td width="116" height="75">우리 은행</td>
								<td width="222" height="75">1002-553-062276</td>
								<td width="105" height="75"><c:choose>
										<c:when test="${vo.oi_status == 4  }">
										환불 처리 완료
									</c:when>
										<c:otherwise>
											<img
												src="${pageContext.request.contextPath}/resources/image/refundbtn.png"
												alt="" onclick="refund('${vo.imp_uid}', '${vo.idx }');" />
										</c:otherwise>
									</c:choose></td>
							</tr>
						</c:forEach>
						<c:if test="${empty list }">
							<tr>
								<td align="center" colspan="10">현재 환불 신청 목록이 비어있습니다.</td>
							</tr>
						</c:if>
						<tr align="center">
							<td colspan="10">${pageMenu }</td>
						</tr>
					</tbody>
				</table>
				</div>
<!-- 			</form> -->

		</div>

	</div>
	</div>
</body>
</html>
