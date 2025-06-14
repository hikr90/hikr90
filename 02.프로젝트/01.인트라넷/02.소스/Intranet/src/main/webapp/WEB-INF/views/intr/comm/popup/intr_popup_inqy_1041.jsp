<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!-- 
	view : intr_popup_inqy_1041
	title : 결재선 등록 팝업
-->
<script>
	$(document).ready(function(){
		// 목록 추가 (add), 데이터 있음 (data),  데이터 없음 (none)
		var aprvLine = $("#aprvLine").val();
		var isData =  aprvLine == '' ? 'none' : 'data';
		setAprvLine(isData);
	});
	
	// 결재선 처리
	function setAprvLine(flag){
		var cIdx = $("input[name=radioIdx]:checked");
		var obj = new Object();
		var str = "";
		
		
		// 목록 추가
		if(flag=="add"){
			if(cIdx.length==0){
				alert("<spring:message code="CHECK.NONE"/>");
				return;
			}
			// 첫 시작
			obj["aprvIdx"] = cIdx.val();											// 사번
			obj["empNm"] = cIdx.attr("empNm");							// 사원
			obj["orgNm"] = cIdx.attr("orgNm");								// 부서
			obj["rankNm"] = cIdx.attr("rankNm");							// 직급
			obj["aprvNm"] = "";														// 결재 유형
			
			// 목록 생성
			str += addLine(obj);
			
		} else if(flag=="data") {
			// 목록 있음
			var data = $("#aprvLine").val();
			var items = data.split("@").filter(item => item !== "");
			//
			items.forEach(function(item) {
			    var parts = item.split('|');
			 	// 결재유형|사번|기안|부서|직급|이름@...
			    obj["aprvCd"] 		= parts[0];
			 	obj["aprvIdx"] 		= parts[1];
			 	obj["aprvNm"] 		= parts[2];
			    obj["orgNm"] 		= parts[3];
			    obj["rankNm"] 		= parts[4];
			    obj["empNm"] 		= parts[5];
				//
			    str += addLine(obj);
			});
		} 
		
		// 셀렉트 박스 클릭
		$(".pop_sbox").on("click", function () {
			$(this).siblings(".pop_sul").toggle(); // 리스트 열고 닫기
		});

		// hover 이벤트
		$(".pop_sul li").hover(function(){
			$(this).addClass("hover").siblings().removeClass("hover");
		});
		
		// 항목 선택
		$(".pop_sul li").on("click", function () {
		    var setNm = $(this).attr("setNm");
		    var setCd = $(this).attr("setCd");
			var setIdx = $(this).attr("setIdx");
		    
			// 값 지정
			$(this).closest('div').find('div').text(setNm);
			$(this).closest('div').find('input[name=aprvCd]').val(setCd);
			$(this).closest('div').find('input[name=aprvNm]').val(setNm);
			$(this).closest('div').find('input[name=aprvIdx]').val(setIdx);

			// 목록 닫기
			$(".sUl").css("display","none");
		});
	}

	// 결재선 생성
	function addLine(obj){
		//
		var str = "";
		var arrLine = [
	    <c:forEach var="list" items="${typeList}" varStatus="status">
	    	<c:if test="${status.index > 1}">
		      {
		        name: '${list.commcodeNm}',
		        code: '${list.commcodeCd}'
		      }<c:if test="${!status.last}">,</c:if>
	      	</c:if>
	    </c:forEach>
	 	];
		
		str += "<tr class='setListTr' empIdx='" + obj["aprvIdx"] + "'>"
		str += "		<td>" + obj["orgNm"] + "</td>";
		str += "		<td>" + obj["empNm"] + " " + obj["rankNm"] + "</td>";
		str += "		<td style='padding: 0;'>";
		//
		str += "  		<div class='select_wrap'>";
		str += "    			<div class='pop_sbox' style='width:126px; border:unset; text-indent:0px;'>" + obj["aprvNm"] + "</div>";
		str += "    			<input type='hidden' id='aprvCd' name='aprvCd' name='aprvCd' value='" + obj["aprvCd"] + "'>";
		str += "    			<input type='hidden' id='aprvNm' name='aprvNm' name='aprvNm' value='" + obj["aprvNm"] + "'>";
		str += "    			<input type='hidden' id='aprvIdx' name='aprvIdx' name='aprvIdx' value='" + obj["aprvIdx"] + "'>";
		str += "    			<input type='hidden' id='orgNm' name='orgNm' name='orgNm' value='" + obj["orgNm"] + "'>";
		str += "    			<input type='hidden' id='rankNm' name='rankNm' name='rankNm' value='" + obj["rankNm"] + "'>";
		str += "    			<input type='hidden' id='empNm' name='empNm' name='empNm' value='" + obj["empNm"] + "'>";
		str += "				";
		str += "    			<ul class='sUl pop_sul scroll_wrap' style='width:126.5px; margin-left: -1px;'>";
		
		// 반복문 동작
		arrLine.forEach(item => {
		  str += "      			<li setNm='"+item.name+"' setCd='"+item.code+"' setIdx='" + obj["aprvIdx"] + "'>" + item.name + "</li>";
		});
		
		str += "    			</ul>";
		str += "  		</div>";
		str += "		</td>";
		str += "		<td><div id='divArea' onclick=\"delCall(this);\"><a>삭제</a></div></td>";
		str += "</tr>";
		
		$(".aprvTbl").append(str);
	}
	
	// 화면 상 제거
	function delCall(t){
		$(t).closest("tr").remove();
	}
	
	// 결재선 등록
	function lineProc(type){
		//
		var aprvLine = "";		// 결재선
		var aprvCnt = 0;		// 결재자 수
		var aprvYn = true;		// 유효성 플래그
		//
		$(".setListTr").each(function(idx){
			// 결재자 확인
			var aprvCd = $(this).find("input[name='aprvCd']").val();
			
			if(aprvCd == 'TYPE_0020'){		// 결재
				aprvCnt++;
			}
			
			// 결재 유형이 선택되지 않음
			if(idx != 0 && (aprvCd == '' || aprvCd == null || aprvCd == 'undefined')){
				alert((idx + 1) + "번째 항목의 결재 유형이 선택되지 않았습니다.");
				aprvYn = false;
				return false;
			}
			
			// 결재선 등록
			// (결재유형코드|결재자|기안|부서|직급|이름@...)
   			var aprvCd = $(this).find("input[name='aprvCd']").val();
    		var aprvNm = $(this).find("input[name='aprvNm']").val();
    		var aprvIdx = $(this).find("input[name='aprvIdx']").val();
    		var orgNm = $(this).find("input[name='orgNm']").val();
    		var rankNm = $(this).find("input[name='rankNm']").val();
    		var empNm = $(this).find("input[name='empNm']").val();
    		//
    		aprvLine += aprvCd + "|" + aprvIdx + "|" + aprvNm + "|" + orgNm + "|" + rankNm + "|" + empNm;
    		aprvLine += "@";
		});
		
		// 결재 유형이 선택되지 않은 경우
		if(!aprvYn) return false;

		// 결재자가 없는 경우
		if(aprvCnt<1){
			alert("<spring:message code="APRV.LINE.ONE"/>");
			return;
		};
		
		// 결재선 저장
		if(confirm("<spring:message code="APRV.LINE.CONFIRM"/>")){
			$("#aprvLine").val(aprvLine);
			alert("<spring:message code="APRV.LINE.SUCCESS"/>");
			popClose(type);
		}
	}
</script>

<!-- 부서 사용자 트리 -->
<div class="tree_wrap">
	<div class="tree_area" id="tree_area" style="width: 300px; height: 445px;"> 
		<div class="tree">
			<ul class="ul_1">
											
			<c:forEach var="list" items="${empList}" varStatus="status">
				<c:set var="spanIcon"	value="icon_folder"/>
				<c:set var="spanNm"	value="${list.orgNm}"/>

				<c:set var="nextLv"	value=""/>
				<c:set var="prevLv"	value=""/>
												
				<c:if test="${list.isleaf eq 'Y'}">
					<c:set var="spanIcon" 	value="icon_list"/> 
					<c:set var="spanNm"	value="${list.empNm}"/>
				</c:if>
												
				<c:if test="${empty list.lv }">
					<c:set var="nextLv"	value="1"/>
				</c:if>
													
				<!-- 태그 열기 -->
				<c:choose>
					<c:when test="${list.lv gt prevLv}">
						<ul class="ul_${list.lv}">
							<li class="li_${list.lv}">
							<span class="${spanIcon}"></span>
							<c:if test="${list.isleaf eq 'Y'}">
								<input type="radio" id="radio${status.index}" name="radioIdx" value="${list.empIdx}" orgNm="${list.orgNm}" empNm="${list.empNm}" rankNm="${list.rankNm}">
							</c:if>
							<label for="radio${status.index}">${spanNm}</label>
					</c:when>
					<c:when test="${list.lv eq prevLv}">
						<c:if test="${list.isleaf eq 'Y'}">
							<input type="radio" id="radio${status.index}" name="radioIdx" value="${list.empIdx}" orgNm="${list.orgNm}" empNm="${list.empNm}" rankNm="${list.rankNm}">
						</c:if>
						<label for="radio${status.index}">${spanNm}</label>
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
<div id="treeArrow" class="tree_arrow" onclick="setAprvLine('add');"></div>

<!-- 결재선 목록 -->
<div id="tree_info" class="tree_info" style="width: 640px; height: 425px; border: solid 2px #f6f6f6; padding: 10px;">
	<div class="post_wrap">
		<div class="scroll_wrap" style="height: 410px;">
			<table class="post_table aprvTbl">
				<caption>결재선 목록</caption>
				<colgroup>
					<col class="w30per">
					<col class="w35per">
					<col class="w20per">
					<col class="w15per">
				</colgroup>
				<thead>
					<tr>
						<th scope="col">부서</th>
						<th scope="col">성함</th>
						<th scope="col">결재유형</th>
						<th scope="col">삭제</th>
					</tr>
				</thead>
				<tbody>
					<!-- 결재선 추가 -->
					<tr class="setListTr" empIdx="${empVO.empIdx}">
						<td>${empVO.orgNm}</td>
						<td>${empVO.empNm} ${empVO.rankNm}</td>
						<td>기안
							<input type="hidden" id="aprvCd" name="aprvCd" value="TYPE_0010">
							<input type="hidden" id="aprvNm" name="aprvNm" value="기안">
							<input type="hidden" id="aprvIdx" name="aprvIdx" value="${empVO.empIdx}">
							<input type="hidden" id="orgNm" name="orgNm" value="${empVO.orgNm}">
							<input type="hidden" id="rankNm" name="rankNm" value="${empVO.rankNm}">
							<input type="hidden" id="empNm" name="empNm" value="${empVO.empNm}">
						</td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div><!-- End post_wrap -->
</div>