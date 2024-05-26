const express = require("express");
const router = express.Router();

router
  .route("/")
  .get((req, res) => {
    res.send("Get Contacts Page!");
  })
  .post((req, res) => {
    console.log(req.body); // 요청이 파싱되어야 JSON 데이터 값의 조회가 가능하다.
    const { name, email, phone } = req.body; // 구조분해할당

    //
    if (!name || !email || !phone) {
      return res.send("필수 값이 입력되지 않았습니다.");
    }
    res.send("Post Contacts Page!");
  });

router
  .route("/:id")
  .get((req, res) => {
    res.send(`View Contact for Id : ${req.params.id}`);
  })
  .put((req, res) => {
    res.send(`Update Contact for Id : ${req.params.id}`);
  })
  .delete((req, res) => {
    res.send(`Delete Contact for Id : ${req.params.id}`);
  });

// 모듈에서 라우터 리턴
module.exports = router;
