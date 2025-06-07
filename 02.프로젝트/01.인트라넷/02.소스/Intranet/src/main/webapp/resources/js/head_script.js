$(function(){
	// -- 셀렉트 박스 -----------------------------------------------------------------------
	// 전체 선택
	$("body").on("click", ".sList", function (e) {
		//
		var targetUl = $("#" + e.target.id).siblings('ul');
		//		
		if($(targetUl).css("display") === "none") {
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
	
	// hover 이벤트
	$(".sUl li").hover(function(){
		$(this).addClass("hover").siblings().removeClass("hover");
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
	// 검색어
	$("input[name=srchNm]").val("");
	
	// 검색일자
	$("input[name=srchSdt]").val("");
	$("input[name=srchEdt]").val("");

	// 부서, 직급
	$("input[name=orgNm]").val("");
	$("input[name=rankNm]").val("");

	// 사용여부
	$("input[name=useNm]").val("전체");
	$("input[name=useCd]").val("");
	
	// 진행단계
	$("input[name=statNm]").val("전체");
	$("input[name=statCd]").val("");
}

// 폼 태그 동작
function formSubmit(mappingId){
	//
	var f = document.getElementById('form');
	f.action = mappingId;
	f.submit();
}

// 로그아웃
function outProc() {
	alert("로그아웃 되었습니다.");
	location.href = "intrMainProc1020.do";
}

// 목록 조회 (엔터)
function pushCall(f) {
	if(event.keyCode==13){
		listCall(f);
	}
}

// 로그인 (엔터)
function pushLogCall(f) {
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
function mobProc(num) {
	// 입력창에 입력된 값
    var input = num.value.replace(/[^0-9]/g, ''); // 숫자가 아닌 값
    var output = "";
    var pattern = /[0-9]/g;
    
	// 함수에따라서 입력창에서 처리할 값
    if(input.length < 4) {
        //
    	if(!pattern.test(input)){
    		num.value = "";
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
    num.value = output;
}

// 입력 값 유효성 검증 (공통)
function valProc(){
	// 유효성 검사
	var chkYn		= true; 
	
	// input
	$("#"+"form"+" input").each(function(idx, tag){
		//
		var type = $(this).attr('type');
		var id = $(this).attr('id');
		//
		if((type=="text" || type=="password")) {
			if(!id.includes('srch') && !id.includes('none')){
				if($(tag).val()=="" || $(tag).val()==null){
					//
					alert($(tag).attr("title")+"(을)를 입력해주세요.");
					chkYn = false;
					return false;
				}
			}
		}
	});
	
	// textarea
	if(chkYn!=false){
		$("#"+"form"+" textarea").each(function(idx, tag){
			//
			var id = $(tag).attr('id');
			//
			if(id!='remark'){
				if($(tag).val().length==0){
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
function addrProc() {
	new daum.Postcode({
        oncomplete: function(data) {
            // 주소 선택 후 동작
            var data = data.address;
            $("#addr").val(data); 
        }
    }).open();
}

// 금액 입력
function amtProc(tag){
	// 통화 처리
	var value = tag.value.replace(/[^0-9]/g, ""); 				// 숫자만 남김
  	var format = Number(value).toLocaleString("ko-KR"); 	// 쉼표 추가
  	tag.value = value ? `₩${format}` : "";							// 템플릿 리터럴 (표현식)
  	
  	// 한글 처리
  	var amtNm = "";
  	//
  	if (value >= 100000000) {
    	amtNm = (value / 100000000).toFixed(1).replace(/\.0$/, '') + "억원";
    } else if (value >= 10000000) {
    	amtNm = (value / 10000000).toFixed(1).replace(/\.0$/, '') + "천만원";
	} else if (value >= 10000) {
		amtNm = (value / 10000).toFixed(1).replace(/\.0$/, '') + "만원";
    } else {
		amtNm = value.toLocaleString() + "원";
    }
	//  화면 표시
	tag = "(" + tag + ")";
  	$("#amtNm").text(amtNm);
}

// 카드 번호 입력 (마스킹)
function cardProc(tag){
	//
    var raw = tag.value.replace(/[^0-9*]/g, ''); // 숫자와 *만 추출
    var masked = '';
	//
    for (var i = 0; i < raw.length; i++) {
        if (i >= 4 && i < 12) {
            masked += '*';
        } else {
            masked += raw[i];
        }

        // 하이픈 추가
        if ((i + 1) % 4 == 0 && i < 15) {
            masked += '-';
        }
    }
	// 번호 입력
	tag.value = masked;
}

// 숫자 입력
function numProc(num){
	num.value = num.value.replace(/[^0-9]/g, '');
}