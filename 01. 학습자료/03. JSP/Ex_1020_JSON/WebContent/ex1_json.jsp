<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- JSON(Javascript Object Notation) 표기법
		서로 다른 프로그램(또는 OS)에서 데이터를 교환하기위한 약속된 표기법
		
		
		(5분)
		네이버에서 프로그램별로 따로 데이터를 줄 필요없이 JSON타입하나로 여러 프로그램에 주면 각각의 프로그램에서 공통적인 방법으로 분석하는 방법
		  -->

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript">
			/* JSON표기법은 마치 MAP처럼 KEY,VALUE형태로 저장이 된다. (MAP은 아니다.) 
				콜백처럼 아래의 데이터가 넘어온다고 생각하면 된다. */
			var p = {'name':'일길동','age':'30','tel':'010-1111-1111'};
			
			// document.write : 인터넷창에 출력
			document.write("이름 : "+p.name+"<br>");
			document.write("나이 : "+p.age+"<br>");
			document.write("전화 : "+p['tel']+"<br>"); 
			
			document.write("<hr>");
			
			// JSON 배열(1차원)
			/// []이 있는 경우 배열 형식이 [0]등의 방식으로 열어야한다.
			var p_arr = [{'name':'hong','age':'30','tel':'010'},
							{'name':'kim','age':'35','tel':'017'},
							{'name':'oh','age':'27','tel':'011'}];
			
			// 배열에서 값을 찾는 방식은 python과 비슷하다. 
			document.write(p_arr[0].name+"<br>");
			
			document.write("<hr>");
			
			for(var i=0;i<p_arr.length;i++){
				document.write(p_arr[i].name+" / "+
								p_arr[i].age+" / "+
								p_arr[i].tel+"<br>");
			}	
			
			
			document.write("<hr>");
			
			
			// JSON 혼합 배열(2차원)
			// 키 값은 하나이나 해당하는 value값이 여러개
			var course = {'name':'웹개발3',
							'start':'2020-07-01',
							'end':'2021-01-02',
							'sub':['java','jsp','android'],
							'student':[{'name':'hong','age':'20'},
										{'name':'kim','age':'22'},		// JSON의 다차원 배열
										{'name':'park','age':'25'}]};
			
			// 혼합배열 출력
			document.write("과목명 : "+course.name+"<br>");
			document.write("시작날짜 : "+course.start+"<br>");
			
			document.write("과목명1 : "+course.sub[0]+"<br>");
			document.write("과목명2 : "+course.sub[1]+"<br>");
			
			document.write("학생1 : "+course.student[0].name+"<br>");
			document.write("학생3 : "+course.student[2].name+"<br>");
			
			
			
		</script>
	
	</head>
	<body>
		
	</body>
</html>