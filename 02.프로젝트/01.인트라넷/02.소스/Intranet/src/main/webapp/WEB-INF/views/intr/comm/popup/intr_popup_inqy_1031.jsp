<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" 	uri="http://www.springframework.org/tags" %>

<!-- 
	view : intr_popup_inqy_1031
	title : 프로젝트 트리 팝업
-->
<div class="scroll_wrap">
	<div class="pop_tree">
		<div class="tree">
			<c:forEach var="list" items="${projList}" varStatus="status">
				<c:set var="spanIcon"	value="icon_folder"/>
				
				<li class="li_">
					<input type="radio" id="projPcd" class="projPcd" name="projPcd" value="${list.projCd}" projPnm="${list.projTitle}" projPcd="${list.projCd}" >
					<span class="${spanIcon}"></span>
					${list.projTitle}
				</li>
			</c:forEach>
			</ul>
		</div>	
	</div>
</div>