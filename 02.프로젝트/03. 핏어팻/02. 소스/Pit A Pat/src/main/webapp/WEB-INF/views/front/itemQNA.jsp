<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/include/pipt_include_1020.jsp"%>
<link href="${pageContext.request.contextPath}/resources/css/itemQNA.css" rel="stylesheet" type="text/css">
<div id="objectbanner">
		<div id="bannertxt">마이페이지</div>
		<img
			src="${pageContext.request.contextPath}/resources/image/mypage.png">
	</div>
	<div id="wrap">
	
	<c:if test="${ sessionScope.user.idx eq null }">
		alert("로그인을 하세요");
	</c:if>



		<div id="submenu">
			<ul>
				<li><a href="piptMypageInqy1010.do">주문 / 배송조회</a></li>
				<li><a href="refund.do">주문 취소 / 변경</a></li>
				<li><a href="qnaonelist.do">1:1 문의</a></li>
				<li><a href="qnaprodlist.do"><span class="order">상품 Q
							&amp; A</span></a></li>
				<li><a href="pwd_check.do">회원정보 수정</a></li>
				<li><a href="mypage_leave.do">회원 탈퇴</a></li>
			</ul>
		</div>

		<div id="itemqna">
			<form id="questiontable">
				<h2 style="font-size: 28px">상품 Q &amp; A 내역</h2>
				<p>&nbsp;</p>

				<p>* 상품페이지에서 문의하신 질문에 대한 답변을 편리하게 보실 수 있습니다.</p>
				<p>* 상품코드를 클릭하시면 상품 상세페이지로 이동하실 수 있습니다.</p>
				<p>* 답변이 완료된 사항은 수정을 하실 수 없습니다.</p>

				<p>&nbsp;</p>
				<table width="980" cellspacing="0" height="200">
					<tbody>

						<tr>
							<th width=95 height="60" scope="row">번호</th>
							<th scope="row" width=196>상품명</th>
							<th scope="row" width=430>제목</th>
							<th scope="row" width=140>작성일</th>
							<th scope="row" width=108>답변여부</th>
						</tr>
						
						
						<c:set var="size">${list.size()}</c:set>
						
						<c:forEach var="vo" items="${ list }">
							
							<c:if test="${ sessionScope.user.idx eq vo.member_idx }">
								<tr>
									<td height="121" scope="row">${ vo.q_infonum }</td>
		
									<td>${ vo.g_name }</td>
									<td>
									<c:if test="${ vo.q_delete eq 1 }">
										<a href="" style="color: gray; text-decoration: line-through;">
											${ vo.q_title  }
										</a>
									</c:if>
								
								<!-- 삭제안된 글일경우 클릭 가능 -->
									<c:if test="${ vo.q_delete eq 0 }">
										<a href="qnaprodanswerview.do?q_idx=${ vo.q_idx }">
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

			</form>

			<c:if test="${ row_total ne 0 }">
					<p align="center" id="page_menu">${pageMenu}</p>
			</c:if>
				





		</div>

	</div>
<%@include file="/WEB-INF/views/include/pipt_include_1030.jsp"%>