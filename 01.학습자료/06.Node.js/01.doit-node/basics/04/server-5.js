// 라우팅 연습하기  (결과 비교 파일 : 04\results\server-5.js)
const http = require("http");

// 서버 생성
const server = http.createServer((req, res) => {
  res.setHeader("Content-type", "text/plain");

  // req.url : 요청 경로
  // req.method : 요청 방식

  // 구조 분해 할당 (destructing)
  // - 객체 내에서 각 변수를 따로 받는 방식
  // - const url = req.url;
  // - const method = req.method;
  const { url, method } = req;

  //
  if (method === "GET" && url === "/home") {
    res.write("HOME");
    res.end();
  } else if (method === "GET" && url === "/about") {
    res.end("ABOUT"); // 하나의 write만 작성하는 경우 end로 한번에 작성 가능하다.
  } else {
    res.end("Not Found.");
  }
});

// 서버 실행
server.listen(3000, () => {
  console.log("서버가 실행중");
});
