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
	//
	$(document).ready(function() {
		// 선택 항목 음영 처리
		$(document).on('click','.a_btn',function() {
			//
			$(".a_btn").each(function() {
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
		$("#menuArea").css("display","none");
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
            	$("#authTree").html(data);
            	$("#menuArea").css("display","inline-flex");
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
            	    $("#authInfo").html(data);
            	    $("#menuArea").css("display","inline-flex");
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
<form id="form" onsubmit="return false;">
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
									<input type="hidden" id="authCd" name="authCd" value="">
								
									<h2>메뉴 권한 부여</h2><br>
	                                <div class="srch_wrap">
										<div class="right_srch_area">
											<!-- 제목 -->
											<div class="srch_area">
												<label class="srch_label">제목</label>		
												<input type="text" id="srchNm" name="srchNm" class="srch_cdt_text" value="${resultParam.srchNm}" onkeydown="pushListKey(this.form);">
											
												<input type="button"class="btn_blue" value="조회" onclick="listCall(this.form);">
											</div>
	                                	</div>
	                                </div>
										
									<div class="tree_wrap mt20" style="height: 500px;">
										<div id="tree_area" class="tree_area">
											<div id="authTree" class="tree">
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
											
										<div id="menuArea" class="menu_area" style="display: none;">
											<!-- 권한 메뉴 목록 -->
											<div id="menuInfo" class="tree_info ml20" style="width: 450px; height: 425px;">
												<div class="post_wrap">
													<div class="scroll_wrap">
														<table class="post_table menuTbl">
															<caption>권한 목록 테이블</caption>
															<colgroup>
																<col class="w7per">
																<col class="w30per">
															</colgroup>
															<thead>
																<tr>
																	<th scope="col">
																		<span class="check_box">
																			<input type="checkbox" class="check_box menuChk"> 
																			<label for="chk-yes"><span></span></label>
																		</span>
																	</th>
																	<th scope="col">메뉴명</th>
																</tr>
															</thead>
															<tbody>
										                       	<c:forEach var="list" items="${tMenuList}" varStatus="status"> 
																<tr>
																	<td class="first_td">
								                                       <span class="check_box">
																			<input type="checkbox" class="check_box" id="menuCd" name="menuCd" value="${list.menuCd}" menuNm="${list.menuNm}" menutypeCd="${list.menutypeCd}" menuLv="${list.lv}"> 
																			<label for="chk-yes"><span></span></label>
																		</span>
																	</td>
																	<td class="align_left">
																		<c:if test="${list.lv ne '1'}">&nbsp;&nbsp;ㄴ</c:if>
																		${list.menuNm}
																	</td>
																</tr>
								                                </c:forEach>
															</tbody>
														</table>
													</div>
												</div><!-- End post_wrap -->
											</div>
											
											<!-- 화살표 -->
											<div id="treeArrow" class="tree_arrow" onclick="moveBtn(this.form);"></div>
											
											<!-- 권한 목록 -->
											<div id="authInfo" class="tree_info" style="width: 450px; height: 425px;"></div>
										</div> <!-- End menu_area -->
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
