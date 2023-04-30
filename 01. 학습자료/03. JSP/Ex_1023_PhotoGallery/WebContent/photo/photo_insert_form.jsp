<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script uri="httpRequest.js"></script>
		
		<script type="text/javascript">
			function send(f) {
				var title = f.title.value;
				var pwd = f.pwd.value;
				var photo = f.photo.value;
				
				if(title==''){
					alert("제목을 입력하세요.");
					return;
				}
				
				if(pwd==''){
					alert("비밀번호를 입력하세요.");
					return;
				}

				if(photo==''){
					alert("사진이 없습니다.");
					return;
				}
				

				f.submit();
				
				
			}
		</script>
		
	</head>
	<body>
	
		<form action="insert.do" method="POST" enctype="multipart/form-data">
			<table border="1" align="center">
			<caption>사진 등록하기</caption>
				<tr>
					<th>제목</th>
					<td>
						<input name="title">
					</td>				
				</tr>

				<tr>
					<th>비밀번호</th>
					<td>
						<input name="pwd" type="password">
					</td>				
				</tr>

				<tr>
					<th>업로드용 사진</th>
					<td>
						<input type="file" name="photo">
					</td>				
				</tr>
				
				<tr>
					<td colspan="2" align="center">
						<input type="button" value="사진등록하기" onclick="send(this.form)">
						<input type="button" value="취소" onclick="location.href='list.do'">
					</td>
				</tr>
				
			</table>
		</form>
	
	</body>
</html>