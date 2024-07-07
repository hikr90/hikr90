// Ajax 팝업
function ajaxPopup(obj, width, height, mappingId, i){
	//
	var zIndex = 9999;
	var popupArea = $("#popupArea"+i);
	//
	popupArea.css({
		 //
		 position:	'fixed'	,																// 포지션
		 boxShadow:	'0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)'	,	// 그림자 속성
         zIndex: zIndex + 1	,																// Z-INDEX (백그라운드 레이어보다 위)
         top:	'47%'	,
         left: 	'50%'	,
         width:	  width+'px' ,
         height:  height+'px' ,
         transform:	'translate(-50%, -50%)'	,
         msTransform:	'translate(-50%, -50%)',
         webkitTransform:	'translate(-50%, -50%)'
	});
	
	// 동작 제어
	$.ajax({
		type:	"POST" , 
		url:	mappingId,
		data:	obj,
		dataType:	"text" ,
		success : function(data){
			//
			$("#postCon"+i).html(data);
			$("#popupArea"+i).removeClass("hidden");

		},
		error : function(res, status, error){
			//
			alert("요청하신 작업을 실패하였습니다.\n관리자에게 문의해주세요.");
		}
	});

}

//
var mailChkYn = false; 	// 인증 여부 체크

// 정보 찾기 팝업
function chgPopup(mappingId){
	// 화면 전환
	$.ajax({
		type:	"POST" , 
		url:	mappingId,
		dataType:	"text" ,
		success : function(data){
			//
			mailChkYn = false;
			$("#joinCode").val("");
			$("#empId").val("");
			$("#empPwd").val("");
			//
			$("#postCon").html(data);
		},
		error : function(res, status, error){
			//
			alert("팝업 조회에 실패하였습니다.");
		}
	});
}

// 팝업 종료
function popClose(area){
	//
	$("#"+area).addClass('hidden');
}
