// path 모듈 연습하기 ( 결과 비교 파일 : 03\results\path.js)
const path = require("path");

/* join
    - 파라미터를 합쳐서 경로를 생성하는 함수
*/
const fullPath = path.join("some", "work", "ex.txt");
console.log(fullPath);

/* dirname
    - 경로만 추출하는 함수
*/
const dir = path.dirname(fullPath);
console.log(dir);

/* basename
    - 해당 함수는 두가지 역할을 수행한다.
    - 하나는 파일명만 추출하는 함수이고
    - 
*/
const fn1 = path.basename(__filename); // 현재 파일이 있는 경로 + 파일명 값 중에서 파일명만 추출
console.log(`전체 경로 : ${__filename}`);
console.log(`파일명 : ${fn1}`);

/* 
    - 확장자를 제거한 파일명을 가지고온다.
*/
const fn2 = path.basename(__filename, ".js");
console.log(`확장자를 제외한 파일명 : ${fn2}`);
