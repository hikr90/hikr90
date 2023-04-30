<!--명칭 : intr_temp_detl_1020
	작성자 : 김태현
	작성일자 : 2022.12.30
	내용 : 관리자 템플릿 등록 화면-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" 	uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="spring" 	uri="http://www.springframework.org/tags" %>

<!-- Form postWriteWrap  -->
<h2 style="display: table;">신규 등록</h2>
<div class="postWrite">
	<dl>
		<dt>
			<label for="post-title">템플릿명</label>
		</dt>
		<dd>
			<input type="text" id="templateNm" class="templateNm" title="템플릿명" name="templateNm">
		</dd>
	</dl>
	<dl>
		<dt>
			<label for="post-title">상위 템플릿명</label>
		</dt>
		<dd>
			<input type="text" id="upprTemplateNm" class="upprTemplateNm" title="상위템플릿명" name="upprTemplateNm" readonly="readonly" style="width: 75%;">
			<input type="hidden" id="upprTemplateCd" class="upprTemplateCd" name="upprTemplateCd">
			<input type="button" class="stb-box-btn" value="선택" style="margin-left: 3px; margin-right: 5px; margin-bottom: 5px;" onclick="popCall();" >
			<input type="button" class="stb-box-btn-grey" value="삭제" style="margin-right: -15px; margin-bottom: 5px;" onclick="delPopCall();">
		</dd>
	</dl>
	<dl>
		<dt>
			<label>사용여부</label>
		</dt>
		<dd class="sel_2part">
			<div class="_radioBox enter-chkBox">
				<span class="radio-area"> 
					<input type="radio" id="chk-local" name="useYn" checked="checked" value="Y"> 
					<label for="chk-local">예<span></span></label>
					
					<input type="radio" id="chk-foreign" name="useYn" value="N"> 
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
			<textarea rows="10" cols="30" title="비고" id="remark" name="remark"></textarea>
		</dd>
	</dl>
</div>

<div class="btnWrap alignR" style="float:right;">
	<input type="button" class="_btn _grey" onclick="regProc(this.form);" value="등록">	
	<a onclick="delArea('treeInfo');" class="_btn _line">취소</a>
</div>
