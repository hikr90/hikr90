<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" 	uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="spring" 	uri="http://www.springframework.org/tags" %>

<!-- 
	view : intr_popup_inqy_1091
	title : 회의 상세 팝업
-->
<div class="post_view" style="margin: 0; margin-top:20px;">
	<dl>
		<dt>회의 제목</dt>
		<dd>${defaultInfo.mtgTitle}</dd>
		<dt>등록자</dt>
		<dd>${defaultInfo.orgNm} ${defaultInfo.empNm} ${defaultInfo.rankNm}</dd>
	</dl>
	<dl class="post_info">
		<dt>회의 일자</dt>
		<dd>
			<span class="date">
				<fmt:parseDate value="${defaultInfo.mtgDt}" var="parseDt" pattern="yyyyMMdd"/>
				<fmt:formatDate value="${parseDt}" var="formatDt" pattern="yyyy-MM-dd"/>
				${formatDt}
			</span>
		</dd>

		<dt>회의 시간</dt>
		<dd>
			<span class="date">
				<fmt:parseDate value="${defaultInfo.mtgStm}" var="parseStm" pattern="HHmm"/>
				<fmt:formatDate value="${parseStm}" var="formatStm" pattern="HH:mm"/>
				
				<fmt:parseDate value="${defaultInfo.mtgEtm}" var="parseEtm" pattern="HHmm"/>
				<fmt:formatDate value="${parseEtm}" var="formatEtm" pattern="HH:mm"/>
				${formatStm} ~ ${formatEtm}
			</span>
		</dd>
	</dl>
	<dl>
		<dt>회의 장소</dt>
		<dd>${defaultInfo.mtgLoc}</dd>
		<dt>참여 인원</dt>
		<dd>${defaultInfo.mtgMbr}</dd>
	</dl>
	<dl>
		<dt>회의 내용</dt>
		<dd class="post_text" style="height: 140px;">
			<pre>${defaultInfo.mtgCont}</pre>
		</dd>
	</dl>
	
	<dl class="post_file">
		<dt>회의자료</dt>
		<dd class="post_file">
			<div class="file_wrap">
				<ul id="fileUl"> 
				<c:forEach var="list" items="${fileList}" varStatus="status">
					<li class="${status.index != 0 ? 'nbsp' : ''}">
						<img src='resources/images/icon/icon_file.png' width="15" height="15"/>
						<a href="#" onclick="fileProc('${list.fileId}', '${list.fileSno}');">${list.fileNm}</a>
						<input type="hidden" id="fileId" name="fileId" value="${list.fileId}">
					</li>
				</c:forEach>
				</ul>
			</div>
		</dd>
	</dl>
</div><!-- End post_view -->
