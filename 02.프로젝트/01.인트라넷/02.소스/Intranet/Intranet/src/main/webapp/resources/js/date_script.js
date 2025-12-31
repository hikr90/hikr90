$(function() {
	// 데이트피커 초기화
	initDatepicker();
});

// daterangepicker 초기화
function initDatepicker() {
    $('input[id="srchSdt"], input[id="srchEdt"]').daterangepicker({
        locale: {
            "separator": " ~ ",
            "format": 'YYYY-MM-DD',
            "daysOfWeek": ["일", "월", "화", "수", "목", "금", "토"],
            "monthNames": ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"]
        },
        autoUpdateInput: false,
        singleDatePicker: true,
        showDropdowns: true,
        autoApply: true,
        parentEl: '.post_view' // 👈 모달 내부에 달력을 생성하도록 지정 (중요)
    });

    // 날짜 선택 시 input에 값 삽입
    $('input[id="srchSdt"], input[id="srchEdt"]').on('apply.daterangepicker', function(ev, picker) {
        $(this).val(picker.startDate.format('YYYY-MM-DD'));
    });

    // flatpickr (시간) 초기화
    flatpickr(".time_picker", { // id보다는 class 권장 (중복 방지)
        enableTime: true,
        noCalendar: true,
        dateFormat: "H:i",
        time_24hr: true
    });
}

// 월 (0 포함) 표현
function leadingZeros(n, digits) {
	try {
		// N (날짜 단위 값의 길이) 숫자가 DIGITS (연<4>,월<2>,일<2>의 길이) 보다 작은 경우 0 포함 두자리로 변경
	    var zero = '';
	    n = n.toString();
	    //
	    if (n.length < digits) {
	        for (i = 0; i < digits - n.length; i++)
	            zero += '0';
	    }
	
	} catch (error) {
        console.error("[Error] 월 (0 포함) 표현 : ", error.message);
	}
    //
    return zero + n;
}

// 현재 시간 표현
function getTimeStamp(d) {
	try {
		// getMinutes + 1 : Minutes의 경우 0 ~ 9로 표현
		var now =  d.getHours() + ":" + ((d.getMinutes()<10?'0':'') + d.getMinutes() + ":" + d.getSeconds());
	
	} catch (error) {
        console.error("[Error] 현재 시간 표현 : ", error.message);
	}
	//	
    return now;
}

// 현재 일자 표현
function getDateStamp(d) {
	try {
		// getMonth + 1 : Month의 경우 0 ~ 11로 표현
		var now =  leadingZeros(d.getFullYear(), 4) + '-' + leadingZeros(d.getMonth() + 1, 2) + '-' + leadingZeros(d.getDate(), 2);
	
	} catch (error) {
        console.error("[Error] 현재 일자 표현 : ", error.message);
	}
	//	
    return now;
}
