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
	function sendData() {
		// Data
		var data = {
				test_no:"TEST_0001",
				test_nm:"TEST",
				disp_order:"1",
				remark:"NULL"
		}
		
		// Ajax
		$.ajax({
			type:"post",
			url:"${pageContext.request.contextPath}/test/sendData",
			contentType:"application/json",
			data:JSON.stringify(data),
			success:function(data, textStatus){
				//
			},
			error:function(data, textStatus){
				//
			},
			complete:function(data, textStatus){
				//
			}
			
		});
	}
</script>
</head>
<body>
	<input type="button" id="btn" value="데이터 전송" onclick="sendData();">
</body>
</html>