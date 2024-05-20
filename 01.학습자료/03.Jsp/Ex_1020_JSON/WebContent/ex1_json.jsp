<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript">
			/* Json
				- Javascript Object Notation 표기법
				- 서로 다른 프로그램 또는 운영체제에서 같은 규칙으로 응답과 요청 데이터를 교환하기위해서 사용되는 약속된 표기법
				- Json은 Key와 Value의 형태로 저장되나 Map과 같은 자료형은 아니다.
			*/
			var p = {'name':'일길동','age':'30','tel':'010-1111-1111'};
			//			
			document.write("이름 : "+p.name+"<br>");
			document.write("나이 : "+p.age+"<br>");
			document.write("전화 : "+p['tel']+"<br>"); 
			//
			document.write("<hr>");
			
			/*	Json의 배열 형태 
					- Json의 배열 형태는 [ ] 으로 { } 데이터를 감싸는 구조로 되어있다.
					- Json의 배열 종류는 여러가지 형태로 존재한다.					
			*/
			// 	(1) 1차원 형태
			// 		- 배열[인덱스]의 방식으로 열어야한다.
			var p_arr = [{'name':'hong','age':'30','tel':'010'},
							{'name':'kim','age':'35','tel':'017'},
							{'name':'oh','age':'27','tel':'011'}];
			//			
			document.write(p_arr[0].name+"<br>");
			document.write("<hr>");
			//
			for(var i=0;i<p_arr.length;i++){
				document.write(p_arr[i].name+" / "+
								p_arr[i].age+" / "+
								p_arr[i].tel+"<br>");
			}	
			//			
			document.write("<hr>");
			
			
			//	(2) 2차원 형태
			//		- 키 값은 하나이나, 그에 속하는 value값이 두개 이상인 경우를 뜻한다.
			//		- 이를 혼합배열이라고 부른다.
			var course = {'name':'웹개발3',
							'start':'2020-07-01',
							'end':'2021-01-02',
							'sub':['java','jsp','android'],
							'student':[{'name':'hong','age':'20'},
										{'name':'kim','age':'22'},
										{'name':'park','age':'25'}]};
			
			//
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