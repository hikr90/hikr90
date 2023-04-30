<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 게시글 상세보기  -->
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<!-- 삭제 여부에대한 값을 다시 받아와야하므로 AJAX를 사용해야한다. -->
		<script src="../js/httpRequest.js"></script>
		<script type="text/javascript">
			function reply() {
				// 몇번 글에 게시글을 달고싶은지 글을 남겨야한다.
				location.href="reply_form.do?idx=${vo.idx}&page=${param.page}";
			}
			
			function del() {
				
				if(confirm("정말로 삭제하시겠습니까?")){
					/* 비밀번호가 있으므로 LOCATION.HREF를 사용하지 않는다. */
					var pwd = document.getElementById("c_pwd").value;
					var url = "del.do";
					var param = "idx=${ vo.idx }&pwd="+pwd;
					
					sendRequest(url, param, resultFn, "POST");
				}
			}
			
			function resultFn() {
				if(xhr.readyState==4 && xhr.status==200){
					var data = xhr.responseText;
					var json = eval(data);
					
					if(json[0].res=="yes"){
						alert("삭제에 성공했습니다.");
						/*	PARAM변수의 사용 이유 
								여기서는 PAGE변수가 다시 해당 페이지로 돌아올 때 사용하는 변수로, 이곳에서 다시 다른 SERVLET에서 사용하고 
								결과적으로는 LIST.DO에 전달해야하는 상황이므로 PARAM이라는 변수에 담는 것이다.
						*/						
						location.href="list.do?page=${param.page}";
					}else{
						alert("비밀번호가 틀렸습니다.");
					}
				}
			}
			
			// 정보 수정
			function modify() {
				var pwd = document.getElementById("c_pwd").value;
				
				if(pwd != "${vo.pwd}"){					
					alert("비밀번호가 맞지 않습니다.");
					return;
				}
				location.href="update_form.do?idx=${vo.idx}&page=${param.page}";
			}
		</script>
	</head>
	<body>
		<table border="1">
			<form name="f" method="POST">
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
					<!-- PRE태그는 DB에 저장되어있는 엔터값이 그대로 적용되게하는 태그이다. -->
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
						<!-- 현재 게시글에 답글달기 -->
						<img src="../img/btn_reply.gif" onclick="reply();" style="cursor: pointer;">
						</c:if>

						<!-- 게시글 수정하기 -->
						<img src="../img/btn_modify.gif" onclick="modify();" style="cursor: pointer;">
						<!-- 게시글 삭제하기 -->
						<img src="../img/btn_delete.gif" onclick="del();" style="cursor: pointer;">						
					</td>
				</tr>
			</form>
		</table>
	</body>
</html>