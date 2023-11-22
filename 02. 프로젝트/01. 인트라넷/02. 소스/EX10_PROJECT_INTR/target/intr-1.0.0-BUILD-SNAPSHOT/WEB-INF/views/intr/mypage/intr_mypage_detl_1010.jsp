<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1010.jsp" %>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
	
</script>
<body id="main">
	<form id="form" name="form" method="POST">
	<div id="modalArea">
		<c:import url="/WEB-INF/views/intr/comm/popup/intr_popup_inqy_1010.jsp"></c:import>	
	</div>

	<!-- MENU -->
	<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1030.jsp" %>
		
	<article id="_subArticle">
		<div class="_wrap">
			<div id="_content">
				<div id="sub_content" class="_inner">					
					<div class="_contentArea _formArea">
						<div class="postWrap">
							<!-- Form postWriteWrap  -->
                            <h2>MY PAGE</h2>
                            <div class="postWrite">
                            	<dl style="height: 150px;">
	                           		<dt><label>이미지</label></dt>
	                                <dd>
	                                	<div style="display: -webkit-inline-box;">
	                                    	<div class="empProfile">
	                                        	<c:choose>
	                                        		<c:when test="${ not empty defaultList }">
		                                 				<img class="empImg" id="empImg" src="getEmpImg.do?deptNm=${empInfo.deptNm}&empNm=${empInfo.empNm}&fileOrglNm=${defaultList[0].fileOrglNm}">
	                                        		</c:when>
	                                        		<c:otherwise>
			                                        	<img class="empImg" id="empImg" src="resources/images/icon/icon_emp.png">
	                                        		</c:otherwise>
	                                        	</c:choose>
	                                        </div>
	                                        
	                                        <div class="profileBox" style="margin-left: 20px; display: grid;">
	                                        	
	                                        </div>
	                               		</div>
	                               </dd>
                               </dl>
                               
                               <dl>
                               		<dt><label>사원명</label></dt>
                               		<dd class="sel_2part">
	                           			${empInfo.empNm}
                                    	<input type="hidden" title="사원번호" name="empIdx" value="${empInfo.empIdx}">
                               		</dd>
                               		<dt><label>성별</label></dt>
                               		<dd class="sel_2part">
                               			<div class="_radioBox enter-chkBox">
                                        	<span class="radio-area">
                                            	<input type="radio" id="chk-local" class="gender" name="gender" value="남자" <c:if test="${empInfo.gender eq '남자'}">checked="checked"</c:if>></input>
                                                <label for="chk-local">남자<span></span></label>
                                            </span>
                                            <span class="radio-area">
                                            	<input type="radio" id="chk-foreign" class="gender" name="gender" value="여자" <c:if test="${empInfo.gender eq '여자'}">checked="checked"</c:if>></input>
                                                <label for="chk-foreign">여자<span></span></label>
                                            </span>
                                       </div>
                                    </dd>
                              </dl>

                              <dl>
                              		<dt><label>부서</label></dt>
                                    <dd class="sel_2part">
                                    	${empInfo.deptNm}
                                    </dd>
                                    <dt><label>직급</label></dt>
                                    <dd class="sel_2part">
	                                	${empInfo.gradeNm}
                                    </dd>
                              </dl>

                              <dl>
                              		<dt><label>연락처</label></dt>
                                    <dd class="sel_2part">
                                    	<input type="text" title="연락처" name="phone" maxlength="13" value="${empInfo.phone}" onkeyup="ipNum(this);">
                                    </dd>
                                        
                                    <dt><label>메일 주소</label></dt>
                                    <dd class="sel_2part">
                                            <input type="text" title="메일 주소" name="email" value="${empInfo.email}">
                                        </dd>
                             </dl>
                             
                             <dl>
                             		<dt><label>주소</label></dt>
                                    <dd class="sel_2part">
                                    	<input type="text" title="주소" readonly="readonly" id="adrApi" name="adrApi" value="${empInfo.adr}">
                                        <input type="button" class="stb-box-btn" value="주소 검색" onclick="addrApi();">
                                    </dd>
                                    <dt><label>상세 주소</label></dt>
                                    <dd class="sel_2part">
                                    	<input type="text" title="상세주소" id="adrInfo" name="adrInfo" value="${empInfo.adrInfo}">
                                    </dd>
                             </dl>
                             
                             <dl>
                             		<dt><label>아이디</label></dt>
                                    <dd class="sel_2part">
                                    	${empInfo.empId}
                                        <input type="hidden" title="아이디" name="empId" value="${empInfo.empId}">
                                    </dd>
                                    <dt><label>관리자 여부</label></dt>
                                    <dd class="sel_2part">${empInfo.mgrYn}</dd>
                             </dl>
								
							 <dl>
                             		<dt><label>비밀번호</label></dt>
                                    <dd class="sel_2part">
                                    	<input type="password" title="비밀번호 입력" id="empPwd" name="empPwd" value="${empInfo.empPwd}">
                                    </dd>
                                    <dt><label>비밀번호 확인</label></dt>
                                    <dd class="sel_2part">
                                    	<input type="password" title="비밀번호 확인" name="cPwd" id="cPwd" value="">
                                    </dd>
                            </dl>

							</div><!-- End postWriteWrap -->
                                
                            <div class="btnWrap alignR">
                            	<input type="button" class="_btn _grey" onclick="updProc(this.form);" value="수정 완료">
                                <a class="_btn _line" onclick="location.href='empMain.do'">취소</a>
                            </div>
                    	</div><!-- End postWrap -->
					</div><!-- End _contentArea _formArea -->
				</div><!-- End _inner -->
			</div><!-- End _content -->
		</div><!-- End _wrap -->
	</article>
	</form>
	
<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1020.jsp" %>
