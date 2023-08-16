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
			<input type="hidden" id="contentIdx" name="contentIdx" value="">
		
			<div class="widgetBox">
				<div class="_wrap">
					<div class="mainTopWrap">
						<div class="mainTopArea">
							<h3>공지사항</h3>
								<a href="javascript:formSubmit('intrBoardInqy2010.do')" class="moreBtn">전체보기</a>
								<ul style="line-height: 25px;">
									<c:forEach var="list" items="${defaultList}" begin="0" end="4">
										<li>
											<a href="javascript:setContentIdx('${list.brdIdx}','intrBoardInqy1030.do')">
												${list.brdTitle}
												<c:if test="${list.fileYn gt 'Y'}">
													<img id="updImg" src='resources/images/icon/icon_file.png' style="width: 15px; padding-left: 3px;"/>
												</c:if>
												<fmt:parseDate value="${list.regDt}" var="formatDt" pattern="yyyyMMdd"/>
												<span class="date"><fmt:formatDate value="${formatDt}"  pattern="yyyy-MM-dd"/></span>
											</a>
										</li>
									</c:forEach>
									<c:if test="${empty defaultList}">
										등록된 공지사항이 없습니다.
									</c:if>
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
	    	<article class="_subArticle" style="margin: 0 auto auto 52%;">
		    	<h2>나의 기안</h2><br>
					<a href="javascript:formSubmit('intrAprvInqy1010.do')" class="moreBtn">전체보기</a>
					<ul style="line-height: 25px;">
						<c:forEach var="list" items="${aprvReqList}" begin="0" end="4">
							<li>
								<a href="javascript:setContentIdx('${list.aprvIdx}','intrAprvInqy1030.do')">
									(${list.currStepNm}) ${list.aprvTitle}
									<fmt:parseDate value="${list.aprvRegDt}" var="formatDt" pattern="yyyyMMdd"/>
									<span class="date"><fmt:formatDate value="${formatDt}"  pattern="yyyy-MM-dd"/></span>
								</a>
							</li>
						</c:forEach>
						<c:if test="${empty aprvReqList}">
							품의한 기안문이 없습니다.
						</c:if>
					</ul>
		    </article>
	    </div>
        
        <div class="mainBotArea" style="width: 25%;">
			<article class="_subArticle">
	    		<h2>나의 결재</h2>
					<a href="javascript:formSubmit('intrAprvInqy2010.do')" class="moreBtn">전체보기</a>
					<ul style="line-height: 25px;">
						<c:forEach var="list" items="${aprvRecList}" begin="0" end="4">
							<li>
								<a href="javascript:setContentIdx('${list.aprvIdx}','intrAprvInqy2020.do')">
									(${list.currStepNm}) ${list.aprvTitle}
									<fmt:parseDate value="${list.aprvRegDt}" var="formatDt" pattern="yyyyMMdd"/>
									<span class="date"><fmt:formatDate value="${formatDt}"  pattern="yyyy-MM-dd"/></span>
								</a>
							</li>
						</c:forEach>
						<c:if test="${empty aprvRecList}">
							결재할 기안문이 없습니다.
						</c:if>
					</ul>
    		</article>
        </div>
	</div>
	
	<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1020.jsp" %>
</form>	
</body>
</html>
    