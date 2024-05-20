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
	// 작업 커밋
	function getCommit(f) {
		var url = "test_commit.do";
		var param = "testNo="+f.testNo.value;
		//
		sendRequest(url,param,commitFn,"POST");
	}
	
	
	// 커밋 처리 함수
	function commitFn(){
		if( xhr.readyState==4 && xhr.status==200 ){
			var data = xhr.responseText;
			var json = eval(data);
			
			if(json[0].res=="YES"){
				alert("커밋 작업 완료");
				location.href="test_list.do";
			}else{
				alert("커밋 작업 실패");
			}
		}
	}
	
	// 작업 롤백
	function getRollback(f) {
		var url = "test_rollback.do";
		sendRequest(url,null,rollbackFn,"POST");
	}
	
	// 롤백 처리 함수
	function rollbackFn(){
		if( xhr.readyState==4 && xhr.status==200 ){
			var data = xhr.responseText;
			var json = eval(data);
			
			if(json[0].res=="YES"){
				alert("롤백 작업 완료");
				location.href="test_list.do";
			}else{
				alert("롤백 작업 실패");
			}
		}
	}
</script>
</head>
<body>
<form id="form" method="post">
	<h1>테스트 목록</h1>
	<input type="button" value="커밋" onclick="getCommit(this.form);">
	<input type="button" value="롤백" onclick="getRollback(this.form);">
	<input type="hidden" name="testNo" value="TEST_0001">
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
</form>
</body>
</html>