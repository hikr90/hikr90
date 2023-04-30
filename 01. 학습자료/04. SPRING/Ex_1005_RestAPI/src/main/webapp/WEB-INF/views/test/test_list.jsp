<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${ pageContext.request.contextPath }/resources/httpRequest.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	//
	$(function() {
		//
		$("#btn").click(function() {
			//
			if($("#test_no").val()==""){
				alert("테스트 번호를 입력하세요.");
				return;
			}
			if($("#test_nm").val()==""){
				alert("테스트 명칭을 입력하세요.");
				return;
			}
			
			//
			var type = $("input[name='api']:checked").attr("id");
			var url = "${pageContext.request.contextPath}/test/";
			var data_no = $("#test_no").val();
			var data_nm = $("#test_nm").val();
			
			var data = {
					test_no:data_no,
					test_nm:data_nm
			};
			
			//
			$.ajax({
				type:type,
				url:url,
				contentType:"application/json",
				data:JSON.stringify(data),
				success:function(data, textStatus){
					//
					alert("작업이 성공적으로 완료되었습니다.");
				},
				error:function(data, textStatus){
					//
					alert("작업에 실패했습니다.");
				}
			});
			
		});
	});
</script>
</head>
<body>
<form id="form">
	<h1>테스트 목록</h1>
	<input type="button" id="btn" name="btn" value="API동작" />
	<table border="1">
		<caption>:: 테스트 화면 ::</caption>
		<tr>
			<th>테스트 번호</th>
			<td>
				<input type="text" id="test_no" name="test_no" value="" />
			</td>
		</tr>
		<tr>
			<th>테스트 명칭</th>
			<td>
				<input type="text" id="test_nm" name="test_nm" value="" />
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="radio" name="api" id="post" checked="checked" />POST
				<input type="radio" name="api" id="put" />PUT
				<input type="radio" name="api" id="delete" />DELETE
			</td>
		</tr>
	</table>
</form>
</body>
</html>