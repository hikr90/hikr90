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
		var sw = $(this).closest(".select_wrap");
		
		// 텍스트 박스에 표시
    	sw.find(".sList").text(setNm);           	// 표시용 div
    	sw.find('input').val(setNm); 				// 이름 값
    	sw.find('input').next().val(setCd); 		// 코드 값

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
	try {
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
	
	} catch (error) {
        console.error("[Error] 검색 초기화 : ", error.message);
	}
}

// 폼 태그 동작
function formSubmit(mappingId){
	try {
		//
		var f = document.getElementById('form');
		f.action = mappingId;
		f.submit();
	
	} catch (error) {
        console.error("[Error] 폼 태그 동작 : ", error.message);
	}
}

// 사용자
function userCall() {
	try {
		location.href = "intrMainInqy1020.do";
	
	} catch (error) {
        console.error("[Error] 사용자 : ", error.message);
	}
}

// 관리자
function adminCall() {
	try {
		location.href = "intrMainInqy1030.do";
	
	} catch (error) {
        console.error("[Error] 관리자 : ", error.message);
	}
}

// 로그아웃
function outProc() {
	try {
		alert("로그아웃 되었습니다.");
		location.href = "intrMainProc1020.do";
	
	} catch (error) {
        console.error("[Error] 로그아웃 : ", error.message);
	}
}

// 목록 조회 (엔터)
function pushCall(f) {
	try {
		if(event.keyCode==13){
			listCall(f);
		}
	} catch (error) {
        console.error("[Error] 목록 조회 (엔터) : ", error.message);
	}
}

// 로그인 (엔터)
function pushLogCall(f) {
	try {
		if(event.keyCode==13){
			loginCall(f);
		}
	} catch (error) {
        console.error("[Error] 로그인 (엔터) : ", error.message);
	}
}

// 영역 제거
function delArea(area) {
	try {
		$("#"+area).html("");
	} catch (error) {
        console.error("[Error] 영역 제거 : ", error.message);
	}
}

// 연락처 자동 입력
function mobProc(num) {
	try {
	    // replace(/[^0-9]/g, '') : 숫자가 아닌 모든 문자 제거
	    var input = num.value.replace(/[^0-9]/g, '');
	    var len = input.length;
	    var output = "";
	    
	    // 입력 길이에 따라 하이픈(-)을 추가하여 포맷팅
	    if (len < 4) {
	        // 3자리 이하 (예: 010)
	        output = input;
	    } else if (len < 7) {
	        // 4~6자리 (예: 010-123)
	        output = input.substr(0, 3) + "-" + input.substr(3);
	    } else if (len < 11) {
	        // 7~10자리 (일반적인 휴대폰 형식: 010-123-4567, 지역번호 포함: 02-123-4567)
	        output = input.substr(0, 3) + "-" + input.substr(3, 3) + "-" + input.substr(6);
	    } else {
	        // 11자리 이상 (예: 010-1234-5678)
	        // 최대 11자리까지만 사용하고 나머지 절삭
	        var maxInput = input.substr(0, 11);
	        output = maxInput.substr(0, 3) + "-" + maxInput.substr(3, 4) + "-" + maxInput.substr(7);
	    }

	} catch (error) {
        console.error("[Error] 연락처 자동 입력 : ", error.message);
	}
    // 포맷팅된 값을 입력 필드에 지정
    num.value = output;
}

// 입력 값 유효성 검증
function valProc(){
	// 유효성 검사 플래그
    var chkYn = true;
	//    
	try {
		// input & textArea
	    var requiredFields = $("#form input[type='text'], #form input[type='password'], #form textarea");
	
	    requiredFields.each(function(index, element){
	        // 현재 요소를 jQuery 객체로 변환
	        var tag = $(element);
	        var id = tag.attr('id') || '';
	        var title = tag.attr('title') || '필수 항목';
	        var value = tag.val().trim(); 
	        
	        // 제외 조건 통합 확인
	        // - input: id에 'srch' 또는 'none' 포함 시 제외
	        // - textarea: id가 'remark'인 경우 제외
	        var isTextArea = tag.is('textarea');
	
	        if (id.includes('srch') || id.includes('none') || (isTextArea && id === 'remark')) {
	            // 해당 요소는 건너뛰고 다음 반복으로 이동
	            return true; 
	        }
	        
	        // 값 유효성 검증
	        if (value === ""){
	            alert(title + "(을)를 입력해주세요.");
	            tag.focus(); 
	            chkYn = false; // 플래그 변경
	            return false;  // jQuery each 반복 중단
	        }
	    });
		    
	} catch(error) {
		console.error("[Error] 입력 값 유효성 검증 : ", error.message);
	}
	// 반복문 내에서 chkYn이 false로 변경되지 않았다면 true 반환
	return chkYn;		
}

// 주소 조회
function addrProc() {
	try {
			new daum.Postcode({
		        oncomplete: function(data) {
        	    // 주소 선택 후 동작
            	var data = data.address;
            	$("#addr").val(data); 
        	}
    	}).open();

	} catch (error) {
		console.error("[Error] 주소 조회 : ", error.message);	
	} 
}

// 금액 입력 처리
function amtProc(amt) {
    try {
        // 숫자만 남기고, 값 포맷팅을 위한 변수 선언
        var value = amt.value.replace(/[^0-9]/g, ""); 				// 숫자만 남김
        var numValue = Number(value);
        var format = numValue.toLocaleString("ko-KR"); 	// 쉼표 추가
        
        // 입력 필드에 통화 형식 지정 (빈 값이면 빈 문자열)
        amt.value = value ? "₩" + format : "";
        
        // 한글 처리
        var amtNm = "";
        
        if (numValue >= 100000000) {
            // 억 단위
            // toFixed(1)로 소수점 한 자리까지 고정 후, .0은 제거
            amtNm = (numValue / 100000000).toFixed(1).replace(/\.0$/, '') + "억원";
        } else if (numValue >= 10000000) {
            // 천만 단위
            amtNm = (numValue / 10000000).toFixed(1).replace(/\.0$/, '') + "천만원";
        } else if (numValue >= 10000) {
            // 만 단위
            amtNm = (numValue / 10000).toFixed(1).replace(/\.0$/, '') + "만원";
        } else if (numValue > 0) {
            // 원 단위
            amtNm = numValue.toLocaleString("ko-KR") + "원";
        } else {
            // 0이거나 빈 값
            amtNm = "0원";
        }

        // 화면 표시
        var target = document.getElementById("amtNm");
        if (target) {
            // 괄호와 함께 한글 금액 표시
            target.textContent = "(" + amtNm + ")";
        }
        
    } catch(error) {
        console.error("[Error] 금액 처리 : ", error.message);
    }
}

// 카드 번호 입력 (마스킹)
function cardProc(tag){
	try {
        // 숫자와 '*' 외의 모든 문자를 제거하고 최대 16자리까지만 사용
        var raw = tag.value.replace(/[^0-9*]/g, '');
        var limitedRaw = raw.substr(0, 16);
        
        // 마스킹 처리 (두 번째 그룹 4자리, 세 번째 그룹 4자리를 '*'로 대체)
        var masked = limitedRaw.replace(
            /^([0-9*]{4})([0-9*]{8})?([0-9*]{4})?$/, 
            function(match, p1, p2, p3) {
                var output = p1 || "";
                // 두 번째/세 번째 8자리가 있을 경우, 마스킹 처리 (총 8자리)
                if (p2) {
                    output += p2.replace(/[0-9]/g, '*'); // 숫자를 '*'로 변환
                }
                
                // 마지막 4자리가 있을 경우, 복원
                if (p3)  output = output.substr(0, 12) + p3;
                return output;
            }
        );
        
        // 하이픈 추가 (4자리마다 '-' 추가)
        // 입력된 문자열을 4자리씩 그룹화하고 '-'로 연결
        var formatted = masked.replace(/([0-9*]{4})(?=[0-9*])/g, '$1-');

        // 입력 필드에 최종 값 지정
        tag.value = formatted;
        
    } catch(error) {
        console.error("[Error] 카드 번호 입력 : ", error.message);
    }
}

// 숫자 입력
function numProc(num){
	try {
		num.value = num.value.replace(/[^0-9]/g, '');
	} catch (error) {
        console.error("[Error] 숫자 입력 : ", error.message);
	}
}

// 신규 등록 판단 (3일)
function isNew(regDt) {
    if (!regDt) return "";

	// Date 객체 생성
    var year = parseInt(regDt.substring(0, 4));
    var month = parseInt(regDt.substring(4, 6)) - 1; // 월은 0부터 시작
    var day = parseInt(regDt.substring(6, 8));
    
	var contDt = new Date(year, month, day);
    var today = new Date();

    // Date 비교
    today.setHours(0, 0, 0, 0); 
    
    var timeDiff = today.getTime() - contDt.getTime();
    var dayDiff = Math.floor(timeDiff / (1000 * 60 * 60 * 24));     // 1일 = 24 * 60 * 60 * 1000 밀리초

    // 3일 이내 (0, 1, 2)이면 NEW 마크업 반환
    if (dayDiff >= 0 && dayDiff <= 3) {
        return '<span style="color: red; font-weight: bold;">[NEW]</span> ';
    }
    return "";
}

// 탭 show/hide 체크
function isTabOverlow() {
    let tabList = $(".tab_list"); 						// 탭 목록 전체 (실제 콘텐츠 너비)
    let wrapper = $(".tab_wrapper");  			// 탭 목록을 감싸는 뷰포트 (보이는 영역 너비)
    let controls = $(".tab_scroll_controls"); 	// 좌우 화살표 버튼 컨테이너
    
    // 탭 목록의 실제 스크롤 너비와 wrapper의 보이는 너비를 비교
    if (tabList[0].scrollWidth > wrapper.width()) {
        // 탭이 넘칠 경우, show
        controls.show(); 
    } else {
        // 탭이 넘치지 않을 경우, hide
        controls.hide();
    }
}