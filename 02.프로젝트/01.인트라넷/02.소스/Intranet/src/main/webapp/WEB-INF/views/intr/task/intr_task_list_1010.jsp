<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1010.jsp" %>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
<script type="text/javascript">
	//
	var d = new Date();
	var today = getDateStamp(d);
	var addCnt = 0;
	//
	$(document).ready(function() {
		// 업무 삭제
		$(document).on("click", "#task_del", function() {
			$(this).parent().parent().remove();
		});
		
		// 오늘 지정
		var srchDt = "${param.srchDt}";
		if(srchDt=="") $("#srchSdt").val(today);
		
		// 데이터 조회
		if("${defaultList}" != null) {
			addTask(false); // 첫 시작
		} else {
			addTask(true); // 데이터 추가
		}
	});
	
	// 검색 조회
	function listCall(f){
		formSubmit("intrTaskInqy1010.do");
	}
	
	// 목록 추가
	function addTask(defYn) {
		var taskStr = "";
		// 추가 버튼
		if(defYn){
			//
			taskStr += "<tr class='setListTr'>";
			taskStr += 		"<td class='first_td'>";
			taskStr += 			"<span class='date'>" + today + "</span>";
			taskStr += 			"<input type='hidden' id='regDt' name='regDt' value='" + today.replaceAll('-','') + "'>"
			taskStr += 		"</td>";
			taskStr += 		"<td>";
			taskStr += 			"<input type='text' id='regTm" + "" + "' name='regTm' style='width: 60px; height:33px;' readonly>"
			taskStr += 		"</td>";
			taskStr += 		"<td>";
			taskStr += 			"<input type='text' id='taskCont' name='taskCont' value='' style='height: 33px; text-align: left; width: 100%;'>";
			taskStr += 		"</td>";
			taskStr += 		"<td>";
			taskStr += 			"<span id='task_del' class='task_del'></span>";
			taskStr += 		"</td>";
			taskStr += "</tr>";
			//
			
		} else {
			// 첫 시작
			if("${defaultList}" != null){
				//
				var defaultList = [];
				// 배열에 저장
			  	<c:forEach var="item" items="${defaultList}">
				  	defaultList.push({
				        regDt: "${item.regDt}",
				        regTm: "${item.regTm}",
				        taskCont: "${item.taskCont}"
				      });
  				</c:forEach>
				//
				for(var i=0;i<defaultList.length;i++) {
					//
					taskStr += "<tr class='setListTr'>";
					taskStr += 		"<td class='first_td'>";
					taskStr += 			"<span class='date'>" + defaultList[i].regDt + "</span>";
					taskStr += 			"<input type='hidden' id='regDt" + "" + "' name='regDt' value='" + defaultList[i].regDt + "'>"
					taskStr += 		"</td>";
					taskStr += 		"<td>";
					taskStr += 			"<input type='text' id='regTm' name='regTm' style='width: 60px; height:33px;' value='" + defaultList[i].regTm + "' readonly>"
					taskStr += 		"</td>";
					taskStr += 		"<td>";
					taskStr += 			"<input type='text' id='taskCont' name='taskCont' style='height: 33px; text-align: left; width: 100%;' value='" + defaultList[i].taskCont + "'>";
					taskStr += 		"</td>";
					taskStr += 		"<td>";
					taskStr += 			"<span id='task_del' class='task_del'></span>";
					taskStr += 		"</td>";
					taskStr += "</tr>";
					//
				}
			}
		}
		//
		$(".post_table_wrap .post_table").append(taskStr);
		
		// flatpickr 생성
	  	flatpickr("#regTm", {
	  		enableTime: true,     // 시간 선택 활성화
	  	    noCalendar: true,     // 달력 비활성화
	  	    dateFormat: "H:i",    // 시:분 형식
	  	    time_24hr: true       // 24시간제 (false면 AM/PM)
	  	});
		//
		addCnt++;
	}

	// 목록 초기화
	function initTask(f){
		//
		if(addCnt==0){
			alert("<spring:message code="TAKS.NONE"/>");
			return;
		}
		
		if(confirm("초기화하시겠습니까?")){
			//
			addCnt = 0;
			formSubmit('intrTaskInqy1010.do');
		}
	}
	
	// 목록 저장
	function regProc(f){
		//
		if(addCnt==0){
			alert("<spring:message code="TAKS.NONE"/>");
			return;
		}
		//
		var dataJson = [];
		var validate = true;
		//
		$(".setListTr").each(function(idx) {
			// JSON 저장
			var data = {};
			var regDt = $(this).find('input[name="regDt"]').val().replaceAll("-","");
			var regTm = $(this).find('input[name="regTm"]').val().replaceAll(":","");
			var taskCont = $(this).find('input[name="taskCont"]').val();
			//
			if(regTm == null || regTm == ""){
				alert((idx + 1) + "번째의 항목의 업무시간을 입력해주세요.");
				validate = false;
				return false;
			}
			if(taskCont == null || taskCont == ""){
				alert((idx + 1) + "번째의 항목의 업무내용을 입력해주세요.");
				validate = false;
				return false;
			}
			//
			data.regDt = regDt;
			data.regTm = regTm;
			data.taskCont = taskCont;
			data.empIdx = $("#empIdx").val();
			//
			dataJson.push(data);
		});
		// 유효성 검증
		if(!validate){
			return false;
		}
		//
		if(confirm("등록하시겠습니까?")){
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
											
									<h2>업무일지</h2><br>
									<div class="srch_wrap">
										<div class="srch_area">
											<label class="srch_label">작성일자</label>
											<input type="text" class="srch_cdt_date srchDt" id="srchSdt" name="srchDt" value="${param.srchDt}" readonly="readonly" />
										
											<input type="button"class="btn_blue" value="조회" onclick="listCall(this.form);">
										</div>
										
										<div class="srch_area float_right" style="padding-top: 25px;">
											<button type="button" class="btn_navy" onclick="addTask(true);">추가</button>
											<button type="button" class="btn_gray" onclick="initTask(this.form);">초기화</button>
											<button type="button" class="btn_blue" onclick="regProc(this.form);">저장</button>
										</div>
									</div>
									
									<div class="post_table_wrap">
										<table class="post_table">
											<caption>업무일지 목록</caption>
											<colgroup>
												<col class="w10per">
												<col class="w8per">
												<col class="wAutoper">
												<col class="w8per">
											</colgroup>
											<thead>
												<tr>
													<th scope="col">업무일자</th>
													<th scope="col">업무시간</th>
													<th scope="col">업무내용</th>
													<th scope="col">삭제</th>
												</tr>
											</thead>
											<tbody></tbody>
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