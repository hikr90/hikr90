// fs 모듈의 readdir 함수 연습하기 ( 결과 비교 파일 : 03\results\list-2.js)

/* readdir
    - 디렉토리를 가져오는 함수
    - 경로, 콜백함수 (에러, 파일)를 매개변수로 받는다.
*/
const fs = require("fs"); // fs는 노드 코어 모듈의 파일 시스템을 뜻한다.

fs.readdir("./", (err, files) => {
  // 에러가 발생할 경우, 에러 메세지를 표시
  // 정상인 경우 콘솔 출력
  if (err) {
    console.log(err);
  }
  console.log(files); // 현재 경로(list-1.js가 있는 경로, 즉 03파일 경로) 의 파일을 출력
});
