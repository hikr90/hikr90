// JavaScript Document
// index.js

//moveToTop.png 클릭했을 때 0.5초 만에 TOP으로 이동
$(function(){	
	$('#moveToTop').on('click', function(){		
		$('html, body').animate({ scrollTop:0 }, 500); 
	});
});


