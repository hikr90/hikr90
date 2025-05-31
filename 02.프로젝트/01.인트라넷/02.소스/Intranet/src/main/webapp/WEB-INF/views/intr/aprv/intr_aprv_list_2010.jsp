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
	function detCall(sequenceId) {
		//
		$("#sequenceId").val(sequenceId);
		formSubmit("intrAprvInqy2020.do");
	}
</script>
<body id="main">
<form id="form" name="form" method="POST">
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
									<input type="hidden" id="sequenceId" name="sequenceId" value="">
									<input type="hidden" id="page" name="page" value="${param.page}">
									<input type="hidden" id="pageUrl" name="pageUrl" value="${param.pageUrl}">
									
									<h2>결재 조회</h2><br>
									<div class="srch_wrap">
										<div class="right_srch_area">
											<!-- 작성일자 -->
											<div class="srch_area">
												<label class="srch_label">작성일자</label>
												<input type="text" class="srch_cdt_date srchSdt" id="srchSdt" name="srchSdt" value="${param.srchSdt}" readonly="readonly" />
												~
												<input type="text" class="srch_cdt_date srchEdt" id="srchEdt" name="srchEdt" value="${param.srchEdt}" readonly="readonly"/>
											</div>
											
											<!-- 기안자명 -->
											<div class="srch_area">
												<label class="srch_label">기안자명</label>
												<input type="text" id="srchNm" name="srchEnm" class="srch_cdt_text" value="${param.srchEnm}" onkeydown="pushListKey(this.form);">
											</div>
		                                	
		                                	<!-- 결재자명 -->
											<div class="srch_area">
												<label class="srch_label">결재자명</label>
												<input type="text" id="srchNm" name="srchAnm" class="srch_cdt_text" value="${param.srchAnm}" onkeydown="pushListKey(this.form);">
											</div>
											
											<!-- 제목 -->
											<div class="float_right">
												<div class="srch_area">
													<label class="srch_label">제목</label>
													<input type="text" id="srchNm" name="srchNm" class="srch_cdt_text" value="${param.srchNm}" onkeydown="pushListKey(this.form);">
												
													<input type="button"class="btn_blue" value="조회" onclick="listCall(this.form);">
													<input type="button"class="btn_gray" value="초기화" onclick="initCall();">
												</div>
		                                	</div>
		                                </div>
									</div>
									
									<div class="post_table_wrap">
										<table class="post_table">
											<caption>결재내역 목록 조회</caption>
											<colgroup>
												<col class="w7per">
												<col class="w12per">
												<col class="auto">
												<col class="w17per">
												<col class="w17per">
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
														<td class="first_td">${list.num}</td>
														<td>${list.currStepNm}</td>
														<td class="_title">
															<a class="show_view a_title" onclick="detCall('${list.sequenceId}');">${list.aprvTitle}</a>
														</td>
														<td>${list.aprvorgNm} ${list.aprvEmpNm} ${list.aprvrankNm}</td>
														<td>${list.empNm} ${list.orgNm} ${list.rankNm}</td>
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
		                                        <c:if test="${empty defaultList}">
		                                            <tr>
		                                                <td align="center" colspan="6">
		                                              	      등록된 글이 없습니다.
		                                                </td>
		                                            </tr>
		                                        </c:if>
											</tbody>
										</table>
									</div>
								
									<c:if test="${not empty defaultList}">
										<div class="paging_area">
											<div class="list_cnt">총 건수 : ${defaultList[0].listCnt}건</div>
											<ul class="paging">
												<li class="">${pageMenu}</li>
											</ul>
										</div><!-- End paging_wrap -->
									</c:if>	
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
