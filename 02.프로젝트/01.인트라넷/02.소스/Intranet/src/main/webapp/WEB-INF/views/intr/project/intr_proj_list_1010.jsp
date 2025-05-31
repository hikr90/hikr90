<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1010.jsp" %>

<script type="text/javascript">
	// 검색 조회
	function listCall(f){
		formSubmit("intrProjInqy1010.do");
	}

	// 등록 화면 조회
	function regCall(){
		formSubmit("intrProjInqy1020.do");
	}
	
	// 상세 화면 조회
	function detCall(sequenceId) {
		//
		$("#sequenceId").val(sequenceId);
		formSubmit("intrProjInqy1030.do");
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
   				url:	"intrProjProc1020.do",
   				data:	{
   					"delIdxArr":delIdxArr
   				},
   				success : function(data){
   					//
   					var json = eval(data);
   					if(json[0].res=="YES"){
   	   					//
   						alert("<spring:message code="PROC.SUCCESS"/>");
   	   					location.href="intrProjInqy1010.do?pageUrl=Proj";
   	   					
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
									
									<h2>프로젝트 관리
										<span class="float_right">
											<input type="button"class="btn_blue_thin" value="등록" onclick="regCall();">
											<input type="button"class="btn_gray_thin" value="삭제" onclick="delProc(this.form);">
										</span>
									</h2>
									<br>
									
									<div class="srch_wrap">
											<div class="right_srch_area">
												<!-- 수행일자 -->
												<div class="srch_area">
													<label class="srch_label">수행일자</label>
													<input type="text" class="srch_cdt_date srchDt" id="srchSdt" name="srchDt" value="${param.srchDt}" readonly="readonly" />
												</div>
												
												<!-- 진행상태 -->
												<div class="srch_area">
													<label class="srch_label">진행상태</label>
													<div class="select_wrap">
														<div id="statList" class="sList select_box">${empty param.statNm ? '전체' : param.statNm}</div>
														<input type="hidden" name="srchStatNm" value="${param.statCd}">
														<input type="hidden" name="srchStatCd" value="${param.statNm}">
													
														<ul class="sUl select_ul scroll_wrap">
															<c:forEach var="list" items="${statList}">
																<li setNm="${list.commcodeNm}" setCd="${list.commcodeCd}">${list.commcodeNm}</li>
															</c:forEach>
														</ul>
													</div>
												</div>
												<br>
												
												<!-- 부서 -->
												<div class="srch_area">
													<label class="srch_label">부서</label>
													<input type="text" id="orgNm" name="orgNm" class="srch_cdt_text" value="${param.orgNm}" onkeydown="pushListKey(this.form);">
												</div>

												<!-- 직급 -->
												<div class="srch_area">
													<label class="srch_label">직급</label>
													<input type="text" id="rankNm" name="rankNm" class="srch_cdt_text" value="${param.rankNm}" onkeydown="pushListKey(this.form);">
												</div>
												
												<!-- 담당자 -->
												<div class="srch_area">
													<label class="srch_label">담당자</label>
													<input type="text" id="srchIdx" name="srchIdx" class="srch_cdt_text" value="${param.srchIdx}" onkeydown="pushListKey(this.form);">
												</div>
												
												<!-- 프로젝트명 -->
												<div class="float_right">
													<div class="srch_area">
														<label class="srch_label">프로젝트명</label>
														<input type="text" id="srchNm" name="srchNm" class="srch_cdt_text" value="${param.srchNm}" onkeydown="pushListKey(this.form);">
													
														<input type="button"class="btn_blue" value="조회" onclick="listCall(this.form);">
														<input type="button"class="btn_gray" value="초기화" onclick="initCall();">
													</div>
			                                	</div>
											</div>
										</div>
									
									<div class="post_table_wrap">
										<table class="post_table">
											<caption>프로젝트 목록 조회</caption>
											<colgroup>
												<col class="w7per">
												<col class="w12per">
												<col class="auto">
												<col class="w20per">
												<col class="w12per">
												<col class="w12per">
											</colgroup>
											<thead>
												<tr>
													<th scope="col">
														<span class="check_box">
															<input type="checkbox" class="check_box everyChk"> 
															<label for="check_label"><span class="check_label"></span></label>
														</span>
													</th>
													<th scope="col">진행상태</th>
													<th scope="col">프로젝트명</th>
													<th scope="col">담당자</th>
													<th scope="col">시작일</th>
													<th scope="col">종료일</th>
												</tr>
											</thead>
											<tbody>
		                                    	<c:forEach var="list" items="${defaultList}"> 
													<tr>
														<td class="first_td">
					                                       <span class="check_box">
																<input type="checkbox"  name="checkBox" class="check_box delIdx" id="delIdx${status.index}" value="${list.projCd}"> 
																<label for="check_label"><span></span></label>
															</span>
														</td>
														<td>${list.statusNm}</td>
														<td class="_title">
															<a class="show_view a_title" onclick="detCall('${list.projCd}');">${list.projTitle}</a>
														</td>
														<td>${list.orgNm} ${list.ownerNm} ${list.rankNm}</td>
														<td>
															<span class="date">
															<fmt:parseDate value="${list.projSdt}" var="parseDt" pattern="yyyyMMdd"/>
															<fmt:formatDate value="${parseDt}" var="formatDt" pattern="yyyy-MM-dd"/>
															${formatDt} 
														</td>
														<td>
															<span class="date">
																<fmt:parseDate value="${list.projEdt}" var="parseDt" pattern="yyyyMMdd"/>
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
