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
	<!-- 폼 태그의 전송 방식
			 파일 업로드시 폼태그의 속성은 반드시 아래와 같아야한다.
				- METHOD  : POST 
				- ENCTYPE : MULTIPART/FORM-DATA 

			ENCTYPE
				- 폼태그에서 데이터가 서버로 전송될 때의 인코딩 타입을 뜻한다.
				- 폼 태그의 기본 값의 전송방식은 APPLICATION/X-WWW-FORM-URLENCODEDED으로 ?변수1=값1&변수2=값2 의 형태로 데이터가 전송된다.
				- 기본 방식에서 문자 데이터를 전송하는데는 상관이 없으나 파일을 전송하는 경우에는 바이너리타입의 데이터를 전송하는데 만약 기본값으로 진행하면 바이너리 데이터가 문자 그대로 전송된다.
			
				- APPLICATION/X-WWW-FORM-URLENCODEDED (DEFAULT) : 서버로 전송시 모든 문자 인코딩
				- TEXT/PLAIN : 공백문자(SPACE)를 +로 변환하는 인코딩
				- MULTIPART/FORM-DATA : 서버로 전송시 모든 문자를 인코딩 하지 않음 (파일이나 이미지에서 사용하며, 해당 속성은 반드시 POST타입으로 동작해야한다.)		
			 -->
	<form method="POST" enctype="multipart/form-data">
		제목:<input name="title"><br>
		<!-- 파일이나 이미지를 받는 경우
				- INPUT태그의 TYPE속성을 FILE로 받으면 파일 형식로 값을 받을 수 있다.
				- 받는 파일의 NAME속성은 반드시 VO나 테이블 컬럼명칭과 일치해야한다. -->
		사진:<input type="file" name="photo"><br>
		<input type="button" value="전송" onclick="send(this.form);">
	</form>
</body>
</html>