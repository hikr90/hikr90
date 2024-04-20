// 서버 연결을 받아주는 변수 XHR 생성
var xhr = null;

// XMLHTTPREQUEST 객체 생성 함수
function createRequest(){

/*	HTTPREQEUST.JS
 		
 		AJAX 작업은 XMLHTTPREQUEST 객체를 생성하는 것으로 동작한다.
 		XMLHTTPREQUEST객체는 아래의 기능을 가지고있다.
 		
 		- Open (GET방식의 경우 서버로 연결 요청하는 메소드)
 		- Onreadystatechange (작업이 완료된 후 콜백 메소드)
 		- Send (POST방식의 경우 서버로 연결 요청하는 메소드)
 		
 		HTTPREQUEST.JS의 동작 순서
 		1 XMLHTTPREQUEST 객체(XHR) 생성
 		2 요청과 응답을 처리할 SENDREQUEST 메소드 생성
 			2-1 전송타입 지정 
 			2-2 파라미터 타입 지정
 			2-3 접근 URL 지정
 		3 OPEN 메소드를 통하여 서버와 클라이언트간의 연결 요청 (GET경우, POST의 경우는 SEND로 요청한다.)
 		4  작업이 완료된 후 호출할 CALLBACK 메서드 생성
 		
 				
 		ACTIVEXOJBECT
 			JAVASCRIPT를 사용하여 서버로 정보를 보내는 클래스 객체이다.
 			ACTIVEXOBJECT는 익스플로어에서 XMLHTTP라고 불리는데 이 클래스를 통해서 
 			MOZZLIA, SAFARI등의 다른 브라우저에서 MICROSOFT의 ACTIVEX객체의 메소드나 속성(PROPERTY)를 지원할 수 있게 된다.
*/
	
	// XHR 객체가 비어있지 않은 경우는 AJAX를 동작하도록 리턴
	if(xhr!=null)return;
	
	// WINDOW.ACTIVEXOBJECT는 ActiveXObject를 지원하는 브라우저라면 OBJECT를 리턴(TRUE)하고
	// 그렇지 않다면 NULL(FALSE)을 리턴한다.
	if(window.ActiveXObject)
		// ACTIVEXOBJECT를 지원하는 브라우저 (IE5, IE6등의 브라우저)
		xhr = new ActiveXObject("Microsoft.XMLHTTP");
	else
		// 지원하지 않는 브라우저 (IE7+, 크롬, 파이어폭스, 오페라등의 브라우저)
		xhr = new XMLHttpRequest();
}

// 통신 요청을 받는 SENDREQUEST 메소드 생성
function sendRequest(url, param, callBack, method){
	// HTTP의 REQUEST(요청) 생성
	createRequest();

	// 전송타입 지정
	var httpMethod = 
	(method!='POST' && method!='post')?'GET':'POST';
	
	// GET 방식
	// 파라미터 지정
	var httpParam = 
	(param==null || param == '')?null:param;
	
	// 접근 URL 지정
	var httpURL = url;
	
	// 요청 방식이 GET방식이고, 전달할 파라미터 값이 있다면 HTTPURL이라는 경로를 생성한다.
	// POST는 노출 방식이 아니므로 따로 작성하지 않는다.
	// (.../TEST.JSP?CH=123)의 방식
	if(httpMethod == 'GET' && httpParam != null)
		httpURL = httpURL+"?"+httpParam;
	
    // OPEN(요청방식, 접근URL, 비동기(TRUE:비동기))의 메소드로  서버 연결 요청
	xhr.open(httpMethod, httpURL, true);
	
	// POST 방식
	// 	SETREQUESTHEADER메소드에 콘텐츠 타입이 FORM-URLENCODED임을 지정해야한다.
	// 	요청(REQUEST)에 MINE TYPE을 설정
	//	예를 들자면 SEND()를 호출 하기 전에 아래와 같은 형태로 SEND()로 보낼 쿼리를 이용해야 한다.
	xhr.setRequestHeader("Content-Type",
	  "application/x-www-form-urlencoded");

	//작업이 완료된 후 호출될 콜백 메소드 지정
	xhr.onreadystatechange = callBack;
	
	// HTTP에 요청을 실제로 실행하는 메소드
	// 	DATA는 POST로 보낼 데이터를 뜻합니다.
	xhr.send(httpMethod == 'POST'?httpParam:null);
	
}













