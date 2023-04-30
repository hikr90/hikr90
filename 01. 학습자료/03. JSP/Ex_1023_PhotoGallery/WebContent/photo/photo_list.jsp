<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	
		<link rel="stylesheet" href="../css/photo.css">
		<script src="../js/httpRequest.js"></script>
		
		<script type="text/javascript">
			function del(f) {
				var idx = f.idx.value;
				var pwd = f.pwd.value; // 원본 비밀번호 (DB에 있는 비밀번호)
				var pwd2 = f.pwd2.value; // 삭제를 위해서 INPUT에 입력한 비밀번호
				
				if(pwd!=pwd2){
					alert("비밀번호가 틀렸습니다.");
					return;
				}
				
				if(!confirm("정말로 삭제하시겠습니까?")){
					return;
				}
				
				
				var url = "photo_del.do";
				var param = "idx="+idx;
				
				sendRequest(url, param, resultFn,"POST");
			}
			
			function resultFn() {
				if(xhr.readyState==4 && xhr.status==200){
					
					var data = xhr.responseText;
					var json = eval(data);
					
					if(json[0].param=="yes"){
						alert("삭제 성공");
					}else{
						alert("삭제 실패");
					}
					
				}
					location.href="list.do";
			}
			
			function download(fn) {
				location.href="download.do?dir=/upload/&filename="+encodeURIComponent(fn);
				
			}
			
		</script>
		
		
	</head>
	<body>
		
		<div id="main_box">
			<h1>:::PhotoGallery:::</h1>
			
			<div align="center" style="margin: 10px">
				<!-- servelt을 거쳐서 간다. -->
				<input type="button" value="사진업로드" onclick="location.href='insert_form.do'">
			</div>
		
			<div id="photo_box">
			
			<!-- request로 받은 list가 비어있는 경우에대한 if문 -->
			<c:if test="${ empty list }">
				<div align="center">
					등록된 사진이 없습니다.
				</div>
			</c:if>
			
				<c:forEach var="vo" items="${ list }">
					<div class="photo_type">
						<img src="../upload/${ vo.filename }">
						
						<div class="title">${ vo.title }</div>
						
						
						<form>
						<div>
							<input type="hidden" name="idx" value="${ vo.idx }">
							<input type="hidden" name="pwd" value="${ vo.pwd }">
						
							
							<div align="center">
								<input type="password" name="pwd2" size=5>
								<input type="button" value="삭제" onclick="del(this.form);">
								<!-- 메서드 안에는 홑따움표가 들어가야한다. -->
								<input type="button" value="다운" onclick="download('${ vo.filename }');">
							</div>
						
						</div>
						</form>
					</div>
				</c:forEach>
			</div>
		
		</div>
		
	</body>
</html>