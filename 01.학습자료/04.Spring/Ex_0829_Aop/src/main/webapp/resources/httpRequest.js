// 서버 연결을 받아주는 변수 XHR 생성
var xhr = null;

// XMLHTTPREQUEST 객체 생성 함수
function createRequest(){
	/*	HTTPREQEUST.JS
			- 서버 연결을 위한 참조 파일
			- AJAX 작업은 XMLHTTPREQUEST객체를 생성하는 것으로 동작한다.
		
			# XMLHTTPREQUEST의 기능
				- OPEN : GET방식의 경우 서버로 요청을 보내는 메소드
				- SEND : POST방식의 경우 서버로 요청을 보내는 메소드 
				- ONREADYSTATECHAGE : 작업이 완료된 후 콜백 메소드
		
			# HTTPREQUEST.JS 동작 순서
				- XHR (XMLHTTPREQUEST) 객체 생성
				- 요청과 응답을 처리할 SENDREQUEST메소드 생성
					- 전송타입 / 파라미터 타입 / 접근 URL 지정
				- OPEN/SEND등의 기능을 통해서 서버와 클라이언트간의 연결 요청
				- 작업이 완료된 후 호출할 콜백 함수 생성 
			
			# ACTIVEXOBJECT
				- 자바스크립트를 사용하여 서버로 정보를 보내는 클래스 객체
				- ACTIVEXOBJECT는 브라우저에서 XMLHTTP라고 불리는데 
				- 이 객체를 통해서 MOZZLIA, SAFARI등의 다른 브라우저에서 MICROSOFT의 ACTIVEX객체의 메소드나 속성을 지원할 수 있게 된다.
	 */

	// XHR 객체가 비어있는 경우 리턴
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

// 통신 요청을 받는 SENDREQUEST
function sendRequest(url, param, callBack, method){
	// HTTP의 REQUEST(요청) 생성
	createRequest();
	
	// 옵션 지정
	var httpMethod = (method!='POST' && method!='post')?'GET':'POST'; // 전송타입 지정
	var httpParam = (param==null || param == '')?null:param; // 파라미터 지정
	var httpURL = url; // 접근 URL 지정

	/*	GET 방식 전송
			- GET방식인 경우, 접근 URL의 방식을 URL?변수1=값1&변수2=값2 의 형태로 작성한다.
	*/
	if(httpMethod == 'GET' && httpParam != null)
		httpURL = httpURL+"?"+httpParam;
	
	/*	OPEN 메소드
	 		- GET방식에서 사용
	 		- 요청방식, 접근URL, 비동기 여부 (TRUE:비동기) 의 파라미터를 사용한다.
	 		- 세가지의 파라미터를 통해서 서버로의 요청
	*/
	xhr.open(httpMethod, httpURL, true);

	/*	SETREQUESTHEADER
	  		- 요청에 MIME-TYPE을 지정
	  		
	  		# CONTENT-TYPE
	  			## APPLICATION/X-WWW-FORM-URLENCODED
	  				- 서버로 전송 시 모든 문자 인코딩
	  				- ?변수1=값1&변수2=값2의 형태로 데이터 전송
	  				
	  			## APPLICATION/JSON
	  				- RESTFUL API 사용 시 인코딩
	  				- {KEY : VALUE}의 형태로 전송
	  				
	  			## TEXT/PLAIN
	  				- 공백문자 (SPACE)를 +로 인코딩
	  			
	  			## MULTIPART/FORM-DATA
	  				- 서버로 전송 시 모든 문자를 인코딩 하지 않는다.
	  				- 파일 전송 시 사용
	  				- 해당 속성은 반드시 POST타입으로 동작해야한다.
	*/
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

	// 콜백 메소드 지정
	xhr.onreadystatechange = callBack;
	
	/*	SEND 메소드
	 		- POST방식에서 사용
	 		- HTTPPARAM 변수를 파라미터로 전송한다.
	*/
	xhr.send(httpMethod == 'POST'?httpParam:null);
}