<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript">
		/* [참고] 파일의 경로 차이
				- 프로젝트에서 사용되는 파일은 두종류가 존재한다.
				- 하나는 클라이언트에서 업로드하는 파일이고, 나머지 하나는 개발자가 사용하기위해서 WebContent 경로에 저장하는 리소스 파일이다.
				
				- 전자의 파일은 프로젝트 소스 내에 저장되는 것이 아니므로 서버에서 경로를 통해서 가져오지 않는 한 사용할 수 없다.
		
				- 클라이언트에서 저장한 파일 : 서버 PC내 경로에 저장
				- 개발자가 사용하는 이미지 : 프로젝트 내 WebContent 경로 내 저장
		*/
	</script>
</head>
<body>
	제목 : ${ title }<br>
	파일명 : <img src="upload/${ filename }" width="200"><br>
</body>
</html>