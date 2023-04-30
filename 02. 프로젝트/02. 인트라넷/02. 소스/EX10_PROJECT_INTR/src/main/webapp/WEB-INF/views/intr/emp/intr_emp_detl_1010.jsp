<!--명칭 : intr_emp_detl_1010
	작성자 : 김태현
	작성일자 : 2022.12.25
	내용 : 사원 상세 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1010.jsp" %>

<style>._formArea .postWrite dl > dd, ._formArea .postView dl > dd{height: 63px;}</style>
<script type="text/javascript">
	// 목록으로
	function listCall() {
		formSubmit('intrEmpInqy1010.do');
	}
	
	// 수정 화면
	function modCall() {
		formSubmit('intrEmpInqy1040.do');
	}
	
	// 복직, 퇴사 처리
	function resiProc(f){
		//
		if(confirm("작업 처리하시겠습니까?")){
			//
			var param = $("#form").serialize();
			$.ajax({
	    		type : 'post',
	        	url : 'intrEmpProc1030.do',
	            data : param,
	            dataType : 'html',
	            success : function(data){
	     				//
	     				var json = eval(data);
	   					if(json[0].res=="YES"){
	   						//
	   						alert("<spring:message code="comm.proc.succ"/>"); // ALERT
	   						formSubmit('intrEmpInqy1030.do');
	   					} else {
							//
							alert("<spring:message code="comm.proc.fail"/>"); // ALERT
	   					}
	            },
	            error : function(data){
	            	//
					alert("<spring:message code="comm.proc.error"/>");
	            }
	      	});
		}
	}
</script>
</head>
<body id="main">
<form id="form" method="POST">
	<!-- MENU -->
	<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1030.jsp" %>
	
	<article id="_subArticle">
		<div class="_wrap">
			<div id="_content" style="padding-bottom: 30px;">
				<div id="sub_content" class="_inner" style="padding-top: 40px;">					
					<div class="_contentArea _formArea">
						<div class="postWrap">
							<input type="hidden" id="srchNm" name="srchNm" value="${param.srchNm}">
							<input type="hidden" id="srchSdt" name="srchSdt" value="${param.srchSdt}">
							<input type="hidden" id="srchEdt" name="srchEdt" value="${param.srchEdt}">
							<input type="hidden" id="contentIdx" name="contentIdx" value="${param.contentIdx}">
							<input type="hidden" id="empIdx" name="empIdx" value="${defaultInfo.empIdx}">


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
                                        	</div>
                                        </dd>
                                    </dl>
                                    <dl>
                                        <dt><label>사원명</label></dt>
                                        <dd class="sel_2part">
                                            ${defaultInfo.empNm}
                                        </dd>
                                        
                                        <dt><label>재직 여부</label></dt>
                                        <dd>${defaultInfo.resiYn}</dd>
                                    </dl>

                                    <dl>
                                    	<dt><label>부서</label></dt>
                                        <dd class="sel_2part">
											${defaultInfo.deptNm}
                                        </dd>

                                        <dt></dt>
                                        <dd></dd>
                                    </dl>

                                    <dl>
                                    	<dt><label>직급</label></dt>
                                        <dd class="sel_2part">
											${defaultInfo.gradeNm}
                                        </dd>
                                        
                                        <dt></dt>
                                        <dd></dd>
                                    </dl>
                                    <dl>
                                        <dt><label>연락처</label></dt>
                                        <dd class="sel_2part">
											${defaultInfo.empPhone}
                                        </dd>
                                    
                                        <dt><label>성별</label></dt>
                                        <dd class="sel_2part">
                                        	<c:choose>
                                        		<c:when test="${defaultInfo.empGender eq 'M'}">남자</c:when>
                                        		<c:otherwise>여자</c:otherwise>
                                        	</c:choose>
                                        </dd>
                                    </dl>
                                    <dl>
                                        <dt><label>주소</label></dt>
                                        <dd class="sel_2part">
                                        	${defaultInfo.empAddr}
                                        </dd>
                                        
                                        <dt><label>상세 주소</label></dt>
                                        <dd class="sel_2part">
                                        	${defaultInfo.empAddrInfo}
                                        </dd>
                                    </dl>
                                	<dl>
                                        <dt><label>아이디</label></dt>
                                        <dd class="sel_2part">
                                        	${defaultInfo.empId}
                                        </dd>
                                		
                                		<dt><label>메일 주소</label></dt>
                                        <dd class="sel_2part">
                                        	${defaultInfo.empEmail}
                                        </dd>
                                	</dl>    
								</div><!-- End postWriteWrap -->
                                
	                                <div class="btnWrap alignR">
										<div class="floatR">
											<c:choose>
												<c:when test="${defaultInfo.resiYn eq 'N'}">
													<input type="button" class="_btn _grey" value="복직처리" onclick="resiProc(this.form);">
												</c:when>
												<c:otherwise>
													<input type="button" class="_btn _line" value="수정" onclick="modCall('${defaultInfo.empIdx}')">
													<input type="button" class="_btn _grey" value="퇴사처리" onclick="resiProc(this.form);">
												</c:otherwise>
											</c:choose>
										</div>
										<div class="floatL">
											<a class="_btn _blue" onclick="listCall();">목록으로</a>
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