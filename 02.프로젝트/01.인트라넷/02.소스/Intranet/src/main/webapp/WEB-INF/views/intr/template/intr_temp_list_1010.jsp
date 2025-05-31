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
	});

	// 기안문 양식 조회
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
            	$(".tree_info").html("");
            	$(".tree").html(data);
            	setTree("tree_area");
            },
            error : function(data){
            	//
				alert("<spring:message code="PROC.ERROR"/>");
            }
      	});
	}

	// 기안문 양식 등록
	function regCall() {
		//
		$.ajax({
    		type : 'post',
        	url : 'intrTempInqy1030.do',
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
	
	// 기안문 양식 등록 처리
	function regProc(){
		// 에디터 내용 저장
		var editCont = CKEDITOR.instances.editor.getData();
		if(editCont.trim()!=null && editCont.trim()!=''){
			$("#editor").val(editCont);
		}

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
	
	// 기안문 양식 상세보기
	function detCall(templateCd){
		//
		$("#templateCd").val(templateCd);
		var param = $("#form").serialize();
		//
		$.ajax({
    		type : 'post',
        	url : 'intrTempInqy1020.do',
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
	
	// 기안문 양식 수정 처리
	function modProc(f){
		// 유효성 검증
		if(!validation()){return;};
		//
		if(confirm("수정하시겠습니까?")){
			//
			var editCont = CKEDITOR.instances.editor.getData();
			$("#editor").val(editCont);
			//
			var param = $("#form").serialize();
			$.ajax({
	    		type : 'post',
	        	url : 'intrTempProc1020.do',
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
	
	// 기안문 양식 삭제 처리
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
	<!-- 정보 찾기 -->
 	<div id="popupArea" class="popup_area hidden">
		<c:import url="/WEB-INF/views/intr/comm/popup/intr_popup_inqy_1010.jsp"></c:import>	
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
									<input type="hidden" id="templateCd" name="templateCd" value="0">
									<input type="button"class="listCall" onclick="listCall(this.form);" style="display: none;">
								
									<h2>기안문 양식 관리</h2><br>
									
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
										<div class="tree_area mr20" id="tree_area" style="width: 715px; height: 746px;"> 
											<div class="tree">
												<ul class="ul_1">
												<c:forEach var="list" items="${defaultList}" varStatus="status">
				           						   	<c:set var="spanIcon" 	value="icon_list"/> 
		
													<li class="li_1">
													<span class="${spanIcon}"></span>
													<a class="a_btn" id="${list.templateCd}" href="javascript:" onclick="detCall('${list.templateCd}');">${list.templateNm}</a>
												</c:forEach>
												</ul>
											</div>
										</div>
										
										<div class="tree_info" id="tree_info"></div>
									</div>
								</div><!-- End post_wrap -->
							</div><!-- End content_area form_area -->
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

