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
			// 수정
			function modify(f) {
				var c_cnt = f.c_cnt.value;
				
				var number = /^[0-9]+$/;
				
				// 수량이 정수가 아닌 수가 기입되었을 때 처리
				if(!number.test(c_cnt)){
					alert("수량은 정수만 입력가능합니다.");
					return;
				}
				f.submit();
			}
			
			// 삭제 (장바구니에서 물품만 삭제하는 것이므로 C_IDX를 지워야한다.)
			function del(c_idx) {
				if(!confirm("정말로 삭제하시겠습니까?")){
					return;
				}
				location.href="cart_delete.do?c_idx="+c_idx;
			}
		</script>
	</head>
	<body>
		<jsp:include page="index.jsp"/>
		<table align="center" width="600" border="1" style="border-collapse: collapse;">
			<tr>
				<td colspan="6" align="center">나의 장바구니</td>
			</tr>
			
			<tr>
				<th>모델명</th>
				<th>제품명</th>
				<th>단가</th>
				<th>수량</th>
				<th>금액</th>
				<th>삭제</th>
			</tr>
			
			<c:forEach var="vo" items="${ list }">
			<tr align="center">
				<td>${ vo.p_num }</td>
				<td>${ vo.p_name }</td>
				<td>
					단가 : <fmt:formatNumber value="${ vo.p_price }"/><br>
					<font color="red">
						(할인가 : <fmt:formatNumber value="${ vo.p_saleprice }"/>)
					</font>
				</td>

				<td>
					<!-- 수량의 변화에따라 값을 다르게해야므로 폼 처리한다. CART_UPDATE.DO로 수량(C_CNT)을 몇개 보낼 것인지, 어느 M_IDX로 보낼 것인지 정한다. -->
					<form action="cart_update.do">
						<input type="hidden" name="c_idx" value="${ vo.c_idx }">
						<input name="c_cnt" size="4" align="center" value="${ vo.c_cnt }">
						<input type="submit" value="수정" onclick="modify(this.form);">
					</form>
				</td>
			
				<td><fmt:formatNumber value="${ vo.c_cnt * vo.p_saleprice }"/></td>
				<td>
					<input type="button" value="삭제" onclick="del(${vo.c_idx});">
				</td>
			</tr>
			</c:forEach>			
			
			<c:if test="${ empty list }">			
			<tr>
				<td colspan="6" align="center">장바구니가 비어있습니다.</td>
			</tr>
			</c:if>
			
			<tr>
				<td colspan="5" align="right">총 결제 금액</td>
				<td><fmt:formatNumber value="${ total_amount }"/></td>
			</tr>
		</table>	
	</body>
</html>