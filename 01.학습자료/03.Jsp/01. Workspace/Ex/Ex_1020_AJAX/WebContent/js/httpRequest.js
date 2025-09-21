// 서버 연결을 받아주는 xhr 생성
var xhr = null;

// 요청 객체 생성
function createRequest(){
	/*	httpRequest.js
			- open : get방식인 경우 서버로 연결을 요청하는 메소드
			- send : post방식인 경우 서버로 연결을 요청하는 메소드
			- onReadyStateChange : 작업이 완료된 후 콜백 메소드
	
			HttpRequest.js의 동작 순서
				(1) xmlHttpRequest 객체 xhr 생성
				(2) 요청과 응답을 처리할 sendRequest 메소드 생성
					(2.1) 전송타입 지정
					(2.2) 파라미터 타입 지정
					(2.3) 접근 url 지정
				(3) open 혹은 send 메소드를 통해서 서버와 클라이언트 간 연결 요청
				(4) 작업이 완료된 후 콜백 메소드 생성
				
		activeObject
			- 자바스크립트를 사용하여 정보를 서버로 보내는 클래스
			- 익스플로어에서는 xmlHttp라고 부르는데 이 클래스를 통해서 mozzlia, safari등의 다른 브라우저에서 마이크로소프트의 activeX 메소드나 속성을 지원할 수 있다. 				
	*/
	
	// xhr객체가 없는 경우 동작 중지
	if(xhr!=null)return;
	
	
	/* window.activeXObject
		- activeXObject를 지원하는 브라우저인지 여부를 반환한다.
		- 지원하는 경우 true, 아닌 경우 false를 리턴한다.
	*/
	if(window.ActiveXObject)
		// IE5, IE6등의 브라우저
		xhr = new ActiveXObject("Microsoft.XMLHTTP");
	else
		// IE7+, fireFox, opera등의 브라우저
		xhr = new XMLHttpRequest();
}

// 콜백 메소드
function sendRequest(url, param, callBack, method){
	// http의 요청 생성
	createRequest();

	// 전송타입 지정
	var httpMethod = (method!='POST' && method!='post')?'GET':'POST';
	
	// 파라미터 지정 (get방식)
	var httpParam = (param==null || param == '')?null:param;
	
	// 접근 url 지정
	var httpURL = url;
	
	// 요청 방식이 get방식에 전송하는 파라미터가 있을 경우
	if(httpMethod == 'GET' && httpParam != null)
		httpURL = httpURL+"?"+httpParam;
	
	// open 메소드
	// 	- (요청방식, 접근 url, 비동기여부)의 메소드로 서버 연결 요청
	xhr.open(httpMethod, httpURL, true);			// 비동기 요청
	
	// 컨텐츠 타입 지정
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

	// 콜백 메소드 지정
	xhr.onreadystatechange = callBack;
	
	// post방식으로 전송 	
	xhr.send(httpMethod == 'POST'?httpParam:null);
}
