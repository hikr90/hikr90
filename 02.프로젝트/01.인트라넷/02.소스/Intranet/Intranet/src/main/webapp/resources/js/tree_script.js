// 트리 생성
function setTree(area) {
	// 영역 생성
	var tree = $('.'+area+' .tree');
	
	// 버튼 생성
	var treePlus = '\<button type=\"button\" class=\"treePlus\"\>+\<\/button\>';
	var treeMinus = '\<button type=\"button\" class=\"treeMinus\"\>-\<\/button\>';
	
	// 버튼 추가
	tree.find("ul > ul > li .orgCd").before(treeMinus);
	
	// 버튼 클릭 시
	tree.find("button").click(function(){
		//
		var treeBtn = $(this).attr("class");
		// 닫음 (-)
		if(treeBtn=="treeMinus"){
			$(this).parent().nextAll().slideUp(200); 				// 하위 제거
			$(this).text("+"); 													// 아이콘 변경
			$(this).removeClass(); 											// 클래스 제거
			$(this).addClass("treePlus"); 								// 클래스 추가
		// 오픈 (+)
		} else {
			$(this).parent().nextAll().slideDown(200);
			$(this).text("-"); 
			$(this).removeClass(); 
			$(this).addClass("treeMinus");
		}
	});
}
