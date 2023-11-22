$(function(){

	var movedIndex;
	/*
	function moveSlide(index){	
		movedIndex = index;
		
		var moveLeft = -(index*1280);
		$('#slidePanel').animate({'left':moveLeft}, 'slow');
	}
	*/
	function moveSlide(index) {
			//전달 받은 index 값을 movedIndex에 저장
			//prev와 next 메소드에서 사용
			movedIndex = index;		
				
			// 슬라이드 이동
			var moveLeft = -(index * 1920); //왼쪽으로 이동 거리
			$('#slidePanel').animate({'left': moveLeft}, 'slow');		
		}	
	
	var randomNumber = Math.floor(Math.random()*4);
	moveSlide(randomNumber);
	
	$('#prevButton').on('click', function(){
		if(movedIndex != 0)
		  movedIndex = movedIndex - 1;
		  moveSlide(movedIndex);
	});
	
	$('#nextButton').on('click', function(){
		if(movedIndex != 2)
		movedIndex = movedIndex + 1;
		moveSlide(movedIndex);
	});
	
	setInterval(function(){
		if(movedIndex != 3)
		movedIndex = movedIndex + 1;
		else
		movedIndex =0;
		
		moveSlide(movedIndex);
	},3000);
});