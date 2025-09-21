<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	/*	Map의 EL표기법 
			- (1) 전체 표현 : ${영역.map.get("key")}
			- (2) 영역 생략 : ${map.get("key")}
			- (3) 키값 검색 : ${map["key"]}
			- (4) 가장 보편적인 형태 : ${map.key값}
	*/
	Map<String, String> map = new HashMap();
	map.put("test", "oracle.jdbc");
	map.put("url","java:comp");	
	map.put("id", "test");
	map.put("pwd", "1111");
	//	
	request.setAttribute("my_map", map);
%>
   
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	</head>
	<body>
		전체 표현 : ${ requestScope.my_map.get("test") }<br>
		영역 생략 : ${ my_map.get("test") }<br>
		<hr>
		키값을 통한 표현 : (\${ my_map["test"] }) : ${ my_map["test"] }<br>
		<hr>
		가장 보편적으로 사용하는 형태 : (\${ my_map.test }) : ${ my_map.test }
	</body>
</html>