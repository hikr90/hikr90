// 파일 관련 배열
var fileTemp	= []; // 업로드 파일

// 함수
$(function() {
	var fileCnt = 0;
	/* 명칭 : fileUpd
	 * 작성자 : 김태현
	 * 작성일자 : 2022.12.07
	 * 내용 : 파일 업로드
	 */
	$("#fileUpd").on('change', function() {
		// 파일, 화면 내 파일 추가
		var thisFiles = this.files; 
		var fileStr = "";
		// 파일 정보 추가
		fileTemp.push(thisFiles[0]);

		// 파일명, 파일 사이즈, 파일 확장자
		var fileIdx = thisFiles[0].name.toString().indexOf(".");
		var fileSize = (thisFiles[0].size/(1024*1024)).toFixed(2) + "MB";
		var fileTypeNm = thisFiles[0].name.toString().substring(fileIdx+1).toUpperCase();
				
		// 화면 내 파일 추가
		fileStr += "<li id='updLi"+fileCnt+"'>";
		fileStr += "	<input type='checkbox' class='_chkBox' name='checkIdx' value='"+fileCnt+"'/>";
		fileStr += "	<img src='resources/images/icon/icon_file.png' style='padding: 0 7px 0 7px'/>";
		fileStr += "	<a>"+thisFiles[0].name+"</a>";
		fileStr += "</li>";
			
		// 추가 후 초기화 
		$("#updUl").append(fileStr);
		fileStr = "";		
		fileCnt++;
	});	
	
	/* 명칭 : everyChk
	 * 작성자 : 김태현
	 * 작성일자 : 2022.12.07
	 * 내용 : 전체 체크박스 동작
	 */
	$('.everyChk').click(function() {
		if($(".everyChk").is(":checked")){
			$("input[type=checkbox]").prop("checked", true);
	    } else {
	    	$("input[type=checkbox]").prop("checked", false);	
	    }
	});
	
	/* 명칭 : fileDel
	 * 작성자 : 김태현
	 * 작성일자 : 2022.12.07
	 * 내용 : 파일 삭제
	 */
	$("#fileDel").on('click', function() {
		// 체크된 항목이 없는 경우
		if($("input[name='checkIdx']:checked").length==0){
			// 전체 체크 해제
			$("input:checkbox[name='everyChk']").prop("checked", false);
			alert("체크된 항목이 없습니다.");
			return;
		}
		
		// 삭제 값 처리
		$("input[name='checkIdx']:checked").each(function(i){
			// 배열 내 제거
			var checkVal = $(this).val();
			fileTemp.splice(checkVal,1);
			// 화면 내 제거
			var updLi = document.getElementById("updLi"+checkVal); 
			updLi.remove();
		});
		
		// 전체 체크 해제
		$(".everyChk").prop("checked", false);
	});

	/* 명칭 : profileImg
	 * 작성자 : 김태현
	 * 작성일자 : 2023.01.14
	 * 내용 : 사원 사진 변경 이벤트
	 */
	$("#profileImg").change(function(e) {
		// 이미지 존재
		if(this){
			//
			var imgFile = $(this).val();
			var isFileYn = /(\.png|\.jpg|\.jpeg)$/i;
			// 유효성 검증
			if(!imgFile.match(isFileYn)){
				alert("사진(png, jpg, jpeg) 파일만 업로드 가능합니다.");
				return;
			}
			
			// 업로드 이미지 처리
			var reader = new FileReader();
			reader.readAsDataURL(e.target.files[0]); // 바이너리 데이터 읽기 (이벤트 발생한 태그 자체)
			// 콜백 함수 동작
			reader.onload = function(f) {
				// 화면 상 처리
				$("#empImg").attr("src",f.target.result); // 이미지 미리보기
				$("#profileSpan").text(e.target.files[0].name); // 이미지 명칭 입력
				// 파일 저장
				fileTemp.push(e.target.files[0]);
			}
			//
			$("#modCnt").val("1");
		}
	});
	
	// 이미지 삭제
	$("#delProfileImg").click(function() {
		// 화면 상 처리
		$("#profileImg").val("");
		$("#empImg").attr("src","resources/images/icon/icon_emp.png");
		$("#profileSpan").text("사진을 등록해주세요.");
		$("#modCnt").val("1");
		
		// 파일 삭제
		fileTemp = [];
	})
});

/* 명칭 : setFileList
 * 작성자 : 김태현
 * 작성일자 : 2022.12.07
 * 내용 : 파일 목록 세팅
 */
function setFileList(){
	var fileList = new FormData(document.getElementById("form"));
	// 
	for(var i=0;i<fileTemp.length;i++){
		fileList.append("fileList",fileTemp[i]);
	}
	//
	return fileList;
}


/* 명칭 : setFileArea
 * 작성자 : 김태현
 * 작성일자 : 2023.01.10
 * 내용 : 파일 영역 세팅
 */
function setFileArea(){
	var fileStr = "";
	//
	$(".fileIdx").each(function(idx, item){
		//
		fileStr += "<input type='hidden' id='fileIdx"+idx+"' name='fileIdx"+idx+"' value='"+item.value+"'>";
	});
	//
	$("#modCnt").val($(".fileIdx").length);
	$("#fileArea").html(fileStr);
}


/* 명칭 : fileProc
 * 작성자 : 김태현
 * 작성일자 : 2024.04.13
 * 내용 : 파일 다운로드 (단건)
 */
function fileProc(fileIdx){
	formSubmit('intrFileProc1020.do?fileIdx='+fileIdx);
}
		
/* 명칭 : zipProc
 * 작성자 : 김태현
 * 작성일자 : 2024.04.13
 * 내용 : 파일 다운로드 (전체)
 */
function zipProc(){
	formSubmit('intrFileProc1030.do');
}

