<!--명칭 : intr_include_1030
	작성자 : 김태현
	작성일자 : 2022.12.01
	내용 : 메인 헤더-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<header style="min-height: 100px;">
	<div class="_wrap">
		<div class="utilWrap">
			<div class="login_state">
				<ul class="utilList">

				<!-- 메인 메뉴 출력-->
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
				</ul>
				<br><br>
				<div class="login_state_text">
					접속을 환영합니다.<br><br>
					<strong>${empVO.empNm}님</strong>
				</div>
			</div>
		</div>
			
		<div id="gnbWrap">
			<div class="logo">
				<img id="_logo" src="${pageContext.request.contextPath }/resources/images/icon/icon_logo.png">
			</div>
			
			<nav id="_nav">
				<ul class="ul_1">
					<c:forEach var="uMenu" items="${menuList}" varStatus="status">
					<c:if test="${uMenu.lv eq 1}">
						<li class="li_1">
						<a class="a_1" href="${uMenu.mappingId eq null ? '#':uMenu.mappingId}">${uMenu.menuNm}</a>
							<ul class="ul_2">
								<c:forEach var="lMenu" items="${menuList}" varStatus="status">
								<c:if test="${uMenu.menuCd eq lMenu.upprMenuCd}">
									<li class="li_2" style="display: inline-block;">
										<a class="a_2" href="${lMenu.mappingId}">${lMenu.menuNm}</a>
									</li>
								</c:if>
								</c:forEach>
							</ul>
						</li>
					</c:if>
					</c:forEach>
				</ul>
			</nav>
		</div>
	</div>
</header>