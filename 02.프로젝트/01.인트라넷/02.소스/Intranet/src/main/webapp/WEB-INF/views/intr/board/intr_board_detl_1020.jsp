<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1010.jsp" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript">
		// 공지사항 등록 처리
		function regProc(f){
  			// 유효성 검증
			if(!validation()){return;};
			//
			if(confirm("등록하시겠습니까?")){
				var fileList = setFileList();
				//
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
		   						location.href = "intrBoardInqy1010.do";
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
	<form id="form" method="POST" enctype="multipart/form-data">
	<!-- MENU -->
	<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1030.jsp" %>
		
	<article id="_subArticle">
		<div class="_wrap">
			<div id="_content">
				<div id="sub_content" class="_inner" style="padding-top: 40px;">					
					<div class="_contentArea _formArea">
					<div class="postCon">
						<input type="hidden" id="empIdx" name="empIdx"  value="${empVO.empIdx}">
						<input type="hidden" id="modCnt" name="modCnt" value="0">
						
						<div class="postWrap">
							<!-- Form postWriteWrap  -->
							<h2>공지사항 등록</h2>
							<div class="postWrite">
								<dl>
									<dt><label for="post-title">제목</label></dt>
									<dd style="width: 45%;">
										<input type="text" id="brdTitle" title="제목" name="brdTitle">
									</dd>
									<dt>부서</dt>
									<dd>${empVO.deptNm}</dd>
									<dt>작성자</dt>
									<dd>${empVO.empNm}</dd>
								</dl>
								<dl class="post-info">
									<dt>첨부 파일</dt>
									<dd>
										<div class="fileUpdBox">
											<label for="fileUpd">업로드</label>
											<input type="file" name="fileUpd" id="fileUpd">
											<label for="fileDel" style="background-color:  #575757;">삭제</label>
											<input type="button" id="fileDel" name="fileDel" value="삭제" style="display: none;">
										</div>
									</dd>
								</dl>
								<dl class="post-info">
									<dt></dt>
									<dd class="post_file">
										<div class="scrollFileWrap">
											<ul>
												<li> 
													<input type="checkbox" class="_chkBox everyChk" id="everyChk" name="everyChk" style="vertical-align: middle;">
													<span style="font-size: 1.6rem; font-weight: 700; font-family: NanumSquare">전체 선택</span>
												</li>
											</ul>
											<c:import url="/WEB-INF/views/intr/comm/include/intr_include_1040.jsp">
												<c:param name="fileNm"></c:param>
											</c:import>
										</div>
									</dd>
								</dl>
								<dl>
									<dt><label for="post_text">내용</label></dt>
									<dd class="post_text">
										<textarea id="brdContent" title="내용" name="brdContent"></textarea>
									</dd>
								</dl>
							</div><!-- End postWriteWrap -->
							<div class="btnWrap alignR">
									<input type="button" class="_btn _grey" onclick="regProc(this.form);" value="등록">
									<a onclick="location.href='intrBoardInqy1010.do'" class="_btn _line">취소</a>
							</div>
						</div><!-- End postWrap -->
						</div>
					</div><!-- End _contentArea _formArea -->
				</div><!-- End _inner -->
			</div><!-- End _content -->
		</div><!-- End _wrap -->
	</article>
	</form>
</body>
	
<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1020.jsp" %>