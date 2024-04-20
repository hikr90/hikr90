<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- EL은  var처럼 자료형 상관없이 사용이 가능하다. -->
<%
	Map<String, String> map = new HashMap();
	map.put("test", "oracle.jdbc");
	map.put("url","java:comp");	
	map.put("id", "test");
	map.put("pwd", "1111");
	
	/* MAP객체를 통째로 저장 (String, Object) */
	request.setAttribute("my_map", map);
%>
   
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	</head>
	<body>
		<!-- EL을 통해서 MAP을 조회하는 방법 -->
		풀코딩(안씀) : ${ requestScope.my_map.get("test") }<br>
		약간 줄인 코딩(안씀) : ${ my_map.get("test") }<br>
		<hr>
		좀더 줄인 코딩 (가끔 씀) (\${ my_map["test"] }) : ${ my_map["test"] }<br>
		<hr>
		최종 형태(\${ my_map.test }) : ${ my_map.test }
	</body>
</html>