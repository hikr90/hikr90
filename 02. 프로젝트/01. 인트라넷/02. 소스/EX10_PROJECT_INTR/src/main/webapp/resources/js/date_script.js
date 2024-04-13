$(function() {
	// 시작 일자
	$('input[id="srchSdt"]').daterangepicker(
			{
				//
				locale:{
					"separator": " ~ ", 										// 구분자
					"format": 'YYYY-MM-DD',										// 포맷
					"applyLabel": "확인",                    					// 확인 버튼 텍스트
				    "cancelLabel": "취소",                   					// 취소 버튼 텍스트
				    "daysOfWeek": ["일", "월", "화", "수", "목", "금", "토"],
				    "monthNames": ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"]
				},
				autoUpdateInput: false,											// 값 자동 표시 여부
				timePicker: false,                        						// 시간 표시 여부
			    showDropdowns: true,                     						// 년월 수동 여부
			    autoApply: false,                         						// 확인, 취소 자동 여부
			    timePicker24Hour: false,                  						// 24시 표시 여부
			    timePickerSeconds: false,                 						// 초 표시 여부
			    singleDatePicker: true                   						// 캘린더 한가지만 사용 여부
	});
	
	// 종료 일자
	$('input[id="srchEdt"]').daterangepicker(
			{
				//
				locale:{
					"separator": " ~ ", 										// 구분자
					"format": 'YYYY-MM-DD',										// 포맷
					"applyLabel": "확인",                    					// 확인 버튼 텍스트
					"cancelLabel": "취소",                   					// 취소 버튼 텍스트
					"daysOfWeek": ["일", "월", "화", "수", "목", "금", "토"],
					"monthNames": ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"]
				},
				autoUpdateInput: false,											// 값 자동 표시 여부
				timePicker: false,                        						// 시간 표시 여부
				showDropdowns: true,                     						// 년월 수동 여부
				autoApply: false,                         						// 확인, 취소 자동 여부
				timePicker24Hour: false,                  						// 24시 표시 여부
				timePickerSeconds: false,                 						// 초 표시 여부
				singleDatePicker: true                   						// 캘린더 한가지만 사용 여부
	});
	
	// 시작 일자 포맷
	$('input[id="srchSdt"]').on('apply.daterangepicker', function(ev, picker) {
	    $(this).val(picker.startDate.format('YYYY-MM-DD'));
	});

	// 
	$('input[id="srchSdt"]').on('cancel.daterangepicker', function(ev, picker) {
	      $(this).val('');
	});

	// 종료 일자 포맷
	$('input[id="srchEdt"]').on('apply.daterangepicker', function(ev, picker) {
		$(this).val(picker.endDate.format('YYYY-MM-DD'));
	});
	
	$('input[id="srchEdt"]').on('cancel.daterangepicker', function(ev, picker) {
		$(this).val('');
	});
	
});

/* 명칭 : leadingZeros
 * 작성자 : 김태현
 * 작성일자 : 2022.12.26
 * 내용 : 월 표현 함수 (0포함)
 */
function leadingZeros(n, digits) {
	// N (날짜 단위 값의 길이) 숫자가 DIGITS (연<4>,월<2>,일<2>의 길이) 보다 작은 경우 0 포함 두자리로 변경
    var zero = '';
    n = n.toString();
    //
    if (n.length < digits) {
        for (i = 0; i < digits - n.length; i++)
            zero += '0';
    }
    //
    return zero + n;
}

/* 명칭 : getTimeStamp
 * 작성자 : 김태현
 * 작성일자 : 2022.12.26
 * 내용 : 시간 표현 함수
 */
function getTimeStamp(d) {
	// GETMONTH + 1 : MONTH의 경우 0 ~ 11로 표현
	var now =  d.getHours() + ":" + ((d.getMinutes()<10?'0':'') + d.getMinutes() + ":" + d.getSeconds());
    return now;
}

/* 명칭 : getDateStamp
 * 작성자 : 김태현
 * 작성일자 : 2022.12.26
 * 내용 : 날짜 표현 함수
 */
function getDateStamp(d) {
	// GETMONTH + 1 : MONTH의 경우 0 ~ 11로 표현
	var now =  leadingZeros(d.getFullYear(), 4) + '-' + leadingZeros(d.getMonth() + 1, 2) + '-' + leadingZeros(d.getDate(), 2);
    return now;
}
