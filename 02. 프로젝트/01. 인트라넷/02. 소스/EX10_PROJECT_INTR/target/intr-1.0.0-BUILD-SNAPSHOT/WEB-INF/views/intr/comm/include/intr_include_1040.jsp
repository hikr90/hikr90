<!--명칭 : intr_include_1040
	작성자 : 김태현
	작성일자 : 2022.12.01
	내용 : 파일 영역-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<ul id="updUl">
	<c:if test="${not empty defaultList and defaultList ne ''}">
		<c:forEach var="list" items="${defaultList}" varStatus="status">
			<li id="updLi${status.index}">
				<input type='checkbox' class='_chkBox' name='checkIdx' value="${status.index}">
				<input type="hidden" class="fileIdx" value="${list.fileIdx}">
				<img src="resources/images/icon/icon_file.png">
				<a>${list.fileOrglNm}</a>
			</li>
		</c:forEach>
	</c:if>	
</ul>    