var tempList = new Array();

$(function() {
	/* ================== 첨부파일 ================== */
	// 파일 업로드
	$("#fileUpd").on('change', function() {
		// 파일, 화면 내 파일 추가
		var thisFiles = this.files; 
		var fileStr = "";
		
		// 임시 목록 추가
		tempList.push(thisFiles[0]);

		// 파일명, 파일 사이즈, 파일 확장자
		var fileIdx = thisFiles[0].name.toString().indexOf(".");
		var fileSize = (thisFiles[0].size/(1024*1024)).toFixed(2) + "Mb";
		var fileTypeNm = thisFiles[0].name.toString().substring(fileIdx+1).toUpperCase();
				
		// 화면 내 파일 추가
		fileStr += "<li id='fileLi" + fileCnt + "'>";
		fileStr += "	<input type='hidden' id='fileIdx" + fileCnt + "' name='insert" + fileCnt + "' />";
		fileStr += "	<img src='resources/images/icon/icon_file.png' width='20' height='20' />";
		fileStr += "	<a onClick=\"fileDel('insert','" + fileCnt + "');\"><span>"+thisFiles[0].name+"</span></a>";
		fileStr += "</li>";
			
		// 추가 후 초기화 
		$("#fileUl").append(fileStr);
		fileStr = "";
		fileCnt++;
	});

	/* ================== 프로필 ================== */
	// 프로필 변경
	$("#profBtn").change(function(e) {
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
		$("#empImg").attr("src","resources/images/icon/icon_emp.png");
		$("#profText").text("사진을 등록해주세요.");
		tempList = [];
	});
});
 
/* ================== 첨부파일 삭제 ================== */
function fileDel(status, idx){
	var name = $("#fileIdx" + idx).attr("name");
	//
	if(status=='insert'){
		if(name.indexOf("insert")>-1){
			$("#fileLi"+idx).find("span").css('text-decoration','line-through');
			$("#fileIdx"+idx).attr("name", name.replace(status ,"none"));
		} else {
			$("#fileLi"+idx).find("span").css('text-decoration','');
			$("#fileIdx"+idx).attr("name", name.replace("none", status));
		}
	} else {
		if(name.indexOf("none")>-1){
			$("#fileLi"+idx).find("span").css('text-decoration','line-through');
			$("#fileIdx"+idx).attr("name", name.replace("none" , status));
		} else {
			$("#fileLi"+idx).find("span").css('text-decoration','');
			$("#fileIdx"+idx).attr("name", name.replace(status, "none"));
		}
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
// 단건 다운로드
function fileProc(fileIdx){
	formSubmit('fileDownload.do?fileIdx='+fileIdx);
}
	
// 전체 다운로드
function zipProc(){
	formSubmit('zipDownload.do');
}
