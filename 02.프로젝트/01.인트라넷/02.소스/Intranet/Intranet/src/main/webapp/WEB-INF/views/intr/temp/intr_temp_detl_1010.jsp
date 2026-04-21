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

<div class="post_write" style="margin-top: 0px;">
	<dl>
		<dt>
			<label for="post-title">&#10003; 양식명</label>
		</dt>
		<dd>
			<input type="text" id="tempNm" title="양식명" name="tempNm" value="${defaultInfo.tempNm}">
			<input type="hidden" class="tempCd" id="tempCd" name="tempCd" value="${defaultInfo.tempCd}">
		</dd>
		<dt>사용여부</dt>
        <dd class="sel_2part">
        	<div class="radio_box enter-check_box">
            	<span class="radio-area">
                	<input type="radio" id="chk-yes" name="useYn" value="Y" <c:if test="${defaultInfo.useYn eq 'Y'}">checked="checked"</c:if>>
                	<label for="chk-yes">Y<span></span></label>
            	</span>
            	<span class="radio-area">
                	<input type="radio" id="chk-no" name="useYn" value="N" <c:if test="${defaultInfo.useYn eq 'N'}">checked="checked"</c:if>>
                	<label for="chk-no">N<span></span></label>
            	</span>
            </div>
        </dd>
	</dl>
	<dl>
		<dt>
			<label for="post-title">&#10003; 양식 내용</label>
		</dt>
		<dd>
			<textarea id="editor" name="tempCont" title="양식 내용">${defaultInfo.tempCont}</textarea>
		</dd>
	</dl>
</div>

<div class="btn_wrap align_right">
	<button type="button" class="btn_navy_thin" onclick="modProc(this.form);">수정</button>
</div>
	