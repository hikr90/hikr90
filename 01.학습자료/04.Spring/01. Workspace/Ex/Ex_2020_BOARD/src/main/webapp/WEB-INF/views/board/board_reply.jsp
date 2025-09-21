<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript">
		// 등록	
		function send_check() {
				//
				var f = document.ff;
				//				
				if(f.subject.value==""){
					alert("제목을 입력하십시오.");
					return;
				}
				if(f.name.value==""){
					alert("작성자를 입력하세요.");
					return;
				}
				if(f.content.value==""){
					alert("내용은 한글자 이상 입력해야합니다.");
					return;
				}
				if(f.pwd.value==""){
					alert("비밀번호를 입력해주세요.");
					return;
				}
				//				
				f.submit();
			}
		</script>
	</head>
	<body>
		<form name="ff" method="POST" action="reply.do">
			<input type="hidden" name="idx" value="${ param.idx }">
			<input type="hidden" name="page" value="${ param.page }">
		
			<table border="1" width="540px">
				<caption>::댓글 등록::</caption>
				<tr>
					<th>제목</th>
					<td><input name="subject" style="width:250px"></td>
				</tr>
	
				<tr>
					<th>작성자</th>
					<td><input name="name" style="width:250px"></td>
				</tr>
	
				<tr>
					<th>내용</th>
					<td>
						<textarea name="content" rows="9" cols="60"></textarea>
					</td>
				</tr>
				
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pwd"></td>
				</tr>
				
				<tr>
					<td colspan="2">
						<!-- 취소를 통해서 param으로 받아왔던 페이지 변수를 붙여서 이동  -->
						<img src="${pageContext.request.contextPath}/resources/img/btn_reg.gif" onclick="send_check();" style="cursor: pointer;">
						<img src="${pageContext.request.contextPath}/resources/img/btn_back.gif" onclick="location.href='list.do?page=${param.page}'" style="cursor: pointer;">
					</td>
				</tr>
			</table>
		</form>	
	</body>
</html>