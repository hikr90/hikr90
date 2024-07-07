<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="top_box">
	<div class="top_header">
		<ul>
		<c:choose>
			<c:when test="${ empty memberVO }">
				<li><a href="piptLoginInqy1010.do"  target=_parent>로그인</a></li>
				<li><a href="piptLoginInqy1020.do"  target=_parent>회원가입</a></li>
				<li><a href="piptServiceInqy1010.do"  target=_parent>고객센터</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="piptMypageInqy1010.do" target=_parent>마이페이지</a></li>
				<li><a href="piptFaveInqy1010.do" target=_parent></a>즐겨찾기</li>
				<li><a href="javascript:logout();" target=_parent>로그아웃</a><li>
				
				<c:if test="${memberVO.adminYn eq 'Y'}">
					<li><a href="#"  target=_parent>관리자</a></li>
				</c:if>
			</c:otherwise>
		</c:choose>
		</ul>
	</div>

	<div class="top_menu">
		<div class="top_logo">
			<img class="logo" src="${pageContext.request.contextPath }/resources/image/logo/landscape.png"  onclick="location.href='piptMainInqy1010.do'">

			<nav>
				<ul>
					<li><a href="piptAboutInqy1010.do">Pit a Pat</a></li>
					<li><a href="piptAboutInqy2010.do">오시는 길</a></li>
					<li><a href="piptProdInqy1010.do">상품 소개</a></li>
					<li><a href="piptProdInqy2010.do">가격 정보</a></li>
				</ul>
		</nav>
		</div>
	</div>
</div>