// 로그아웃
function logout() {

	var url = "piptLoginProc1030.do";

	sendRequest(url, null, logoutReturn, "GET");

}

function logoutReturn() {
	if (xhr.readyState == 4 && xhr.status == 200) {
		var data = xhr.responseText;
		var json = eval(data);

		if (json[0].result == 'yes') {
			alert("로그아웃 성공");
		} else {
			alert("로그아웃 실패");
		}
		//
		location.href = "piptMainInqy1010.do";
	}
}
