//아이디 중복확인 스크립트

//현재 문서에서 기능 다 수행하고 마지막으로 이하 익명함수 실행
$(document).ready(function() {
	//아이디값이 mid인 input태그에 값이 들어오면, 즉 공백에서 변경되면
	$('#mid').on('input', function() {
		//이벤트가 발생하게 만든 주체, 즉 사용자가 입력한 mid값을 가져와 mid라는 변수로 지칭
		var mid = $(this).val();
		console.log('[' + mid + ']');

		//ajax를 통해 mid 비동기처리 진행
		if (mid) {//만약 mid가 있다면 이하 실행
			$.ajax({
				url: 'checkedMID.do',
				type: 'POST',
				data: { mid: mid },
				success: function(data) {
					console.log('[' + data + ']')
					console.log('[' + typeof data + ']')
					if (data=='true') { 
						$('#resultMID').text('이미 사용중인 아이디입니다. 다른 아이디 입력해주세요.').css('color', 'red');
					} else if(data=='false'){
						$('#resultMID').text('사용가능한 아이디입니다.').css('color', 'blue');
					}
				}
			});
		} else {
			$('#resultMID').text(' ');//mid값이 없다면 공백처리	
		}
	});
});