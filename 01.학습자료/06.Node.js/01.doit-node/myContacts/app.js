/* express
    - node.js를 사용하여 서버를 쉽게 구성할 수 있게 만든 클래스와 라이브러리 집합체
    - http 모듈 기능 외에도 다양한 기능 소유

    # 기능
      (1) 라우팅
      (2) 미들웨어
      (3) 템플릿 엔진
      (4) 정적인 파일 지원

    # 설치
      (1) npm init
        - package-name : 개발하고자하는 애플리케이션 명칭 (소문자 권장)
        - version : 웹 애플리케이션 버전 입력
        - description : 간략한 설명
        - entry point : 애플리케이션이 동작하는 실행 파일
        - test-command : 테스트에 사용할 명령어
        - git-repository : 애플리케이션을 깃에 푸쉬할 경우 사용할 저장소
        - keywords : 다른 사람이 애플리케이션을 검색하는 경우 사용할 명칭
        - lisence : 라이센스 (기본 값 : ISC)

      (2) npm i express
        - node_modules (express 패키지와 관련된 파일) 이 같이 설치된다.

      (3) npm i nodemon --save-dev -g
        - 서버 코드 작성 시, 서버 종료없이 수정된 내용을 바로 적용해주는 패키지
        - save-dev는 개발 시에만 사용하고 운영 배포에서는 사용하지 않는다는 뜻이다.
        - g는 global의 약자로 한번 설치 시 시스템 내에서 자유롭게 사용할 수 있도록 한다.

    # 메소드
      (1) get : get 방식 요청
      (2) post : post 방식 요청
      (3) put : 값 수정
      (4) delete : 값 삭제
*/

// 서버 생성
//const express = require("express");
//const app = express();

// npx nodemon app 혹은 nodemon app 콘솔에 입력하여 서버 동작
//app.listen(3000, () => {
//  console.log("서버 실행 중");
//});

/* get
    - 서버에서, get 방식으로 요청이 오는 경우 처리하는 함수
    - (맵핑 경로, 콜백함수) 요청이 있을 경우, 콜백함수를 동작한다.
*/
//app.get("/", (req, res) => {
//  res.send("Hello World!");
//});

//app.get("/contacts", (req, res) => {
//  res.send("Get Contact Page!");
//});

/* post
    - 서버에서, post 방식으로 요청이 오는 경우 처리하는 함수
    - (맵핑 경로, 콜백함수) 요청이 있을 경우, 콜백함수를 동작한다.
    - post 방식을 확인하기위해서는 thunder client라는 vscode 확장 프로그램을 사용한다.

      # thunder client
        - 마켓 플레이스 메뉴에서 thunder client 검색 후 설치
        - new request 클릭 후 url과 타입을 지정한 뒤 send 버튼으로 테스트 진행
*/
//app.post("/contacts", (req, res) => {
//  res.send("Post Contact Page!");
//});

/* 라우트 파라미터
    - 특정 값에 해당하는 데이터만 가져오고자할 때 사용하는 기능
    - 요청 url 뒤에 : 를 붙여 그 뒤에 변수 작성
    - /요청 url/:id
*/

// 연락처 조회
//app.get("/contacts/:id", (req, res) => {
//  res.send(`View Contact for Id : ${req.params.id}`);
//});

// 연락처 수정
//app.put("/contacts/:id", (req, res) => {
//  res.send(`Update Contact for Id : ${req.params.id}`);
//});

// 연락처 삭제
//app.delete("/contacts/:id", (req, res) => {
//  res.send(`Delete Contact for Id : ${req.params.id}`);
//});

/* 요청 객체의 속성
    (1) req.body : 서버로 post 요청 시 넘겨준 정보를 가지고있다.
    (2) req.cookie : 클라이언트에 저장된 쿠키 정보를 서버로 넘긴 경우 저장되는 정보
    (3) req.headers : 서버로 요청보낸 헤더의 정보
    (4) req.params : 요청 url 뒤에 붙어있는 파라미터를 뜻한다.
    (5) req.query : 요청 url에 포함된 질의 매개변수를 뜻한다.
*/

/* 미들웨어
    - 요청과 응답 중간에서 요청을 처리하거나 원하는 형태로 응답을 처리하는 함수
    - 서버의 응답과 요청을 따로 생성할 필요없이 한 곳에 묶여서 관리하므로 가독성이 좋다.
    - 라우터 미들웨어는 코드 작성 후 use 함수를 통해서 사용하는 미들웨어를 명시해줘야한다.
    
    # 역할
      (1) 요청 전처리
        - 요청이 서버에 도착하기 전에 실행하는 작업
        - 사용자 인증, 폼 내용 검증 등의 작업

      (2) 라우팅 처리
        - 특정 url로 진입한 요청을 라우터 핸들러등으로 통합적으로 관리

      (3) 응답 처리
        - 서버에서 클라이언트로 응답을 보내기전에 데이터를 적합한 형태로 변환하거나, 오류등의 예외를 처리
*/

/*
// 라우터 생성
// - 라우터란, 네트워크 간 연결을 돕는 장치를 뜻한다.
const router = express.Router();

// 라우터 동작
router
  .route("/contacts")
  .get((req, res) => {
    res.send("Get Contacts Page!");
  })
  .post((req, res) => {
    res.send("Post Contacts Page!");
  });

router
  .route("/contacts/:id")
  .get((req, res) => {
    res.send(`View Contact for Id : ${req.params.id}`);
  })
  .put((req, res) => {
    res.send(`Update Contact for Id : ${req.params.id}`);
  })
  .delete((req, res) => {
    res.send(`Delete Contact for Id : ${req.params.id}`);
  });

// 라우터 명시
app.use(router);
*/

// contentRoutes를 미들웨어로 사용
const express = require("express");
const dbConnect = require("./config/dbconnect");
const app = express();

// DB연동
dbConnect();

// 바디파서 미들웨어 등록
app.use(express.json());
app.use(express.urlencoded({ extended: true }));

app.use("/contacts", require("./routes/contentRoutes"));

app.listen(3000, () => {
  console.log("서버 실행중");
});

/* 바디파서 미들웨어
    - 서버로 요청을 보낼 때 요청 본문에 담긴 내용을 파싱(프로그램에서 사용할 수 있도록 변환)하는 미들웨어
    - 요청 본문에 어떤 유형의 자료가 있는가에따라서 사용되는 함수가 달라진다.
    - 일부 기능(json, urlencoded)이 express에 포함되어있으므로 따로 다운로드할 필요가 없다. 

    # 기능
      (1) .json() : json 형식의 본문을 파싱
      (2) .urlencoded() : url로 인코딩된 본문을 파싱
        (2.1) 파라미터
            - extended true : query string이 중복된 개체더라도 처리
            - extended false : 중복되는 개체는 제외

      (3) .row() : 가공되지 않은 바이너리 타입의 데이터를 파싱
      (4) .text() : 텍스트 형식의 본문을 파싱
*/
