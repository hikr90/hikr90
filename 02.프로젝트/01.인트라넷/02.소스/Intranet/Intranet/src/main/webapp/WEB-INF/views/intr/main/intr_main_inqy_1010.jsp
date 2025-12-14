<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1010.jsp" %>


<link href='${pageContext.request.contextPath}/resources/fullcalendar-5.10.2/lib/main.css' rel='stylesheet' />
<script src='${pageContext.request.contextPath}/resources/fullcalendar-5.10.2/lib/main.js'></script>

<!DOCTYPE html>
<html>
<head></head>
<script>
	//
	var calList = JSON.parse('${calList}');
	document.addEventListener('DOMContentLoaded', function() {
		//
		var calendar = document.getElementById('calendar');
	    var mtgCont = new FullCalendar.Calendar(calendar, {
	    	//
	        locale: 'en',  							// 언어
			eventLimit: true,						// 이벤트 내용 초과 시, MORE로 표현
			displayEventTime: false, 			// 이벤트 시간 여부
			navLinks: false, 						// 날짜 선택할 경우 상세 데이터 조회 
			selectable: false,						// 네모 선택 여부
			height: 430,
			headerToolbar: {
				start: 'prev,next today',
				center: 'title',
			    end: 'dayGridMonth'
			},
			dateClick: function(info) {
				// 음영 처리
				$('.fc-day').removeClass('set_date');
				$(info.dayEl).addClass('set_date');
				
				// date 포맷
				var dateObj = info.date;
				viewCall(dateObj);
			 },
			 eventClick: function(info) {
				// 음영 처리	 
				$('.fc-day').removeClass('set_date');
				$(info.el).closest('td').addClass('set_date');
				
				// date 포맷
				var dateObj = info.event.start;
				viewCall(dateObj);
				
			 },
			// 데이터
			events : calList,
			eventColor : '#214b97'
		});
	    //
	    mtgCont.render();
	});
	
	// 캘린더 목록 조회
	function viewCall(dateObj){
		try {
			// 변수 지정
			var year = dateObj.getFullYear();
			var month = String(dateObj.getMonth() + 1).padStart(2, '0');  // 월은 0부터 시작
			var date = String(dateObj.getDate()).padStart(2, '0');	// 일은 최소 두자리
			var calDate = year + month + date;
			//
			$.ajax({
					type:	"post" , 
					traditional: true,
					url:	"intrMtgInqy2020.do",
					data:	{
						"mtgDt": calDate
					},
					success : function(data){
	   					$("#calInfo").html(data);
					},
					error : function(res, status, error){
						//
						alert("<spring:message code="PROC.ERROR"/>");
					}
			});
			
		} catch (error) {
	        console.error("[Error] 캘린더 목록 조회 : ", error.message);
		}
	}
	
	// 회의 조회 팝업
	function mtgCall(sequenceId){
		try {
			//
			var obj = new Object();
			
			obj["mappingId"] = "intrPopupInqy1091.do";
			obj["sequenceId"] = sequenceId;
			obj["areaType"] = "mtg";
			obj["width"] = "700";
			obj["height"] = "550";
			//		
			ajaxPopup(obj);
			
		} catch (error) {
	        console.error("[Error] 회의 조회 팝업 : ", error.message);
		}
	}
	
	$(document).ready(function(){
		// 배너 생성
		var banrPop = $('#banrPop');
	    if (banrPop.length > 0) {
	        var banrCd = "${banrInfo.banrCd}";

	        // 쿠키 조회
	        function getCookie(name) {
	            var nameEQ = name + "=";
	            var ca = document.cookie.split(';');
	            for(var i=0; i < ca.length; i++) {
	                var c = ca[i];
	                while (c.charAt(0) == ' ') c = c.substring(1, c.length);
	                if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length, c.length);
	            }
	            return null;
	        }

	        // 쿠키 세팅
	        function setCookie(name, value) {
	            var date = new Date();
	            date.setDate(date.getDate() + 1); // 오늘, 23:59:59까지 유효
	            date.setHours(0); 
	            date.setMinutes(0);
	            date.setSeconds(0);
	            var expires = "; expires=" + date.toUTCString();
	            document.cookie = name + "=" + (value || "")  + expires + "; path=/";
	        }

	        // 오늘 하루 보지 않기 미 체크 시, 배너 표시
	        if (getCookie(banrCd) !== 'done') {
	            banrPop.show(); // 쿠키가 없으면 배너 표시
	        }

	        // 닫기
	        $('#closeBanr').on('click', function() {
	            var noMoreToday = $('#noMoreToday').is(':checked');
	            
	            if (noMoreToday) {
	                // '오늘 하루 보지 않기' 체크 시 쿠키 설정
	                setCookie(banrCd, 'done');
	            }
	            
	            // 팝업 숨김
	            banrPop.hide();
	        });
	    }
	});
</script>

<style>
	.fc-daygrid-event-harness { width:20px; }
</style>

<body id="main">
<form id="form" method="POST" onsubmit="return false;">
	<!-- 메뉴 -->
	<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1030.jsp" %>

	<!-- 회의 팝업 -->
 	<div id="mtgArea" class="popupArea hidden">
		<c:import url="/WEB-INF/views/intr/comm/popup/intr_popup_inqy_1090.jsp"></c:import>	
	</div>

	<!-- 배너 -->
	<c:if test="${not empty banrInfo}">
        <div id="banrPop" class="banr_popup">
            <a href="${banrInfo.banrUrl}" target="_blank">
                <img id="banrImg" class="banr_img" width="${banrInfo.width}" height="${banrInfo.height}" src="intrBanrInqy1099.do?fileNm=${banrInfo.fileNm}&sequenceId=${banrInfo.banrCd}">
            </a>
            
            <div class="banr_close">
                <label for="noMoreToday"><input type="checkbox" id="noMoreToday" class="check_box"><span style="font-size: 1.4rem;">오늘 하루 보지 않기</span></label>&nbsp;
                 <label for="closeBanr"><button id="closeBanr" class="closeBanr"></button><span style="font-size: 1.4rem;">닫기</span></label>
            </div>
        </div>
    </c:if>

	<div class="main_area">
		<div class="top_area">
			<article class="main_article">
				<div class="content">
					<input type="hidden" id="brdId" name="brdId" value="">
					<input type="hidden" id="aprvId" name="aprvId" value="">
				
					<div class="top_box">
						<div class="wrap" style="width: 1630px">
							<div class="top_wrap">
								<div class="top_area">
									<!-- full calendar -->
									<div id="calendar">
												
									</div>
								</div>
								
								<!-- 회의 관리 -->
								<div class="top_area">
									<div class="area_title">
										<h3>
											<img src='resources/images/icon/icon_srch.png' width="20" height="20"/>
											회의 관리
										</h3>
									</div>
									
									<div id="calInfo" class="area_content">
										<ul class="area_ul scroll_wrap" style="height: 360px;">
											<c:forEach var="list" items="${calInfo}">
												<li class="main_li" style="border-bottom: solid 2px #f6f6f6; margin-right: 20px;">
													<a href="javascript:mtgCall('${list.mtgCd}');" class="main_a pl20" style="font-weight: bold;">
														<fmt:parseDate value="${list.mtgStm}" var="parseStm" pattern="HHmm"/>
														<fmt:formatDate value="${parseStm}" var="formatStm" pattern="HH:mm"/>
														
														<fmt:parseDate value="${list.mtgEtm}" var="parseEtm" pattern="HHmm"/>
														<fmt:formatDate value="${parseEtm}" var="formatEtm" pattern="HH:mm"/>
														[${formatStm} ~ ${formatEtm}] ${list.mtgTitle}
													</a><br>
													<span class="ellipsis">${list.mtgCont}</span>
													<span class="main_ie">
														${list.orgNm} ${list.empNm}
													</span>
												</li>
											</c:forEach>
											
											<c:if test="${empty calInfo}">
												<li class="main_li pl20">
													등록된 회의가 없습니다.
												</li>												
											</c:if>
										</ul>
									</div>
								</div>
								<!-- 회의 관리 -->
								
								<!-- 마이페이지 -->
								<div class="top_area">
									<div class="emp_profile">
                                       	<c:choose>
                                       		<c:when test="${empInfo.profileYn eq 'Y'}">
                                 				<img id="empImg" class="emp_img" width="250" height="250" style="border: 3px solid #214b97; border-radius: 100%;" src="intrEmpInqy1099.do?sequenceId=${empVO.empIdx}">
                                       		</c:when>
                                       		<c:otherwise>
	                                        	<img id="empImg" class="emp_img" width="250" height="250" src="resources/images/icon/icon_profile.png">
                                       		</c:otherwise>
                                       	</c:choose>
									</div>
                                    
                                    <div class="profile_area">
	                                    <ul class="main_ul main_font">
	                                   		<li>${empVO.empNm}</li>
	                                    	<li>${empVO.orgNm}</li>
	                                    	<li>${empVO.rankNm}</li>
	                                    </ul>
	                                    
	                                    <ul class="main_ul main_font">
	                                    	<li>
												<fmt:parseDate value="${empVO.hireDt}" var="parseDt" pattern="yyyyMMdd"/>
												<fmt:formatDate value="${parseDt}" var="formatDt" pattern="yyyy-MM-dd"/>
												<span>${formatDt} 입사</span> 
											</li>
	                                    </ul>
	                                    
	                                    	<li><span>${not empty taskInfo ? 'myTask.taskCont' : '등록된 담당업무가 없습니다.'}</span></li>
	                                    <ul class="main_ul main_font">
	                                    </ul>
                                    </div>
								</div>
								<!-- 마이페이지 -->
							</div>
						</div><!-- End wrap -->
					</div><!-- End widget_box -->
				</div><!-- End content -->
			</article>
		</div>
		
		<div class="bottom_area">
			<article class="main_article">
				<div class="content">
					<div class="bottom_box">
						<div class="wrap" style="width: 1630px;">
							<div class="bottom_wrap">
								<!-- 공지사항 -->	
								<div class="bottom_area">
							    	<div class="area_title">
							    		<h3>
							    			<img src='resources/images/icon/icon_fcheck.png' width="20" height="20"/>
							    			공지사항
							    		</h3><a href="intrBoardInqy2010.do?pageUrl=Board" class="main_ie" style="font-size: 1.5rem;">전체보기</a>
									</div>
									
									<div class="area_content">
										<ul class="area_ul">
											<c:forEach var="list" items="${boardList}" begin="0" end="2">
												<li class="main_li">
													<a class="main_a pl20" href="intrBoardInqy2020.do?sequenceId=${list.brdId}&pageUrl=Board">
														<script>document.write(isNew('${list.regDt}'))</script>
														${list.brdTitle}
													</a>
													<span class="date main_ie">
														<fmt:parseDate value="${list.regDt}" var="parseDt" pattern="yyyyMMdd"/>
														<fmt:formatDate value="${parseDt}" var="formatDt" pattern="yyyy-MM-dd"/>
														${formatDt} 
													</span>
												</li>
											</c:forEach>
											
											<c:if test="${empty boardList}">
												<li class="main_li pl20">
													등록된 글이 없습니다.
												</li>												
											</c:if>
										</ul>
									</div>
								</div>
								<!-- 공지사항 -->	
								
								<!-- 결재 조회 -->	
								<div class="bottom_area">
						    		<div class="area_title">
							    		<h3>
							    			<img src='resources/images/icon/icon_auth.png' width="20" height="20"/>
							    			결재 조회
							    		</h3><a href="intrAprvInqy2010.do?pageUrl=Aprv" class="main_ie" style="font-size: 1.5rem;">전체보기</a>
									</div>

									<div class="area_content">
										<ul class="area_ul">
											<c:forEach var="list" items="${aprvList}" begin="0" end="2">
												<li class="main_li">
													<a class="main_a pl20" href="intrAprvInqy2020.do?sequenceId=${list.aprvId}&temptypeCd=${list.temptypeCd}&returnUrl=${list.returnUrl}&pageUrl=Aprv">
														<script>document.write(isNew('${list.regDt}'))</script>	
														${list.aprvTitle}
													</a>
													<span class="date main_ie">
														<fmt:parseDate value="${list.regDt}" var="parseDt" pattern="yyyyMMdd"/>
														<fmt:formatDate value="${parseDt}" var="formatDt" pattern="yyyy-MM-dd"/>
														${formatDt} 
													</span>
												</li>
											</c:forEach>
											
											<c:if test="${empty aprvList}">
												<li class="main_li pl20">
													등록된 결재가 없습니다.
												</li>												
											</c:if>
										</ul>
									</div>
								</div>
								<!-- 결재 조회 -->
								
								<!-- 오늘의 일정 -->	
								<div class="bottom_area">
						    		<div class="area_title">
							    		<h3>
							    			<img src='resources/images/icon/icon_note.png' width="20" height="20"/>
							    			오늘의 일정
							    		</h3><a href="intrScheInqy2010.do" class="main_ie" style="font-size: 1.5rem;">전체보기</a>
									</div>

									<div class="area_content">
										<ul class="area_ul">
											<c:forEach var="list" items="${scheList}" begin="0" end="2">
												<li class="main_li">
													${list.aprvTitle}
													<span class="date main_ie">
														<fmt:parseDate value="${list.regDt}" var="parseDt" pattern="yyyyMMdd"/>
														<fmt:formatDate value="${parseDt}" var="formatDt" pattern="yyyy-MM-dd"/>
														${formatDt} 
													</span>
												</li>
											</c:forEach>
											
											<c:if test="${empty scheList}">
												<li class="main_li pl20">
													등록된 일정이 없습니다.
												</li>												
											</c:if>
										</ul>
									</div>
								</div>
								<!-- 오늘의 일정 -->	
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
    