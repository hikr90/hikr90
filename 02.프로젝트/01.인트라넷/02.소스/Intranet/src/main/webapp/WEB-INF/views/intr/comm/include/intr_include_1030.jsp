<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<header style="min-height: 130px;">
	<div class="wrap">
		<div class="header_wrap">
			<div class="header_state">
				<ul class="header_list">
					<c:choose>
						<c:when test="${empVO.authYn eq 'Y'}">
							<li><a href="intrMainInqy1020.do">사용자</a></li>
							<li><a href="intrMainInqy1030.do">관리자</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="intrMainInqy1020.do">사용자</a></li>
						</c:otherwise>
					</c:choose>
					<li><a onclick="logout();">로그아웃</a></li>
				</ul><br><br>
				
				<div class="header_state_text">
					접속을 환영합니다.<br><br>
					<a href="intrMainInqy1040.do?menuType=${menuType}&empIdx=${empVO.empIdx}"><strong>${empVO.empNm}님</strong></a>
				</div>
			</div>
		</div>
			
		<div class="menu_wrap">
			<div class="logo">
				<img class="logo" src="${pageContext.request.contextPath }/resources/images/icon/icon_logo.png" style="cursor: pointer;" onclick="location.href='${menuType eq '0' ? 'intrMainInqy1020.do' : 'intrMainInqy1030.do'}'">
			</div>
			
			<nav class="nav">
				<ul class="ul_1">
					<c:forEach var="list" items="${menuList}" varStatus="status">
						<c:if test="${list.lv eq 1}">
							<li class="li_1">
								<a class="a_1" href="${list.mappingId}?menuSet=${list.menuCd}&pageUrl=${list.mappingId}&empIdx=${empVO.empIdx}">${list.menuNm}</a>
							</li>
						</c:if>
					</c:forEach>
				</ul>
			</nav>
		</div>
	</div>
</header>