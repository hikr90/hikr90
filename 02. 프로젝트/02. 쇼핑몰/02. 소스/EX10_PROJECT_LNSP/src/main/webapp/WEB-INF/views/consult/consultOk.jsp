<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../front/header.jsp"%>
<link
	href="${ pageContext.request.contextPath }/resources/css/consultOk.css"
	rel="stylesheet" type="text/css">
<link
	href="${ pageContext.request.contextPath }/resources/css/menu1.css"
	rel="stylesheet" type="text/css">
<script
	src="${ pageContext.request.contextPath }/resources/js/consultform.js"></script>
</head>
	<div id="objectbanner">
		<div id="bannertxt">CONSULT</div>
		<img
			src="${ pageContext.request.contextPath }/resources/image/consultbanner.png">


	</div>

	<div id="wrap">
		<div id="consult">
			<div id="orderOK">
				<img
					src="${ pageContext.request.contextPath }/resources/image/ok.png"
					alt="" />
				<div class="orderOKtxt">
					<h1 style="font-size: 36px">요청서가 정상적으로 제출되었습니다.</h1>
					<p>&nbsp;</p>
					<p>최대한 빠른 시일내에 견적서를 보내드리도록 노력하겠습니다.</p>
					<p>견적서를 받는데에는 최대 3일이 걸릴 수 있습니다.</p>
				</div>
			</div>
			<div id="consultOk">
				<form id="consultOkform">
					<h2 style="font-size: 26px">견적서 요청 내역</h2>
					<p>&nbsp;</p>
					<table width="1120" height="900" cellspacing="0">

						<thead>
							<tr>
								<th width="170" height="80">이름</th>
								<td><pre>${vo.m_name}</pre></td>
							</tr>
							<tr>
								<th width="170" height="80">연락처</th>
								<td><pre>${vo.m_phone}</pre></td>
							</tr>
							<tr>
								<th width="170" height="80">이메일</th>
								<td><pre>${vo.m_email}</pre></td>
							</tr>
							<tr>
								<th width="170" height="80">서비스</th>
								<td width="683">&nbsp;<pre>${vo.est_type}</pre></td>
							</tr>
							<tr>
								<th width="170" height="80">공간</th>
								<td><pre>${vo.est_place}</pre></td>
							</tr>
							<tr>
								<th width="170" height="80">예산</th>
								<td><pre>${vo.est_price}</pre></td>
							</tr>
							<tr>
								<th width="170" height="80">날짜</th>
								<td><pre>${vo.est_day}</pre></td>
							</tr>
							<tr>
								<th width="170" height="80">장소</th>
								<td><pre>${vo.est_region}</pre></td>
							</tr>
							<tr>
								<th width="170" height="80">평수</th>
								<td><pre>${vo.est_space}</pre></td>
							</tr>
							<tr>
								<th width="170" height="180">희망 사항</th>
								<td><pre>${vo.est_memo}</pre></td>
							</tr>


						</thead>

					</table>
					<p>&nbsp;</p>
					<p>
						<a href="index.do"><img
							src="${ pageContext.request.contextPath }/resources/image/consultOk.png"
							alt="" /></a>
					</p>
				</form>
			</div>
		</div>



		<div id="process">
			<h2 style="text-align: center; font-size: 26px;">요청서 처리 안내</h2>
			<div class="processimg">
				<div class="img1">
					<p>&nbsp;</p>
					<p>
						<img
							src="${ pageContext.request.contextPath }/resources/image/consult1.png"
							width="100" height="100" alt="" />
					</p>
					<div class="imgtext">
						<h3>요청서 작성</h3>
					</div>

				</div>
				<div class="next">
					<img
						src="${ pageContext.request.contextPath }/resources/image/next.png"
						width="62" height="200" alt="" />
				</div>

				<div class="img1">
					<p>&nbsp;</p>
					<p>
						<img
							src="${ pageContext.request.contextPath }/resources/image/consult2.png"
							width="100" height="100" alt="" />
					</p>
					<div class="imgtext">
						<h3>요청서 접수</h3>
						<p>&nbsp;</p>
						조경전문가 전달
					</div>
				</div>
				<div class="next">
					<img
						src="${ pageContext.request.contextPath }/resources/image/next.png"
						width="62" height="200" alt="" />
				</div>

				<div class="img1">
					<p>&nbsp;</p>
					<p>
						<img
							src="${ pageContext.request.contextPath }/resources/image/consult3.png"
							width="100" height="100" alt="" />
					</p>
					<div class="imgtext">
						<h3>견적서 발송</h3>
						<p>&nbsp;</p>
						최대 3일 소요
					</div>
				</div>
				<div class="next">
					<img
						src="${ pageContext.request.contextPath }/resources/image/next.png"
						width="62" height="200" alt="" />
				</div>

				<div class="img1">
					<p>&nbsp;</p>
					<p>
						<img
							src="${ pageContext.request.contextPath }/resources/image/consult4.png"
							width="100" height="100" alt="" />
					</p>
					<div class="imgtext1">
						<h3>연락 및 시공</h3>
						<p>&nbsp;</p>
						개인상담 및 시공
					</div>
				</div>
				<div class="next">
					<img
						src="${ pageContext.request.contextPath }/resources/image/next.png"
						width="62" height="200" alt="" />
				</div>

				<div class="img2">
					<p>&nbsp;</p>
					<p>
						<img
							src="${ pageContext.request.contextPath }/resources/image/consult5.png"
							width="110" height="92" alt="" />
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
	<%@include file="../front/footer.jsp"%>