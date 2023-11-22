<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IslandScape</title>
<link href="${pageContext.request.contextPath}/resources/css/change_faq.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	/* function MM_callJS(jsStr) { //v2.0
		return eval(jsStr)
	} */
	function edit(){
		var f = document.editform;
		
		f.submit();
	}
</script>
</head>
<body>
<div id="qna">
		<form id="productform" name="editform" action="cscenter_insert_action.do" method="get">
	<h2>FAQ 및 공지사항 추가</h2>
	<table width="980" cellpadding="10" cellspacing="0" style="border-collapse:collapse; border:2px #A9DDB3 solid;">
	<tr>
		<th height="55">
			CATEGORY
			
		</th>
		<td align="left">
			&nbsp;
			<select name="category">
				<option>공지</option>
				<option>주문/결제</option>
				<option>반품/교환</option>
				<option>배송</option>
				<option>회원</option>
			</select>
		</td>
	</tr>
	<tr>
		<th height="55">질문 및 제목</th>
		<td align="left">
			&nbsp;<input name="question" style="width:600px;"> <!-- js파일이 없는데 왜 엔터에 기능이 있는거지?? : 박세환 -->
		</td>
	</tr>
	<tr> 
		<th height="355">답변 및 내용</th>
		<td align="left">
			&nbsp;<textarea name="answer" rows="12" cols="80">${ip}</textarea>
		</td>
	</tr>
	
	</table>
	<p style="margin-top: 10px; float:right; ">
	<a href="javascript:edit();"><img src="${pageContext.request.contextPath}/resources/image/insertboard.png"  alt=""/></a>
	</p>
		</form><!-- id="editform" -->
</div>
</body>
</html>