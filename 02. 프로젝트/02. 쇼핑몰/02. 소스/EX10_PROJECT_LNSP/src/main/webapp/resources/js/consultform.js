// JavaScript Document

$(function() {
	var movedIndex;
	
	function moveSlide(index) {
		movedIndex= index;
		
		var moveLeft= -(index*622);
		$('#slidePanel').animate({'left':moveLeft},'slow');
	}
	var randomNumber = Math.floor(Math.random()*1);
	moveSlide(randomNumber);
	
	$('#prevButton1').on('click',function() {
		if(movedIndex != 0)
		movedIndex = movedIndex - 1;
		moveSlide(movedIndex);
	});
	
	$('#nextButton1').on('click',function() {
		if(movedIndex != 7)
		movedIndex = movedIndex + 1;
		moveSlide(movedIndex);
	});
	
	$('#prevButton2').on('click',function() {
		if(movedIndex != 0)
		movedIndex = movedIndex - 1;
		moveSlide(movedIndex);
	});
	
	$('#nextButton2').on('click',function() {
		if(movedIndex != 6)
		movedIndex = movedIndex + 1;
		moveSlide(movedIndex);
	});
	
	$('#prevButton3').on('click',function() {
		if(movedIndex != 0)
		movedIndex = movedIndex - 1;
		moveSlide(movedIndex);
	});
	
	$('#nextButton3').on('click',function() {
		if(movedIndex != 5)
		movedIndex = movedIndex + 1;
		moveSlide(movedIndex);
	});
	
	$('#prevButton4').on('click',function() {
		if(movedIndex != 0)
		movedIndex = movedIndex - 1;
		moveSlide(movedIndex);
	});
	
	$('#nextButton4').on('click',function() {
		if(movedIndex != 4)
		movedIndex = movedIndex + 1;
		moveSlide(movedIndex);
	});
	
	$('#prevButton5').on('click',function() {
		if(movedIndex != 0)
		movedIndex = movedIndex - 1;
		moveSlide(movedIndex);
	});
	
	$('#nextButton5').on('click',function() {
		if(address1.value == ""){
			alert("우편번호 검색을 해 주세요");
			return;
		}
		if(address2.value == ""){
			alert("상세주소를 입력해 주세요");
			return;
		}
		if(movedIndex != 3)
		movedIndex = movedIndex + 1;
		moveSlide(movedIndex);
	});
	
	$('#prevButton6').on('click',function() {
		if(movedIndex != 0)
		movedIndex = movedIndex - 1;
		moveSlide(movedIndex);
	});
	
	$('#nextButton6').on('click',function() {
		if(address3.value == ""){
			alert("평수를 입력해 주세요");
			return;
		}
		if(movedIndex != 2)
		movedIndex = movedIndex + 1;
		moveSlide(movedIndex);
	});
	
	$('#prevButton7').on('click',function() {
		if(movedIndex != 0)
		movedIndex = movedIndex - 1;
		moveSlide(movedIndex);
	});
	
	$('#nextButton7').on('click',function() {
		if(address4.value == ""){
			alert("조경 관련 문의 및 희망 사항을 입력해주세요");
			return;
		}
		
		var result = confirm('견적요청서을 제출하시겠습니까?');

		if(result){
			$("form").submit();
		}
	});
	

$('#controlPanel img').each(function (index) {
	$(this).hover(
	function() {
		$(this).attr('src','images/button.png');
	},
	function() {
		$(this).attr('src','images/button1.png');
	}
	);
	
	$(this).on("click",function() {
		moveSlide(index);
	});
});
});

