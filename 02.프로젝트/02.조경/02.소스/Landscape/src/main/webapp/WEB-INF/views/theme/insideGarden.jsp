<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="themeheader.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=euc-kr">
<title>IslandScape</title>
<style type="text/css">
a:link {
	text-decoration: none;
	;
}
</style>


<link
	href="${pageContext.request.contextPath}/resources/css/insideGarden.css"
	rel="stylesheet" type="text/css">
</head>

<body>

	<div id="objectbanner">
		<div id="bannertxt">THEME</div>
		<img
			src="${pageContext.request.contextPath}/resources/image/insidebanner.png">


	</div>

	<div id="tab1">
			<ul class="tab" id="tab">
				<li><a href="insideGarden.do">실내조경</a></li>
				<li><a href="outsideGarden.do">실외조경</a></li>
				<li><a href="ectGarden.do">기타조경</a></li>
			</ul>
			<div class="tab_con" id="tab_con"></div>
		</div>


	<div id="wrap">


		<div id="content1">
			<div class="text1">실내조경</div>
			<div>
				<img
					src="${pageContext.request.contextPath}/resources/image/bar.png"
					width="80" height="15">
			</div>
		</div>


		<div id="content2">
			<div id="pic1">
				<div class="advice">
					<img
						src="${pageContext.request.contextPath}/resources/image/counsel.png"
						width="150" height="150">
				</div>
				<div class="advicetext">상담</div>
			</div>
			<div class="next">
				<img
					src="${pageContext.request.contextPath}/resources/image/next.png"
					width="62" height="200" alt="" />
			</div>
			<div id="pic2">
				<div class="advice">
					<img
						src="${pageContext.request.contextPath}/resources/image/plan.png"
						width="150" height="150">
				</div>
				<div class="advicetext">설계</div>
			</div>
			<div class="next">
				<img
					src="${pageContext.request.contextPath}/resources/image/next.png"
					width="62" height="195" alt="" />
			</div>
			<div id="pic3">
				<div class="advice">
					<img
						src="${pageContext.request.contextPath}/resources/image/estimate.png"
						width="150" height="150">
				</div>
				<div class="advicetext">견적</div>
			</div>
			<div class="next">
				<img
					src="${pageContext.request.contextPath}/resources/image/next.png"
					width="62" height="195" alt="" />
			</div>
			<div id="pic4">
				<div class="advice">
					<img
						src="${pageContext.request.contextPath}/resources/image/construction.png"
						width="150" height="150">
				</div>
				<div class="advicetext">시공</div>
			</div>
			<div class="next">
				<img
					src="${pageContext.request.contextPath}/resources/image/next.png"
					width="62" height="195" alt="" />
			</div>
			<div id="pic5">
				<div class="advice">
					<img
						src="${pageContext.request.contextPath}/resources/image/maintain.png"
						width="150" height="150">
				</div>
				<div class="advicetext">유지/관리</div>
			</div>
		</div>

		<div id="content3">
			<div class="text2">
				<div class="title">
					<img
						src="${pageContext.request.contextPath}/resources/image/symbol.png"
						alt="" /> 실내정원 / 벽면녹화
				</div>
				<div class="text2-1">
					평범한 건물 벽면에 생명을 불어 넣는 녹화는 오피스와 건물<br>의 분위기 크게 변화시킬 수 있는데 큰 도움을
					줍니다.
					<p>&nbsp;</p>
					오피스와 건물의 랜드마크가 될 수 있는 수직정원과 벽면녹화를 다양한 사이즈와 수종으로 제안해 드릴 수 있으며, 정기<br>적으로
					방문해 체계적이고 과학적인 유지관리를 해드립니다.
					<p>&nbsp;</p>
					식재 식물은 미세먼지 제거에 탁월한 검증된 종을 선정해 <br>적정한 생육과 유지관리가 쉬울 수 있도록 설계해
					드립니다.
				</div>
			</div>
			<div class="inside1">
				<img
					src="${pageContext.request.contextPath}/resources/image/indoor1.png"
					alt="" />
			</div>
			<div class="indoor1">
				<div class="indoor1_1">
					<img
						src="${pageContext.request.contextPath}/resources/image/indoor2.png"
						width="360" height="270" alt="" />
				</div>
				<div class="indoor1_2">
					<img
						src="${pageContext.request.contextPath}/resources/image/indoor3.png"
						width="360" height="270" alt="" />
				</div>
				<div class="indoor1_3">
					<img
						src="${pageContext.request.contextPath}/resources/image/indoor4.png"
						width="360" height="270" alt="" />
				</div>
			</div>

		</div>
	</div>
	<div id="content4">
		<div id="full">
			<div class="design">
				<img
					src="${pageContext.request.contextPath}/resources/image/indoor5.png"
					alt="" />
			</div>

			<div id="text3">
				<div class="title">
					<img
						src="${pageContext.request.contextPath}/resources/image/symbol2.png"
						alt="" /> 조경인테리어디자인
				</div>
				<div class="text3-1">
					평범한 건물 벽면에 생명을 불어 넣는 녹화는 오피스와 <br>건물의분위기 크게 변화시킬 수 있는데 큰 도움을
					줍니다.
					<p>&nbsp;</p>
					오피스와 건물의 랜드마크가 될 수 있는 수직정원과 벽면녹화를 다양한 사이즈와 수종으로 제안해 드릴 수 있으며, 정기적으로
					방문해 체계적이고 과학적인 유지관리를 해드립니다.
					<p>&nbsp;</p>
					식재 식물은 미세먼지 제거에 탁월한 검증된 종을 선정해 <br> 적정한 생육과 유지관리가 쉬울 수 있도록 설계해
					드립니다.
				</div>
			</div>
		</div>
	</div>
	<div id="content5">

		<div class="inside3">
			<img src="${pageContext.request.contextPath}/resources/image/indoor6.png" alt="" />
		</div>
		<div id="text4">

			<div class="text4-1">
				평범한 건물 벽면에 생명을 불어 넣는 녹화는 오피스와 건물<br>의 분위기 크게 변화시킬 수 있는데 큰 도움을
				줍니다.
				<p>&nbsp;</p>
				오피스와 건물의 랜드마크가 될 수 있는 수직정원과 벽면녹화를 다양한 사이즈와 수종으로 제안해 드릴 수 있으며, 정기<br>적으로
				방문해 체계적이고 과학적인 유지관리를 해드립니다.
				<p>&nbsp;</p>
			</div>
		</div>
	</div>

	<div id="content6">


		<div class="text5">
			<div class="title">
				<img
					src="${pageContext.request.contextPath}/resources/image/symbol.png"
					alt="" /> 화분설치 / 화분관리
			</div>
			<div class="text5-1">
				평범한 건물 벽면에 생명을 불어 넣는 녹화는 오피스와 건물<br>의 분위기 크게 변화시킬 수 있는데 큰 도움을
				줍니다.
				<p>&nbsp;</p>
				오피스와 건물의 랜드마크가 될 수 있는 수직정원과 벽면녹화를 다양한 사이즈와 수종으로 제안해 드릴 수 있으며, 정기<br>적으로
				방문해 체계적이고 과학적인 유지관리를 해드립니다.
				<p>&nbsp;</p>
				식재 식물은 미세먼지 제거에 탁월한 검증된 종을 선정해 <br>적정한 생육과 유지관리가 쉬울 수 있도록 설계해
				드립니다.
			</div>
		</div>
		<div class="inside4">
			<img
				src="${pageContext.request.contextPath}/resources/image/indoor7.png"
				alt="" />
		</div>
		<div class="indoor2">
			<div class="indoor2_1">
				<img
					src="${pageContext.request.contextPath}/resources/image/indoor8.png"
					width="560" height="380" alt="" />
			</div>
			<div class="indoor2_2">
				<img
					src="${pageContext.request.contextPath}/resources/image/indoor9.png"
					width="560" height="380" alt="" />
			</div>
		</div>


	</div>

	<%@include file="/WEB-INF/views/include/footer.jsp"%>