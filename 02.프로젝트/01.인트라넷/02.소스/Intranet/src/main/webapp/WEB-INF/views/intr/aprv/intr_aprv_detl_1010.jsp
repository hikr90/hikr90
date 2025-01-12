<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1010.jsp" %>

<head>
<script type="text/javascript">
	$(document).ready(function() {
		// 에디터
		CKEDITOR.replace('editor',{height: 500});
	});

	// 목록으로
	function listCall() {
		formSubmit('intrAprvInqy1010.do');
	}
	
	// 결재선 조회 팝업
	function popCall(contId){
		//
		var obj = new Object();
		obj["contId"] = contId;
		//		
		ajaxPopup(obj,"1100","620","intrPopupInqy1050.do","");
	}
	
	// 결재 처리
	function aprvCall(aprvGb){
		// 결재 (0), 반송 (1), 취소(2)		
		$("#aprvGb").val(aprvGb);
		//
		if(confirm("진행하시겠습니까?")){
			var param = $("#form").serialize();

			$.ajax({
		    	type : 'post',
		    	url : "intrAprvProc1020.do",
				data : param,
				dataType : 'text',
				success : function(data){
					//
					var json = eval(data);
	   				if(json[0].res=="NO"){
	   	   				// 결재 실패
	   					alert("<spring:message code="APRV.LINE.EXSIT"/>");
	   	   				return;
	   	   				
	   				} else if(json[0].res=="EXIST"){
	   					// 이미 결재 완료된 상태
	   					alert("<spring:message code="PROC.FAIL"/>");
	   					return;
	   					
					} else {
	   					// 결재 완료 후 새로고침
	   					alert("<spring:message code="PROC.SUCCESS"/>");
	   					location.reload();
	   				}
				},
				error : function(xhr, status, error){
			    	//
					alert("<spring:message code="PROC.ERROR"/>");
			    	return;
			    }
			});
		}
	}
	
	// 품의문 재사용 등록
	function reAprvCall(){
		if(confirm("진행하시겠습니까?")){
			formSubmit('intrAprvInqy2030.do');
		}
	}
</script>
</head>
<body id="main">
	<!-- 결재선 -->
 	<div id="popupArea" class="popupArea hidden">
		<c:import url="/WEB-INF/views/intr/comm/popup/intr_popup_inqy_1030.jsp"></c:import>	
	</div>

	<!-- 메뉴 -->
	<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1030.jsp" %>
	
	<form id="form" method="POST" onsubmit="return false;">
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
									<input type="hidden" id="page" name="page" value="${param.page}">
									<input type="hidden" id="pageUrl" name="pageUrl" value="${param.pageUrl}">
									<input type="hidden" id="srchNm" name="srchNm" value="${param.srchNm}">
									<input type="hidden" id="srchSdt" name="srchSdt" value="${param.srchSdt}">
									<input type="hidden" id="srchEdt" name="srchEdt" value="${param.srchEdt}">
									<input type="hidden" id="contId" name="contId" value="${aprvDetInfo.contId}">
									<input type="hidden" id="aprvGb" name="aprvGb" value="0">
											
									<div class="post_wrap">
			                        	<h2>품의문 상세</h2><br>
										<div class="post_view">
											<dl>
												<dt>제목</dt>
												<dd>${aprvDetInfo.aprvTitle}</dd>
												<dt>작성일</dt>
												<dd>
													<span class="date">
														<fmt:parseDate value="${aprvDetInfo.regDt}" var="parseDt" pattern="yyyyMMdd"/>
														<fmt:formatDate value="${parseDt}" var="fomatDt" pattern="yyyy-MM-dd"/>
														${fomatDt} 
													</span>	
												</dd>
												<dt>진행 단계</dt>
												<dd>${aprvDetInfo.currStepNm}</dd>
											</dl>
											<dl class="post_info">
												<dt>작성자</dt>
												<dd>(${aprvDetInfo.deptNm}) ${aprvDetInfo.empNm} ${aprvDetInfo.gradeNm}</dd>
												<dt>시행일자</dt>
												<dd>
													<span class="date">
														<!-- 시행 시작일 --> 
														<fmt:parseDate value="${aprvDetInfo.efctSdt}" var="parseSdt" pattern="yyyyMMdd"/>
														<fmt:formatDate value="${parseSdt}" var="formatSdt" pattern="yyyy-MM-dd"/>
			
														<!-- 시행 종료일 --> 
														<fmt:parseDate value="${aprvDetInfo.efctEdt}" var="parseEdt" pattern="yyyyMMdd"/>
														<fmt:formatDate value="${parseEdt}" var="formatEdt" pattern="yyyy-MM-dd"/>
														${formatSdt} ~ ${formatEdt}
													</span>	
												</dd>
												<dt>결재선</dt>
												<dd>
				                            		<button type="button" class="btn_navy_thin" onclick="popCall(${aprvDetInfo.contId});">결재선</button>
												</dd>
											</dl>
											<dl>
												<dt>내용</dt>
												<dd class="post_text">
													<textarea id="editor" name="aprvCont" title="템플릿 내용">${aprvDetInfo.aprvCont}</textarea>
												</dd>
											</dl>
										</div>

										<div class="btn_wrap">
											<div class="float_right">
												<button type="button" class="btn_blue_thin" onclick="listCall();">목록으로</button>											
											</div>

											<div class="float_right">
												<!-- 기안자, 결재 취소할 수 있는 상황 -->
												<c:if test="${empVO.empIdx eq currAprvInfo.empIdx and currAprvInfo.cancelYn eq 'Y'}">
													<button type="button" class="btn_gray_thin" onclick="aprvCall('2');">결재 취소</button>
												</c:if>
												<!-- 기안자, 반송 상황 -->
												<c:if test="${empVO.empIdx eq aprvDetInfo.empIdx and (aprvDetInfo.stepCd eq 'STEP_0004' or aprvDetInfo.stepCd eq 'STEP_0005')}">
													<button type="button" class="btn_gray_thin" onclick="reAprvCall();">재사용 등록</button>
												</c:if>
											</div>
										</div>
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
