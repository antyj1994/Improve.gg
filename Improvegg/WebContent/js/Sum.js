$(document).ready(function() {
	$(".booldropdownt").click(function() {
		var thiss = $(this);
		thiss.closest('.btn-group').addClass('dropup');
		thiss.closest('.btn-group').removeClass('dropdown');
		thiss.addClass('booldropdownf');
		thiss.removeClass('booldropdownt');
		$.ajax({
			type: 'GET',
			url: 'expandSummoner',
			success: function(data){
				thiss.closest('.jq-match-container').find('#resultdiv').html('<div class="container expand-container">' +
						'<b>' + data + '<b></div>'
				);
			}
		});		
	});
	
	$('[data-toggle="tooltip"]').tooltip({
	    animated: 'fade',
	    position: 'right',
	    html: true
});
});

/*$(document).ready(function() {
	$(".booldropdownf").click(function() {
		alert('test');
		var thiss = $(this);
		thiss.removeClass('booldropdownf');
		thiss.addClass('booldropdownt');
		thiss.closest('.btn-group').addClass('dropdown');
		thiss.closest('.btn-group').removeClass('dropup');
		//thiss.closest('.jq-match-container').find('#resultdiv').remove();		
	});
});*/

var utilLoad = 0;

$(document).ready(function() {
	$(".load-btn").click(function() {
		var summonerName = $('#sumName').text();
		var thiss = $(this);
		$.ajax({
			type: 'POST',
			url: 'expandMatches',
			data: {
				summonerName: summonerName,
				timess: utilLoad,
			},
			success: function(data){
				utilLoad++;
				var matches = $.parseJSON(data);
				for (var i=0; i<matches.length; i++){
					var x = matches[i];
					$('.matches-container').append(
							'<hr class="my-3">' +
							'<div class="jq-match-container">' +
							 	'<div class="container-fluid row match-container justify-content-between">' +
							 		'<div class="game-stats col-sm">' +
							 			'<div>' +
							 				x.gameMode +
							 				'<hr class="my-1">' +
							 				x.result +
							 				'<hr class="my-1">' +
							 				x.gameDuration +
							 			'</div>' +
							 		'</div>' +
							 		'<div class="summ-stats col">' +
							 			'<div class="row">' +
								 			'<div class="col">' +
								 				'<img src="' + x.champUrl + '" class="rounded champions-image" width="75" height="75" data-toggle="tooltip" title="<img src=' + x.champ + '>">' +
								 				'<footer>' +
								 					x.champName +
								 				'</footer>' +
								 			'</div>' +
								 			'<div class="col">' +
								 				'<img src="' + x.spellUrl1 + '" class="rounded champions-image" width="50" height="50" data-toggle="tooltip" title="<img src=' + x.spell1 + '>">' +
								 				'<img src="' + x.spellUrl2 + '" class="rounded champions-image" width="50" height="50" data-toggle="tooltip" title="<img src=' + x.spell2 + '>">' +
								 			'</div>' +
							 			'</div>' +
							 		'</div>' +
							 		'<div class="kda col">' +
							 			'<div class="row">' +
							 				'<div class="champ-level col">' +
									 			'Level ' + x.champLevel +
									 			'<hr class="my-1">' +
									 			x.cs + 'CS' +
									 			'<hr class="my-1">' +
									 			x.golds + 'K' +
									 		'</div>' +
							 				'<div class="kda col">' +
							 					x.kda +
							 					'<hr class="my-2">' +
							 					x.lane +
							 				'</div>' +
							 			'</div>' +
							 		'</div>' +
							 		'<div class="items col">' +
								 		'<div class="container items1">' +
								 			'<img src="' + x.itemUrl0 + '" class="rounded champion-image" width="30" height="30" data-toggle="tooltip" title="<img src=' + x.item0 + '>">' +
								 			'<img src="' + x.itemUrl1 + '" class="rounded champion-image" width="30" height="30" data-toggle="tooltip" title="<img src=' + x.item1 + '>">' +
								 			'<img src="' + x.itemUrl2 + '" class="rounded champion-image" width="30" height="30" data-toggle="tooltip" title="<img src=' + x.item2 + '>">' +
								 			'<hr class="my-2">' +
								 		'</div>' +
								 		'<div class="container items2">' +
								 			'<img src="' + x.itemUrl3 + '" class="rounded champion-image" width="30" height="30" data-toggle="tooltip" title="<img src=' + x.item3 + '>">' +
								 			'<img src="' + x.itemUrl4 + '" class="rounded champion-image" width="30" height="30" data-toggle="tooltip" title="<img src=' + x.item4 + '>">' +
								 			'<img src="' + x.itemUrl5 + '" class="rounded champion-image" width="30" height="30" data-toggle="tooltip" title="<img src=' + x.item5 + '>">' +
								 		'</div>' +
								 	'</div>' +
							 		'<div class="teams col-md">' +
							 			'<div class="team-row row">' +
								 			'<div class="container team1">' +
								 				'<img src="' + x.champs[0] + '" class="rounded champion-image" width="30" height="30">' +
												'<img src="' + x.champs[1] + '" class="rounded champion-image" width="30" height="30">' +
												'<img src="' + x.champs[2] + '" class="rounded champion-image" width="30" height="30">' +
												'<img src="' + x.champs[3] + '" class="rounded champion-image" width="30" height="30">' +
												'<img src="' + x.champs[4] + '" class="rounded champion-image" width="30" height="30">' +
								 				'<hr class="my-2">' +
									 		'</div>' +
									 		'<div class="container team2">' +
									 			'<img src="' + x.champs2[0] + '" class="rounded champion-image" width="30" height="30">' +
									 			'<img src="' + x.champs2[1] + '" class="rounded champion-image" width="30" height="30">' +
									 			'<img src="' + x.champs2[2] + '" class="rounded champion-image" width="30" height="30">' +
									 			'<img src="' + x.champs2[3] + '" class="rounded champion-image" width="30" height="30">' +
									 			'<img src="' + x.champs2[4] + '" class="rounded champion-image" width="30" height="30">' +
									 		'</div>' +
									 	'</div>' +
							 		'</div>' +			 		
							 		'<div class="btn-group dropdown">' +
								 		'<button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">' +
		    								'<span class="sr-only">Toggle Dropdown</span>' +
		  								'</button>' +
	  								'</div>' +
							 	'</div>' +
							 	'<div class="jq-dropdown-menu container-fluid">' +
							 		'<div id="resultdiv">' +	
							 		'</div>'  +
							 	'</div>' +
						 	'</div>'
					);	
				}
				$('.matches-container').append('<hr class="my-4">');
			},
			error: function(){
				alert(summonerName);
			}
		});		
	});
});
