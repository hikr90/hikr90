<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1010.jsp" %>

<head>
	<script type="text/javascript">
		//
		$(document).ready(function(){
			$("#dmlProc").change(function(){
				// 체크에따라서 버튼명 변경
				if($(this).is(":checked")) {
					$(".listCall").val("처리");
				} else {
					$(".listCall").val("조회");
				}
			})
		});
	
		// 쿼리 입력 유효성 검증
		function validate(query){
			//
			var chkYn = true;
			var dmlPatn = ["merge","insert","update","delete"];
			var chkDml = dmlPatn.some(word => query.includes(word));
			
			// 쿼리 미 입력 시
			if(query == '' || query == null){
				alert("<spring:message code="QUERY.NONE"/>");
				return false;
			}
			
			// DML 처리 체크되어있지 않은 경우
			if(!$('#dmlProc').is(':checked')) {
				// 쿼리 내 where절 없을 시
				if(query.indexOf('where') < 0){
					alert("<spring:message code="QUERY.WHERE.DISABLE"/>");
					return false;
				}
				// 쿼리 내 dml 문장이 존재하는 경우
				if(chkDml){
					alert("<spring:message code="QUERY.NOT.DML"/>");
					return false;
				}
			}
			//
			return chkYn;
		}
	
		// 쿼리 조회
		function listCall(f){
			// 유효성 검증
			var query = $("#query").val().toLowerCase();
			var param = $("#form").serialize();
			if(!validate(query)) return;
			//
			var url = "intrQueryInqy1020.do";
			if($('#dmlProc').is(':checked')) url = "intrQueryProc1010.do"
			//
			$.ajax({
	    		type : 'post',
	        	url : url,
	            data : param,
	            dataType : 'html',
	            success : function(data){
	            	// 반환 데이터가 있는 경우
	            	if(data != null && data != ''){
	            		// DML 체크
	            		if($('#dmlProc').is(':checked')) {
	            			//
	            			var json = eval(data);
	            			var resInt = json[0].resInt;
							//	  DML 처리	
							if(resInt > 0) {
								alert("쿼리가 수행되었습니다.\n총 " + resInt + "건의 데이터가 처리되었습니다.");
							} else {
								alert("수행된 작업이 없습니다.\n작성하신 쿼리를 확인해주세요.");
							}
	            			
	            		} else {
	            			// SELECT 처리
	            			$("#queryResult").html(data);
	            		}
	            		
	            	} else {
	            		// 쿼리 수행 오류
	            		alert("<spring:message code="QUERY.RES.ERROR"/>");
	            	}
	            },
	            error : function(data){
	            	//
					alert("<spring:message code="PROC.ERROR"/>");
	            }
	      	});
		}
		
		// 엑셀 다운로드
		function excelDown(){
			// 유효성 검증
			var query = $("#query").val().toLowerCase();
			var param = $("#form").serialize();
			if(!validate(query)) return;
			//
			formSubmit("intrQueryInqy1030.do");
		}
	</script>
</head>
<body id="main">
<form id="form" method="POST">
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
									<input type="hidden" id="headTit" name="headTit" value="쿼리 조회 목록">
		                            
		                            <h2>쿼리 입력
										<span class="float_right">
												<input type="button"class="btn_green_thin" value="Excel" onclick="excelDown();">
											<input type="button"class="btn_blue_thin listCall" value="조회" onclick="listCall();">
										</span>
									</h2>
									<span style="font-size: 1.6rem; float: right; margin: 10px;">
										<input type="checkbox" id="dmlProc" class="dmlProc" name="dmlProc" style="width: 15px; height: 15px; vertical-align: middle;">DML 처리
									</span><br>
									
									<!-- 쿼리 입력 -->
									<div id="queryInput" class="query_input">
										<textarea id="query" class="query" name="query" ></textarea>
									</div>
									
									<!-- 결과 조회 -->
									<div id="queryResult" class="post_table_wrap">
										
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
