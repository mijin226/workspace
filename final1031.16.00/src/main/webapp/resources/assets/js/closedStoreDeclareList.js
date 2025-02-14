//폐점 신고 제보 승인 및 취소 처리

//폐점 신고 제보 승인
$('#addReport').on('click', function() {
	console.log('closedStoreDeclareList.js addReport start');

	//[1] 승인버튼 클릭한 가게 고유번호 불러오기
	const storeNum = document.getElementByid('storeNum').value;
	console.log('closedStoreDeclareList.js addReport storeNum load');

	//[2] 정말 승인절차 진행할 지 안내창 띄우기
	Swal.fire({
		icon: 'warning',
		title: '폐점신고 제보승인',
		text: '정말 폐점 처리하겠습니까? 확인을 누르면 폐점상태로 전환됩니다.',
		showCancelButton: true,//취소 버튼 생성
		confirmButtonText: '확인',
		cancelButtonText: '취소'

		//[3] 	확인 : 해당 가게 폐점 전환+제보글 삭제(addReport.do) 
		//		취소 : 가게 폐점제보 페이지로(loadListStoreReport.do)
	}).then((result) => {
		if (result.isConfirmed) {
			//addReport.do 비동기 진행
			//비동기 결과 true시, 폐점된 가게로 전환되었습니다. 제보글이 삭제됩니다.
			//처리도중 문제가 발생해 실행되지 않았습니다. 다시 시도해주세요. 재발생 시 본사에 문의 바랍니다.
			//ajax를 통해 비동기처리 진행
			$.ajax({
				url: 'addReport.do',
				type: 'POST',
				contentType: 'application/json',
				data: JSON.stringify({
					storeNum: storeNum,
				}),
				dataType: 'json',
				success: function(result) {
					if (result.true) {	//반환값 boolean true인 경우
						Swal.fire({
							icon: 'success',
							title: '폐점 전환 완료',
							text: '폐점된 가게로 전환되었습니다. 제보글이 삭제됩니다.',
							confirmButtonText: '확인',
						})
					} else {	//반환값 boolean false인 경우
						Swal.fire({
							icon: 'error',
							title: '에러 발생',
							text: '처리도중 문제가 발생해 실행되지 않았습니다. 다시 시도해주세요. 재발생 시 본사에 문의 바랍니다.',
							confirmButtonText: '확인'
						});
					}
				},
				error: function() {
					console.error('AJAX 요청 실패:', error);
					Swal.fire({
						icon: 'error',
						title: '오류',
						text: '서버와의 통신에 실패했습니다.',
						confirmButtonText: '확인'
					});
				}
			});
		}
	})
});


//폐점 신고 제보 취소
$('#deleteReport').on('click', function() {
	console.log('closedStoreDeclareList.js deleteReport start');

	//[1] 취소 버튼 클릭한 가게 고유번호 불러오기
	const storeNum = document.getElementByid('storeNum').value;
	console.log('closedStoreDeclareList.js deleteReport storeNum load');

	//[2] 정말 취소절차 진행할 지 안내창 띄우기
	Swal.fire({
		icon: 'warning',
		title: '폐점신고 제보취소',
		text: '폐점 신고된 글을 삭제하겠습니까? 확인을 누르면 신고된 제보는 삭제됩니다.',
		showCancelButton: true,//취소 버튼 생성
		confirmButtonText: '확인',
		cancelButtonText: '취소'

		//[3]	확인 : 해당 가게 고유번호 넘겨서 제보글 삭제(deleteReport.do)
		//		취소 : 가게 폐점제보 페이지로(loadListStoreReport.do)
	}).then((result) => {
		if (result.isConfirmed) {
			//deleteReport.do 비동기 진행
			//비동기 결과 true시, 제보글이 삭제되었습니다.
			//처리도중 문제가 발생해 실행되지 않았습니다. 다시 시도해주세요.
			//ajax를 통해 비동기처리 진행
			$.ajax({
				url: 'deleteReport.do',
				type: 'POST',
				contentType: 'application/json',
				data: JSON.stringify({
					storeNum: storeNum,
				}),
				dataType: 'json',
				success: function(result) {
					if (result.true) {	//반환값 boolean true인 경우
						Swal.fire({
							icon: 'success',
							title: '폐점 제보글 삭제',
							text: '폐점 제보글이 삭제되었습니다.',
							confirmButtonText: '확인',
						})
					} else {	//반환값 boolean false인 경우
						Swal.fire({
							icon: 'error',
							title: '에러 발생',
							text: '처리도중 문제가 발생해 실행되지 않았습니다. 다시 시도해주세요. 재발생 시 본사에 문의 바랍니다.',
							confirmButtonText: '확인'
						});
					}
				},
				error: function() {
					console.error('AJAX 요청 실패:', error);
					Swal.fire({
						icon: 'error',
						title: '오류',
						text: '서버와의 통신에 실패했습니다.',
						confirmButtonText: '확인'
					});
				}
			});
		}
	})
});
