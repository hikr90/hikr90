<!--명칭 : intr_board_detl_1010
	작성자 : 김태현
	작성일자 : 2022.12.25
	내용 : 공지사항 상세-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1010.jsp" %>

<head>
	<script type="text/javascript">
		// 목록으로
		function listCall() {
			formSubmit('intrBoardInqy2010.do');
		}
		
		// 파일 다운로드
		function fileProc(){
			formSubmit('intrFileProc1020.do');
		}
		
		// 전체 다운로드
		function zipProc(){
			formSubmit('intrFileProc1030.do');
		}
	</script>
</head>
<body id="main">
	<!-- MENU -->
	<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1030.jsp" %>
	
	<form id="form" method="POST">
	<article id="_subArticle">
		<div class="_wrap">
			<div id="_content">
				<div id="sub_content" class="_inner" style="padding-top: 40px;">					
					<div class="_contentArea _formArea">
						<input type="hidden" id="page" name="page" value="${param.page}">
						<input type="hidden" id="srchNm" name="srchNm" value="${param.srchNm}">
						<input type="hidden" id="srchSdt" name="srchSdt" value="${param.srchSdt}">
						<input type="hidden" id="srchEdt" name="srchEdt" value="${param.srchEdt}">
						<input type="hidden" id="contentIdx" name="contentIdx" value="${defaultInfo.brdIdx}">
						<input type="hidden" id="brdTitle" name="brdTitle" value="${defaultInfo.brdTitle}">
					
						<div class="postCon">
						<div class="postWrap">
                            <h2>공지사항 상세</h2>
							<!-- Form postViewWrap  -->
							<div class="postView">
								<dl>
									<dt>제목</dt>
									<dd>${defaultInfo.brdTitle}</dd>
									<dt>작성일</dt>
									<dd>
										<span class="date">
											<fmt:parseDate value="${defaultInfo.regDt}" var="parseDt" pattern="yyyyMMdd"/>
											<fmt:formatDate value="${parseDt}" var="fomatDt" pattern="yyyy-MM-dd"/>
											${fomatDt} 
										</span>	
									</dd>
								</dl>
								<dl class="post-info">
									<dt>부서</dt>
									<dd>${ defaultInfo.deptNm }</dd>
									<dt>작성자</dt>
									<dd>${ defaultInfo.empNm }</dd>
								</dl>
	
								<dl class="post_file">
									<dt>첨부파일</dt>
									<dd class="post_file">
										<div class="scrollFileWrap">
											<ul id="updUl"> 
											<c:forEach var="list" items="${defaultList}">
												<li>
													<img src='resources/images/icon/icon_file.png'/>
													<a href="#" onclick="fileProc();">${list.fileOrglNm}</a>
													<input type="hidden" id="fileIdx" name="fileIdx" value="${list.fileIdx}">
												</li>
											</c:forEach>
											</ul>
										</div>
									</dd>
								</dl>

								<dl>
									<dt>내용</dt>
									<dd class="post_text">
										<pre style="font-family: NanumSquare">${ defaultInfo.brdContent }</pre>
									</dd>
								</dl>
							</div><!-- End postViewWrap -->
							
							<div class="btnWrap alignR">
								<div class="floatR">
									<c:if test="${defaultList ne null}">
										<a class="_btn" onclick="zipProc();">전체 다운로드</a>
									</c:if>
									<a class="_btn _blue" onclick="listCall();">목록으로</a>
								</div>
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
