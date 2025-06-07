<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1010.jsp" %>

<head>
<script type="text/javascript">
	$(document).ready(function() {
		// 에디터
		CKEDITOR.replace('editor',{height: 710});
	});

	// 목록으로
	function listCall() {
		formSubmit('intrAprvInqy2010.do');
	}
	
	// 프로젝트 팝업
	function projCall(){
		//
		var obj = new Object();
		//
		obj["mappingId"] = "intrPopupInqy1030.do";
		obj["areaType"] = "proj";
		obj["width"] = "600"
		obj["height"] = "370";
		//		
		ajaxPopup(obj);
	}
	
	// 결재선 조회 팝업
	function lineCall(){
		var obj = new Object();
		//
		obj["mappingId"] = "intrPopupInqy1041.do";
		obj["areaType"] = "line";
		obj["width"] = "1100";
		obj["height"] = "620";
		//		
		ajaxPopup(obj);
	}
	
	// 물품 조회 팝업
	function itemCall(){
		var obj = new Object();
		//
		obj["mappingId"] = "intrPopupInqy1062.do";
		obj["areaType"] = "item";
		obj["width"] = "1100"
		obj["height"] = "620";
		//		
		ajaxPopup(obj);
	}
</script>
</head>
<body id="main">
<form id="form" method="POST" onsubmit="return false;">
	<!-- 메뉴 -->
	<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1030.jsp" %>

	<!-- 프로젝트 팝업 -->
 	<div id="projArea" class="popupArea hidden">
		<c:import url="/WEB-INF/views/intr/comm/popup/intr_popup_inqy_1030.jsp"></c:import>	
	</div>
	
	<!-- 결재선 팝업 -->
 	<div id="lineArea" class="popupArea hidden">
		<c:import url="/WEB-INF/views/intr/comm/popup/intr_popup_inqy_1040.jsp"></c:import>	
	</div>
	
	<!-- 물품 팝업 -->
 	<div id="itemArea" class="popupArea hidden">
		<c:import url="/WEB-INF/views/intr/comm/popup/intr_popup_inqy_1060.jsp"></c:import>	
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
						<div id="sub_content">					
							<div class="form_area">
								<input type="hidden" id="srchNm" name="srchNm" value="${param.srchNm}">
								<input type="hidden" id="tempCd" name="tempCd" value="${param.tempCd}">
								<input type="hidden" id="temptypeCd" name="temptypeCd" value="${param.temptypeCd}">
								<input type="hidden" id="returnUrl" name="returnUrl" value="${param.returnUrl}">
								<input type="hidden" id="filetypeCd" name="filetypeCd" value="APRV">
										
								<div class="post_wrap">
		                        	<h2>물품반출입 신청서
											<button type="button" class="btn_blue_thin main_ie" onclick="listCall();">목록으로</button>											
		                        	</h2><br>
									<div class="post_view">
										<dl>
											<dt>
												<label for="post-title">프로젝트명</label>
											</dt>
											<dd>
												${defaultInfo.aprvTitle}
											</dd>
										</dl>
										<dl>
											<dt>결재선</dt>
											<dd>
												<input type="button"class="btn_gray align_top" value="조회" onclick="lineCall();">
												<input type="hidden" id="aprvLine" name="aprvLine" value="">
											</dd>
											
											<dt>물품 등록</dt>
											<dd>
												<input type="button"class="btn_blue align_top" value="조회" onclick="itemCall();">
											</dd>
										</dl>
										<dl>
											<dt>반출입 일자</dt>
											<dd>
												<fmt:parseDate value="${defaultInfo.reqDt}" var="parseDt" pattern="yyyyMMdd"/>
												<fmt:formatDate value="${parseDt}" var="fomatDt" pattern="yyyy-MM-dd"/>
												${fomatDt}
											</dd>
										</dl>
								        <dl>
											<dt><label for="post_text">양식 내용</label></dt>
											<dd class="post_text">
												<textarea id="editor" name="aprvCont" title="양식 내용">${defaultInfo.aprvCont}</textarea>
											</dd>
										</dl>
										<dl class="post_info">
											<dt>첨부파일</dt>
											<dd class="post_file">
												<div class="file_wrap">
													<!-- 파일 목록 -->
													<c:import url="/WEB-INF/views/intr/comm/include/intr_include_1040.jsp">
														<c:param name="fileNm"></c:param>
													</c:import>
												</div>
											</dd>
										</dl>
									</div><!-- End post_write -->
									
									<div class="btn_wrap align_right">
										<div class="float_left">
											<c:if test="${not empty fileList and fileList ne '' and fileList.size() > 1}">
												<button type="button" class="btn_navy_thin" onclick="zipProc();">전체 다운로드</button>
											</c:if>
										</div>
										
										<div class="float_right">
											<button type="button" class="btn_gray_thin" onclick="listCall();">목록으로</button>
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
