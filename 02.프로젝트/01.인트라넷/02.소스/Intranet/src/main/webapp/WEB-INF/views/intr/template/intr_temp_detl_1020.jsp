<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core" %>
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
			<input type="text" id="templateNm" class="templateNm" title="양식명" name="templateNm">
		</dd>
	</dl>
	<dl>
		<dt>
			<label for="post-title">&#10003; 양식 내용</label>
		</dt>
		<dd>
			<textarea id="editor" name="templateCont" title="양식 내용"></textarea>
		</dd>
	</dl>
</div>

<div class="btn_wrap align_right">
	<button type="button" class="btn_navy_thin" onclick="regProc(this.form);">등록</button>	
	<button type="button" class="btn_gray_thin" onclick="delArea('tree_info');">취소</button>
</div>
