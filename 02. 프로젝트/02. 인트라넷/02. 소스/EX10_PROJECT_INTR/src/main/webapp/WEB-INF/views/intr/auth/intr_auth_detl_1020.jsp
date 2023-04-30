<!--명칭 : intr_auth_detl_1020
	작성자 : 김태현
	작성일자 : 2023.01.26
	내용 : 관리자 권한 등록 화면-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" 	uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>

<!-- Form postWriteWrap  -->
<h2 style="display: table;">신규 등록</h2>
<div class="postWrite">
	<dl>
		<dt>
			<label for="post-title">권한명</label>
		</dt>
		<dd>
			<input type="text" id="authNm" class="authNm" title="권한명" name="authNm">
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
