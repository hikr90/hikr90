<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1010.jsp" %>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
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
		                            <h2>My Page</h2><br>
		                            <div class="post_write">
		                            	<dl>
			                           		<dt>
			                           			<label>프로필</label>
			                           		</dt>
			                                <dd>
			                                	<div>
			                                    	<div class="emp_profile">
			                                        	<c:choose>
			                                        		<c:when test="${not empty defaultList}">
				                                 				<img id="empImg" class="emp_img" width="150" height="150" src="intrEmpInqy1012.do?deptNm=${defaultInfo.deptNm}&empNm=${defaultInfo.empNm}&fileNm=${defaultInfo[0].fileNm}">
			                                        		</c:when>
			                                        		<c:otherwise>
					                                        	<img id="empImg" class="emp_img" width="150" height="150" src="resources/images/icon/icon_emp.png">
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
		                                    	<input type="hidden" title="사원번호" name="empIdx" value="${defaultInfo.empIdx}">
		                               		</dd>
		                               		<dt>
		                               			<label>성별</label>
		                               		</dt>
		                               		<dd class="sel_2part">
		                               			<div class="radio_box">
		                                        	<span class="radio_area">
		                                            	<input type="radio" id="chk-yes" class="gender" name="gender" value="남자" <c:if test="${defaultInfo.empGender eq 'M'}">checked="checked"</c:if> disabled="disabled">
		                                                <label for="chk-yes">남자<span></span></label>
		                                            </span>
		                                            <span class="radio_area ml10">
		                                            	<input type="radio" id="chk-no" class="gender" name="gender" value="여자" <c:if test="${defaultInfo.empGender eq 'F'}">checked="checked"</c:if> disabled="disabled">
		                                                <label for="chk-no">여자<span></span></label>
		                                            </span>
		                                       </div>
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
		                                    	<input type="text" title="연락처" name="phone" maxlength="13" value="${defaultInfo.phone}" onkeyup="ipNum(this);">
		                                    </dd>
		                                        
		                                    <dt><label>메일 주소</label></dt>
		                                    <dd class="sel_2part">
		                                    	<input type="text" title="메일 주소" name="email" value="${defaultInfo.email}">
		                                    </dd>
		                             	</dl>
		                             	<dl>
		                             		<dt><label>주소</label></dt>
		                                    <dd class="sel_2part">
		                                    	<input type="text" title="주소" readonly="readonly" id="adrApi" name="adrApi" value="${defaultInfo.adr}">
		                                        <input type="button"class="btn_blue align_top" value="주소 검색" onclick="srchAddr();">
		                                    </dd>
		                                    <dt><label>상세 주소</label></dt>
		                                    <dd class="sel_2part">
		                                    	<input type="text" title="상세주소" id="adrInfo" name="adrInfo" value="${defaultInfo.adrInfo}">
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
		                                    	<input type="password" title="비밀번호 입력" id="empPwd" name="empPwd" value="${defaultInfo.empPwd}">
		                                    </dd>
		                                    <dt><label>비밀번호 확인</label></dt>
		                                    <dd class="sel_2part">
		                                    	<input type="password" title="비밀번호 확인" name="cPwd" id="cPwd" value="">
		                                    </dd>
		                            	</dl>
									</div><!-- End post_write -->
		                                
		                            <div class="btn_wrap align_right">
		                            	<button type="button" class="btn_navy_thin" onclick="updProc(this.form);">수정완료</button>
		                                <button type="button" class="btn_gray_thin" onclick="location.href='${menuType eq '0' ? 'intrMainInqy1020.do' : 'intrMainInqy1030.do'}'">취소</button>
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
