<!--명칭 : intr_task_inqy_2010
	작성자 : 김태현
	작성일자 : 2023.06.13
	내용 : 사용자 업무일지 작성 화면-->
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
		$(document).on("click", "#taskDel", function() {
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
		taskStr += 		"<td class='first-td'>";
		taskStr += 			"<span class='date'>" + today + " " + time + "</span>";
		taskStr += 			"<input type='hidden' id='regDt' name='regDt' value='" + today.replaceAll('-','') + "'>"
		taskStr += 			"<input type='hidden' id='regTm' name='regTm' value='" + time.replaceAll(':','') + "'>"
		taskStr += 		"</td>";
		taskStr += 		"<td>";
		taskStr += 			"<input type='text' id='taskContent' name='taskContent' value='' style='height: 33px; text-align: left; width: 100%;'>";
		taskStr += 		"</td>";
		taskStr += 		"<td>";
		taskStr += 			"<span id='taskDel' class='taskDel'></span>";
		taskStr += 		"</td>";
		taskStr += "</tr>";
		//
		addCnt++;
		$(".postTable").append(taskStr);
	}

	// 목록 초기화
	function initTask(f){
		//
		addCnt = 0;
		formSubmit('intrTaskInqy2010.do');
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
				data.taskContent = $(this).find('input[name="taskContent"]').val();
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
   						formSubmit('intrTaskInqy2010.do');
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
	<!-- MENU -->
	<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1030.jsp" %>
	
	<form id="form" name="form" method="POST" onsubmit="return false;">
	<article id="_subArticle">
		<div class="_wrap">
			<div id="_content">
				<div id="sub_content" class="_inner">					
					<div class="_contentArea _formArea">
						<!-- Form srchWrap  -->
						<div class="listWrap">
						</div><!-- End listWrap -->
						<!-- Form postWrap  -->
						<div class="postWrap" style="height: 710px;">
							<h2>업무 일지 작성</h2>
							<div class="f-srchWrap">
								<div class="alignC">
									<input type="hidden" id="empIdx" name="empIdx" value="${empVO.empIdx}">
								
									<input type="button" class="stb-box-btn-grey" value="추가" onclick="addTask(this.form);" style="margin-top: 1px;">
									<input type="button" class="stb-box-btn" value="초기화" onclick="initTask(this.form);">
                                	<input type="button" class="stb-box-btn" value="저장" onclick="regProc(this.form);" style="float: right;">
								</div>
							</div>
							
							<div class="postTableWrap">
							<div class="scrollTableWrap" style="height: 520px;">
								<table class="postTable">
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
										<c:if test="${ not empty defaultList }">
										<c:forEach var="list" items="${defaultList}" varStatus="status"> 
										<tr class='setListTr'>
											<td class="first-td">
												<span class="date">
													<fmt:parseDate value="${list.regDtTm}" var="parseDtTm" pattern="yyyyMMddHHmmss"/>
													<fmt:formatDate value="${parseDtTm}" var="fomatDtTm" pattern="yyyy-MM-dd HH:mm:ss"/>
													${fomatDtTm} 

													<input type="hidden" id='regDt' name="regDt" value="${list.regDt}">
													<input type="hidden" id='regTm' name="regTm" value="${list.regTm}">
												</span>
											</td>
											<td>
												<input type="text" id="taskContent" name="taskContent" value="${list.taskContent}" style="height: 33px; text-align: left; width: 100%;">
											</td>
											<td>
												<span id="taskDel" class="taskDel"></span>
											</td>
                                        </tr>
                                        </c:forEach>
                                        </c:if>
									</tbody>
								</table>
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