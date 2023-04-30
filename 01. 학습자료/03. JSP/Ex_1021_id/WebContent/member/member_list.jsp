<%@page import="vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!--모델2는 서블릿에서 실행해야한다.
	하나의 프로젝트안에서 부서, 고객, 멤버등 여러가지를 관리하는데
	WebContent안에 다 같이 넣어놓으면 혼동이 온다. 그래서 패키지와 같은 개념으로 폴더를 만든다. (member/해둔 이유)
	추후 회원에대한 모든 자료는 member폴더에 넣으면 된다. 
	
	model1과 model2의 차이점
	model1 : servlet없이 하나의 jsp에서 화면 구현 입력 출력까지 모두 다 처리하는 방식
	model2 : 구현로직과 처리로직을 분리해서 작업하는 형태
				jsp : 화면 ui 및 요청작업등
				servlet : 처리(비즈니스) 로직
				등을 작업하는 형태로 분리해둔 것
	 -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<!-- ajax를 사용하는 경우 ../로 한번 뒤로 나와야한다. -->
		<script src="../js/httpRequest.js"></script>
		
		<script type="text/javascript">
			function del(idx) {
				if(!confirm("정말로 삭제하시겠습니까?")){
					return;
				}
				
				var url = "del.do"
				// encodeURIComponent : &등의 문자가 서버로 보내는 과정에서 혼동되지 않도록 쓰는 기능
				var param = "idx="+encodeURIComponent(idx);
				
				sendRequest(url,param,resultF,"POST");
				
			}
			
			function resultF() {
				if(xhr.readyState==4 && xhr.status==200){
					// "[{'res':%d}]" 형태의 Stirng타입
					var data = xhr.responseText;
					
					// "[{'res':%d}]" JSON타입
					var json = eval(data);
					if( json[0].res == 1 ){
						alert("삭제성공");
					}else{
						alert("삭제실패");
					}
					
					location.href="member_list.do";
				}
			}
		
		</script>
	</head>
<body>
	<table border="1">
		<caption>::회원정보::</caption>
		
		<tr>
			<td colspan="7">
				<input type="button" value="회원 등록" onclick="location.href='member_insert_form.jsp'">
			</td>
		</tr>
		
		<tr>
			<th>회원번호</th>
			<th>이름</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이메일</th>
			<th>주소</th>
			<th>비고</th>
		</tr>
		
		<c:forEach var="p" items="${ list }">
		<tr>
			<td>${ p.idx }</td>
			<td>${ p.name }</td>
			<td>${ p.id }</td>
			<td>${ p.pwd }</td>
			<td>${ p.email }</td>
			<td>${ p.addr }</td>
			<td><!-- 여기서는 list정보가 없으므로 실행은 action에서 해야한다. servlet이 수정되면 새로고침이 아닌 다시 실행해야한다.  -->
				<input type="button" value="삭제" onclick="del(${ p.idx })">
			</td>
		</tr>
		</c:forEach>
		
	</table>
</body>
</html>