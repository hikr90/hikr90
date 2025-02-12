<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1010.jsp" %>

<head>
	<script type="text/javascript">
		// 첨부파일 수
		var fileCnt = "${defaultList.size()}" != null && "${defaultList.size()}" != "" ? "${defaultList.size()}" : 0;
		
		// 공지사항 등록 처리
		function regProc(f){
  			// 유효성 검증
			if(!validation()){return;};
			if(confirm("등록하시겠습니까?")){
				//
				var fileList = setFormData();
	   			$.ajax({
					url:"intrBoardProc1010.do",
					processData : false,
					contentType : false,
					data: fileList,
					type : 'post',
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
		
		// 목록으로
		function listCall() {
			formSubmit('intrBoardInqy1010.do');
		}
	</script>
</head>

<body id="main">
<form id="form" method="POST" enctype="multipart/form-data">
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
					<div class="sub_content">					
						<div class=" form_area">
							<input type="hidden" id="empIdx" name="empIdx"  value="${empVO.empIdx}">
							<input type="hidden" id="page" name="page" value="${param.page}">
							<input type="hidden" id="pageUrl" name="pageUrl" value="${param.pageUrl}">
							<input type="hidden" id="srchEdt" name="srchEdt" value="${param.srchEdt}">
							<input type="hidden" id="contId" name="contId" value="${defaultInfo.contId}">
							
							<div class="post_wrap">
								<h2>공지사항 등록</h2><br>
								<div class="post_view">
									<dl>
										<dt>
											<label for="post-title">제목</label>
										</dt>
										<dd style="width: 45%;">
											<input type="text" id="brdTitle" title="제목" name="brdTitle">
										</dd>
										<dt>부서</dt>
										<dd>${empVO.deptNm}</dd>
										<dt>작성자</dt>
										<dd>${empVO.empNm}</dd>
									</dl>
									<dl class="post_info">
										<dt>첨부 파일</dt>
										<dd>
											<div class="file_box">
												<label for="fileUpd">업로드</label>
												<h4 class="file_text">업로드할 파일을 선택해주세요.</h4>
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
											<textarea id="brdCont" title="내용" name="brdCont"></textarea>
										</dd>
									</dl>
								</div><!-- End post_write -->
								<div class="btn_wrap align_right">
										<button type="button" class="btn_navy_thin" onclick="regProc(this.form);">등록</button>
										<button type="button" class="btn_gray_thin" onclick="listCall();">취소</button>
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