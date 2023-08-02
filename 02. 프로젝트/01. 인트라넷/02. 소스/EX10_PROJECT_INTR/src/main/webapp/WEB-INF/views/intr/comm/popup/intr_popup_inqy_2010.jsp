<!--명칭 : intr_popup_inqy_2010
	작성자 : 김태현
	작성일자 : 2023.08.02
	내용 : 결재의견 입력 팝업-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1010.jsp" %>

<!DOCTYPE html>
<html>
<script type="text/javascript">
	// 팝업 종료
	function popClose(){
		window.close();
	}
	
	// 팝업 확인
	function popConfirm(){
		// 결재 비밀번호
		var aprvPwd = $("#aprvPwd").val();
		var empPwd = "${empVO.empPwd}";
		var aprvResn = $("#aprvResn").val();
		//
		if(aprvPwd==''){
			alert("<spring:message code="APRV.PWD.NONE"/>");
			return;
		}

		if(aprvPwd!=empPwd){
			alert("<spring:message code="APRV.PWD.FAIL"/>");
			return;
		}
		
		// 결재 수신 처리
		opener.parent.aprvProc();
	}
</script>
<body style="overflow-x: hidden; overflow-y: hidden;">
<form id="form">
<div class="_popList">
	<article id="_subArticle">
		<div class="_wrap">
			<div id="_content">
				<div id="sub_content" class="_inner">					
					<div class="_contentArea _formArea" style="margin-bottom: 0px;">
                        <div class="_find_info_Wrap">
                            <div class="postWrap" style="height: 350px;">
                                <div id="postCon">
                                	<h2>결재 의견 입력</h2>
									
									<div>
										<div class="postWrite" style="margin-bottom: 40px;">
											<dl>
												<dt>
													<label>비밀번호</label>
												</dt>
												<dd class="sel_2part">
													<input type="password" id="aprvPwd" name="aprvPwd" title="비밀번호" style="width: 100%;" value="">
												</dd>
											</dl>
											<dl>
												<dt>
													<label>결재 의견</label>
												</dt>
												<dd class="sel_2part">
													<textarea rows="5" cols="20" id="aprvResn" name="aprvResn"></textarea>
												</dd>
											</dl>
										</div>
										<!-- End postWriteWrap -->
									</div>
                                </div>
                                
                                <div class="btn_center">
                                	<input type="button" class="_btn _grey" value="확인" onclick="popConfirm();">
                                    <input type="button" class="_btn _line" value="취소" onclick="popClose();">
                                </div>
                            </div><!-- End postWrap -->
                          </div> 
					</div><!-- End _contentArea _formArea -->
				</div><!-- End _inner -->
			</div><!-- End _content -->
		</div><!-- End _wrap -->
	</article>
</div>
</form>
</body>
</html>