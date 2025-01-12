<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1010.jsp" %>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
	// 아이디 중복 여부
	var chqEmpYn = "N";
	//
	$(document).ready(function(){
		// 그룹코드 변경 감지
		$(document).on('change','#empId',function() {
			chqEmpYn = "N";
		});
		
		// 주소 입력란 클릭 시, 주소 검색 동작
		$("#empAddr").on('click',function(){
			srchAddr();
		});
	});
	
	// 아이디 중복 조회
	function chqEmpId(f) {
		//
		if($("#empId").val()==""){
			alert("아이디를 입력해주세요.");
			return;			
		}
		//
		var param = $("#form").serialize();
		$.ajax({
    		type : 'post',
        	url : 'intrEmpInqy2020.do',
            data : param,
            dataType : 'html',
            success : function(data){
     				//
     				var json = eval(data);
   					if(json[0].res=="NO"){
   						//
   	     				chqEmpYn = "Y";
   						alert("<spring:message code="EMP.ID.SUCCESS"/>"); // ALERT
   					} else {
						//
   	     				chqEmpYn = "N";
						alert("<spring:message code="EMP.ID.FAIL"/>"); // ALERT
   					}
            },
            error : function(data){
            	//
				alert("<spring:message code="PROC.ERROR"/>");
            }
      	});
	}

	// 사원 등록 처리
	function regProc(f){
		// 유효성 검증
		if(!validation()){return;};
		//
		if($("#setDeptCd").val()==""){
			alert("<spring:message code="EMP.DEPT.NONE"/>");
			return;
		}
		if($("#setGradeCd").val()==""){
			alert("<spring:message code="EMP.GRADE.NONE"/>");
			return;
		}
		if(chqEmpYn!="Y"){
			alert("<spring:message code="EMP.GRADE.NONE"/>");
			return;
		}
		if($("#empPwd").val()!=$("#chqPwd").val()){
			alert("비밀번호가 일치하지 않습니다.");
			return;
		}
		//
		if(confirm("등록하시겠습니까?")){
			var fileList = setFormData();
			//
			$.ajax({
				url:"intrEmpProc1010.do",
				processData : false,
				contentType : false,
				data: fileList,
				type : 'post',
	            success : function(data){
	     				//
	     				var json = eval(data);
	     				if(json[0].res=='YES'){
   	   						//
   							alert("<spring:message code="PROC.SUCCESS"/>");
	   						location.href = "intrEmpInqy1010.do?pageUrl=Emp";
	   						
	     				} else {
	     					//
	     					alert("<spring:message code="PROC.FAIL"/>");
							return;	
	     				}
	            },
	            error : function(data){
	            	//
					alert("<spring:message code="PROC.ERROR"/>");
	            }
	      	});
		}		
	}
	
	// 목록으로
	function listCall() {
		formSubmit('intrEmpInqy1010.do');
	}
</script>
</head>
<body id="main">
<form id="form" method="POST" enctype="multipart/form-data">
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
									<input type="hidden" id="page" name="page" value="${param.page}">
									<input type="hidden" id="pageUrl" name="pageUrl" value="${param.pageUrl}">
		
		                            <h2>사원 등록</h2><br>
	                                <div class="post_write">
	                                    <dl>
	                                        <dt>
	                                        	<label>사진 등록</label>
	                                        </dt>
	                                        <dd>
	                                        	<div class="profile_wrap disp_flex">
		                                        	<div class="profile_area">
		                                        		<img class="emp_img" id="empImg" width="100" height="100" src="resources/images/icon/icon_emp.png">
	                                        		</div>
	    
		                                        	<div class="profile_box mt10 ml20">
		                                        		<br><span id="profText">사진을 등록해주세요.</span>
			                                        	<div style="margin-top: 5px;">
			                                        		<label for="profBtn" class="btn_blue">등록</label> 
															<input type="file" id="profBtn">
															<input type="hidden" id="profImg" name="profImg" value="">
		                                        			<input type="button" class="btn_gray" id="profDel" value="삭제"> 
		                                        		</div>
		                                        	</div>
	                                        	</div>
	                                        </dd>
	                                    </dl>
	                                    <dl>
	                                        <dt><label>사원명</label></dt>
	                                        <dd class="sel_2part">
	                                            <input type="text" title="사원명" id="empNm" name="empNm">
	                                        </dd>
	                                        
	                                        <dt><label>성별</label></dt>
	                                        <dd class="sel_2part">
	                                        	<div class="radio_box enter-check_box">
	                                            	<span class="radio-area">
	                                                	<input type="radio" id="chk-yes" name="empGender" value="M" checked="checked">
	                                                	<label for="chk-yes">남자<span></span></label>
	                                            	</span>
	                                            	<span class="radio-area">
	                                                	<input type="radio" id="chk-no" name="empGender" value="F" >
	                                                	<label for="chk-no">여자<span></span></label>
	                                            	</span>
	                                            </div>
	                                        </dd>
	                                    </dl>
	                                    <dl>
	                                    	<dt><label>부서</label></dt>
	                                        <dd class="sel_2part">
												<div class="select_wrap">
													<div id="deptList" class="sList select_box">부서를 선택해주세요.</div>
													<input type="hidden" id="setDeptCd" name="setDeptCd" value="">
													<input type="hidden" id="setDeptNm" name="setDeptNm" value="">
												
													<ul class="sUl select_ul">
														<c:forEach var="list" items="${deptList}">
															<c:if test="${not empty list.deptCd}"><li setNm="${list.deptNm}" setCd="${list.deptCd}">${list.deptNm}</li></c:if>
														</c:forEach>
													</ul>
												</div>
	                                        </dd>
	                                        
	                                        <dt><label>직급</label></dt>
	                                        <dd class="sel_2part">
	                                        	<div class="select_wrap">
													<div id="gradeList" class="sList select_box">직급을 선택해주세요.</div>
													<input type="hidden" id="setGradeCd" name="setGradeCd" value="">
													<input type="hidden" id="setGradeNm" name="setGradeNm" value="">
												
													<ul class="sUl select_ul">
														<c:forEach var="list" items="${gradeList}">
															<c:if test="${not empty list.gradeCd}"><li setNm="${list.gradeNm}" setCd="${list.gradeCd}">${list.gradeNm}</li></c:if>
														</c:forEach>
													</ul>
												</div>
	                                        </dd>
	                                    </dl>
	                                    <dl>
	                                        <dt><label>연락처</label></dt>
	                                        <dd class="sel_2part">
	                                            <input type="text" title="연락처" id="empPhone" name="empPhone" maxlength="13" onkeydown="inputNum(this);" >
	                                        </dd>
											
											<dt></dt>
											<dd></dd>
	                                    </dl>
	                                    <dl>
	                                        <dt><label>주소</label></dt>
	                                        <dd class="sel_2part">
	                                            <input type="text" title="주소" readonly="readonly" id="empAddr" name="empAddr">
	                                            <input type="button"class="btn_blue align_top" value="주소 검색" onclick="srchAddr();">
	                                        </dd>
	                                        
	                                        <dt><label>상세 주소</label></dt>
	                                        <dd class="sel_2part">
	                                            <input type="text" title="상세주소" id="empAddrInfo" name="empAddrInfo">
	                                        </dd>
	                                    </dl>
	                                    <dl>
	                                        <dt><label>아이디</label></dt>
	                                        <dd class="sel_2part">
	                                            <input type="text" title="아이디" name="empId" id="empId" oninput="this.value=this.value.replace(/[^a-zA-Z0-9]/g,'')">
	                                            <input type="button"class="btn_blue align_top" value="중복 확인" onclick="chqEmpId(this.form)">
	                                        </dd>
	                                        
	                                        <dt><label>메일 주소</label></dt>
	                                        <dd class="sel_2part">
	                                            <input type="text" title="메일 주소" id="empEmail" name="empEmail">
	                                        </dd>
	                                    </dl>
										<dl>
											<dt><label>비밀번호</label></dt>
	                                        <dd class="sel_2part">
	                                            <input type="password" title="비밀번호" id="empPwd" name="empPwd">
	                                        </dd>
	                                        <dt><label>비밀번호 확인</label></dt>
	                                        <dd class="sel_2part">
	                                        	<input type="password" title="비밀번호 확인" id="chqPwd" name="chqPwd">
	                                       	</dd>
	                                    </dl>
									</div><!-- End post_write -->
										
	                                <div class="btn_wrap align_right">
	                                	<button type="button" class="btn_navy_thin" onclick="regProc(this.form);">등록</button>
	                                    <button type="button" class="btn_gray_thin" onclick="listCall();">취소</button>
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