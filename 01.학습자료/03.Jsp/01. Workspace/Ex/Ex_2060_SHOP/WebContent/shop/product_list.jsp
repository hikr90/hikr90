<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	
		<script type="text/javascript">
			function regi() {
				location.href="insert_form.do";
			}
		</script>
	</head>
	<body>
		<!-- jsp:include태그
				- include태그의 바디 영역에서의 사용
				- 헤더와 바디 영역에서의 사용 차이
					- 헤더는 정적인 방식으로 컴파일 단계에서 실행되므로 메인화면과 include가 있는 영역의 변수가 공유되므로 중복이 허용되지 않는다. 속도 측면에서는 빠르다.
					- 바디는 동적인 방식으로 페이지 호출 단계에서 실행되므로 변수가 중복될 일은 없다. 속도는 측면에서는 헤더보다 느리다.
		-->
		<jsp:include page="index.jsp"/>
		
		<!-- 상품 등록 -->
		<div class="regi" align="center">
			<input id="reg" type="button" value="상품등록" onclick="regi();">
		</div>
		
		<table border="1" align="center" width="600px" style="border-collapse: collapse;">
			<tr bgcolor="#dedede">
				<th width="10%">모델명</th>
				<th width="10%">이미지</th>
				<th width="35%">제품명</th>
				<th width="25%">제품 가격</th>
				<th width="20%">비고</th>
			</tr>
			<br>

			<!-- 카테고리에 제품이 없는 경우 -->
			<c:if test="${ empty list }">
				<center>
					해당 카테고리에는 등록된 제품이 없습니다.
				</center>
			</c:if>
			
			<c:forEach var="p" items="${ list }">
			<tr align="center">
				<td>${ p.p_num }</td>
				<td>
					<img src="../images/${ p.p_image_s }" width="100px" height="90px">
				</td>
				<td>
					<a href="view.do?idx=${ p.idx }">${ p.p_name }</a>
				</td>
				<td>
					<fmt:formatNumber value="${ p.p_saleprice }"/><br>
					<font color="red">${ p.salerate }% 할인</font>
				</td>
				<td><fmt:formatNumber value="${ p.p_price }"/></td>
			</tr>
			</c:forEach>
		</table>
	</body>
</html>