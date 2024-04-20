<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	
		<script type="text/javascript">
			function checkdata(f) {
				var category = f.category.value;
				var p_num = f.p_num.value;
				var p_name = f.p_name.value;
				var p_company = f.p_company.value;
				var p_price = f.p_price.value;
				var p_saleprice = f.p_saleprice.value;
				var p_img_s = f.p_img_s.value;
				var p_img_l = f.p_img_l.value;
				var p_content = f.p_content.value;
				
				var category = f.category.value;
				var p_num = f.p_num.value;
				var p_name = f.p_name.value;
				var p_company = f.p_company.value;
				var p_price = Number(f.p_price.value);
				var p_saleprice = f.p_saleprice.value;
				var p_img_s = f.p_img_s.value;
				var p_img_l = f.p_img_l.value;
				var p_content = f.p_content.value;
				var p_patteren = /^[0-9]+$/;
				
				// 유효성 검사
				if(category=="cate_no"){
					alert("카테고리를 선택해주세요.");
					return;
				}
				if(p_num==""){
					alert("모델명을 입력해주세요.");
					return;
				}
				if(p_name==""){
					alert("제품명을 입력해주세요.");
					return;
				}
				if(p_company==""){
					alert("제조사명을 입력해주세요.");
					return;
				}
				if(p_price==""){
					alert("가격을 입력해주세요.");
					return;
				}else if(!p_patteren.test(p_price)){
					alert("숫자만 입력 가능합니다.");
					return;
				}else if(p_price<10000){
					alert("가격은 최소 만원 이상이여야합니다.");
					return;
				}
				if(p_saleprice==""){
					alert("할인가를 입력해주세요.");
					return;
				}else if(!p_patteren.test(p_saleprice)){
					alert("숫자만 입력 가능합니다.");
					return;
				}else if(p_saleprice<10000){
					alert("할인가는 최소 만원 이상이여야합니다.");
					return;
				}
				if(p_img_s==""){
					alert("사진을 업로드해주세요.");
					return;
				}
				if(p_img_l==""){
					alert("사진을 업로드해주세요.");
					return;
				}
				if(p_content==""){
					alert("제품 소개를 입력해주세요.");
					return;
				}
				
				f.submit();
			}
		</script>
	</head>
	<body>
		<jsp:include page="index.jsp"/>
		
		<form name="f" 
				method="POST"
				enctype="multipart/form-data" 
				action="insert.do">
		<table border="1"
			 	align="center" 
			 	width="600px" 
			 	style="border-collapse: collapse;">
			<tr>
				<td>제품 카테고리</td>
				<td>
				<!-- 어느 카테고리에 넣을지 비교할 파라미터 용도 -->
					<select name="category">
						<option value="">카테고리 선택</option>
						<option value="com001">컴퓨터</option>
						<option value="ele002">가전 제품</option>
						<option value="sp003">스포츠 용품</option>
					</select>
				</td>
			</tr>
			
			<tr>
				<td>모델명</td>
				<td><input name="p_num"></td>
			</tr>

			<tr>
				<td>제품명</td>
				<td><input name="p_name"></td>
			</tr>

			<tr>
				<td>제조사</td>
				<td><input name="p_company"></td>
			</tr>

			<tr>
				<td>가격</td>
				<td><input name="p_price"></td>
			</tr>

			<tr>
				<td>할인가</td>
				<td><input name="p_saleprice"></td>
			</tr>

			<tr>
				<td>제품사진(작은 사진)</td>
				<td><input type="file" name="p_img_s"></td>
			</tr>

			<tr>
				<td>제품사진(상세 설명)</td>
				<td><input type="file" name="p_img_l"></td>
			</tr>

			<tr>
				<td>제품 소개</td>
				<td><textarea name="p_content" row="5"></textarea></td>
			</tr>

			<tr>
				<td colspan="2" align="center">
					<input type="button" value="상품등록" onclick="checkdata(this.form);">
				</td>
			</tr>
		</table>
		</form>
	</body>
</html>