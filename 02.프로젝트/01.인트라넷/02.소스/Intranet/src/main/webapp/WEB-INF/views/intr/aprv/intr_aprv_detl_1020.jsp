<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" 	uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="spring" 	uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1010.jsp" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script>
		$(document).ready(function() {
			// 에디터
			CKEDITOR.replace('editor', {height: 800});
			
			// 기본 결재선 등록
			setAprvLine();
		});
		
		// 시행일자 유효성
		function validateAprvDt(){
			//
			var chkYn = true;
			// 시행일자 유효성 검증			
 			var date = new Date();
			var today = getDateStamp(date); 
			// 시행일자 (시작, 종료일)
			var efctSdt = $("#srchSdt").val();
			var efctEdt = $("#srchEdt").val();
			//
 			if(efctSdt=='' || efctEdt==''){
				alert("<spring:message code="APRV.DT.NONE"/>");
				chkYn = false;
				return;
			};
 			if(efctSdt<today || efctSdt<today){
				alert("<spring:message code="APRV.DT.PAST"/>");
				chkYn = false;
				return;
			};
 			if(efctSdt>efctEdt){
				alert("<spring:message code="APRV.EDT.PAST"/>");
				chkYn = false;
				return;
			};
			
			return chkYn;			
		}
		
		// 기안문 등록 처리
		function aprvLineCall(){
			// 유효성 검증
			if(!validation()){return;};
			if(!validateAprvDt()){return;};
 			// 결재선 팝업
 			
 			if($(".setListTr").length==0){
				// 첫 시작
				var obj = new Object();
				ajaxPopup(obj,"1100","650","intrPopupInqy1031.do","");
				
			} else {
				// 숨김 해제
				$("#popupArea").removeClass('hidden');
			}
		}
		
		// 결재선 기본 등록
		function setAprvLine(){
			$("#aprvLine").val("${empVO.empIdx}" + "@" + "STEP_0002" + "|");
		}
		
		// 취소
		function listCall(){
			formSubmit("intrAprvInqy1010.do");
		}
	</script>
</head>
<body id="main">
	<form id="form" method="POST">

	<!-- 결재선 -->
 	<div id="popupArea" class="popupArea hidden">
		<c:import url="/WEB-INF/views/intr/comm/popup/intr_popup_inqy_1030.jsp"></c:import>	
	</div>

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
									<h2>기안문 등록</h2><br>
									<input type="hidden" id="aprvLine" name="aprvLine" value="">
									<input type="hidden" id="empIdx" name="empIdx" value="${empVO.empIdx}">
									<input type="hidden" id="tempCd" name="tempCd" value="${defaultInfo.tempCd}">
									<input type="hidden" id="page" name="page" value="${param.page}">
									<input type="hidden" id="pageUrl" name="pageUrl" value="${param.pageUrl}">
									
									<div class="post_write">
										<dl>
											<dt><label for="post-title">제목</label></dt>
											<dd>
												<input type="text" id="aprvTitle" class="aprvTitle" title="템플릿명" name="aprvTitle" value="${defaultInfo.tempNm}">
											</dd>
											
											<dt>시행일자</dt>
											<dd>
												<input type="text" id="srchSdt" class="srch_cdt_date width30" name="efctSdt" title="시행일자" readonly="readonly"/>
												~
												<input type="text" id="srchEdt" class="srch_cdt_date width30" name="efctEdt" title="시행일자" readonly="readonly"/>
											</dd>
											
											<dt>일정 등록 여부</dt>
											<dd>${defaultInfo.calendarYn}</dd>
										</dl>
										<dl class="post_info">
											<dt>부서</dt>
											<dd>${empVO.deptNm}</dd>
											
											<dt>직급</dt>
											<dd>${empVO.gradeNm}</dd>

											<dt>작성자</dt>
											<dd>${empVO.empNm}</dd>
										</dl>
										<dl>
											<dt><label for="post_text">내용</label></dt>
											<dd class="post_text">
												<textarea id="editor" title="템플릿 내용">${defaultInfo.tempCont}</textarea>
												<input type="hidden" id="aprvCont" title="템플릿 내용" name="aprvCont" value="">
											</dd>
										</dl>
									</div><!-- End post_write -->
		
									<div class="btn_wrap align_right">
										<button type="button" type="button"class="btn_navy_thin" onclick="aprvLineCall();">등록</button>
										<button type="button" type="button"class="btn_gray_thin" onclick="listCall();">취소</button>
									</div>
								</div>
							</div><!-- End form_area -->
						</div><!-- End sub_content -->
					</div><!-- End content -->
				</article>
			</div>
		</div>
	</div>
</form>
</body>
</html>
	
<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1020.jsp" %>
