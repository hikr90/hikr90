<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!-- 
	view : intr_popup_inqy_1041
	title : 결재선 등록 팝업
-->

<script>
	var aprvCnt = 0;
	$(document).ready(function(){
		// 결재선 생성
		setAprvLine(false);
		
		// 셀렉트 박스 클릭
		$(document).on("click", ".pop_sbox", function () {
			$(this).siblings(".pop_sul").toggle(); // 리스트 열고 닫기
		});
		// 셀렉트 박스 항목 클릭
		$(".pop_sul li").on("click", function () {
		 //
		  var setNm = $(this).attr("setNm");
		  var setCd = $(this).attr("setCd");
		  var wrap = $(this).closest(".select_wrap");
		  //
		  wrap.find(".pop_sbox").text(setNm);
		  wrap.find("input[name=aprvCd]").val(setCd);
		  wrap.find("input[name=aprvNm]").val(setNm);
		  //
		  wrap.find(".pop_sul").hide();
		});
	});
	
	// 목록 이동 
	function setAprvLine(defaultYn){
		//
		if(defaultYn==true){
			// 체크한 건이 없는 경우
			var checkedIdx = $("input[name=radioIdx]:checked");
			if(checkedIdx.length==0){
				alert("<spring:message code="CHECK.NONE"/>");
				return;
			}

			// 변수
			var str = "";													// 결재선
			var empIdx = checkedIdx.val();					// 사번
			var empNm = checkedIdx.attr("empNm");		// 사원명
			var orgNm = checkedIdx.attr("orgNm");		// 부서명
			var rankNm = checkedIdx.attr("rankNm");		// 직급명
			//
			var arrLine = [
			    <c:forEach var="list" items="${typeList}" varStatus="status">
			    	<c:if test="${status.index != 0}">
				      {
				        name: '${list.commcodeNm}',
				        code: '${list.commcodeCd}'
				      }<c:if test="${!status.last}">,</c:if>
			      </c:if>
			    </c:forEach>
			 ];
			
			// 목록 생성
			str += "<tr id='setListTr"+aprvCnt+"' class='setListTr' empIdx='"+empIdx+"'>"
			str += "		<td>" + orgNm + "</td>";
			str += "		<td>" + empNm + " " + rankNm + "</td>";
			str += "		<td style='padding: 0;'>";
			//
			str += "  		<div class='select_wrap'>";
			str += "    			<div id='typeList"+aprvCnt+"' class='pop_sbox' style='width:126px; border:unset; text-indent:0px;'></div>";
			str += "    			<input type='hidden' id='aprvCd' name='aprvCd' name='aprvCd' value=''>";
			str += "    			<input type='hidden' id='aprvNm' name='aprvNm' name='aprvNm' value=''>";
			str += "				";
			str += "    			<ul class='sUl pop_sul scroll_wrap' style='width:126px;'>";
			
			// 반복문 동작
			arrLine.forEach(item => {
			  str += "      			<li setNm='"+item.name+"' setCd='"+item.code+"'>" + item.name + "</li>";
			});
			
			str += "    			</ul>";
			str += "  		</div>";
 			str += "		</td>";
			str += "		<td><div id='divArea' onclick=\"delCall('setListTr"+aprvCnt+"');\"><a>삭제</a></div></td>";
			str += "</tr>";

		} else {
			//
			str += "<tr id='setListTr"+aprvCnt+"' class='setListTr' empIdx='${empVO.empIdx}'>"
			str += "		<td>${empVO.orgNm}</td>";
			str += "		<td>${empVO.empNm}</td>";
			str += "		<td>기안</td>";
			str += "		<td></td>";
			str += "</tr>";
		}
	
		// 결재선 추가
		$(".aprvLineTbl").append(str);
		aprvCnt++;
		
		// hover 이벤트
		$(".sUl li").hover(function(){
			$(this).addClass("hover").siblings().removeClass("hover");
		});
		
		// 항목 선택
		$(".sUl li").on("click", function () {
		    var setNm = $(this).attr("setNm");
		    var setCd = $(this).attr("setCd");

			// 값 지정
			$(this).closest('div').find('div').text(setNm);
			$(this).closest('div').find('input').val(setCd);
			$(this).closest('div').find('input').next().val(setNm);

			// 목록 닫기
			$(".sUl").css("display","none");
		});
	}

	// 화면 상 제거
	function delCall(setListTr){
		// 화면 상 삭제 처리
		$("#"+setListTr).remove();
	}
	
	// 결재선 등록
	function popConfirm(f){
		// 결재선
		var aprvLine = "";
		// 유효성 검증
		var setAprvIdx = "";
		var setStatCd = "";
		var setStatCnt = 0;
		//
		$(".setListTr").each(function(){
			
		});
		// 결재자가 없는 경우
		if(setStatCnt<2){
			alert("<spring:message code="APRV.LINE.NONE"/>");
			return;
		};
		
		// 결재선 저장
		$("#aprvLine").val(aprvLine);
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
<div id="treeArrow" class="tree_arrow" onclick="setAprvLine(true);"></div>

<!-- 결재선 목록 -->
<div id="tree_info" class="tree_info" style="width: 640px; height: 425px; border: solid 2px #f6f6f6; padding: 10px;">
	<div class="post_wrap">
		<div class="scroll_wrap" style="height: 410px;">
			<table class="post_table aprvLineTbl">
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
						<th scope="col">단계</th>
						<th scope="col">삭제</th>
					</tr>
				</thead>
				<tbody>
					<!-- 결재선 추가 -->
				</tbody>
			</table>
		</div>
	</div><!-- End post_wrap -->
</div>