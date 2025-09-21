<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${ pageContext.request.contextPath }/resources/httpRequest.js"></script>
<script type="text/javascript">
	//
	function getTranSaction(){
		var url = "tran_saction.do";
		//
		alert("완료");
		sendRequest(url,null,resFn,"POST");
	}
	
	//
	function resFn(){
		//
		if( xhr.readyState == 4 && xhr.status==200 ){
		 	var data = xhr.responseText;
		 	var json = eval(data);
		 	//
		 	if(json[0].res=='YES'){
		 		location.href = "test_list.do";
		 	}

		}
	}
</script>
</head>
<body>
	<h1>테스트 목록</h1>
	<input type="button" value="트랜젝션" onclick="javascript:getTranSaction();">
	<table border="1">
		<caption>:: 테스트 정보 ::</caption>
		<tr>
			<th>테스트 번호</th>
			<th>테스트 명칭</th>
			<th>조회순서</th>
			<th>비고</th>
		</tr>
		
		<c:forEach var="list" items="${ list }">
		<tr>
			<td>${ list.test_no }</td>
			<td>${ list.test_nm }</td>
			<td>${ list.disp_order }</td>
			<td>${ list.remark }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>