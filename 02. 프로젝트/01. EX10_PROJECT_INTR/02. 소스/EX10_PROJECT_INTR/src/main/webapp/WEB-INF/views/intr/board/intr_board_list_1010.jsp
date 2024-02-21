<!--명칭 : intr_board_list_1010
	작성자 : 김태현
	작성일자 : 2022.12.07
	내용 : 공지사항 관리 목록-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1010.jsp" %>

<script type="text/javascript">
	// 공지사항 등록
	function regCall(){
		formSubmit("intrBoardInqy1020.do");
	}
	
	// 공지사항 상세
	function detCall(contentIdx) {
		//
		$("#contentIdx").val(contentIdx);
		formSubmit("intrBoardInqy1030.do");
	}

	// 검색 조회
	function listCall(f){
		formSubmit("intrBoardInqy1010.do");
	}
	
	// 공지사항 삭제
	function delProc(f){
		//
		var delIdxArr = [];
		$(".delIdx").each(function(idx, tag){
			if($("#delIdx"+idx).is(':checked')){
				//				
				delIdxArr.push($("#delIdx"+idx).val());
			}
		});
		// 유효성 체크
		if(delIdxArr.length==0){
			alert("<spring:message code="CHECK.NONE"/>");
			return;
		}	
		//				
		if(confirm('삭제하시겠습니까?')){
			//
   			$.ajax({
   				type:	"post" , 
   				traditional: true,
   				url:	"intrBoardProc1020.do",
   				data:	{
   					"delIdxArr":delIdxArr
   				},
   				success : function(data){
   					//
   					var json = eval(data);
   					if(json[0].res=="YES"){
   	   					//
   						alert("<spring:message code="PROC.SUCCESS"/>");
   	   					location.href="intrBoardInqy1010.do";
   	   					
   					} else {
   						//
   						alert("<spring:message code="PROC.ERROR"/>");
   						return;
   					}
   				},
   				error : function(res, status, error){
   					//
   					alert("<spring:message code="PROC.ERROR"/>");
   				}
   			});

		}
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
						<div class="listWrap"></div>
						<!-- End listWrap -->
						<!-- Form postWrap  -->
						<div class="postWrap" style="height: 710px;">
							<input type="hidden" id="contentIdx" name="contentIdx" value="">

							<div class="tagWrap">
								<h2>공지사항 관리
									<span class="stb-box">
										<input type="button" class="stb-box-btn2" value="등록" onclick="regCall();">
										<input type="button" class="stb-box-btn3" value="삭제" onclick="delProc(this.form);">
									</span>
								</h2>
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
										<input type="text" class="srch-cdt-date srchSdt" id="srchSdt" name="srchSdt" value="${srchMap.srchSdt}" readonly="readonly" />
										~
										<input type="text" class="srch-cdt-date srchEdt" id="srchEdt" name="srchEdt" value="${srchMap.srchEdt}" readonly="readonly"/>
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
							<div class="scrollTableWrap">
								<table class="postTable">
									<caption>공지사항 정보정정 목록 조회</caption>
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
											<th scope="col">
												<span class="_chkBox">
													<input type="checkbox" class="checkbox everyChk"> 
													<label for="chk-local"><span></span></label>
												</span>
											</th>
											<th scope="col">제목</th>
											<th scope="col">부서</th>
											<th scope="col">작성자</th>
											<th scope="col">작성일자</th>
											<th scope="col">조회수</th>
										</tr>
									</thead>
									<tbody>
                                       <c:forEach var="list" items="${defaultList}" varStatus="status"> 
										<tr>
											<td class="first-td">
		                                       <span class="_chkBox">
													<input type="checkbox" class="checkbox delIdx" id="delIdx${status.index}" value="${list.brdIdx}"> 
													<label for="chk-local"><span></span></label>
												</span>
											</td>
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
                                        <c:if test="${empty defaultList}">
                                            <tr>
                                                <td align="center" colspan="6">
                                              	      등록된 글이 없습니다.
                                                </td>
                                            </tr>
                                        </c:if>
									</tbody>
								</table>
								
								<c:if test="${ not empty defaultList }">
									<div id="totalCnt">
										총 건수 : ${ defaultList[0].listCnt }건
									</div>
								</c:if>
							</div>
						
							<div class="scrollArea"></div><!-- End pagingWrap -->
							</div><!-- End postWrap -->
					</div><!-- End _contentArea _formArea -->
				</div><!-- End _inner -->
			</div><!-- End _content -->
		</div><!-- End _wrap -->
	</article>
</form>
</body>

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1020.jsp" %>
