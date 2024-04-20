/* 명칭 : setTree
 * 작성자 : 김태현
 * 작성일자 : 2023.01.06 
 * 내용 : 트리 세팅
 */
function setTree(area) {
	// 영역 지정
	var tree = $('.'+area+' .tree');
	
	// 버튼 지정
	var treePlus = '\<button type=\"button\" class=\"treePlus\"\>+\<\/button\>';
	var treeMinus = '\<button type=\"button\" class=\"treeMinus\"\>-\<\/button\>';
	
	// 버튼 추가
	tree.find(".icon_folder").before(treeMinus); // - 버튼 추가
	
	//tree.find("ul").parent().prepend(treeMinus); // - 버튼 추가
	//$(".ul_1").prev().remove(); // 최상단 제거

	
	// 버튼 클릭 시
	tree.find("button").click(function(){
		//
		var treeBtn = $(this).attr("class");
		// 닫음
		if(treeBtn=="treeMinus"){
			$(this).parent().next().slideUp(200); // 하위 제거
			$(this).text("+"); // 아이콘 변경
			$(this).removeClass(); // 클래스 제거
			$(this).addClass("treePlus"); // 클래스 추가
			
		// 열음
		}else{
			$(this).parent().next().slideDown(200);
			$(this).text("-"); 
			$(this).removeClass(); 
			$(this).addClass("treeMinus");

		}
	});
}
