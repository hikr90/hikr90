<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="http://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/order.css"
	rel="stylesheet" type="text/css">
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<script src="http://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script>
    $(function() {
        var IMP = window.IMP;
        var code = "imp48842715";  // FIXME: 가맹점 식별코드
        IMP.init(code);

        // 결제요청
        IMP.request_pay({
			
        	// name과 amount만 있어도 결제 진행가능
            pg : 'inicis', // pg 사 선택
            pay_method : 'card',
            merchant_uid : 'merchant_' + new Date().getTime(),
            name : '아임포트 결재',
            amount : '${vo2.oi_price*vo2.oi_count + 3000}',
            buyer_email : '${vo2.oi_deemail}',
            buyer_name :'${vo2.oi_dename}',
            buyer_tel : '${vo2.oi_dephone}',
            buyer_addr : '${vo2.oi_deaddr}',
            buyer_postcode : '123-456',
            m_redirect_url : ''
        }, function(rsp) {
            if ( rsp.success ) {
                var msg = '결제가 완료되었습니다.';
                msg += '고유ID : ' + rsp.imp_uid;
                msg += '상점 거래ID : ' + rsp.merchant_uid;
                msg += '결제 금액 : ' + rsp.paid_amount;
                msg += '카드 승인번호 : ' + rsp.apply_num;
                location.href="orderOk.do?idx=${vo2.idx}&imp="+rsp.imp_uid;
            }
            else {
                var msg = '결제에 실패하였습니다. 에러내용 : ' + rsp.error_msg;
                location.href="piptProdInqy1010.do?category=tree";
            }
            alert(msg);
        });
    });
    </script>
</head>
<body>
<%-- 		<input type="hidden" name="idx" value="${vo2.idx}"> --%>
<%-- 		<input type="hidden" name="g_num" value="${vo2.g_num}"> --%>
<%-- 		<input type="hidden" name="g_name" value="${vo2.g_name}"> --%>
<%-- 		<input type="hidden" name="g_price" value="${vo2.g_price}"> --%>
<%-- 		<input type="hidden" name="oi_count" value="${vo2.oi_count}"> --%>
<%-- 		<input type="hidden" name="sum" value="${vo2.oi_price * vo2.oi_count}"> --%>
<%-- 		<input type="hidden" name="total" value="${vo2.oi_price * vo2.oi_count + 3000}"> --%>
<%-- 		<input type="hidden" name="m_name" value="${vo2.m_name}"> --%>
<%-- 		<input type="hidden" name="oi_dephone" value="${vo2.oi_dephone}"> --%>
<%-- 		<input type="hidden" name="m_email" value="${vo2.m_email}"> --%>
<%-- 		<input type="hidden" name="oi_deaddr" value="${vo2.oi_deaddr}"> --%>
<%-- 		<input type="hidden" name="oi_date" value="${vo2.oi_date}"> --%>
<%-- 		<input type="hidden" name="oi_derequest" value="${vo2.oi_derequest}"> --%>
</body>
</html>