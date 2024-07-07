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
							<div class="sub_content">
								<div class="form_area">
									<input type="hidden" id="page" name="page" value="${param.page}">
									<input type="hidden" id="srchNm" name="srchNm" value="${param.srchNm}">
									<input type="hidden" id="srchSdt" name="srchSdt" value="${param.srchSdt}">
									<input type="hidden" id="srchEdt" name="srchEdt" value="${param.srchEdt}">
									<input type="hidden" id="contId" name="contId" value="${defaultInfo.contId}">
									<input type="hidden" id="brdTitle" name="brdTitle" value="${defaultInfo.brdTitle}">
								
									<div class="post_wrap">
		                           		<h2>공지사항 상세</h2><br>
									
										<div class="post_view">
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
												<dt>조회수</dt>
												<dd>${defaultInfo.brdReadhit}</dd>
											</dl>
											<dl class="post_info">
												<dt>부서</dt>
												<dd>${defaultInfo.deptNm}</dd>
												<dt>직급</dt>
												<dd>${defaultInfo.gradeNm}</dd>
												<dt>작성자</dt>
												<dd>${defaultInfo.empNm}</dd>
											</dl>
				
											<dl class="post_file">
												<dt>첨부파일</dt>
												<dd class="post_file">
													<div class="file_wrap">
														<ul id="updUl" style="float: left;"> 
														<c:forEach var="list" items="${defaultList}" varStatus="status">
															<li class="${status.index != 0 ? 'nbsp' : ''}">
																<img src='resources/images/icon/icon_file.png' width="20" height="20" />
																<a href="#" style="text-indent: 10px;" onclick="fileProc('${list.fileIdx}');">${list.fileOrglNm}</a>
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
													<pre>${defaultInfo.brdCont}</pre>
												</dd>
											</dl>
										</div><!-- End post_view -->
									
									<div class="btn_wrap align_right">
										<div class="float_left">
											<c:if test="${not empty defaultList and defaultList ne ''}">
												<button type="button" class="btn_navy_thin" onclick="zipProc();">전체 다운로드</button>
											</c:if>
										</div>
										
										<div class="float_right">
											<button type="button" class="btn_gray_thin" onclick="listCall();">목록으로</button>
										</div>
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
