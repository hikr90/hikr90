<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/pipt_include_1020.jsp"%>
<%@include file="check_login.jsp"%>
<style type="text/css">
a:link {
	text-decoration: none;;
	font-family: "나눔스퀘어";
}
</style>
<link href="${pageContext.request.contextPath}/resources/css/order.css"
	rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/resources/js/tab.js"></script>
<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	function goPopup() {
		new daum.Postcode({
			oncomplete : function(data) {
				var addr = '';

				if (data.userSelectedType == 'R') {
					addr = data.roadAddress;
				} else {
					addr = data.jibunAddress;
				}

				document.getElementById('zipcode').value = data.zonecode;
				document.getElementById("addr").value = addr;

				document.getElementById("addr").focus();

			}
		}).open();
	}

	function orderAction() {

		var f = document.ff;
// 		var m_name = f.m_name.value;
// 		var m_email = f.email1.value + '@' + f.email2.value;
// 		var m_phone = f.hp1.value + '-' + f.hp2.value + '-' + f.hp3.value;
// 		var m_tel = f.tel1.value + '-' + f.tel2.value + '-' + f.tel3.value;
// 		var m_addr = f.zipcode.value + ' ' + f.addr.value;

		var oi_dename = f.oi_dename.value;
		var oi_deemail = f.deemail1.value + '@' + f.deemail2.value;
		var oi_dephone = f.dehp1.value + '-' + f.hp2.value + '-' + f.hp3.value;
		var oi_sms = f.oi_sms.value;
		var oi_deaddr = f.dezipcode.value + ' ' + f.deaddr.value + ' ' +f.deaddress.value;
		var oi_derequest = f.oi_derequest.value;
		
		console.log(oi_derequest);
		
		var email_pattern = /^[-A-Za-z0-9_]+[-A-Za-z0-9_.]*[@]{1}[-A-Za-z0-9_]+[-A-Za-z0-9_.]*[.]{1}[A-Za-z]{1,5}$/;

		if (oi_dename == '') {
			alert("이름을 입력해야 합니다!");
			return;
		}
		if (oi_deemail == '' || !email_pattern.test(oi_deemail)) {
			alert("이메일을 입력해야 합니다!");
			return;
		}

		if (oi_dephone == '') {
			alert("휴대폰 번호를 입력해야 합니다!");
			return;
		}

		if (oi_deaddr == '') {
			alert("주소를 입력해야 합니다!");
			return;
		}

		f.submit();

	}
</script>

<div id="wrap">
	<div id="producttxt">주문 / 결제</div>
	<div id="product">
		<form id="producttable" name="ff" method="POST" action="import.do">
			<h2>주문 상품</h2>
			<p>&nbsp;</p>
			<table width="1200" height="251" border="0" cellpadding="10"
				cellspacing="0">
				<input type="hidden" name="oi_price" value="${vo2.g_price}"> 
				<input type="hidden" name="oi_count" value="${vo2.count}"> 
				<input type="hidden" name="g_num" value="${vo2.g_num}"> 
				<tbody>
					<tr>
						<th width="116" height="50" scope="row">상품코드</th>
						<th width="425">상품명</th>
						<th width="116">판매가</th>
						<th width="116">수량</th>
						<th width="116">가격</th>
					</tr>
						<c:set var="price" value="${vo2.g_price }" />
						<c:set var="count" value="${vo2.count}" />
						<c:set var="delivery" value="3000" />
						<c:set var="sum" value="${price*count + delivery}" />
						<tr>
							<td height="121" scope="row">${vo2.idx }</td>
							<td>${vo2.g_name }</td>
							<td><fmt:formatNumber value="${vo2.g_price }" />원</td>
							<td>${vo2.count }그루</td>
							<td><fmt:formatNumber value="${price*count }" />원</td>
						</tr>
					<tr>
						<td height="50" scope="row"></td>
						<td height="50" colspan="2"><span class="productTotal">상품금액
								+ 배송비(3000원)</span></td>
						<td height="50" colspan="2"><fmt:formatNumber value="${sum }" />원</td>
					</tr>
				</tbody>
			</table>
			<br> <br> <br>
			<h2>주문고객 정보</h2>
			<p>&nbsp;</p>
			<table id="orderform" width="1120" height="240" border="0"
				cellpadding="10" cellspacing="0">

				<tbody>
					<tr>
						<th width="182" height="80" scope="row">이름</th>
						<td width="283">${vo2.m_name }</td>
						<th width="182" scope="row">이메일</th>
						<td width="319">${vo2.m_email }
							<p>
								<span class="sub">(주문정보를 이메일로 보내드립니다.)</span>
							</p>
						</td>
					</tr>
					<tr>
						<th width="182" height="80" scope="row">휴대폰번호</th>
						<td>
							${vo2.m_phone }
						</td>
						<th width="182" scope="row">전화번호</th>
						<td>
							${vo2.m_tell }
						</td>
					</tr>
					<tr>
						<th width="182" height="80" scope="row">SMS수신</th>
						<td colspan="3">
							<input type="radio" id="smsY" name="oi_sms" value="1" checked> 주문 배송 정보 수신&nbsp;&nbsp;
							<input type="radio" id="smsN" name="oi_sms" value="2"> 수신받지않음
						</td>

					</tr>
				</tbody>
			</table>
			<br>
			<p>*주문자 정보를 수정해도 회원정보는 변경되지 않습니다.</p>
			<p>회원정보 변경은 '마이페이지 &gt; 회원정보수정'에서 가능합니다.</p>

			<br> <br> <br>
			<h2>배송지 정보</h2>
			<p>&nbsp;</p>
			<table id="deliveryform" width="1120" height="320" border="0"
				cellpadding="10" cellspacing="0">

				<tbody>
					<tr>
						<th width="182" height="80" scope="row">이름</th>
						<td width="283">
							<input type="text" name="oi_dename" id="name">
						</td>
						<th width="182" scope="row">이메일</th>
						<td width="319">
							<p>
								<input type="text" id="email1" name="deemail1" size="15">
								@ <select id="email2" name="deemail2">
									<option value="naver.com" selected>naver.com
									<option value="hanmail.net">hanmail.net
									<option value="gmail.com">gmail.com
									<option value="nate.com">nate.com
								</select>
							</p>
							<p>
								<span class="sub">(주문정보를 이메일로 보내드립니다.)</span>
							</p>
						</td>
					</tr>
					<tr>
						<th width="182" height="80" scope="row">휴대폰번호</th>
						<td>
							<input id="hp1" name="dehp1" size="4"> - 
							<input id="hp2" name="dehp2" size="4"> - 
							<input id="hp3" name="dehp3" size="4">
						</td>
						<th width="182" scope="row">전화번호</th>
						<td>
							<input type="text" id="tel1" name="detel1" size="4"> - 
							<input type="text" id="tel2" name="detel2" size="4"> - 
							<input type="text" id="tel3" name="detel3" size="4">
						</td>
					</tr>
					<tr>
						<th width="182" height="80" scope="row">주소</th>
						<td colspan="3">
							<input id="zipcode" name="dezipcode">
								<img src="${pageContext.request.contextPath}/resources/image/postaddress.png" value="우편번호찾기" onclick="javascript:goPopup();"><br> 
							<input id="addr" name="deaddr" size="35" >
							<input id="address" name="deaddress" size="40">
						    	 <span class="sub">상세 주소 입력</span>
						</td>
					</tr>
					<tr>
						<th width="182" height="80" scope="row">배송 요청사항</th>
						<td colspan="3">
							<p>
								<select id="memo" name="oi_derequest">
									<option value="1" selected>배송 요청사항 	없음									
									<option value="2">부재시 경비실에 맡겨주세요.
									<option value="3">배송 전 연락바랍니다.
									<option value="4">부재시 핸드폰으로 연락바랍니다.
								</select>
							</p>
						</td>
					</tr>
				</tbody>
			</table>
			<br> <br> <br>
<!-- 			<h2>TOTAL</h2><br> -->
<!-- 			<p>&nbsp;</p> -->
<!-- 			<table id="payform" width="650" height="240" border="0" -->
<!-- 				cellpadding="10" cellspacing="0"> -->
<!-- 				<tbody> -->
<!-- 					<tr> -->
<!-- 						<th width="140" height="80" scope="row">신용카드</th> -->
<!-- 						<td width="469"><label for="input">카드번호&nbsp;</label><input -->
<!-- 							type="text" id="cardNum" size="18">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label -->
<!-- 							for="cardPW">비밀번호&nbsp;</label><input type="password" id="cardPW" -->
<!-- 							size="18"></td> -->
<!-- 					</tr> -->
<!-- 					<tr> -->
<!-- 						<th width="141" height="80" scope="row">무통장입금</th> -->
<!-- 						<td><select id="bank"> -->
<!-- 								<option value="우리은행" selected>우리은행 ( 324-01-123400 / -->
<!-- 									(주)LandScape)&nbsp;&nbsp; -->
<!-- 								<option value="국민은행">국민은행 ( 011-02-300481 / -->
<!-- 									(주)LandScape)&nbsp;&nbsp; -->
<!-- 								<option value="신한은행">신한은행 ( 987-25-202099 / -->
<!-- 									(주)LandScape)&nbsp;&nbsp; -->
<!-- 								<option value="하나은행">하나은행 ( 698-00-222176 / -->
<!-- 									(주)LandScape)&nbsp;&nbsp; -->
<!-- 								<option value="농협은행">농협은행 ( 327-56-333002 / -->
<!-- 									(주)LandScape)&nbsp;&nbsp; -->
<!-- 						</select></td> -->
<!-- 					<tr> -->
<!-- 						<th width="141" height="80" scope="row">휴대폰 결제</th> -->
<!-- 						<td colspan="3"><select id="agency"> -->
<!-- 								<option value="SKT" selected>SKT -->
<!-- 								<option value="KT">KT -->
<!-- 								<option value="LG">LG -->
<!-- 						</select> <input type="text" id="PAYphone" size="15"></td> -->

<!-- 					</tr> -->
<!-- 				</tbody> -->
<!-- 			</table> -->
	<div align="center">
		<h2>TOTAL</h2><br>
			<table id="totalform" width="400" height="240" border="0"
				cellpadding="10" cellspacing="0">
				<tbody>
					<tr>
						<th width="143" height="80" scope="row">주문금액</th>
						<td width="257">
							<fmt:formatNumber value="${price*count }"/>원
						</td>
					<tr>
						<th width="143" height="80" scope="row">배송비</th>
						<td>
							<fmt:formatNumber value="3000"/>원
						</td>
					<tr>
						<th width="143" height="80" scope="row">총 주문금액</th>
						<td colspan="3">
							<fmt:formatNumber value="${sum }"/>원
						</td>

					</tr>
				</tbody>
			</table>
		</div>
		<div align="center">
			<p>* 휴대폰으로 결제하신 금액은 익월 휴대폰 요금에 함께 청구됩니다</p><br>
			<p>
				<span class="payimg">
				<img src="${pageContext.request.contextPath}/resources/image/pay.png" alt="" onclick="javascript:orderAction();"/></span>
			</p>
		</div>
		</form>



	</div>



</div>
<%@include file="/WEB-INF/views/include/pipt_include_1030.jsp"%>