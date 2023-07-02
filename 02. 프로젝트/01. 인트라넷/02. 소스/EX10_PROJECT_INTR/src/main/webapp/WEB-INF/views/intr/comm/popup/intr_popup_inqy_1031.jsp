<!--명칭 : intr_popup_inqy_1031
	작성자 : 김태현
	작성일자 : 2022.12.01
	내용 : 팝업 결재선 트리 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<script>
	$(document).ready(function(){
		// TRUE : 디폴트 추가 (기안자), FALSE (직접 추가)
		setAprvLine(true);
	});
	
	// 목록 이동 
	function moveBtn(defaultYn){
		// 체크한 건이 없는 경우
		if($("input[id=empIdx]:checked").length==0){
			alert("<spring:message code="CHECK.NONE"/>");
			return;
		}
		
		// 결재선 추가
		setAprvLine(false);
	}
	
	// 결재선 추가
	function setAprvLine(setLineYn){
		// 체크한 목록 결재선 추가
		var str = "";
		if(setLineYn==false){
			// 중복 확인
			$("input[id=empIdx]:checked").each(function() {
				// 중복 여부 변수
				var str = "";								// 결재선
				var dupeYn = 'Y';							// 중복 여부
				var empIdx = $(this).val();					// 사원 IDX
				var empNm = $(this).next().val();			// 사원명
				var deptNm = $(this).next().val();			// 부서명
	
					// 체크한 부서 사용자 확인
					$("input[id=aprvEmpIdx]").each(function() {
						// 중복되는 경우 중복 여부 값 변경
						var aprvEmpIdx = $(this).val();
						//
						if(aprvEmpIdx==empIdx){
							dupeYn = "Y";
							return; 
						}
					});
				
					// 미 중복
					if(dupeYn=='N'){
						//
						str += "<tr>"
						str += "	<td class='first-td'>";
						str += "		<span class='_chkBox'>";
						str += "		<input type='checkbox' class='checkbox' id='aprvEmpIdx' value='" + empIdx + "'/>"
						str += "		<label for='chk_local'><span></span></label></span>";
						str += "		<input type='hidden' name='aprvEmpIdx' value='" + empIdx + "'/>"
						str += "	</td>";
						str += "	<td>"+"준비중"+"</td>";
						str += "	<td>${empVO.deptNm}</td>";
						str += "	<td>${empVO.empNm}</td>";
						str += "	<td>삭제</td>";
						str += "</tr>";
					}	
				});
			
		} else { 
			// 기본 결재선 추가
			str += "<tr>"
			str += "	<td class='first-td'>";
			str += "		<span class='_chkBox'>";
			str += "		<input type='checkbox' class='checkbox' id='aprvEmpIdx' value='" + empIdx + "'/>"
			str += "		<label for='chk_local'><span></span></label></span>";
			str += "		<input type='hidden' name='aprvEmpIdx' value='" + empIdx + "'/>"
			str += "	</td>";
			str += "	<td>"+"준비중"+"</td>";
			str += "	<td>${empVO.deptNm}</td>";
			str += "	<td>${empVO.empNm}</td>";
			str += "	<td>삭제</td>";
			str += "</tr>";
		}
			
		// 체크 해제
		$(".aprvLineTbl").append(str);
		$("input[id='empIdx']").prop("checked", false);
		$(".aprvLineChk").prop("checked", false);
	}
</script>
<!-- 부서 사용자 트리 -->
<div class="treeWrap" style="display: inline;">
	<div class="treeArea" id="treeArea" style="width: 350px;"> 
		<div class="tree">
			<ul class="ul_1">
											
			<c:forEach var="list" items="${defaultList}" varStatus="status">
				<c:set var="spanIcon"	value="icon_folder"/>
				<c:set var="spanNm"	value="${list.deptNm}"/>

				<c:set var="nextLv"	value=""/>
				<c:set var="prevLv"	value=""/>
												
				<c:if test="${list.isleaf eq 'Y'}">
					<c:set var="spanIcon" 	value="icon_list"/> 
					<c:set var="spanNm"	value="${list.empNm}"/>
				</c:if>
												
				<c:if test="${ empty list.lv }">
					<c:set var="nextLv"	value="1"/>
				</c:if>
													
				<!-- 태그 열기 -->
				<c:choose>
					<c:when test="${list.lv gt prevLv}">
						<ul class="ul_${list.lv}">
							<li class="li_${list.lv}">
							<span class="${spanIcon}"></span>
							<c:if test="${list.isleaf eq 'Y'}">
								<input type="radio" id="empIdx" name="empIdx" value="${list.empIdx}">
							</c:if>${spanNm}
							<input type="hidden" id="empNm" name="empNm" value="${list.empNm}">
							<input type="hidden" id="deptNm" name="deptNm" value="${list.deptNm}">
					</c:when>
					<c:when test="${list.lv eq prevLv}">
						<c:if test="${list.isleaf eq 'Y'}">
							<input type="radio" id="empIdx" name="empIdx" value="${list.empIdx}">
						</c:if>${spanNm}
						<input type="hidden" id="empNm" name="empNm" value="${list.empNm}">
						<input type="hidden" id="deptNm" name="deptNm" value="${list.deptNm}">
					</c:when>
				</c:choose>
		
				<!-- 태그 닫기 -->										
				<c:choose>
					<c:when test="${list.lv gt nextLv}">
						</li>
															
						<c:forEach begin="1" end="${list.lv - nextLv}" varStatus="status">
							<c:if test="${list.lv ne '1'}">
									</ul>
								</li>
							</c:if>
						</c:forEach>
															
					</c:when>
					<c:when test="${list.lv eq nextLv}">
						</li>
					</c:when>
				</c:choose>
														
				<c:set var="prevLv" value="${list.lv}" />
			</c:forEach>
		</div>	
	</div>
</div>

<!-- 이동 화살표 -->
<div id="treeArrow" class="treeArrow" style="cursor: pointer; -webkit-transform: scaleX(-1);" onclick="moveBtn(this.form);"></div>

<!-- 결재선 목록 -->
<div id="treeInfo" class="treeInfo" style="width: 560px; margin-left: 0px; margin-bottom: 2%; height: 468px; overflow: hidden; display: inline-block;">
	<div class="postWrap" style="padding-top: 20px;">
		<div class="scrollTableWrap">
			<table class="postTable aprvLineTbl">
				<caption>결재선 목록</caption>
				<colgroup>
					<col class="w15per">
					<col class="w20per">
					<col class="w25per">
					<col class="w25per">
					<col class="w15per">
				</colgroup>
				<thead>
					<tr>
						<th scope="col">
							<span class="_chkBox">
								<input type="checkbox" class="checkbox aprvLineChk"> 
								<label for="chk-local"><span></span></label>
							</span>
						</th>
						<th scope="col">단계</th>
						<th scope="col">부서</th>
						<th scope="col">이름</th>
						<th scope="col">제거</th>
					</tr>
				</thead>
				<tbody>
				<!-- 결재선 추가 -->
				</tbody>
			</table>
		</div>
	</div><!-- End postWrap -->
</div>