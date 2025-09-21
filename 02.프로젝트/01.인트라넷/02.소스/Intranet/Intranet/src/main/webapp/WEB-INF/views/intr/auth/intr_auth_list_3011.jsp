<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<script type="text/javascript">
	// 사용자 권한 목록 전체 체크
	$('.empChk').click(function() {
		if($(".empChk").is(":checked")){
			$("input[id=authEmpIdx]").prop("checked", true);
	    } else {
	    	$("input[id=authEmpIdx]").prop("checked", false);	
	    }
	});
	
	// 목록 이동
	function moveBtn(f) {
		// 체크한 건이 없는 경우
		if($("input[id=empIdx]:checked").length==0){
			alert("<spring:message code="CHECK.NONE"/>");
			return;
		}

		// 체크한 값 이동
		$("input[class=empIdx]:checked").each(function() {
			// 중복 여부 값
			var dupeYn = 'N';
			// 사용자 관련 변수
			var empIdx = $(this).val();
			var empNm = $(this).attr("empNm");
			var orgNm = $(this).attr("orgNm");
			
			// 사용자 권한 목록 값
			$("input[id=authEmpIdx]").each(function() {
				// 중복되는 경우 중복 여부 값 변경
				var authEmpIdx = $(this).val();
				//
				if(authEmpIdx==empIdx){
					//
					dupeYn = "Y";
					return; 
				}
			});
			
			// 중복되지 않는 경우
			if(dupeYn=='N'){
				//
				var str = "";
				//
				str += "<tr>"
				str += "	<td class='first_td'>";
				str += "		<span class='check_box'>";
				str += "		<input type='checkbox' class='checkbox' id='authEmpIdx' value='" + empIdx + "'/>"
				str += "		<label for='chk_local'><span></span></label></span>";
				str += "		<input type='hidden' name='authEmpIdx' value='" + empIdx + "'/>"
				str += "	</td>";
				str += "	<td>" + orgNm + "</td>";
				str += "	<td>" + empNm + "</td>";
				str += "</tr>";
				
				$(".authEmpTbl").append(str);
			}
			
			// 체크 해제
			$("input[id='empIdx']").prop("checked", false);
			$(".empChk").prop("checked", false);
			$(".totalIdx").prop("checked", false);
		});
	}
	
	// 권한 목록 화면 상 제거
	function delCall(){
		// 유효성 검증
		if($("input[id=authEmpIdx]:checked").length==0){
			alert("<spring:message code="CHECK.NONE"/>");
			return;
		}
		
		// 화면 상 삭제 처리
		$("input[id=authEmpIdx]:checked").each(function() {
			$(this).parents("tr").remove();
		});
		
		//
		$(".empChk").prop("checked", false);
	}
	
	// 새로고침 (사용자 권한 목록 재 조회)
	function setListCall() {
		$(".list_bg").trigger("click");
	}
	
	// 저장 처리
	function regProc(){
		//
		$("#authCd").val($("#authTree .list_bg").attr('id'));
		$("input[name=authEmpIdx]").each(function(idx) {
			$(this).attr("name","empIdx"+idx);
		});
		//
		var param = $("#form").serialize();
		if(confirm("저장하시겠습니까?")){
			//
			$.ajax({
	    		type : 'post',
	        	url : 'intrAuthProc3010.do',
	            data : param,
	            dataType : 'html',
	            success : function(data){
	            	//
					alert("<spring:message code="PROC.SUCCESS"/>");
	            	setListCall();
	            },
	            error : function(data){
	            	//
					alert("<spring:message code="PROC.ERROR"/>");
	            }
	      	});
		}				
	}
</script>

<div class="post_wrap" style="height: 330px; padding: 0px;">
	<input type="hidden" id="authCd" name="authCd" value="">
	
	<div class="scroll_wrap" style="max-height: 380px; height: auto;">
		<table class="post_table authEmpTbl">
			<caption>사용자 목록 테이블</caption>
			<colgroup>
				<col class="w7per">
				<col class="w10per">
				<col class="w20per">
			</colgroup>
			<thead>
				<tr>
					<th scope="col">
						<span class="check_box"> 
						<input type="checkbox" class="check_box empChk"> 
						<label for="chk-yes"><span></span></label></span>
					</th>
					<th scope="col">부서</th>
					<th scope="col">사용자</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="list" items="${authEmpList}" varStatus="status">
					<tr>
						<td class="first_td">
							<span class="check_box"> 
							<input type="checkbox" class="check_box" id="authEmpIdx" value="${list.empIdx}"> 
							<label for="chk-yes"><span></span></label></span>
							<input type="hidden" name="authEmpIdx" value="${list.empIdx}">
						</td>
						<td>${list.orgNm}</td>
						<td>${list.empNm}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div> <!-- End post_wrap -->

<div class="btn_center pt30">
	<button type="button" class="btn_gray_thin float_left" onclick="delCall();">삭제</button>
	<button type="button" class="btn_navy_thin float_right" style="margin-left: 5px;" onclick="regProc(this.form);">저장</button> 
	
	<button type="button" class="btn_blue_thin float_right" onclick="setListCall();">새로고침</a>
</div>
