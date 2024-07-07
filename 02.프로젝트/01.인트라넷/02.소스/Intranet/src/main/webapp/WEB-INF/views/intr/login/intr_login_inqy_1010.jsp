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
   			// 정보 찾기 팝업 (높이, 너비, 맵핑, 변수)
   			var obj = new Object();
   			ajaxPopup(obj,"650","300","intrPopupInqy1021.do","");
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
   		
   		// 로그인 정보 입력
   		function setInfo(empId, empPwd){
   			//
   			$("input[name=empId]").val(empId);
   			$("input[name=empPwd]").val(empPwd);
   		}
	</script>
</head>
<body id="sub">
	<!-- 정보 찾기 -->
 	<div id="popupArea" class="popup_area hidden">
		<c:import url="/WEB-INF/views/intr/comm/popup/intr_popup_inqy_1020.jsp"></c:import>	
	</div>

	<!-- 로그인 화면 -->
	<form id="form" method="post" enctype="multipart/form-data">
		<div class="body">
			<div class="login_wrap">
				<div class="login_area">
					<h3>LOGIN</h3>
					<input type="text" placeholder="아이디" title="아이디" id="empId" name="empId" onkeydown="pushLoginKey(this.form);" value="ADMIN">
					<input type="password" id="empPwd" name="empPwd" placeholder="패스워드" title="비밀번호" onkeydown="pushLoginKey(this.form);" value="ADMIN">
					<input type="button"class="login_btn" value="로그인" onclick="loginCall(this.form);">
                       <input type="button"class="btn_find" value="아이디/비밀번호 찾기" onclick="popCall();">
				</div>
					
				<div class="auth_area">
					<div class="post_table_wrap">
						<table class="post_table">
							<caption>로그인 권한 목록 조회</caption>
							<colgroup>
								<col class="auto">
								<col class="w60per">
							</colgroup>
							<thead>
								<tr style="border-bottom: none;">
									<th scope="col">권한</th>
									<th scope="col">소유자</th>
								</tr>
							</thead>
							<tbody>
                                <c:forEach var="list1" items="${defaultList}" varStatus="status1">
									<c:if test="${list1.authCd ne defaultList[status1.index + 1].authCd}">
										<tr>
											<td class="align_center">${list1.authNm}</td>
											<td class="title align_left">
												<c:forEach var="list2" items="${defaultList}" varStatus="status2">
													<c:if test="${list1.authCd eq list2.authCd}">
														<a href="javascript:setInfo('${list2.empId}','${list2.empPwd}');" style="color: #214b97;">${list2.empNm}</a>
														&nbsp;
													</c:if>
												</c:forEach>
											</td>
										</tr>
									</c:if>
                               </c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</form>
	
	<%@ include file="/WEB-INF/views/intr/comm/include/intr_include_1020.jsp" %>

</body>
</html>