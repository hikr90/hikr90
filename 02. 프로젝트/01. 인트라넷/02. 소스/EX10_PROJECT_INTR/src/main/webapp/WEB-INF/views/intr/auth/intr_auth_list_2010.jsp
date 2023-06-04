<!--명칭 : intr_auth_list_2010
	작성자 : 김태현
	작성일자 : 2023.01.26
	내용 : 메뉴 권한 목록-->
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
			})
			//
			$(this).addClass('list_bg');
		});
		
		// 권한 메뉴 목록 전체 체크
		$('.menuChk').click(function() {
			if($(".menuChk").is(":checked")){
				$("input[name=menuCd]").prop("checked", true);
		    } else {
		    	$("input[name=menuCd]").prop("checked", false);	
		    }
		});
		
		// 권한 메뉴, 메뉴 목록 감춤
		$(".menuArea").hide();
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
            	$(".menuArea").hide();
            },
            error : function(data){
            	//
				alert("<spring:message code="PROC.ERROR"/>");
            }
      	});
	}

	// 권한 상세보기
	function detCall(authCd){
		//
		$("#authCd").val(authCd);
		var param = $("#form").serialize();
		//
		$.ajax({
    		type : 'post',
        	url : 'intrAuthInqy2011.do',
            data : param,
            dataType : 'html',
            success : function(data){
     				//
            	    $(".menuAuthInfo").html(data);
            	    $(".menuArea").show();
            },
            error : function(data){
            	//
				alert("<spring:message code="PROC.ERROR"/>");
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
							<input type="hidden" id="authCd" name="authCd" value="">
						
							<h2>메뉴 권한 관리</h2>
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
									
									<div id="menuArea" class="menuArea" style="display: inline;">
									<div id="treeInfo" class="treeInfo menuAuthInfo" style="width: 455px; margin-bottom: 5%; height: 448px; overflow: hidden;">
										
									</div>
									
									<div id="treeArrow" class="treeArrow" style="cursor: pointer; -webkit-transform: scaleX(-1);" onclick="moveBtn(this.form);"></div>
									<div id="treeInfo" class="treeInfo" style="width: 455px; margin-left: 0px; margin-bottom: 5%; height: 468px; overflow: hidden;">
										<div class="postWrap">
											<div class="scrollTableWrap" style="height: 518px;">
												<table class="postTable menuTbl" style="">
													<caption>권한 목록 테이블</caption>
													<colgroup>
														<col class="w7per">
														<col class="w30per">
													</colgroup>
													<thead>
														<tr>
															<th scope="col">
																<span class="_chkBox">
																	<input type="checkbox" class="checkbox menuChk"> 
																	<label for="chk-local"><span></span></label>
																</span>
															</th>
															<th scope="col">메뉴명</th>
														</tr>
													</thead>
													<tbody>
								                       	<c:forEach var="list" items="${tMenuList}" varStatus="status"> 
														<tr>
															<td class="first-td">
						                                       <span class="_chkBox">
																	<input type="checkbox" class="checkbox" id="menuCd" name="menuCd" value="${list.menuCd}" menuNm="${list.menuNm}" menutypeCd="${list.menutypeCd}" menuLv="${list.lv}"> 
																	<label for="chk-local"><span></span></label>
																</span>
															</td>
															<td style="text-align: left;">
																<c:if test="${list.lv ne '1'}">&nbsp;&nbsp;ㄴ</c:if>
																${list.menuNm}
															</td>
														</tr>
						                                </c:forEach>
													</tbody>
												</table>
											</div>
										</div><!-- End postWrap -->
									</div>
									</div> <!-- MENU AREA -->
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
