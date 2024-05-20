<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Spring Framework의 CSS
		- 참조 파일은 webapp/resources에 저장된다.
		- 해당 경로에 접근하기위해서는 EL표기법을 사용한다.
		
			# 경로 접근
				(1) 프로젝트 경로 접근 (pageContext.Request.ContextPath)
					- 웹 애플리케이션의 상대 경로 (프로젝트 내 webapp)
					- 화면 : pageContext는 웹 컨테이너가 Jsp 동작 시 자동으로 생성하는 내장 객체
					- 서버 : request.getContextPath
					- 예시 : /test
				
				(2) 프로젝트와 화면 접근 (localhost 포함)
					- 화면 : pageContext.request.requestURL
					- 서버 : request.getRequestURL
					- 예시 : http://localhost:8080/test/WEB-INF/views/test.jsp
			
				(3) 프로젝트와 파일 경로 접근 (localhost 미포함)
					- 화면 : pageContext.request.requestURI
					- 서버 : request.getRequestURI
					- 예시 : /test/WEB-INF/view/test.jsp
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
		
		// 비밀번호가 일치하는 경우 Ajax를 통해서 삭제 결과를 받아온다.
		var url = "delete.do";
		var param = "idx="+f.idx.value;
		
		// (보내고자하는 맵핑 주소, 보내는 파라미터, 처리 내용을 받아올 메소드, 전송방식)
		sendRequest(url,param,resultFn,"GET");
	}
	
	// 콜백 메소드
	function resultFn() {
		if(xhr.readyState==4 && xhr.status==200){ // 정상적으로 값을 전달받은 상태
			
			/* 속성
				- (1) readyState
						- 서버 통신의 진행 상황을 알려주는 속성
						- 0(오류) : 초기화되지 않은 상태
						- 1(오류) : send메소드가 동작하지 않은, 로드되지 않은 상태
						- 2(오류) : send메소드를 통해서 요청은 했으나 응답을 받지 못한 상태
						- 3(정상) : 상호작용 상태로서 데이터의 일부분만 받은 상태
						- 4(정상) : 모든 데이터를 받은 완료 상태
						
				- (2) status
						- 서버의 응답 상태를 알려주는 속성
						- 200 (정상) : 이상없음, 정상적으로 처리되어 데이터가 넘어온 상태
						- 404 (오류) : 경로없음, 코드에 오류가 존재하는 상황
						- 500 (오류) : 데이터가 없음, 서버 관련 코드에 오류가 존재하는 상황
					
				- (3) responseText
					- 서버 응답의 결과(데이터)를 받는 속성
					- JSON 등의 형태로 받을 수 있다.
			*/
			
			// responseText는 맵핑된 컨트롤러에서 리턴받은 데이터를 받는 함수이다.
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
			<!-- 입력 폼인 insert_form.do로 이동 -->
			<input type="button" value="글쓰기" onclick="location.href='insert_form.do'">
		</div>
		
		<c:forEach var="vo" items="${ list }">
			
			<div class="visit_box">
				<div class="type_content"><pre>${ vo.content }</pre>
					<c:if test="${ vo.filename ne 'no_file' }">
						<img src="resources/upload/${ vo.filename }" width="200px">
					</c:if>
				</div>

				<div class="type_name">작성자:${ vo.name }(${ vo.ip })</div>
				<div class="type_regdate">작성일:${ vo.regdate }</div>
				
				<div>
					<form>
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