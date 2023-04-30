<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 파일 업로드
	파일 업로드를 위해서 필요한 라이브러리를 설치해야한다.
	1 http://servlets.com/ 에 접속
	2 왼쪽의 COS FILE UPLOAD LIBRARY 선택
	3 cos-20.08.zip 다운로드
	4 압축을 푼 뒤, 압축 풀린 폴더의 lib폴더로 들어간다. 
	5 cos는 파일 업로드시 사용하는 라이브러리인데 복사하여 DB라이브러리(톰캣의 lib) 집어넣는 lib폴더에다가 넣어주자
 
 	사진 파일등을 파라미터로 db로 전달하는데
 	실제로 사진을 db에 저장하는 것이 아니다. 실제로 사진은 서버(우리pc)의 폴더에 저장을 하며 db에는 사진의 경로만 저장한다. (필요할 때, 서버에서 db에서 요구하는 이름이랑 똑같은 파일을 가져오는 구조) 
 -->

<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript">
		function send(f) {
			var title = f.title.value; // String타입 문자열
			var photo = f.photo.value; // 이미지 형식
			
			// 유효성 검사 
			if(title==''){
				alert("사진의 제목을 입력하세요.");
				return;
			}
			
			// 사진을 선택하지 않으면 ''형태로 비어있게 된다.
			if(photo==''){
				alert("사진을 선택해주세요.");
				return;
			}
			
			f.action = "upload.do";
			f.submit();
			
		}
	</script>
	
	</head>
	<body>
		<!-- 파일 업로드(파일 input사용)시 고려사항
		1 전송방식(method)는 반드시 POST
		2 enctype은 form태그에서 파일을 전송한다는 것을 알려주는 인코딩 속성(방법)이다. uft-8은 한글, multipart는 바이너리(파일)을 넘긴다는 뜻   -->
		
		<!-- 사진과 제목등을 파라미터로 넘기기 위한 폼
				file타입을 넘길 때는 바이너리 타입이 가능한 POST의 방식(문자열, 바이너리타입)만 사용해야한다, GET은 문자열만 가능하기 때문이다.
				 -->
		<form method="POST" enctype="multipart/form-data">
			제목 : <input name="title"><br>
			<!-- file type의 input은 파일을 업로드하는데 사용된다. (이미지, 텍스트파일 모두 가능)
					파일로 되어있는 input은 내가 선택한 파일의 이름형태로 등록이 된다. -->
			첨부 : <input type="file" name="photo"><br>
			<input type="button" value="업로드" onclick="send(this.form)"> 
		</form>
	</body>
</html>