<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta content="text/html; charset=utf-8">
<title>IslandScape</title>
<link href="${pageContext.request.contextPath}/resources/css/popstyle.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/resources/js/httpRequest.js"></script>
<script type="text/javascript">
function MM_callJS(jsStr) { //v2.0
  return eval(jsStr)
}

function check(f) {
	m_name = f.m_name.value;
	m_phone = f.tel.value;
	
	if(m_name == ""){
		alert('이름을 입력해주세요');
		return;
	}
	if(m_phone == ""){
		alert('전화번호를 입력해주세요');
		return;
	}
	
	var url = "piptLoginProc1040.do";
	var param = "m_name=" + encodeURIComponent(m_name) + "&m_phone=" + encodeURIComponent(m_phone) ;
	
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
		
		alert('회원님의 아이디는 : ' + json[0].m_id);
		
		
		MM_callJS('window.close();');
	}
}
</script>
</head>

<body>
<form id="ljiForm" action="#">
<div class="popupimg2">
  <div class="logo"><img src="${pageContext.request.contextPath}/resources/image/landscape.png" width="169" height="53" alt=""/>아이디찾기</div>
	
<div id="form">

<center>

      <table width="401" height="130" >
                <thead>
                                     
                    <tr>
                      <th width="89">이름</th>
                        <td width="192" class="sub">
                        <input type="text" name="m_name" id="id">
                        </td>
                      
                </tr>
                    <tr>
                        <th>전화번호</th>
                        <td width="192" class="sub">
                        <input type="text" id="phone" name="tel">
                        </td>
                    </tr>
                     
                </thead>
      </table>
    </center>	
  

</div>
<div id="search"><span class="sub">
  <input type="image" src="${pageContext.request.contextPath}/resources/image/logOK.png" alt="확인" onClick="check(this.form);">
  <img src="${pageContext.request.contextPath}/resources/image/cancel.png" alt="닫기" onClick="MM_callJS('window.close();')">
  </span>
    

  </div>
</div>
</form>

</body>
</html>
