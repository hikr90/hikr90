<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1010.jsp" %>

<script type="text/javascript">
	// 검색 조회
	function listCall(f){
		try {
			//
			formSubmit("intrMtgInqy1010.do");
			
		} catch (error) {
	        console.error("[Error] 검색 조회 : ", error.message);
		}
	}

	// 등록 화면 조회
	function regCall(){
		try {
			//
			formSubmit("intrMtgInqy1020.do");
			
		} catch (error) {
	        console.error("[Error] 등록 화면 조회 : ", error.message);
		}
	}
	
	// 상세 화면 조회
	function detCall(sequenceId) {
		try {
			//
			$("#sequenceId").val(sequenceId);
			formSubmit("intrMtgInqy1030.do");
			
		} catch (error) {
	        console.error("[Error] 상세 화면 조회 : ", error.message);
		}
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
									
									<h2>회의 관리
										<span class="float_right">
											<input type="button" class="btn_blue_thin" value="등록" onclick="regCall();">
										</span>
									</h2>
									
									<div class="srch_wrap">
											<div class="right_srch_area">
												<!-- 회의일자 -->
												<div class="srch_area">
													<label class="srch_label">회의일자</label>
													<input type="text" class="srch_cdt_date srchDt" id="srchSdt" name="srchDt" value="${param.srchDt}" readonly="readonly" />
												</div>
												
												<!-- 등록자 -->
												<div class="srch_area">
													<label class="srch_label">등록자</label>
													<input type="text" id="srchIdx" name="srchIdx" class="srch_cdt_text" value="${param.srchIdx}" onkeydown="pushCall(this.form);">
												</div>
												
												<!-- 부서 -->
												<div class="srch_area">
													<label class="srch_label">부서</label>
													<input type="text" id="orgNm" name="orgNm" class="srch_cdt_text" value="${param.orgNm}" onkeydown="pushCall(this.form);">
												</div>

												<!-- 직급 -->
												<div class="srch_area">
													<label class="srch_label">직급</label>
													<input type="text" id="rankNm" name="rankNm" class="srch_cdt_text" value="${param.rankNm}" onkeydown="pushCall(this.form);">
												</div>
												
												<!-- 제목 -->
												<div class="float_right">
													<div class="srch_area">
														<label class="srch_label">제목</label>
														<input type="text" id="srchNm" name="srchNm" class="srch_cdt_text" value="${param.srchNm}" onkeydown="pushCall(this.form);">
													
														<input type="button" class="btn_blue" value="조회" onclick="listCall(this.form);">
														<input type="button" class="btn_gray" value="초기화" onclick="initCall();">
													</div>
			                                	</div>
											</div>
										</div>
									
									<div class="post_table_wrap">
										<table class="post_table">
											<caption>회의 목록 조회</caption>
											<colgroup>
												<col class="w15per">
												<col class="w15per">
												<col class="auto">
												<col class="w20per">
											</colgroup>
											<thead>
												<tr>
													<th scope="col">회의일자</th>
													<th scope="col">회의시간</th>
													<th scope="col">회의 제목</th>
													<th scope="col">등록자</th>
												</tr>
											</thead>
											<tbody>
		                                    	<c:forEach var="list" items="${defaultList}" varStatus="status"> 
													<tr>
														<td class="first_td">
															<span class="date">
																<fmt:parseDate value="${list.mtgDt}" var="parseDt" pattern="yyyyMMdd"/>
																<fmt:formatDate value="${parseDt}" var="formatDt" pattern="yyyy-MM-dd"/>
																${formatDt} 
															</span>
														</td>
														<td>
															<span class="date">
																<fmt:parseDate value="${list.mtgStm}" var="parseStm" pattern="HHmm"/>
																<fmt:formatDate value="${parseStm}" var="formatStm" pattern="HH:mm"/>

																<fmt:parseDate value="${list.mtgEtm}" var="parseEtm" pattern="HHmm"/>
																<fmt:formatDate value="${parseEtm}" var="formatEtm" pattern="HH:mm"/>
																${formatStm} ~ ${formatEtm}
															</span> 
														</td>
														<td class="_title">
															<c:if test="${list.fileYn eq 'Y'}">
																<img id="fileImg" src='resources/images/icon/icon_file.png' width="15" height="15" />
															</c:if>
															<a class="show_view a_title" onclick="detCall('${list.mtgCd}');">${list.mtgTitle}</a>
														</td>
														<td>${list.orgNm} ${list.empNm} ${list.rankNm}</td>
			                                        </tr>
		                                        </c:forEach>
		                                        
		                                        <!-- 글이 없는 경우 -->
		                                        <c:if test="${empty defaultList}">
		                                            <tr>
		                                                <td align="center" colspan="4">
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
