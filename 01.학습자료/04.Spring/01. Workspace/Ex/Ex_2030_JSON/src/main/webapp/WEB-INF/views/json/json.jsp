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
		
		// Json Maker
		$("#jsonMaker").click(function() {
			var jsonStr = '{"member":[{"name":"홍길동", "age":"20"},{"name":"김길동", "age":"30"},{"name":"박길동", "age":"40"}]}';	// JSON형태의 문자열 생성
			
			/*	Json 	
					- Javascript Object Notation
					- 대표적인 비 관계형 데이터의 형태
					- 서로 다른 프로그램 및 운영체계에서 데이터를 교환하기위한 약속된 형식의 텍스트를 사용하는 개방형 표준 데이터 형식
					- 단순한 형식이기에 비교적 자원이 열악한 앱 환경에서 데이터를 주고받는 XML 형식을 대체한다.
					
					형태
						- key와 value값의 형태
						- Json의 데이터는 기본적인 배열 형태외에도 1개의 키 값에 다수의 value값이 존재하는 혼합 형태가 있다.
						- {} 으로 감싸서 표현되며 , 를 사용하여 여러 값이 저장된다.
						- 배열 형태의 경우 []으로 감싸진다.
						
						(1) 기본 형태 (객체)
							- {"키1":"값1","키2":"값2","키3":"값3"}
						
						(2) 기본 형태 (배열)
							- {"배열명":["값1","값2","값3"]}
						
						(3) 혼합 형태
							- var json = {"키1":"값",
											"키2":"값2",
											"키3","값3",
											"키4":["값4.1","값4.2","값4.3"],
											"키5":[{"키5.1":"값5.1","키5.2":"값5.2"},
													{"키5.3":"값5.3","키5.4":"값5.4"},
													{"키5.5":"값5.5","키5.6":"값5.6"}]}
					
					메소드
						(1) Parse
							- Json형태의 문자열을 Json 자료형으로 변환

						(2) Stringify
							- 자바스크립트의 값이나 객체를 Json 문자열로 변환
						
						(3) Eval
							- Json 형태의 문자열을 Json형태로 변경
			*/
			var jsonInfo = JSON.parse(jsonStr);	
			var resStr = "<h3>JSON MAKER</h3><br>";
			resStr += JSON.stringify(jsonInfo) + "<br><br>";
			//
			for(var i in jsonInfo.member){
				resStr += jsonInfo.member[i].name + " / " + jsonInfo.member[i].age + "<br>";
			}
			//			
			$("#divArea").html(resStr);
		}); // Json Maker
		
		
		// VO to Json
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
			
		}); // VO to Json
		
		
		// Map to Json
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
			
		}); // Map to Json
		
		// Json Object
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
					//
					for(i in jsonData.jsonArr){
						resStr += jsonData.jsonArr[i].name + " / " + jsonData.jsonArr[i].age + "<br>";
					}
					//					
					$("#divArea").html(resStr);
				}
			});
			
		}); // Json Object
	});
</script>
</head>
<body>
	<!-- Json -->
	<input type="button" id="jsonMaker" value="JSON MAKER" >
	<input type="button" id="voToJson" 	value="VO TO JSON" >
	<input type="button" id="mapToJson" value="MAP TO JSON" >
	<input type="button" id="jsonObject" value="JSON OBJECT" >
	
	<br><br>
	
	<!-- Div -->
	<div id="divArea"></div>
</body>
</html>