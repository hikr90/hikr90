<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

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
		popClose('popupArea');
	}
</script>

<!-- 결재선 목록 -->
<div id="tree_info" class="tree_info">
	<div class="post_wrap">
		<div class="scroll_wrap">
			<table class="post_table">
				<caption>결재선 목록</caption>
				<colgroup>
					<col class="w10per">
					<col class="w15per">
					<col class="w20per">
					<col class="w20per">
					<col class="w10per">
					<col class="w25per">
				</colgroup>
				<thead>
					<tr>
						<th scope="col">순번</th>
						<th scope="col">진행 단계</th>
						<th scope="col">부서</th>
						<th scope="col">이름</th>
						<th scope="col">사유</th>
						<th scope="col">처리 일자</th>
					</tr>
				</thead>
				<tbody>
					<!-- 결재선 목록 -->
					<c:forEach var="list" items="${defaultList}" varStatus="status">
						<tr>
							<td>${list.num}</td>
							<td>${list.stepNm}</td>
							<td>${list.deptNm}</td>
							<td>${list.empNm}</td>
							<td>
								<c:if test="${list.aprvRsltResn ne null and list.aprvRsltResn ne ''}">
									<div class="tooltip_area">
										<img src="resources/images/icon/icon_tooltip.png" height="30" width="30">
										<span class="tooltip_text">[결재 의견]<br>${list.aprvRsltResn}</span>
									</div>
								</c:if>
							</td>
							<td>
								<span class="date">
									<!-- 처리 시작일 --> 
									<fmt:parseDate value="${list.aprvRsltDt}" var="parseDt" pattern="yyyyMMdd"/>
									<fmt:formatDate value="${parseDt}" var="formatDt" pattern="yyyy-MM-dd"/>
	
									<!-- 처리 시간 --> 
									<fmt:parseDate value="${list.aprvRsltTm}" var="parseTm" pattern="HHmmss"/>
									<fmt:formatDate value="${parseTm}" var="formatTm" pattern="HH:mm:ss"/>
									${formatDt} ${formatTm}
								</span>	
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div><!-- End post_wrap -->
</div>