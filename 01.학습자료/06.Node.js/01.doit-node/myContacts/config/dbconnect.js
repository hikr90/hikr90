/* MongoDB와 VSCode 연동
    # 순서
      (1) 몽고디비 회원가입
      (2) Database에서 Clusters 생성
      (3) Connect 클릭 후 MongoDB for VSCode 선택
      (4) VSCode에서 확장 프로그램 선택 후 MongoDB for VSCode 설치
      (5) MongoDB 메뉴 선택 후 add Connect 클릭
      (6) 복사한 URL을 입력한 뒤 패스워드를 기입하여 연동

    # 모듈
      (1) mongoose : 몽고DB 연동 보조 모듈
      (2) dotenv : .env 파일에 있는 데이터를 가져오게하는 모듈
*/

// mongoose, dotenv 모듈 동작
const mongoose = require("mongoose");
require("dotenv").config();

// 비동기 처리 (async, await)
const dbConnect = async () => {
  try {
    // process.env : env파일 안의 변수를 가져오는 객체 (config함수가 먼저 선행되어야한다.)
    // await : 동작 시 시간 대기
    const connect = await mongoose.connect(process.env.DB_CONNECT);
    console.log("DB Connected.");
  } catch (error) {
    console.log(error);
  }
};

//
module.exports = dbConnect;
