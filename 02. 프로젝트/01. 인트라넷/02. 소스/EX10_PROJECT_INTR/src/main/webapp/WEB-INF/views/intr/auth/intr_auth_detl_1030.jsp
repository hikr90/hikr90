<!--명칭 : intr_comm_detl_1030
	작성자 : 김태현
	작성일자 : 2023.01.26
	내용 : 관리자 권한 수정 화면-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- Form postWriteWrap  -->
<h2 style="display: table;">정보 수정</h2>
<div class="postWrite">
	<dl>
		<dt>
			<label for="post-title">권한명</label>
		</dt>
		<dd>
			<input type="text" id="authNm" title="권한명" name="authNm" value="${defaultInfo.authNm}">
			<input type="hidden" class="authCd" id="authCd" name="authCd" value="${defaultInfo.authCd}">
		</dd>
	</dl>
	<dl>
		<dt>
			<label>사용여부</label>
		</dt>
		<dd>
			<div class="_radioBox enter-chkBox">
				<span class="radio-area"> 
					<input type="radio" id="chk-local" name="useYn" value="Y" <c:if test="${defaultInfo.useYn eq 'Y'}">checked</c:if>> 
					<label for="chk-local">예<span></span></label>
					
					<input type="radio" id="chk-foreign" name="useYn" value="N" <c:if test="${defaultInfo.useYn ne 'Y'}">checked</c:if>> 
					<label for="chk-foreign">아니오<span></span></label>
				</span> 
			</div>
		</dd>
	</dl>
	<dl>
		<dt>
			<label for="post-title">비고</label>
		</dt>
		<dd>
			<textarea rows="5" cols="30" id="remark" title="비고" name="remark">${defaultInfo.remark}</textarea>
		</dd>
	</dl>
</div>

<div class="btnWrap alignR" style="float:right;">
	<input type="button" class="_btn _grey" onclick="modProc(this.form);" value="수정 완료">	
	<a onclick="detCall('${defaultInfo.authCd}');" class="_btn _line">취소</a>
</div>
