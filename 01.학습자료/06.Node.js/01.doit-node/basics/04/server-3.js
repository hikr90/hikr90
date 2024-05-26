// 응답 객체 확인하기 - 응답 헤더, 응답 본문, 응답 종료  (결과 비교 파일 : 04\results\server-3.js)
const http = require("http");

/* 요청 객체 & 응답 객체
        - 웹브라우저에서 요청과 응답에 관한 데이터를 가지고있는 저장 공간
        - 헤더와 본문 내용으로 구성되며, json 데이터 혹은 문자 데이터 등으로 제공 받는다.
*/

// 서버 생성
const server = http.createServer((req, res) => {
  // 헤더의 속성 값을 지정하는 함수
  res.setHeader("Content-type", "text/plain"); // 응답할 데이터의 타입 지정

  // 화면 상에 데이터를 표시하는 함수
  res.write("Hello Node");

  // 응답을 종료하는 함수
  res.end();
});

// 서버 실행
server.listen(3000, () => {
  console.log("서버가 실행중");
});

/* 라우팅
    - 클라이언트에서 들어오는 요청에따라 그에 맞는 함수가 실행되는 것
    - 요청 방식 (GET, POST, PUT, DELETE) 에따라서 처리할 함수를 다르게 할 수도 있다.
*/
