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
	$(document).ready(function() {
		// 목록 추가 (add), 데이터 있음 (data),  데이터 없음 (none)
		var itemLine = $("#itemLine").val();
		var isData = itemLine == '' ? 'none' : 'data';
		setItem(isData);
		
		$(document).on("click", "#item_del", function() {
			// 물품 삭제
			$(this).parent().parent().remove();
		});
	});
	
	// 목록 추가
	function setItem(flag) {
		//
		var str = "";
		var obj = new Object();
		//
		if(flag == "add"){
			//
			obj["mgtNo"] 		= "";
		    obj["itemNm"] 		= "";
		 	obj["itemCnt"] 		= "";
		    obj["reqRsn"] 		= "";
			
			addItem(obj);
			
		} else if(flag == "data") {
			// 목록 조회
			var data = $("#itemLine").val();
			var items = data.split("@").filter(item => item != "");
			//
			items.forEach(function(item) {
				var parts = item.split('|');
				// 관리번호|제품명|수량|사유@...
				obj["mgtNo"] 		= parts[0];
			    obj["itemNm"] 		= parts[1];
			 	obj["itemCnt"] 		= parts[2];
			    obj["reqRsn"] 		= parts[3];
				//
				str += addItem(obj);
			});
		}
	}
	
	// 물품 등록 생성
	function addItem(obj){
		//
		var str = "";

		str += "<tr class='setItemTr'>";
		str += 		"<td class='first_td'>";
		str += 			"<input type='text' id='mgtNo' class='add_height' name='mgtNo' style='width:140px; text-align:center;' value='" + obj["mgtNo"] + "'>"
		str += 		"</td>";
		str += 		"<td>";
		str += 			"<input type='text' id='itemNm' class='add_height' name='itemNm' style='width:240px;' value='" + obj["itemNm"] + "'>"
		str += 		"</td>";
		str += 		"<td>";
		str += 			"<input type='text' id='itemCnt' class='add_height' name='itemCnt' style='width:85px; text-align:center;' value='" + obj["itemCnt"] + "' oninput='numProc(this);'>";
		str += 		"</td>";
		str += 		"<td>";
		str += 			"<input type='text' id='reqRsn' class='add_height' name='reqRsn' style='width:420px;' value='" + obj["reqRsn"] + "'>";
		str += 		"</td>";
		str += 		"<td>";
		str += 			"<span id='item_del' class='task_del' onclick=\"delCall(this);\"></span>";
		str += 		"</td>";
		str += "</tr>";
		//
		$(".itemTbl").append(str);
		//
		$(".add_height").css({
				'height':'35px'
			,	'line-height':'35px'
		});
	}
	
	// 화면 상 제거
	function delCall(t){
		$(t).closest("tr").remove();
	}
	
	// 목록 초기화
	function initItem(f){
		//
		if($(".setItemTr").length==0){
			alert("<spring:message code="ADD.CNT.NONE"/>");
			return;
		}
		//
		if(confirm("초기화하시겠습니까?")){
			var data = $("#itemLine").val();
			//
			if(data != ""){
				// 초기화
				$(".setItemTr").remove();
				// 재 생성
				var items = data.split("@").filter(item => item != "");
				var obj = new Object();
				var str = "";
				
				items.forEach(function(item) {
				    var parts = item.split('|');
					// 관리번호|제품명|수량|사유@...
					obj["mgtNo"] 		= parts[0];
				    obj["itemNm"] 		= parts[1];
				 	obj["itemCnt"] 		= parts[2];
				    obj["reqRsn"] 		= parts[3];
					//
					str += addItem(obj);
				});
			} else {
				$(".setItemTr").remove();
			}
		}
	}
	
	// 목록 저장
	function itemProc(type){
		//
		var itemLine = "";			// 목록 항목
		var itemYn = true; 		// 유효성 플래그
		var reqCnt = 0;
		//	
		$(".setItemTr").each(function(idx){
			// 항목 등록
			// (관리번호|제품명|수량|사유@...)
			var mgtNo = $(this).find("input[name='mgtNo']").val();
			var itemNm = $(this).find("input[name='itemNm']").val();
			var itemCnt = $(this).find("input[name='itemCnt']").val();
			var reqRsn = $(this).find("input[name='reqRsn']").val();

			//	유효성 검증		
			if(mgtNo == '' || mgtNo == null || mgtNo == 'undefined'){
				alert((idx + 1) + "번째 항목의 관리번호를 입력해주세요.");
				itemYn = false;
				return false;
			}
			if(itemNm == '' || itemNm == null || itemNm == 'undefined'){
				alert((idx + 1) + "번째 항목의 제품명을 입력해주세요.");
				itemYn = false;
				return false;
			}
			if(itemCnt == '' || itemCnt == null || itemCnt == 0 || itemCnt == 'undefined'){
				alert((idx + 1) + "번째 항목의 수량을 입력해주세요.");
				itemYn = false;
				return false;
			}
			if(reqRsn == '' || reqRsn == null || reqRsn == 'undefined'){
				alert((idx + 1) + "번째 항목의 사유를 입력해주세요.");
				itemYn = false;
				return false;
			}
			// 등록 건수
			reqCnt++;
			// 
			itemLine += mgtNo + "|" + itemNm + "|" + itemCnt + "|" + reqRsn;
    		itemLine += "@";
		});
		
		// 특정 항목이 입력되지 않은 경우
		if(!itemYn) return false;
		
		// 한 건도 등록되지 않은 경우
		if(reqCnt == 0){
			alert("<spring:message code="APRV.ITEM.NONE"/>");
			return;
		}
		
		// 등록		
		if(confirm("<spring:message code="APRV.ITEM.CONFIRM"/>")){
			$("#itemLine").val(itemLine);
			alert("<spring:message code="APRV.ITEM.SUCCESS"/>");
			popClose(type);
		}
	}
</script>

<div class="post_table_wrap scroll_wa">
	<table class="post_table itemTbl">
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
