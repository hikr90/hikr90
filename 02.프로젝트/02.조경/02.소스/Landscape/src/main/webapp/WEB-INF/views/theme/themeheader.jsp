<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IslandScape</title>
<script>
	function logout() {

		var url = "logout.do";

		sendRequest(url, null, resultFn2, "GET");

	}

	function resultFn2() {
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
<link
	href="${ pageContext.request.contextPath }/resources/css/menu1.css"
	rel="stylesheet" type="text/css">

<link rel="stylesheet" type="text/css"
	href="${ pageContext.request.contextPath }/resources/css/slideShow.css">
<script
	src="${ pageContext.request.contextPath }/resources/js/jquery-3.2.1.min.js"></script>
<script
	src="${ pageContext.request.contextPath }/resources/js/navmenu.js"></script>
<script src="${ pageContext.request.contextPath }/resources/js/index.js"></script>
<script
	src="${ pageContext.request.contextPath }/resources/js/slideShow.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/httpRequest.js"></script>
</head>
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
<body>	
	<div id="top">
		<div id="toplogo">
			<a href="index.do"><img
				src="${ pageContext.request.contextPath }/resources/image/landscape.png"></a>
		</div>
		<nav>
			<ul>
				<li><a href="About2.do">ABOUT</a></li>
				<li><a href="insideGarden.do">THEME</a></li>
				<li><a href="tree.do?category=tree">PRODUCT</a></li>
				<li><a href="consult.do">CONSULT</a></li>
				<li><a href="portfolio.html">PORTFOLIO</a></li>
			</ul>
			<div id="submenubox">
				<div class="submenuitem" id="submenuitem1">
					<ul>
						<li><a href="About2.do">회사소개</a></li>
						<li><a href="Value.do">사업소개</a></li>
					</ul>
				</div>
				<div class="submenuitem" id="submenuitem2">
					<ul>
						<li><a href="InsideGarden.do">실내조경</a></li>
						<li><a href="outsideGarden.do">실외조경</a></li>
						<li><a href="EctGarden.do">기타조경</a></li>
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
				<div class="submenuitem" id="submenuitem5">
					<ul>
						<li><a href="portfolio.html">실내조경실적</a></li>
						<li><a href="portfolio_out.html">실외조경실적</a></li>
						<li><a href="portfolio_ect.html">기타조경실적</a></li>

					</ul>
				</div>
			</div>
		</nav>
	</div>
</body>
</html>