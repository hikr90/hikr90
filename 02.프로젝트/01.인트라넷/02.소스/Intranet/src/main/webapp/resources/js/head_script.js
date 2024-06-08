$(document).ready(function(){
	/* 명칭 : 메뉴 동적 메소드
	 * 작성자 : 김태현
	 * 내용 : 메뉴 동적 메소드
	 */
	$('header #_nav .li_1').on('mouseenter focusin', function () {        
		//
	    $(this).addClass('_open').siblings('.li_1').removeClass('_open');
	});
	
	//
	$('header').on('mouseleave focusout', function () {
		//
	});
});

/* 명칭 : formSubmit
 * 작성자 : 김태현
 * 내용 : 폼 태그 동작
 */ 
function formSubmit(mappingId){
	//
	var f = document.getElementById('form');
	f.action = mappingId;
	f.submit();
}

/* 명칭 : setContentIdx
 * 작성자 : 김태현
 * 내용 : 목록 선택 시 인덱스값 부여
 */ 
function setContentIdx(contentIdx, mappingId){
	//
	$("#contentIdx").val(contentIdx);
	formSubmit(mappingId);
}

/* 명칭 : logout
 * 작성자 : 김태현
 * 내용 : 로그아웃
 */
function logout() {
	//
	alert("로그아웃 되었습니다.");
	location.href = "intrLoginProc1030.do";
}

/* 명칭 : pushListKey
 * 작성자 : 김태현
 * 내용 : 엔터 입력 (조회)
 */
function pushListKey(f) {
	//
	if(event.keyCode==13){
		listCall(f);
	}
}

/* 명칭 : pushLoginKey
 * 작성자 : 김태현
 * 내용 : 엔터 입력 (로그인)
 */
function pushLoginKey(f) {
	//
	if(event.keyCode==13){
		loginCall(f);
	}
}


/* 명칭 : delArea
 * 작성자 : 김태현
 * 내용 : 영역 제거
 */
function delArea(area) {
	//
	$("#"+area).html("");
}


/* 명칭 : inputNum
 * 작성자 : 김태현
 * 내용 : 연락처 자동 입력 함수
 */
function inputNum(inputNum) {
	// 입력창에 입력된 값
    var input = inputNum.value.replace(/[^0-9]/g, ''); // 숫자가 아닌 값
    var output = "";
    var pattern = /[0-9]/g;
    
	// 함수에따라서 입력창에서 처리할 값
    if(input.length < 4) {
        //
    	if(!pattern.test(input)){
    		inputNum.value = "";
    	} else {
    		//
        	return input;
    	}
    } else if(input.length < 7) {
        //
    	output += input.substr(0, 3);
    	output += "-";
    	output += input.substr(3);
    } else if(input.length < 11) {
    	//
    	output += input.substr(0, 3);
    	output += "-";
    	output += input.substr(3, 3);
    	output += "-";
    	output += input.substr(6);
    } else {
    	//
    	output += input.substr(0, 3);
    	output += "-";
    	output += input.substr(3, 4);
    	output += "-";
    	output += input.substr(7);
    }
    // 값 지정
    inputNum.value = output;
}


/* 명칭 : initData
 * 작성자 : 김태현
 * 내용 : 데이터 초기화
 */
function initData(area){
	//
	var textInput = $("#"+area+" input[type=text]");
	
	// 값 초기화
	$.each(textInput, function(idx, input){
		$(input).val("");		
	});
}


/* 명칭 : validation
 * 작성자 : 김태현
 * 내용 : input 태그 (text, password) 유효성 검증 (공통)
 */
function validation(){
	// 유효성 검사
	var chkYn		= true; 
	// INPUT
	$("#"+"form"+" input").each(function(idx, tag){
		//
		var type = $(this).attr('type');
		var id = $(this).attr('id');
		//
		if((type=="text" || type=="password") && !id.includes('srch') && !id.includes('uppr')){
			//
			if($(tag).val()=="" || $(tag).val()==null){
				//
				alert($(tag).attr("title")+"(을)를 입력해주세요.");
				chkYn = false;
				return false;
			}
		}
	});
	
	// TEXTAREA
	if(chkYn!=false){
		$("#"+"form"+" textarea").each(function(idx, tag){
			//
			var id = $(tag).attr('id');
			if(id!='remark'){
				//
				if($(tag).val().length==0){
					//
					alert($(tag).attr("title")+"(을)를 입력해주세요.");
					chkYn = false;
					return false;
				}
			}
		});
	}
	//
	return chkYn;
}


/* 명칭 : srchAddr
 * 작성자 : 김태현
 * 내용 : 주소 조회 (API)
 */
function srchAddr() {
	new daum.Postcode({
        oncomplete: function(data) {
            // 주소 선택 후 동작
            var data = data.address;
            $("#empAddr").val(data); 
        }
    }).open();
}
