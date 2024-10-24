//게시물 검색데이터 여부 확인 스크립트

//현재 문서에서 기능 다 수행하고 마지막으로 이하 익명함수 실행
$(document).ready(function() {
	//상태의 값이 input태그에 값이 들어오면, 즉 공백에서 변경되면
	$('#btn').on('click', function() {
		//이벤트가 발생하게 만든 주체, 즉 사용자가 입력한 상태값을 가져와 상태로 변수로 지칭
		var condition = $('#condition').val();
		var searchContent = $('#searchContent').val();
		console.log('condition: ' + condition);
		console.log('searchContent: ' + searchContent);

		//ajax를 통해 searchContent 비동기처리 진행
		if (searchContent) {//만약 searchContent가 있다면 이하 실행
			$.ajax({
				url: 'searchBoard.do',
				type: 'POST',
				contentType: 'application/json',
				data: JSON.stringify({
					condition: condition,
					searchContent: searchContent
				}),
				dataType: 'json',
				success: function(data) {
					console.log('sucess data [' + data + ']')
					console.log('[' + typeof data + ']')

					var boardSearchedList = $('#boardSearchList');
					console.log('dataList.length:' + data.length)
					boardSearchedList.empty();

					if (data.length <= 0) { //사용자가 검색한 데이터가 없다면
						boardSearchedList.append('검색하신 결과가 없습니다.');
					} else {//사용자가 검색한 데이터가 있다면
						data.forEach(function(board) {
							boardSearchedList.append('<li><a href="detailBoard.do> 작성자: ' + board.writer + ', 내용: ' + board.content + '</a></li>')
						})
					}
				}
			})
		} else {
			$('#searchContent').text(' ');//searchContent값이 없다면 공백처리	
		}
	});
});