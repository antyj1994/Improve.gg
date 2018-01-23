/**
 * 
 */

$(document).ready(function() {
	$('[data-toggle="tooltip"]').tooltip({
		    animated: 'fade',
		    placement: 'left',
		    html: true
	});   
	$('.dropdown-toggle').on('click', 'button', function(){
		alert('suca1');
		$(this).closest('.btn-group').toggleClass('dropup');
		$(this).closest('.jq-match-container').find('.jq-dropdown-menu').slideToggle();
	});
	/*$('.dropup').on('click', 'button', function(){
		alert('suca2');
		$(this).closest('.dropup').addClass('dropdown');
		$(this).closest('.dropup').removeClass('dropup');
		$(this).closest('.jq-match-container').find('.jq-dropdown-menu').hide();
	});*/
});