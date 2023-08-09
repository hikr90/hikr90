<!--명칭 : intr_aprv_list_2010
	작성자 : 김태현
	작성일자 : 2023.07.31
	내용 : 결재 목록-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1010.jsp" %>

<script type="text/javascript">
	// 검색 조회
	function listCall(f){
		formSubmit("intrAprvInqy2010.do");
	}
	
	// 품의문 상세 조회
	function detCall(contentIdx) {
		//
		$("#contentIdx").val(contentIdx);
		formSubmit("intrAprvInqy2020.do");
	}
</script>
<body id="main">
<form id="form" name="form" method="POST">
	<!-- MENU -->
	<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1030.jsp" %>

	<article id="_subArticle">
		<div class="_wrap">
			<div id="_content">
				<div id="sub_content" class="_inner" style="padding-top: 40px;">
					<div class="_contentArea _formArea">
						<!-- Form postWrap  -->
						<div class="postWrap" style="height: 710px;">
							<input type="hidden" id="page" name="page" value="${param.page}">
							<input type="hidden" id="contentIdx" name="contentIdx" value="">
							
							<div class="tagWrap">
								<h2>결재 목록</h2>
							</div>
							
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
									<caption>결재내역 목록 조회</caption>
									<colgroup>
										<col class="w7per">
										<col class="w12per">
										<col class="auto">
										<col class="w15per">
										<col class="w15per">
										<col class="w12per">
									</colgroup>
									<thead>
										<tr>
											<th scope="col">순번</th>
											<th scope="col">진행 단계</th>
											<th scope="col">품의문 제목</th>
											<th scope="col">결재 진행자</th>
											<th scope="col">결재 기안자</th>
											<th scope="col">작성일자</th>
										</tr>
									</thead>
									<tbody>
                                       <c:forEach var="list" items="${defaultList}"> 
										<tr>
											<td class="first-td">${list.num}</td>
											<td>${list.currStepNm}</td>
											<td class="_title">
												<a class="show_view a_title" onclick="detCall('${list.aprvIdx}');">${list.aprvTitle}</a>
											</td>
											<td>${list.aprvDeptNm} ${list.aprvEmpNm}</td>
											<td>${list.empNm} ${list.deptNm}</td>
											<td>
												<span class="date">
													<fmt:parseDate value="${list.aprvRegDt}" var="parseDt" pattern="yyyyMMdd"/>
													<fmt:formatDate value="${parseDt}" var="formatDt" pattern="yyyy-MM-dd"/>
													${formatDt} 
												</span>	
											</td>
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
