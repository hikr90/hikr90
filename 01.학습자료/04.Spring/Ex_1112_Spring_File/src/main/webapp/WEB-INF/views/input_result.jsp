<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	//
	function download(filename) {
		// 한글 인코딩 추가하여 컨트롤러로 전송
		location.href="download.do?filename="+encodeURIComponent(filename);
	}
</script>
</head>
<body>
	<a href="javascript:download('${vo.filename}')">${ vo.title }</a>
	<input type="button" value="취소" onclick="location.href='insert_form.do'"><br>
	<img src="resources/upload/${ vo.filename }"/>
</body>
</html>