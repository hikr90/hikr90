<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1010.jsp" %>

<link href='${pageContext.request.contextPath}/resources/fullcalendar-5.10.2/lib/main.css' rel='stylesheet' />
<script src='${pageContext.request.contextPath}/resources/fullcalendar-5.10.2/lib/main.js'></script>
<script>
	var defaultList = JSON.parse('${defaultList}');
	//
	document.addEventListener('DOMContentLoaded', function() {
		//
		var calendar = document.getElementById('calendar');
	    var scheCont = new FullCalendar.Calendar(calendar, {
	    	//
	        locale: 'en',  							// 언어
			eventLimit: true,					// 이벤트 내용 초과 시, MORE로 표현
			displayEventTime: false, 	// 이벤트 시간 여부
			navLinks: true, 					// 날짜 선택할 경우 상세 데이터 조회 
			selectable: false,				// 네모 선택 여부
			headerToolbar: {
				start: 'prev,next today',
				center: 'title',
			    end: 'dayGridMonth,listMonth'
			},
			// 네모 선택 이벤트
	        select: function(info) {
				//
			},
			// 기안문 정보 팝업
			eventClick: function(info) {
				//
				var pw = "650";
				var ph = "860";
				var left = Math.ceil((window.screen.width - pw)/2);
				var top = Math.ceil((window.screen.height - ph)/2) - 50;

				// info.event.id
				var options = 'toolbar=no, scrollbars=no, resizeable=yes, status=no, menubar=no, width=' + pw + ', height=' + ph + ', top=' + top + ', left=' + left;
				window.open("intrScheInqy1020.do?contId="+info.event.id, "_blank", options);
			},
			// 데이터
			events : defaultList
		});
	    
	    //
	    scheCont.render();
	});
	
	// 검색 조회
	function listCall(f){
		formSubmit("intrScheInqy1010.do");
	}
</script>
<body id="main">
<form id="form" name="form" method="POST">
	<!-- 메뉴 -->
	<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1030.jsp" %>

	<div class="main_wrap">
		<!-- 좌측 메뉴 -->
		<div class="left_wrap">
			<div class="left_area">
				<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1050.jsp" %>
			</div>
		</div>
	
		<div class="content_wrap">
			<div class="content_area">
				<article class="sub_article">
					<div class="content">
						<div class="sub_content">					
							<div class="form_area">
								<div class="post_wrap">
									<h2>일정 관리</h2><br>
									
									<div class="srch_wrap">
										<div class="right_srch_area">
											<!-- 작성일자 -->
											<div class="srch_area">
												<label class="srch_label">작성일자</label>
												<input type="text" class="srch_cdt_date srchSdt" id="srchSdt" name="srchSdt" value="${param.srchSdt}" readonly="readonly" />
												~
												<input type="text" class="srch_cdt_date srchEdt" id="srchEdt" name="srchEdt" value="${param.srchEdt}" readonly="readonly"/>
											</div>
											
											<!-- 부서 -->
											<div class="srch_area">
												<label class="srch_label">부서</label>
												<div class="select_wrap">
													<div id="deptList" class="sList select_box">${empty param.deptNm ? '전체' : param.deptNm}</div>
													<input type="hidden" name="deptCd" value="${param.deptCd}">
													<input type="hidden" name="deptNm" value="${param.deptNm}">
												
													<ul class="sUl select_ul">
														<c:forEach var="list" items="${deptList}">
															<li setNm="${list.deptNm}" setCd="${list.deptCd}">${list.deptNm}</li>
														</c:forEach>
													</ul>
												</div>
											</div>
											
											<!-- 직급 -->
											<div class="srch_area">
												<label class="srch_label">직급</label>
												<div class="select_wrap">
													<div id="gradeList" class="sList select_box">${empty param.gradeNm ? '전체' : param.gradeNm}</div>
													<input type="hidden" name="gradeCd" value="${param.gradeCd}">
													<input type="hidden" name="gradeNm" value="${param.gradeNm}">
												
													<ul class="sUl select_ul">
														<c:forEach var="list" items="${gradeList}">
															<li setNm="${list.gradeNm}" setCd="${list.gradeCd}">${list.gradeNm}</li>
														</c:forEach>
													</ul>
												</div>
											</div>
											
											<!-- 사원명 -->
											<div class="float_right">
												<div class="srch_area">
													<label class="srch_label">사원명</label>
													<input type="text" id="srchNm" name="srchNm" class="srch_cdt_text" value="${resultMap.srchNm}" onkeydown="inputEnt(this.form);">
													
													<input type="button"class="btn_blue" value="조회" onclick="listCall(this.form);">
													<input type="button"class="btn_gray" value="초기화" onclick="initCall();">
												</div>											
		                                	</div>
		                                </div>
									</div>
								
									<div class="sche_wrap">
										<div class="sche_area">
											<div id="calendar" class="sche_content">
												
											</div>
										</div><!-- End post_write -->
									</div><!-- End sche_wrap -->
								</div><!-- End post_wrap -->
							</div><!-- End form_area -->
						</div><!-- End sub_content -->
					</div><!-- End content -->
				</article>
			</div>
		</div>
	</div>
</form>
</body>

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1020.jsp" %>
