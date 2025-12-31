var tempList = new Array();

$(function() {
	/* ================== file ================== */
	// 업로드
	$("#fileUpd").on('change', function() {
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
			fileStr += "	<a href='javascript:void(0);' onclick=\"fileDel('insert', '" + i + "');\"><span>"+thisFiles[i].name+"</span></a>";
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
			var isUploadImg = $(this).val();
			var isFileYn = /(\.png|\.jpg|\.jpeg)$/i;
			tempList = [];
			
			// 유효성 검증
			if(!isUploadImg.match(isFileYn)){
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
			$("#isUploadImg").val('Y');
		}
	});
	
	// 프로필 삭제
	$("#profDel").click(function() {
		// 화면 상 처리
		$("#empImg").attr("src","resources/images/icon/icon_profile.png");
		$("#profText").text("사진을 등록해주세요.");
		$("#isUploadImg").val('N');
		tempList = [];
	});
});
 

// 첨부파일 삭제
function fileDel(status, idx){
	var name = $("#fileId" + idx).attr("name");
	//
	try {
		// insert (등록), delete (삭제), none (작업 없음)
		if(status=='insert'){
			if(name.indexOf("insert")>-1){
				// insert > none
				$("#fileLi"+idx).find("span").css('text-decoration','line-through');			// 라인 추가
				$("#fileId"+idx).attr("name", name.replace(status ,"none"));					// none 처리
			} else {
				// none > insert
				$("#fileLi"+idx).find("span").css('text-decoration','');							// 라인 제거
				$("#fileId"+idx).attr("name", name.replace("none", status));					// insert 처리
			}
			//
		} else {
			if(name.indexOf("none")>-1){
				// none > delete
				$("#fileLi"+idx).find("span").css('text-decoration','line-through');			// 라인 추가
				$("#fileId"+idx).attr("name", name.replace("none" , status));					// none 처리
			} else {
				// delete > none
				$("#fileLi"+idx).find("span").css('text-decoration','');							// 라인 제거
				$("#fileId"+idx).attr("name", name.replace(status, "none"));					// delete 처리
			}
		}
		
	} catch (error) {
        console.error("[Error] 첨부파일 삭제 : ", error.message);
	}
}


// 폼 데이터 생성
function setFormData(){
	try {
		//
		var fileList = new FormData(document.getElementById("form"));
		for(var i=0;i<tempList.length;i++){
			fileList.append("fileList", tempList[i]);
		}
		
	} catch (error) {
        console.error("[Error] 폼 데이터 생성 : ", error.message);
	}
	//
	return fileList;
}


// 다운로드
function fileProc(fileId, fileSno){
	try {
		formSubmit('fileDown.do?fileId='+fileId+'&fileSno='+fileSno);
	
	} catch (error) {
        console.error("[Error] 다운로드 : ", error.message);
	}
}
	
// 압축 다운로드
function zipProc(){
	try {
		formSubmit('zipDown.do');
	} catch (error) {
        console.error("[Error] 압축 다운로드 : ", error.message);
	}
}

// 참고문서 다운로드
function docDown(docCd){
	try {
		formSubmit('docDown.do?docCd='+docCd);
	
	} catch (error) {
        console.error("[Error] 참고문서 다운로드 : ", error.message);
	}
}