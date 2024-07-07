<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<link
	href="${pageContext.request.contextPath}/resources/css/consult.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath}/resources/css/menu1.css"
	rel="stylesheet" type="text/css">
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/index.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/navmenu.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/consultform.js"></script>
</head>

<script type="text/javascript">
	function check() {
		var f = document.consultform;
		alert(f.phone.value);
		
		
	}
</script>7

<body>


	<header>
		<div id="topMenuBox">

			<a href="index1.do" target=_parent>Home</a>&nbsp;&nbsp;|&nbsp; <a
				href="piptLoginInqy1011.do" target=main>로그인</a>&nbsp;&nbsp;|&nbsp; <a
				href="joinForm.do" target=main>회원가입</a>&nbsp;&nbsp;| <a
				href="piptFaveInqy1010.do">장바구니</a> |&nbsp; <a href="piptMypageInqy1010.do" target=main>마이페이지</a>&nbsp;&nbsp;|&nbsp;
			<a href="CScenter.do" target=main>고객센터</a>&nbsp;&nbsp;|&nbsp;
		</div>
		<p>
	</header>
	
	<div id="top">
		<div id="toplogo">
			<a href="index1.do"><img
				src="${pageContext.request.contextPath}/resources/image/landscape.png"></a>
		</div>
		<nav>
			<ul>
				<li><a href="piptAboutInqy1020.do">ABOUT</a></li>
				<li><a href="piptThemeInqy1020.do">THEME</a></li>
				<li><a href="piptProdInqy1010.do">PRODUCT</a></li>
				<li><a href="consult.do">CONSULT</a></li>
				<li><a href="portfolio.do">PORTFOLIO</a></li>
			</ul>
			<div id="submenubox">
				<div class="submenuitem" id="submenuitem1">
					<ul>
						<li><a href="piptAboutInqy1020.do">회사소개</a></li>
						<li><a href="Value.do">사업소개</a></li>
					</ul>
				</div>
				<div class="submenuitem" id="submenuitem2">
					<ul>
						<li><a href="piptThemeInqy1020.do">실내조경</a></li>
						<li><a href="piptThemeInqy1030.do">실외조경</a></li>
						<li><a href="piptThemeInqy1010.do">기타조경</a></li>
					</ul>
				</div>
				<div class="submenuitem" id="submenuitem3">
					<ul>
						<li><a href="piptProdInqy1010.do">나무/묘목</a></li>
						<li><a href="ground.do">바닥재</a></li>
						<li><a href="object.do">조형물</a></li>
						<li><a href="product.do">조경용품</a></li>
					</ul>
				</div>
				<div class="submenuitem" id="submenuitem4">
					<ul>
						<li><a href="consult.do">견적문의</a></li>

					</ul>
				</div>
				<div class="submenuitem" id="submenuitem5">
					<ul>
						<li><a href="portfolio.do">실내조경실적</a></li>
						<li><a href="portfolio_out.do">실외조경실적</a></li>
						<li><a href="portfolio_ect.do">기타조경실적</a></li>

					</ul>
				</div>
			</div>
		</nav>
	</div>
	<div id="objectbanner">
		<div class="bannertxt">CONSULT</div>
		<img
			src="${pageContext.request.contextPath}/resources/image/consultbanner.png">


	</div>

	<div id="wrap">

		<div id="consultfull">
			<div id="notice">
				<div class="noticetxt1">
					<h3 style="font-size: 36px">NOTICE</h3>
					<p>
						요청서 제출전에 연락이 가능하게 성함과 연락처 이메일을 다시 한번 확인부탁드립니다. 1분 내외의 요청서를 작성하면,
						여러 조경 전문가 분들이 맞춤형 견적서를 보내드려요. <br>그 중에 맘에 쏙 드는 맞춤형 조경 서비스를
						받아보세요.
					</p>

					<p style="color: #00761F; font-size: 23px; font-weight: bold;">총
						질문 문항 : 8 문항 &nbsp;&nbsp;&nbsp;&nbsp;예상 소요시간 : 1분</p>

					<p style="color: #969696; font-size: 18px;">*견적서를 받는데에는 최대 3일이
						걸릴 수 있습니다.</p>
					<p style="color: #969696; font-size: 18px;">
						<img
							src="${pageContext.request.contextPath}/resources/image/landscape.png"
							width="200" height="63" alt="" />
					</p>

				</div>
			</div>
			
			<div id="consult"><form id="consultform" action="consultOk.do" method="post">

				<div id="slidecontent">
					<div id="slidePanel">
						<div class="panel1">
							<h1>&nbsp;</h1>
							<h1>&nbsp;</h1>
							<h2>1. 어떤 서비스를 원하시나요?</h2>
							<p>&nbsp;</p>
							<p>&nbsp;</p>

								<table width="520" height="400" border="0" cellspacing="0"
									cellpadding="10">
									<tbody>
										<tr>
											<th scope="row"><input type="radio" name="radio1"
												id="radio1" checked value="조경 설계"> 조경 설계 (기획부터 시공까지)</th>
										</tr>
										<tr>
											<th scope="row"><input type="radio" name="radio1"
												id="radio2" value="시설물 설치"> 시설물 설치 (휴게공간, 놀이시설, 조명 등 설치)</th>
										</tr>
										<tr>
											<th scope="row"><input type="radio" name="radio1"
												id="radio3" value="유지 관리"> 유지 관리 (수목 전지 및 전정, 잔디 관리 등)</th>
										</tr>
										<tr>
											<th scope="row"><input type="radio" name="radio1"
												id="radio4"value="식재 및 수목 관리"> 식재 및 수목 관리 (화단, 나무 심기 등)</th>
										</tr>
										<tr>
											<th scope="row"><input type="radio" name="radio1"
												id="radio5" value="기타"> 기타&nbsp;&nbsp;&nbsp;<input type="text"
												id="etc1"></th>
										</tr>

									</tbody>
								</table>
								<p>
								<p>&nbsp;</p>
								<div id="prevNextButtonBox1">
									<img id="prevButton1"
										src="${pageContext.request.contextPath}/resources/image/consultback.png">
									<img id="nextButton1"
										src="${pageContext.request.contextPath}/resources/image/consultnext.png">
								</div>
								</p>
						</div>


						<div class="panel2">
							<h1>&nbsp;</h1>
							<h1>&nbsp;</h1>
							<h2>2. 시공을 원하는 공간은 어디인가요?</h2>
							<p>&nbsp;</p>
							<p>&nbsp;</p>


							<table id="consultform2" width="520" height="400" border="0"
								cellspacing="0" cellpadding="10">
								<tbody>
									<tr>
										<th scope="row"><input type="radio" name="radio2"
											id="radio6" checked value="실내"> 실내 (실내정원, 벽면, 화분설치)</th>
									</tr>
									<tr>
										<th scope="row"><input type="radio" name="radio2"
											id="radio7" value="실외"> 실외 (정원, 화단, 조형물 설치)</th>
									</tr>
									<tr>
										<th scope="row"><input type="radio" name="radio2"
											id="radio8" value="옥상, 테라스"> 옥상, 테라스</th>
									</tr>
									<tr>
										<th scope="row"><input type="radio" name="radio2"
											id="radio9" value="거리"> 거리 (가로수, 가로등)</th>
									</tr>
									<tr>
										<th scope="row"><input type="radio" name="radio2"
											id="radio10" value="기타"> 기타&nbsp;&nbsp;&nbsp;<input type="text"
											id="etc2"></th>
									</tr>

								</tbody>
							</table>
							<p>
							<p>&nbsp;</p>
							<div id="prevNextButtonBox2">
								<img id="prevButton2"
									src="${pageContext.request.contextPath}/resources/image/consultback.png">
								<img id="nextButton2"
									src="${pageContext.request.contextPath}/resources/image/consultnext.png">
							</div>
							</p>

						</div>


						<div class="panel3">
							<h1>&nbsp;</h1>
							<h1>&nbsp;</h1>
							<h2>3. 예산은 어느정도 범위인가요?</h2>
							<p>&nbsp;</p>
							<p>&nbsp;</p>


							<table id="consultform3" width="520" height="400" border="0"
								cellspacing="0" cellpadding="10">
								<tbody>
									<tr>
										<th scope="row"><input type="radio" name="radio3"
											id="radio11" checked value="500 만원 이하"> 500 만원 이하</th>
									</tr>
									<tr>
										<th scope="row"><input type="radio" name="radio3"
											id="radio12" value="500 만원 ~ 1000 만원"> 500 만원 ~ 1000 만원</th>
									</tr>
									<tr>
										<th scope="row"><input type="radio" name="radio3"
											id="radio13" value="1000 만원 ~ 1500 만원"> 1000 만원 ~ 1500 만원</th>
									</tr>
									<tr>
										<th scope="row"><input type="radio" name="radio3"
											id="radio14" value="1500 만원 ~ 2000 만원"> 1500 만원 ~ 2000 만원</th>
									</tr>
									<tr>
										<th scope="row"><input type="radio" name="radio3"
											id="radio15" value="2000 만원 이상"> 2000 만원 이상</th>
									</tr>

								</tbody>
							</table>
							<p>
							<p>&nbsp;</p>
							<div id="prevNextButtonBox3">
								<img id="prevButton3"
									src="${pageContext.request.contextPath}/resources/image/consultback.png">
								<img id="nextButton3"
									src="${pageContext.request.contextPath}/resources/image/consultnext.png">
							</div>
							</p>

						</div>


						<div class="panel4">
							<h1>&nbsp;</h1>
							<h1>&nbsp;</h1>
							<h2>4.시공을 원하시는 날짜가 있나요?</h2>
							<p>&nbsp;</p>
							<p>&nbsp;</p>


							<table id="consultform4" width="520" height="400" border="0"
								cellspacing="0" cellpadding="10">
								<tbody>
									<tr>
										<th scope="row"><input type="radio" name="radio4"
											id="radio16" checked value="신청 후 5일 ~ 15일"> 신청 후 5일 ~ 15일</th>
									</tr>
									<tr>
										<th scope="row"><input type="radio" name="radio4"
											id="radio17" value="신청 후 15일 ~ 25일"> 신청 후 15일 ~ 25일</th>
									</tr>
									<tr>
										<th scope="row"><input type="radio" name="radio4"
											id="radio18" value="신청 후 25일 ~ 35일"> 신청 후 25일 ~ 35일</th>
									</tr>
									<tr>
										<th scope="row"><input type="radio" name="radio4"
											id="radio19" value="추후 협의 가능합니다"> 추후 협의 가능합니다.</th>
									</tr>
									<tr>
										<th scope="row"><input type="radio" name="radio4"
											id="radio20" value="가능한 빨리 하고 싶어요"> 가능한 빨리 하고 싶어요.</th>
									</tr>

								</tbody>
							</table>
							<p>
							<p>&nbsp;</p>
							<div id="prevNextButtonBox4">
								<img id="prevButton4"
									src="${pageContext.request.contextPath}/resources/image/consultback.png">
								<img id="nextButton4"
									src="${pageContext.request.contextPath}/resources/image/consultnext.png">
							</div>
							</p>

						</div>


						<div class="panel5">
							<h1>&nbsp;</h1>
							<h1>&nbsp;</h1>
							<h2>5. 시공을 원하는 장소는 어디인가요?</h2>
							<p>&nbsp;</p>
							<p>&nbsp;</p>


							<table id="consultform5" width="520" height="250" border="0"
								cellspacing="0" cellpadding="10">
								<tbody>
									<tr>
										<th rowspan="3" scope="row">
											<p>
												<span class="sub">주소입력</span>
											</p> <input type="text" name="address1" id="address1"> <img
											src="${pageContext.request.contextPath}/resources/image/postaddress.png"
											value="우편번호찾기"><br> 
											<input type="text" name="address2" id="address2" size="40" value="">
											<span class="sub">상세 주소 입력</span>
										</th>
									</tr>
								</tbody>
							</table>
							<p>
							<p>&nbsp;</p>
							<div id="prevNextButtonBox5">
								<img id="prevButton5"
									src="${pageContext.request.contextPath}/resources/image/consultback.png">
								<img id="nextButton5"
									src="${pageContext.request.contextPath}/resources/image/consultnext.png">
							</div>
							</p>

						</div>

						<div class="panel6">
							<h1>&nbsp;</h1>
							<h1>&nbsp;</h1>
							<h2>6. 시공 공간은 몇 평인가요?</h2>
							<p>&nbsp;</p>
							<p>&nbsp;</p>


							<table id="consultform6" width="520" height="250" border="0"
								cellspacing="0" cellpadding="10">
								<tbody>
									<tr>
										<th scope="row"><input type="text" name="address3" id="address3"
											size="40">
											<p>&nbsp;</p>
											<p>
												<span class="sub">(ex. 100평 or 2m X 5m)</span>
											</p></th>
									</tr>
								</tbody>
							</table>
							<p>
							<p>&nbsp;</p>
							<div id="prevNextButtonBox6">
								<img id="prevButton6"
									src="${pageContext.request.contextPath}/resources/image/consultback.png">
								<img id="nextButton6"
									src="${pageContext.request.contextPath}/resources/image/consultnext.png">
							</div>
							</p>

						</div>


						<div class="panel7">
							<h1>&nbsp;</h1>
							<h1>&nbsp;</h1>
							<h2>7. 조경 관련 문의 및 희망 사항을 알려주세요!</h2>
							<p>&nbsp;</p>
							<p>&nbsp;</p>


							<table id="consultform7" width="520" height="350" border="0"
								cellspacing="0" cellpadding="10">
								<tbody>
									<tr>
										<th scope="row"><textarea name="address4" id="address4"></textarea>
											<p>&nbsp;</p>
											<p>
												<span class="sub">(ex. 잔디와 바닥 위주의 시공을 원해요.)</span>
											</p></th>
									</tr>
								</tbody>
							</table>
							<p>
							<p>&nbsp;</p>
							<div id="prevNextButtonBox7">
								<img id="prevButton7"
									src="${pageContext.request.contextPath}/resources/image/consultback.png">
								<img id="nextButton7"
									src="${pageContext.request.contextPath}/resources/image/consultnext.png">
							</div>
							</p>

						</div>


						<div class="panel8">
							<h1>&nbsp;</h1>
							<h1>&nbsp;</h1>
							<h2>
								8. 연락받으실 성함과 연락처, 이메일을 <br>입력해주세요.
							</h2>
							<p>&nbsp;</p>
							<p>&nbsp;</p>


							<table id="consultform8" width="520" height="310" border="0"
								cellspacing="0" cellpadding="10">
								<tbody>
									<tr>
										<th scope="row">이름 :&nbsp; <input type="text" name="name" id="name"></th>
									</tr>
									<tr>
										<th scope="row">연락처 : <input type="text" name="phone" id="phone">
										</th>
									</tr>
									<tr>
										<th scope="row">이메일 : <input type="text" name="email" id="email"></th>
									</tr>
								</tbody>
							</table>
							<p>
							<p>&nbsp;</p>
							<div id="prevNextButtonBox8">
								<img id="prevButton8"
									src="${pageContext.request.contextPath}/resources/image/consultback.png" alt="이전">
								<img id="nextButton8"
									src="${pageContext.request.contextPath}/resources/image/consultnext.png" alt="다음">
							</div>
						</div>
					</div>
				</div>
			</form></div>


			<div id="process">
				<h2 style="text-align: center">요청서 처리 안내</h2>
				<div class="processimg">
					<div class="img1">
						<p>&nbsp;</p>
						<p>
							<img
								src="${pageContext.request.contextPath}/resources/image/consult1.png"
								width="105" height="105" alt="" />
						</p>
						<div class="imgtext">
							<h3>요청서 작성</h3>
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
								src="${pageContext.request.contextPath}/resources/image/consult2.png"
								width="105" height="105" alt="" />
						</p>
						<div class="imgtext">
							<h3>요청서 접수</h3>
							<p>&nbsp;</p>
							조경전문가 전달
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
								src="${pageContext.request.contextPath}/resources/image/consult3.png"
								width="105" height="105" alt="" />
						</p>
						<div class="imgtext">
							<h3>견적서 발송</h3>
							<p>&nbsp;</p>
							최대 3일 소요
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
								src="${pageContext.request.contextPath}/resources/image/consult4.png"
								width="105" height="105" alt="" />
						</p>
						<div class="imgtext1">
							<h3>연락 및 시공</h3>
							<p>&nbsp;</p>
							개인상담 및 시공
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
								src="${pageContext.request.contextPath}/resources/image/consult5.png"
								width="115" height="94" alt="" />
						</p>
						<div class="imgtext">
							<h3>시공 완료</h3>
							<p>&nbsp;</p>
							<p>&nbsp;</p>
						</div>
					</div>

				</div>


			</div>

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