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
		formSubmit('intrAprvInqy2010.do');
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
		// 결재 수신처리 (반려:0, 결재:1, 회수:2)
		$("#aprvGb").val(aprvGb);
		//
		var obj = new Object();
		ajaxPopup(obj,"700","340","intrPopupInqy2011.do","1");
	}
	
	// 팝업 확인
	function aprvProc(){
		//
		var aprvPwd = $("#aprvPwd").val().toUpperCase();
		var aprvResn = $("#aprvResn").val();
		var empPwd = "${empVO.empPwd}".toUpperCase();
		//
		if(aprvPwd==''){
			alert("<spring:message code="APRV.PWD.NONE"/>");
			return;
		}
		if(aprvPwd!=empPwd){
			alert("<spring:message code="APRV.PWD.FAIL"/>");
			return;
		}
		
		// 처리
		var param = $("#form").serialize();
		if(confirm("진행하시겠습니까?")){
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
</script>
</head>
<body id="main">
<form id="form" name="form" method="POST" onsubmit="return false;">
	<!-- 결재선 -->
 	<div id="popupArea" class="popupArea hidden">
		<c:import url="/WEB-INF/views/intr/comm/popup/intr_popup_inqy_1030.jsp"></c:import>	
	</div>

	<!-- 결재 의견 -->
 	<div id="popupArea1" class="popupArea1 hidden">
		<c:import url="/WEB-INF/views/intr/comm/popup/intr_popup_inqy_2010.jsp"></c:import>	
	</div>

	<!-- MENU -->
	<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1030.jsp" %>
	
	<article id="_subArticle">
		<div class="_wrap">
			<div id="_content">
				<div id="sub_content" class="_inner" style="padding-top: 40px;">					
					<div class="_contentArea _formArea">
						<input type="hidden" id="page" name="page" value="${param.page}">
						<input type="hidden" id="srchNm" name="srchNm" value="${param.srchNm}">
						<input type="hidden" id="srchSdt" name="srchSdt" value="${param.srchSdt}">
						<input type="hidden" id="srchEdt" name="srchEdt" value="${param.srchEdt}">
						<input type="hidden" id="currAprvSno" name="currAprvSno" value="${aprvDetInfo.currAprvSno}">
						<input type="hidden" id="contentIdx" name="contentIdx" value="${aprvDetInfo.aprvIdx}">
						<input type="hidden" id="lastAprvYn" name="lastAprvYn" value="${empVO.empIdx eq aprvDetInfo.aprvEmpIdx?aprvDetInfo.lastAprvYn:'N'}">
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
									<dd style="width: 40%;">${aprvDetInfo.aprvTitle}</dd>
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
								<dl class="post-info">
									<dt>기안자</dt>
									<dd style="width: 40%;">(${aprvDetInfo.deptNm}) ${aprvDetInfo.empNm}</dd>
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
	                            		<a class="_btn _gray" onclick="popCall(${aprvDetInfo.aprvIdx});">결재선</a> 
									</dd>
								</dl>

								<c:if test="${not empty defaultList and defaultList ne ''}">
								<dl class="post_file">
									<dt>첨부파일</dt>
									<dd class="post_file" style="width: 40%;">
										<div class="scrollFileWrap">
											<ul id="updUl"> 
											<c:forEach var="list" items="${defaultList}">
												<li>
													<img src='resources/images/icon/icon_file.png'/>
													<a href="#" onclick="fileProc('${list.fileIdx}');">${list.fileOrglNm}</a>
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
										<textarea id="editor" name="aprvContent" title="템플릿 내용">${aprvDetInfo.aprvContent}</textarea>
									</dd>
								</dl>
							</div><!-- End postViewWrap -->
							
							<div class="btnWrap alignR">
								<div class="floatR">
									<c:if test="${empVO.empIdx eq aprvDetInfo.aprvEmpIdx and (aprvDetInfo.aprvRsltDt eq null or aprvDetInfo.aprvRsltDt eq '')}">
										<a class="_btn _gray" onclick="aprvCall('0');">반려</a>
										<a class="_btn _blue" onclick="aprvCall('1');">결재</a>
									</c:if>
								</div>
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

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1020.jsp" %>
