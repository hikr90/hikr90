<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<ul id="updUl">
	<c:forEach var="list" items="${defaultList}" varStatus="status">
		<li id="updLi${status.index}" class="${status.index != 0 ? 'nbsp' : ''}">
			<input type="hidden" class="fileIdx" value="${list.fileIdx}">
			<img src="resources/images/icon/icon_file.png" width="15" height="15" >
			<a>${list.fileOrglNm}</a>
		</li>
	</c:forEach>
</ul>    