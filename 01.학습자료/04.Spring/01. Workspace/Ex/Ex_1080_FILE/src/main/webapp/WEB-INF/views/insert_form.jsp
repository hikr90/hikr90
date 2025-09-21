<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function send(f) {
		//		
		var title = f.title.value;
		var photo = f.photo.value;
		//
		if(title==''){
			alert("제목을 입력하세요.");
			return;
		}
		//
		if(photo==''){
			alert("파일 사진을 선택하세요.");
			return;
		}
		
		//
		f.action = "upload.do";
		f.submit();
	}
</script>
</head>
<body>
	<!-- 폼태그 파일 전송
			- 파일 업로드시 폼태그의 속성은 반드시 아래와 같아야한다.
				(1) method  : post 
				(2) enctype : multipart/form-data 

			enctype
				- 폼태그에서 데이터가 서버로 전송될 때의 인코딩 타입을 뜻한다.
				- 기본 전송방식은 application/x-www-form-urlencoded이다.
					예) url?변수1=값1&변수2=값2

				- 해당 방식은 문자 데이터를 전송하는데는 상관이 없으나 파일을 전송하는 경우에는 바이너리타입의 데이터를 전송해야하므로 multipart/form-data로 해야한다.
				
				(1) application/x-www-form-urlencoded : (default) 서버로 모든 문자를 인코딩하여 전송
				(2) text/plain : 공백문자를 +로 인코딩하여 전송한다.
				(3) multipart/form-data : 인코딩 없이 서버로 전송한다.
	-->
	<form method="POST" enctype="multipart/form-data">
		제목:<input name="title"><br>
			<!-- input태그 file타입의 name값은 VO 혹은 테이블 컬럼명과 일치해야한다. -->
		사진:	<input type="file" name="photo"><br>
			<input type="button" value="전송" onclick="send(this.form);">
	</form>
</body>
</html>