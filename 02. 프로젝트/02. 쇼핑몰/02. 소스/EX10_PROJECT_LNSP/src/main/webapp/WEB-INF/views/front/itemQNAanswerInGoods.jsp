<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="${ pageContext.request.contextPath }/resources/css/1to1QNAanswer.css" rel="stylesheet" type="text/css">
	
	<script type="text/javascript">
		function back() {
			history.back();
		}
	</script>
<div id="objectbanner">
		<div id="bannertxt">마이페이지</div>
		<img
			src="${ pageContext.request.contextPath }/resources/image/mypage.png">
	</div>

	<div id="wrap" >
<div>

	</div>
		<div id="qna" >
			<h2 style="font-size: 28px">상품 Q &amp; A</h2>
			<p>&nbsp;</p>

			<p>* 한번 등록한 상담내용은 수정이 불가능합니다. 수정을 원하시는 경우, 삭제 후 재등록 하셔야 합니다.</P>
			<p>* 1:1 상담은 24시간 신청가능하며 접수된 내용은 빠른 시간내에 답변을 드리도록 하겠습니다.</p>

			<p>&nbsp;</p>
			<div class="question">
				<div class="qnatitle">Q.</div>
				<div class="qna1"><b>제목:${ vo.q_title }</b></div>
				<div class="qna2">상품명:${vo.g_name }</div>
				<div class="qna3">${ vo.q_content }</div>


			</div>

			<div class="answer">
				<div class="qnatitle">A.</div>
				<div class="qna1"><b>작성자 : 관리자</b></div>
				<div class="qna2">등록일 : ${ qavo.qa_regdate }</div>
				<hr>
				<div class="ans3" style="margin-top: 30px;">${ qavo.qa_content }</div>
			</div>

		
			<div align="center">
				<button   onclick="back();">
					<img src="${ pageContext.request.contextPath }/resources/image/list.png" alt="" />
				</button>
			</div>
		
		</div>
<div>

	</div>
	</div>


<%@include file="footer.jsp"%>