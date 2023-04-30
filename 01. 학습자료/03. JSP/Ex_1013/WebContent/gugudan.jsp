<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!-- html 주석 : 보안성이 떨어짐(html소스보기에서 볼 수 있다.)  -->
<%-- jsp 주석 : 보안성이 높음(페이지에서 소스보기로 볼 수 없다.)--%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	
		<style type="text/css">
			table{border-collapse: collapse;}
		</style>
	</head>
	<body>
		
		<table border="1">
		<% for(int i=1;i<10;i++){%>
			<tr>
			<% for(int j=2;j<10;j++){%>
				<td>
				<%-- <%= j+" * "+i+" = "+i*j%> --%>
				<% String str = String.format("%d * %d = %d",j,i,j*i);%>
				<%=str%>
				</td>
		<% }%>
			</tr>
		<% } %>
		</table>
		
		
		
		
			
	</body>
</html>