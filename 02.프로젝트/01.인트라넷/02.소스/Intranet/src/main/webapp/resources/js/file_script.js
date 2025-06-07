var tempList = new Array();

$(function() {
	/* ================== file ================== */
	// 업로드
	$("#fileUpd").on('change', function() {
		// 초기화 
		$("#fileUl").html("");
	
		// 파일, 화면 내 파일 추가
		var thisFiles = this.files; 
		var fileStr = "";
		
		// 다중 파일 처리 
		for(var i=0;i<thisFiles.length;i++){
			// 임시 목록 추가
			tempList.push(thisFiles[i]);
			
			// 화면 내 파일 추가
			fileStr += "<li id='fileLi" + i + "'>";
			fileStr += "	<input type='hidden' id='fileId" + i + "' name='insert" + i + "' />";
			fileStr += "	<img src='resources/images/icon/icon_file.png' width='20' height='20' />";
			fileStr += "	<a href='#' onclick=\"fileDel('insert', '" + i + "');\"><span>"+thisFiles[i].name+"</span></a>";
			fileStr += "</li>";
		}		
		
		// 추가 후 초기화 
		$("#fileUl").append(fileStr);
		fileStr = "";
	});

	/* ================== profile ================== */
	// 초기화
	$("#profBtn").on("click", function () {
		$(this).val("");
	});
	
	// 프로필 변경
	$("#profBtn").change(function(e) {
		//
		if(this){
			var thisFiles = this.files; 
			var profImg = $(this).val();
			var isFileYn = /(\.png|\.jpg|\.jpeg)$/i;
			tempList = [];
			
			// 유효성 검증
			if(!profImg.match(isFileYn)){
				alert("사진(png, jpg, jpeg) 파일만 업로드 가능합니다.");
				return;
			}
			
			// 프로필 업로드 처리
			var reader = new FileReader();
			reader.readAsDataURL(e.target.files[0]); // 바이너리 데이터 읽기 (이벤트 발생한 태그 자체)

			// 콜백 함수 동작
			reader.onload = function(f) {
				// 화면 상 처리
				$("#empImg").attr("src",f.target.result); // 이미지 미리보기
				$("#profText").text(e.target.files[0].name); // 이미지 명칭 입력
			}
			
			// 파일 목록 추가
			tempList.push(thisFiles[0]);
		}
	});
	
	// 프로필 삭제
	$("#profDel").click(function() {
		// 화면 상 처리
		$("#empImg").attr("src","resources/images/icon/icon_profile.png");
		$("#profText").text("사진을 등록해주세요.");
		tempList = [];
	});
});
 
/* ================== 첨부파일 삭제 ================== */
function fileDel(status, idx){
	//
	var fileLi = $("#fileLi" + idx);
    var fileId = $("#fileId" + idx);
    var fileProc = fileId.attr("name");
    var isDelete = (status === "insert") ? fileProc.includes("insert") : fileProc.includes("none");
    //
    if (isDelete) {
        fileLi.find("span").css("text-decoration", "line-through");
        fileId.attr("name", fileProc.replace(status, "none"));
    } else {
        fileLi.find("span").css("text-decoration", "");
        fileId.attr("name", fileProc.replace("none", status));
    }
}


/* ================== 폼데이터 생성 ================== */
function setFormData(){
	var fileList = new FormData(document.getElementById("form"));
	//
	for(var i=0;i<tempList.length;i++){
		fileList.append("fileList", tempList[i]);
	}
	//
	return fileList;
}


/* ================== 다운로드 ================== */
function fileProc(fileId, fileSno){
	formSubmit('fileDown.do?fileId='+fileId+'&fileSno='+fileSno);
}
	
function zipProc(){
	formSubmit('zipDown.do');
}
