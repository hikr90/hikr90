<!--명칭 : intr_main_inqy_1010
	작성자 : 김태현
	작성일자 : 2022.12.01
	내용 : 사용자 메인 화면-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1010.jsp" %>

<!DOCTYPE html>
<html>
<head></head>
<body id="main">
<form id="form" name="form" method="POST" onsubmit="return false;">
	<!-- MENU -->
	<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1030.jsp" %>

	<!-- MAIN TOP -->
	<article id="_mainArticle">
		<div id="_content" style="margin-top: 50px;">
			<div class="widgetBox">
				<div class="_wrap">
					<div class="mainTopWrap">
						<div class="mainTopArea">
							<h3>공지사항</h3>
							<a href="" class="moreBtn">전체보기</a>
							
							<ul style="line-height: 25px;">
							<c:forEach var="list" items="${brdList}" begin="0" end="4">
									<li>
										<a href="javascript:formSubmit('intrBoardInqy1030.do')">
										<input type="hidden" id="brdIdx" name="brdIdx" value="${list.brdIdx}">
											${list.brdTitle}
											<c:if test="${list.fileYn gt 'Y'}">
												<img id="updImg" src='resources/images/icon/icon_file.png' style="width: 15px; padding-left: 3px;"/>
											</c:if>
											<fmt:parseDate value="${list.regDt}" var="formatDt" pattern="yyyyMMdd"/>
											<span class="date"><fmt:formatDate value="${formatDt}"  pattern="yyyy-MM-dd"/></span>
										</a>
									</li>
							</c:forEach>
							</ul>
						</div>
					</div>
				</div><!-- End _wrap -->
			</div><!-- End widgetBox -->
		</div><!-- End _content -->
	</article>

	<!-- MAIN BOTTOM -->
    <div class="mainBotWrap">
    	<div class="mainBotArea">
    		
        </div>
    </div>
	
	<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1020.jsp" %>

</form>	
</body>
</html>
    