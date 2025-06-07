<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!-- 
	view : intr_popup_inqy_1042
	title : 결재선 조회 팝업
-->
<script>
	// 함수
	$(document).ready(function(){
		// 툴팁 클릭 시 결재 의견 노출
		$(".tooltip_area").on("click", function(){
			$(".tooltip_text").css("display","block");
		});
		
		// 외부 영역 클릭 시 결재 의견 숨김
		$("body").on("click", function(e){
			if($(".tooltip_text").css("display") == "block"){
		    	if($(".tooltip_area").has(e.target).length == 0) $(".tooltip_text").css('display','none');
		    }
		});
	});

	// 팝업 닫기
	function popConfirm(){
		popClose('opin');
	}
</script>

<div class="post_wrap">
	<!-- 결재의견 -->
	<div class="post_view" style="margin-top: -10px;">
		<dl>
			<dt>
				<label for="post-title">결재 의견</label>
			</dt>
			<dd class="post_text" style="height: 105px;">
				<textarea id="rsltRsn" title="결재의견" id="rsltRsn" name="rsltRsn" style="height: 10px;" placeholder="결재자를 클릭해주세요." readonly="readonly"></textarea>
			</dd>
		</dl>
	</div>

	<!-- 결재선 목록 -->
	<div id="tree_info" class="tree_info">
		<div class="post_wrap">
			<div class="scroll_wrap">
				<table class="post_table">
					<caption>결재선 목록</caption>
					<colgroup>
						<col class="w10per">
						<col class="w20per">
						<col class="auto">
						<col class="w20per">
						<col class="w20per">
					</colgroup>
					<thead>
						<tr>
							<th scope="col">순번</th>
							<th scope="col">결재 유형</th>
							<th scope="col">결재자</th>
							<th scope="col">처리 유형</th>
							<th scope="col">처리 일자</th>
						</tr>
					</thead>
					<tbody>
						<!-- 결재선 목록 -->
						<c:forEach var="list" items="${typeList}" varStatus="status">
							<tr>
								<td>${list.num}</td>
								<td>${list.stepNm}</td>
								<td>${list.orgNm}</td>
								<td>${list.empNm}</td>
							</tr>
						</c:forEach>
						
						<c:if test="${empty typeList}">
							<tr>
								<td align="center" colspan="5">
                              	      결재내역이 없습니다.
                                </td>
							</tr>
						</c:if>
					</tbody>
				</table>
			</div>
		</div><!-- End post_wrap -->
	</div>
</div>