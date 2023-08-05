<!--명칭 : intr_aprv_detl_1010
	작성자 : 김태현
	작성일자 : 2023.07.17
	내용 : 품의문 상세 조회-->
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
	
	// 파일 다운로드
	function fileProc(){
		formSubmit('intrFileProc1020.do');
	}
	
	// 전체 다운로드
	function zipProc(){
		formSubmit('intrFileProc1030.do');
	}
	
	// 결재선 조회 팝업
	function popCall(aprvIdx){
		//
		var obj = new Object();
		obj["contentIdx"] = aprvIdx;
		//		
		ajaxPopup(obj,"1100","650","intrPopupInqy1032.do","");
	}
	
	// 결재 처리
	function aprvCall(aprvGb){
		// 반송(0), 결재(1) 구분 값 지정
		$("#aprvGb").val(aprvGb);
		formSubmit('intrAprvProc1020.do');
	}
</script>
</head>
<body id="main">
	<!-- 결재선 -->
 	<div id="popupArea" class="popupArea hidden">
		<c:import url="/WEB-INF/views/intr/comm/popup/intr_popup_inqy_1030.jsp"></c:import>	
	</div>

	<!-- MENU -->
	<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1030.jsp" %>
	
	<form id="form" method="POST">
	<article id="_subArticle">
		<div class="_wrap">
			<div id="_content">
				<div id="sub_content" class="_inner" style="padding-top: 40px;">					
					<div class="_contentArea _formArea">
						<input type="hidden" id="page" name="page" value="${param.page}">
						<input type="hidden" id="srchNm" name="srchNm" value="${param.srchNm}">
						<input type="hidden" id="srchSdt" name="srchSdt" value="${param.srchSdt}">
						<input type="hidden" id="srchEdt" name="srchEdt" value="${param.srchEdt}">
						<input type="hidden" id="contentIdx" name="contentIdx" value="${defaultInfo.aprvIdx}">
						<input type="hidden" id="aprvGb" name="aprvGb" value="0">
					
						<div class="postCon">
						<div class="postWrap">
                            <h2>품의문 상세
    	                        <span class="stb-box">
                            		<a class="_btn _blue" onclick="listCall();">목록으로</a>
								</span>
                            </h2>
                            
							<!-- Form postViewWrap  -->
							<div class="postView">
								<dl>
									<dt>제목</dt>
									<dd style="width: 40%;">${defaultInfo.aprvTitle}</dd>
									<dt>작성일</dt>
									<dd>
										<span class="date">
											<fmt:parseDate value="${defaultInfo.regDt}" var="parseDt" pattern="yyyyMMdd"/>
											<fmt:formatDate value="${parseDt}" var="fomatDt" pattern="yyyy-MM-dd"/>
											${fomatDt} 
										</span>	
									</dd>
									<dt>진행 단계</dt>
									<dd>${defaultInfo.currStepNm}</dd>
								</dl>
								<dl class="post-info">
									<dt>기안자</dt>
									<dd style="width: 40%;">(${defaultInfo.deptNm}) ${defaultInfo.empNm}</dd>
									<dt>시행일자</dt>
									<dd>
										<span class="date">
											<!-- 시행 시작일 --> 
											<fmt:parseDate value="${defaultInfo.efctSdt}" var="parseSdt" pattern="yyyyMMdd"/>
											<fmt:formatDate value="${parseSdt}" var="formatSdt" pattern="yyyy-MM-dd"/>

											<!-- 시행 종료일 --> 
											<fmt:parseDate value="${defaultInfo.efctEdt}" var="parseEdt" pattern="yyyyMMdd"/>
											<fmt:formatDate value="${parseEdt}" var="formatEdt" pattern="yyyy-MM-dd"/>
											${formatSdt} ~ ${formatEdt}
										</span>	
									</dd>
									<dt>결재선</dt>
									<dd>
	                            		<a class="_btn _gray" onclick="popCall(${defaultInfo.aprvIdx});">결재선</a>
									</dd>
								</dl>

								<c:if test="${not empty fileList and fileList ne ''}">
								<dl class="post_file">
									<dt>첨부파일</dt>
									<dd class="post_file" style="width: 40%;">
										<div class="scrollFileWrap">
											<ul id="updUl"> 
											<c:forEach var="list" items="${fileList}">
												<li>
													<img src='resources/images/icon/icon_file.png'/>
													<a href="#" onclick="fileProc();">${list.fileOrglNm}</a>
													<input type="hidden" id="fileIdx" name="fileIdx" value="${list.fileIdx}">
												</li>
											</c:forEach>
											</ul>
										</div>
									</dd>
									<dt><a class="_btn" onclick="zipProc();">전체 다운로드</a></dt>
									<dd></dd>
								</dl>
								</c:if>

								<dl>
									<dt>내용</dt>
									<dd class="post_text">
										<textarea id="editor" name="aprvContent" title="템플릿 내용">${defaultInfo.aprvContent}</textarea>
									</dd>
								</dl>
							</div><!-- End postViewWrap -->
						</div><!-- End postWrap -->
					</div>
					</div><!-- End _contentArea _formArea -->
				</div><!-- End _inner -->
			</div><!-- End _content -->
		</div><!-- End _wrap -->
	</article>
	</form>
</body>		

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1020.jsp" %>
