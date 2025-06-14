<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1010.jsp" %>

<link href='${pageContext.request.contextPath}/resources/fullcalendar-5.10.2/lib/main.css' rel='stylesheet' />
<script src='${pageContext.request.contextPath}/resources/fullcalendar-5.10.2/lib/main.js'></script>

<!DOCTYPE html>
<html>
<head></head>
<script>
//
var defaultList = JSON.parse('${mtgList}');
document.addEventListener('DOMContentLoaded', function() {
	//
	var calendar = document.getElementById('calendar');
    var scheCont = new FullCalendar.Calendar(calendar, {
    	//
        locale: 'en',  							// 언어
		eventLimit: true,						// 이벤트 내용 초과 시, MORE로 표현
		displayEventTime: false, 			// 이벤트 시간 여부
		navLinks: true, 							// 날짜 선택할 경우 상세 데이터 조회 
		selectable: false,						// 네모 선택 여부
		height: 430,
		headerToolbar: {
			start: 'prev,next today',
			center: 'title',
		    end: 'dayGridMonth'
		},
		// 네모 선택 이벤트
        select: function(info) {
			//
		},
		// 선택 이벤트
		eventClick: function(info) {
			//
			
		},
		// 데이터
		events : defaultList,
		eventColor : '#214b97'
	});
    //
    scheCont.render();
});
</script>
<body id="main">
<form id="form" method="POST" onsubmit="return false;">
	<!-- 메뉴 -->
	<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1030.jsp" %>

	<div class="top_wrap">
		<div class="top_area">
			<article class="main_article">
				<div class="content">
					<input type="hidden" id="brdId" name="brdId" value="">
					<input type="hidden" id="aprvId" name="aprvId" value="">
				
					<div class="top_box">
						<div class="wrap">
							<div class="top_wrap">
								<div class="top_area float_left">
									<!-- full calendar -->
									<div id="calendar">
												
									</div>
								</div>
								
								<div class="top_area">
									<div class="area_title">
										<h3>회의 관리</h3>
									</div>
									
									<div class="area_content">
										<ul class="scroll_wrap">
											<c:forEach var="list" items="${mtgList}">
												<li class="main_li">
													<a class="main_a">[${list.leavtypeCd}] ${list.aprvTitle}</a>
													<span class="date main_span">
														<fmt:parseDate value="${list.leavjSdt}" var="parseSdt" pattern="yyyyMMdd"/>
														<fmt:formatDate value="${parseSdt}" var="formatSdt" pattern="yyyy-MM-dd"/>
														${formatSdt}
														~
														<fmt:parseDate value="${list.leavEdt}" var="parseEdt" pattern="yyyyMMdd"/>
														<fmt:formatDate value="${parseEdt}" var="formatEdt" pattern="yyyy-MM-dd"/>
														${formatEdt}
													</span>
												</li>
											</c:forEach>
											
											<c:if test="${empty leavList}">
												<li class="main_li">
													등록된 글이 없습니다.
												</li>												
											</c:if>
										</ul>
									</div>
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
							    	<div class="area_title">
							    		<h3>공지사항</h3><br>
									</div>
									
									<div class="area_content">
										<ul class="area_ul">
											<c:forEach var="list" items="${boardList}" begin="0" end="2">
												<li class="main_li">
													<a class="main_a">${list.brdTitle}</a>
													<span class="date main_ie">
														<fmt:parseDate value="${list.regDt}" var="parseDt" pattern="yyyyMMdd"/>
														<fmt:formatDate value="${parseDt}" var="formatDt" pattern="yyyy-MM-dd"/>
														${formatDt} 
													</span>
												</li>
											</c:forEach>
											
											<c:if test="${empty boardList}">
												<li class="main_li">
													등록된 글이 없습니다.
												</li>												
											</c:if>
										</ul>
									</div>
								</div>
								
								<div class="bottom_area">
						    		<div class="area_title">
							    		<h3>결재 조회</h3><br>
									</div>

									<div class="area_content">
										<ul class="area_ul">
											<c:forEach var="list" items="${aprvList}" begin="0" end="2">
												<li class="main_li">
													<a class="main_a" href="intrAprvInqy2020.do?sequenceId=${list.aprvId}&temptypeCd=${list.temptypeCd}&returnUrl=${list.returnUrl}">${list.aprvTitle}</a>
													<span class="date main_ie">
														<fmt:parseDate value="${list.regDt}" var="parseDt" pattern="yyyyMMdd"/>
														<fmt:formatDate value="${parseDt}" var="formatDt" pattern="yyyy-MM-dd"/>
														${formatDt} 
													</span>
												</li>
											</c:forEach>
											
											<c:if test="${empty aprvList}">
												<li class="main_li">
													등록된 글이 없습니다.
												</li>												
											</c:if>
										</ul>
									</div>
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
    