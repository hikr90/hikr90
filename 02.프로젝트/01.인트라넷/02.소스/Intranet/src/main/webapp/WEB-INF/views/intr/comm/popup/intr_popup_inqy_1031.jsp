<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<script>
	var aprvCnt = 0;
	$(document).ready(function(){
		//
		setAprvLine(false);
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
			var str = "";								// 결재선
			var empIdx = checkedIdx.val();				// 사원 IDX
			var empNm = checkedIdx.attr("empNm");		// 사원명
			var deptNm = checkedIdx.attr("deptNm");		// 부서명
			//
			str += "<tr id='setListTr"+aprvCnt+"' class='setListTr' empIdx='"+empIdx+"'>"
			str += "	<td>" + deptNm + "</td>";
			str += "	<td>" + empNm + "</td>";
			str += "	<td>";
			str += "		<select class='step_select'>";
			str += "			<option value='STEP_0002' selected>결재</option>";
			str += "			<option value='STEP_0003'>참조</option>";
			str += "		</select>";
			str += "	</td>";
			str += "	<td><div id='divArea' onclick=\"delCall('setListTr"+aprvCnt+"');\"><a>삭제</a></div></td>";
			str += "</tr>";

		} else {
			//
			str += "<tr id='setListTr"+aprvCnt+"' class='setListTr' empIdx='${empVO.empIdx}'>"
			str += "	<td>${empVO.deptNm}</td>";
			str += "	<td>${empVO.empNm}</td>";
			str += "	<td>";
			str += "		<select disabled class='step_select'>";
			str += "			<option value='STEP_0001' selected>기안</option>";
			str += "		</select>";
			str += "	</td>";
			str += "	<td></td>";
			str += "</tr>";
		}
	
		// 결재선 추가
		aprvCnt++;
		$(".aprvLineTbl").append(str);
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
			// 검증
			setStatCd = $(this).find('select option:selected').val();
			if(setStatCd=="STEP_0002"){
				setStatCnt++;				
			};
			// 결재선
			aprvLine += $(this).attr('empIdx') + "@" + setStatCd + "|";
		});
		// 결재자 1명 이상
		if(setStatCnt==0){
			alert("<spring:message code="APRV.LINE.NONE"/>");
			return;
		};
		
		// 결재선 저장
		$("#aprvLine").val(aprvLine);
		
		// 등록 처리
		aprvProc(f);
	}
	
	// 등록 처리
	function aprvProc(f){
		if(confirm("등록하시겠습니까?")){
			// 에디터 내용 저장
			var getData = CKEDITOR.instances.editor.getData();
			document.getElementById("aprvCont").setAttribute('value',getData);
			// 태그 내 변수 저장
			var fileList = setFileList();
			//
   			$.ajax({
				url:"intrAprvProc1010.do",
				processData : false,
				contentType : false,
				data: fileList,
				type : 'post',
   				success : function(data){
   						//
   						var json = eval(data);
   						if(json[0].res=='YES'){
   	   						//
   							alert("<spring:message code="PROC.SUCCESS"/>");
	   						location.href = "intrAprvInqy1010.do";
   						}else{
   	   						//
   							alert("<spring:message code="PROC.FAIL"/>");
							return;	   							
   						}
   				},
   				error : function(res, status, error){
   					//
   					alert("<spring:message code="PROC.ERROR"/>");
   				}
   			});
		}
	}
</script>

<!-- 부서 사용자 트리 -->
<div class="tree_wrap">
	<div class="tree_area" id="tree_area"> 
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
								<input type="radio" id="radio${status.index}" name="radioIdx" value="${list.empIdx}" deptNm="${list.deptNm}" empNm="${list.empNm}">
							</c:if>
							<label for="radio${status.index}">${spanNm}</label>
					</c:when>
					<c:when test="${list.lv eq prevLv}">
						<c:if test="${list.isleaf eq 'Y'}">
							<input type="radio" id="radio${status.index}" name="radioIdx" value="${list.empIdx}" deptNm="${list.deptNm}" empNm="${list.empNm}">
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
<div id="tree_info" class="tree_info" style="width: 670px;">
	<div class="post_wrap">
		<div class="scroll_wrap" style="height: 425px;">
			<table class="post_table aprvLineTbl">
				<caption>결재선 목록</caption>
				<colgroup>
					<col class="w30per">
					<col class="w30per">
					<col class="w25per">
					<col class="w15per">
				</colgroup>
				<thead>
					<tr>
						<th scope="col">부서</th>
						<th scope="col">이름</th>
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