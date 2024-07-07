<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>환불 하기</title>
</head>
<body>
111111111111111111111111111
<!--  <button onclick="cancelPay()">환불하기</button> -->
  <script
    src="https://code.jquery.com/jquery-3.3.1.min.js"
    integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
    crossorigin="anonymous"></script><!-- jQuery CDN --->
  <script>
  
//   function cancelPay() {
//       jQuery.ajax({
//         "url": "http://www.myservice.com/payments/cancel",
//         "type": "POST",
//         "contentType": "application/json",
//         "data": JSON.stringify({
//           "merchant_uid": "mid_" + new Date().getTime(), // 주문번호
//           "cancel_request_amount": 105, // 환불금액
//           "reason": '', // 환불사유
//           "refund_holder": '유영일', // [가상계좌 환불시 필수입력] 환불 수령계좌 예금주
//           "refund_bank": '20', // [가상계좌 환불시 필수입력] 환불 수령계좌 은행코드(ex. KG이니시스의 경우 신한은행은 88번)
//           "refund_account": '1002553062276' // [가상계좌 환불시 필수입력] 환불 수령계좌 번호
//         }),
//         "dataType": "json"
//       });
//     }

//     <!-- Node.js -->
//     var express = require('express');
//     var app = express();
//     var axios = require('axios');
//     /* ... 중략 ... */
//     app.post('/payments/cancel', async (req, res, next) => {
//       try {
//         /* 액세스 토큰(access token) 발급 */
//         const getToken = await axios({
//           url: "https://api.iamport.kr/users/getToken",
//           method: "post", // POST method
//           headers: { 
//             "Content-Type": "application/json" 
//           },
//           data: {
//             imp_key: "6862946469110187", // [아임포트 관리자] REST API키
//             imp_secret: "fKFbeWmSM15LsMe5ImgJu7wVZnlg5wOkhtwvpSocTuXlgcqYyHI3PeYOCj4HQS27myDMr2YlwWHN88MG" // [아임포트 관리자] REST API Secret
//           }
//         });
//         const { access_token } = getToken.data.response; // 엑세스 토큰
//         /* 결제정보 조회 */
       
//       } catch (error) {
//         res.status(400).send(error);
//       }
//     });
//     /* ... model/payments.js ... */
//     var mongoose = require('mongoose');
//     var Schema = mongoose.Schema;
    
//     var PaymentsSchema = new Schema({
//       imp_uid: String, // 아임포트 고유번호(환불 요청시 고유번호로 사용)
//       merchant_uid: String, // 주문번호(결제정보 조회시 사용)
//       amount: { type: Number, default: 0 }, // 결제 금액(환불 가능 금액 계산시 사용)
//       cancel_amount: { type: Number, default: 0 }, // 환불 된 총 금액(환불 가능 금액 계산시 사용)
      
//     });
    
//     module.exports = mongoose.model('Payments', PaymentsSchema);
//     var Payments = require('./models/payments');
//     app.post('/payments/cancel', async (req, res, next) => {
//       try {
//         /* 액세스 토큰(access token) 발급 */
//         /* ... 중략 ... */
//         /* 결제정보 조회 */
//         const { body } = req;
//         const { merchant_uid } = body; // 클라이언트로부터 전달받은 주문번호
//         Payments.find({ merchant_uid }, async function(err, payment) { 
//           if (err) {
//             return res.json(err);
//           }
//           const paymentData = payment[0]; // 조회된 결제정보
//           /* 아임포트 REST API로 결제환불 요청 */
          
//         });
//       } catch (error) {
//         res.status(400).send(error);
//       }
//     });
//     /* ... 중략 ... */
//     app.post('/payments/cancel', async (req, res, next) => {
//       try {
//         /* 액세스 토큰(access token) 발급 */
//         /* ... 중략 ... */
//         /* 결제정보 조회 */
//         const { body } = req;
//         const { merchant_uid, reason } = body; // 클라이언트로부터 전달받은 주문번호, 환불사유
//         Payments.find({ merchant_uid }, async function(err, payment) { 
//           /* ... 중략 ... */
//           const paymentData = payment[0]; // 조회된 결제정보
//           const { imp_uid } = paymentData; // 조회한 결제정보로부터 imp_uid 추출
//           /* 아임포트 REST API로 결제환불 요청 */
//           const getCancelData = await axios({
//             url: "https://api.iamport.kr/payments/cancel",
//             method: "post",
//             headers: {
//               "Content-Type": "application/json",
//               "Authorization": access_token // 아임포트 서버로부터 발급받은 엑세스 토큰
//             },
//             data: {
//             	reason, // 가맹점 클라이언트로부터 받은 환불사유
//                 imp_uid, // imp_uid를 환불 고유번호로 입력
//                 amount: cancel_request_amount, // 가맹점 클라이언트로부터 받은 환불금액
//                 checksum: cancelableAmount, // [권장] 환불 가능 금액 입력
//                 refund_holder, // [가상계좌 환불시 필수입력] 환불 수령계좌 예금주
//                 refund_bank, // [가상계좌 환불시 필수입력] 환불 수령계좌 은행코드(ex. KG이니시스의 경우 신한은행은 88번)
//                 refund_account // [가상계좌 환불시 필수입력] 환불 수령계좌 번호
//             }
//           });
//           const { response } = getCancelData.data; // 환불 결과
//           /* 환불 결과 동기화 */
          
//         });
//       } catch (error) {
//         res.status(400).send(error);
//       }
//     });
//     /* ... 중략 ... */
//     app.post('/payments/cancel', async (req, res, next) => {
//       try {
//         /* 액세스 토큰(access token) 발급 */
//         /* ... 중략 ... */
//         /* 결제정보 조회 */
//         Payments.find({ merchant_uid }, async function(err, payment) { 
//           /* ... 중략 ... */
//           /* 아임포트 REST API로 결제환불 요청 */
//           /* ... 중략 ... */
//           const { response } = getCancelData.data; // 환불 결과
//           /* 환불 결과 동기화 */
//           const { merchant_uid } = response; // 환불 결과에서 주문정보 추출
//           Payments.findOneAndUpdate({ merchant_uid }, response, { new: true }, function(err, payment) { // 주문정보가 일치하는 결제정보를 추출해 동기화
//             if (err) {
//               return res.json(err);
//             }
//             res.json(payment); // 가맹점 클라이언트로 환불 결과 반환
//           });
//         });
//       } catch (error) {
//         res.status(400).send(error);
//       }
//     });
    
    </script>
    
</body>
</html>