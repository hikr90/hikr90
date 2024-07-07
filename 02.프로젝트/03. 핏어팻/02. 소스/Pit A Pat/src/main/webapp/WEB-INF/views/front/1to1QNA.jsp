<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/pipt_include_1020.jsp"%>
<link href="${pageContext.request.contextPath}/resources/css/1to1QNA.css" rel="stylesheet" type="text/css">

	<script type="text/javascript">
		function send(f) {
			
			f.action = "qnaoneform.do";
			f.submit();
			
		}
	</script>
<body>
<div id="objectbanner">
	<div id="bannertxt">마이페이지</div>
	<img
		src="${pageContext.request.contextPath}/resources/image/mypage.png">
</div>

	<div id="wrap">



		<div id="submenu">
			<ul>
				<li><a href="piptMypageInqy1010.do">주문 / 배송조회</a></li>
				<li><a href="refund.do">주문 취소 / 변경</a></li>
				<li><a href="qnaonelist.do"><span class="order">1:1
							문의</span></a></li>
				<li><a href="qnaprodlist.do">상품 Q &amp; A</a></li>
				<li><a href="pwd_check.do">회원정보 수정</a></li>
				<li><a href="leave.do">회원 탈퇴</a></li>
			</ul>
		</div>

	
		<div id="qna">
			<form id="qnaform">

				
				
				<h2 style="font-size: 28px">1 : 1 문의</h2>
				<p>&nbsp;</p>

				<p>* 한번 등록한 상담내용은 수정이 불가능합니다. 수정을 원하시는 경우, 삭제 후 재등록 하셔야 합니다.</P>
				<p>* 1:1 상담은 24시간 신청가능하며 접수된 내용은 빠른 시간내에 답변을 드리도록 하겠습니다.</p>
				<p>* 상담명을 클릭하시면 상세답변을 볼수있습니다.</p>

				<p>&nbsp;</p>
				<table width="auto" height="auto" border="0" cellpadding="10"
					cellspacing="0">
					<tbody>
						<tr>
							<th width="100" height="50" scope="row">번호</th>
							<th width="150">상담구분</th>
							<th width="480">상담명</th>

							<th width="150">등록일</th>
							<th width="100">답변여부</th>

						
						</tr>
						

						<c:set var="size">${list.size()}</c:set>
						
						<c:forEach var="vo" items="${ list }" varStatus="status">
						
						
						<c:if test="${ sessionScope.user.idx eq vo.member_idx }">
							<tr>
								<td height="121" scope="row">${ vo.q_infonum }</td>
								<td> 
								<c:if test="${ vo.q_qnapart eq 1 }">
									배송문의
								</c:if>
								<c:if test="${ vo.q_qnapart eq 2 }">
									주문 /결제문의
								</c:if>
								<c:if test="${ vo.q_qnapart eq 3 }">
									취소 문의
								</c:if>
								<c:if test="${ vo.q_qnapart eq 4 }">
									교환 / 환불문의
								</c:if>
								<c:if test="${ vo.q_qnapart eq 5 }">
									반품문의
								</c:if>
								</td>
								
								<td>
								<c:if test="${ vo.q_delete eq 1 }">
									<a href="" style="color: gray; text-decoration: line-through;">
										${ vo.q_title  }
									</a>
								</c:if>
								
								<!-- 삭제안된 글일경우 클릭 가능 -->
								<c:if test="${ vo.q_delete eq 0 }">
									<a href="qnaoneanswerview.do?q_idx=${ vo.q_idx }">
										${ vo.q_title }
									</a>
								</c:if>
								</td>
								
								<td>${ vo.q_regdate }</td>
								<td>
									<c:if test="${ vo.q_qnayn eq 0 }">
										N
									</c:if>
									<c:if test="${ vo.q_qnayn eq 1 }">
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
				
				<p>&nbsp;</p>
				<p align="center">
					
					<button onclick="javascript:send(this.form);"><img alt="" src="${pageContext.request.contextPath}/resources/image/1_1qna.png" /></button>
				</p>
			</form>

	
		</div>

	</div>
</body>


<%@include file="/WEB-INF/views/include/pipt_include_1030.jsp"%>