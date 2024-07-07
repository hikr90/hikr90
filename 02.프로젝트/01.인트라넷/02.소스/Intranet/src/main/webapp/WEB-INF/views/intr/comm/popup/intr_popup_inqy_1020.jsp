<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<script type="text/javascript">
	//
	$(document).ready(function(){
		//
		var findIdYn = "";		// 아이디 찾기 여부
	});
	
	// 아이디, 비밀번호 찾기 여부 검증
	function findIdYn(){
		//
		findYn = "";
		if($("#findYn").length < 1){
			findYn = 'N';
		}else {
			findYn = 'Y';
		}
		//		
		return findYn;
	}
	
	
	// 인증 번호 전송
	function sendNum(f){
		//
		$("#form").attr("findIdYn",findIdYn());	// 아이디, 비밀번호 찾기 조회
		//
		if(findIdYn()=="Y" && $("#findNm").val()==""){
			//
			alert("이름을 입력해주세요.");
			return;
		} else if (findIdYn()=="N" && $("#findId").val()==""){
			//
			alert("아이디를 입력해주세요.");
			return;
		}
		//
		if($("#findEmail").val()==""){
			alert("이메일을 입력해주세요.");
			return;
		}
		
		// 이메일 기본 형식 (RFC5322)
		let regex = new RegExp("([!#-'*+/-9=?A-Z^-~-]+(\.[!#-'*+/-9=?A-Z^-~-]+)*|\"\(\[\]!#-[^-~ \t]|(\\[\t -~]))+\")@([!#-'*+/-9=?A-Z^-~-]+(\.[!#-'*+/-9=?A-Z^-~-]+)*|\[[\t -Z^-~]*])");
		//
		if(!regex.test($("#findEmail").val())){
			alert("이메일 형식을 입력해주세요.");
			return;
		}
		//
		var param = $("#popForm").serialize(); // 파라미터 저장
		mailChkYn = false; // 인증 여부
		//
		$.ajax({
		    	type : 'post',
		    	url : "intrMailProc1010.do",
				data : param,
				dataType : 'text',
			success : function(data){
				//
				var json = eval(data);
   				if(json[0].res=="NO"){
   	   				// 발송 실패
   					alert("<spring:message code="FIND.INFO.NONE"/>");
   				} else {
   					// 발송 성공
   					alert("<spring:message code="JOIN.CODE.SUCCESS"/>");
   					// 인증 코드 입력
   					$("#joinCode").val(json[0].joinCode);
   					$("#empId").val(json[0].empId);
   					$("#empPwd").val(json[0].empPwd);
   				}
			},
			error : function(xhr, status, error){
		    	//
				alert("<spring:message code="PROC.ERROR"/>");
		    }
		});
	}
	
	// 인증하기
	function chkNum(f){
		//
		var joinCode = $("#joinCode").val();
		var inputCode = $("#inputCode").val();
		// 인증코드 입력값이 없는 경우
		if(inputCode==""){
			//
			alert("<spring:message code="INPUT.CODE.NONE"/>");
			return;
		}
		// 인증을 하지 않았을 경우
		if(joinCode==""){
			//
			alert("<spring:message code="JOIN.CODE.NONE"/>");
			return;	
		} 
		// 인증코드와 입력코드 비교
		if(inputCode!=joinCode){
			// 인증 실패
			mailChkYn = false;
			alert("<spring:message code="CODE.NO.COINCIDE"/>");
			return;
			
		} else {
			// 인증 성공
			mailChkYn = true;
			alert("<spring:message code="CODE.SUCCESS"/>");
			return;	
		}
	}
	
	// 찾기
	function popConfirm(){
		//
		if(!mailChkYn){
			alert("<spring:message code="FIND.CHECK.NONE"/>");
			return;	
		}
		//
		findYn == "Y" ? findInfo = $("#empId").val() : $("#empPwd").val();
		alert("찾고 계신 정보는 [" + findInfo + "] 입니다.");
	}
</script>
<form id="popForm">
<div class="pop_area">
	<article class="sub_article">
		<div class="content">
			<div id="sub_content">					
				<div class="form_area">
                       <div class="find_info_wrap">
                           <div class="post_wrap">
                           	<input type="hidden" id="joinCode" value="">
                           	<input type="hidden" id="empId" value="">
                           	<input type="hidden" id="empPwd" value="">

                               <div id="postCon" class="post_con">
                               
                               </div>
                               
                               <div class="btn_center">
                               	<input type="button"class="btn_blue_thin" value="찾기" onclick="popConfirm();">
                                   <input type="button"class="btn_gray_thin" value="취소" onclick="popClose('popupArea');">
                               </div>
                           </div><!-- End post_wrap -->
                         </div> 
				</div><!-- End content_area form_area -->
			</div><!-- End sub_content -->
		</div><!-- End content -->
	</article>
</div>
</form>
</html>