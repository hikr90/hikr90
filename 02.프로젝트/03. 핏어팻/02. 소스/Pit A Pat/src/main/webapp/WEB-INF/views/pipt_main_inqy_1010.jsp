<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- Header script -->
<%@include file="/WEB-INF/views/include/pipt_include_1010.jsp"%>

<body>
	<!-- Logo & Menu -->
	<%@include file="/WEB-INF/views/include/pipt_include_1020.jsp"%>
	
	<!-- Slide -->
	<article id="slideShow">
		<div id="slideShowBox">
			<div id="slidePanel">
				<img src="${pageContext.request.contextPath}/resources/image/banner/banner1.png"  class="slideImg" />
				<img src="${pageContext.request.contextPath}/resources/image/banner/banner2.png"  class="slideImg" />
				<img src="${pageContext.request.contextPath}/resources/image/banner/banner3.png"  class="slideImg" />
				<img src="${pageContext.request.contextPath}/resources/image/banner/banner4.png"  class="slideImg" />
			</div>
		</div>
	</article>

	<div class="wrap">
		<div class="main_box">
			<div class="main_title">
				Best Item
				
				<a class="view_all">전체 보기</a>
			</div>

			<div class="sub_title">
				<ul>
					<li><a href="javascript:">전체</a></li>
					<li><a href="javascript:">제품1</a></li>
					<li><a href="javascript:">제품2</a></li>
					<li><a href="javascript:">제품3</a></li>
				</ul>
			</div>

			<div class="item_area">
				<div class="item_box">
					<img src="${pageContext.request.contextPath}/resources/image/news1.png" width="370"  height="250" />
					<img src="${pageContext.request.contextPath}/resources/image/news1.png" width="370"  height="250" />
					<img src="${pageContext.request.contextPath}/resources/image/news1.png" width="370"  height="250" />
					<img src="${pageContext.request.contextPath}/resources/image/news1.png" width="370"  height="250" />
				</div>
			</div>
		</div>
		
		<div class="background_box">
			<div class="main_box ">
				<div class="main_title">
					Monthly Item
				</div>
				<div class="sub_desc">할인 20 ~ 30% 적용</div>
			</div>
		</div>

		<div id="content5">
			<div class="text4">
				<p>Portfolio</p>
			</div>
			<div class="underbar">
				<img
					src="${pageContext.request.contextPath}/resources/image/bar.png"
					width="140" height="15">
			</div>
			<div class="port1">
				<div class="pf">
					<a href="portfolio_out.html"><img
						src="${pageContext.request.contextPath}/resources/image/L1.jpg"
						width="380" height="380"></a>
				</div>
				<div class="porttxt">TOWNHOUSE INTERIOR DESIGN</div>
			</div>
			<div class="port1">
				<div class="pf">
					<a href="portfolio_out.html"><img
						src="${pageContext.request.contextPath}/resources/image/L2.jpg"
						width="380" height="380"></a>
				</div>
				<div class="porttxt">TOWNHOUSE INTERIOR DESIGN</div>
			</div>
			<div class="port1">
				<div class="pf">
					<a href="portfolio_out.html"><img
						src="${pageContext.request.contextPath}/resources/image/L3.jpg"
						width="380" height="380"></a>
				</div>
				<div class="porttxt">TOWNHOUSE INTERIOR DESIGN</div>
			</div>
			<div class="port1">
				<div class="pf">
					<a href="portfolio_out.html"><img
						src="${pageContext.request.contextPath}/resources/image/L4.jpg"
						width="380" height="380"></a>
				</div>
				<div class="porttxt">TOWNHOUSE INTERIOR DESIGN</div>
			</div>
			<div class="port1">
				<div class="pf">
					<a href="portfolio_out.html"><img
						src="${pageContext.request.contextPath}/resources/image/L5.jpg"
						width="380" height="380"></a>
				</div>
				<div class="porttxt">TOWNHOUSE INTERIOR DESIGN</div>
			</div>
		</div>

	</div>
	<%@include file="/WEB-INF/views/include/pipt_include_1030.jsp"%>