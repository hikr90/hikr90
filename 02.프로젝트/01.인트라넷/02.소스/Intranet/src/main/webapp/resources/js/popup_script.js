// modal
function ajaxPopup(obj){
	//
	var area = obj["areaType"] + "Area"; // projArea
	var con =  obj["areaType"] + "Con";	// projCon
	//	
	var postArea = $("#" + area);
	postArea.css({
		 //
		 position:	'fixed'	,																// 포지션
         zIndex: 9991 + 1,																	// z-index (백그라운드 레이어보다 위)
         top:	'47%',
         left: 	'50%',
         width:	  obj["width"] + "px",
         height:  obj["height"] + "px",
         transform:	'translate(-50%, -50%)'	,
         msTransform:	'translate(-50%, -50%)',
         webkitTransform:	'translate(-50%, -50%)'
	});
	
	// 동작 제어
	$.ajax({
		type:	"POST" , 
		url:	obj["mappingId"],
		data:	obj,
		dataType:	"text" ,
		success : function(data){
			//
			$("#"+con).html(data);
			$("#"+area).removeClass("hidden");
			//
			$("#overlay").show();
		  	$("#"+area).show();
  			$('body').css('overflow', 'hidden');
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
			$("#findCon").html(data);
		},
		error : function(res, status, error){
			//
			alert("팝업 조회에 실패하였습니다.");
		}
	});
}

// 팝업 내 선택
function popConfirm(type){
	var pcd = type + "Pcd";
	var pnm = type + "Pnm";
	var input = $("input[name=" + pcd + "]:checked"); 

	// 선택 여부 검증
	if(input.length==0){
		alert("목록을 선택해주세요.");
		return;
	}
	// 팝업 선택 후 종료
	$("#" + pcd).val(input.attr(pcd));
	$("#" + pnm).val(input.attr(pnm));
	
	popClose(type);	
}

// 팝업 종료
function popClose(type){
	//
	var area = type + "Area";
	$("#"+area).addClass('hidden');
	$("#"+area).hide();
	$('#overlay').hide();
  	$('body').css('overflow', '');
}
