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

.cursor1 th {
	cursor: pointer;
}

.cursor2 th {
	cursor: pointer;
}

</style>


<link
	href="${pageContext.request.contextPath}/resources/css/manager_1to1.css"
	rel="stylesheet" type="text/css">
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>

	<script type="text/javascript">
		function del(idx) {
			
			if(confirm("정말 삭제하시겠습니까??")){
				location.href='qna1to1delete.do?idx='+idx+'&page=${empty param.page ? 1 : param.page}';
			}
		}
		
		function deltitle() {
			alert("삭제된 글 입니다");
		}
		
	
	</script>


</head>

<body>
<div id="wrap">
	<jsp:include page="common_top.jsp"></jsp:include>	
	<jsp:include page="common_menu.jsp"></jsp:include>
	
		<div id="main">
			<div class="totalbar">
				<h2 style="font-size: 24px">1:1문의</h2>
				<form id="totalform">
					<table  cellspacing="0" cellpadding="0">
						<tbody>
							<tr class="cursor1">
								<th scope="row" height="60" width="283" onclick="location.href='manager_1to1part.do?count=1';" >배송문의</th>
								<th width="283" onclick="location.href='manager_1to1part.do?count=2';">주문 / 결제문의</th>
								<th width="283" onclick="location.href='manager_1to1part.do?count=3';">취소 문의</th>
								<th width="283" onclick="location.href='manager_1to1part.do?count=4';">교환 / 환불문의</th>
								<th width="283" onclick="location.href='manager_1to1part.do?count=5';">반품문의</th>
							</tr>
							<tr >
								<td scope="row" height="90" >
									${ count.count1 }건</td>
								<td >${ count.count2 }건</td>
								<td >${ count.count3 }건</td>
								<td >${ count.count4 }건</td>
								<td >${ count.count5 }건</td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
			
			<form id="totalform">
					<table cellspacing="0" cellpadding="0">
						<tbody>
							<tr class="cursor2">
								<th scope="row" width="354" height="60" onclick="location.href='manager_1to1QNA.do';">총 문의</th>
								<th width="354" onclick="location.href='manager_1to1condition.do?count=1';">답변 대기</th>
								<th width="354" onclick="location.href='manager_1to1condition.do?count=2';">답변 완료</th>
								<th width="354" onclick="location.href='manager_1to1condition.do?count=3';">삭제된 글</th>
							</tr>
							<tr>
								<td scope="row" height="90" >${ total }건</td>
								<td >${ count.wait }건</td>
								<td >${ count.Complete }건</td>
								<td >${ count.delete }건</td>
							</tr>
						</tbody>
					</table>
			</form>
				
			<div id="productlist">
				<h2 style="font-size: 24px">전체 문의 목록</h2>
				<form id="listform">
					<table  border="0" cellspacing="0"
						cellpadding="0">
						<tbody>
							<tr>
								<th scope="row" width="152" height="65">번호</th>
								<th width="177">분류</th>
								<th width="411">문의 제목</th>
								<th width="176">작성자</th>
								<th width="177">답변상태</th>
								<th width="160">답변하기</th>
								<th width="175">작성일</th>
								<th width="175">삭제</th>

							</tr>
								
								
						<c:forEach var="vo" items="${ list }">
						
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
									<a href="" onclick="deltitle();" style="color: gray; text-decoration: line-through;">
										${ vo.q_title  }
									</a>
								</c:if>
								
								<!-- 삭제안된 글일경우 클릭 가능 -->
								<c:if test="${ vo.q_delete eq 0 }">
									<a href="qnaOneanswerInManagerview.do?q_idx=${ vo.q_idx }">
										${ vo.q_title }
									</a>
								</c:if>
								</td>

								
								<td>
									${vo.m_name }
								</td>
								
								<td>
									<c:if test="${ vo.q_qnayn eq 0 }">
										N
									</c:if>
									<c:if test="${ vo.q_qnayn eq 1 }">
										Y
									</c:if>
								</td>
								
								<td>
								<input type="hidden" value="${ vo.q_idx }" name="idx">
								<c:if test="${ vo.q_qnayn eq 0  }">
									<c:if test="${ vo.q_delete eq 0 }">
										<a href="manager_1to1QNAanswer.do?idx=${ vo.q_idx }&page=${empty param.page ? 1 : param.page}">
											<img src="${pageContext.request.contextPath}/resources/image/answer.png" width="90" height="40" alt=""/>
										</a>
									</c:if>
								</c:if>
								<c:if test="${vo.q_qnayn eq 1 }">
									<c:if test="${ vo.q_delete eq 0 }">
										답변완료
									</c:if>
								</c:if>
								<c:if test="${ vo.q_delete eq 1 }">
									삭제된 글
								</c:if>
								
								</td>
								
								<td width="175" height="75">${ vo.q_regdate }</td>

								<td>
								<c:if test="${ vo.q_delete eq 0 }">
									<img src="${pageContext.request.contextPath}/resources/image/deleteboard.png"  alt=""
									onclick="del('${ vo.q_idx}');"/>
								</c:if>
								<c:if test="${ vo.q_delete eq 1 }">
									삭제된 글
								</c:if>
								</td>
							</tr>
							


						</c:forEach>
						
							<c:if test="${ empty list }">
							
									<tr>
										<td colspan="7">문의가 없습니다<td>
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



	</div>
</body>
</html>
