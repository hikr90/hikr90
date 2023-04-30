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
		<!-- INCLUDE의 BODY 영역에서 사용 방법
				JSP:INCLUDE를 사용하여 JSP를 추가하는 경우 INDEX.JSP가 항상 화면 위에 위치하게 된다.
				(기본적으로 대부분의 사이트는 상단의 메뉴를 하나하나 만들지 않으므로 보통 상단이나 하단 메뉴는 JSP:INCLUDE를 통해서 고정시킨다.) 

				HEADER와 BODY의 위치시 차이
					HEADER : 정적인 방식(컴파일 단계에서 실행)으로 메인 화면과 INCLUDE가 있는 영역의 변수가 공유되므로 중복이 허용안된다. 속도 측면으로는 빠르다.
					BODY : 동적인 방식(페이지 호출 단계에서 실행)으로 변수가 중복될 걱정이 없다. 단 속도가 느리다.
		-->
		<jsp:include page="index.jsp"/>
		
		<!-- 상품 등록하기 -->
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

			<!-- 카테고리에 제품이 없는 경우 NULL로 구분 -->
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
					<!-- 제품 명칭의 A태그를 선택시 제품 상세보기인 VIEW.DO페이지로 IDX를 보낸다.  -->
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