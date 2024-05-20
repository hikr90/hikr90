<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- ajax
		- 자바스크립트를 활용한 백그라운드 통신기술 (Asynchronus Javascript & xml)
		- 비동기식 통신이라고 부른다.
		- 하나의 웹페이지 안에서 변경사항이 발생한 경우 변경된 특정 부분만 갱신하는 기능
		- 동기식 통신의 경우 다른 화면으로 이동하면서 페이지가 완전히 새로고침되는 구조
		
		- 본 예제에서는 HttpRequest.js 파일을 통해서 비동기식 통신을 진행한다.
		- 프로젝트에서는 WebContent 폴더 내 js파일을 생성하여 사용한다.	
-->

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<!-- 스크립트 태그를 사용하여 httpRequest.js를 참조한다. -->
		<script src="js/httpRequest.js"></script>
		<script type="text/javascript">
			function send() {
				var dan = document.getElementById("dan").value;
				if(dan<2||dan>9){
					alert("2에서 9 사이의 값을 입력하세요.");
					return;
				}
				
				// location.href 기능은 그대로 화면을 이동하므로 사용할 수 없다.
				// ajax를 통해서 콜백 메소드로 요청에대한 응답을 돌려 받아야한다.
				var url = "gugudan_ajax.jsp";
				var param = "dan="+dan;
				
				/* sendRequest 
						- httpRequset의 메소드
						- (전송 url, 전송 파라미터, 콜백메소드, 전송방식)
					
						[참고] 본 예제에서 ajax의 동작 흐름
							(1) 전송 url을 타고 gugudan_ajax.jsp로 이동
							(2) gugudan_ajax.jsp에서 dan 파라미터를 받아 구구단의 계산이 동작한다.
							(3) gugudan_ajax.jsp의 body 영역 내 결과(str)가 담긴다.
							(4) 콜백메소드인 resultFn으로 되돌아온다.
							(5) 메소드 내에서 결과 (data) 를 통해서 disp 태그 영역에 결과를 출력한다.
				*/
				sendRequest(url,param,resultFn,"GET");
			}
			
			// 콜백메소드
			// 	- ajax의 요청 결과를 돌려받을 메소드
			//	- ajax의 결과 처리가 완료된 후 자동으로 호출된다.
			function resultFn() {
				/*	ajax의 결과 코드 
						- 결과 코드는 인터넷의 개발자도구 (f12) 에서 확인 가능하다.
						- 함수 내에서는 readyState와 status함수를 통해서 확인할 수 있다.
						
						readyState
							- 0 : 초기화 오류
							- 1, 2, 3 : 로딩 중
							- 4 : 로드 완료
						
						status
							- 200 : 이상없음 (정상적으로 처리되어 넘어옴)
							- 404 : 경로없음 (코드 상 오류 존재)
							- 500 : 데이터 없음 (서버 에러)
				*/				
				console.log(xhr.readyState+" / "+xhr.status);
				// 정상적으로 처리된 경우				
				if(xhr.readyState==4 && xhr.status==200){
					// responseText는 서버에서 처리된 응답 결과를 받는 함수이다.
					var data = xhr.responseText;
					// innerHtml을 통해서 화면 상에 받아온 결과를 출력한다.
					document.getElementById("disp").innerHTML = data;
				}
			}			
		</script>
		
	</head>
	<body>
		단:<input id="dan">
			<input type="button" value="결과보기" onclick="send();">
			<hr>
			
			<div id="disp">
			
			</div>
	</body>
</html>