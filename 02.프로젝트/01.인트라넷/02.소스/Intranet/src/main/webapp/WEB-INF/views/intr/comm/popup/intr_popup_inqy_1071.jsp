<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" 	uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="spring" 	uri="http://www.springframework.org/tags" %>

<!-- 
	view : intr_popup_inqy_1071
	title : 정산내역 등록 팝업
-->
<script>
	var addCnt = 0;
	$(document).ready(function() {
		// 물품 삭제
		$(document).on("click", "#corp_del", function() {
			$(this).parent().parent().remove();
		});
	});
	
	// 목록 추가
	function addCorp() {
		//
		var corpStr = "";
		
		corpStr += "<tr class='setListTr'>";
		corpStr += 		"<td class='first_td'>";
		corpStr += 			"<input type='text' id='corpNm' class='add_height' name='corpNm' style='width:240px;' value=''>"
		corpStr += 		"</td>";
		corpStr += 		"<td>";
		corpStr += 			"<input type='text' id='corpCnt' class='add_height' name='corpCnt' style='width:190px; text-align:center;' value='₩0' oninput='amtProc(this);'>";
		corpStr += 		"</td>";
		corpStr += 		"<td>";
		corpStr += 			"<input type='text' id='corpRsn' class='add_height' name='corpRsn' style='width:420px;' value=''>";
		corpStr += 		"</td>";
		corpStr += 		"<td>";
		corpStr += 			"<span id='corp_del' class='task_del'></span>";
		corpStr += 		"</td>";
		corpStr += "</tr>";
		//
		$(".post_table_wrap .post_table").append(corpStr);
		addCnt++;
		//
		$(".add_height").css({
				'height':'35px'
			,	'line-height':'35px'
		});
	}
	
	// 목록 초기화
	function initCorp(f){
		//
		if(addCnt==0){
			alert("<spring:message code="ADD.CNT.NONE"/>");
			return;
		}
		
		if(confirm("초기화하시겠습니까?")){
			addCnt = 0;
			$(".setListTr").remove();
		}
	}
</script>

<div class="post_table_wrap scroll_wrap">
	<table class="post_table">
		<caption>정산내역 등록 목록</caption>
		<colgroup>
			<col class="w25per">
			<col class="w20per">
			<col class="wAutoper">
			<col class="w8per">
		</colgroup>
		<thead>
			<tr style="line-height: 10px;">
				<th scope="col">사용처</th>
				<th scope="col">사용 금액</th>
				<th scope="col">용도</th>
				<th scope="col">삭제</th>
			</tr>
		</thead>
		<tbody></tbody>
	</table>
</div>
