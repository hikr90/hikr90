<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/header.jsp"%>
<script>
		function readhitUp(idx) {
			var url = "readhit.do";
			var param = "idx=" + idx;
			sendRequest(url, param, resultFn, "GET");
		}
		function resultFn(){
			if( xhr.readyState == 4 && xhr.status == 200 ){
			}
		}
		function scbutton(f){
			location.href="cscenter_result.do?sc=" + f.sctext.value;
		}
		
	</script>
<!-- 		<link -->
<%-- 	href="${ pageContext.request.contextPath }/resources/css/menu1.css" --%>
<!-- 	rel="stylesheet" type="text/css"> -->

<link
	href="${pageContext.request.contextPath}/resources/css/CScenter.css"
	rel="stylesheet" type="text/css">
<%-- httpRequest.js : 경로 확인할것--%>
<script
	src="${pageContext.request.contextPath}/resources/js/CScenter.js"></script>
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
				<tbody>
					<tr>
						<th width="110" height="50" scope="row">번호</th>
						<th width="730">제목</th>
						<th width="130">등록일</th>
					</tr>
					<%
						int i = 0;
					%>
					<c:forEach var="vo" items="${list}">
						<%
							i++;
						%>
						<tr>
							<td height="60" scope="row">${vo.notice_idx}</td>
							<td width="730"><div class="question<%=i%>">
									<p>&nbsp;</p>
									<p>
										<a href="#"
											onclick="SirenFunction<%=i %>('SirenDiv<%=i %>'); readhitUp(${vo.idx}); return false; "
											class="blind_view<%=i %>">&#91;${vo.category}&#93;
											${vo.question}</a>
									</p>
								</div>
								<div class="answer_view<%=i%>" id="SirenDiv<%=i%>">
									<pre>${vo.answer}</pre>

								</div></td>
							<td width="130"><fmt:formatDate value="${vo.faq_date}"
									pattern="YYYY/MM/dd" /></td>

						</tr>
					</c:forEach>
					<c:if test="${empty list}">
						<tr>
							<td colspan="3" align="center" class="no_result" height="60">
								검색결과가 없습니다</td>

						</tr>
					</c:if>


				</tbody>
			</table>
			<div>
				<p id="page_menu">${pageMenu}</p>
				<p id="search_menu">
					<input type="text" name="sctext"> <input type="button"
						value="검색" onclick="scbutton(this.form);">
				</p>
			</div>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
		</form>


	</div>

</div>
<%@include file="/WEB-INF/views/include/footer.jsp"%>
