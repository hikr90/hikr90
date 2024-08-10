<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1010.jsp" %>

<script type="text/javascript">
	// 첨부파일 수
	var fileCnt = "${defaultList.size()}" != null && "${defaultList.size()}" != "" ? "${defaultList.size()}" : 0;
	
	// 취소
	function detCall() {
		formSubmit('intrBoardInqy1030.do');
	}
	
	// 수정 처리
	function modProc(f){
		// 유효성 검증
		if(!validation()){return;};
		var fileList = setFormData();
		//
		if(confirm("수정하시겠습니까?")){
			// 
   			$.ajax({
				url:"intrBoardProc1030.do",
				processData : false,
				contentType : false,
				data: fileList,
				type : 'POST',
   				success : function(data){
   						//
   						var json = eval(data);
   						if(json[0].res=='YES'){
   	   						//
   							alert("<spring:message code="PROC.SUCCESS"/>");
	   						location.href = "intrBoardInqy1010.do?pageUrl=Board";
	   						
   						}else if(json[0].res=='NO'){
   	   						//
   							alert("<spring:message code="PROC.FAIL"/>");
							return;	   							
   						}else{
   	   						//
   							alert("<spring:message code="PROC.EXISTS"/>");
							return;	   							
   						}
   				},
   				error : function(res, status, error){
   					//
   					alert("<spring:message code="PROC.ERROR"/>");
   				}
   			});
		}
	}	

</script>
</head>
<body id="main">
<form method="POST" enctype="multipart/form-data" id="form">
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
							<div class="content_area form_area">
								<input type="hidden" id="empIdx" name="empIdx" value="${defaultInfo.empIdx}">
								<input type="hidden" id="contId" name="contId" value="${defaultInfo.contId}">
								<input type="hidden" id="page" name="page" value="${param.page}">
								<input type="hidden" id="pageUrl" name="pageUrl" value="${param.pageUrl}">
								<input type="hidden" id="srchNm" name="srchNm" value="${param.srchNm}">
								<input type="hidden" id="srchSdt" name="srchSdt" value="${param.srchSdt}">
								<input type="hidden" id="deptCd" name="deptCd" value="${param.deptCd}">
								<input type="hidden" id="gradeCd" name="gradeCd" value="${param.gradeCd}">
								<input type="hidden" id="deptNm" name="deptNm" value="${param.deptNm}">
								<input type="hidden" id="gradeNm" name="gradeNm" value="${param.gradeNm}">
								<input type="hidden" id="srchEdt" name="srchEdt" value="${param.srchEdt}">
								<input type="hidden" id="contId" name="contId" value="${defaultInfo.contId}">
								
								<div class="post_wrap">
									<h2>공지사항 수정</h2><br>
									<div class="post_write">
										<dl>
											<dt><label for="post-title">제목</label></dt>
											<dd><input type="text" id="brdTitle" name="brdTitle" title="제목" value="${defaultInfo.brdTitle}"></dd>
											<dt>부서</dt>
											<dd>${defaultInfo.deptNm}</dd>									
											<dt>작성자</dt>
											<dd>${defaultInfo.empNm}</dd>
										</dl>
										<dl class="post_info">
											<dt>첨부 파일</dt>
											<dd>
												<div class="file_box">
													<label for="fileUpd">업로드</label>
													<h4 class="file_text">파일을 클릭하여, 업로드 대상 포함 여부를 선택 가능합니다.</h4>
													<input type="file" id="fileUpd" name="fileUpd" class="btn_blue">
												</div>
											</dd>
										</dl>
										
										<dl class="post_info">
											<dt></dt>
											<dd class="post_file">
												<div class="file_wrap">
													<!-- 파일 목록 -->
													<c:import url="/WEB-INF/views/intr/comm/include/intr_include_1040.jsp">
														<c:param name="fileNm"></c:param>
													</c:import>
												</div>
											</dd>
										</dl>
										
										<dl>
											<dt><label for="post_text">내용</label></dt>
											<dd class="post_text">
												<textarea id="post_text" name="brdCont" title="내용">${defaultInfo.brdCont}</textarea>
											</dd>
										</dl>
									</div><!-- End post_write -->
									<div class="btn_wrap align_right">
											<button type="button" class="btn_navy_thin" onclick="modProc(this.form);">수정완료</button>
											<button type="button" class="btn_gray_thin" onclick="detCall();">취소</button>
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