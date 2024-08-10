<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1010.jsp" %>

<script type="text/javascript">
	//
	var addCnt = 0;
	//
	$(document).ready(function() {
		// 업무 삭제
		$(document).on("click", "#task_del", function() {
			$(this).parent().parent().remove();
		});
		//
	});
	
	// 목록 추가
	function addTask(f) {
		// 일자 값 생성
		var d = new Date();
		var time = getTimeStamp(d);
		var today = getDateStamp(d);
		// 문구 추가
		var taskStr = "";
		//
		taskStr += "<tr class='setListTr'>";
		taskStr += 		"<td class='first_td'>";
		taskStr += 			"<span class='date'>" + today + " " + time + "</span>";
		taskStr += 			"<input type='hidden' id='regDt' name='regDt' value='" + today.replaceAll('-','') + "'>"
		taskStr += 			"<input type='hidden' id='regTm' name='regTm' value='" + time.replaceAll(':','') + "'>"
		taskStr += 		"</td>";
		taskStr += 		"<td>";
		taskStr += 			"<input type='text' id='taskCont' name='taskCont' value='' style='height: 33px; text-align: left; width: 100%;'>";
		taskStr += 		"</td>";
		taskStr += 		"<td>";
		taskStr += 			"<span id='task_del' class='task_del'></span>";
		taskStr += 		"</td>";
		taskStr += "</tr>";
		//
		addCnt++;
		$(".post_table_wrap .post_table").append(taskStr);
	}

	// 목록 초기화
	function initTask(f){
		//
		addCnt = 0;
		formSubmit('intrTaskInqy1010.do');
	}
	
	// 목록 저장
	function regProc(f){
		//
		if(addCnt==0){
			alert("<spring:message code="TAKS.NONE"/>");
			return;
		}
		//
		if(confirm("등록하시겠습니까?")){
			//
			var dataJson = [];
			//
			$(".setListTr").each(function() {
				// JSON 저장
				var data = {};
				data.regDt = $(this).find('input[name="regDt"]').val();
				data.regTm = $(this).find('input[name="regTm"]').val();
				data.taskCont = $(this).find('input[name="taskCont"]').val();
				data.empIdx = $("#empIdx").val();
				//
				dataJson.push(data);
			});
			//
			$.ajax({
			    	type : 'post',
			    	url : "intrTaskProc1010.do",
					data : JSON.stringify(dataJson),
					dataType : 'text',
		    		contentType : 'application/json;charset=UTF-8',
				success : function(data){
			    	//
   					var json = eval(data);
   					if(json[0].res=="YES"){
   	   					//
	  					addCnt = 0;
   	   					//
   						alert("<spring:message code="PROC.SUCCESS"/>");
   						formSubmit('intrTaskInqy1010.do');
   					} else {
   						//
   						alert("<spring:message code="PROC.FAIL"/>");
   					}
				},
				error : function(xhr, status, error){
			    	//
					alert("<spring:message code="PROC.ERROR"/>");				
			    }
			});
		}
	}
</script>
<body id="main">
<form id="form" name="form" method="POST" onsubmit="return false;">
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
									<input type="hidden" id="page" name="page" value="${param.page}">
									<input type="hidden" id="pageUrl" name="pageUrl" value="${param.pageUrl}">
									<input type="hidden" id="empIdx" name="empIdx" value="${empVO.empIdx}">						
									
									<h2>업무 일지 작성</h2><br>
									<div class="srch_wrap">
										<div class="align_center">
											<button type="button" class="btn_navy" onclick="addTask(this.form);">추가</button>
											<button type="button" class="btn_gray" onclick="initTask(this.form);">초기화</button>
		                                	<button type="button" class="btn_blue float_right" onclick="regProc(this.form);">저장</button>
										</div>
									</div>
									
									<div class="post_table_wrap">
										<table class="post_table">
											<caption>업무일지 목록</caption>
											<colgroup>
												<col class="w15per">
												<col class="wAutoper">
												<col class="w8per">
											</colgroup>
											<thead>
												<tr>
													<th scope="col">작성일</th>
													<th scope="col">업무</th>
													<th scope="col">삭제</th>
												</tr>
											</thead>
											<tbody>
												<c:if test="${not empty defaultList}">
												<c:forEach var="list" items="${defaultList}" varStatus="status"> 
												<tr class='setListTr'>
													<td class="first_td">
														<span class="date">
															<fmt:parseDate value="${list.regDtTm}" var="parseDtTm" pattern="yyyyMMddHHmmss"/>
															<fmt:formatDate value="${parseDtTm}" var="fomatDtTm" pattern="yyyy-MM-dd HH:mm:ss"/>
															${fomatDtTm} 
		
															<input type="hidden" id='regDt' name="regDt" value="${list.regDt}">
															<input type="hidden" id='regTm' name="regTm" value="${list.regTm}">
														</span>
													</td>
													<td>
														<input type="text" id="taskCont" name="taskCont" value="${list.taskCont}" style="height: 33px; text-align: left; width: 100%;">
													</td>
													<td>
														<span id="task_del" class="task_del"></span>
													</td>
		                                        </tr>
		                                        </c:forEach>
		                                        </c:if>
											</tbody>
										</table>
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

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1020.jsp" %>	