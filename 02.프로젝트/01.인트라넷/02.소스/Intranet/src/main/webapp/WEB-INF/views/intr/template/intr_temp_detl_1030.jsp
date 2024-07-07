<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 	uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="post_write" style="margin-top: 0px;">
	<dl>
		<dt>
			<label for="post-title">템플릿명</label>
		</dt>
		<dd>
			<input type="text" id="tempNm" title="템플릿명" name="tempNm" value="${defaultInfo.tempNm}">
			<input type="hidden" class="tempCd" id="tempCd" name="tempCd" value="${defaultInfo.tempCd}">
		</dd>
	</dl>
	<dl>
		<dt>
			<label for="post-title">상위 템플릿명</label>
		</dt>
		<dd>
			<input type="text" id="upprTemplateNm" class="upprTemplateNm" title="상위 템플릿명" readonly="readonly" value="${defaultInfo.upprTemplateNm}">
			<input type="hidden" class="upprTemplateCd" id="upprTemplateCd" name="upprTemplateCd" value="${defaultInfo.upprTemplateCd}">

			<input type="button"class="btn_blue" value="선택" onclick="popCall();">
			<input type="button"class="btn_gray" value="삭제" onclick="delPopCall();">
		</dd>
	</dl>
	<dl>
		<dt>
			<label>사용여부</label>
		</dt>
		<dd>
			<div class="radio_box enter-check_box">
				<span class="radio-area"> 
					<input type="radio" id="chk-yes" name="useYn" value="Y" <c:if test="${defaultInfo.useYn eq 'Y'}">checked</c:if>> 
					<label for="chk-yes">예<span></span></label>
					
					<input type="radio" id="chk-no" name="useYn" value="N" <c:if test="${defaultInfo.useYn ne 'Y'}">checked</c:if>> 
					<label for="chk-no" class="ml10">아니오<span></span></label>
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

<div class="btn_wrap align_right">
	<button type="button" class="btn_navy" onclick="modProc(this.form);">수정완료</button>
	<button type="button" class="btn_gray" onclick="detCall('${defaultInfo.tempCd}');">취소</button>
</div>
