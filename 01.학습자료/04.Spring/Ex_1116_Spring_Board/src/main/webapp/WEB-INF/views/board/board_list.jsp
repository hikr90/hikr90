<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			a{text-decoration: none;}
		</style>
	
	</head>
	<body>
		
		<table border="1" align="center" width="700px"
				style="border-collapse: collapse;">
			
			<caption>::게시판::</caption>
			<tr>
				<th width="10%">번호</th>
				<th>제목</th>
				<th width="20%">작성자</th>
				<th width="15%">작성일</th>
				<th width="10%">조회수</th>
			</tr>			
			
			<c:forEach var="vo" items="${ list }">
			<tr>
				<td align="center">${ vo.idx }</td>
				
				
				<td>
				<!-- 댓글 들여쓰기
						- 댓글은 DEPTH의 값에따라 알 수 있다. 
						- 댓글인 경우 1, 대댓글인 경우 2 
				-->
				<c:forEach begin="1" end="${ vo.depth }">
					&nbsp; <!-- 들여쓰기위한 공백 -->
				</c:forEach>
				
				<!-- 댓글 기호 -->
				<c:if test="${ vo.depth ne 0 }">
					ㄴ
				</c:if>
				
				<!-- 삭제 처리된 항목 -->
				<c:if test="${ vo.del_info eq -1 }">
					<a href="" style="color: gray; text-decoration: none;">
						${ vo.subject }
					</a>		
				</c:if>
				
				<!-- 삭제 처리되지 않은 항목
						- 처음 실행시 PAGE는 NULL값이므로 삼항연산자를 통해서 NULL인 경우 1페이지를 LIST.DO에 반환할 수 있어야한다. 
						- 특정 페이지에 PAGE값이 있는 경우 해당 값을 LIST.DO로 반환하여 작업이 완료된 후 해당 페이지에 머물도록 한다.   
				-->
				<c:if test="${ vo.del_info eq 0 }">
				<a href="view.do?idx=${ vo.idx }&page=${ empty param.page ? 1 : param.page }">
					${ vo.subject }				
				</a>				
				</c:if>
				</td>	
				
				<td align="center">${ vo.name }</td>
				<td align="center">${ vo.regdate }</td>
				<td align="center">${ vo.readhit }</td>
			</tr>
			
			</c:forEach>
			
			<!-- 글이 없는 경우 -->
			<c:if test="${ empty list }">
			<tr>
				<td colspan="5" align="center">현재 등록된 글이 없습니다.</td>
			</tr>
			</c:if>
			
			<!-- 페이지 목록 -->
			<tr align="center">
				<td colspan="5">
				<!-- 하단 페이지에 PAGEMENU를 불러온다. -->
					${ pageMenu }
				</td>
			</tr>
			
			<tr>
				<td colspan="5">
				<!-- CURSOR:POINTER
						- 이미지에 마우스를 올렸을 때, 손가락 아이콘으로 변경되는 기능
				-->
					<img src="${pageContext.request.contextPath}/resources/img/btn_reg.gif" align="right"
						onclick="location.href='insert_form.do'"
						style="cursor:pointer;"> 
				</td>
			</tr>
		</table>
	</body>
</html>