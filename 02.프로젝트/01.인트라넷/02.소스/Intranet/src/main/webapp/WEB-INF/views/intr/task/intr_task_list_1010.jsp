<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1010.jsp" %>

<script type="text/javascript">
	//
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
							<input type="hidden" id="contentIdx" name="contentIdx" value="">

							<div class="tagWrap">
								<h2>업무일지 조회</h2>
							</div>
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

									<!-- 작성일자 -->
									<div class="srchArea">
										<label class="srcLabel">작성일자</label>
										<input type="text" class="srch-cdt-date" id="srchSdt" name="srchSdt" value="${srchMap.srchSdt}" readonly="readonly" />
										~
										<input type="text" class="srch-cdt-date" id="srchEdt" name="srchEdt" value="${srchMap.srchEdt}" readonly="readonly"/>
									</div>
									
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
							<table class="postTable">
								<caption>업무일지 조회</caption>
								<colgroup>
									<col class="w10per">
									<col class="w10per">
									<col class="w10per">
									<col class="w10per">
									<col class="auto">
								</colgroup>
								<thead>
									<tr>
										<th scope="col">작성일자</th>
										<th scope="col">작성시간</th>
										<th scope="col">부서</th>
										<th scope="col">작성자</th>
										<th scope="col">업무</th>
									</tr>
								</thead>
								<tbody>
	                                <c:forEach var="list" items="${defaultList}" varStatus="status"> 
									<tr>
										<td class="first-td">
											<span class="date">
												<fmt:parseDate value="${list.regDt}" var="parseDt" pattern="yyyyMMdd"/>
												<fmt:formatDate value="${parseDt}" var="formatDt" pattern="yyyy-MM-dd"/>
												${formatDt}
											</span>
										</td>
										<td class="first-td">
											<span class="date">
												<fmt:parseDate value="${list.regTm}" var="parseTm" pattern="HHmmss"/>
												<fmt:formatDate value="${parseTm}" var="formatTm" pattern="HH:mm:ss"/>
												${formatTm} 
											</span>	
										</td>
										<td>${list.deptNm}</td>
										<td>${list.empNm}</td>
										<td class="_title">${list.taskContent}</td>
                                   </tr>
                                   </c:forEach>
                                       
                                   <!-- 글이 없는 경우 -->
                                   <c:if test="${ empty defaultList }">
  	                                 <tr>
    					                 <td align="center" colspan="5">
                  		             	      등록된 글이 없습니다.
                                         </td>
                                     </tr>
                                   </c:if>
								</tbody>
							</table>

							<c:if test="${ not empty defaultList }">
								<div class="pagingArea">
								<div class="listCnt">총 건수 : ${defaultList[0].listCnt}건</div>
									<ul class="paging">
										<li class="">${pageMenu}</li>
									</ul>
								</div><!-- End pagingWrap -->
							</c:if>	
					</div><!-- End _contentArea _formArea -->
				</div><!-- End _inner -->
			</div><!-- End _content -->
		</div><!-- End _wrap -->
	</article>
</form>
</body>

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1020.jsp" %>
