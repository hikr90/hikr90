<%@page import="vo.DeptVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- Model 1
		- 한 곳에서 Jsp를 사용하여 서블릿없이 서버, 화면의 작업을 전부 처리하는 방식
		- 소스가 복잡해지므로 잘 사용하지는 않으나 소규모로 빠르게 작업을 처리해야하는 경우 사용하기도 한다.
 -->
<%
	// InitialContext
	// - JNDI서비스를 제공하는 객체 생성
	InitialContext ic = new InitialContext();
	
	// 컨텍스트 객체 생성
	// - java:comp/env는 톰캣에서 리소스를 관리하는 가상의 주소이다.
	// - lookup함수는 JNDI의 메소드로서 name과 key값의 정보를 통해서 데이터소스의 객체를 얻는다.
	// LOOKUP은 JNDI의 메소드로서 NAME과 KEY값을 통해서 DATASOURCE의 객체를 얻는다.
	Context ctx = (Context)ic.lookup("java:comp/env");
	
	// DB객체 생성
	// - jdbc/oracle_test는 context.xml에 등록한 계정 정보를 뜻한다.
	DataSource ds = (DataSource)ctx.lookup("jdbc/oracle_test");
	
	// 커넥션 객체 생성
	// - getConnection은 DB연동을 가져오는 메소드이다.
	Connection conn = ds.getConnection();
	
	// 커넥션 유무 파악
	System.out.println("--DB연결 성공--");
	
	// 쿼리문 생성
	String sql = "select * from dept";
	
	// PreparedStatement
	// 	- statement를 상속하는 인터페이스로 Sql 쿼리문을 동작시키는 객체
	//	- 쿼리문을 반복해서 사용할 수 있도록 돕는다.
	PreparedStatement pstmt = conn.prepareStatement(sql);
	
	// executeQuery
	// 	- Sql 처리 결과를 저장하는 객체
	//	- next 메소드는 쿼리 결과의 행 데이터가 존재하는지를 뜻한다.
	//	- 값이 있는 경우 true, 없는 경우 false를 반환한다.
	ResultSet rs = pstmt.executeQuery();
	List<DeptVO> dept_list = new ArrayList();
	// 
	while(rs.next()){
		DeptVO vo = new DeptVO();
		// getInt : 쿼리의 결과를 숫자 타입으로 받는다.
		// getString : 쿼리의 결과를 문자열 타입으로 받는다.
		vo.setDeptno(rs.getInt("deptno"));
		vo.setdName(rs.getString("dname"));
		vo.setLoc(rs.getString("loc"));
		// add를 사용하여 ArrayList에 저장한다.
		dept_list.add(vo);
	}
	
	// close는 DB연동을 종료하는 메소드이다.
	// 스트림과 마찬가지로 닫을 때는 역순으로 닫아준다.
	rs.close();
	pstmt.close();
	conn.close();
%>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
		table{border-collapse: collapse;}
	</style>
	<script type="text/javascript">
		function send(no) {
			// 받은 값을 인풋태그(히든)의 값으로 지정해준 뒤 서버 전송을 할 수 있다.
			var f = document.getElementById("m_form");
			var hid = document.getElementById("hid");
			hid.value = no;
			f.submit();
		}
	</script>
	</head>
	<body>
		<!-- 버튼 태그 내 폼 태그를 보내지 못하므로 대신 아이디 값을 넘긴다. -->
		<form id="m_form" action="sawon_list.jsp">
		<table border="1">
			<caption>:: 부서 테이블 ::</caption>
				<tr>
					<th>번호</th>
					<th>부서명</th>
					<th>위치</th>
				</tr>
					<%
					for(int i=0;i<dept_list.size();i++){
						DeptVO vo = dept_list.get(i);
					%>
					<tr>
						<td><%= vo.getDeptno() %></td>
						<td>
							<!-- [참고] a태그에서 값 전송
									- 폼 태그를 사용할 수 없으므로 a태그의 send함수를 통해서 VO의 값을 넘긴다.
									- javascript:함수를 사용하여 받은 파라미터 값을 히든 태그의 값으로 보내주는 함수를 통해 서버로 값을 전송한다. 
									- 자주 사용하는 방식은 아니다.
 							-->
							<a href="javascript:send('<%=vo.getDeptno()%>')">	
								<%= vo.getdName() %>
							</a>
						</td>
						<td><%= vo.getLoc() %></td>
					</tr>
				<% }%>
		</table>
		
		<!-- [참고] 인풋태그의 히든 타입
				- 타입이 히든인 인풋타입은 화면 상에서 보이지 않는다.
				- 히든타입은 개발자가 사용자가 확인할 수 없는 방식으로 값을 넘길 때 사용한다.
		-->
		<input type="hidden" id="hid" name="deptno">
		</form>
	</body>
</html>