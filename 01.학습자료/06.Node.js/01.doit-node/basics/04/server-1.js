// HTTP 모듈로 서버 만들고 실행하기 (결과 비교 파일 : 04\results\server-1.js)
// 노드 코어 모듈 (http)
const http = require("http");

/* createServer
    - http 모듈으로 서버를 생성하는 함수
    - 콜백함수 (요청, 응답) 를 파라미터로 받는다.

*/
// 서버 생성
const server = http.createServer((req, res) => {
  console.log("요청 발생");
});

/* listen
    - 서버를 실행하는 메소드
    - 포트번호, 콜백함수 () 를 파라미터로 받는다.
*/
// 서버 실행
server.listen(3000, () => {
  console.log("서버가 실행중");
});

// localhost란 사용자 컴퓨터에 생성된 서버를 가르키는 키워드를 뜻한다.
// 웹브라우저에서 localhost:3000 을 입력한다.

// 서버를 중지하고자하는 경우, 터미널에서 Ctrl + c 를 입력한다.
