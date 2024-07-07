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
	href="${pageContext.request.contextPath}/resources/css/manager_productlist.css"
	rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">



	function del(idx, status, g_condition) {
		if (!confirm("정말로 삭제하시겠습니까?")) {
			return;
		}
		
		location.href = "goods_delete.do?idx=" + idx + "&status=" + status
				+ "&g_condition=" + g_condition;
		alert("삭제가 완료되었습니다");
	}
	
	function soldout(idx, status, g_condition) {
		if (!confirm("상품을 품절시키시겠습니까?")) {
			return;
		}
		
		location.href = "goods_soldout.do?idx=" + idx + "&status=" + status
				+ "&g_condition=" + g_condition;
		alert("품절이 완료되었습니다");
	}
	
	function sale(idx, status, g_condition) {
		if (!confirm("상품을 추가하시겠습니까?")) {
			return;
		}
		
		location.href = "goods_insert.do?idx=" + idx + "&status=" + status
				+ "&g_condition=" + g_condition;
		alert("추가가 완료되었습니다");
	}
	
	function searchBtn(f){
		location.href="manager_productsearch.do?search=" + f.name.value + "&radio=" + f.category.value + 
				"&select=" + f.condition.value;
	}
	
	
</script>
</head>
<body>
<div id="wrap">
	<jsp:include page="common_top.jsp"></jsp:include>
	<jsp:include page="common_menu.jsp"></jsp:include>
	<div id="main">
		<div id="search">
			<h2 style="font-size: 24px">상품 검색</h2>
			<form id="searchform">
				<table border="0" cellspacing="0"
					cellpadding="0">
					<tbody>
						<tr>
							<th colspan="2" scope="row">&nbsp;</th>
						</tr>
						<tr>
							<th width="239" scope="row" height="60">상품코드</th>
							<td width="1189"><input type="text" name="name"></td>
						</tr>
						<tr>
							<th scope="row" height="60">상품구분</th>
							<td>
								<input type="radio" name="category" id="radio" value="all" checked> 전체 &nbsp;&nbsp;&nbsp; 
								<input type="radio" name="category" id="radio2" value="tree"> 나무 &nbsp;&nbsp;&nbsp; 
								<input type="radio" name="category" id="radio3" value="ground"> 바닥재 &nbsp;&nbsp;&nbsp; 
								<input type="radio" name="category" id="radio4" value="object"> 조형물 &nbsp;&nbsp;&nbsp; 
								<input type="radio" name="category" id="radio5" value="product"> 조경용품
							</td>
						</tr>
						<tr>
							<th scope="row" height="60">판매상태</th>
							<td>
								<select name="condition" >
									<option value="0" selected>전체</option>
									<option value="1">판매상품</option>
									<option value="2">품절상품</option>
									<option value="3">삭제상품</option>
								</select>
								
							</td>
						</tr>

					</tbody>
				</table>
				<p>
					<button type="button"
						value="검색" onclick="searchBtn(this.form);">
					<img
						src="${pageContext.request.contextPath}/resources/image/search.png"
						alt="" /></button>
				</p>
			</form>
		</div>
		<div id="productlist">
			<h2>상품 목록</h2>
			<form id="listform">
				<table border="0" cellspacing="0" cellpadding="0">
					<tbody>
						<tr>
							<th scope="row" width="100" height="70">No</th>
							<th width="140" height="70">상품코드</th>
							<th width="434" height="70">상품명</th>
							<th width="150" height="70">상품구분</th>
							<th width="150" height="70">판매가</th>
							<th width="180" height="70">제조사</th>
							<th width="150" height="70">상품상태</th>
							<th width="120" height="70">품절</th>
							<th width="120" height="70">삭제</th>
							<th width="120" height="70">상품추가</th>
						</tr>
						<c:set var="idx" value="${vo.idx}" />
						<c:set var="status" value="${vo.status}" />
						<c:set var="g_condition" value="${vo.g_condition}" />
						
						<c:forEach var="vo" items="${ list }">
							<tr>
								<td scope="row" width="100" height="70">${ vo.idx }</td>
								<td width="170" height="70">${ vo.g_num }</td>
								<td width="434" height="70"><a
									href="treeitem1.do?idx=${ vo.idx }">${ vo.g_name }</a></td>
								<td width="150" height="70">${ vo.category }</td>
								<td width="150" height="70">${ vo.g_price }</td>
								<td width="180" height="70">${ vo.g_company }</td>
								<td width="150" height="70">
								<c:choose>
							<c:when test="${vo.g_condition eq 1}">
									판매상품							
								</c:when>
							<c:when test="${vo.g_condition eq 2}">
									품절상품							
								</c:when>
							<c:when test="${vo.g_condition eq 3}">
									삭제상품					
								</c:when>
						</c:choose>
								</td>
								<td width="120" height="70">
									<button type="button" onclick="soldout('${vo.idx}', '${vo.status}', '${vo.g_condition}')">
										<img
											src="${pageContext.request.contextPath}/resources/image/soldout.png"
											width="90" height="40" alt="" />
									</button>
								</td>

								<td width="120" height="70">
									<button type="button" onclick="del('${vo.idx}', '${vo.status}', '${vo.g_condition}')">
										<img
											src="${pageContext.request.contextPath}/resources/image/delete.png"
											width="90" height="40" alt="" />
									</button>
								</td>
								<td width="120" height="70">
									<button type="button" onclick="sale('${vo.idx}', '${vo.status}', '${vo.g_condition}')">
										<img
											src="${pageContext.request.contextPath}/resources/image/sale.png"
											width="90" height="40" alt="" />
									</button>
								</td>
							</tr>
						</c:forEach>
						
					</tbody>
				</table>
			</form>
			<div id="pages">${ pageMenu }</div>
		</div>
		
	</div>
	</div>
</body>
</html>
