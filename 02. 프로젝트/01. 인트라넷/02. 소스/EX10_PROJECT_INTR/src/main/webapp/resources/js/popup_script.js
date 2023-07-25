/* 명칭 : ajaxPopup
 * 작성자 : 김태현
 * 작성일자 : 2022.11.02
 * 내용 : 기본 팝업 
 */
function ajaxPopup(obj, width, height, mappingId){
	//
	var zIndex = 9999;
	var popupArea = $("#popupArea");
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
			$("#postCon").html(data);
			$("#popupArea").removeClass("hidden");

		},
		error : function(res, status, error){
			//
			alert("요청하신 작업을 실패하였습니다.\n관리자에게 문의해주세요.");
		}
	});

}


/* 명칭 : chgPopup
 * 작성자 : 김태현
 * 작성일자 : 2022.11.02 
 * 내용 : 아이디, 비밀번호 찾기 화면 전환
 */
var EmaChkYn = false; 	// 인증 여부 체크
function chgPopup(mappingId){
	// 화면 전환
	$.ajax({
		type:	"POST" , 
		url:	mappingId,
		dataType:	"text" ,
		success : function(data){
			//
			EmaChkYn = false;
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

/* 명칭 : popClose
 * 작성자 : 김태현
 * 작성일자 : 2022.11.11 
 * 내용 : 팝업 닫기
 */
function popClose(area){
	//
	$("#"+area).addClass('hidden');
}