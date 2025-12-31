<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" 	uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="spring" 	uri="http://www.springframework.org/tags" %>

<!-- 
	view : intr_popup_inqy_1111
	title : API 상세
-->
<script>
	$(document).ready(function(){
		let jStr = '${jObj}';
 		let jParse = JSON.parse(jStr);
		let jPretty = JSON.stringify(jParse, null, 2);
		
		$("#jObj").text(jPretty);
	});
</script>

<div class="post_view" style="margin: 0; margin-top:20px;">
	<dl>
		<dt>반환 데이터 복사</dt>
		<dd>
			<input type="button" class="btn_blue" value="복사" onclick="copyUrl('#jObj');" style="margin-bottom: 5px;">
		</dd>
	</dl>
	<dl>
		<dt>반환 데이터</dt>
		<dd class="post_text" style="height: 440px;">
			<textarea id="jObj" readonly="readonly" style="color: #727272;"></textarea>
		</dd>
	</dl>
</div><!-- End post_view -->
