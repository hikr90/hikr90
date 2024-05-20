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
		<table border="1" align="center" width="700px" style="border-collapse: collapse;">
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
						<!-- 댓글 들여쓰기 값 (Depth) -->
						<c:forEach begin="1" end="${ vo.depth }">
							&nbsp;
						</c:forEach>
				
						<!-- 댓글을 'ㄴ'으로 표현하는 방법 -->
						<c:if test="${ vo.depth ne 0 }">
							ㄴ
						</c:if>
					
						<!-- 제목에 링크달기 -->
						<!-- 삭제된 게시글은 회색의 링크가 없는 글로 표현한다. -->
						<c:if test="${ vo.del_info eq -1 }">
							<a href="" style="color: gray; text-decoration: none;">
								${ vo.subject }
							</a>		
						</c:if>
					
						<!-- 게시글 클릭 시 페이징 값 처리
								- 상세보기로 이동하는 경우, 취소 혹은 DML작업 후 들어왔던 페이지 값을 그대로 유지할 수 있도록 page 값을 같이 보낸다.
								- 단, 목록 처음 조회 시 page값은 NULL이므로 삼항연산자를 통해서 없는 경우에는 1값으로 지정한다.
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
					<!-- 하단 페이지에 pageMenu값을 불러온다. -->
					${ pageMenu }
				</td>
			</tr>
			
			<tr>
				<td colspan="5">
					<!-- onClick 속성 내에 location.href 값을 추가하여 이동시킬 수 있다. -->
					<img src="../img/btn_reg.gif" align="right" onclick="location.href='insert_form.do'" style="cursor:pointer;">
				</td>
			</tr>
		</table>
	</body>
</html>