//
/* require
    - 모듈을 가져오는 함수
    - 함수 내 파라미터는 해당 js의 경로와 파일명을 기입한다.
*/

// 같은 경로 내 user.js 의 모듈에서 user변수를 가져온다.
const user = require("./user"); // module.exports = user;
const hello = require("./hello"); // module.exports = hello;

// user 에서 변수명을 지정
// hello 에서 user명을 가지고 hello 함수 동작
hello(user);
