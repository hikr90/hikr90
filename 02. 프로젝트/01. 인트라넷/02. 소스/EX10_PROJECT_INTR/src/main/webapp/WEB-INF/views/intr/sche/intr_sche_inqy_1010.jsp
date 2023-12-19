<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1010.jsp" %>

<link href='${pageContext.request.contextPath}/resources/fullcalendar-5.10.2/lib/main.css' rel='stylesheet' />
<script src='${pageContext.request.contextPath}/resources/fullcalendar-5.10.2/lib/main.js'></script>
<script>
	var defaultList = JSON.parse('${defaultList}');
	//
	document.addEventListener('DOMContentLoaded', function() {
		//
		var scheContent = document.getElementById('calendar');
	    var scheCont = new FullCalendar.Calendar(scheContent, {
	    	//
	        locale: 'en',  					// 언어
			eventLimit: true,				// 이벤트 내용 초과 시, MORE로 표현
			displayEventTime: false, 		// 이벤트 시간 여부
			navLinks: true, 				// 날짜 선택할 경우 상세 데이터 조회 
			selectable: false,				// 네모 선택 여부
			headerToolbar: {
				start: 'prev,next today',
				center: 'title',
			    end: 'dayGridMonth,listMonth'
			},
			// 네모 선택 이벤트
	        select: function(arg) {
				//
			},
			// 일정 선택 이벤트
			eventClick: function(arg) {
				//
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
	<!-- MENU -->
	<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1030.jsp" %>

	<form id="form" name="form" method="POST">
	<article id="_subArticle">
		<div class="_wrap">
			<div id="_content">
				<div id="sub_content" class="_inner">					
					<div class="_contentArea _formArea">
						<!-- Form srchWrap  -->
						<div class="listWrap">
						</div><!-- End listWrap -->
						<!-- Form postWrap  -->
						<div class="postWrap" style="height: auto;">
							<div class="tagWrap">
								<h2>일정 관리</h2>
							</div>
							<div class="f-srchWrap">
								<div class="search_nav">
									<div class="srchArea">
										<label class="srcLabel">부서</label>
										
										<select id="deptCd" name="srchDeptCd" style="width: 200px;">
											<option value="" <c:if test="${empty srchMap.deptCd}">selected</c:if>>전체</option>

										<c:forEach var="list" items="${deptList}" varStatus="status">
											<option value="${list.deptCd}" <c:if test="${srchMap.deptCd eq list.deptCd}">selected</c:if>>${list.deptNm}</option>
										</c:forEach>
										</select>
									</div>
									
									<div class="srchLeftArea">
									<div class="srchArea">
										<label class="srcLabel">사원명</label>
										<input type="text" id="srchNm" name="srchNm" class="srch-cdt-text" value="${resultMap.srchNm}" onkeydown="inputEnt(this.form);">
									</div>
									<div class="srchArea cdtArea noLabel">                                
                                   		<input type="button" class="stb-box-btn" value="조회" onclick="listCall(this.form);">
                                	</div>
                                	</div>
                                </div>
							</div>
							
							<div class="scheWrap">
								<div class="scheArea">
									<div id="calendar" class="scheContent" style="width: 1400px; min-height: 500px;">
										
									</div>
								</div><!-- End postWriteWrap -->
							</div>
						</div><!-- End postWrap -->
					</div><!-- End _contentArea _formArea -->
				</div><!-- End _inner -->
			</div><!-- End _content -->
		</div><!-- End _wrap -->
	</article>
	</form>
</body>

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1020.jsp" %>
