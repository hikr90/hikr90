<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript">
			//
			function send_check() {
				// THIS.FORM으로 파라미터를 넘길 수 없는 경우 BODY에 있는 FORM태그를 사용하는 방식으로 처리한다.
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
		<form name="ff" method="POST" action="insert.do">
		<table border="1" width="540px">
		
			<caption>::새 게시글 등록::</caption>
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
					<!-- 이미지와 A태그는 FORM으로 보낼 수가 없으므로 SEND_CHECK함수안에서 FORM태그인 FF를 사용하여 처리한다. -->
					<img src="${pageContext.request.contextPath}/resources/img/btn_reg.gif" onclick="send_check();" style="cursor: pointer;">
					<img src="${pageContext.request.contextPath}/resources/img/btn_back.gif" onclick="location.href='list.do'" style="cursor: pointer;">
				</td>
			</tr>
		</table>
		</form>	
	</body>
</html>