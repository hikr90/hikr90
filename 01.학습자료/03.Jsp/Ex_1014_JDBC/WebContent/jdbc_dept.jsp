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
    
<!-- MODEL 1 : 한곳에서 JSP, HTML의 작업을 전부 처리하는 경우로
		MODEL 1은 기본적으로는 잘 사용하지 않지만 특히 대규모 프로젝트에서는 절대 사용하지 않는다. 
		
		왜 JSP에서 동적 데이터를 처리할 수 있는가?
		DB로 접속하기위한 작업은 자바 코드로 처리하는데 JSP에서 자바 코드를 사용할 수 있는 스크립트 릿을 사용한다.
		마찬가지로 HTML은 자바 코드가 불가능하므로 사용할 수 없다.
 -->

<%
	
	/*	JNDI 검색
			톰캣이 참조할 자원 (계정과 비밀번호)을 찾아야만 접속이 가능하다. */
			
	// JNDI서비스를 제공하는 객체 생성
	InitialContext ic = new InitialContext();
	
	// JNDI 검색을 위한 상수값 지정 (JAVAX.NAMING으로 IMPORT)
	// CONTEXT.XML의 CONTEXT태그에 접근
	// JAVA:COMP/ENV는 톰캣에서 참조파일 (리소스)을 관리하는 가상의 주소로서, JDBC/ORACLE_TEST는 CONTEXT.XML에 등록한 계정 정보이다.
	// LOOKUP은 JNDI의 메소드로서 NAME과 KEY값을 통해서 DATASOURCE의 객체를 얻는다.
	Context ctx = (Context)ic.lookup("java:comp/env");
	

	// 검색한 CONEXT에서 NAME을 검색하여 " "의 명칭으로 리소스하여 어떤 DB로 접속할지를 결정 (JAVAX.SQL을 IMPORT)
	// ctx를 검색한 객체를 통해서 name을 검색하여 ""안의 명칭으로 리소스 하겠다.
	DataSource ds = (DataSource)ctx.lookup("jdbc/oracle_test");
	
	// DB에 연결 (JAVAX.SQL을 IMPORT)
	Connection conn = ds.getConnection();
	
	// 연결 유무를 파악하기위한 SYSO
	System.out.println("--DB연결 성공--");
	
	// DEPT의 정보를 얻기위한 SQL 쿼리문 동작 
	String sql = "select * from dept";
	
	
	/* PREPAREDSTATEMENT
			STATEMENT를 상속하는 인터페이스로 SQL쿼리문을 동작시키는 객체
			동일한 DB문장을 효율적으로 반복 사용하게하는 역할
			접속 계정의 정보를 알기위해서 CONN이 있어야한다. 
			(TEST 계정에 접근하여 SQL을 검색하는 것이 가능해진 상태) */
	PreparedStatement pstmt = conn.prepareStatement(sql);
	
	// EXECUTEQUERY는 ​SQL문의 결과를 저장하는 객체이다.
	// PSTMT를 통해서 수행이 완료된 결과를 VO객체에 저장
	// (동작한 순간 DEPTNO 테이블에 가상의 커서를 잡는 상태가 된다.) 
	ResultSet rs = pstmt.executeQuery();
	List<DeptVO> dept_list = new ArrayList();
	
	// WHILE문과 NEXT로 SQL문의 결과를 테이블의 행단위로 로드  
	// 	RS.NEXT는 다음 요소가 존재하면 TRUE (더이상 다음 행이 없다면 FALSE)
	// 	RS.NEXT는 실행시마다 다음라인으로 이동한다. 

	while(rs.next()){
		DeptVO vo = new DeptVO();
		// 접근한 행에서 DEPTNO라는 컬럼에 들어간 값(RS.GETINT)를 VO에 저장한다.
		vo.setDeptno(rs.getInt("deptno"));
		vo.setdName(rs.getString("dname"));
		vo.setLoc(rs.getString("loc"));
		dept_list.add(vo);
	}
	
	
	/* 기본적으로 웹 브라우저에서 새로고침시마다 접속 인원수가 증가하지만 따로 나가는 작업이 없기에
			MAXACTIVE가 최대치를 넘어서는 순간 사이트에서 500 에러가 나게된다.  
			DB에 연결한 후, 원하는 작업을 마무리했다면 CLOSE를 통해서 DB접속을 해제해줘야 다음 유저가 접속할 수 있다.
			STREAM과 마찬가지로 닫을 때는 역순으로 닫아줘야한다. 
		
			(만약 CLOSE가 되지 않으면 PROJECT메뉴의 CLEAN으로 서버 초기화하거나 하단의 SERVER탭에서 내용을 DELETE하고 다시 동작시키면 된다. */
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
			// alert(no);
			// submit할 form과 no의 값을 hid에 넣어줄 hid 입력상자를 지정 
			var f = document.getElementById("m_form");
			var hid = document.getElementById("hid");
			hid.value = no;
			f.submit();
		}
	</script>
	</head>
	<body>
		<!-- 파라미터로 this.form을 못넘기니 id가 있어야한다. 해당 파라미터를 가지고 sawon_list.jsp로 넘어간다. -->
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
							<!--	JAVASCRIPT:메소드
										입력태그가 아닌 A태그에서 값을 전송하고자하는 경우
										FORM태그를 사용할 수 없으므로  위 방식을 사용해서 A태그의 SEND함수로 VO값을 넘길 수 있다.
										많이 사용하는 방식은 아니다.
 							-->
							<a href="javascript:send('<%=vo.getDeptno()%>')">	
								<%= vo.getdName() %>
							</a>
						</td>
						<td><%= vo.getLoc() %></td>
					</tr>
				<% }%>
		</table>
		
		<!-- A태그로 파라미터를 보내기 힘든 경우
				INPUT태그의 HIDDEN속성을 사용하기도 한다.
				A태그로는 파라미터를 보낼 수 없으므로 대신 눈에 보이지 않는 INPUT태그를 하나 더 만들어서 필요한 값을 넘기는 것이 가능하다. 
				TYPE을 HIDDEN으로 주게되면 입력상자가 눈에 보이지 않게 된다. -->
		<input type="hidden" id="hid" name="deptno">
		</form>
	</body>
</html>