<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1010.jsp" %>

<script type="text/javascript">
	// 사원 등록
	function regCall(){
		formSubmit("intrEmpInqy1020.do");
	}
	
	// 검색 조회
	function listCall(f){
		formSubmit("intrEmpInqy1010.do");
	}
	
	// 사원 상세보기
	function detCall(empIdx){
		//
		$("#empIdx").val(empIdx);
		$("#contId").val(empIdx.replace('EMP_',''));
		//
		formSubmit("intrEmpInqy1030.do");
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
									<input type="hidden" id="empIdx" name="empIdx" value="">
									<input type="hidden" id="contId" name="contId" value="">

									<h2>사원 조회</h2><br>
									<div class="srch_wrap">
										<div class="right_srch_area">
											<!-- 입사일자 -->
											<div class="srch_area">
												<label class="srch_label">입사일자</label>
												<input type="text" class="srch_cdt_date srchSdt" id="srchSdt" name="srchSdt" value="${resultParam.srchSdt}" readonly="readonly" />
												~
												<input type="text" class="srch_cdt_date srchEdt" id="srchEdt" name="srchEdt" value="${resultParam.srchEdt}" readonly="readonly"/>
											</div>
												
											<!-- 부서 -->
											<div class="srch_area">
												<label class="srch_label">부서</label>
												<div class="select_wrap">
													<div id="deptList" class="sList select_box">${empty resultParam.deptNm ? '전체' : resultParam.deptNm}</div>
													<input type="hidden" name="deptCd" value="${resultParam.deptCd}">
													<input type="hidden" name="deptNm" value="${resultParam.deptNm}">
												
													<ul class="sUl select_ul">
														<c:forEach var="list" items="${deptList}">
															<li setNm="${list.deptNm}" setCd="${list.deptCd}">${list.deptNm}</li>
														</c:forEach>
													</ul>
												</div>
											</div>
											
											<!-- 직급 -->
											<div class="srch_area">
												<label class="srch_label">직급</label>
												<div class="select_wrap">
													<div id="gradeList" class="sList select_box">${empty resultParam.gradeNm ? '전체' : resultParam.gradeNm}</div>
													<input type="hidden" name="gradeCd" value="${resultParam.gradeCd}">
													<input type="hidden" name="gradeNm" value="${resultParam.gradeNm}">
												
													<ul class="sUl select_ul">
														<c:forEach var="list" items="${gradeList}">
															<li setNm="${list.gradeNm}" setCd="${list.gradeCd}">${list.gradeNm}</li>
														</c:forEach>
													</ul>
												</div>
											</div>
												
											<!-- 제목 -->
											<div class="float_right">
												<div class="srch_area">
													<label class="srch_label">제목</label>
													<input type="text" id="srchNm" name="srchNm" class="srch_cdt_text" value="${resultParam.srchNm}" onkeydown="pushListKey(this.form);">
												
													<input type="button"class="btn_blue" value="조회" onclick="listCall(this.form);">
												</div>
		                                	</div>
		                                </div>
									</div>
									
									<div class="post_table_wrap">
										<table class="post_table">
											<caption>사원 목록페이지 입니다.</caption>
											<colgroup>
												<col class="w12per">
												<col class="w12per">
												<col class="w12per">
												<col class="w12per">
												<col class="w8per">
											</colgroup>
											<thead>
												<tr>
													<th scope="col">입사일</th>
													<th scope="col">부서</th>
													<th scope="col">직급</th>
													<th scope="col">사원명</th>
													<th scope="col">재직 여부</th>
												</tr>
											</thead>
											<tbody>
		                                    	<c:forEach var="list" items="${defaultList}"> 
													<tr>
														<td class="first_td">
															<span class="date">
																<fmt:parseDate value="${list.empHireDate}" var="parseDt" pattern="yyyyMMdd"/>
																<fmt:formatDate value="${parseDt}" var="fomatDt" pattern="yyyy-MM-dd"/>
																${fomatDt} 
															</span>
														</td>
														<td>${list.deptNm}</td>
														<td>${list.gradeNm}</td>
														<td>
															<a class="show_view a_title" onclick="detCall('${list.empIdx}');">${list.empNm}</a>
														</td>
														<td>
															<c:choose>
																<c:when test="${list.resiYn eq 'N'}">N</c:when>
																<c:otherwise>Y</c:otherwise>
															</c:choose>
														</td>
			                                        </tr>
		                                        </c:forEach>
		                                        
		                                        <!-- 글이 없는 경우 -->
		                                        <c:if test="${empty defaultList}">
		                                            <tr>
		                                                <td align="center" colspan="5">
		                                              	      등록된 사원이 없습니다.
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
									
									<div class="float_right pt10 disp_inline">
										<input type="button"class="btn_navy_thin" value="등록" onclick="regCall();">
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