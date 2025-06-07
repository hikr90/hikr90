<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" 	uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="spring" 	uri="http://www.springframework.org/tags" %>

<!-- 
	view : intr_popup_inqy_1061
	title : 물품 등록 팝업
-->
<script>
	var addCnt = 0;
	$(document).ready(function() {
		// 물품 삭제
		$(document).on("click", "#item_del", function() {
			$(this).parent().parent().remove();
		});
	});
	
	// 목록 추가
	function addItem() {
		//
		var itemStr = "";
		
		itemStr += "<tr class='setListTr'>";
		itemStr += 		"<td class='first_td'>";
		itemStr += 			"<input type='text' id='mgtNo' class='add_height' name='mgtNo' style='width:140px; text-align:center;' value=''>"
		itemStr += 		"</td>";
		itemStr += 		"<td>";
		itemStr += 			"<input type='text' id='itemNm' class='add_height' name='itemNm' style='width:240px;' value=''>"
		itemStr += 		"</td>";
		itemStr += 		"<td>";
		itemStr += 			"<input type='text' id='itemCnt' class='add_height' name='itemCnt' style='width:85px; text-align:center;' value='0' oninput='numProc(this);'>";
		itemStr += 		"</td>";
		itemStr += 		"<td>";
		itemStr += 			"<input type='text' id='reqRsn' class='add_height' name='reqRsn' style='width:420px;' value=''>";
		itemStr += 		"</td>";
		itemStr += 		"<td>";
		itemStr += 			"<span id='item_del' class='task_del'></span>";
		itemStr += 		"</td>";
		itemStr += "</tr>";
		//
		$(".post_table_wrap .post_table").append(itemStr);
		addCnt++;
		//
		$(".add_height").css({
				'height':'35px'
			,	'line-height':'35px'
		});
	}
	
	// 목록 초기화
	function initItem(f){
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

<div class="post_table_wrap scroll_wa">
	<table class="post_table">
		<caption>물품 등록 목록</caption>
		<colgroup>
			<col class="w15per">
			<col class="w25per">
			<col class="w10per">
			<col class="wAutoper">
			<col class="w8per">
		</colgroup>
		<thead>
			<tr style="line-height: 10px;">
				<th scope="col">관리번호</th>
				<th scope="col">제품명</th>
				<th scope="col">수량</th>
				<th scope="col">사유</th>
				<th scope="col">삭제</th>
			</tr>
		</thead>
		<tbody></tbody>
	</table>
</div>
