/* 모듈
    CommonJS 모듈 시스템
        - Node.js의 기본 모듈 시스템 (reqiure, module.exports)
    
    ES모듈 시스템
        - ECMAScript의 표준 모듈 시스템, Node.js에서 지원하고 있다. (import, export)
 */
const user = "홍길동";

const hello = (name) => {
  console.log(`${name} 님, 안녕하세요?`);
};

hello(user);
