//비밀번호 일치여부 확인 스크립트

//현재 문서에서 기능 다 수행하고 마지막으로 이하 익명함수 실행
$(document).ready(function() {
	//아이디값이 doublepassword인 input태그에 값이 들어오면, 즉 공백에서 변경되면
	$('#doublePassword').on('input', function() {
		//이벤트가 발생하게 만든 주체, 즉 사용자가 입력한 doublepassword값을 가져와 doublepassword라는 변수로 지칭
		var doublePassword = $(this).val();//doublepassword
		console.log('[ var doublePassword : ' + doublePassword + ']');
		var password = $('#password').val();
		console.log('[ var password : ' + password + ']');

		//ajax를 통해 mid 비동기처리 진행
		if (doublePassword) {//만약 doublepassword가 있다면 이하 실행
			$.ajax({
				url: 'checkedPW.do',
				type: 'POST',
				data: { password: password, doublePassword:doublePassword},
				success: function(data) {
					console.log('[' + data + ']')
					console.log('[' + typeof data + ']')
					if (data=='true') { 
						$('#resultPW').text('비밀번호가 일치합니다.').css('color', 'blue');
					} else if(data=='false'){
						$('#resultPW').text('비밀번호가 다릅니다. 다시 입력해주세요').css('color', 'red');
					}
				}
			});
		} else {
			$('#resultPW').text(' ');//mid값이 없다면 공백처리	
		}
	});
});