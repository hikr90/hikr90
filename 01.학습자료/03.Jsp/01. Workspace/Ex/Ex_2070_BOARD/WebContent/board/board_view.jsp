<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="../js/httpRequest.js"></script>
		<script type="text/javascript">
			// 답글 화면 출력
			function reply() {
				// 몇번 게시글에 댓글을 남길 것인지에대한 변수 값을 같이 전송해야한다.
				location.href="reply_form.do?idx=${vo.idx}&page=${param.page}";
			}
			
			// 게시글 삭제
			function del() {
				//
				if(confirm("정말로 삭제하시겠습니까?")){
					var pwd = document.getElementById("c_pwd").value;
					var url = "del.do";
					var param = "idx=${ vo.idx }&pwd="+pwd;
					//					
					sendRequest(url, param, resultFn, "POST");
				}
			}
			
			// 콜백 메소드
			function resultFn() {
				if(xhr.readyState==4 && xhr.status==200){
					var data = xhr.responseText;
					var json = eval(data);
					//
					if(json[0].res=="yes"){
						alert("삭제에 성공했습니다.");
						location.href="list.do?page=${param.page}";
					}else{
						alert("비밀번호가 틀렸습니다.");
					}
				}
			}
			
			// 게시글 수정
			function modify() {
				var pwd = document.getElementById("c_pwd").value;
				//				
				if(pwd != "${vo.pwd}"){					
					alert("비밀번호가 맞지 않습니다.");
					return;
				}
				//
				location.href="update_form.do?idx=${vo.idx}&page=${param.page}";
			}
		</script>
	</head>
	<body>
		<form name="f" method="POST">
		<table border="1">
				<tr>
					<th>제목</th>
					<td>${ vo.subject }</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${ vo.name }</td>
				</tr>
				<tr>
					<th>작성일</th>
					<td>${ vo.regdate }</td>
				</tr>
				<tr>
					<th>ip</th>
					<td>${ vo.ip }</td>
				</tr>
				<tr>
					<th>내용</th>
					<!-- pre태그
							- DB에 저장되어있는 엔터 값이 Html에서 그대로 적용되어 출력하게하는 태그 
					-->
					<td><pre>${ vo.content }</pre></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" id="c_pwd" name="c_pwd"></td>
				</tr>
				<tr>
					<td colspan="2">
						<img src="../img/btn_list.gif" onclick="location.href='list.do?page=${param.page}'" style="cursor: pointer;">
						
						<c:if test="${ vo.depth lt 1 }">
							<!-- 현재 게시글에 답글 처리 -->
							<img src="../img/btn_reply.gif" onclick="reply();" style="cursor: pointer;">
						</c:if>

						<!-- 게시글 수정 -->
						<img src="../img/btn_modify.gif" onclick="modify();" style="cursor: pointer;">
		
						<!-- 게시글 삭제 -->
						<img src="../img/btn_delete.gif" onclick="del();" style="cursor: pointer;">						
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>