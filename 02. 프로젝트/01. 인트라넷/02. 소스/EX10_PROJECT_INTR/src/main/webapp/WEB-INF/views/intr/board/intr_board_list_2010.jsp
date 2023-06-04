<!--명칭 : intr_board_list_2010
	작성자 : 김태현
	작성일자 : 2022.12.01
	내용 : 공지사항 목록-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1010.jsp" %>

<script type="text/javascript">
	// 검색 조회
	function listCall(f){
		formSubmit("intrBoardInqy2010.do");
	}

	// 공지사항 상세
	function detCall(contentIdx) {
		//
		$("#contentIdx").val(contentIdx);
		formSubmit("intrBoardInqy2020.do");
	}
</script>
<body id="main">
<form id="form" method="POST">
	<!-- MENU -->
	<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1030.jsp" %>

	<article id="_subArticle">
		<div class="_wrap">
			<div id="_content">
				<div id="sub_content" class="_inner" style="padding-top: 40px;">
					<div class="_contentArea _formArea">
						<!-- Form postWrap  -->
						<div class="postWrap" style="height: 710px;">
							<input type="hidden" id="contentIdx" name="contentIdx" value="">
							<input type="hidden" id="page" name="page" value="${param.page}">
							<input type="hidden" id="srchNm" name="srchNm" value="${param.srchNm}">
							<input type="hidden" id="srchSdt" name="page" value="${param.srchSdt}">
							<input type="hidden" id="srchEdt" name="page" value="${param.srchEdt}">
						
							<h2>공지사항</h2>
							<div class="f-srchWrap">
								<div class="search_nav">
									<div class="srchArea">
										<label class="srcLabel">작성일자</label>
										<input type="text" id="srchSdt" class="srch-cdt-date" id="srchSdt" name="srchSdt" value="${srchMap.srchSdt}" readonly="readonly"/>
										~
										<input type="text" id="srchEdt" class="srch-cdt-date" id="srchEdt" name="srchEdt" value="${srchMap.srchEdt}" readonly="readonly"/>
									</div>
									
									<!-- 부서 -->
									<div class="srchArea">
									
									</div>
									
									<!-- 제목 -->
									<div class="srchLeftArea">
										<div class="srchArea">
											<label class="srcLabel">제목</label>
											<input type="text" id="srchNm" name="srchNm" class="srch-cdt-text" value="${srchMap.srchNm}" onkeydown="pushListKey(this.form);">
										</div>
										<div class="srchArea cdtArea noLabel">                                
	                                   		<input type="button" class="stb-box-btn" value="조회" onclick="listCall(this.form);">
	                                	</div>
                                	</div>
                                </div>
							</div>
							<div class="postTableWrap">
								<table class="postTable">
									<caption>공지사항 목록 조회</caption>
									<colgroup>
										<col class="w7per">
										<col class="auto">
										<col class="w12per">
										<col class="w12per">
										<col class="w15per">
										<col class="w7per">
									</colgroup>
									<thead>
										<tr>
											<th scope="col">순번</th>
											<th scope="col">제목</th>
											<th scope="col">부서</th>
											<th scope="col">작성자</th>
											<th scope="col">작성일자</th>
											<th scope="col">조회수</th>
										</tr>
									</thead>
									<tbody>
                                       <c:forEach var="list" items="${defaultList}"> 
										<tr>
											<td class="first-td">${list.num}</td>
											<td class="_title">
												<a class="show_view a_title" onclick="detCall('${list.brdIdx}');">${list.brdTitle}</a>
												<c:if test="${list.fileYn eq 'Y'}">
													<img id="fileImg" src='resources/images/icon/icon_file.png' style="width: 15px; padding-left: 3px;"/>
												</c:if>
											</td>
											<td>${list.deptNm}</td>
											<td>${list.empNm}</td>
											<td>
												<span class="date">
													<fmt:parseDate value="${list.regDt}" var="parseDt" pattern="yyyyMMdd"/>
													<fmt:formatDate value="${parseDt}" var="formatDt" pattern="yyyy-MM-dd"/>
													${formatDt} 
												</span>	
											</td>
											<td>${list.brdReadhit}</td>
                                        </tr>
                                        </c:forEach>
                                        
                                        <!-- 글이 없는 경우 -->
                                        <c:if test="${ empty defaultList }">
                                            <tr>
                                                <td align="center" colspan="6">
                                              	      등록된 글이 없습니다.
                                                </td>
                                            </tr>
                                        </c:if>
                                        
									</tbody>
								</table>
							</div>
						
							<c:if test="${ not empty defaultList }">
								<div class="pagingArea">
								<div class="listCnt">총 건수 : ${defaultList[0].listCnt}건</div>
									<ul class="paging">
										<li class="">${pageMenu}</li>
									</ul>
								</div><!-- End pagingWrap -->
							</c:if>	
						</div><!-- End postWrap -->
					</div><!-- End _contentArea _formArea -->
				</div><!-- End _inner -->
			</div><!-- End _content -->
		</div><!-- End _wrap -->
	</article>
</form>
</body>

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1020.jsp" %>
