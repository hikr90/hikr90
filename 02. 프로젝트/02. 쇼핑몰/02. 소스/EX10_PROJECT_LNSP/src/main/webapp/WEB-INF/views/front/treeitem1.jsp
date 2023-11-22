<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<%@include file="check_login.jsp"%>
<style type="text/css">
a:link {
	text-decoration: none;
	font-family: "나눔스퀘어";
}
</style>
<link
	href="${ pageContext.request.contextPath }/resources/css/treeitem1.css"
	rel="stylesheet" type="text/css">
<script src="${ pageContext.request.contextPath }/resources/js/tab.js"></script>
<script
	src="${ pageContext.request.contextPath }/resources/js/js_package.js"></script>
<script
	type="${ pageContext.request.contextPath }/resources/text/javascript"></script>
<script
	type="${ pageContext.request.contextPath }/resources/js/httpRequest.js"></script>
<script>
	function MM_openBrWindow(theURL, winName, features) { //v2.0
		window.open(theURL, winName, features);
	}

	function cart(g_num, g_price, g_name) {

		var url = "cart_insert.do";
		var param = "g_num=" + g_num + "&g_price=" + g_price + "&g_name="
				+ g_name + "&count=" + document.getElementById("cnt").value;
		sendRequest(url, param, resultFn, "get");
	}

	function resultFn() {

		if (xhr.readyState == 4 && xhr.status == 200) {
			var data = xhr.responseText;

			if (data == 'yes') {
				alert("장바구니에 담았습니다");
				if (!confirm("장바구니로 이동하시겠습니까?")) {
					return;
				}
				location.href = "cart.do";
			} else {
				alert("이미 장바구니에 담겨있습니다");
			}
			location.href = "cart.do";
		}
	}
</script>
</head>
<div id="wrap">

	<div id="history">
		<p>
			HOME > PRODUCT > <a href="tree.do?category=${ vo.category }">${ vo.category }</a>
		</p>
	</div>
	<div id="item">
		<form id="tree" name="product" action="order_temp.do">
			<table width=1180 height=550 cellpadding=10>
				<input type="hidden" name="g_num" value="${vo.g_num }">
				<input type="hidden" name="g_name" value="${vo.g_name }">
				<input type="hidden" name="g_price" value="${vo.g_price }">
				<tr>
					<td rowspan=8 align=center width=570 height="550"><img
						src="${pageContext.request.contextPath}/resources/image/${ vo.g_image_l }"
						width="550" height="550"></td>
					<th colspan=3 align=left height="66"><h2>${ vo.g_name }</h2></th>
				</tr>
				<th align=left width=100 height="60">판매가</th>
				<td colspan=2 align=left>${ vo.g_price }원</td>
				</tr>
				<tr>
					<th align=left width=100 height="60">상품타입</th>
					<td colspan=2 align=left><c:choose>
							<c:when test="${vo.g_type eq 1}">
									생화							
								</c:when>
							<c:when test="${vo.g_type eq 2}">
									조화							
								</c:when>
						</c:choose></td>
				</tr>

				<tr>
					<th align=left width=100 height="60">배송구분</th>
					<td colspan=2 align=left><c:choose>
							<c:when test="${vo.g_delivery eq 1}">
									택배 배송							
								</c:when>
							<c:when test="${vo.g_delivery eq 2}">
									국내 특급							
								</c:when>
							<c:when test="${vo.g_delivery eq 3}">
									해외 배송					
								</c:when>
							<c:when test="${vo.g_delivery eq 4}">
									해외 특급						
								</c:when>
						</c:choose></td>
				</tr>
				<tr>
					<th align=left width=100 height="60">원산지</th>
					<td colspan=2 align=left>${vo.g_country }</td>
				</tr>

				<th width=100 height="60" align=left>주문수량</th>
				<td align=left width="70"><p>
						<input type=text name="count" size=5 value="1" id="cnt"
							style="width: 30; height: 20" onblur="javascript:amountCheck();">개
					</p></td>
				<td align=left width="280">
					<p>
						<input type=button value="▲" onClick="javascript:amountPlus();"
							style="width: 18; height: 16;"><br> <input
							type=button value="▼" onClick="javascript:amountMinus();"
							style="width: 18; height: 16;">
					</p>
				</td>
				<tr>
					<c:if test="${ vo.g_condition eq 1 }">
						<th class="border" height="80" colspan=3 align=left>본사진은
							실제상품과 상이 할 수 있습니다.</th>
					</c:if>
					<c:if test="${ vo.g_condition eq 2 }">
						<th class="border" height="80" colspan=3 align=left>선택하신 상품이
							일시품절되었습니다.</th>
					</c:if>
					<c:if test="${ vo.g_condition eq 3 }">
						<th class="border" height="80" colspan=3 align=left>현재 판매가
							중단된 상품입니다.</th>
					</c:if>

				</tr>
				<tr>

					<th colspan=3 align=left><c:if test="${ vo.status eq 1 }">


						</c:if> <c:if test="${ vo.status eq 0 }">
							<button type="sumbit">
								<img
									src="${pageContext.request.contextPath}/resources/image/buy.png"
									width="127" height="55" alt="" /> &nbsp;&nbsp;&nbsp;
							</button>
							<button type="button" value="${ member.idx }"
								onclick="cart('${vo.g_num}', '${vo.g_price}', '${vo.g_name}')">

								<img
									src="${pageContext.request.contextPath}/resources/image/cart.png"
									width="127" height="55" alt="" />
							</button>
						</c:if></th>
				</tr>
			</table>
		</form>


	</div>

	<div id="explaintable">
		<div id="tab1">
			<ul class="tab" id="tab">
				<li><a href="treeitem1.do?idx=${ vo.idx }#explaintable">상품설명</a></li>
				<li><a href="treeitem1.do?idx=${ vo.idx }#review">상품후기</a></li>
				<li><a href="treeitem1.do?idx=${ vo.idx }#question">상품 Q&A</a></li>
				<li><a href="treeitem1.do?idx=${ vo.idx }#delivery">배송 / 교환
						/ 환불</a></li>
			</ul>

			<div class="tab_con" id="tab_con"></div>
		</div>
		<h2>필수입력정보</h2>
		<p>&nbsp;</p>
		<form id="explainform">
			<table width="1180" height="300" border="0" cellpadding="10"
				cellspacing="0">

				<tbody>
					<tr>
						<th width="182" scope="row">상품명</th>
						<td width="283">${ vo.g_name }</td>
						<th width="182" scope="row">상품번호</th>
						<td>${ vo.idx }</td>
					</tr>
					<tr>
						<th width="182" scope="row">원산지</th>
						<td>${ vo.g_country }</td>
						<th width="182" scope="row">제조사</th>
						<td>${ vo.g_company }</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	<div id="picture">

		<p>
			<img
				src="${pageContext.request.contextPath}/resources/image/${ vo.g_content }">
		</p>

		<div class="notice">
			<h2>유의사항</h2>
			<p>&nbsp;</p>
			<p>
				살아있는 생물 이라 사진과 상이 할 수 있습니다.<br> 잎이 없어도 살아있는 생물이며 철저히 검사되어
				발송되지만,혹시나 뿌리가 상했거나 줄기가 마른경우 <br> 3일이내로 환불 및 교환이 가능합니다. 단 심은후에는
				환불과 교환이 불가합니다.<br> 싹이 아직 나오지 않은 상태여도 포트안에 싹이 잠들어있습니다. 이는 정상적인
				상품이오니 안심하고 심어주세요.<br> 기타 문의는 고객센터 (tel. 070-5433-2545) 로 문의
				부탁드립니다.
			</p>
		</div>

	</div>


	<div id="delivery">

		<form id="deliveryform">

			<h2>배송 / 교환 / 환불</h2>
			<p>&nbsp;</p>
			<table width="1180" height="230" border="0" cellpadding="10"
				cellspacing="0">
				<tbody>
					<tr>
						<th width="237" height="70" scope="row">&gt; 배송정보</th>
						<td width="817"><p>&nbsp;</p>
							<p>
								배송기간은 주문일(무통장입금은 결제완료일)로부터 1일(24시간) ~ 5일정도 걸립니다.<br> 단, 지정일
								배송이 가능한 플라워 상품이나, 제작기간이 별도로 소요되는 상품의 경우에는 <br> 상품설명에 있는
								제작기간과 배송시기를 숙지해 주시기 바랍니다.<br> 업체조건배송 상품은 해당 브랜드 배송기준으로 배송비가
								부여됩니다. 업체착불배송 상품은 해당 브랜드 <br> 배송기준 및 배송지에 따라 배송비가 착불로
								부과됩니다.<br> 가구 및 플라워 등의 상품의 경우에는 지역에 따라 추가 배송비용이 발생할 수 있음을
								알려드립니다.
							</p>
							<p>&nbsp;</p>
							<p>&nbsp;</p>
							<p>&nbsp;</p></td>
					</tr>
					<tr>
						<th scope="row" height="150"><p>&gt; 교환 / 환불</p>
							<p>&nbsp;</p></th>
						<td>
							<p>
								교환/반품 신청은 배송완료 후 7일 이내 가능합니다.<br> 변심 반품의 경우 왕복배송비를 차감한 금액이
								환불되며, 제품 및 포장 상태가 재판매 가능하여야 합니다.<br> 상품 불량인 경우는 배송비를 포함한
								전액이 환불됩니다.<br> 출고 이후 환불요청 시 상품 회수 후 처리됩니다.<br> 쥬얼리를
								포함한 주문제작 상품/카메라/밀봉포장상품/플라워 등은 변심으로 인한 반품/환불이 불가합니다.<br>
								완제품으로 수입된 상품의 경우 A/S가 불가합니다.<br> 상품페이지에 교환/환불/AS에 대한 브랜드
								개별기준이 있는 경우에는 해당 내용이 우선 적용 됩니다.
							</p>
							<p>&nbsp;</p>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	<div id="review">
		<form id="reviewtable">
			<h2>
				상품후기<span class="reviewImg"><img
					src="${pageContext.request.contextPath}/resources/image/reviewtxt.png"
					alt=""
					onClick="MM_openBrWindow('review.html','','width=740,height=920')" /></span>
			</h2>
			<p>&nbsp;</p>
			<table width="1180" height="200" border="0" cellpadding="10"
				cellspacing="0">
				<tbody>
					<tr>
						<th width="88" height="50" scope="row">번호</th>
						<th width="771">상품평</th>

						<th width="132">작성일</th>
						<th width="109">작성자</th>
					</tr>
					<tr>
						<td height="120" scope="row">&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>

				</tbody>
			</table>

		</form>
	</div>
	<div id="question">
		<form id="questiontable">
			<h2>
				상품문의 <span class="reviewImg"> <c:if
						test="${ !empty sessionScope.user.idx }">
						<img
							src="${pageContext.request.contextPath}/resources/image/question.png"
							alt=""
							onClick="MM_openBrWindow('qnaprodform.do?member_idx=${ sessionScope.user.idx }&goods_idx=${ vo.idx }','','width=740,height=920')"
							style="cursor: pointer;" />
					</c:if>
				</span>
			</h2>
			<p>&nbsp;</p>
			<a name="prodqna"></a>
			<table width="1180" height="200" border="0" cellpadding="10"
				cellspacing="0">
				<tbody>
					<tr>
						<th width="100" height="50" scope="row">번호</th>
						<th width="140">작성일</th>
						<th width="700">제목</th>

						<th width="140">작성자</th>
						<th width="120">답변</th>
					</tr>

					<c:forEach var="q_vo" items="${ list }">

						<c:if test="${ vo.idx eq q_vo.goods_idx }">
							<tr>
								<td height="121" scope="row">${ q_vo.q_infonum }</td>
								<td>${ q_vo.q_regdate }</td>
								<td><c:if test="${ q_vo.q_delete eq 1 }">
										<a href="" style="color: gray; text-decoration: line-through;">
											${ q_vo.q_title  } </a>
									</c:if> <!-- 삭제안된 글일경우 클릭 가능 --> <c:if test="${ q_vo.q_delete eq 0 }">
										<a href="qnaprodanswerInGoodsview.do?q_idx=${ q_vo.q_idx }">
											${ q_vo.q_title } </a>
									</c:if></td>

								<td>${ q_vo.m_name }</td>
								<td>									
									<c:if test="${ q_vo.q_qnayn eq 0 }">
										N
									</c:if>
									<c:if test="${ q_vo.q_qnayn eq 1 }">
										Y
									</c:if>
								</td>
						</tr>
						</c:if>

					</c:forEach>

					<c:if test="${ empty list }">

						<tr>
							<td colspan="5">질문이 없습니다
							<td>
						</tr>

					</c:if>


				</tbody>
			</table>


			<c:if test="${ row_total ne 0 }">
				<p align="center" id="page_menu">${pageMenu}</p>
			</c:if>

		</form>

	</div>
</div>
<%@include file="footer.jsp"%>