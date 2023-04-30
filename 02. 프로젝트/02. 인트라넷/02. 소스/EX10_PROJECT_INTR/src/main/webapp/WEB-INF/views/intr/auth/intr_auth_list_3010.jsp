<!--명칭 : intr_auth_list_3010
	작성자 : 김태현
	작성일자 : 2023.01.31
	내용 : 사용자 권한 목록-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1010.jsp" %>

<!DOCTYPE html>
<html style="overflow: hidden;">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	//
	$(document).ready(function() {
		// 선택 항목 음영 처리
		$(document).on('click','.a_btn',function() {
			//
			$(".a_btn").each(function() {
				//
				$(this).removeClass('list_bg');
			});
			//
			$(this).addClass('list_bg');
		});	
		
		// 전체 선택 시 체크
		$(document).on('click','.totalIdx',function() {
			//
			var totalYn = $(this).is(':checked');
			$("input[name=empIdx]").each(function(){
				$(this).prop('checked',totalYn);
			});
		});	
			
		// 부서 체크 시 하위 자동 체크
		$(document).on('click','.deptCd',function() {
			//
			var deptYn = $(this).is(':checked');
			$("input[name=empIdx]").each(function(){
				$(this).prop('checked',deptYn);
			});
		});	
		
		// 권한 메뉴, 메뉴 목록 감춤
		$(".empArea").hide();
	});
	
	// 권한 조회
	function listCall(f){
		//
		var param = $("#form").serialize();
		$.ajax({
    		type : 'post',
        	url : 'intrAuthInqy1011.do',
            data : param,
            dataType : 'html',
            success : function(data){
            	//
            	$(".tree").html(data);
            	$(".empArea").hide();
            },
            error : function(data){
            	//
				alert("<spring:message code="comm.proc.error"/>");
            }
      	});
	}

	// 권한 상세보기
	function detCall(authCd){
		//
		var param = $("#form").serialize();
		$.ajax({
    		type : 'post',
        	url : 'intrAuthInqy3011.do',
            data : param,
            dataType : 'html',
            success : function(data){
     				//
            	    $(".empAuthInfo").html(data);
            	    $(".empArea").show();
            },
            error : function(data){
            	//
				alert("<spring:message code="comm.proc.error"/>");
            }
      	});
	}
</script>
</head>
<body id="main">
<form id="form">
	<!-- MENU -->
	<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1030.jsp" %>
	 
	<article id="_subArticle">
		<div class="_wrap">
			<div id="_content">
				<div id="sub_content" class="_inner">					
					<div class="_contentArea _formArea" style="margin-bottom: 0px;">
					
						<div class="postWrap" style="padding-top: 60px;">
							<h2>사용자 권한 관리</h2>
                                <div class="f-srchWrap">
									<div class="search_nav">
									<div class="srchArea">
										<label class="srcLabel">권한명</label>
										<input type="text" id="srchNm" name="srchNm" class="srch-cdt-text" value="${srchMap.srchNm}" onkeydown="pushListKey(this.form);">
									</div>
									<div class="srchArea cdtArea noLabel">                                
                                   		<input type="button" class="stb-box-btn" value="조회" onclick="listCall(this.form);">
                                	</div>
                                	</div>
                                </div>
                                <!-- end Form srchWrap  -->
								
								<div class="treeWrap">
									<div id="treeArea" class="treeArea" style="margin-bottom: 5%; width: 385px;">
										<div class="tree">
											<ul class="ul_1">
											<c:forEach var="list" items="${defaultList}" varStatus="status">
			           						   	<c:set var="spanIcon" 	value="icon_list"/> 
	
												<li class="li_1">
												<span class="${spanIcon}"></span>
												<a class="a_btn" id="${list.authCd}" href="#" onclick="detCall('${list.authCd}');">${list.authNm}</a>
											</c:forEach>
											</ul>
										</div>	
									</div>
									
									<div id="empArea" class="empArea" style="display: inline;">
										<div id="treeInfo" class="treeInfo empAuthInfo" style="width: 455px; margin-bottom: 5%; height: 448px; overflow: hidden;">
										
										</div>
									
										<div id="treeArrow" class="treeArrow" style="cursor: pointer; -webkit-transform: scaleX(-1);" onclick="moveBtn(this.form);"></div>
										<div id="treeInfo" class="treeInfo" style="border: solid 2px #f6f6f6; width: 450px; margin-left: 0px; margin-bottom: 5%; height: 445px; overflow: hidden;">
											<div class="tree">
												<ul class="ul_1">
													<li class="li_1">
														<input type="checkbox" id="totalIdx" class="totalIdx" name="totalIdx">
														전체 선택
													</li>
																				
												<c:forEach var="list" items="${empList}" varStatus="status">
													<c:set var="spanIcon"	value="icon_folder"/>
													<c:set var="listNm"		value="${list.deptNm}"/>
													<c:set var="nextLv"		value=""/>
													<c:set var="prevLv"		value=""/>
												
													<c:if test="${list.isleaf eq 'Y'}">
					           						   	<c:set var="spanIcon" 	value="icon_list"/> 
					           						   	<c:set var="listNm" 	value="${list.empNm}"/> 
					            					</c:if>
												
													<c:if test="${ empty list.lv }">
					           						   	<c:set var="nextLv"	value="1"/>
					            					</c:if>
													
													<!-- 태그 열기 -->
													<c:choose>
														<c:when test="${list.lv gt prevLv}">
															<ul class="ul_${list.lv}">
																<li class="li_${list.lv}">
																<input type="checkbox" id="empIdx" class="<c:if test="${list.isleaf eq 'N'}">deptCd</c:if><c:if test="${list.isleaf eq 'Y'}">empIdx</c:if>" name="empIdx" value="${list.empIdx}" empNm="${list.empNm}" deptNm="${list.deptNm}">
																<span class="${spanIcon}"></span>
																${listNm}
														</c:when>
														<c:when test="${list.lv eq prevLv}">
															<li class="li_${list.lv}">
															<input type="checkbox" id="empIdx" class="<c:if test="${list.isleaf eq 'N'}">deptCd</c:if><c:if test="${list.isleaf eq 'Y'}">empIdx</c:if>" name="empIdx" value="${list.empIdx}" empNm="${list.empNm}" deptNm="${list.deptNm}">
															<span class="${spanIcon}"></span>
															${listNm}
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
									</div> <!-- EMP AREA -->
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
