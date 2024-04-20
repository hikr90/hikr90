<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="../js/httpRequest.js"></script>
		<script type="text/javascript">
			function send_check() {
				
				var f = document.ff;
				var subject = f.subject.value;
				var name = f.name.value;
				var content = f.content.value;
				
				if(f.subject==""){
					alert("제목을 입력하십시오.");
					return;
				}
				if(f.name==""){
					alert("작성자를 입력하세요.");
					return;
				}
				if(f.content==""){
					alert("내용은 한글자 이상 입력해야합니다.");
					return;
				}
				if(f.pwd==""){
					alert("비밀번호를 입력해주세요.");
					return;
				}
				if(confirm("내용을 수정하시겠습니까?")){
					
				var url = "update.do";
				// AJAX로 보낼 때는 SUBMIT과 다르게 PARAM에 보낼 거 다 보내야한다. 
				var param = "idx=${param.idx}&page=${param.page}&name="+name+"&content="+content+"&subject="+subject;
					
				sendRequest(url, param, resultFn, "POST");
				}
			}
			
			function resultFn() {
				if( xhr.readyState==4 && xhr.status==200 ){
					var data = xhr.responseText;
					
					if(data=='yes'){
						alert("수정완료");
						location.href="view.do?idx=${param.idx}";
					}else{
						alert("수정실패");
					}
				}
			}
		</script>
	</head>
	<body>
		<form name="ff" method="POST" action="update.do">
		<!-- 파라미터에 있는 값을 가져오는 방법 -->
		<input type="hidden" name="idx" value="${ param.idx }">
		<input type="hidden" name="page" value="${ param.page }">
		
		<table border="1" width="540px">
			<caption>::게시글 수정::</caption>
			<tr>
				<th>제목</th>
				<td><input name="subject" style="width:250px" placeholder="${ vo.subject }"></td>
			</tr>

			<tr>
				<th>작성자</th>
				<td><input name="name" style="width:250px" value="${ vo.name }" readonly="readonly"></td>
			</tr>

			<tr>
				<th>내용</th>
				<td>
					<textarea name="content" rows="9" cols="60" placeholder="${ vo.content }"></textarea>
				</td>
			</tr>
			
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pwd" value="${ vo.pwd }" readonly="readonly"></td>
			</tr>
			
			<tr>
				<td colspan="2">
					<img src="../img/btn_reg.gif" onclick="send_check();" style="cursor: pointer;">
					<img src="../img/btn_back.gif" onclick="location.href='view.do?idx=${vo.idx}'" style="cursor: pointer;">
				</td>
			</tr>
		</table>
		</form>	
	</body>
</html>