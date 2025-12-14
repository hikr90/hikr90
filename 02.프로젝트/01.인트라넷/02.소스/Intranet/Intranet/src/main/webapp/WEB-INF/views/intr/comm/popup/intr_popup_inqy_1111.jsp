<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" 	uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="spring" 	uri="http://www.springframework.org/tags" %>

<!-- 
	view : intr_popup_inqy_1111
	title : RESTful API 상세
-->
<script>
	$(document).ready(function(){
		// 
	});
</script>

<div class="post_view" style="margin: 0; margin-top:20px;">
	<dl>
		<dt>요청 URL</dt>
		<dd>
			<input type="text" id="reqUrl" name="reqUrl" value="${defaultInfo.reqUrl}" readonly="readonly" style="width: 410px;">
			<input type="button" class="btn_blue" value="복사" onclick="copyUrl('#reqUrl');" style="margin-bottom: 5px;">
		</dd>
	</dl>
	<dl>
		<dt>반환 JSON</dt>
		<dd class="post_text" style="height: 440px;">
			<textarea readonly="readonly">${defaultInfo.jsonData}</textarea>
		</dd>
	</dl>
</div><!-- End post_view -->
