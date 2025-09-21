<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" 	uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>

<div class="post_write" style="margin: 0px;">
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
			<div class="radio_box enter-check_box">
				<span class="radio-area"> 
					<input type="radio" id="chk-yes" name="useYn" checked="checked" value="Y"> 
					<label for="chk-yes">예<span></span></label>
					
					<input type="radio" id="chk-no" name="useYn" value="N"> 
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
			<textarea rows="10" cols="30" title="비고" id="remark" name="remark"></textarea>
		</dd>
	</dl>
</div>

<div class="btn_center align_right">
	<button type="button" class="btn_navy_thin" onclick="regProc(this.form);">등록</button>
	<button type="button" class="btn_gray_thin" onclick="delArea('tree_info');">취소</button>
</div>
