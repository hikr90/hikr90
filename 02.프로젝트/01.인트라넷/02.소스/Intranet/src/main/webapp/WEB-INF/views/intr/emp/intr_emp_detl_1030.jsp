<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1010.jsp" %>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
	// 취소
	function detCall() {
		//
		formSubmit('intrEmpInqy1030.do');
	}
	
	// 수정 처리
	function modProc(f){
		// 유효성 검증
		if(!validation()){return;};
		//
		if(confirm("수정하시겠습니까?")){
			// 
			var fileList = setFileList(); // 파일 목록 세팅
			//
   			$.ajax({
				url:"intrEmpProc1020.do",
				processData : false,
				contentType : false,
				data: fileList,
				type : 'POST',
   				success : function(data){
   						//
   						var json = eval(data);
   						if(json[0].res=='YES'){
   	   						//
   							alert("<spring:message code="PROC.SUCCESS"/>");
	   						location.href = "intrEmpInqy1010.do";
   						}else{
   	   						//
   							alert("<spring:message code="PROC.FAIL"/>");
							return;	   							
   						}
   				},
   				error : function(res, status, error){
   					//
   					alert("<spring:message code="PROC.ERROR"/>");
   				}
   			});
			
		} else {
			//
			$("#modCnt").val("0");
			$("#fileArea").html("");
		}
	}	
</script>
</head>
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
									<input type="hidden" id="contId" name="contId" value="${param.contId}">
									<input type="hidden" id="srchNm" name="srchNm" value="${param.srchNm}">
									<input type="hidden" id="srchSdt" name="srchSdt" value="${param.srchSdt}">
									<input type="hidden" id="srchEdt" name="srchEdt" value="${param.srchEdt}">
									<input type="hidden" id="empIdx" name="empIdx" value="${defaultInfo.empIdx}">
									<input type="hidden" id="modCnt" name="modCnt" value="0">
		      						<input type="hidden" name="fileIdx" value="${defaultList[0].fileIdx}">
								
		                            <h2>사원 상세</h2><br>
	                                <div class="post_write">
	                                    <dl>
	                                        <dt><label>프로필</label></dt>
	                                        <dd>
	                                        	<div class="profile_wrap disp_flex">
		                                        	<div class="profile_area">
		                                        		<c:choose>
		                                        			<c:when test="${not empty defaultList}">
		                                        				<img class="emp_img" id="empImg" width="100" height="100" src="intrEmpInqy1012.do?contId=${defaultList[0].contId}&fileOrglNm=${defaultList[0].fileOrglNm}">
		                                        			</c:when>
		                                        			<c:otherwise>
				                                        		<img class="emp_img" id="empImg" width="100" height="100" src="resources/images/icon/icon_emp.png">
		                                        			</c:otherwise>
		                                        		</c:choose>
		                                        	</div>
	                                        	
		                                        	<div class="profile_box mt10 ml20">
		                                        		<br><span>사진을 등록해주세요.</span>
			                                        	<div style="margin-top: 5px;">
			                                        		<label for="profileImg" class="btn_blue">등록</label>
															<input type="file" name="profileImg" id="profileImg">
		                                        			<input type="button"class="btn_gray" id="delProfileImg" value="삭제">
		                                        		</div>
		                                        	</div>
	                                        	</div>
	                                        </dd>
	                                    </dl>
	                                    <dl>
	                                        <dt><label>사원명</label></dt>
	                                        <dd class="sel_2part">
	                                            <input type="text" title="사원명" id="empNm" name="empNm" value="${defaultInfo.empNm}" readonly="readonly">
	                                        </dd>
	                                        
	                                        <dt></dt>
	                                        <dd></dd>
	                                    </dl>
	                                    <dl>
	                                    	<dt><label>부서</label></dt>
	                                        <dd class="sel_2part">
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
	                                        </dd>
	                                        
	                                        <dt><label>직급</label></dt>
	                                        <dd class="sel_2part">
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
	                                        </dd>
	                                    </dl>
	                                    <dl>
	                                        <dt><label>연락처</label></dt>
	                                        <dd class="sel_2part">
	                                            <input type="text" title="연락처" id="empPhone" name="empPhone" maxlength="13" value="${defaultInfo.empPhone}" onkeyup="inputNum(this);">
	                                        </dd>
	
	                                        <dt><label>성별</label></dt>
	                                        <dd class="sel_2part">
	                                        	<div class="radio_box enter-check_box">
	                                            	<span class="radio-area">
	                                                	<input type="radio" id="chk-yes" class="empGender" name="empGender" value="M" <c:if test="${defaultInfo.empGender eq 'M'}">checked="checked"</c:if>></input>
	                                                	<label for="chk-yes">남자<span></span></label>
	                                            	</span>
	                                            	<span class="radio-area">
	                                                	<input type="radio" id="chk-no" class="empGender" name="empGender" value="F" <c:if test="${defaultInfo.empGender eq 'F'}">checked="checked"</c:if>></input>
	                                                	<label for="chk-no">여자<span></span></label>
	                                            	</span>
	                                            </div>
	                                        </dd>
	                                    </dl>
	                                    <dl>
	                                        <dt><label>주소</label></dt>
	                                        <dd class="sel_2part">
	                                            <input type="text" title="주소" readonly="readonly" id="empAddr" name="empAddr" value="${defaultInfo.empAddr}">
	                                            <input type="button"class="btn_blue align_top" value="주소 검색" onclick="srchAddr();">
	                                        </dd>
	                                        
	                                        <dt><label>상세 주소</label></dt>
	                                        <dd class="sel_2part">
	                                            <input type="text" title="상세주소" id="empAddrInfo" name="empAddrInfo" value="${defaultInfo.empAddrInfo}">
	                                        </dd>
	                                    </dl>
	                                    <dl>
	                                        <dt><label>아이디</label></dt>
	                                        <dd class="sel_2part">
	                                            <input type="text" title="아이디" id="empId" name="empId" value="${defaultInfo.empId}" readonly="readonly">
	                                        </dd>
	                                        
	                                        <dt><label>메일 주소</label></dt>
	                                        <dd class="sel_2part">
	                                            <input type="text" title="메일 주소" id="empEmail" name="empEmail" value="${defaultInfo.empEmail}">
	                                        </dd>
	                                    </dl>
									</div>
		                                
	                                <div class="btn_wrap align_right">
										<div class="float_right">
											<button type="button" class="btn_navy_thin" onclick="modProc('${empInfo.empIdx}')">수정완료</button>
											<button type="button" class="btn_gray_thin" onclick="detCall();">취소</button>
										</div>
									</div>
		                            </div><!-- End post_wrap -->
		                        </div>
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