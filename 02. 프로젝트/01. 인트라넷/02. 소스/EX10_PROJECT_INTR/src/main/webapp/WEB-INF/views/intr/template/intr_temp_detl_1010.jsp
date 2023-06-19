<!--명칭 : intr_temp_detl_1010
	작성자 : 김태현
	작성일자 : 2022.12.30
	내용 : 관리자 템플릿 상세 화면-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" 	uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="spring" 	uri="http://www.springframework.org/tags" %>

<script>
	$(document).ready(function() {
		CKEDITOR.replace('editor',{ height: 500});
	});
</script>


<!-- Form postWriteWrap  -->
<div class="postWrite">
	<dl>
		<dt>
			<label for="post-title">템플릿명</label>
		</dt>
		<dd style="width: 50%;">
			<input type="text" id="templateNm" title="템플릿명" name="templateNm" value="${defaultInfo.templateNm}">
			<input type="hidden" class="templateCd" id="templateCd" name="templateCd" value="${defaultInfo.templateCd}">
		</dd>
		<dt>
			<label for="post-title">사용여부</label>
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
			<label for="post-title">템플릿 내용</label>
		</dt>
		<dd>
			<textarea id="editor" name="templateContent" title="템플릿 내용">${defaultInfo.templateContent}</textarea>
		</dd>
	</dl>
</div>

<div class="btnWrap alignR" style="float:right;">
	<input type="button" class="_btn _line" onclick="modProc(this.form);" value="수정">
	<input type="button" class="_btn _grep" onclick="delProc(this.form);" value="삭제">	
</div>
	