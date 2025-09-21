<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1010.jsp" %>

<script type="text/javascript">
	// 목록 조회
	function listCall(f){
		formSubmit("inqAdminTaskList.do");
	}
	
	// +/- 처리
	function spreadProc(taskIdx){
		// 
		var sprGb = $("#"+taskIdx).attr("sprGb");
		//		
		if(sprGb=="Y") {
			// close
			$("."+taskIdx).removeClass('hide');
			$("."+taskIdx).addClass('show');	
			$("#"+taskIdx).find('a').text("-");	
			$("#"+taskIdx).attr('sprGb','N');

		} else {
			// open
			$("."+taskIdx).removeClass('show');
			$("."+taskIdx).addClass('hide');	
			$("#"+taskIdx).find('a').text("+");	
			$("#"+taskIdx).attr('sprGb','Y');

		}
	}
</script>
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
							<div id="sub_content">					
								<div class="form_area">
									<div class="post_wrap">
										<input type="hidden" id="page" name="page" value="${param.page}">
										<input type="hidden" id="pageUrl" name="pageUrl" value="${param.pageUrl}">
										<input type="hidden" id="taskId" name="taskId" value="">
										
										<h2>업무일지 조회</h2>
										<div class="srch_wrap">
											<div class="right_srch_area">
												<!-- 작성일자 -->
												<div class="srch_area">
													<label class="srch_label">작성일자</label>
													<input type="text" id="srchSdt" class="srch_cdt_date" id="srchSdt" name="srchSdt" value="${param.srchSdt}" readonly="readonly"/>
													~
													<input type="text" id="srchEdt" class="srch_cdt_date" id="srchEdt" name="srchEdt" value="${param.srchEdt}" readonly="readonly"/>
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
												
												<!-- 작성자 -->
												<div class="float_right">
													<div class="srch_area">
														<label class="srch_label">작성자</label>
														<input type="text" id="srchNm" name="srchNm" class="srch_cdt_text" value="${param.srchNm}" onkeydown="pushCall(this.form);">
														
														<input type="button"class="btn_blue" value="조회" onclick="listCall(this.form);">
														<input type="button"class="btn_gray" value="초기화" onclick="initCall();">
													</div>
			                                	</div>
			                                </div>
										</div>
										
										<table class="post_table">
											<caption>업무일지 조회</caption>
											<colgroup>
												<col class="w5per">
												<col class="w10per">
												<col class="w10per">
												<col class="auto">
												<col class="w10per">
												<col class="w10per">
											</colgroup>
											<thead>
												<tr>
													<th scope="col">+/-</th>
													<th scope="col">업무일자</th>
													<th scope="col">업무시간</th>
													<th scope="col">업무내용</th>
													<th scope="col">부서</th>
													<th scope="col">작성자</th>
												</tr>
											</thead>
											<tbody>
				                                <c:forEach var="list" items="${defaultList}" varStatus="status"> 
														<tr id="${list.dispOrder eq 0 ? list.taskIdx : ''}" class="${list.dispOrder eq 0 ? '' : list.taskIdx} ${list.dispOrder eq 0 ? 'show' : 'hide'}" sprGb="${list.dispOrder eq 0 ? 'Y' : 'N'}">
															<c:if test="${list.dispOrder eq 0}">
																<td rowspan="${list.rowNum}">
																	<c:if test="${list.dispOrder eq 0}"><a onclick="spreadProc('${list.taskIdx}');">+</a></c:if>
																</td>
																<td rowspan="${list.rowNum}">
																	<span class="date">
																		<fmt:parseDate value="${list.regDt}" var="parseDt" pattern="yyyyMMdd"/>
																		<fmt:formatDate value="${parseDt}" var="formatDt" pattern="yyyy-MM-dd"/>
																	
																		${formatDt}
																	</span>
																</td>
															</c:if>
															<td>
																<fmt:parseDate value="${list.regTm}" var="parseTm" pattern="HHmmss"/>
																<fmt:formatDate value="${parseTm}" var="formatTm" pattern="HH:mm"/>
																	${formatTm}
															</td>
															<td class="_title"><c:if test="${list.dispOrder ne 0}">&nbsp;&nbsp;&nbsp;</c:if>${list.taskCont}</td>
															<c:if test="${list.dispOrder eq 0}">
																<td rowspan="${list.rowNum}">${list.orgNm}</td>
																<td rowspan="${list.rowNum}">${list.empNm}</td>
															</c:if>
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
			
										<c:if test="${not empty defaultList}">
											<div class="paging_area">
												<div class="list_cnt">총 건수 : ${defaultList[0].listCnt}건</div>
												<ul class="paging">
													<li class="">${pageMenu}</li>
												</ul>
											</div><!-- End paging_wrap -->
										</c:if>	
								</div><!-- End post_wrap  -->
							</div><!-- End form_area -->
						</div><!-- End content -->
					</div><!-- End wrap -->
				</article>
			</div>
		</div>
	</div>
</form>
</body>

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1020.jsp" %>
