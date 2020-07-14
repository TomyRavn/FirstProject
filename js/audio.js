var audio = document.querySelector('#myAudio');

function init(){
    var index = 2;
	$('#playNext').click(function() {
		index++;
		if(index > $('#myAudio source').length) index=2;
		console.log( index-1 + '번째 소스 재생' );

		$('#myAudio source#main').attr('src',
			$('#myAudio source:nth-child('+index+')').attr('src'));
		$("#myAudio")[0].load();
		$("#myAudio")[0].play();
	});
}

init();