<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	
		<script src="../js/httpRequest.js"></script>
		<script type="text/javascript">
			function addCart(p_idx, m_idx) {
				//
				var url = "cart_insert.do";
				var param = "p_idx="+p_idx+"&m_idx="+m_idx; 
				//				
				sendRequest(url,param,resultFn,"POST");
			}
			
			// 콜백 메소드
			function resultFn() {
				//
				if(xhr.readyState==4 && xhr.status==200){
					var data = xhr.responseText;
					if(data=='yes'){
						alert("장바구니에 담았습니다.");
						if(!confirm("장바구니로 이동하시겠습니까?")){
							return;
						}
						location.href="cart_list.do";
					}else{
						alert("이미 장바구니에 담겨있는 상품입니다.");
					}
				}
			}
		</script>
	</head>
	<body>
		<jsp:include page="index.jsp"/>
		
		<table align="center" border="1" width="600" style="border-collapse: collapse;">
			<tr>
				<td>제품 카테고리</td>
				<td>${ vo.category }</td>
			</tr>
			<tr>
				<td>모델명</td>
				<td>${ vo.p_num }</td>
			</tr>
			<tr>
				<td>제품명</td>
				<td>${ vo.p_name }</td>
			</tr>
			<tr>
				<td>제조사</td>
				<td>${ vo.p_company }</td>
			</tr>
			<tr>
				<td>가격</td>
				<td>
					<fmt:formatNumber value="${ vo.p_price }" />
					(할인가 : <fmt:formatNumber value="${ vo.p_saleprice }"/>)
				</td>
			</tr>
			<tr>
				<td>제품 설명</td>
				<td>${ vo.p_content }</td>
			</tr>
			<tr>
				<td colspan="2" align="center"> <!-- 큰 이미지 -->
					제품 설명 이미지 <img src="../images/${ vo.p_image_l }" width="500">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="장바구니 담기" onclick="addCart('${ vo.idx }', '${ 1 }');">
					<input type="button" value="장바구니 보기" onclick="location.href='cart_list.do'">
				</td>
			</tr>
		</table>
	</body>
</html>