<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/pipt_include_1020.jsp"%>
<link
	href="${pageContext.request.contextPath}/resources/css/object.css"
	rel="stylesheet" type="text/css">
<html>
<body>

<div id="objectbanner">
	<div id="bannertxt">PRODUCT</div>
	<img
		src="${pageContext.request.contextPath}/resources/image/objectbanner.png">
</div>
<div id="wrap">


	<div id="product">
		<c:forEach var="his" begin="0" end="0" items="${ list }">
			<div id="history">HOME > PRODUCT > ${ his.category }</div>
		</c:forEach>

		<div id="submenu">
			<ul>
				<li><a href="piptProdInqy1010.do?category=tree">나무/묘목</a></li>
				<li><a href="piptProdInqy1010.do?category=ground">바닥재</a></li>
				<li><a href="piptProdInqy1010.do?category=object">조형물</a></li>
				<li><a href="piptProdInqy1010.do?category=product">조경용품</a></li>
			</ul>
		</div>
		<div id="productform">
			<c:forEach var="cg" begin="0" end="0" items="${ list }">
				<div class="objecttitle">
					<img
						src="${pageContext.request.contextPath}/resources/image/rectangle.png">
					<c:choose>
						<c:when test="${cg.category eq 'tree'  }">
							나무/ 묘목
						</c:when>
						<c:when test="${cg.category eq 'ground'  }">
							바닥재
						</c:when>
						<c:when test="${cg.category eq 'object'  }">
							조형물
						</c:when>
						<c:when test="${cg.category eq 'product'  }">
							조경용품
						</c:when>
					</c:choose>
				</div>
			</c:forEach>


			<c:forEach var="vo" items="${ list }">
				<input type="hidden" name="g_num" value="${vo.g_num }">
				<div class="item1">
					<a  href="treeitem1.do?idx=${ vo.idx }"><img
						src="${pageContext.request.contextPath}/resources/image/${ vo.g_image_l }"
						width="231" height="231" alt="" /></a>
					<div class="itemtext1">
						<a href="treeitem1.do?idx=${ vo.idx }">${ vo.g_name }</a>
						<div class="price">${ vo.g_price }원</div>
						<div class="review">
							<img
								src="${pageContext.request.contextPath}/resources/image/review.png"
								width="18" height="15" alt="" />
						</div>
						<div class="like">
							<img
								src="${pageContext.request.contextPath}/resources/image/heart.png"
								width="18" height="15" alt="" /> ${ vo.readhit }
						</div>
					</div>
				</div>
			</c:forEach>

			<c:if test="${ empty list }">

				<center>해당 카테고리에는 아직 등록된 상품이 없습니다</center>

			</c:if>
		</div>
		<p>&nbsp;</p>

		<div id="pages">${ pageMenu }</div>

	</div>
</div>
<%@include file="/WEB-INF/views/include/pipt_include_1030.jsp"%>