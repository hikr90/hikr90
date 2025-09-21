// 서버 연결을 받아주는 변수 xhr 생성
var xhr = null;

// XMLHttpRequest객체 생성 함수
function createRequest(){
	/*	HttpRequest.js
			- 서버 연결을 위한 참조 파일
			- Ajax 작업은 XMLHttpRequest객체를 생성하는 것으로 동작한다.
		
			# XMLHttpRequest의 기능
				- open : get방식의 경우 서버로 요청을 보내는 메소드
				- send : post방식의 경우 서버로 요청을 보내는 메소드 
				- onReadyStateChange : 작업이 완료된 후 콜백 메소드
		
			# HttpRequest.js 동작 순서
				- xhr (XMLHttpRequest) 객체 생성
				- 요청과 응답을 처리할 sendRequest메소드 생성
					- 전송타입, 파라미터 타입, 접근 url 지정
				- open, send등의 기능을 통해서 서버와 클라이언트간의 연결 요청
				- 작업이 완료된 후 호출할 콜백 함수 생성 
			
			# activeXObject
				- 자바스크립트를 사용하여 서버로 정보를 보내는 클래스 객체
				- activeXObject는 브라우저에서 XMLHttp라고 불리는데 
				- 이 객체를 통해서 Mozzlia, Safari등의 다른 브라우저에서 activeX객체의 메소드나 속성을 지원할 수 있게 된다.
	 */

	// xhr 객체가 비어있는 경우 리턴
	if(xhr!=null)return;
	
	/*	WINDOW.ACTIVEXOBJECT	
			- 브라우저가 액티브X를 지원하는지 여부를 반환하는 메소드
			- 액티브X를 지원하는 브라우저로는 IE5, IE6등이 해당되며
			- 액티브X를 지원하지 않는 브라우저로는 IE7+, CHROME, FILEFOX, OPERA등이 있다.
	*/
	if(window.ActiveXObject)
		xhr = new ActiveXObject("Microsoft.XMLHTTP");
	else
		xhr = new XMLHttpRequest();
}

// 통신 요청을 받는 sendRequest
function sendRequest(url, param, callBack, method){
	// Http의 Request(요청) 생성
	createRequest();
	
	// 옵션 지정
	var httpMethod = (method!='POST' && method!='post')?'GET':'POST'; // 전송타입 지정
	var httpParam = (param==null || param == '')?null:param; // 파라미터 지정
	var httpURL = url; // 접근 URL 지정

	/*	get 방식 전송
			- get방식인 경우, 접근 url의 방식을 url?변수1=값1&변수2=값2 의 형태로 작성한다.
	*/
	if(httpMethod == 'GET' && httpParam != null)
		httpURL = httpURL+"?"+httpParam;
	
	/*	open 메소드
	 		- get방식에서 사용
	 		- 요청방식, 접근url, 비동기 여부 (true:비동기) 의 파라미터를 사용한다.
	 		- 세가지의 파라미터를 통해서 서버로의 요청
	*/
	xhr.open(httpMethod, httpURL, true);

	/*	setRequestHeader
	  		- 요청에 mime-type을 지정
	  		
	  		# content-type
	  			(1) application/x-www-form-urlencoded
	  				- 서버로 전송 시 모든 문자 인코딩
	  				- url?변수1=값1&변수2=값2의 형태로 데이터 전송
	  				
	  			(2) application/json
	  				- Restful api 사용 시 인코딩
	  				- {key : value}의 형태로 전송
	  				
	  			(3) text/plain
	  				- 공백문자 (Space)를 +로 인코딩
	  			
	  			(4) multipart/form-data
	  				- 서버로 전송 시 모든 문자를 인코딩 하지 않는다.
	  				- 파일 전송 시 사용
	  				- 해당 속성은 반드시 post타입으로 동작해야한다.
	*/
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

	// 콜백 메소드 지정
	xhr.onreadystatechange = callBack;
	
	/*	send 메소드
	 		- post방식에서 사용
	 		- httpParam 변수를 파라미터로 전송한다.
	*/
	xhr.send(httpMethod == 'POST'?httpParam:null);
}