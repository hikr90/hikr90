/*  # 스키마
      - 데이터베이스에서 저장되는 자료 형태를 정하는 것
      - 애플리케이션 코드와 별도의 파일로 작성한다. (코드의 재사용성이 높음)
      - 모듈로 내보내기위해서 스키마 >> 모델로 변환하여 DB에 저장한다.

    # 도큐먼트
      - 스키마에서 정의한 구조를 사용한 자료

    # 컬렉션
      - 여러개의 도큐먼트로 묶은 단위 (폴더)를 뜻한다.

    [참고]  스키마 > 도큐먼트 > 컬렉션 
*/
const mongoose = require("mongoose");

// 스키마 인스턴스 객체 생성
const contactSchema = new mongoose.Schema(
  {
    name: {
      type: String, // 타입
      required: true, // 필수 값 여부
    },
    email: { type: String },
    phone: { type: String, required: [true, "전화번호는 꼭 기입해주세요."] },
  },
  {
    // 자료가 작성되거나 수정되는 경우 자동으로 그 시간을 기록해주는 속성
    timestamps: true,
  }
);

// 모델로 변환 (모델명, 스키마명)
mongoose.model("Contact", contactSchema);

/*  1. 애플리케이션
        - 특정 기능을 제공하는 프로그램, 그 자체로 완전한 소프트웨어
        - 사용자 인터페이스, 상호작용 기능 등이 포함된다.
        - SNS 애플리케이션

    2. API
        - 애플리케이션 간에 자료를 주고받으면서 특정 기능 실행하는 인터페이스
        - API를 통해서 타 시스템 간 통신하며 자료를 주고받거나, 새로운 애플리케이션을 생성하기도 한다.
        - 예) SNS 애플리케이션에서 사용하는 로그인 API, 게시물 작성 API 등
    
    3. REST
        - HTTP 프로토콜을 활용하여 자료를 주고받기 위해 약속된 구조
        - Representational state transfer 의 약자로 데이터의 현재 상태를 볼 수 있는 전송을 뜻한다.
        - 예) 온라인 쇼핑몰에서 장바구니에 어떤 상품을 담았는지 데이터 제공

    4. RESTful API (REST API)
        - REST 형식을 지켜서 생성한 API
        - URI 형태로 요청한다.
        
        4.1 URI 작성 요령
            (1) 자원명은 명사형으로 알파벳 소문자 사용
            (2) 자원명에 2개 이상의 단어를 사용할 경우, - 혹은 카멜 표기법으로 처리
            (3) 자원 간에 계층이 있는 경우 / 로 구분하되, URI 끝에는 /를 붙이지 않음
            (4) get 등의 자원 처리 방법은 URI에 포함하지 않음

        4.2 요청방식과 역할
            (1) POST (CREATE) : 등록
            (2) GET (READ) : 조회
            (3) PUT (UPDATE) : 수정
            (4) DELETE (DELETE) : 삭제
*/
