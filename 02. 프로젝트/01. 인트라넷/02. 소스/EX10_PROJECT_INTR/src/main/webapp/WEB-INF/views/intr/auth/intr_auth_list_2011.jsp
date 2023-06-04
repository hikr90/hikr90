<!--명칭 : intr_auth_list_2011
	작성자 : 김태현
	작성일자 : 2023.01.27
	내용 : 메뉴 권한 목록-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<script type="text/javascript">
	// 권한 메뉴 목록 전체 체크
	$('.authChk').click(function() {
		if($(".authChk").is(":checked")){
			$("input[id=authMenuCd]").prop("checked", true);
	    } else {
	    	$("input[id=authMenuCd]").prop("checked", false);	
	    }
	});
	
	// 목록 이동
	function moveBtn(f) {
		// 체크한 건이 없는 경우
		if($("input[id=menuCd]:checked").length==0){
			alert("<spring:message code="CHECK.NONE"/>");
			return;
		}
		
		// 체크한 값 이동
		$("input[id=menuCd]:checked").each(function() {
			// 중복 여부 값
			var dupeYn = 'N';
			// 메뉴 관련 변수
			var menuCd = $(this).val();
			var menuNm = $(this).attr("menuNm");
			var menutypeCd = $(this).attr("menutypeCd");
			var menuLv = $(this).attr("menuLv");
			
			// 메뉴 권한 목록 값
			$("input[id=authMenuCd]").each(function() {
				// 중복되는 경우 중복 여부 값 변경
				var authMenuCd = $(this).val();
				//
				if(authMenuCd==menuCd){
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
				str += "	<td class='first-td'>";
				str += "		<span class='_chkBox'>";
				str += "		<input type='checkbox' class='checkbox' id='authMenuCd' value='" + menuCd + "'/>"
				str += "		<label for='chk_local'><span></span></label></span>";
				str += "		<input type='hidden' name='authMenuCd' value='" + menuCd + "'/>"
				str += "	</td>";
				//
				if(menuLv!=1){
					str += "	<td style='text-align: left;'>&nbsp;&nbsp;ㄴ " + menuNm + "</td>";
				} else {
					str += "	<td style='text-align: left;'>" + menuNm + "</td>";
				}
				//
				str += "	<td>" + menutypeCd + "</td>";
				str += "</tr>";
				
				$(".authMenuTbl").append(str);
			}
			
			// 체크 해제
			$("input[id='menuCd']").prop("checked", false);
			$(".menuChk").prop("checked", false);
		});
	}
	
	// 권한 목록 화면 상 제거
	function delCall(){
		// 유효성 검증
		if($("input[id=authMenuCd]:checked").length==0){
			alert("<spring:message code="CHECK.NONE"/>");
			return;
		}
		
		// 화면 상 삭제 처리
		$("input[id=authMenuCd]:checked").each(function() {
			$(this).parents("tr").remove();
		});
		
		//
		$(".authChk").prop("checked", false);
	}
	
	// 새로고침 (메뉴 권한 목록 재 조회)
	function setListCall() {
		$(".list_bg").trigger("click");
	}
	
	// 저장 처리
	function regProc(){
		// 권한 값 지정
		$("#authCd").val($(".list_bg").attr('id'));
		
		// 권한 메뉴 추가
		$("input[name=authMenuCd]").each(function(idx) {
			$(this).attr("name","menuCd"+idx);
		});
		//
		var param = $("#form").serialize();
		//
		if(confirm("저장하시겠습니까?")){
			//
			$.ajax({
	    		type : 'post',
	        	url : 'intrAuthProc2010.do',
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

<div class="postWrap" style="padding: 0px;">
	<input type="hidden" id="authCd" name="authCd" value="">
	
	<div class="scrollTableWrap" style="max-height: 380px; height: auto;">
		<table class="postTable authMenuTbl">
			<caption>권한 목록 테이블</caption>
			<colgroup>
				<col class="w7per">
				<col class="w30per">
			</colgroup>
			<thead>
				<tr>
					<th scope="col">
						<span class="_chkBox"> 
						<input type="checkbox" class="checkbox authChk"> 
						<label for="chk-local"><span></span></label></span>
					</th>
					<th scope="col">메뉴 부여</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="list" items="${authMenuList}" varStatus="status">
					<tr>
						<td class="first-td">
							<span class="_chkBox"> 
							<input type="checkbox" class="checkbox" id="authMenuCd" value="${list.menuCd}"> 
							<label for="chk-local"><span></span></label></span>
							<input type="hidden" name="authMenuCd" value="${list.menuCd}">
						</td>
						<td style="text-align: left;">
							<c:if test="${list.lv ne '1'}">&nbsp;&nbsp;ㄴ</c:if>
							${list.menuNm}
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div> <!-- End postWrap -->

<div class="btnWrap alignL" style="float: left; margin-top: 36px;">
	<input type="button" class="_btn _grey" value="삭제" onclick="delCall();">
</div>
<div class="btnWrap alignR" style="float: right; margin-top: 36px;">
	<input type="button" class="_btn _grey" onclick="regProc(this.form);" value="저장"> 
	<a onclick="setListCall();" class="_btn _line">새로고침</a>
</div>