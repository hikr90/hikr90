/* express-async-handler
    - try catch 대신 async를 에러 체크하는 라이브러리
    - npm으로 설치
*/
const asyncHandler = require("express-async-handler");

// Get All Contacts
const getAllContacts = asyncHandler(async (req, res) => {
  res.send("Contacts Page!");
});

// Create Contacts
const createContact = asyncHandler(async (req, res) => {
  console.log(req.body); // 요청이 파싱되어야 JSON 데이터 값의 조회가 가능하다.
  const { name, email, phone } = req.body; // 구조분해할당

  //
  if (!name || !email || !phone) {
    return res.send("필수 값이 입력되지 않았습니다.");
  }
  res.send("Post Contacts Page!");
});

//
module.exports = getAllContacts;
module.exports = createContact;
