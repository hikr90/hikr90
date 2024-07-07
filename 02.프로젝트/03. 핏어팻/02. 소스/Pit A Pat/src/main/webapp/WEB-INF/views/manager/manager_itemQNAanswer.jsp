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
}
</style>
<link href="${pageContext.request.contextPath}/resources/css/manager_itemQNAanswer.css" rel="stylesheet"
	type="text/css">
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>

		<script type="text/javascript">
		function send(f) {
			var qa_content = f.qa_content.value;
			
			if( qa_content == "" ){
				alert("내용을 입력하세요");
				return;
			}
			
			alert("답변을 등록하였습니다");
			
			f.action = "manager_itemQNAinsert.do";
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
				<input type="hidden" name="goods_idx" value="${ vo.goods_idx }">
				
					<h2 style="font-size: 24px">상품 문의 답변</h2>
					<p>&nbsp;</p>
					<table  cellspacing="0">

						<thead>

							<tr>
								<th width="183" height="80">상품명</th>
								<td colspan="3">${ vo.g_name }</td>
							</tr>
							<tr>
								<th width="183" height="80">작성자</th>
								<td width="262">${ vo.m_name }</td>
								<th width="183">답변일시</th>
								<td width="262">${ time }</td>

							</tr>
							<tr>
								<th width="183" height="80">제목</th>
								<td colspan="3">${ vo.q_title }</td>
							</tr>
							<tr>
								<th width="183" height="260">문의 내용</th>
								<td colspan="3"><textarea>${ vo.q_content }</textarea>
								</td>
							</tr>
							<tr>
								<th width="183" height="260">답변 내용</th>
								<td colspan="3"><textarea name="qa_content"></textarea>
								</td>
							</tr>


						</thead>

					</table>

					<p>&nbsp;</p>
					<p>
						<span class="summit">
						<button onclick="send(this.form);">
							<img src="${pageContext.request.contextPath}/resources/image/qnasummit.png" alt="" />&nbsp;&nbsp;&nbsp;&nbsp;
						</button>
						<a href="manager_itemQNA.do?page=${empty param.page ? 1 : param.page}"><img src="${pageContext.request.contextPath}/resources/image/qnacancel.png" alt="" /></a>
						</span>
					</p>
				</form>





			</div>
		</div>


</div>
</body>
</html>
