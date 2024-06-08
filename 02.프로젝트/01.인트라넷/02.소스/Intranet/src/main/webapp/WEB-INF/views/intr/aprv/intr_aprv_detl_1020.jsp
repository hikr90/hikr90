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
			CKEDITOR.replace('editor',{ height: 500});
			
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
			$("#aprvLine").val("${empVO.empIdx}@STAT_0002|");
		}
	</script>
</head>
<body id="main">
	<form id="form" method="POST">

	<!-- 결재선 -->
 	<div id="popupArea" class="popupArea hidden">
		<c:import url="/WEB-INF/views/intr/comm/popup/intr_popup_inqy_1030.jsp"></c:import>	
	</div>

	<!-- MENU -->
	<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1030.jsp" %>
		
	<article id="_subArticle">
		<div class="_wrap">
			<div id="_content">
				<div id="sub_content" class="_inner" style="padding-top: 40px;">					
					<div class="_contentArea _formArea">
					<div class="postCon">
						<div class="postWrap">
							<!-- Form postWriteWrap  -->
							<h2>기안문 등록</h2>
							<input type="hidden" id="aprvLine" name="aprvLine" value="">
							<input type="hidden" id="empIdx" name="empIdx" value="${empVO.empIdx}">
							<input type="hidden" id="modCnt" name="modCnt" value="0">
							<input type="hidden" id="templateCd" name="templateCd" value="${defaultInfo.templateCd}">
							
							<div class="postWrite">
								<dl>
									<dt><label for="post-title">제목</label></dt>
									<dd style="width: 45%;">
										<input type="text" id="aprvTitle" class="aprvTitle" title="템플릿명" name="aprvTitle" value="${defaultInfo.templateNm}">
									</dd>
									<dt>시행일자</dt>
									<dd>
										<input type="text" id="srchSdt" class="srch-cdt-date" name="efctSdt" title="시행일자" readonly="readonly" style="width: 22%;"/>
										~
										<input type="text" id="srchEdt" class="srch-cdt-date" name="efctEdt" title="시행일자" readonly="readonly" style="width: 22%;"/>
									</dd>
								</dl>
								<dl class="post-info">
									<dt>부서</dt>
									<dd style="width: 45%;">${empVO.deptNm}</dd>
									<dt>직급</dt>
									<dd>${empVO.gradeNm}</dd>
									<dt>작성자</dt>
									<dd>${empVO.empNm}</dd>
								</dl>
								<dl>
									<dt><label for="post_text">내용</label></dt>
									<dd class="post_text">
										<textarea id="editor" title="템플릿 내용">${defaultInfo.templateContent}</textarea>
										<input type="hidden" id="aprvContent" title="템플릿 내용" name="aprvContent" value="">
									</dd>
								</dl>
							</div><!-- End postWriteWrap -->

							<div class="btnWrap alignR">
								<input type="button" class="_btn _grey" onclick="aprvLineCall(this.form);" value="등록">
								<a onclick="location.href='intrAprvInqy1010.do'" class="_btn _line">취소</a>
							</div>
						</div><!-- End postWrap -->
						</div>
					</div><!-- End _contentArea _formArea -->
				</div><!-- End _inner -->
			</div><!-- End _content -->
		</div><!-- End _wrap -->
	</article>
	</form>
</body>
</html>
	
<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1020.jsp" %>
