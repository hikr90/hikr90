<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- Ajax를 쓰기위한 설정
	웹에서 DB사용하려면의 httpRequest.js 파일이 있어야한다.
	프로젝트에서 WebContent에 js폴더를 생성한 뒤 그 안에 복사한다.
 	-->


<!-- Ajax(Asynchronus Javascript & xml)
		자바 스크립트를 활용한 백그라운드 통신기술(비동기식 통신)
		하나의 웹페이지 안에서 변경사항이 발생한 경우 변경된 특정 부분만 갱신이 가능하도록 한다. (모델2에서 사용)
		
		비동기식 통신 : 네이버 로그인하면 그 부분만 바뀌는 것처럼 해당 영역만 새로고침 되는 구조
		(아이디 잘못입력했을 시, 아이디가 잘못입력되었습니다.라는 경고문구를 띄우는게 가능하다.) 
		
		동기식 통신 : 다른 jsp로 갔다가 다시 되돌아오면서 페이지가 새로고침되는 구조 
		-->
		

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<!-- js폴더에 존재하는 httpRequest.js를 참조하는 코드
				외부의 js를 참조하는 스크립트 영역에는 내부 스크립트의 내용을 절대로 쓸 수 없으니 반드시 새로운 스크립트를 만들어야한다. -->
		<script src="js/httpRequest.js"></script>
		
		<script type="text/javascript">
			function send() {
				var dan = document.getElementById("dan").value;
				/* 유효성 처리는 먼저 클라이언트(스크립트)에서 해두고 서버로 보내는 것이 효율적이다. */
				if(dan<2||dan>9){
					alert("2에서 9 사이의 값을 입력하세요.");
					return;
				}
				
				// location.href는 그냥 보내면 돌아오지 않는다.
				// ajax를 통한 callback메서드로 결과를 돌려받아야한다.
				var url = "gugudan_ajax.jsp";
				var param = "dan="+dan;
				
				// httpRequest의 메서드 (그냥 가져다 쓸 수 있는 이유는 위 스크립트에서 참조했기때문이다.)
				// sendRequest("전송 url","넘길 파라미터","resultFn(콜백메서드)","전송방식(그냥 POST로 간다.)")
				// 순서 (23분)
				// 전송 url으로 출발한 다음 resultFn으로 돌아온다. (따로 function으로 호출하지 않아도 알아서 돌아온다.)
				// gugudan_ajax으로 간다.
				// gugudan_ajax에서 dan이라는 파라미터를 받는다.
				// 거기서 포문이 돌면서 str안에 구구단의 내용이 담긴다.
				// str이 gugudan의 disp영역으로 가야한다.(클래스가 달라서 스크립트 릿으로 못한다. )
				// 그러니 gugudan_ajax의 body에 스크립트릿에 뿌린다.
				// ajax는 화면에 뿌려지는 값을 텍스트화해서 요청했던 콜백메서드로 보내준다.

				sendRequest(url,param,resultFn,"GET");
				
			}
			
			// Ajax의 요청 결과를 돌려받을 콜백메서드
			// 결과 처리가 완료된 후 자동으로 호출되는 메서드 
			//위에 콜백메서드로 정한 명칭과 동일한 명칭으로 메서드를 만들어줘야한다.
			function resultFn() {
				
				// xhr은 가지고온 결과에 오류가 있는지 없는지를 보관한다.
				// 인터넷 f12의 콘솔창에서 확인할 수 있다.
				// xhr.readyState
				// 	0 : 초기화 오류
				//	1,2,3 : 로딩중
				//	4 : 로드완료 : 그러니까 4가 완전히 떳을 때, 작업을 다시 해야한다. (alert이 막 뜨던 이유)
				
				// xhr.status
				// 200 : 이상없음, 정상적으로 처리되어 넘어왔음
				// 404 : 경로없음 (코드에 오류가 존재)
				// 500 : 데이터가 없음 (서버 에러, 코드에 오류가 존재)
				
				// 4 / 200 인경우 처리
				console.log(xhr.readyState+" / "+xhr.status);
				
				if(xhr.readyState==4 && xhr.status==200){
					// 서버로부터 도착한 데이터(str)를 받아보자
					var data = xhr.responseText;
					
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