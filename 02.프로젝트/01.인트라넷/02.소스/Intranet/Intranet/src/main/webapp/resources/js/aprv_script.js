// 프로젝트 팝업
function projCall(){
	try {
		//
		var obj = new Object();
		obj["mappingId"] = "intrPopupInqy1030.do";
		obj["areaType"] = "proj";
		obj["width"] = "600"
		obj["height"] = "370";
		//		
		ajaxPopup(obj);		
		
	} catch (error) {
        console.error("[Error] 프로젝트 팝업 : ", error.message);
	}
}
	
// 담당자 팝업
function empCall(){
	try {
	num.value = num.value.replace(/[^0-9]/g, '');
} catch (error) {
    console.error("[Error] 숫자 입력 : ", error.message);
}
	
	var obj = new Object();
	obj["mappingId"] = "intrPopupInqy1010.do";
	obj["areaType"] = "emp";
	obj["width"] = "550"
	obj["height"] = "420";
	//		
	ajaxPopup(obj);
}

// 결재선 등록 팝업
function lineReg(){
	try {
		//
		var obj = new Object();

		obj["mappingId"] = "intrPopupInqy1041.do";
		obj["areaType"] = "line";
		obj["sequenceId"] = "${param.sequenceId}";
		obj["width"] = "1100";
		obj["height"] = "620";
		//		
		ajaxPopup(obj);

	} catch (error) {
        console.error("[Error] 결재선 조회 팝업 : ", error.message);
	}
}

// 결재선 조회 팝업
function lineCall(){
	try {
		//
		var obj = new Object();
		
		obj["mappingId"] = "intrPopupInqy1042.do";
		obj["areaType"] = "line";
		obj["sequenceId"] = "${param.sequenceId}";
		obj["width"] = "1100";
		obj["height"] = "620";
		//		
		ajaxPopup(obj);

	} catch (error) {
        console.error("[Error] 결재선 조회 팝업 : ", error.message);
	}
}

// 물품 등록 팝업
function itemReg(){
	try {
		//
		var obj = new Object();
		
		obj["mappingId"] = "intrPopupInqy1061.do";
		obj["areaType"] = "item";
		obj["sequenceId"] = "${param.sequenceId}";
		obj["width"] = "1100"
		obj["height"] = "620";
		//		
		ajaxPopup(obj);
		
	} catch (error) {
        console.error("[Error] 물품 등록 팝업 : ", error.message);
	}
}

// 물품 조회 팝업
function itemCall(){
	try {
		//
		var obj = new Object();

		obj["mappingId"] = "intrPopupInqy1062.do";
		obj["areaType"] = "item";
		obj["sequenceId"] = "${param.sequenceId}";
		obj["width"] = "1100"
		obj["height"] = "620";
		//		
		ajaxPopup(obj);

	} catch (error) {
        console.error("[Error] 물품 조회 팝업 : ", error.message);
	}
}

// 정산내역 등록 팝업
function corpReg(){
	try {
		//
		var obj = new Object();

		obj["mappingId"] = "intrPopupInqy1071.do";
		obj["areaType"] = "corp";
		obj["sequenceId"] = "${param.sequenceId}";
		obj["width"] = "1100"
		obj["height"] = "620";
		//		
		ajaxPopup(obj);
		
	} catch (error) {
        console.error("[Error] 정산내역 등록 팝업 : ", error.message);
	}
}

// 정산내역 조회 팝업
function corpCall(){
	var obj = new Object();
	obj["mappingId"] = "intrPopupInqy1072.do";
	obj["areaType"] = "corp";
	obj["sequenceId"] = "${param.sequenceId}";
	obj["width"] = "1100"
	obj["height"] = "620";
	//		
	ajaxPopup(obj);
}

// 결재의견 입력 팝업
function opinCall(method){
	try {
		//
		var obj = new Object();
		
		obj["mappingId"] = "intrPopupInqy1050.do";
		obj["areaType"] = "opin";
		obj["width"] = "550";
		obj["height"] = "400";
		//
		$("#rslttypeCd").val(method);
		ajaxPopup(obj);

	} catch (error) {
        console.error("[Error] 결재의견 입력 팝업 : ", error.message);
	}
}

// 결재 처리
function opinConf(area) {
	var rslttypeCd = $("#rslttypeCd").val();
	var aprvPwd = $("#aprvPwd").val();
	var empPwd = "${empVO.empPwd}";
	//	
	try {
		// 유효성 검증
		if(aprvPwd == '') {
			alert("비밀번호를 입력해주세요.");
			return;
		}
		//
		if(aprvPwd != empPwd){
			alert("비밀번호를 확인해주세요.");
			return;
		}
		//
		if(rslttypeCd == 'RSLT_0020'){
			// 반송 시, 결재의견 미 입력
			if($("#aprvResn").val() == '') {
				alert("반송 시, 결재의견을 입력해주세요.");
				return;
			}
		}
		if(confirm("처리하시겠습니까?")) {
			formSubmit("intrAprvProc1020.do");
		}
					
	} catch (error) {
        console.error("[Error] 결재 처리 : ", error.message);
	}
}

// 결재 취소
function cnlProc(rslttypeCd) {
	try {
		//
		if(confirm("결재를 취소하시겠습니까?")) {
			$("#rslttypeCd").val(rslttypeCd);
			formSubmit("intrAprvProc1020.do");
		}
		
	} catch (error) {
        console.error("[Error] 결재 취소 : ", error.message);
	}
}