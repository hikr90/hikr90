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
}
</style>


<link
	href="${pageContext.request.contextPath}/resources/css/manager_1to1answer.css"
	rel="stylesheet" type="text/css">
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
	
	<script type="text/javascript">
		function send(f) {
			var qa_content = f.qa_content.value;
			
			if( qa_content == "" ){
				alert("내용을 입력하세요");
				return;
			}
			
			alert("답변을 등록하였습니다");
			
			f.action = "manager_1to1QNAinsert.do";
			f.submit();
		}
	</script>

</head>

<body>
<div id="wrap">
	<jsp:include page="common_top.jsp"></jsp:include>	
	<jsp:include page="common_menu.jsp"></jsp:include>
		<div id="main">
			<div id="qna">
				<form id="qnaform">
				
				<input type="hidden" name="qna_idx" value="${ vo.q_idx }">
				<input type="hidden" name="page" value="${ param.page }">
				
					<h2 style="font-size: 24px">1 : 1 문의 답변</h2>
					<p>&nbsp;</p>
					<table cellspacing="0">

						<thead>

							<tr>
								<th width="183" height="80">문의 분야</th>
								<td colspan="3">
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
							</tr>
							<tr>
								<th width="183" height="80">작성자</th>
								<td width="262">${vo.m_name }</td>
								<th width="183">답변일시</th>
								<td width="262">${ time }</td>
								
							</tr>
							
							
							<tr>
								<th width="183" height="80">제목</th>
								<td colspan="3">${ vo.q_title }</td>
							</tr>
							<tr>
								<th width="183" height="130">문의 내용</th>
								<td colspan="3"><textarea disabled="disabled">${ vo.q_content }</textarea></td>
							</tr>
							<tr>
								<th width="183" height="130">답변 내용</th>
								<td colspan="3"><textarea name="qa_content"></textarea></td>
							</tr>
							
<!-- 							<tr>
								<th width="183" height="80">비밀번호</th>
								<td colspan="3"><input type="password" name="qnaPW"
									id="qnaPW" size="30"></td>
							</tr> -->

						</thead>

					</table>

					<p>&nbsp;</p>
					<p>
						<span class="summit">
						<button onclick="send(this.form);">
							<img src="${pageContext.request.contextPath}/resources/image/qnasummit.png" alt="" />&nbsp;&nbsp;&nbsp;&nbsp;
						</button>
							<a href="manager_1to1QNA.do?page=${empty param.page ? 1 : param.page}">
								<img src="${pageContext.request.contextPath}/resources/image/qnacancel.png" alt="" />
							</a>
						</span>
					</p>
				</form>





			</div>
		</div>



	</div>
</body>
</html>