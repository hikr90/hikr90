<!--명칭 : intr_temp_list_1010
	작성자 : 김태현
	작성일자 : 2022.12.29
	내용 : 템플릿 목록 조회-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1010.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(document).ready(function() {
		// 선택 항목 음영 처리
		$(document).on('click','.a_btn',function() {
			//
			$(".a_btn").each(function() {
				$(this).removeClass('list_bg');
			});
			//
			$(this).addClass('list_bg');
		})
		
		// 트리 세팅
		setTree("treeArea");
	});

	// 템플릿 조회
	function listCall(f){
		//
		var param = $("#form").serialize();
		$.ajax({
    		type : 'post',
        	url : 'intrTempInqy1011.do',
            data : param,
            dataType : 'html',
            success : function(data){
            	//
            	$(".tree").html(data);
            	setTree("treeArea");
            },
            error : function(data){
            	//
				alert("<spring:message code="comm.proc.error"/>");
            }
      	});
	}

	// 템플릿 등록
	function regCall() {
		//
		$.ajax({
    		type : 'post',
        	url : 'intrTempInqy1020.do',
            data : null,
            dataType : 'html',
            success : function(data){
     				//
            	    $(".treeInfo").html(data);
     				$(".a_btn").each(function() {
        				$(this).removeClass('list_bg');
        			});
            },
            error : function(data){
            	//
				alert("<spring:message code="comm.proc.error"/>");
            }
      	});
	}
	
	// 템플릿 등록 처리
	function regProc(){
		// 유효성 검증
		if(!validation()){return;};
		var param = $("#form").serialize();
		//
		if(confirm("등록하시겠습니까?")){
			//		
			$.ajax({
	    		type : 'post',
	        	url : 'intrTempProc1010.do',
	            data : param,
	            dataType : 'html',
	            success : function(data){
	     				//
	            	    $(".treeInfo").html(""); // 등록 화면 초기화
	    				alert("<spring:message code="comm.proc.succ"/>"); // ALERT
	    				
	    				// 재 조회
	            		$(".listCall").trigger("click");	
	            },
	            error : function(data){
	            	//
					alert("<spring:message code="comm.proc.error"/>");
	            }
	      	});
		}		
	}
	
	// 템플릿 상세보기
	function detCall(templateCd){
		//
		$("#templateCd").val(templateCd);
		var param = $("#form").serialize();
		//
		$.ajax({
    		type : 'post',
        	url : 'intrTempInqy1030.do',
            data : param,
            dataType : 'html',
            success : function(data){
     				//
            	    $(".treeInfo").html(data);
            },
            error : function(data){
            	//
				alert("<spring:message code="comm.proc.error"/>");
            }
      	});
	}
	
	// 템플릿 수정화면
	function modCall(f){
		//
		var param = $("#form").serialize();
		//
		$.ajax({
    		type : 'post',
        	url : 'intrTempInqy1040.do',
            data : param,
            dataType : 'html',
            success : function(data){
     				//
            	    $(".treeInfo").html(data);
            },
            error : function(data){
            	//
				alert("<spring:message code="comm.proc.error"/>");
            }
      	});
	}
	
	// 템플릿 수정 처리
	function modProc(f){
		// 유효성 검증
		if(!validation()){return;};
		var param = $("#form").serialize();
		//
		if(confirm("수정하시겠습니까?")){
			//		
			$.ajax({
	    		type : 'post',
	        	url : 'intrTempProc1020.do',
	            data : param,
	            dataType : 'html',
	            success : function(data){
	     				//
	            	    $(".treeInfo").html(""); // 등록 화면 초기화
	    				alert("<spring:message code="comm.proc.succ"/>"); // ALERT
	    				
	    				// 재 조회
	            		$(".listCall").trigger("click");	
	            },
	            error : function(data){
	            	//
					alert("<spring:message code="comm.proc.error"/>");
	            }
	      	});
		}		

	}
	
	// 템플릿 삭제 처리
	function delProc(f){
		//
		if(!validation()){return;};
		var param = $("#form").serialize();
		//
		if(confirm("삭제하시겠습니까?")){
			//		
			$.ajax({
	    		type : 'post',
	        	url : 'intrTempProc1030.do',
	            data : param,
	            dataType : 'html',
	            success : function(data){
	     				//
	            	    $(".treeInfo").html(""); // 등록 화면 초기화
	    				alert("<spring:message code="comm.proc.succ"/>"); // ALERT
	    				
	    				// 재 조회
	            		$(".listCall").trigger("click");	
	            },
	            error : function(data){
	            	//
					alert("<spring:message code="comm.proc.error"/>");
	            }
	      	});
		}
	}
	
	// 상위 공통코드 팝업
	function popCall(){
		//
		var param = $("#form").serialize();
		ajaxPopup(param,"650","440","intrPopupInqy1030.do");
	}
	
	// (팝업) 상위 템플릿 선택
	function popConfirm(){
		//
		if($("input[type=radio]:checked").length==0){
			//
			alert("선택된 항목이 없습니다.");
			return;
		}
		// 값 지정
		var checkedCd = $("input[type='radio']:checked").val();
		var checkedNm = $("input[type='radio']:checked").attr('templateNm');
		//
		$(".upprTemplateCd").val(checkedCd);
		$(".upprTemplateNm").val(checkedNm);
		//
		popClose('popupArea');
	}
	
	// 상위 공통코드 삭제
	function delPopCall() {
		//
		$(".upprTemplateCd").val("");
		$(".upprTemplateNm").val("");
	}
</script>
</head>
<body id="main">
<form id="form" name="form">
	<!-- 정보 찾기 -->
 	<div id="popupArea" class="popupArea hidden">
		<c:import url="/WEB-INF/views/intr/comm/popup/intr_popup_inqy_1010.jsp"></c:import>	
	</div>
	
	<!-- MENU -->
	<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1030.jsp" %>
	
	<article id="_subArticle">
		<div class="_wrap">
			<div id="_content">
				<div id="sub_content" class="_inner">					
					<div class="_contentArea _formArea">
						<div class="postWrap" style="padding-top: 60px;">
						<input type="hidden" id="templateCd" name="templateCd" value="0">
						<input type="button" class="listCall" onclick="listCall(this.form);" style="display: none;">
						
							<div class="tagWrap">
								<h2>템플릿 관리
									<span class="stb-box">
										<input type="button" class="stb-box-btn2" value="등록" onclick="regCall();">
									</span>
								</h2>
							</div>
							
                            <div class="f-srchWrap">
                            	<div class="srchArea">
									<label class="srcLabel">템플릿명</label>
									<input type="text" id="srchNm" name="srchNm" class="srch-cdt-text" value="${srchMap.srchNm}" onkeydown="pushListKey(this.form);">
								</div>
								<div class="srchArea cdtArea noLabel">                                
                                	<input type="button" class="stb-box-btn" value="조회" onclick="listCall(this.form);">
                                </div>
                            </div>
                            <!-- end Form srchWrap  -->
							
							<div class="treeWrap">
								<div class="treeArea" id="treeArea"> 
									<div class="tree">
										<ul class="ul_1">
																		
										<c:forEach var="list" items="${defaultList}" varStatus="status">
											<c:set var="spanIcon"	value="icon_folder"/>
											<c:set var="nextLv"	value=""/>
											<c:set var="prevLv"	value=""/>
										
											<c:if test="${list.isleaf eq 'Y'}">
			           						   	<c:set var="spanIcon" 	value="icon_list"/> 
			            					</c:if>
										
											<c:if test="${ empty list.lv }">
			           						   	<c:set var="nextLv"	value="1"/>
			            					</c:if>
											
											<!-- 태그 열기 -->
											<c:choose>
												<c:when test="${list.lv gt prevLv}">
													<ul class="ul_${list.lv}">
														<li class="li_${list.lv}">
														<span class="${spanIcon}"></span>
														<a class="a_btn" id="${list.templateCd}" href="#" onclick="detCall('${list.templateCd}');">${list.templateNm}</a>
												</c:when>
												<c:when test="${list.lv eq prevLv}">
													<li class="li_${list.lv}">
													<span class="${spanIcon}"></span>
													<a class="a_btn" id="${list.templateCd}" href="#" onclick="detCall('${list.templateCd}');">${list.templateNm}</a>
												</c:when>
											</c:choose>

											<!-- 태그 닫기 -->										
											<c:choose>
												<c:when test="${list.lv gt nextLv}">
													</li>
													
													<c:forEach begin="1" end="${list.lv - prevLv}" varStatus="status">
														<c:if test="${list.lv ne '1'}">
																</ul>
															</li>
														</c:if>
													</c:forEach>
													
												</c:when>
												<c:when test="${list.lv eq nextLv}">
													</li>
												</c:when>
											</c:choose>
												
											<c:set var="prevLv" value="${list.lv}" />
										</c:forEach>
									</div>	
								</div>
								<div class="treeInfo" id="treeInfo">
									
								</div>
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
