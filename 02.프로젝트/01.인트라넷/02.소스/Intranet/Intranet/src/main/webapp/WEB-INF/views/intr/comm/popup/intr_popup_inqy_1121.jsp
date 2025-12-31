<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" 	uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="spring" 	uri="http://www.springframework.org/tags" %>

<!-- 
	view : intr_popup_inqy_1121
	title : 업무 스케쥴러 등록 팝업
-->
<script>
	$(document).ready(function(){
		// 데이트피커 초기화
		initDatepicker();
		
		// 버튼 제어
		$(".regBtn").show();
		$(".mdBtn").hide();
	});
</script>

<div class="post_view" style="margin: 0; margin-top:20px;">
	<dl>
		<dt>&#10003; 업무 제목</dt>
		<dd>
			<input type="text" id="tldrTitle" name="tldrTitle" title="업무 제목" value="">
		</dd>
	</dl>
	<dl class="post_info">
		<dt>&#10003; 업무 기간</dt>
		<dd>
			<input type="text" class="srch_cdt_date srchSdt" id="srchSdt" name="tldrSdt" title="업무 기간 (시작)" value="" readonly="readonly" />
				~
			<input type="text" class="srch_cdt_date srchEdt" id="srchEdt" name="tldrEdt" title="업무 기간 (종료)" value="" readonly="readonly" />
		</dd>
	</dl>
	<dl>
		<dt>&#10003; 업무 내용</dt>
		<dd class="post_text" style="height: 160px;">
			<textarea id="tldrCont" name="tldrCont" title="업무 내용"></textarea>
		</dd>
	</dl>
</div><!-- End post_view -->
