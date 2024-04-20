<%@page import="vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	MemberDAO m_dao = MemberDAO.getInstance();
	List<MemberVO> member_list = m_dao.selectList();
%>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript">
		function del(idx) {
			if(!confirm("정말로 삭제하시겠습니까?")){
				return;
			}
			
			location.href = "member_del.jsp?idx="+idx;
		}
		
		function register() {
			var disp = document.getElementById("disp");
			disp.style.display = "block";
		}
		
		function cancel() {
			var disp = document.getElementById("disp");
			disp.style.display = "none";
		}
		
		function send(f) {
			var name = f.name.value;
			var id = f.id.value;
			var pwd = f.pwd.value;
			var email = f.email.value;
			var addr = f.addr.value;
			var pwd_pattern = /^[0-9]+$/;
			var email_pattern = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
			
			if(name==""){
				alert("이름을 입력해주세요.");
				return;
			}
			if(id==""){
				alert("아이디를 입력해주세요.");
				return;
			}
			if(pwd==""){
				alert("비밀번호를 입력해주세요.");
				return;
			}
			if(!pwd_pattern.test(pwd)){
				alert("비밀번호는 숫자만 가능합니다.");
				return;
			}
			if(!email_pattern.test(email)){
				alert("이메일의 형식에 맞지 않습니다.");
				return;
			}
			
			f.method="POST";
			f.action = "member_register.jsp";
			f.submit();
			
		}
		
		function update(idx,name,id,pwd,email,addr) {
			var disp2 = document.getElementById("disp2");
			disp2.style.display = "block";
			
			document.getElementsByName("name2")[0].value = name;
			document.getElementsByName("id2")[0].value = id;
			document.getElementsByName("pwd2")[0].value = pwd;
			document.getElementsByName("email2")[0].value = email;
			document.getElementsByName("addr2")[0].value = addr;
			document.getElementsByName("idx")[0].value = idx;
			
			
		}
		
		function cancel_update() {
			var disp2 = document.getElementById("disp2");
			disp2.style.display = "none";
		}
		
	
		function send2(f) {
			
			var name = f.name2.value;
			var id = f.id2.value;
			var pwd = f.pwd2.value;
			var email = f.email2.value;
			var addr = f.addr2.value; 
			var pwd_pattern = /^[0-9]+$/;
			var email_pattern = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
			
			if(name==""){
				alert("이름을 입력해주세요.");
				return;
			}
			if(id==""){
				alert("아이디를 입력해주세요.");
				return;
			}
			if(pwd==""){
				alert("비밀번호를 입력해주세요.");
				return;
			}
			if(!pwd_pattern.test(pwd)){
				alert("비밀번호는 숫자만 가능합니다.");
				return;
			}
			if(!email_pattern.test(email)){
				alert("이메일의 형식에 맞지 않습니다.");
				return;
			}

			
			f.action = "member_update.jsp";
			f.method = "POST"; 
			f.submit();

		}
		
	</script>
	
	</head>
	<body>
	
		<table border="1">
			<caption>::회원정보::</caption>
			<tr>
				<th>회원번호</th>
				<th>이름</th>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이메일</th>
				<th>주소</th>
				<th colspan="2">비고</th>
			</tr>
			
				<% for(int i=0;i<member_list.size();i++){ 
					MemberVO vo = member_list.get(i);
				%>
					<tr>
						<td><%=vo.getIdx()%></td>
						<td><%=vo.getName()%></td>
						<td><%=vo.getId()%></td>
						<td><%=vo.getPwd()%></td>
						<td><%=vo.getEmail()%></td>
						<td><%=vo.getAddr()%></td>
						<td><input type="button" name="btn_del" value="삭제" onclick="del('<%=vo.getIdx()%>')"></td>
						<td><input type="button" name="btn_update" value="수정" onclick="update('<%=vo.getIdx()%>',
																							'<%=vo.getName()%>',
																							'<%=vo.getId()%>',
																							'<%=vo.getPwd()%>',
																							'<%=vo.getEmail()%>',
																							'<%=vo.getAddr()%>')"></td>
					</tr>
				<% } %>
			<tr align="center">
				<td colspan="8"><input type="button" value="회원 등록" onclick="register()"></td>
			</tr>	
		</table>
	
		
		<div id="disp" style="display:none;">
			<form>
			<table border="1">
				<caption>::회원 등록::</caption>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pwd"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text" name="addr"></td>
				</tr>
				<tr align="center">
					<td colspan="2">
						<input type="button" name="btn_register" value="등록" onclick="send(this.form);">
						<input type="button" name="btn_cancel" value="취소" onclick="cancel();">
					</td>
				</tr>
			</table>
			</form>
		</div>
		
		<div id="disp2" style="display:none;">
			<form>
			<input type="hidden" name="idx">
			
			<table border="1">
				<caption>::회원 수정::</caption>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name2"></td>
				</tr>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="id2"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pwd2"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="email2"></td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text" name="addr2"></td>
				</tr>
				<tr align="center">
					<td colspan="2">
						<input type="button" name="btn_update" value="수정" onclick="send2(this.form);">
						<input type="button" name="btn_cancel2" value="취소" onclick="cancel_update()">
					</td>
				</tr>
			</table>
			</form>
		</div>
			
	</body>
</html>