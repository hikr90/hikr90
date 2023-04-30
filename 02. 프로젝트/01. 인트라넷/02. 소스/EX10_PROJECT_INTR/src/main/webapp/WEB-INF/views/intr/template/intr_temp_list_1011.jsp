<!--명칭 : intr_temp_list_1011
	작성자 : 김태현
	작성일자 : 2023.01.01
	내용 : 템플릿 트리 목록-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 	uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>

<c:if test="${fn:length(defaultList)>0}">
	<ul class="ul_1">

	<c:forEach var="list" items="${defaultList}" varStatus="status">
		<c:set var="spanIcon" value="icon_folder" />
		<c:set var="nextLv" value="" />
		<c:set var="prevLv" value="" />

		<c:if test="${list.isleaf eq 'Y'}">
			<c:set var="spanIcon" value="icon_list" />
		</c:if>

		<c:if test="${ empty list.lv }">
			<c:set var="nextLv" value="1" />
		</c:if>

		<!-- 태그 열기 -->
		<c:choose>
			<c:when test="${list.lv eq '1'}">
				<li class="li_${list.lv}"><span class="${spanIcon}"></span> 
				<a class="a_btn" href="#" onclick="detCall('${list.templateCd}');">${list.templateNm}</a>
			</c:when>
			<c:when test="${list.lv gt prevLv}">
				<ul class="ul_${list.lv}">
					<li class="li_${list.lv}"><span class="${spanIcon}"></span>
					<a class="a_btn" href="#" onclick="detCall('${list.templateCd}');">${list.templateNm}</a>
			</c:when>
			<c:when test="${list.lv eq prevLv}">
				<li class="li_${list.lv}"><span class="${spanIcon}"></span>
				<a class="a_btn" href="#" onclick="detCall('${list.templateCd}');">${list.templateNm}</a>
			</c:when>
		</c:choose>

		<!-- 태그 닫기 -->
		<c:choose>
			<c:when test="${list.lv gt nextLv}">
				</li>

				<!-- 다음 레벨과 차이 만큼 반복문으로 태그 닫기 -->
				<c:forEach begin="1" end="${list.lv - nextLv}" varStatus="status">
					</ul>
						</li>
				</c:forEach>
			</c:when>
			<c:when test="${list.lv eq nextLv}">
				</li>
			</c:when>
		</c:choose>

		<!-- 직전 레벨 저장 -->
		<c:set var="prevLv" value="${list.lv}" />
	</c:forEach>

	</ul>
</c:if>