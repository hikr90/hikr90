<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1010.jsp" %>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
	$(document).ready(function(){
		$(".a_title ").removeClass('list_bg');
	});

	// 수정 처리
	function updProc(f){
		try {
			// 비밀번호 검증
			var empPwd = $("#empPwd").val();
			var cPwd = $("#cPwd").val();
			//
			if(empPwd != ''){
				if(empPwd != cPwd){
					alert("<spring:message code="MYPAGE.PWD.DIFF"/>");
					return;
				}
			}
			
			// 유효성 검증
			if($("#addr").val() == ''){
				alert("<spring:message code="MYPAGE.ADDR.NONE"/>");
				return;
			}
			if($("#addrInfo").val() == ''){
				alert("<spring:message code="MYPAGE.ADDR.INFO.NONE"/>");
				return;
			}
			if($("#email").val() == ''){
				alert("<spring:message code="MYPAGE.EMAIL.NONE"/>");
				return;
			}
			
			// 연락처
			var regex = /^010-\d{4}-\d{4}$/;
			
			if(!regex.test($("#mobNo").val())){
				alert("<spring:message code="EMP.MOB.FAIL"/>");
				return;
			}
			//
			if(confirm("수정하시겠습니까?")){
				var fileList = setFormData();
				//
	   			$.ajax({
					url:"intrEmpProc1020.do",
					processData : false,
					contentType : false,
					data: fileList,
					type : 'POST',
	   				success : function(data){
	   						var json = eval(data);
	   						
	   						if(json[0].res=='YES'){
	   							alert("<spring:message code="PROC.SUCCESS"/>");
		   						$("#cancel").trigger('click');
		   						
	   						}else{
	   							alert("<spring:message code="PROC.FAIL"/>");
								return;	   							
	   						}
	   				},
	   				error : function(res, status, error){
	   					//
	   					alert("<spring:message code="PROC.ERROR"/>");
	   				}
	   			});
			}
			
		} catch (error) {
	        console.error("[Error] 수정 처리 : ", error.message);
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
		                            <h2>My Page</h2>
		                            <input type="hidden" name="empIdx" value="${defaultInfo.empIdx}">
		                            <input type="hidden" name="setOrgCd" value="${defaultInfo.orgCd}">
		                            <input type="hidden" name="setRankCd" value="${defaultInfo.rankCd}">
		                            <input type="hidden" name="isMale" value="${defaultInfo.isMale}">
		                            
		                            <div class="post_write">
		                            	<dl>
			                           		<dt>
			                           			<label>프로필</label>
			                           		</dt>
			                                <dd>
			                                	<div>
			                                    	<div class="emp_profile">
			                                        	<c:choose>
															<c:when test="${defaultInfo.profileYn eq 'Y'}">
                                 								<img id="empImg" class="emp_img" width="200" height="200" src="intrEmpInqy1099.do?sequenceId=${empVO.empIdx}">
			                                        		</c:when>
			                                        		<c:otherwise>
					                                        	<img id="empImg" class="emp_img" width="200" height="200" src="resources/images/icon/icon_profile.png">
			                                        		</c:otherwise>
			                                        	</c:choose>
			                                        </div>
			                                        
			                                        <div class="profile_box"></div>
			                               		</div>
			                               </dd>
		                               </dl>
		                               <dl>
		                               		<dt><label>사원명</label></dt>
		                               		<dd class="sel_2part">
			                           			${defaultInfo.empNm}
		                               		</dd>
		                               		<dt>
		                               			<label>성별</label>
		                               		</dt>
		                               		<dd class="sel_2part">
		                               			<c:if test="${defaultInfo.isMale eq 'Y'}">남자</c:if> 
		                               			<c:if test="${defaultInfo.isMale ne 'Y'}">여자</c:if> 
		                                    </dd>
		                              	</dl>
		                              	<dl>
		                              		<dt><label>부서</label></dt>
		                                    <dd class="sel_2part">
		                                    	${defaultInfo.orgNm}
		                                    </dd>
		                                    <dt><label>직급</label></dt>
		                                    <dd class="sel_2part">
			                                	${defaultInfo.rankNm}
		                                    </dd>
		                              	</dl>
		                              	<dl>
		                              		<dt><label>연락처</label></dt>
		                                    <dd class="sel_2part">
		                                    	<input type="text" title="연락처" id="mobNo" name="mobNo" maxlength="13" value="${defaultInfo.mobNo}" onkeyup="mobProc(this);">
		                                    </dd>
		                                        
		                                    <dt><label>메일 주소</label></dt>
		                                    <dd class="sel_2part">
		                                    	<input type="text" title="메일 주소" id="email" name="email" value="${defaultInfo.email}">
		                                    </dd>
		                             	</dl>
		                             	<dl>
		                             		<dt><label>주소</label></dt>
		                                    <dd class="sel_2part">
		                                    	<input type="text" title="주소" id="addr" readonly="readonly" id="addr" name="addr" value="${defaultInfo.addr}">
		                                        <input type="button" class="btn_blue align_top" value="주소 검색" onclick="addrProc();">
		                                    </dd>
		                                    <dt><label>상세 주소</label></dt>
		                                    <dd class="sel_2part">
		                                    	<input type="text" title="상세주소" id="addrInfo" name="addrInfo" value="${defaultInfo.addrInfo}">
		                                    </dd>
		                             	</dl>
		                             	<dl>
		                             		<dt><label>아이디</label></dt>
		                                    <dd class="sel_2part">
		                                    	${defaultInfo.empId}
		                                        <input type="hidden" title="아이디" name="empId" value="${defaultInfo.empId}">
		                                    </dd>
		                                    <dt><label>관리자 여부</label></dt>
		                                    <dd class="sel_2part">${empVO.authYn}</dd>
		                             	</dl>
									 	<dl>
		                             		<dt><label>비밀번호</label></dt>
		                                    <dd class="sel_2part">
		                                    	<input type="password" title="비밀번호 입력" id="empPwd" name="empPwd" value="">
		                                    	<span style="color: red; float: right; margin-top: 20px; font-size: 14px;">패스워드 입력 시, 비밀번호가 변경됩니다.</span>
		                                    </dd>
		                                    <dt><label>비밀번호 확인</label></dt>
		                                    <dd class="sel_2part">
		                                    	<input type="password" title="비밀번호 확인" name="cPwd" id="cPwd" value="">
		                                    </dd>
		                            	</dl>
									</div><!-- End post_write -->
		                                
		                            <div class="btn_wrap align_right">
		                            	<button type="button" class="btn_navy_thin" onclick="updProc(this.form);">수정완료</button>
		                                <button type="button" id="cancel" class="btn_gray_thin" onclick="location.href='${menuType eq '0' ? 'intrMainInqy1020.do' : 'intrMainInqy1030.do'}'">취소</button>
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
