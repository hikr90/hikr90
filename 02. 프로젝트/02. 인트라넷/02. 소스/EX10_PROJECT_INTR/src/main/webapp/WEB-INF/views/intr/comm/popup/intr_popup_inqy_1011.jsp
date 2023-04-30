<!--명칭 : intr_popup_inqy_1011
	작성자 : 김태현
	작성일자 : 2022.12.01
	내용 : 팝업 템플릿 조회-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" 	uri="http://www.springframework.org/tags" %>

<script>
	$(document).ready(function(){
		// 선택한 값의 라디오 버튼 제거
		$("input[name='radio']").each(function(){
			if($(".list_bg").attr("id")==this.value){
				this.remove();				
			}			
		});
	});
</script>

<div class="scrollTableWrap" style="height: auto;">
	<div class="popTree">
		<div class="tree">
		<c:if test="${fn:length(defaultList)>0}">
			<ul class="ul_1">
			
			<c:forEach var="list" items="${defaultList}" varStatus="status">
				<c:set var="spanIcon"	value="icon_folder"/>
				<c:set var="nextLv"	value=""/>
				<c:set var="prevLv"	value=""/>
												
				<c:if test="${list.isleaf eq 'Y'}">
					<c:set var="spanIcon" 	value="icon_list"/> 
				</c:if>
												
				<c:if test="${ empty list.lv }">
					<c:set var="nextLv"	value="1"/>
				</c:if>
													
				<!-- 태그 열기 -->
				<c:choose>
					<c:when test="${list.lv gt prevLv}">
						<ul class="ul_${list.lv}">
							<li class="li_${list.lv}">
							<span class="${spanIcon}"></span>
							<input type="radio" name="radio" value="${list.templateCd}" templateNm="${list.templateNm}">
							${list.templateNm}
					</c:when>
					<c:when test="${list.lv eq prevLv}">
						<li class="li_${list.lv}">
							<span class="${spanIcon}"></span>
							<input type="radio" name="radio" value="${list.templateCd}" templateNm="${list.templateNm}">
							${list.templateNm}
					</c:when>
				</c:choose>
		
				<!-- 태그 닫기 -->										
				<c:choose>
					<c:when test="${list.lv gt nextLv}">
						</li>
															
						<c:forEach begin="1" end="${list.lv - nextLv}" varStatus="status">
							<c:if test="${list.lv ne '1'}">
									</ul>
								</li>
							</c:if>
						</c:forEach>
															
					</c:when>
					<c:when test="${list.lv eq nextLv}">
						</li>
					</c:when>
				</c:choose>
														
				<c:set var="prevLv" value="${list.lv}" />
			</c:forEach>
			</ul>
		</c:if>
		</div>
	</div>
</div>