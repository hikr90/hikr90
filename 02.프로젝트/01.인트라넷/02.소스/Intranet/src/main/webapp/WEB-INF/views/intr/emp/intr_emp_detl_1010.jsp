<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1010.jsp" %>

<script type="text/javascript">
	// 목록으로
	function listCall() {
		formSubmit('intrEmpInqy1010.do');
	}
	
	// 수정 화면
	function modCall() {
		formSubmit('intrEmpInqy1040.do');
	}
	
	// 복직 퇴사 처리
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
	   						alert("<spring:message code="PROC.SUCCESS"/>");
	   						formSubmit('intrEmpInqy1030.do');
	   					} else {
							//
							alert("<spring:message code="PROC.FAIL"/>");
	   					}
	            },
	            error : function(data){
	            	//
					alert("<spring:message code="PROC.ERROR"/>");
	            }
	      	});
		}
	}
</script>
</head>
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
									<input type="hidden" id="srchNm" name="srchNm" value="${param.srchNm}">
									<input type="hidden" id="srchSdt" name="srchSdt" value="${param.srchSdt}">
									<input type="hidden" id="srchEdt" name="srchEdt" value="${param.srchEdt}">
									<input type="hidden" id="contId" name="contId" value="${param.contId}">
									<input type="hidden" id="empIdx" name="empIdx" value="${defaultInfo.empIdx}">
		
		                            <h2>사원 상세</h2><br>
	                                <div class="post_write">
	                                    <dl>
	                                        <dt><label>프로필</label></dt>
	                                        <dd>
	                                        	<div>
	                                        	<div class="emp_profile">
	                                        		<c:choose>
	                                        			<c:when test="${not empty defaultList}">
	                                        				<img class="emp_img" id="emp_img" width="100" height="100" src="intrEmpInqy1012.do?contId=${defaultList[0].contId}&fileOrglNm=${defaultList[0].fileOrglNm}">
	                                        			</c:when>
	                                        			<c:otherwise>
			                                        		<img class="emp_img" id="emp_img" width="100" height="100" src="resources/images/icon/icon_emp.png">
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
	                                        
	                                        <dt><label>성별</label></dt>
	                                        <dd class="sel_2part">
	                                        	<c:choose>
	                                        		<c:when test="${defaultInfo.empGender eq 'M'}">남자</c:when>
	                                        		<c:otherwise>여자</c:otherwise>
	                                        	</c:choose>
	                                        </dd>
	                                    </dl>
	                                    <dl>
	                                    	<dt><label>부서</label></dt>
	                                        <dd class="sel_2part">
												${defaultInfo.deptNm}
	                                        </dd>
	                                        
	                                    	<dt><label>직급</label></dt>
	                                        <dd class="sel_2part">
												${defaultInfo.gradeNm}
	                                        </dd>
	                                    </dl>
	                                    <dl>
	                                        <dt><label>연락처</label></dt>
	                                        <dd class="sel_2part">
												${defaultInfo.empPhone}
	                                        </dd>
	                                    
	                                        <dt><label>재직 여부</label></dt>
	                                        <dd>${defaultInfo.resiYn}</dd>
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
									</div>
		                                
	                                <div class="btn_wrap align_right">
										<div class="float_right">
											<c:choose>
												<c:when test="${defaultInfo.resiYn eq 'N'}">
													<button type="button" class="btn_navy_thin" onclick="resiProc(this.form);">복직처리</button>
												</c:when>
												<c:otherwise>
													<button type="button" class="btn_blue_thin" onclick="modCall('${defaultInfo.empIdx}')">수정</button>
													<button type="button" class="btn_gray_thin" onclick="resiProc(this.form);">퇴사처리</button>
												</c:otherwise>
											</c:choose>
										</div>
										<div class="float_left">
											<button type="button" class="btn_navy_thin" onclick="listCall();">목록으로</button>
										</div>
									</div>
		                        </div><!-- End post_wrap -->
							</div><!-- End content_area form_area -->
						</div><!-- End sub_content -->
					</div><!-- End content -->
				</article>
			</div>
		</div>
	</div>
</form>
</body>
	
<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1020.jsp" %>