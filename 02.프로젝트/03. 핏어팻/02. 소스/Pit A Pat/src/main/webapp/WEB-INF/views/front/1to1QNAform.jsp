<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/pipt_include_1020.jsp"%>

<link href="${pageContext.request.contextPath}/resources/css/1to1QNAform.css" rel="stylesheet" type="text/css">

	<script type="text/javascript">
		function send(f) {
			
			var q_title = f.q_title.value;
			var q_content = f.q_content.value;
			
			if( q_title == "" ){
				alert("제목을 입력하세요");
				return;
			}
		
			if( q_content == "" ){
				alert("내용을 입력하세요");
				return;
			}
			
			alert("문의가 등록되었습니다");
			
			f.action = "qnaoneinsert.do";
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
				
				<input type="hidden" name="idx" value="${ sessionScope.user.idx }" >
				
				<h2 style="font-size: 28px">1 : 1 문의</h2>
				<p>&nbsp;</p>

				<p style="color: #FF0A0E">* 한번 등록한 상담내용은 수정이 불가능합니다. 수정을 원하시는
					경우, 삭제 후 재등록 하셔야 합니다.</p>
				<p>* 문의하실 분야를 선택하신 후 내용을 입력하신 다음 "신청하기 " 버튼을 눌러주세요.</p>
				<p>* 1:1 상담은 24시간 신청가능하며 접수된 내용은 빠른 시간내에 답변을 드리도록 하겠습니다.</p>
				<p>&nbsp;</p>
				<table width="980" height="580" cellspacing="0">

					<thead>

						<tr>
							<th width="183" height="80">문의 분야</th>
							<td colspan="3">
								<input type="radio" name="q_qnapart" value="1" checked="checked"> 배송문의 &nbsp;&nbsp;
								<input type="radio" name="q_qnapart" value="2"> 주문 /결제문의 &nbsp;&nbsp;
								<input type="radio" name="q_qnapart" value="3"> 취소 문의 &nbsp;&nbsp;
								<input type="radio" name="q_qnapart" value="4"> 교환 / 환불문의&nbsp;&nbsp;
								<input type="radio" name="q_qnapart" value="5"> 반품문의
							</td>
						</tr>
						<tr>
							<th width="183" height="80">주문자</th>
							<td width="262">${sessionScope.user.m_name }</td>
							<th width="183">아이디</th>
							<td width="262">${sessionScope.user.m_id }</td>

						</tr>
						<tr>
							<th width="183" height="80">제목</th>
							<td colspan="3"><input name="q_title" size="40"></td>
						</tr>
						<tr>
							<th width="183" height="160">내용</th>
							<td colspan="3"><textarea name="q_content"></textarea></td>
						</tr>
						<tr>
							<th width="183" height="80">이메일</th>
							<td colspan="3">${sessionScope.user.m_email }</td>
						</tr>

					</thead>
		
				</table>
				<p>&nbsp;</p>
				<p align="center">
					
					
					<button onclick="javascript:send(this.form);"><img src="${pageContext.request.contextPath}/resources/image/qnasummit.png" /></button>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="qnaonelist.do"><img src="${pageContext.request.contextPath}/resources/image/qnacancel.png" alt="" /></a>
				</p>
			</form>

			


		</div>

	</div>

<%@include file="/WEB-INF/views/include/pipt_include_1030.jsp"%>