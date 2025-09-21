<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	// 전송
	function send(f) {
		var name = f.name.value;
		var content = f.content.value;
		var pwd = f.pwd.value;
		//
		if(name==""){
			alert("이름을 입력해주세요.");
			return
		}
		
		if(content==""){
			alert("내용을 입력해주세요.");
			return
		}
		
		if(pwd==""){
			alert("비밀번호를 입력해주세요.");
			return
		}
		//
		f.action = "modify.do";
		f.submit();
	}
</script>
</head>
<body>
	<form method="POST" enctype="multipart/form-data">
		
		<input type="hidden" name="idx" value=${ vo.idx }>
		
		<table border="1" align="center">
			<caption>::방명록 수정하기::</caption>
			<tr>
				<th>작성자</th>
				<td><input name="name" value="${ vo.name }"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea name="content" rows="5" cols="50">${ vo.content }</textarea>
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pwd" value="${ vo.pwd }"></td>
			</tr>
			<tr>
				<th>파일첨부</th>
				<td><input type="file" name="photo"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="수정하기" onclick="send(this.form);">
					<input type="button" value="목록으로" onclick="location.href='list.do'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>