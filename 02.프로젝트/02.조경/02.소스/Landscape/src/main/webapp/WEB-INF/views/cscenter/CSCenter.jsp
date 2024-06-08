<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/header.jsp"%>
<link
	href="${pageContext.request.contextPath}/resources/css/CScenter.css"
	rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/resources/css/menu1.css" rel="stylesheet" type="text/css">
<%-- httpRequest.js : 경로 확인할것--%>
<link href="${pageContext.request.contextPath}/resources/css/CSnotice.css" rel="stylesheet" type="text/css">
<script
	src="${pageContext.request.contextPath}/resources/js/CScenter.js"></script>
	<script
	src="${pageContext.request.contextPath}/resources/js/httpRequest.js"></script>
<script type="text/javascript">
		function readhitUp(idx) {
			var url = "readhit.do";
			var param = "idx=" + idx;
			sendRequest(url, param, resultFn, "GET");
		}
		function resultFn(){
			if( xhr.readyState == 4 && xhr.status == 200 ){
			}
		}
	</script>
<div id="objectbanner">
	<div id="bannertxt">고객센터</div>
	<img src="${pageContext.request.contextPath}/resources/image/CScenter.png">
</div>
<div id="wrap">
	<div id="submenu">
		<ul>
			<li><a href="cscenter_notice.do">공지사항</a></li>
			<li><a href="cscenter_order.do">주문 / 결제 FAQ</a></li>
			<li><a href="cscenter_refund.do">반품 / 교환 FAQ</a></li>
			<li><a href="cscenter_delivery.do">배송 FAQ</a></li>
			<li><a href="cscenter_member.do">회원 FAQ</a></li>

		</ul>
	</div>

	<div id="product">
		<form id="productform">
			<h2>${mainText}</h2>
			<p>&nbsp;</p>
			<p>
				* <strong>${subText}</strong>
			</p>
			<p>&nbsp;</p>
			<table border="0" cellpadding="10" cellspacing="0">
				<!-- 테이블!!! -->
				<tbody>
					<tr>
						<th width="110" height="50" scope="row">번호</th>
						<th width="120">구분</th>
						<th width="750">제목</th>


					</tr>
					<%
						int i = 0;
					%>
					<c:forEach var="vo" items="${list}">
						<%
							i++;
						%>
						<tr>

							<td height="80" scope="row"><%=i%></td>
							<td width="120">${vo.category}</td>
							<td width="750"><div class="question1">
									<p>&nbsp;</p>
									<p>
										<a href="#"
											onclick="SirenFunction1('SirenDiv<%=i %>'); readhitUp(${vo.idx}); return false; "
											class="blind_view1">${vo.question}</a>
									</p>
								</div>
								<div class="answer_view<%=i%>" id="SirenDiv<%=i%>">
									<pre>${vo.answer}</pre>
								</div></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
		</form>


	</div>

</div>
<%@include file="/WEB-INF/views/include/footer.jsp"%>
