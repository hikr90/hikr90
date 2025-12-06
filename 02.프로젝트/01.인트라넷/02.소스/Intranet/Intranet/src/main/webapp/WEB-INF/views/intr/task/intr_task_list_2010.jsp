<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1010.jsp" %>

<script type="text/javascript">
	$(document).ready(function(){
		// 페이지 로드 후 탭 오버플로우 체크
	    isTabOverlow();
	    
	    // 윈도우 크기가 변경될 때도 체크 (반응형 대응)
	    $(window).resize(function() {
	    	isTabOverlow();
	    });
	});
	
	// 목록 조회
	function listCall(){
		try {
			// 부서 선택
		    let orgCd = $("#orgCd").val();
		    $("a[orgCd='" + orgCd + "']").trigger('click');
			
		} catch (error){
	        console.error("[Error] 목록 조회 : ", error.message);
		}
	}
	
	// +/- 처리
	function spreadProc(taskId){
		try {
			//
			var spreadType = $("#"+taskId).attr("spreadType");
			//		
			if(spreadType=="Y") {
				// close
				$("."+taskId).removeClass('hide');
				$("."+taskId).addClass('show');	
				$("#"+taskId).find('.spread').text("-");	
				$("#"+taskId).attr('spreadType','N');
	
			} else {
				// open
				$("."+taskId).removeClass('show');
				$("."+taskId).addClass('hide');	
				$("#"+taskId).find('.spread').text("+");	
				$("#"+taskId).attr('spreadType','Y');
			}
			
		} catch (error){
	        console.error("[Error] +/- 처리 : ", error.message);
		}
	}
	
	// 스크롤 이동 거리 설정
	let SCROLL_AMOUNT = 250; 
	
	// 화살표 이동
	function scrollTabs(direction) {
	    // 탭 목록을 감싸서 overflow: hidden이 적용된 요소
	    let wrapper = $(".tab_wrapper");
	    let currentScroll = wrapper.scrollLeft();
	    let newScroll;

	    if (direction === 'left') {
	        // 왼쪽으로 이동 (스크롤 위치 감소)
	        newScroll = currentScroll - SCROLL_AMOUNT;
	    } else {
	        // 오른쪽으로 이동 (스크롤 위치 증가)
	        newScroll = currentScroll + SCROLL_AMOUNT;
	    }

	    // jQuery animate를 사용하여 부드럽게 스크롤 이동
	    wrapper.animate({
	        scrollLeft: newScroll
	    }, 300); // 300ms 동안 움직임
	}
	
	// 탭 show/hide 체크
	function isTabOverlow() {
	    let tabList = $(".tab_list"); 						// 탭 목록 전체 (실제 콘텐츠 너비)
	    let wrapper = $(".tab_wrapper");  			// 탭 목록을 감싸는 뷰포트 (보이는 영역 너비)
	    let controls = $(".tab_scroll_controls"); 	// 좌우 화살표 버튼 컨테이너
        
        // 탭 목록의 실제 스크롤 너비와 wrapper의 보이는 너비를 비교
	    if (tabList[0].scrollWidth > wrapper.width()) {
	        // 탭이 넘칠 경우, show
	        controls.show(); 
	    } else {
	        // 탭이 넘치지 않을 경우, hide
	        controls.hide();
	    }
	}
	
	// 탭 클릭
	function tabCall(element){
		//
		try {
			// Active 추가
			let elt = $(element);
			$('.tab_item').removeClass('active');
			elt.parent('li').addClass('active');

			// 부서 코드 조회
			let orgCd = elt.attr('orgCd');
			$("#orgCd").val(orgCd);
			//
			let param = $("#form").serialize();
			$.ajax({
		    	type : 'post',
		    	url : "intrTaskInqy2011.do",
				data : param,
				dataType : 'text',
				success : function(data){
					$("#tabArea").html("");
					//
					if(data != ''){
						$("#tabArea").html(data);
					}
				},
				error : function(xhr, status, error){
					alert("<spring:message code="PROC.ERROR"/>");	
		    	}
			})
			
		} catch (error){
			console.error("[Error] 탭 선택 처리 : ", error.message);
		}
	}
	
	// 업무 상세 조회
	function detCall(taskId){
		try {
			//
			$("#taskId").val(taskId);
			formSubmit("intrTaskInqy2020.do");
			
		} catch (error){
	        console.error("[Error] 업무 상세 조회 : ", error.message);
		}
	}
</script>
<body id="main">
<form id="form" method="POST">
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
							<div id="sub_content">					
								<div class="form_area">
									<div class="post_wrap">
										<input type="hidden" id="page" name="page" value="${param.page}">
										<input type="hidden" id="pageUrl" name="pageUrl" value="${param.pageUrl}">
										<input type="hidden" id="orgCd" name="orgCd" value="${param.orgCd}">
										<input type="hidden" id="taskId" name="taskId" value="">
										
										<h2>업무일지 조회</h2>
										<div class="srch_wrap">
											<div class="right_srch_area">
												<!-- 작성일자 -->
												<div class="srch_area">
													<label class="srch_label">작성일자</label>
													<input type="text" id="srchSdt" class="srch_cdt_date" id="srchSdt" name="srchSdt" value="${param.srchSdt}" readonly="readonly"/>
													~
													<input type="text" id="srchEdt" class="srch_cdt_date" id="srchEdt" name="srchEdt" value="${param.srchEdt}" readonly="readonly"/>
												</div>

												<!-- 작성자 -->
												<div class="float_right">
													<div class="srch_area">
														<label class="srch_label">작성자</label>
														<input type="text" id="srchNm" name="srchNm" class="srch_cdt_text" value="${param.srchNm}" onkeydown="pushCall(this.form);">
														
														<input type="button" class="btn_blue" value="조회" onclick="listCall();">
														<input type="button" class="btn_gray" value="초기화" onclick="initCall();">
													</div>
			                                	</div>
			                                </div>
										</div>
										
										<!-- 탭 -->
										<div class="tab_container">
											<!-- 왼쪽 화살표 -->
										    <div class="tab_scroll_controls">
										    	<a href="javascript:void(0);" onclick="scrollTabs('left');">
										    		<img class="scroll_btn_left" src='resources/images/icon/icon_scroll_arrow.png' width="35" height="35" />
										    	</a>
										    </div>
										    
										    <!-- 탭 목록 -->
										    <div class="tab_wrapper">
											    <ul class="tab_list">
											    	<c:forEach var="list" items="${orgList}" varStatus="status">
											    		<c:if test="${empty param.orgCd}">
											    			<li class="tab_item ${status.index eq 0 ? 'active' : ''}">
											    		</c:if>
											    		<c:if test="${not empty param.orgCd}">
											    			<li class="tab_item ${list.orgCd eq param.orgCd ? 'active' : ''}">
											    		</c:if>
															<a href="javascript:void(0);" class="${list.orgCd}" onclick="tabCall(this);" orgCd="${list.orgCd}">${list.orgNm}</a>
														</li>
											        </c:forEach>
											    </ul>
										    </div>
										    
										    <div class="tab_scroll_controls">
										    	<a href="javascript:void(0);" onclick="scrollTabs('right');">
										    		<img class="scroll_btn_right" src='resources/images/icon/icon_scroll_arrow.png' width="35" height="35" />
										    	</a>
										    </div>
										</div>
										<!-- 탭 -->

										<!-- 탭 내용 -->
										<div id="tabArea" class="tab_content_area">
											<table class="post_table">
												<caption>업무일지 조회</caption>
												<colgroup>
													<col class="w5per">
													<col class="auto">
													<col class="w10per">
													<col class="w10per">
												</colgroup>
												<thead>
													<tr>
														<th scope="col">+/-</th>
														<th scope="col">업무 제목</th>
														<th scope="col">등록 시간</th>
														<th scope="col">등록자</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="list" items="${defaultList}" varStatus="status"> 
											        	<c:set var="none" value="none${status.index}" />
														<tr id="${list.rowNum eq 1 ? list.taskId : none}" class="${list.rowNum eq 1 ? '' : list.taskId} ${list.rowNum eq 1 ? 'show' : 'hide'}" spreadType="${list.rowNum eq 1 ? 'Y' : 'N'}">
													        <c:if test="${list.rowNum eq 1}">
													            <td rowspan="${list.rowCnt}">
													                <a class="spread" onclick="spreadProc('${list.taskId}');">+</a>
													            </td>
													        </c:if>
											
													        <td class="_title">
											    		        <a href="javascript:void(0);" class="show_view a_title" style="color: #214b97 !important;" onclick="detCall('${list.taskId}');">${list.taskTitle}</a>
											    		    </td>
											
													        <c:if test="${list.rowNum eq 1}">
													            <td rowspan="${list.rowCnt}">
													                <span class="date">
													                    <fmt:parseDate value="${list.taskDt}" var="parseDt" pattern="yyyyMMdd"/>
													                    <fmt:formatDate value="${parseDt}" var="formatDt" pattern="yyyy-MM-dd"/>
													                
													                    ${formatDt}
													                </span>
													            </td>
													            <td rowspan="${list.rowCnt}">${list.orgNm} ${list.empNm}</td>
													        </c:if>
													</tr>
												</c:forEach>
											
													<!-- 글이 없는 경우 -->
													<c:if test="${empty defaultList}">
												    	<tr>
															<td align="center" colspan="4">등록된 글이 없습니다.</td>
														</tr>
													</c:if>
												</tbody>
											</table>
											
											<c:if test="${not empty defaultList}">
												<div class="paging_area">
													<div class="list_cnt">총 건수 : ${defaultList[0].listCnt}건</div>
														<ul class="paging">
															<li class="">${pageMenu}</li>
														</ul>
												</div><!-- End paging_wrap -->
											</c:if>
										</div>
										
								</div><!-- End post_wrap  -->
							</div><!-- End form_area -->
						</div><!-- End content -->
					</div><!-- End wrap -->
				</article>
			</div>
		</div>
	</div>
</form>
</body>

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1020.jsp" %>
