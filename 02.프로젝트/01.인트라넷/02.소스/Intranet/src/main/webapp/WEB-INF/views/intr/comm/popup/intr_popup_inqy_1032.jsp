<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<script>
	// 팝업 닫기
	function popConfirm(){
		popClose('popupArea');
	}
	
	// 툴팁 관련
</script>

<!-- 결재선 목록 -->
<div id="treeInfo" class="treeInfo" style="width: 995px; margin-left: 0px; margin-bottom: 2%; height: 468px; overflow: hidden; display: inline-block;">
	<div class="postWrap" style="padding-top: 20px;">
		<div class="scrollTableWrap">
			<table class="postTable">
				<caption>결재선 목록</caption>
				<colgroup>
					<col class="w10per">
					<col class="w15per">
					<col class="w20per">
					<col class="w20per">
					<col class="w25per">
					<col class="w10per">
				</colgroup>
				<thead>
					<tr>
						<th scope="col">순번</th>
						<th scope="col">진행 단계</th>
						<th scope="col">부서</th>
						<th scope="col">이름</th>
						<th scope="col">처리 일자</th>
						<th scope="col">사유</th>
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
							<td><c:if test="${list.aprvRsltResn ne null and list.aprvRsltResn ne ''}">
								<div class="tooltip">
									<img src="resources/images/icon/icon_tooltip.png" style="height: 17px;">
									<span class="tooltiptext tooltip-bottom">[결재 의견] ${list.aprvRsltResn}</span>
								</div>
							</c:if></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div><!-- End postWrap -->
</div>