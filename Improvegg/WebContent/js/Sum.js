/**
 * 
 */

$(document).ready(function() {
	$('[data-toggle="tooltip"]').tooltip({
		    animated: 'fade',
		    placement: 'left',
		    html: true
	});   
	$('.dropdown').on('click', 'button', function(){
		$.ajax({
			url : 'expandSummoner',
			type : 'GET',
			success: function(data){
				alert(data);
				$('#resultdiv').text(data);
				$('.jq-dropdown-menu').show();
			}
		});
		alert('testjs');
		$(this).closest('.btn-group').addClass('dropup');
		
	});
});
	
	
	/*$('.dropup').on('click', 'button', function(){
		alert('suca2');
		$(this).closest('.dropup').addClass('dropdown');
		$(this).closest('.dropup').removeClass('dropup');
		$(this).closest('.jq-match-container').find('.jq-dropdown-menu').hide();
	});
	var xhr = new XMLHttpRequest();
	xhr.setRequestHeader("connection", "close");
	xhr.open('get', "expandSummoner", true);
	xhr.onload = function() {
		
		var jsonStringQuotes = xhr.responseText;
		var dati = JSON.parse(jsonStringQuotes);

		var xhrA = new XMLHttpRequest();
		xhrA.open('get', 'datiAnagrafici');
		xhrA.onload = function() {
			var jsonStringQuotesA = xhrA.responseText;
			var datiAnagrafici = JSON.parse(jsonStringQuotesA);
			var jsonStringQuotes = xhr.responseText;
			var professori = JSON.parse(jsonStringQuotes);
			var v = $('<option value=\"-1\">---</option>');
			$("#opzioniRicevimenti").append(v);
			var cont=0;
			for ( var i in professori) {
				console.log(professori[i].studentiRicevimento);
				if(professori[i].nomeUtente == datiAnagrafici.nomeUtente){
					for( var j in professori[i].studentiRicevimento){
						var a = $('<tr> <th value=\"'+professori[i].studentiRicevimento[j].matricola+'\">'+professori[i].studentiRicevimento[j].nome+' '+professori[i].studentiRicevimento[j].cognome+'</th> <th id="data'+cont+'"></th>  </tr>');
						$("#listaRicevimenti").append(a);
						texpandMatch(professori[i].nomeUtente, professori[i].studentiRicevimento[j].matricola,cont);
						cont++;
						var d = $('<option value=\"'+professori[i].studentiRicevimento[j].matricola+'\">'+professori[i].studentiRicevimento[j].nome+' '+professori[i].studentiRicevimento[j].cognome+'</option>');
						$("#opzioniRicevimenti").append(d);
					
					}
				}
			}	
		}
	}
	xhr.send(null);
});

function expandMatch(nM,mt,cont) {
	
	$.ajax({
		url : 'expandSummoner',
		data : {
			nomeUtente : nM,
			matricola : mt
		},
		type : 'get',
		success: function(data){
			$('#data'+cont+'').text(data);	
		}
	});
	
}*/