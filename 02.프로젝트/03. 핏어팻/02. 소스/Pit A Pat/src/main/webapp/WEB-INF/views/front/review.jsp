<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<link href="${pageContext.request.contextPath}/resources/css/refund.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/menu1.css"
	rel="stylesheet" type="text/css">
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/index.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/navmenu.js"></script>
</head>

<body>


	<header>
		<div id="topMenuBox">

			<a href="index1.html" target=_parent>Home</a>&nbsp;&nbsp;|&nbsp; <a
				href="login.html" target=_parent>로그인</a>&nbsp;&nbsp;|&nbsp; <a
				href="joinForm.html" target=_parent>회원가입</a>&nbsp;&nbsp;|&nbsp;<a
				href="cart.html" target=_parent>장바구니</a> | <a href="mypage.html"
				target=_parent>마이페이지</a>&nbsp;&nbsp;|&nbsp; <a href="CScenter.html"
				target=_parent>고객센터</a>&nbsp;&nbsp;|&nbsp;
		</div>
		<p>
	</header>
<body>
	<div id="top">
		<div id="toplogo">
			<a href="index1.html"><img
				src="${pageContext.request.contextPath}/resources/image/landscape.png"></a>
		</div>
		<nav>
			<ul>
				<li><a href="About2.html">ABOUT</a></li>
				<li><a href="InsideGarden.html">THEME</a></li>
				<li><a href="tree.html">PRODUCT</a></li>
				<li><a href="consult.html">CONSULT</a></li>
				<li><a href="portfolio.html">PORTFOLIO</a></li>
			</ul>
			<div id="submenubox">
				<div class="submenuitem" id="submenuitem1">
					<ul>
						<li><a href="About2.html">회사소개</a></li>
						<li><a href="Value.html">사업소개</a></li>
					</ul>
				</div>
				<div class="submenuitem" id="submenuitem2">
					<ul>
						<li><a href="InsideGarden.html">실내조경</a></li>
						<li><a href="outsideGarden.html">실외조경</a></li>
						<li><a href="EctGarden.html">기타조경</a></li>
					</ul>
				</div>
				<div class="submenuitem" id="submenuitem3">
					<ul>
						<li><a href="tree.html">나무/묘목</a></li>
						<li><a href="ground.html">바닥재</a></li>
						<li><a href="object.html">조형물</a></li>
						<li><a href="product.html">조경용품</a></li>
					</ul>
				</div>
				<div class="submenuitem" id="submenuitem4">
					<ul>
						<li><a href="consult.html">견적문의</a></li>

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


	<div id="objectbanner">
		<div class="bannertxt">마이페이지</div>
		<img
			src="${pageContext.request.contextPath}/resources/image/mypage.png">
	</div>
	<div id="wrap">



		<div id="submenu">
			<ul>
				<li><a href="mypage.html">주문 / 배송조회</a></li>
				<li><a href="refund.html"><span class="order">주문 취소
							/ 변경</span></a></li>
				<li><a href="1to1QNA.html">1:1 문의</a></li>
				<li><a href="itemQNA.html">상품 Q &amp; A</a></li>
				<li><a href="updateMember.html">회원정보 수정</a></li>
				<li><a href="leave.html">회원 탈퇴</a></li>
			</ul>
		</div>

		<div id="product">
			<form id="productform">
				<h2 style="font-size: 28px">주문 취소 / 변경</h2>
				<p>&nbsp;</p>

				<p>
					* 주문취소 시에는 고객님께서 결제한 계좌로 환불처리 됩니다. (신용카드 : 즉시, 계좌이체 : 최대3일 소요)<br>
					* 일부 환불이 불가능한 경우에는 온라인 예치금으로 자동 예치됩니다.
				</p>
				<p>* 이미 출고된 상품이 있는 경우 주문을 취소할 수 없습니다. 반품 메뉴를 이용하시기 바랍니다.</p>
				<p>&nbsp;</p>
				<table width="980" height="190" border="0" cellpadding="10"
					cellspacing="0">

					<tbody>
						<tr>
							<th width="110" height="60" scope="row">주문번호</th>
							<th width="130">주문일시</th>
							<th width="300">주문상품</th>

							<th width="110">주문금액</th>
							<th width="110">주문상태</th>
							<th width="110">취소</th>
							<th width="110">교환</th>
						</tr>
						<tr>
							<td width="110" height="130" scope="row">&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td><a href="refundOk.html"><img
									src="${pageContext.request.contextPath}/resources/image/refundButton.png"
									alt="" /></a></td>
							<td><a href="changeOk.html"><img
									src="${pageContext.request.contextPath}/resources/image/change.png"
									alt="" /></a></td>
						</tr>

					</tbody>
				</table>
				<p>&nbsp;</p>






				<div id="process">
					<h2 style="font-size: 26px">주문처리안내</h2>
					<div class="processimg">
						<div class="img1">
							<p>&nbsp;</p>
							<p>
								<img
									src="${pageContext.request.contextPath}/resources/image/process1.png"
									width="80" height="80" alt="" />
							</p>
							<div class="imgtext">
								<h3>주문완료</h3>
								<p>&nbsp;</p>
								<p>&nbsp;</p>
							</div>

						</div>
						<div class="next">
							<img
								src="${pageContext.request.contextPath}/resources/image/next.png"
								width="62" height="200" alt="" />
						</div>

						<div class="img1">
							<p>&nbsp;</p>
							<p>
								<img
									src="${pageContext.request.contextPath}/resources/image/process2.png"
									width="80" height="80" alt="" />
							</p>
							<div class="imgtext">
								<h3>결제완료</h3>
								<p>&nbsp;</p>
								결제내역 확인
							</div>
						</div>
						<div class="next">
							<img
								src="${pageContext.request.contextPath}/resources/image/next.png"
								width="62" height="200" alt="" />
						</div>

						<div class="img1">
							<p>&nbsp;</p>
							<p>
								<img
									src="${pageContext.request.contextPath}/resources/image/process3.png"
									width="80" height="80" alt="" />
							</p>
							<div class="imgtext">
								<h3>상품준비</h3>
								<p>&nbsp;</p>
								상품출고지시
							</div>
						</div>
						<div class="next">
							<img
								src="${pageContext.request.contextPath}/resources/image/next.png"
								width="62" height="200" alt="" />
						</div>

						<div class="img1">
							<p>&nbsp;</p>
							<p>
								<img
									src="${pageContext.request.contextPath}/resources/image/process4.png"
									width="120" height="100" alt="" />
							</p>
							<div class="imgtext1">
								<h3>배송중</h3>
								<p>&nbsp;</p>
								상품 출고완료
							</div>
						</div>
						<div class="next">
							<img
								src="${pageContext.request.contextPath}/resources/image/next.png"
								width="62" height="200" alt="" />
						</div>

						<div class="img2">
							<p>&nbsp;</p>
							<p>
								<img
									src="${pageContext.request.contextPath}/resources//image/process5.png"
									width="80" height="80" alt="" />
							</p>
							<div class="imgtext">
								<h3>배송완료</h3>
								<p>&nbsp;</p>
								<p>&nbsp;</p>
							</div>
						</div>

					</div>


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
					<p>
						회사명 (주)샌드박스네트워크대표 이필성대표전화 02-556-1551 주소06180 서울특별시 강남구 테헤란로 518
						(대치동) 한국섬유산업연합회 15층<br> 사업자 등록번호 220-88-89136통신판매업 COPYRIGHT
						ⓒ 샌드박스 스토어.<br> ALL RIGHTS RESERVED.
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
