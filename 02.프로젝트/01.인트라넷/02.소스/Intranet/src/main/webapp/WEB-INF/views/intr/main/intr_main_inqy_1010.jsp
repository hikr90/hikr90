<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1010.jsp" %>

<!DOCTYPE html>
<html>
<head></head>
<body id="main">
<form id="form" name="form" method="POST" onsubmit="return false;">
	<!-- 메뉴 -->
	<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1030.jsp" %>

	<div class="top_wrap">
		<div class="top_area">
			<article class="main_article">
				<div class="content">
					<input type="hidden" id="contId" name="contId" value="">
				
					<div class="top_box">
						<div class="wrap">
							<div class="top_wrap">
								<div class="top_area">
									<h3>공지사항</h3><br>
									<a href="javascript:formSubmit('intrBoardInqy2010.do')" class="btn_more">전체보기</a>
									<ul>
										<c:forEach var="list" items="${defaultList}" begin="0" end="4">
											<li>
												<a href="javascript:setContentIdx('${list.contId}','intrBoardInqy2020.do')">
													${list.brdTitle}
													<c:if test="${list.fileYn eq 'Y'}">
														<img id="updImg" src='resources/images/icon/icon_file.png' width="15" height="15" />
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
						</div><!-- End wrap -->
					</div><!-- End widget_box -->
				</div><!-- End content -->
			</article>
		</div>
	</div>
	
	<div class="bottom_wrap">
		<div class="bottom_area">
			<article class="main_article">
				<div class="content">
				
					<div class="bottom_box">
						<div class="wrap">
							<div class="bottom_wrap">
								<div class="bottom_area">
							    	<h3>나의 기안</h3><br>
									<a href="javascript:formSubmit('intrAprvInqy1010.do')" class="btn_more">전체보기</a>
									<ul>
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
								</div>
								
								<div class="bottom_area">
						    		<h3>나의 결재</h3><br>
									<a href="javascript:formSubmit('intrAprvInqy2010.do')" class="btn_more">전체보기</a>
									<ul>
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
								</div>
							</div>
						</div>
					</div>
				</div><!-- End content -->
			</article>
		</div>
	</div>
	
	<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1020.jsp" %>
</form>	
</body>
</html>
    