$(document).ready(function() {
	$(".dropdown-toggle").click(function() {
		var thiss = $(this);
		$.ajax({
			type: 'GET',
			url: 'expandSummoner',
			success: function(data){
				alert(data);
				thiss.closest('.jq-match-container').find('#resultdiv').html(data);
			}
		});		
	});
});
$(document).ready(function() {
	$(".dropdown-toggle").click(function() {
		var thiss = $(this);
		$.ajax({
			type: 'GET',
			url: 'expandSummoner',
			success: function(data){
				alert(data);
				thiss.closest('.jq-match-container').find('#resultdiv').html(data);
			}
		});		
	});
});
$(document).ready(function() {
	$('[data-toggle="tooltip"]').tooltip({
		    animated: 'fade',
		    position: 'right',
		    html: true
	});
});
