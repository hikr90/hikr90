<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>IslandScape</title>
<script>
	function logout() {

		var url = "logout.do";

		sendRequest(url, null, resultFn, "POST");

	}
	function resultFn() {
		if (xhr.readyState == 4 && xhr.status == 200) {

			var data = xhr.responseText;
			var json = eval(data);

			if (json[0].result == 'yes') {
				alert("로그아웃 성공");
			} else {
				alert("로그아웃 실패");
			}

			location.href = "index.do";
		}
	}
</script>
<style type="text/css">
a:link {
	text-decoration: none;
}
</style>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/index.css">
<!-- 	<link -->

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/menu.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/slideShow.css">
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/navmenu.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/index.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/slideShow.js"></script>
	<script
	src="${pageContext.request.contextPath}/resources/js/httpRequest.js"></script>
</head>

<body>

	<article id="slideShow">

		<div id="slideShowBox">
			<div id="slidePanel">
				<img
					src="${pageContext.request.contextPath}/resources/image/baner1.png"
					class="slideImg" /> <img
					src="${pageContext.request.contextPath}/resources/image/baner1-1.png"
					class="slideImg" /> <img
					src="${pageContext.request.contextPath}/resources/image/baner1.png"
					class="slideImg" /> <img
					src="${pageContext.request.contextPath}/resources/image/baner1-1.png"
					class="slideImg" />
			</div>
		</div>
	</article>


	<header>
		<div id="topMenuBox">
			<c:choose>
				<c:when test="${empty sessionScope.user }">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="index.do" target=_parent>Home</a>&nbsp;&nbsp;|&nbsp; 
				<a href="login_form.do" target=_parent>로그인</a>&nbsp;&nbsp;|&nbsp;
				<a href="signup_form.do" target=_parent>회원가입</a>&nbsp;&nbsp;|&nbsp;
				<a href="cscenter_top10.do" target=_parent>고객센터</a>&nbsp;&nbsp;|&nbsp;
				</c:when>
				<c:otherwise>
					${user.m_name }&nbsp;&nbsp;|&nbsp; 
					<a href="index.do" target=_parent>Home</a>&nbsp;&nbsp;|&nbsp; 
					<a href="cart.do" target=_parent>장바구니</a> &nbsp;&nbsp;|&nbsp; 
					<a href="mypage.do" target=_parent>마이페이지</a>&nbsp;&nbsp;|&nbsp;
					<a href="cscenter_top10.do" target=_parent>고객센터</a>&nbsp;&nbsp;|&nbsp;
					<a href="javascript:logout();" target=_parent>로그아웃</a> &nbsp;&nbsp;|&nbsp; 
				</c:otherwise>
			</c:choose>
		</div>
		<p>
	</header>
	<div id="top">
		<div id="toplogo">
			<a href="index.do"><img
				src="${pageContext.request.contextPath}/resources/image/landscape.png"></a>
		</div>
		<nav>
			<ul>
				<li><a href="about1.do">ABOUT</a></li>
				<li><a href="insideGarden.do">THEME</a></li>
				<li><a href="tree.do?category=tree">PRODUCT</a></li>
				<li><a href="consult.do">CONSULT</a></li>
<!-- 				<li><a href="portfolio.do">PORTFOLIO</a></li> -->
			</ul>
			<div id="submenubox">
				<div class="submenuitem" id="submenuitem1">
					<ul>
						<li><a href="about1.do">회사소개</a></li>
						<li><a href="about2.do">사업소개</a></li>
					</ul>
				</div>
				<div class="submenuitem" id="submenuitem2">
					<ul>
						<li><a href="insideGarden.do">실내조경</a></li>
						<li><a href="outsideGarden.do">실외조경</a></li>
						<li><a href="ectGarden.do">기타조경</a></li>
					</ul>
				</div>
				<div class="submenuitem" id="submenuitem3">
					<ul>
						<li><a href="tree.do?category=tree">나무/묘목</a></li>
						<li><a href="tree.do?category=ground">바닥재</a></li>
						<li><a href="tree.do?category=object">조형물</a></li>
						<li><a href="tree.do?category=product">조경용품</a></li>
					</ul>
				</div>
				<div class="submenuitem" id="submenuitem4">
					<ul>
						<li><a href="consult.do">견적문의</a></li>

					</ul>
				</div>
<!-- 				<div class="submenuitem" id="submenuitem5"> -->
<!-- 					<ul> -->
<!-- 						<li><a href="portfolio.html">실내조경실적</a></li> -->
<!-- 						<li><a href="portfolio_out.html">실외조경실적</a></li> -->
<!-- 						<li><a href="portfolio_ect.html">기타조경실적</a></li> -->

<!-- 					</ul> -->
<!-- 				</div> -->
			</div>
		</nav>
	</div>
	<p>
	<div id="wrap">
		<article>
			<div id="content1">
				<div class="text1">Landscape Architecture</div>
				<div class="text2">
					작지만 확실한 자연의 생명력을 느낄수있게 도시공간속의
					<p></p>
					자연을 연출합니다.
				</div>
				<div class="underbar">
					<img
						src="${pageContext.request.contextPath}/resources/image/bar.png"
						width="140" height="15">
				</div>
			</div>
		</article>

		<div id="content2">
			<div class="pic1">
				<div class="servive">
					<img
						src="${pageContext.request.contextPath}/resources/image/servive.png">
				</div>
				<div class="servivetext">Our service</div>
				<div class="text3">저희 회사는 현대적인 감각과 디자인으로 최고의 환경을 만드는것이 저희의 목표</div>
			</div>
			<div class="bar">
				<img
					src="${pageContext.request.contextPath}/resources/image/bar2.png"
					width="10" height="200">
			</div>
			<div class="pic2">
				<div class="product">
					<img
						src="${pageContext.request.contextPath}/resources/image/product.png">
				</div>
				<div class="servivetext">Product</div>
				<div class="text3">저희 회사는 현대적인 감각과 디자인으로 최고의 환경을 만드는것이 저희의 목표</div>
			</div>
			<div class="bar">
				<img
					src="${pageContext.request.contextPath}/resources/image/bar2.png"
					width="10" height="200">
			</div>
			<div class="pic3">
				<div class="personal">
					<img
						src="${pageContext.request.contextPath}/resources/image/personal.png">
				</div>
				<div class="servivetext">Personal</div>
				<div class="text3">저희 회사는 현대적인 감각과 디자인으로 최고의 환경을 만드는것이 저희의 목표</div>
			</div>
			<div class="bar">
				<img
					src="${pageContext.request.contextPath}/resources/image/bar2.png"
					width="10" height="200">
			</div>
			<div class="pic4">
				<div class="sustainable">
					<img
						src="${pageContext.request.contextPath}/resources/image/sustainable.png">
				</div>
				<div class="servivetext">Sustainable</div>
				<div class="text3">저희 회사는 현대적인 감각과 디자인으로 최고의 환경을 만드는것이 저희의 목표</div>
			</div>
		</div>
		<div id="news">
			<div class="newsTitle">
				<p>Latest News</p>
			</div>
			<div class="underbar">
				<img
					src="${pageContext.request.contextPath}/resources/image/bar.png"
					width="140" height="15">
			</div>
			<div class="newspage">
				<div class="new1">
					<img
						src="${pageContext.request.contextPath}/resources/image/news1.png"
						alt="" width="370" />
					<div class="newstext">
						<h2 style="color: #4c300c">조경 시공 청정아파트</h2>
						<p>미세먼지&middot;코로나19 여파로 조경 시공 청정 아파트 관심&uarr;</p>
					</div>
				</div>
				<div class="new2">
					<img
						src="${pageContext.request.contextPath}/resources/image/news2.png"
						alt="" width="370" />
					<div class="newstext">
						<h2 style="color: #4c300c">조경 트렌드</h2>
						<p>특화 디자인 '롯데캐슬 3.0'&hellip;롯데건설, 트렌드 반영 '조경' 강화</p>
					</div>
				</div>
				<div class="new3">
					<div class="subnews1">
						<div class="subimg">
							<img
								src="${pageContext.request.contextPath}/resources/image/news3.png"
								height="72" alt="" />
						</div>
						<div class="subtext">
							<h3 style="color: #4c300c">조경 아파트 설계</h3>
							<p>
								'공기 정화' 아파트 설계 주목<br> 받는다
							</p>
						</div>


					</div>
					<div class="subnews2">
						<div class="subimg">
							<img
								src="${pageContext.request.contextPath}/resources/image/news4.png"
								height="72" alt="" />
						</div>
						<div class="subtext">
							<h3 style="color: #4c300c">조경률 40%</h3>
							<p>조경률 40%... 조경에 공들인 아파트가 대세 -</p>
						</div>
					</div>
					<div class="subnews3">
						<div class="subimg">
							<img
								src="${pageContext.request.contextPath}/resources/image/news5.png"
								height="72" alt="" />
						</div>
						<div class="subtext">
							<h3 style="color: #4c300c">조경 만족도 상승</h3>
							<p>&ldquo;가장 공들이는 건 조경&hellip; 만족도 달라져&rdquo;</p>
						</div>
					</div>
				</div>
			</div>

		</div>

		<div id="objectbanner">
			<div class="txtfull">
				<div class="bannertxt">
					<span style="font-size: 50px">254</span> Offers
				</div>
				<div class="bannertxt2">
					<p>
						<span style="font-size: 50px">10</span>
					</p>
					<p>Years of Experience</p>
				</div>
				<div class="bannertxt3">
					<span style="font-size: 50px">26</span> Qualified Specialists
				</div>
				<div class="bannertxt4">
					<span style="font-size: 50px">99%</span> Satisfied Clients
				</div>
			</div>
			<img
				src="${pageContext.request.contextPath}/resources/image/baner2.png">


		</div>

		<article>
			<div id="content4">
				<div class="pic5">
					<div class="inside">
						<img
							src="${pageContext.request.contextPath}/resources/image/pic2_1.png"
							width="312" height="312" alt="" />
					</div>
					<div class="insidetxt">실내조경</div>

					<div class="text3">
						실내에서 작은힐링과 휴식이 될수<br>있는 공간을 연출합니다.
					</div>
					<div class="viewmore">
						<a href="InsideGarden.html">VIEW MORE &gt;</a>
					</div>
				</div>
				<div class="pic6">
					<div class="inside">
						<img
							src="${pageContext.request.contextPath}/resources/image/pic2_2.png"
							width="312" height="312" alt="" />
					</div>
					<div class="insidetxt">실외조경</div>

					<div class="text3">
						실내에서 작은힐링과 휴식이 될수<br>있는 공간을 연출합니다.
					</div>
					<div class="viewmore">
						<a href="outsideGarden.html">VIEW MORE &gt;</a>
					</div>
				</div>
				<div class="pic7">
					<div class="inside">
						<img
							src="${pageContext.request.contextPath}/resources/image/pic2_3.png"
							width="312" height="312" alt="" />
					</div>
					<div class="insidetxt">기타조경</div>

					<div class="text3">
						실내에서 작은힐링과 휴식이 될수<br>있는 공간을 연출합니다.
					</div>
					<div class="viewmore">
						<a href="EctGarden.html">VIEW MORE &gt;</a>
					</div>
				</div>
			</div>
		</article>

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
	<%@include file="footer.jsp"%>