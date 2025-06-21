<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<ul class="area_ul scroll_wrap" style="height: 360px;">
	<c:forEach var="list" items="${calInfo}">
		<li class="main_li" style="border-bottom: solid 2px #f6f6f6; margin-right: 20px;">
			<a href="javascript:mtgCall('${list.mtgCd}');" class="main_a" style="font-weight: bold;">
				<fmt:parseDate value="${list.mtgStm}" var="parseStm" pattern="HHmm"/>
				<fmt:formatDate value="${parseStm}" var="formatStm" pattern="HH:mm"/>
				
				<fmt:parseDate value="${list.mtgEtm}" var="parseEtm" pattern="HHmm"/>
				<fmt:formatDate value="${parseEtm}" var="formatEtm" pattern="HH:mm"/>
				[${formatStm} ~ ${formatEtm}] ${list.mtgTitle}
			</a><br>
			<span class="ellipsis">${list.mtgCont}</span>
			<span class="main_ie">
				${list.orgNm} ${list.empNm}
			</span>
			
		</li>
	</c:forEach>
	
	<c:if test="${empty calInfo}">
		<li class="main_li">
			등록된 회의가 없습니다.
		</li>												
	</c:if>
</ul>
