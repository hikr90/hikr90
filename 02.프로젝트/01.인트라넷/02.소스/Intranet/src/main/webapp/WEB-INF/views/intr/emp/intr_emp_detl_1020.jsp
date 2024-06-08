<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1010.jsp" %>

<style>._formArea .postWrite, ._formArea .postView {margin-bottom: 31px;}</style>
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
        	url : 'intrEmpInqy1011.do',
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
		if(chqEmpYn!="Y"){
			alert("<spring:message code="EMP.ID.CHECK"/>");
			return;
		}
		if($("#empPwd").val()!=$("#chqPwd").val()){
			alert("비밀번호가 일치하지 않습니다.");
			return;
		}
		//
		if(confirm("등록하시겠습니까?")){
			//		
			var fileList = setFileList();
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
	   						location.href = "intrEmpInqy1010.do";
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
</script>
</head>
<body id="main">
<form id="form" method="POST" enctype="multipart/form-data">
	<!-- MENU -->
	<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1030.jsp" %>

	<article id="_subArticle">
		<div class="_wrap">
			<div id="_content" style="padding-bottom: 10px;">
				<div id="sub_content" class="_inner" style="padding-top: 40px;">	
					<div class="_contentArea _formArea">
						<div class="postWrap">
							<input type="hidden" id="modCnt" name="modCnt" value="0">

							<!-- Form postWriteWrap  -->
                            <div class="">
                            <h2>사원 등록</h2>
                                <div class="postWrite">
                                    <dl style="height: 150px;">
                                        <dt><label>사진 등록</label></dt>
                                        <dd>
                                        	<div style="display: -webkit-inline-box;">
                                        	<div class="empProfile">
                                        		<img class="empImg" id="empImg" src="resources/images/icon/icon_emp.png">
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
                                            <input type="text" title="사원명" id="empNm" name="empNm">
                                        </dd>
                                        
                                        <dt></dt>
                                        <dd></dd>
                                    </dl>

                                    <dl>
                                    	<dt><label>부서</label></dt>
                                        <dd class="sel_2part">
											<select id="deptCd" name="deptCd">
											<c:forEach var="list" items="${deptList}" varStatus="status">
												<option value="${list.deptCd}">${list.deptNm}</option>
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
												<option value="${list.gradeCd}">${list.gradeNm}</option>
											</c:forEach>
											</select>
                                        </dd>
                                        
                                        <dt></dt>
                                        <dd></dd>
									</dl>
                                    <dl>
                                        <dt><label>연락처</label></dt>
                                        <dd class="sel_2part">
                                            <input type="text" title="연락처" id="empPhone" name="empPhone" maxlength="13" onkeydown="inputNum(this);" >
                                        </dd>
										
										<dt><label>성별</label></dt>
                                        <dd class="sel_2part">
                                        	<div class="_radioBox enter-chkBox">
                                            	<span class="radio-area">
                                                	<input type="radio" id="chk-local" name="empGender" value="M" checked="checked">
                                                	<label for="chk-local">남자<span></span></label>
                                            	</span>
                                            	<span class="radio-area">
                                                	<input type="radio" id="chk-foreign" name="empGender" value="F" >
                                                	<label for="chk-foreign">여자<span></span></label>
                                            	</span>
                                            </div>
                                        </dd>
                                    </dl>
                                    <dl>
                                        <dt><label>주소</label></dt>
                                        <dd class="sel_2part">
                                            <input type="text" title="주소" readonly="readonly" id="empAddr" name="empAddr">
                                            <input type="button" class="stb-box-btn" value="주소 검색" onclick="srchAddr();" style="margin-bottom: 5px;">
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
                                            <input type="button" class="stb-box-btn" value="중복 확인" onclick="chqEmpId(this.form)" style="margin-bottom: 5px;">
                                        </dd>
                                        
                                        <dt><label>메일 주소</label></dt>
                                        <dd class="sel_2part">
                                            <input type="text" title="메일 주소" id="empEmail" name="empEmail">
                                        </dd>
                                    </dl>

									<dl>
										<dt><label>비밀번호</label></dt>
                                        <dd class="sel_2part">
                                            <input type="password" title="비밀번호" id="empPwd" name="empPwd" style="margin-bottom: 5px;">
                                        </dd>
                                        <dt><label>비밀번호 확인</label></dt>
                                        <dd class="sel_2part">
                                        	<input type="password" title="비밀번호 확인" id="chqPwd" name="chqPwd" style="margin-bottom: 5px;">
                                       	</dd>
                                    </dl>
									</div><!-- End postWriteWrap -->
                                <div class="btnWrap alignR">
                                	<input type="button" class="_btn _grey" onclick="regProc(this.form);" value="등록">
                                    <a class="_btn _line" onclick="location.href='intrEmpInqy1010.do'">취소</a>
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