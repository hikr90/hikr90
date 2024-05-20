<%@page import="vo.SungjukVO"%>
<%@page import="java.util.List"%>
<%@page import="dao.SungjukDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	SungjukDAO s_dao = SungjukDAO.getInstance();
	List<SungjukVO> sung_list = s_dao.selectList();
%>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
	<script type="text/javascript">
	
		function show_form() {
			var disp = document.getElementById("disp");
			disp.style.display = 'block';
		}	
		
		// 등록 취소
		function my_cancel() {
			var disp = document.getElementById("disp");
			disp.style.display = "none";
			
			// 값의 취소
			// - name 속성으로 값을 찾은 뒤 값을 초기화한다.
			// - getElementByName 메소드는 name값으로 태그를 찾는 메소드이다. (같은 명칭이 있을 수 있으므로 배열로 반환한다.)
			document.getElementsByName("name")[0].value = "";
			document.getElementsByName("kor")[0].value = "";
			document.getElementsByName("eng")[0].value = "";
			document.getElementsByName("mat")[0].value = "";
			//			
			var disp2 = document.getElementById("disp2");
			disp2.style.display = "none";
		}		
		
		// 등록
		function send(f) {
			// trim은 값의 양쪽 공백을 제거하는 함수이다.
			var name = f.name.value.trim();
			var kor = f.kor.value.trim();
			var eng = f.eng.value.trim();
			var mat = f.mat.value.trim();
			//			
			if(name==''){
				alert("이름은 반드시 입력되어야합니다.");
				f.name.focus();
				return;
			}
			// 숫자만 가능한 정규식
			var number = /^[0-9]+$/;
			//			
			if(!number.test(kor) || kor < 0 || kor > 100){
				alert("0에서 100사이의 정수만 입력가능합니다.");
				f.kor.value = '';
				f.kor.focus();
				return;
			}
			if(!number.test(eng) || eng < 0 || eng > 100){
				alert("0에서 100사이의 정수만 입력가능합니다.");
				f.eng.value = '';
				f.eng.focus();
				return;
			}
			if(!number.test(mat) || mat < 0 || mat > 100){
				alert("0에서 100사이의 정수만 입력가능합니다.");
				f.mat.value = '';
				f.mat.focus();
				return;
			}
			//
			f.action = "sung_register.jsp";
			f.submit();
		}
		
		// 삭제
		function del(no) {
			// confirm
			// - 확인 알림창을 뜨게하는 함수
			// - 확인 클릭 시 true, 취소 시 false를 반환한다.
			if(!confirm("정말로 삭제하시겠습니까?")){
				return;	// 아무 동작도 하지 않고 함수를 나옴
			}
			
			// location.href
			//	- 페이지로 이동하는 함수
			//	- 뒤에 파라미터를 붙여주고자하는 경우 url?변수=값1&변수2=값2... 의 형식으로 전송한다. 
			// 	- 폼태그 없이 호출이 가능하다.
			//	- get방식의 전송만 가능하다.
			location.href="sung_del.jsp?no="+no;
		}
		
		// 수정
		function update(no,name,kor,eng,mat) {
			//
			var disp2 = document.getElementById("disp2");
			disp2.style.display = 'block';
			//			
			document.getElementsByName("name2")[0].value = name;
			document.getElementsByName("kor2")[0].value = kor;
			document.getElementsByName("eng2")[0].value = eng;
			document.getElementsByName("mat2")[0].value = mat;
			document.getElementsByName("no")[0].value = no;
		}
		
		// 폼태그를 파라미터로 받아 내용 수정
		function send2(f) {
			// 유효성 검사는 했다고 가정
			f.action = "sung_update.jsp";
			f.submit();
		}
	</script>
	</head>
	<body>
	
		<table border="1">
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>국어</th>
				<th>영어</th>
				<th>수학</th>
				<th>총점</th>
				<th>평균</th>				
				<th>등수</th>				
				<th colspan="2">비고</th>				
			</tr>
			
			<%for(int i=0;i<sung_list.size();i++){ 
				SungjukVO vo = sung_list.get(i);%>
				
				<tr>					
					<td><%=vo.getNo() %></td>
					<td><%=vo.getName() %></td>
					<td><%=vo.getKor() %></td>
					<td><%=vo.getEng() %></td>
					<td><%=vo.getMat() %></td>
					<td><%=vo.getTotal()%></td>
					<td><%=vo.getAvg()%></td>
					<td><%=vo.getRank()%></td>
					<td><input type="button" value="삭제" onclick="del('<%=vo.getNo()%>');"></td>
					<td><input type="button" value="수정" onclick="update('<%=vo.getNo()%>',
																			'<%=vo.getName()%>',
																			'<%=vo.getKor()%>',
																			'<%=vo.getEng()%>',
																			'<%=vo.getMat()%>')"></td>			
				</tr>
				
			<% } %>
			
			<!-- 추가 -->
			<tr align="center">
				<td colspan="10">
					<input type="button" value="학생정보 추가" id="btn_append" onclick="show_form()">
				</td>
			</tr>
			
		</table>
		
		<div id="disp" style="display: none;">
			<form>
				<table border="1">
					<caption>::성적 등록하기::</caption>
						<tr>
						<th>이름</th>
							<td><input type="text" name="name"></td>
						</tr>	
						<tr>
						<th>국어</th>
							<td><input type="text" name="kor"></td>
						</tr>	
						<tr>
						<th>영어</th>
							<td><input type="text" name="eng"></td>
						</tr>	
						<tr>
						<th>수학</th>
							<td><input type="text" name="mat"></td>
						</tr>
						<tr>
							<td colspan="2" align="center">
								<input type="button" value="등록" onclick="send(this.form);"> 
								<input type="button" value="취소" onclick="my_cancel()"> 
							</td>
						</tr>
				</table>
			</form>
		</div>
	
		<div id="disp2" style="display:none">
			<form>
				<input type="hidden" name="no">
				<table border="1">
					<caption>::항목 수정::</caption>
					<tr>
						<th>이름</th>
						<td><input type="text" name="name2"></td>
					</tr>

					<tr>
						<th>국어</th>
						<td><input type="text" name="kor2"></td>
					</tr>

					<tr>
						<th>영어</th>
						<td><input type="text" name="eng2"></td>
					</tr>

					<tr>
						<th>수학</th>
						<td><input type="text" name="mat2"></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="button" value="수정" onclick="send2(this.form);"> 
							<input type="button" value="취소" onclick="my_cancel()"> 
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>