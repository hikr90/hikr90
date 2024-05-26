// 아래 함수 표현식을 화살표 함수로 바꾸기  (결과 비교 : 02\results\arrow-1.js)

// 함수 표현식
// let hi = function() {
//   return '안녕하세요?';
// };

// 화살표 함수
let hi = () => {
  return "안녕하세요?"; // 한 라인만 있는 경우 return 과 {} 괄호도 생략 가능하다.
};

console.log(hi());
