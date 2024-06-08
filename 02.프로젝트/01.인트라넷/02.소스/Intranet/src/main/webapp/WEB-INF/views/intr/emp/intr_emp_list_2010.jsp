<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1010.jsp" %>

<script type="text/javascript">
	// 사원 목록 검색
	function listCall(f){
		//
		formSubmit("intrEmpInqy2010.do");
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
						<!-- Form srchWrap  -->
						<div class="postWrap" style="padding-bottom: 15%;">
							<h2>사원 조회</h2>
							<div class="f-srchWrap">
								<div class="search_nav">
									<!-- 부서 -->
									<div class="srchArea">
										<label class="srcLabel">부서</label>
										
										<select id="deptCd" name="deptCd" style="width: 200px;">
											<option value="" <c:if test="${empty srchMap.deptCd}">selected</c:if>>전체</option>

										<c:forEach var="list" items="${deptList}" varStatus="status">
											<option value="${list.deptCd}" <c:if test="${srchMap.deptCd eq list.deptCd}">selected</c:if>>${list.deptNm}</option>
										</c:forEach>
										</select>
									</div>

									<!-- 입사일자 -->
									<div class="srchArea">
										<label class="srcLabel">입사일자</label>
										<input type="text" id="srchSdt" class="srch-cdt-date" id="srchSdt" name="srchSdt" value="${srchMap.srchSdt}" readonly="readonly" />
										~
										<input type="text" id="srchEdt" class="srch-cdt-date" id="srchEdt" name="srchEdt" value="${srchMap.srchEdt}" readonly="readonly"/>
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
									<caption>사원 목록페이지 입니다.</caption>
									<colgroup>
										<col class="w12per">
										<col class="w12per">
										<col class="w12per">
										<col class="w12per">
										<col class="w12per">
										<col class="w12per">
									</colgroup>
									<thead>
										<tr>
											<th scope="col">입사일</th>
											<th scope="col">부서</th>
											<th scope="col">직급</th>
											<th scope="col">사원명</th>
											<th scope="col">연락처</th>
											<th scope="col">이메일</th>
										</tr>
									</thead>
									<tbody>
                                       <c:forEach var="list" items="${defaultList}" varStatus="status"> 
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
											<td>${list.empNm}</td>
											<td>${list.empPhone}</td>
											<td>${list.empEmail}</td>
                                        </tr>
                                        </c:forEach>
                                        
                                        <!-- 글이 없는 경우 -->
                                        <c:if test="${ empty defaultList }">
                                            <tr>
                                                <td align="center" colspan="6">
                                              	      등록된 사원이 없습니다.
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
