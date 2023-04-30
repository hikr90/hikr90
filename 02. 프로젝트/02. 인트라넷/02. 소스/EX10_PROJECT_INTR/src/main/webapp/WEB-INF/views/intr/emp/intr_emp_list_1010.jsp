<!--명칭 : intr_emp_list_1010
	작성자 : 김태현
	작성일자 : 2022.12.25
	내용 : 사원 정보 정정 목록 -->
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
		$("#contentIdx").val(empIdx.replace('EMP_',''));
		//
		formSubmit("intrEmpInqy1030.do");
	}
</script>
<body id="main">
<form id="form" method="POST">
	<!-- MENU -->
	<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1030.jsp" %>

	<article id="_subArticle">
		<div class="_wrap">
			<div id="_content">
				<div id="sub_content" class="_inner">					
					<div class="_contentArea _formArea">
						<!-- Form srchWrap  -->
						<div class="listWrap">
						</div><!-- End listWrap -->
						<!-- Form postWrap  -->
						<div class="postWrap" style="height: 710px;">
						<input type="hidden" id="empIdx" name="empIdx" value="">
						<input type="hidden" id="contentIdx" name="contentIdx" value="">

							<h2>사원 정보
								<span class="stb-box">
									<input type="button" class="stb-box-btn2" value="등록" onclick="regCall();">
								</span>
							</h2>
							<div class="f-srchWrap">
								<div class="search_nav">
									<div class="srchArea">
										<label class="srcLabel">입사일</label>
										<input type="text" id="srchSdt" class="srch-cdt-date" id="srchSdt" name="srchSdt" value="${srchMap.srchSdt}" readonly="readonly" />
										~
										<input type="text" id="srchEdt" class="srch-cdt-date" id="srchEdt" name="srchEdt" value="${srchMap.srchEdt}" readonly="readonly"/>
									</div>
									
									<div class="srchLeftArea">
										<div class="srchArea">
											<label class="srcLabel">사원명</label>
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
											<td class="first-td">
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
                                        
                                        <!-- 글이 없는 경우 -->
                                        </c:forEach>
                                        <c:if test="${ empty defaultList }">
                                            <tr>
                                                <td align="center" colspan="5">
                                              	      등록된 사원이 없습니다.
                                                </td>
                                            </tr>
                                        </c:if>
                                        
									</tbody>
								</table>
							</div>
						
							<c:if test="${ not empty defaultList }">	
								총 건수 : ${ defaultList[0].listCnt }건
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