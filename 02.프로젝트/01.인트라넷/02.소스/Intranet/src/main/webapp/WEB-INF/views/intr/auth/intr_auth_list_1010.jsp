<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 	uri="http://java.sun.com/jsp/jstl/core" %>
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
			});
			//
			$(this).addClass('list_bg');
		});
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
            	$(".tree_info").html("");
            },
            error : function(data){
            	//
				alert("<spring:message code="PROC.ERROR"/>");
            }
      	});
	}

	// 권한 등록
	function regCall() {
		//
		$.ajax({
    		type : 'post',
        	url : 'intrAuthInqy1020.do',
            data : null,
            dataType : 'html',
            success : function(data){
     				//
            	    $(".tree_info").html(data);
     				$(".a_btn").each(function() {
        				$(this).removeClass('list_bg');
        			});
            },
            error : function(data){
            	//
				alert("<spring:message code="PROC.ERROR"/>");
            }
      	});
	}
	
	// 권한 등록 처리
	function regProc(){
		// 유효성 검증
		if(!validation()){return;};
		//
		var param = $("#form").serialize();
		if(confirm("등록하시겠습니까?")){
			//		
			$.ajax({
	    		type : 'post',
	        	url : 'intrAuthProc1010.do',
	            data : param,
	            dataType : 'html',
	            success : function(data){
	     				//
	            	    $(".tree_info").html(""); // 등록 화면 초기화
	    				alert("<spring:message code="PROC.SUCCESS"/>"); // ALERT
	    				
	    				// 재 조회
	            		$(".listCall").trigger("click");	
	            },
	            error : function(data){
	            	//
					alert("<spring:message code="PROC.ERROR"/>");
	            }
	      	});
		}		
	}
	
	// 권한 상세보기
	function detCall(authCd){
		//
		$("#authCd").val(authCd);
		//
		var param = $("#form").serialize();
		$.ajax({
    		type : 'post',
        	url : 'intrAuthInqy1030.do',
            data : param,
            dataType : 'html',
            success : function(data){
     				//
            	    $(".tree_info").html(data);
            },
            error : function(data){
            	//
				alert("<spring:message code="PROC.ERROR"/>");
            }
      	});
	}
	
	// 권한 수정화면
	function modCall(f){
		//
		var param = $("#form").serialize();
		$.ajax({
    		type : 'post',
        	url : 'intrAuthInqy1040.do',
            data : param,
            dataType : 'html',
            success : function(data){
     				//
            	    $(".tree_info").html(data);
            },
            error : function(data){
            	//
				alert("<spring:message code="PROC.ERROR"/>");
            }
      	});
	}
	
	// 권한 수정 처리
	function modProc(f){
		// 유효성 검증
		if(!validation()){return;};
		//
		var param = $("#form").serialize();
		if(confirm("수정하시겠습니까?")){
			//		
			$.ajax({
	    		type : 'post',
	        	url : 'intrAuthProc1020.do',
	            data : param,
	            dataType : 'html',
	            success : function(data){
	     				//
	            	    $(".tree_info").html(""); // 등록 화면 초기화
	    				alert("<spring:message code="PROC.SUCCESS"/>");
	    				
	    				// 재 조회
	            		$(".listCall").trigger("click");	
	            },
	            error : function(data){
	            	//
					alert("<spring:message code="PROC.ERROR"/>");
	            }
	      	});
		}		

	}
	
	// 권한 삭제 처리
	function delProc(f){
		if(!validation()){return;};
		//
		var param = $("#form").serialize();
		if(confirm("삭제하시겠습니까?")){
			//		
			$.ajax({
	    		type : 'post',
	        	url : 'intrAuthProc1030.do',
	            data : param,
	            dataType : 'html',
	            success : function(data){
	     				//
	            	    $(".tree_info").html(""); // 등록 화면 초기화
	    				alert("<spring:message code="PROC.SUCCESS"/>");
	    				
	    				// 재 조회
	            		$(".listCall").trigger("click");	
	            },
	            error : function(data){
	            	//
					alert("<spring:message code="PROC.ERROR"/>");
	            }
	      	});
		}
	}
</script>
</head>
<body id="main">
<form id="form" name="form" onsubmit="return false;">
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
								<input type="hidden" id="authCd" name="authCd" value="0">
								<input type="button"class="listCall" onclick="listCall(this.form);" style="display: none;">
								
									<h2>권한 관리
										<span class="float_right">
											<input type="button"class="btn_navy_thin" value="등록" onclick="regCall();">
										</span>
									</h2><br>
									
		                            <div class="srch_wrap">
		                            	<div class="right_srch_area">
											<!-- 제목 -->
											<div class="srch_area">
												<label class="srch_label">제목</label>		
												<input type="text" id="srchNm" name="srchNm" class="srch_cdt_text" value="${param.srchNm}" onkeydown="pushListKey(this.form);">
											
												<input type="button"class="btn_blue" value="조회" onclick="listCall(this.form);">
												<input type="button"class="btn_gray" value="초기화" onclick="initCall();">
											</div>
										</div>
		                            </div>
									
									<div class="tree_wrap">
										<div class="tree_area" id="tree_area" style="width: 400px;"> 
											<div class="tree">
												<ul class="ul_1">
													<c:forEach var="list" items="${defaultList}" varStatus="status">
					           						   	<c:set var="spanIcon" 	value="icon_list"/> 
			
														<li class="li_1" style="margin-left: 15px;">
														<span class="${spanIcon}"></span>
														<a class="a_btn" id="${list.authCd}" href="#" onclick="detCall('${list.authCd}');">${list.authNm}</a>
													</c:forEach>
												</ul>
											</div>	
										</div>
										<div class="tree_info pl20" id="tree_info" style="width: 1120px;"></div>
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
