<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
	<title>Home</title>
</head>
<script src="${ pageContext.request.contextPath }/resources/httpRequest.js"></script>
<script src="${ pageContext.request.contextPath }/resources/jquery-1.12.4.js"></script>

<script type="text/javascript">
	//
	function sendMail(f) {
		// 파일이 존재하는 경우, 파일 정보 객체에 저장
		if(f.fileList.value!=""){
			var fileTempArr = [];
			var formData = new FormData(document.getElementById("form"));
			// 
			for(var i=0;i<fileTempArr.length;i++){
				formData.append("fileList",fileTempArr[i]);
			}

		}else{
			//
			alert("파일을 첨부해주세요.");
			return;
		}
		
		//
		$.ajax({
    	        	type : 'POST',
        	    	url : 'sendMail.do',
    				processData : false,
    				contentType : false,
            		data : formData,
            		dataType : 'html',
            	success : function(data){
                	 //
		       		 var json = eval(data);
					 //        		 
	        		 if(json[0].res!='true'){
	        			 alert("테스트 메일 전송 실패!!!");
	        			 return;
	        		 }else{
	        			 alert("테스트 메일 전송 성공!!!");
	        			 return;
	        		 }
        		}
            	,
            	error : function(data){
                	//
                	alert("AJAX ERROR!!!");
            	}
      		});
	}
	
</script>
<body>
	<h1>
		SEND MAIL  
	</h1>
	<form method="POST" enctype="multipart/form-data" id="form" accept-charset="UTF-8">
		<input type="file" name="fileList" id="fileList">
		<input type="button" value="메일 발송" onclick="javascript:sendMail(this.form);">	
	</form>
</body>
</html>
