/* 패키지 관리
    - 모듈 : 기능 단위의 파일
    - 라이브러리 : 여러개의 모듈로 구성된 큰 단위의 기능
        (모듈과 라이브러리를 묶어서 모듈이라고 표현하기도 한다.)
    - 패키지 : 배포가 가능한 여러 모듈과 관련 파일들을 묶어놓은 것으로 외부 사용자들이 다운로드하여 사용할 수 있다.
  
  NPM
    - Node Package Manager, 라이브러리외에 프레임워크, 플러그인 등 패키지를 다운로드하여 사용할 수 있게 하는 도구
    - Node.js 설치 시 npm도 같이 설치된다.
    - npmjs.com에서 패키지를 검색하고 설치할 수 있다.

      패키지 초기화 
        - 부모 경로로 이동한 뒤 npm init 입력
      
      패키지 설치
        - npm i ansi-colors
        - npm install ansi-colors

      패키지 삭제
        - npm uninstall ansi-colors
*/
function hello(name) {
  console.log(name + " 님, 안녕하세요?");
}

hello("홍길동");
