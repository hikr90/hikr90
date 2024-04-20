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
				<!-- 댓글 들여쓰기 (DEPTH의 값만큼 공백을 띄워서 댓글과 대댓글을 표현하는 것이 가능하다.) -->
					<c:forEach begin="1" end="${ vo.depth }">
						&nbsp;
					</c:forEach>
			
				<!-- 댓글을 ㄴ으로 표현하는 방법 -->
					<c:if test="${ vo.depth ne 0 }">
						ㄴ
					</c:if>
				
				<!-- 제목에 링크달기 -->
				<!-- 삭제된 글  (회색의 링크가 없는 글로 표현) -->
				<c:if test="${ vo.del_info eq -1 }">
					<a href="" style="color: gray; text-decoration: none;">
						${ vo.subject }
					</a>		
				</c:if>
				<!-- 삭제되지 않은 글  
						상세보기로 이동하는 경우 취소, DB작업 처리로 돌아오는 경우 해당 페이지로 다시 돌아올 수 있도록 PAGE변수를 같이 보낸다.
						특히 첫 실행시에 PAGE값은 NULL이므로 삼항 연산자를 통해서 NULL인 경우에는 LIST.DO에 1페이지를 반환할 수 있어야한다. 
						
						특정 페이지에 PAGE값이 있는 경우 해당 값을 LIST.DO로 반환하여 작업이 완료된 후 해당 페이지에 있게한다.  -->
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
			
			<tr><!-- CURSOR : POINTER는 마우스 태그에 올려둔 경우 손가락 아이콘으로 변하는 기능이다. -->
				<td colspan="5">
					<img src="../img/btn_reg.gif" align="right"
						onclick="location.href='insert_form.do'"
						style="cursor:pointer;">
				</td>
			</tr>
		</table>
	</body>
</html>