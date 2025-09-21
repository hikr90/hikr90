<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
	<meta content="text/html; charset=utf-8" http-equiv="Content-type">
	<meta http-equiv="X-UA-Compatible" content="Chrome">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<title>INTR EMP SYSTEM</title>
	
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/font/font.css" media="all">
 	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/common.css" media="all">	
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/layout.css" media="all">
	<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css"/>

	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/vendor/jquery-ul-1.12.1.css" media="all">

	<script src="${pageContext.request.contextPath }/resources/js/jquery/jquery-1.12.4.js"></script>
	<script src="${pageContext.request.contextPath }/resources/js/jquery/slick.min.js"></script>
	<script src="${pageContext.request.contextPath }/resources/js/jquery/jquery-ui-1.12.1.js"></script>

	<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
	
	<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
	<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
	<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
	
	<script src="${pageContext.request.contextPath }/resources/js/http_request.js"></script>
	<script src="${pageContext.request.contextPath }/resources/js/head_script.js"></script>
	<script src="${pageContext.request.contextPath }/resources/js/popup_script.js"></script>
	<script src="${pageContext.request.contextPath }/resources/js/tree_script.js"></script>
	<script src="${pageContext.request.contextPath }/resources/js/date_script.js"></script>
	<script src="${pageContext.request.contextPath }/resources/js/file_script.js"></script>

	<link href='${pageContext.request.contextPath}/resources/fullcalendar-5.10.2/lib/main.css' rel='stylesheet' />
	
	<script src='${pageContext.request.contextPath}/resources/fullcalendar-5.10.2/lib/main.js'></script>
	<script src="${pageContext.request.contextPath }/resources/ckeditor4/ckeditor.js"></script>
</head>

<script type="text/javascript">
	$(document).ready(function(){
		//
		var session = "${empVO}";
		//
		if(session == null || session == ''){
			alert("세션 정보가 없습니다.");
			location.href = 'intrMainInqy1010.do';
		}
	});
	
	// 프로젝트 팝업
	function projCall(){
		//
		var obj = new Object();
		//
		obj["mappingId"] = "intrPopupInqy1030.do";
		obj["areaType"] = "proj";
		obj["width"] = "600"
		obj["height"] = "370";
		//		
		ajaxPopup(obj);
	}
	
	// 담당자 팝업
	function empCall(){
		var obj = new Object();
		//
		obj["mappingId"] = "intrPopupInqy1010.do";
		obj["areaType"] = "emp";
		obj["width"] = "550"
		obj["height"] = "420";
		//		
		ajaxPopup(obj);
	}

	// 결재선 등록 팝업
	function lineReg(){
		var obj = new Object();
		//
		obj["mappingId"] = "intrPopupInqy1041.do";
		obj["areaType"] = "line";
		obj["sequenceId"] = "${param.sequenceId}";
		obj["width"] = "1100";
		obj["height"] = "620";
		//		
		ajaxPopup(obj);
	}

	// 결재선 조회 팝업
	function lineCall(){
		var obj = new Object();
		//
		obj["mappingId"] = "intrPopupInqy1042.do";
		obj["areaType"] = "line";
		obj["sequenceId"] = "${param.sequenceId}";
		obj["width"] = "1100";
		obj["height"] = "620";
		//		
		ajaxPopup(obj);
	}

	// 물품 등록 팝업
	function itemReg(){
		var obj = new Object();
		//
		obj["mappingId"] = "intrPopupInqy1061.do";
		obj["areaType"] = "item";
		obj["sequenceId"] = "${param.sequenceId}";
		obj["width"] = "1100"
		obj["height"] = "620";
		//		
		ajaxPopup(obj);
	}

	// 물품 조회 팝업
	function itemCall(){
		var obj = new Object();
		//
		obj["mappingId"] = "intrPopupInqy1062.do";
		obj["areaType"] = "item";
		obj["sequenceId"] = "${param.sequenceId}";
		obj["width"] = "1100"
		obj["height"] = "620";
		//		
		ajaxPopup(obj);
	}
	
	// 정산내역 등록 팝업
	function corpReg(){
		var obj = new Object();
		//
		obj["mappingId"] = "intrPopupInqy1071.do";
		obj["areaType"] = "corp";
		obj["sequenceId"] = "${param.sequenceId}";
		obj["width"] = "1100"
		obj["height"] = "620";
		//		
		ajaxPopup(obj);
	}

	// 정산내역 조회 팝업
	function corpCall(){
		var obj = new Object();
		//
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
		var obj = new Object();
		//
		obj["mappingId"] = "intrPopupInqy1050.do";
		obj["areaType"] = "opin";
		obj["width"] = "550";
		obj["height"] = "400";
		//
		$("#rslttypeCd").val(method);
		ajaxPopup(obj);
	}
	
	// 결재 처리
	function opinConf(area) {
		//
		var rslttypeCd = $("#rslttypeCd").val();
		var aprvPwd = $("#aprvPwd").val();
		var empPwd = "${empVO.empPwd}";
		
		// 유효성 검증
		if(aprvPwd == '') {
			alert("<spring:message code="APRV.PWD.NONE"/>");
			return;
		}
		//
		if(aprvPwd != empPwd){
			alert("<spring:message code="APRV.PWD.FAIL"/>");
			return;
		}
		//
		if(rslttypeCd == 'RSLT_0020'){
			// 반송 시, 결재의견 미 입력
			if($("#aprvResn").val() == '') {
				alert("<spring:message code="APRV.RSN.NONE"/>");
				return;
			}
		}
		//
		if(confirm("처리하시겠습니까?")) {
			formSubmit("intrAprvProc1020.do");
		}
	}
	
	// 결재 취소
	function cnlProc(rslttypeCd) {
		if(confirm("결재를 취소하시겠습니까?")) {
			$("#rslttypeCd").val(rslttypeCd);
			formSubmit("intrAprvProc1020.do");
		}
	}
</script>

<div id="overlay" class="overlay"></div>