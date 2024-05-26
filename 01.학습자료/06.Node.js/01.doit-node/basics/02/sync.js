// 순서대로 실행하기  (결과 비교: 02\results\sync.js)
function displayA() {
  console.log("A");
}

/*  자바스크립트의 함수 처리 순서
        - 시간이 드는 작업 (setTimeout등) 이 있는 경우, 자바스크립트는 시간이 짧게 걸리는 작업을 선 처리하고
        - 그 뒤 시간이 드는 작업을 진행한다.
        - 자바스크립트는 스레드가 1개로 동시 작업이 안되기 때문이다.
*/
function displayB(callback) {
  setTimeout(() => {
    console.log("B");
    callback();
  }, 2000);
}

/*  콜백함수
        - 함수 내 또 다른 함수를 매개변수로 넘겨서 실행 순서를 제어한다.
        - 남용하는 경우 가독성이 떨어진다.
*/
function displayC() {
  console.log("C");
}

displayA();
displayB(displayC); // 콜백 함수를 통해서 B가 2초가 걸린 후에 실행
