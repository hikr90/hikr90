<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1010.jsp" %>

<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript">
   		// 정보 찾기 팝업
   		function popCall(){
   			// 정보 찾기 팝업
   			var param = null;
   			ajaxPopup(param,"650","360","intrPopupInqy1021.do");
   		}
   		
   		// 로그인
   		function loginCall(f){
   			// 유효성 검증
			if(!validation()){return;};
			//   			
			var param = $("#form").serialize();
   			$.ajax({
   				type:	"post" , 
   				url:	"intrLoginProc1010.do",
   				data:	param,
   				dataType:	"text" ,
   				success : function(data){
   					//
   					var json = eval(data);
   					if(json[0].res=="NO_ID"){
   	   					//
   						alert("<spring:message code="LOGIN.ID.FAIL"/>");
   					} else if(json[0].res=="NO_PWD") {
   	   					//
   						alert("<spring:message code="LOGIN.PWD.FAIL"/>");
   					} else {
   						//
   						location.href = "intrMainInqy1020.do";
   					}
   				},
   				error : function(res, status, error){
   					//
   					alert("<spring:message code="PROC.ERROR"/>");
   				}
   			});

   		}
   		
   		// 관리자 계정 등록
   		function adminProc(f){
			//
   			$.ajax({
   				type:	"post" ,
   				url:	"intrLoginProc1020.do",
   				data:	null,
   				dataType:	"text" ,
   				success : function(data){
   					//
   					var json = eval(data);
   					if(json[0].res=="YES"){
   	   					alert("<spring:message code="ADMIN.SUCCESS"/>");
   					} else {
   	   					alert("<spring:message code="ADMIN.FAIL"/>");
   					}
   				},
   				error : function(res, status, error){
   					//
   					alert("<spring:message code="PROC.ERROR"/>");
   				}
   			});

   		}
	</script>
</head>
<body id="sub">
	<!-- 정보 찾기 -->
 	<div id="popupArea" class="popupArea hidden">
		<c:import url="/WEB-INF/views/intr/comm/popup/intr_popup_inqy_1020.jsp"></c:import>	
	</div>

	<!-- 로그인 화면 -->
	<form id="form">
		<div class="_body">
			<div class="_tbl">
				<div class="_login_wrap _sty2">
					<div class="login-wrap">
						<div class="login-area">
							<h3>LOGIN</h3>
							<input type="button" class="_admin_insert" value="관리자 계정등록" onclick="adminProc();">
							<input type="text" placeholder="아이디" title="아이디" id="empId" name="empId" onkeydown="pushLoginKey(this.form);">
							<input type="password" id="empPwd" name="empPwd" placeholder="패스워드" title="비밀번호" onkeydown="pushLoginKey(this.form);">
							<input type="button" class="login-btn" value="로그인" onclick="loginCall(this.form);">
	                        <input type="button" class="btn-find-info" value="아이디/비밀번호 찾기" onclick="popCall();">
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
	
	<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1020.jsp" %>

</body>
</html>