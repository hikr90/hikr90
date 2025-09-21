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
			eventLimit: true,						// 이벤트 내용 초과 시, MORE로 표현
			displayEventTime: false, 			// 이벤트 시간 여부
			navLinks: false, 						// 날짜 선택할 경우 상세 데이터 조회 
			selectable: false,						// 네모 선택 여부
			headerToolbar: {
				start: 'prev,next today',
				center: 'title',
			    end: 'dayGridMonth,listMonth'
			},
			// 네모 선택 시
			dateClick: function(info) {
				//
			},
			// 휴가 선택 시
			eventClick: function(info) {
				var obj = new Object();
				//
				obj["mappingId"] = "intrPopupInqy1081.do";
				obj["areaType"] = "sche";
				obj["sequenceId"] = info.event.id;
				obj["width"] = "700"
				obj["height"] = "460";
				//		
				ajaxPopup(obj);
			},
			// 데이터
			events : defaultList,
			eventColor: '#214b97'
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

	<!-- 일정 팝업 -->
 	<div id="scheArea" class="popupArea hidden">
		<c:import url="/WEB-INF/views/intr/comm/popup/intr_popup_inqy_1080.jsp"></c:import>	
	</div>

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
									<h2>일정 관리</h2>
									
									<div class="srch_wrap">
										<div class="right_srch_area">
											<!-- 휴가 타입 -->
											<div class="srch_area">
												<label class="srch_label">휴가 타입</label>
												<div class="select_wrap">
													<div id="leavList" class="sList select_box">${empty param.leavtypeNm ? '전체' : param.leavtypeNm}</div>
													<input type="hidden" name="leavtypeNm" value="${param.leavtypeNm}">
													<input type="hidden" name="leavtypeCd" value="${param.leavtypeCd}">
												
													<ul class="sUl select_ul scroll_wrap">
														<c:forEach var="list" items="${leavList}">
															<li setNm="${list.commcodeNm}" setCd="${list.commcodeCd}">${list.commcodeNm}</li>
														</c:forEach>
													</ul>
												</div>
											</div>
											
											<!-- 부서 -->
											<div class="srch_area">
												<label class="srch_label">부서</label>
												<input type="text" id="orgNm" name="orgNm" class="srch_cdt_text" value="${param.orgNm}" onkeydown="pushCall(this.form);">
											</div>

											<!-- 직급 -->
											<div class="srch_area">
												<label class="srch_label">직급</label>
												<input type="text" id="rankNm" name="rankNm" class="srch_cdt_text" value="${param.rankNm}" onkeydown="pushCall(this.form);">
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
											<div id="calendar">
												
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
