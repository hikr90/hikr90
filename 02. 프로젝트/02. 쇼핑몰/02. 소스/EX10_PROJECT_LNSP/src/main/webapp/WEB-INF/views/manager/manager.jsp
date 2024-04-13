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
	;
}
</style>


<link
	href="${pageContext.request.contextPath}/resources/css/manager.css"
	rel="stylesheet" type="text/css">
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
</head>

<body>
<div id="wrap">
	<jsp:include page="common_top.jsp"></jsp:include>	
	<jsp:include page="common_menu.jsp"></jsp:include>
	
	<div id="main">
			<div class="totalbar">
				<h2 style="font-size: 24px">주문 현황</h2>
				<form id="totalform">
					<table cellspacing="0" cellpadding="0">
						<tbody>
							<tr>
								<th scope="row" width="158" height="80">총 주문</th>
								<th width="158" height="90">입금확인</th>
								<th width="158" height="90">배송중</th>
								<th width="158" height="90">배송완료</th>
								<th width="158" height="90">취소</th>
								<th width="158" height="90">교환</th>
								<th width="158" height="90">환불</th>
								<th width="158" height="90">1:1 문의</th>
								<th width="158" height="90">상품 문의</th>
							</tr>
							<tr>
								<td scope="row" height="70">${order_count.idx1}</td>
								<td>${order_count.idx2}</td>
								<td>${order_count.idx3}</td>
								<td>${order_count.idx4}</td>
								<td>${order_count.idx5}</td>
								<td>${order_count.idx6}</td>
								<td>${order_count.idx7}</td>
								<td>${order_count.idx8}</td>
								<td>${order_count.idx9}</td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
			<div class="product">
				<div class="producttitle">
					<div class="titletxt">상품 현황</div>
					<div class="more">
						<a href="manager_product.do">MORE</a>
					</div>
				</div>

				<form id="productform">
					<table width="318" height="320" border="0" cellpadding="0"
						cellspacing="0">
						<tbody>
							<tr>
								<th scope="row" width="120">등록 상품</th>
								<td width="60">${goodcount.total}건</td>
							</tr>
							<tr>
								<th scope="row" width="120">판매중 상품</th>
								<td width="60">${goodcount.sale}건</td>
							</tr>
							<tr>
								<th scope="row" width="120">품절 상품</th>
								<td width="60">${goodcount.soldout}건</td>
							</tr>
							<tr>
								<th scope="row" width="120">삭제 상품</th>
								<td width="60">${goodcount.delete}건</td>
							</tr>
						</tbody>
					</table>
				</form>

			</div>
			<div class="estimate">
				<div class="producttitle">
					<div class="titletxt">견적 현황</div>
					<div class="more">
						<a href="#">MORE</a>
					</div>
				</div>
				<form id="estimateform">
					<table width="318" height="320" border="0" cellpadding="0"
						cellspacing="0">
						<tbody>
							<tr>
								<th scope="row" width="120">조경 설계</th>
								<td width="60">${estimate_c.landscape }건</td>
							</tr>
							<tr>
								<th scope="row" width="120">시설물 설치</th>
								<td width="60">${estimate_c.facility }건</td>
							</tr>
							<tr>
								<th scope="row" width="120">유지 관리</th>
								<td width="60">${estimate_c.maintenance }건</td>
							</tr>
							<tr>
								<th scope="row" width="120">수목 관리</th>
								<td width="60">${estimate_c.tree }건</td>
							</tr>
							<tr>
								<th scope="row" width="120">기타</th>
								<td width="60">${estimate_c.other }건</td>
							</tr>
						</tbody>
					</table>
				</form>

			</div>

			<div class="question">
				<div class="producttitle">
					<div class="titletxt">1:1 문의</div>
					<div class="more">
						<a href="manager_1to1QNA.do">MORE</a>
					</div>
				</div>
				<form id="questionform">
					<table width="318" height="320" border="0" cellpadding="0"
						cellspacing="0">
						<tbody>
							<tr>
								<th scope="row" width="120">문의 등록수</th>
								<td width="60">${count_map.total}건</td>
							</tr>
							<tr>
								<th scope="row" width="120">답변대기중</th>
								<td width="60">${count_map.waiting}건</td>
							</tr>
							<tr>
								<th scope="row" width="120">답변 완료</th>
								<td width="60">${count_map.answered}건</td>
							</tr>
						</tbody>
					</table>
				</form>

			</div>

			<div class="itemqna">
				<div class="producttitle">
					<div class="titletxt">상품 문의</div>
					<div class="more">
						<a href="manager_itemQNA.do">MORE</a>
					</div>
				</div>
				<form id="itemqnaform">
					<table width="318" height="320" border="0" cellpadding="0"
						cellspacing="0">
						<tbody>
							<tr>
								<th scope="row" width="120">문의 등록수</th>
								<td width="60">${itemqna.total}건</td>
							</tr>
							<tr>
								<th scope="row" width="120">답변대기중</th>
								<td width="60">${itemqna.waiting}건</td>
							</tr>
							<tr>
								<th scope="row" width="120">답변 완료</th>
								<td width="60">${itemqna.answered}건</td>
							</tr>
						</tbody>
					</table>
				</form>

			</div>
			<div class="notice">
				<div class="noticetitle">공지사항</div>
				<div class="noticetxt">
					<p>
						<a href="#">[공지] 고객센터 운영시간 임시 변경 안내</a>
					</p>
					<p>
						<a href="#">[공지] 핸드폰 결제 서비스 이용 안내</a>
					</p>
					<p>
						<a href="#">[공지] IslandScape 온라인몰 서비스 점검 안내</a>
					</p>
					<p>
						<a href="#">[공지] 시설관리에 의한 일부서비스 중단안내</a>
					</p>
					<p>
						<a href="#">[공지] 휴대폰 결제 시스템 일시 중지 안내</a>
					</p>
					<p>
						<a href="#">[공지] IslandScape 온라인몰 서비스 일시 중단 안내</a>
					</p>
					<p>
						<a href="#">[공지] 시스템 점검 관련 회원 로그인 불가안내</a>
					</p>
				</div>


			</div>

			<div class="update">
				<div class="noticetitle">업그레이드</div>
				<div class="noticetxt">
					<p>
						<a href="#">[주문관리] 한국 우편번호로 검색한 주소 입력방식 개선 안내</a>
					</p>
					<p>
						<a href="#">[고객관리] 운영자의 개인정보조회 권한 제한 영역 확대 안내</a>
					</p>
					<p>
						<a href="#">[고객관리] 회원가입 시 휴대폰 인증 간소화 서비스 추가 </a>
					</p>
					<p>
						<a href="#">[게시판관리] 일반 상품후기 작성 관련 개선 안내</a>
					</p>
					<p>
						<a href="#">[상품관리] 운영자 상품 분류 관리 등록/수정 권한 추가</a>
					</p>
					<p>
						<a href="#">[상품관리] 상품옵션 설정 기능개선 안내</a>
					</p>
					<p>
						<a href="#">[주문관리] 주문자정보 수정 기능 추가 안내</a>
					</p>
				</div>

			</div>



		</div>
	</div>


</body>
</html>
