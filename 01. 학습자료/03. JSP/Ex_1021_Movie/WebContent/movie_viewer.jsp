<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- movie_list_json의 주석 : text/html을 text/json으로 변경한 뒤, header부분 제외하고 다 삭제 
	json파일이 들어가는 jsp에는 주석을 달지 않는 것이 좋다. -->

<!-- json은 "",'' 가리지 않는다.
	localhost : 우리 아이디 
	원래는 서버에서 가져오는데 우리는 프로젝트에 담아서 가져오기에 프로젝트 명이 들어간다. -->



<!DOCTYPE html>
	<html>
	<head>
	<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript" src="js/httpRequest.js"></script>	
	
		<script type="text/javascript">
			/* window.onload = function() : 현재 페이지가 로딩 완료되었을 때, 맨 처음 자동으로 호출되는 메서드 영역 */
			window.onload = function() {
				var url = "movie_list_json.jsp";
				/* 파라미터 줄게 없으면 null로 처리한다. */
				sendRequest(url,null,resultF,"GET");
			}
			
			
			// sendRequest()를 통한 통신작업이 마무리되면 자동으로 호출되는 콜백메서드
			function resultF() {
				if(xhr.readyState==4 && xhr.status==200){
					/* 통신완료 후 넘어온 JSON데이터는
						JSON처럼 보이지만 실제로는 그냥 JSON모양의 ""문자열 구조이다.
						이 데이터를 실제 JSON 형식으로 변경해줘야한다. */
					var data = xhr.responseText;
					
					/* eval : JSON모양의 문자열구조를 JSON타입으로 변경 */
					var json = eval(data);
					
					
					/* select태그에 <option>태그 추가하기 */
					var movie_select = document.getElementById("movie_select");
					
					for(var i=0;i<json.length;i++){
						// option태그 생성하기
						var opt = document.createElement("option");
						opt.innerHTML = json[i].title;
						// value에는 option의 value값이 추가된다.
						opt.value = json[i].path;
						
						// movie_select에 넣어주자(태그에 태그 넣기)
						movie_select.appendChild(opt);
					}
				}
			}
			
			// 현재 선택된 항목의 value(재생경로)를 얻어온다.
			function movie_play() {
				var path = document.getElementById("movie_select").value;
				// VIDEO의 SRC에 재생시키고자하는 동영상의 PATH 추가
				var video = document.getElementById("my_video")
				video.src = path;
				// 항목 선택시 자동 재생
				video.play();
			}
			
		</script>
	</head>
	<body>
		비디오 목록 : 
		<!-- onchane : select의 목록에서 항목을 선택하였을 경우 실행 -->
		<select id="movie_select" onchange="movie_play()">
			<option>재생할 영상을 선택하세요.</option>
			
		</select>
		
		<hr>
		
		<!-- video : 동영생 영역
				src : 재생할 영역의 주소
				controls : 이게 있으면 동영상을 정지하거나 실행하는 버튼이 있고 없으면 그냥 광고처럼 버튼이 없이 강제로 자동재생되는 영상이 된다. 
				width, height : 영상의 높이와 길이 -->
		<video src="" id="my_video" controls="controls" width="320px" height="240px">
		
		
		</video>
		
	</body>
</html>