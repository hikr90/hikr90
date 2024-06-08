<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
	<meta content="text/html; charset=utf-8" http-equiv="Content-type">
	<meta http-equiv="X-UA-Compatible" content="Chrome">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<title>INTR EMP SYSTEM</title>
	
	<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/font/font.css" media="all">
 	<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/common.css" media="all">	
	<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/layout.css" media="all">
	<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css"/>

	<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/vendor/jquery-ul-1.12.1.css" media="all">

	<script src="${ pageContext.request.contextPath }/resources/js/jquery/jquery-1.12.4.js"></script>
	<script src="${ pageContext.request.contextPath }/resources/js/jquery/slick.min.js"></script>
	<script src="${ pageContext.request.contextPath }/resources/js/jquery/jquery-ui-1.12.1.js"></script>
	
	<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
	<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
	<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
	
	<script src="${ pageContext.request.contextPath }/resources/js/http_request.js"></script>
	<script src="${ pageContext.request.contextPath }/resources/js/head_script.js"></script>
	<script src="${ pageContext.request.contextPath }/resources/js/popup_script.js"></script>
	<script src="${ pageContext.request.contextPath }/resources/js/tree_script.js"></script>
	<script src="${ pageContext.request.contextPath }/resources/js/date_script.js"></script>
	<script src="${ pageContext.request.contextPath }/resources/js/file_script.js"></script>

	<link href='${pageContext.request.contextPath}/resources/fullcalendar-5.10.2/lib/main.css' rel='stylesheet' />
	
	<script src='${pageContext.request.contextPath}/resources/fullcalendar-5.10.2/lib/main.js'></script>
	<script src="${ pageContext.request.contextPath }/resources/ckeditor4/ckeditor.js"></script>
	
	<script type="text/javascript">
		$(document).ready(function(){
			var url = window.location.href;
			var session = "${sessionScope.empVO}";

			// 로그인 관련 화면이 아닌 경우
			if(!url.endsWith('/intr/') && url.indexOf('Login') == -1){
				// 세션이 없으면
				if(session==null){
					alert("세션이 만료되었습니다.");
					location.href="intrLoginInqy1010.do";
				}
			}
		})
	</script>
</head>
