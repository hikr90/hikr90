// JavaScript Document

$(function() {
	$('.submenuitem').slideUp(1);
	$('#submenubox').hide();
	
	var $submenuitem = $('.submenuitem');
	
	$('nav ul li').each(function(index) {
		$(this).hover(
			function() {
				$('#submenubox').css('visibility','visible');
				$('#submenubox') .show();
				$submenuitem.eq(index).slideDown(300);
			},
		    function() { 
			$submenuitem.eq(index).slideUp(200);
			$('#submenubox').hide();
	}
	);
});

$('.submenuitem').hover (
	function() {
		$submenuitem.stop();
		$('#submenubox').show();
	},
	function() {
		$submenuitem.slideUp(1);
		$('#submenubox').hide();
	}
	);
});