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
	function detCall(brdId) {
		//
		$("#sequenceId").val(brdId);
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
   	   					location.href="intrBoardInqy1010.do?pageUrl=Board";
   	   					
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
			
										<h2>공지사항 관리
											<span class="float_right">
												<input type="button"class="btn_blue_thin" value="등록" onclick="regCall();">
												<input type="button"class="btn_gray_thin" value="삭제" onclick="delProc(this.form);">
											</span>
										</h2><br>
										
										<div class="srch_wrap">
											<div class="right_srch_area">
												<!-- 작성일자 -->
												<div class="srch_area">
													<label class="srch_label">작성일자</label>
													<input type="text" class="srch_cdt_date srchSdt" id="srchSdt" name="srchSdt" value="${param.srchSdt}" readonly="readonly" />
													~
													<input type="text" class="srch_cdt_date srchEdt" id="srchEdt" name="srchEdt" value="${param.srchEdt}" readonly="readonly"/>
												</div>
												<br>
												
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
												<div class="srch_area">
													<label class="srch_label">작성자</label>
													<input type="text" id="srchIdx" name="srchIdx" class="srch_cdt_text" value="${param.srchIdx}" onkeydown="pushCall(this.form);">
												</div>
												
												<!-- 제목 -->
												<div class="float_right">
													<div class="srch_area">
														<label class="srch_label">제목</label>
														<input type="text" id="srchNm" name="srchNm" class="srch_cdt_text" value="${param.srchNm}" onkeydown="pushCall(this.form);">
													
														<input type="button"class="btn_blue" value="조회" onclick="listCall(this.form);">
														<input type="button"class="btn_gray" value="초기화" onclick="initCall();">
													</div>
			                                	</div>
											</div>
										</div>
										
										<div class="post_table_wrap">
											<table class="post_table">
												<caption>공지사항 목록 조회</caption>
												<colgroup>
													<col class="w7per">
													<col class="auto">
													<col class="w12per">
													<col class="w12per">
													<col class="w15per">
													<col class="w7per">
													<col class="w7per">
												</colgroup>
												<thead>
													<tr>
														<th scope="col">
															<span class="check_box">
																<input type="checkbox" class="check_box everyChk"> 
																<label for="check_label"><span class="check_label"></span></label>
															</span>
														</th>
														<th scope="col">제목</th>
														<th scope="col">부서</th>
														<th scope="col">작성자</th>
														<th scope="col">작성일자</th>
														<th scope="col">조회수</th>
														<th scope="col">사용여부</th>
													</tr>
												</thead>
												<tbody>
			                                       <c:forEach var="list" items="${defaultList}" varStatus="status"> 
													<tr>
														<td class="first_td">
					                                       <span class="check_box">
																<input type="checkbox"  name="checkBox" class="check_box delIdx" id="delIdx${status.index}" value="${list.brdId}"> 
																<label for="check_label"><span></span></label>
															</span>
														</td>
														<td class="_title">
															<a class="show_view a_title" onclick="detCall('${list.brdId}');">${list.brdTitle}</a>
															<c:if test="${list.fileYn eq 'Y'}">
																<img id="fileImg" src='resources/images/icon/icon_file.png' width="15" height="15" />
															</c:if>
														</td>
														<td>${list.orgNm}</td>
														<td>${list.empNm} ${list.rankNm}</td>
														<td>
															<span class="date">
																<fmt:parseDate value="${list.regDt}" var="parseDt" pattern="yyyyMMdd"/>
																<fmt:formatDate value="${parseDt}" var="formatDt" pattern="yyyy-MM-dd"/>
																${formatDt} 
															</span>	
														</td>
														<td>${list.readHit}</td>
														<td>${list.useYn}</td>
			                                        </tr>
			                                        </c:forEach>
			                                        
			                                        <!-- 글이 없는 경우 -->
			                                        <c:if test="${empty defaultList}">
			                                            <tr>
			                                                <td align="center" colspan="7">
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
