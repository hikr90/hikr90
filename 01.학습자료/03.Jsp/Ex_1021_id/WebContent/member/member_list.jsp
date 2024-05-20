<%@page import="vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!--Model2 방식
		- 서블릿을 통해서 로직이 수행된다.
		- 구현 로직과 비즈니스 로직이 분리되어 작업이 진행된다.
-->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="../js/httpRequest.js"></script>
		
		<script type="text/javascript">
			// 삭제
			function del(idx) {
				if(!confirm("정말로 삭제하시겠습니까?")){
					return;
				}
				//				
				var url = "del.do"
				var param = "idx="+encodeURIComponent(idx);
				//
				sendRequest(url,param,resultF,"POST");
			}
			
			// 콜백 메소드
			function resultF() {
				if(xhr.readyState==4 && xhr.status==200){
					var data = xhr.responseText;
					var json = eval(data);
					//
					if( json[0].res == 1 ){
						alert("삭제성공");
					}else{
						alert("삭제실패");
					}
					//					
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
				<td>
					<input type="button" value="삭제" onclick="del(${ p.idx })">
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>