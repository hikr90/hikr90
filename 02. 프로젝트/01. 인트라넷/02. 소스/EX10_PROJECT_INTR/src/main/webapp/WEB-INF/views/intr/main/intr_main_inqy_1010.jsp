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
<script type="text/javascript">
	//
	
</script>
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
							<a href="javascript:formSubmit('intrBoardInqy2010.do')" class="moreBtn">전체보기</a>
							<c:if test="${defaultList ne null and defaultList ne ''}">
								<ul style="line-height: 25px;">
									<c:forEach var="list" items="${defaultList}" begin="0" end="4">
										<li>
											<a href="javascript:formSubmit('intrBoardInqy1030.do')">
											<input type="hidden" id="contentIdx" name="contentIdx" value="${list.brdIdx}">
												${list.brdTitle}
												<c:if test="${list.fileYn gt 'Y'}">
													<img id="updImg" src='resources/images/icon/icon_file.png' style="width: 15px; padding-left: 3px;"/>
												</c:if>
												<fmt:parseDate value="${list.regDt}" var="formatDt" pattern="yyyyMMdd"/>
												<span class="date"><fmt:formatDate value="${formatDt}"  pattern="yyyy-MM-dd"/></span>
											</a>
										</li>
									</c:forEach>
									<c:if test="${defaultList eq null or defaultList eq ''}">
										등록된 공지사항이 없습니다.
									</c:if>
								</ul>
							</c:if>
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
		    	<h2>기안 목록</h2><br>
				<c:if test="${aprvReqList ne null and aprvReqList ne ''}">
					<ul style="line-height: 25px;">
						<c:forEach var="list" items="${aprvReqList}" begin="0" end="4">
							<li>
								<a href="javascript:formSubmit('intrAprvInqy1030.do')">
								<input type="hidden" id="contentIdx" name="contentIdx" value="${list.aprvIdx}">
									${list.aprvTitle}
									<fmt:parseDate value="${list.aprvRegDt}" var="formatDt" pattern="yyyyMMdd"/>
									<span class="date"><fmt:formatDate value="${formatDt}"  pattern="yyyy-MM-dd"/></span>
								</a>
							</li>
						</c:forEach>
						<c:if test="${aprvReqList eq null and aprvReqList eq ''}">
							품의한 기안문이 없습니다.
						</c:if>
					</ul>
				</c:if>
		    </article>
	    </div>
        
        <div class="mainBotArea" style="width: 25%;">
			<article class="_subArticle">
	    		<h2>나의 결재</h2>
    	
    		</article>
        </div>
	</div>
	
	<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1020.jsp" %>
</form>	
</body>
</html>
    