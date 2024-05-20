var xhr = null;

// 요청 생성
function createRequest(){
	//
	if(xhr!=null)return;
	if(window.ActiveXObject)
		xhr = new ActiveXObject("Microsoft.XMLHTTP");
	else
		xhr = new XMLHttpRequest();
}

// 요청 전송
function sendRequest(url, param, callBack, method){
	// 요청 생성
	createRequest();

	// 전송타입 구분
	var httpMethod = (method!='POST' && method!='post')?'GET':'POST';
	
	// 파라미터 구분
	var httpParam = (param==null || param == '')?null:param;
	
	// 접근 url
	var httpURL = url;
	
	if(httpMethod == 'GET' && httpParam != null)
		httpURL = httpURL+"?"+httpParam;
	
	xhr.open(httpMethod, httpURL, true);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.onreadystatechange = callBack;
	xhr.send(httpMethod == 'POST'?httpParam:null);
}