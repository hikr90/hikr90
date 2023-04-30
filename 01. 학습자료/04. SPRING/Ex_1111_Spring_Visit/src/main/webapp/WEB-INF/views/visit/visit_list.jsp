<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- SPRING FRAMEWORK에서의 CSS접근
		- CSS등의 참조 파일은 WEBAPP/RESOURCES의 위치에 저장되고 관리된다.
		- 해당 경로에 접근하기위해서는 WEBAPP의 경로에 접근해야하는데 EL표기법을 통해서 접근이 가능하다.
		
		PAGECONTEXT.REQUEST.CONTEXTPATH
			- 웹 애플리케이션의 상대 경로 (프로젝트 내 WEBAPP 경로)
			- PAGECONTEXT : 웹 컨테이너가 JSP 동작 시 자동으로 생성하는 내장 객체 (Javax.Servlet.PageContext)
			
			# 프로젝트 PATH 접근
				- (EL표기법) pageContext.request.contextPath 
				- (JAVA) request.getContextPath
				- (예시) : /test
			
			# 프로젝트와 화면 경로 접근 (LOCALHOST 포함)
				- (EL표기법) pageContext.request.requestURL
				- (자바) request.getRequestURL
				- (예시) http://localhost:8080/test/WEB-INF/views/test.jsp
				
			# 프로젝트와 파일 경로 접근 (LOCALHOST 미포함)
				- (EL표기법) pageContext.request.requestURI
				- (JAVA) request.getRequestURI
				- (예시) /test/WEB-INF/view/test.jsp
-->
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/visit.css">
<script src="${ pageContext.request.contextPath }/resources/js/httpRequest.js"></script>

<script type="text/javascript">
	// 내용 수정
	function modify(f) {
		//
		var pwd = f.pwd.value;
		var c_pwd = f.c_pwd.value;
		//
		if(pwd != c_pwd){
			alert("비밀번호가 다릅니다.");
			return;
		}
		//
		f.action = "modify_form.do";
		f.submit();
	}
	
	// 내용 삭제
	function del(f) {
		//
		var pwd = f.pwd.value; 
		var c_pwd = f.c_pwd.value;
		//		
		if(pwd != c_pwd){
			alert("비밀번호가 다릅니다.");
			return;
		}
		//
		if(!confirm("정말 삭제하시겠습니까?")){
			return;
		}
		
		// 비밀번호가 일치하는 경우 AJAX를 통해서 삭제 결과를 받아온다.
		var url = "delete.do";
		var param = "idx="+f.idx.value;
		
		// (보내고자하는 맵핑 주소, 보내는 파라미터, 처리 내용을 받아올 메소드, 전송방식)
		sendRequest(url,param,resultFn,"GET");
	}
	
	// DEL의 콜백 메소드
	function resultFn() {
		if(xhr.readyState==4 && xhr.status==200){ // 정상적으로 값을 전달받은 상태
			
			// RESPONSETEXT는 맵핑된 컨트롤러에서 리턴받은 데이터를 뜻한다.
			var data = xhr.responseText;
			
			// 삭제 실패
			if(data=='no'){
				alert("삭제 실패. 관리자에게 문의하세요.");
				return;
			}
			
			// 삭제 성공
			alert("삭제 성공");
			// 삭제에 성공한 경우, 삭제한 페이지를 다시 보여주기위해서 다시 목록을 띄운다.
			location.href="list.do";
		}
	}
</script>

</head>
<body>
	<div id="main_box">
		<h1>::방명록 리스트::</h1>
		
		<div align="center">
			<!-- 입력 폼인 INSERT_FORM.DO로 이동 -->
			<input type="button" value="글쓰기" onclick="location.href='insert_form.do'">
		</div>
		
		<c:forEach var="vo" items="${ list }">
			
			<div class="visit_box">
				<div class="type_content"><pre>${ vo.content }</pre>
				<!-- 사진이 존재하지 않는 경우, 엑박 대신 문자로 보여주기위해서 NO_FILE 문자 추가  -->
				<c:if test="${ vo.filename ne 'no_file' }">
					<img src="resources/upload/${ vo.filename }" width="200px">
				</c:if>
				</div>

				<div class="type_name">작성자:${ vo.name }(${ vo.ip })</div>
				<div class="type_regdate">작성일:${ vo.regdate }</div>
				
				<div>
					<form>
						<!-- 브라우저에서 사용자에게 노출하지 않고 특정한 값을 전송받아야하는 경우, INPUT태그의 HIDDEN속성을 사용한다. -->
						<input type="hidden" name="idx" value="${ vo.idx }">
						<input type="hidden" name="pwd" value="${ vo.pwd }">
						비밀번호 : <input type="password" name="c_pwd">
						<input type="button" value="수정" onclick="modify(this.form);">
						<input type="button" value="삭제" onclick="del(this.form);">
					</form>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>