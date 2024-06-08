const express = require("express");
const router = express.Router();
const getAllContacts = require("../controllers/contactController"); // 컨트롤러
const createContact = require("../controllers/contactController"); // 컨트롤러

router
  .route("/")
  .get(getAllContacts) // 컨트롤러 함수를 찾아서 확인
  .post(createContact);

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
