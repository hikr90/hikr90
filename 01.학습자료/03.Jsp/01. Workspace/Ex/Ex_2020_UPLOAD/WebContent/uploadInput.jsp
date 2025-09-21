<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript">
		// 파일 등록
		function send(f) {
			var title = f.title.value; // String타입 문자열
			var photo = f.photo.value; // 파일 객체
			
			// 유효성 검사 
			if(title==''){
				alert("사진의 제목을 입력하세요.");
				return;
			}
			// 파일이 업로드되지 않는 경우 type=file은 빈 값이다.
			if(photo==''){
				alert("사진을 선택해주세요.");
				return;
			}
			//			
			f.action = "upload.do";
			f.submit();
		}
	</script>
	</head>
	<body>
		<!-- 파일 업로드 시 자바스크립트 상 주의사항
				(1) 전송방식은 반드시 Post여야 한다.
				(2) 폼 태그 내 enctype속성은 multipart/form-data으로 해야한다.
				
				[참고] enctype은 폼태그에서 파일을 전송한다는 것을 알리기위한 인코딩 방법이다.
						- utf-8 : 한글
						- multipart : 바이너리 타입 (파일)
		-->
		<form method="POST" enctype="multipart/form-data">
			제목 : <input name="title"><br>
			첨부 : <input type="file" name="photo"><br>
			<input type="button" value="업로드" onclick="send(this.form)"> 
		</form>
	</body>
</html>