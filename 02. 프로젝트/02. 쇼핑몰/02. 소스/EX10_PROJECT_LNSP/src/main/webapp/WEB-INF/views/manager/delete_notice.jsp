<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="common_logincheck.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=euc-kr">
<title>IslandScape</title>
<link href="${pageContext.request.contextPath}/resources/css/delete_notice.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
function MM_callJS(jsStr) { //v2.0
  return eval(jsStr)
}
function del(idx) {
	if(confirm("정말 삭제하시겠습니까??")){
		location.href='delete_faq_del.do?idx='+idx + "&ctg=공지사항";
	}
}

</script>
</head>

<body>
<div id="qna">
		<form id="productform">
	  <h2>공지사항  </h2>
	  <table width="980" cellpadding="10" cellspacing="0" style="border-collapse:collapse; border:2px #A9DDB3 solid;">
	    <tbody>
    <tr>
      <th width="77" height="50" scope="row">번호</th>
      <th width="577">제목</th>
		<th width="122">수정</th>
      <th width="122">삭제</th>
      
    </tr>
    
    <% int i = 0; %>
    <c:forEach var="vo" items="${list}">
    <% i++; %>
    <tr>
      <td height="60" scope="row">${vo.idx}</td>
      <td width="577">
      	<div class="question<%=i%>">
        <p><a href="change_faq.do?idx=${vo.idx}&ctg=공지사항" class="blind_view<%=i%>">${vo.question}</a></p>
        </div>
      </td>
      
      <td width="120"><a href="change_faq.do?idx=${vo.idx}&ctg=공지사항"><img src="${pageContext.request.contextPath}/resources/image/changeboard.png"  alt=""/></a></td>
      <td width="122"><a href="javascript:del(${vo.idx});"><img src="${pageContext.request.contextPath}/resources/image/deleteboard.png"  alt=""/></a></td>
    </tr>
    </c:forEach>
        </tbody>
</table>
		<p style="float:left;">
			${paging}
			</p>
		<p style="float:right;">
			<a href="insert_faq.do" style="margin-top:5px; margin-right:5px;"><img src="${pageContext.request.contextPath}/resources/image/insertboard.png"  alt="새글추가"/></a>
			</p>
		<p>&nbsp;</p>
  </form>
		  
		</div>
</body>
</html>
