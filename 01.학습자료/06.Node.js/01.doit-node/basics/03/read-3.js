// fs 모듈의 readFile 함수 연습하기 (결과 비교 파일은 03\results\read-3.js)

/* readFile
    - 파일을 읽어오는 함수
    - 파일, 콜백함수 (에러, 파일) 을 파라미터로 받는다.
    - 인코딩 지정을 위해서 콜백 함수 앞에 인코딩 타입을 지정한다.
*/

/* writeFile
    - 파일에 내용을 저장하여 생성하는 함수
    - 파일, 내용을 파라미터로 받는다.
*/

const fs = require("fs");

fs.readFile("./example.txt", "utf-8", (err, data) => {
  // 파일을 읽어온 뒤, 에러 발생 시 에러를 출력
  // 정상적으로 읽어왔다면 파일 내용을 출력
  if (err) {
    console.log(err);
  }
  console.log(data);
  fs.writeFile("./test.txt", data, (err) => {
    if (err) {
      console.log(err);
    }
    console.log("test.txt is saved.");
  });
});
