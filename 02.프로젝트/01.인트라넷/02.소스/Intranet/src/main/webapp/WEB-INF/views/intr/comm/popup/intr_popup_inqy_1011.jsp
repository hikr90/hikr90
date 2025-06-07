<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" 	uri="http://www.springframework.org/tags" %>

<!-- 
	view : intr_popup_inqy_1011
	title : 사원 트리 팝업
-->
<div class="scroll_wrap" style="height: 260px;">
	<div class="pop_tree">
		<div class="tree">
			<c:forEach var="list" items="${empList}" varStatus="status">
				<c:set var="spanIcon"	value="icon_folder"/>
				<c:set var="listNm"		value="${list.orgNm}"/>
				<c:set var="nextLv"		value="${empList[status.index+1].lv}"/>
				<c:set var="prevLv"		value=""/>
				
				<c:if test="${list.isleaf eq 'Y'}">
				   	<c:set var="spanIcon" 	value="icon_list"/> 
				   	<c:set var="listNm" 	value="${list.empNm}"/> 
				</c:if>
			
				<c:if test="${empty list.lv}">
	      			<c:set var="nextLv"	value="1"/>
	       		</c:if>
	
				<c:if test="${list.isleaf eq 'N'}">
					<ul>
				</c:if>
				
				<!-- 태그 열기 -->
				<c:choose>
					<c:when test="${list.lv gt prevLv}">
						<li class="li_${list.lv}">
							<c:if test="${list.isleaf eq 'Y'}">
								&nbsp; 
								ㄴ <input type="radio" id="empPcd" class="${list.isleaf eq 'N' ? 'orgCd' : 'empIdx'}" name="empPcd" value="${list.empIdx}" empPnm="${list.empNm}" empPcd="${list.empIdx}" >
							</c:if>
							<span class="${spanIcon}"></span>
							${listNm}
					</c:when>
					<c:when test="${list.lv eq prevLv}">
						<li class="li_${list.lv}">
							<c:if test="${list.isleaf eq 'Y'}">
								&nbsp;
								ㄴ <input type="radio" id="empPcd" class="${list.isleaf eq 'N' ? 'orgCd' : 'empIdx'}" name="empPcd" value="${list.empIdx}" empPnm="${list.empNm}" empPcd="${list.empIdx}">
							</c:if>
							<span class="${spanIcon}"></span>
							${listNm}
					</c:when>
				</c:choose>
	
				<!-- 태그 닫기 -->										
				<c:choose>
					<c:when test="${list.lv gt nextLv}">
						</li>
							</ul>
						
						<c:forEach begin="1" end="${list.lv - prevLv}" varStatus="status">
							<c:if test="${list.lv ne '1'}">
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
		</div>	
	</div>
</div>