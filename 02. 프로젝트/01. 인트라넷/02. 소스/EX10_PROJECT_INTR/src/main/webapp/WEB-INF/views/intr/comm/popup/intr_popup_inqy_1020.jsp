<!--명칭 : intr_popup_inqy_1020
	작성자 : 김태현
	작성일자 : 2022.12.01
	내용 : 팝업 관리(정보 찾기)-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<script type="text/javascript">
	//
	$(document).ready(function(){
		//
		var EmaChkYn = false; 	// 인증 여부 체크
		var findIdYn = "";		// 아이디 찾기 여부
	});
	
	// 아이디, 비밀번호 찾기 여부 검증
	function findIdYn(){
		//
		var findYn = "";
		if($("#findId").length < 1){
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
		var param = $("#form").serialize();
		$("#form").attr("findIdYn",findIdYn());	
		//
		EmaChkYn = false;
		//
		$.ajax({
		    	type : 'post',
		    	url : "intrMailProc1010.do",
				data : param,
				dataType : 'text',
			success : function(data){
		    	//
				alert("정보 찾기 인증 번호가 전송되었습니다.\n등록하신 메일 계정에서 인증번호를 확인해주세요.");

			},
			error : function(xhr, status, error){
		    	//
				alert("인증 번호 전송에 실패하였습니다.\n관리자에게 문의해주세요.");				
		    }
		});
	}
	
	// 인증 번호 체크
	function chkNum(f){
		//
		
	}
</script>
<div class="_popList">
	<article id="_subArticle">
		<div class="_wrap">
			<div id="_content">
				<div id="sub_content" class="_inner">					
					<div class="_contentArea _formArea">
                        <div class="_find_info_Wrap">
                            <div class="postWrap" style="height: 350px;">
                                <div id="postCon">
                                
                                </div>
                                
                                <div class="btn_center">
                                	<input type="button" class="_btn _grey" value="찾기" onclick="">
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
</html>