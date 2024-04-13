<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>IslandScape</title>
<link href="${pageContext.request.contextPath}/resources/css/popstyle.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/resources/js/httpRequest.js"></script>
<script type="text/javascript">
function MM_callJS(jsStr) { //v2.0
  return eval(jsStr)
}

function check(f) {
	m_id = f.id.value;
	m_email = f.email.value;
	
	if(m_id == ""){
		alert('아이디를 입력해주세요');
		return;
	}
	if(m_email == ""){
		alert('이메일를 입력해주세요');
		return;
	}
	
	var url = "searchPW_action.do";
	var param = "m_id=" + encodeURIComponent(m_id) + "&m_email=" + encodeURIComponent(m_email) ;
	
	sendRequest(url, param, resultFn, "POST");
}

function resultFn() {
	if (xhr.readyState == 4 && xhr.status == 200) {
		
		var data = xhr.responseText;
		
		var json = eval(data);
		
		
		if( json[0].result == 0 ){
			alert("일치하는 회원정보를 가져오지 못했습니다");
			return;
		}
		
		alert('회원님의 비밀번호는 : ' + json[0].m_pwd);
		
		
		MM_callJS('window.close();');
	}
}
</script>
</head>

<body>
<form id="ljiForm">

<div class="popupimg2">
  <div class="logo"><img src="${pageContext.request.contextPath}/resources/image/landscape.png" width="169" height="53" alt=""/>비밀번호찾기</div>
	
<div id="form">
<center>

      <table width="401" height="130" >
                <thead>
                                     
                    <tr>
                      <th width="89">아이디</th>
                        <td width="192" class="sub">
                        <input type="text" id="id">
                        </td>
                </tr>
                    <tr>
                        <th>이메일</th>
                        <td width="192" class="sub">
                        <input type="text" id="email">
                        </td>
                    </tr>
                     
                </thead>
      </table>
    </center>	
</div>
<div id="search"><span class="sub">
  <input type="image" src="${pageContext.request.contextPath}/resources/image/logOK.png" alt="확인" onClick="check(this.form);" >
  <img src="${pageContext.request.contextPath}/resources/image/cancel.png" alt="닫기" onClick="MM_callJS('window.close();')">
  </span>
    

  </div>
</div>

  </form>

</body>
</html>
