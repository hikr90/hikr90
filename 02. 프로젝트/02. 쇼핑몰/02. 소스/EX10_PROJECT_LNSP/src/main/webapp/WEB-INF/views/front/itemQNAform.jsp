<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IslandScape</title>
<link href="${ pageContext.request.contextPath }/resources/css/QNA.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${ pageContext.request.contextPath }/resources/js/httpRequest.js"></script>
<script type="text/javascript">
function MM_callJS(jsStr) { //v2.0
  return eval(jsStr)
}
</script>
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
		
		var url = "qnaprodinsert.do";
	
		var param = "member_idx=" + ${ vo.member_idx } + "&goods_idx=" + ${ vo.goods_idx } +
					"&q_title=" + q_title + "&q_content=" + q_content;
		sendRequest(url, param, resultFn, "GET");
		
	}
	
	function resultFn() {
		
		if( xhr.readyState == 4 && xhr.status == 200 ){
			
			var data = xhr.responseText;
			
			if( data == 'no'){
				alert("실패");
				return;
			}else {
				alert("문의가 등록되었습니다");
				opener.location.reload();
				window.close();
			}
			
		}
	}
	
</script>
</head>

<body>
	<div id="qna">
		<div class="qnatitle">상품문의 쓰기</div>
		<form id="qnaform">
			
			<input type="hidden" name="member_idx" value="${ vo.member_idx }" >
			<input type="hidden" name="goods_idx" value="${ vo.goods_idx }">
		
			<p style="color: #FF0A0E">* 상품관련 문의에 대해서만 답변 받으실수 있습니다.</p>
			<p>* 주문/배송/교환/환불 등 쇼핑몰 사용에 관한 문의시 마이페이지 &gt; 1:1 상담문의를 이용부탁드립니다.</p>
			<p>* 1:1 상담은 24시간 신청가능하며 접수된 내용은 빠른 시간내에 답변을 드리도록 하겠습니다.</p>
			<p>&nbsp;</p>
			<table width="700" height="580" cellspacing="0">

				<thead>

					<tr>
						<th width="180" height="80">상품</th>
						<td>${ vo.g_name }</td>
					</tr>
					<tr>
						<th width="180" height="80">아이디</th>
						<td width="262">${ vo.m_id }</td>
					</tr>
					<tr>
						<th width="180" height="80">제목</th>
						<td><input type="text" name="q_title"size="40"></td>
					</tr>
					<tr>
						<th width="180" height="260">문의내용</th>
						<td><textarea name="q_content">&nbsp;</textarea></td>
					</tr>
					<tr>
						<th width="180" height="80">이메일</th>
						<td>${ vo.m_email }</td>
					</tr>

				</thead>

			</table>

			<p>&nbsp;</p>
			<p>
				<span class="summit">
				<button onclick="javascript:send(this.form);"><img src="${ pageContext.request.contextPath }/resources/image/qnasummit.png" alt="" /></button>
				<img src="${ pageContext.request.contextPath }/resources/image/qnacancel.png" value="닫기"
					onClick="MM_callJS('window.close();')"></span>
			</p>
		</form>




	</div>
</body>
</html>