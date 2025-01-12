$(function(){
	// -- 셀렉트 박스 -----------------------------------------------------------------------
	// 전체 선택
	$("body").on("click", ".sList", function (e) {
		//
		var targetUl = $("#" + e.target.id).siblings('ul');
		//		
		if($(targetUl).css("display") != "block") {
			$(targetUl).css('display','block');
		} else {
			$(targetUl).css('display','none');
		}
	});

	// 항목 선택
	$(".sUl li").on("click", function () {
	    var setNm = $(this).attr("setNm");
	    var setCd = $(this).attr("setCd");

		// 값 지정
		$(this).closest('div').find('div').text(setNm);
		$(this).closest('div').find('input').val(setCd);
		$(this).closest('div').find('input').next().val(setNm);

		// 목록 닫기
		$(".sUl").css("display","none");
	});
	
	// 외부 선택
	$("body").on("click", function(e){
	    if($(".select_wrap").has(e.target).length == 0) $(".sUl").css('display','none');
	});
	
	// Hover 이벤트
	$(".sUl li").hover(function(){
		$(".sUl li").removeClass("hover");
		$(this).addClass("hover");
	});
	
	// -- 전체 선택 -----------------------------------------------------------------------
	$(".everyChk").on("click", function(e){
		if($(this).is(":checked")) {
			$("input[name=checkBox]").prop("checked", true);
		} else {
			$("input[name=checkBox ]").prop("checked", false)
		}
	});
});

// 검색 초기화
function initCall(){
	$("#gradeList").text("전체");
	$("#deptList").text("전체");
	$("input[name=srchNm]").val("");
	$("input[name=srchSdt]").val("");
	$("input[name=srchEdt]").val("");
	$("input[name=deptCd]").val("");
	$("input[name=gradeCd]").val("");
	$("input[name=deptNm]").val("");
	$("input[name=gradeNm]").val("");
}

// 폼 태그 동작
function formSubmit(mappingId){
	//
	var f = document.getElementById('form');
	f.action = mappingId;
	f.submit();
}

// 로그아웃
function logout() {
	//
	alert("로그아웃 되었습니다.");
	location.href = "intrMainProc1020.do";
}

// 목록 조회 (엔터)
function pushListKey(f) {
	//
	if(event.keyCode==13){
		listCall(f);
	}
}

// 로그인 (엔터)
function pushLoginKey(f) {
	//
	if(event.keyCode==13){
		loginCall(f);
	}
}

// 영역 제거
function delArea(area) {
	//
	$("#"+area).html("");
}

// 연락처 자동 입력
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

// 입력 값 초기화
function initData(area){
	//
	var textInput = $("#"+area+" input[type=text]");
	
	// 값 초기화
	$.each(textInput, function(idx, input){
		$(input).val("");		
	});
}



// 입력 값 유효성 검증 (공통)
function validation(){
	// 유효성 검사
	var chkYn		= true; 
	
	// Input
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
	
	// TextArea
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

// 주소 조회 (api) 
function srchAddr() {
	new daum.Postcode({
        oncomplete: function(data) {
            // 주소 선택 후 동작
            var data = data.address;
            $("#empAddr").val(data); 
        }
    }).open();
}
