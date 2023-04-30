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
			
			// 취소를 눌렀을시 값을 찾는데는 id를 지정해서 찾아서 초기화 시켜줘야하는데 name으로도 충분히 가능하다.
			// getElementsByName : 같은 이름을 가진 속성들을 배열 형식으로 가져온다.
			// 같은 name이 있을 경우 어떤 name인지 알 수 없어서 s를 붙이는데 이 경우 name[0], name[1]형식으로 원하는 값을 가져올 수 있다. (개인적으로는 id를 만들어서 하는 것을 추천)
			document.getElementsByName("name")[0].value = "";
			document.getElementsByName("kor")[0].value = "";
			document.getElementsByName("eng")[0].value = "";
			document.getElementsByName("mat")[0].value = "";
			
			var disp2 = document.getElementById("disp2");
			disp2.style.display = "none";
			
		}		
		
		// 등록
		function send(f) {
			var name = f.name.value.trim();
			var kor = f.kor.value.trim();
			var eng = f.eng.value.trim();
			var mat = f.mat.value.trim();
			
			if(name==''){
				alert("이름은 반드시 입력되어야합니다.");
				f.name.focus();
				return;
			}
			
			var number = /^[0-9]+$/;
			
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
			
			f.action = "sung_register.jsp";
			f.submit();
			
		}
		
		// 삭제 기능
		function del(no) {
			
			// confirm이라는 메서드는 경고창을 띄워서 확인시 true, 취소시 false를 반환한다.
			if(!confirm("정말로 삭제하시겠습니까?")){
				// 취소 버튼 클릭시 동작 아무것도 안함
				return;
			}
			
			// location.href는 form태그 없이 가능하며 호출이되면 sung_del.jsp페이지로 바로 이동하며 파라미터를 바로 보내버린다.
			// 단, GET방식만 한다.
			location.href="sung_del.jsp?no="+no;
			
		}
		
		// 수정 버튼 기능
		function update(no,name,kor,eng,mat) {
			
			var disp2 = document.getElementById("disp2");
			disp2.style.display = 'block';
			
			document.getElementsByName("name2")[0].value = name;
			document.getElementsByName("kor2")[0].value = kor;
			document.getElementsByName("eng2")[0].value = eng;
			document.getElementsByName("mat2")[0].value = mat;
			document.getElementsByName("no")[0].value = no;
		}
		
		
		// 내용 수정
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
		
		
		<!-- 학생 추가를 위한 입력폼 (나중에는 페이지를 전환해서 띄우자) -->
		<!-- display를 none으로 하면 해당 항목이 사라진다. 다시 보이게한다면 block으로 해주면 된다. -->
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
	
	
		<!-- 수정을 위한 폼 -->
		<div id="disp2" style="display:none">
			<form>
				
				<!-- 어떤 사람을 수정할지를 결정하는 no -->
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