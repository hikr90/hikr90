<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1010.jsp" %>

<style>
	._formArea .postWrite dl > dd, ._formArea .postView dl > dd{height: 63px;}
</style>
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
	<!-- MENU -->
	<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1030.jsp" %>

	<form id="form" name="form" method="POST">
	<article id="_subArticle">
		<div class="_wrap">
			<div id="_content" style="padding-bottom: 30px;">
				<div id="sub_content" class="_inner" style="padding-top: 40px;">
					<div class="_contentArea _formArea">
						<div class="postWrap">
							<input type="hidden" id="contentIdx" name="contentIdx" value="${param.contentIdx}">
							<input type="hidden" id="srchNm" name="srchNm" value="${param.srchNm}">
							<input type="hidden" id="srchSdt" name="srchSdt" value="${param.srchSdt}">
							<input type="hidden" id="srchEdt" name="srchEdt" value="${param.srchEdt}">
							<input type="hidden" id="empIdx" name="empIdx" value="${defaultInfo.empIdx}">
							<input type="hidden" id="modCnt" name="modCnt" value="0">
      						<input type="hidden" name="fileIdx" value="${defaultList[0].fileIdx}">
						
							<div id="fileArea">
							
							</div>
						
							<!-- Form postWriteWrap  -->
                            <div class="">
                            <h2>사원 상세</h2>
                                <div class="postWrite">
                                    <dl style="height: 150px;">
                                        <dt><label>프로필</label></dt>
                                        <dd>
                                        	<div style="display: -webkit-inline-box;">
                                        	<div class="empProfile">
                                        		<c:choose>
                                        			<c:when test="${not empty defaultList}">
                                        				<img class="empImg" id="empImg" src="intrEmpInqy1012.do?contentIdx=${defaultList[0].contentIdx}&fileOrglNm=${defaultList[0].fileOrglNm}">
                                        			</c:when>
                                        			<c:otherwise>
		                                        		<img class="empImg" id="empImg" src="resources/images/icon/icon_emp.png">
                                        			</c:otherwise>
                                        		</c:choose>
                                        	</div>
                                        	<div class="profileBox" style="margin-left: 20px; display: grid;">
                                        		<span id="profileSpan" style="margin-top: 20px;">사진을 등록해주세요.</span>
	                                        	<div>
	                                        		<label for="profileImg" class="stb-box-btn">등록</label>
													<input type="file" name="profileImg" id="profileImg">
                                        			<input type="button" class="stb-box-btn-grey" id="delProfileImg" value="삭제">
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
											<select id="deptCd" name="deptCd">
											<c:forEach var="list" items="${deptList}" varStatus="status">
												<option value="${list.deptCd}" <c:if test="${defaultInfo.deptCd eq list.deptCd}">selected="selected"</c:if>>${list.deptNm}</option>
											</c:forEach>
											</select>
                                        </dd>
                                        
                                        <dt></dt>
                                        <dd></dd>
                                    </dl>

                                    <dl>
                                    	<dt><label>직급</label></dt>
                                        <dd class="sel_2part">
											<select id="gradeCd" name="gradeCd">
											<c:forEach var="list" items="${gradeList}" varStatus="status">
												<option value="${list.gradeCd}" <c:if test="${defaultInfo.gradeCd eq list.gradeCd}">selected="selected"</c:if>>${list.gradeNm}</option>
											</c:forEach>
											</select>
                                        </dd>
                                        
                                        <dt></dt>
                                        <dd></dd>
                                    </dl>
                                    <dl>
                                        <dt><label>연락처</label></dt>
                                        <dd class="sel_2part">
                                            <input type="text" title="연락처" id="empPhone" name="empPhone" maxlength="13" value="${defaultInfo.empPhone}" onkeyup="inputNum(this);">
                                        </dd>

                                        <dt><label>성별</label></dt>
                                        <dd class="sel_2part">
                                        	<div class="_radioBox enter-chkBox">
                                            	<span class="radio-area">
                                                	<input type="radio" id="chk-local" class="empGender" name="empGender" value="M" <c:if test="${defaultInfo.empGender eq 'M'}">checked="checked"</c:if>></input>
                                                	<label for="chk-local">남자<span></span></label>
                                            	</span>
                                            	<span class="radio-area">
                                                	<input type="radio" id="chk-foreign" class="empGender" name="empGender" value="F" <c:if test="${defaultInfo.empGender eq 'F'}">checked="checked"</c:if>></input>
                                                	<label for="chk-foreign">여자<span></span></label>
                                            	</span>
                                            </div>
                                        </dd>
                                    </dl>
                                    <dl>
                                        <dt><label>주소</label></dt>
                                        <dd class="sel_2part">
                                            <input type="text" title="주소" readonly="readonly" id="empAddr" name="empAddr" value="${defaultInfo.empAddr}">
                                            <input type="button" class="stb-box-btn" value="주소 검색" onclick="srchAddr();" style="margin-bottom: 5px;">
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
								</div><!-- End postWriteWrap -->
                                
	                                <div class="btnWrap alignR">
										<div class="floatR">
											<input type="button" onclick="modProc('${empInfo.empIdx}')" class="_btn _gray" value="수정 완료">
											<a class="_btn _line" onclick="detCall();">취소</a>
										</div>
									</div>
								</div>
                            </div><!-- End postWrap -->
                        </div>
					</div><!-- End _contentArea _formArea -->
					
				</div><!-- End _inner -->

			</div><!-- End _content -->
		</div><!-- End _wrap -->
	</article>
	</form>
</body>
	
<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1020.jsp" %>