<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 게시글 상세보기  -->
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="${pageContext.request.contextPath}/resources/js/httpRequest.js"></script>
		
		<script type="text/javascript">
			// 댓글 등록 화면으로 이동
			function reply() {
				// 몇번 글에 게시글을 달고싶은지 글을 남겨야하므로 Idx와 Page를 Param으로 보내준다.
				location.href="reply_form.do?idx=${vo.idx}&page=${param.page}";
			}
			
			// 삭제
			function del() {
				//				
				if(confirm("정말로 삭제하시겠습니까?")){
					//
					var pwd = document.getElementById("c_pwd").value;
					var url = "del.do";
					var param = "idx=${ vo.idx }&pwd="+pwd;
					//
					sendRequest(url, param, resultFn, "POST");
				}
			}
			
			function resultFn() {
				if(xhr.readyState==4 && xhr.status==200){
					var data = xhr.responseText;
					var json = eval(data);
					
					if(json[0].res=="yes"){
						alert("삭제에 성공했습니다.");
						/*	Param 객체에 담아서 보내는 방법
								- 컨트롤러에서, 디스패처로 포워딩 후 Jsp에서 EL표기법으로 사용해도 무방하다.
								- 본 예제에서는 Page는 다시 해당 페이지로 돌아올 때 사용하는 변수로서 
								- 이곳에서 다시 다른 서블릿으로 사용하고 또 결과적으로 list.do에 전달해야하므로 Param에 담아서 사용한다. 
						*/
						location.href="list.do?page=${param.page}";
					}else{
						alert("비밀번호가 틀렸습니다.");
					}
				}
			}
			
			// 수정
			function modify() {
				//
				var pwd = document.getElementById("c_pwd").value;
				//
				if(pwd != "${vo.pwd}"){					
					alert("비밀번호가 맞지 않습니다.");
					return;
				}
				// 수정 폼도 마찬가지로 다시 되돌아올 수 있도록 Idx와 Page를 담아준다.
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
						<!-- Pre태그는 데이터 내에 존재하는 엔터 값이 화면 상에서 그대로 적용되도록 한다. -->
						<td><pre>${ vo.content }</pre></td>
					</tr>
					
					<tr>
						<th>비밀번호</th>
						<td><input type="password" id="c_pwd" name="c_pwd"></td>
					</tr>
					
					<tr>
						<td colspan="2">
							<!-- 목록으로 돌아갈 시, 해당 게시글이 존재하는 페이지로 돌아가도록 list에서 받아온 Page값을 Param.Page로 보내준다. -->
							<img src="${pageContext.request.contextPath}/resources/img/btn_list.gif" onclick="location.href='list.do?page=${param.page}'" style="cursor: pointer;">
							
							<c:if test="${ vo.depth lt 1 }">
								<!-- 현재 게시글에 댓글달기 -->
								<img src="${pageContext.request.contextPath}/resources/img/btn_reply.gif" onclick="reply();" style="cursor: pointer;">
							</c:if>
							
							<!-- 게시글 수정하기 -->
							<img src="${pageContext.request.contextPath}/resources/img/btn_modify.gif" onclick="modify();" style="cursor: pointer;">
							<!-- 게시글 삭제하기 -->
							<img src="${pageContext.request.contextPath}/resources/img/btn_delete.gif" onclick="del();" style="cursor: pointer;">						
						</td>
					</tr>
			</table>
		</form>
	</body>
</html>