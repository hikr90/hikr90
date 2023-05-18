<!--명칭 : intr_popup_inqy_1020
	작성자 : 김태현
	작성일자 : 2022.12.01
	내용 : 팝업 관리(정보 찾기)-->
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
		var findYn = "";
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
		EmaChkYn = false; // 인증 여부
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
   	   				//
   					alert("<spring:message code="FIND.INFO.FAIL"/>");
   				} else {
   					//
   					alert("<spring:message code="FIND.INFO.SUCCESS"/>");
   				}
			},
			error : function(xhr, status, error){
		    	//
				alert("<spring:message code="PROC.ERROR"/>");
		    }
		});
	}
	
	//
	function chkNum(f){
		//
		EmaChkYn = true;
	}
	
	// 찾기
	function popConfirm(){
		//
		alert(EmaChkYn);
	}	
</script>
<form id="popForm">
<div class="_popList">
	<article id="_subArticle">
		<div class="_wrap">
			<div id="_content">
				<div id="sub_content" class="_inner">					
					<div class="_contentArea _formArea" style="margin-bottom: 0px;">
                        <div class="_find_info_Wrap">
                            <div class="postWrap" style="height: 350px;">
                                <div id="postCon">
                                
                                </div>
                                
                                <div class="btn_center">
                                	<input type="button" class="_btn _grey" value="찾기" onclick="popConfirm();">
                                    <input type="button" class="_btn _line" value="취소" onclick="popClose('popupArea');">
                                </div>
                            </div><!-- End postWrap -->
                          </div> 
					</div><!-- End _contentArea _formArea -->
				</div><!-- End _inner -->
			</div><!-- End _content -->
		</div><!-- End _wrap -->
	</article>
</div>
</form>
</html>