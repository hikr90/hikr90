<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${ pageContext.request.contextPath }/resources/js/httpRequest.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	//
	$(document).ready(function() {
		//
		$("#divArea").text("PLEASE BTN CLICK!");
		
		// JSON MAKER
		$("#jsonMaker").click(function() {
			var jsonStr = '{"member":[{"name":"홍길동", "age":"20"},{"name":"김길동", "age":"30"},{"name":"박길동", "age":"40"}]}';	// JSON형태의 문자열 생성
			
			/*	JSON 	
					- 제이쿼리의 JSON 기능
					
					PARSE
						- JSON형태의 문자열을 JSON 자료형으로 변환한다.
					
					STRINGIFY
						- JAVASCRIPT의 값이나 객체를  JSON 문자열로 변환
						
					EVAL
						- JSON 형태의 문자열을 JSON형태로 변경
			*/
			var jsonInfo = JSON.parse(jsonStr);	
			var resStr = "<h3>JSON MAKER</h3><br>";
			resStr += JSON.stringify(jsonInfo) + "<br><br>";

			for(var i in jsonInfo.member){
				resStr += jsonInfo.member[i].name + " / " + jsonInfo.member[i].age + "<br>";
			}
			
			$("#divArea").html(resStr);
		}); // JSON MAKER
		
		
		// VO_TO_JSON
		$("#voToJson").click(function() {
			//
			$.ajax({
				type: "post",
				async: false,
				url: "vo_to_json.do",
				data: null,
				success: function(data){
					//
					var jsonInfo = eval(data);
					var resStr = "<h3>VO_TO_JSON</h3><br>";
					resStr += JSON.stringify(jsonInfo) + "<br><br>";
					
					if(jsonInfo[0].res=="Y"){
						$("#divArea").html(resStr + "체크 확인 값은 Y입니다.");
					}
					
				}
			});
			
		}); // VO_TO_JSON
		
		
		// MAP TO JSON
		$("#mapToJson").click(function() {
			//
			$.ajax({
				type: "post",
				async: false,
				url: "map_to_json.do",
				data: null,
				success: function(data){
					//
					var resStr = "<h3>MAP TO JSON</h3><br>";
					var jsonInfo = eval(data);
					resStr += JSON.stringify(jsonInfo) + "<br><br>";
					
					for(i in jsonInfo){
						//
						if(jsonInfo[i].length>=1){
							resStr += i + " / " + jsonInfo[i] + "<br>";
						}else{
							for(k in jsonInfo[i]){
								resStr += k + " / " + jsonInfo[i].tel + "<br>";								
							}
						}
						
					}
					$("#divArea").html(resStr); 
				}
			});
			
		}); // MAP TO JSON
		
		// JSON OBJECT
		$("#jsonObject").click(function() {
			//
			$.ajax({
				type: "post",
				async: false,
				url: "json_object.do",
				data: null,
				success: function(data){
					// JSON형태의 문자열을 JSON데이터로 변경
					var jsonData = JSON.parse(data);
					var resStr = "<h3>JSON OBJECT</h3><br>";
					resStr += JSON.stringify(data) + "<br><br>";

					for(i in jsonData.jsonArr){
						resStr += jsonData.jsonArr[i].name + " / " + jsonData.jsonArr[i].age + "<br>";
					}
					
					$("#divArea").html(resStr);
				}
			});
			
		}); // JSON OBJECT
		
	});
</script>
</head>
<body>
	<!-- JSON -->
	<input type="button" id="jsonMaker" value="JSON MAKER" >
	<input type="button" id="voToJson" 	value="VO TO JSON" >
	<input type="button" id="mapToJson" value="MAP TO JSON" >
	<input type="button" id="jsonObject" value="JSON OBJECT" >
	
	<br><br>
	
	<!-- DIV -->
	<div id="divArea"></div>
</body>
</html>