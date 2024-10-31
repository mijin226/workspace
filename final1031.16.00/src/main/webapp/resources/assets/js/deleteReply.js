$(document).ready($('#deleteReply').on('click', function() {
	var replyNum = $('#replyNum').val();

	console.log("deleteReply.js start");

	$.ajax({
		url: "deleteReply.do",
		method: "POST",
		data: {
			replyNum: replyNum,
		},
		success: function(data) {
			console.log("[" + data + "]");
			if (data === 'true') {
				console.log("deleteReply.js true end");
				Swal.fire({
					icon: 'success',
					title: '댓글 등록 완료',
					text: '댓글이 등록되었습니다.',
					confirmButtonText: '확인'
				});
			} else {
				console.log("insertReply.js false end");
				Swal.fire({
					icon: 'error',
					title: '댓글 등록 실패',
					text: '댓글 등록을 실패하였습니다.',
					confirmButtonText: '확인'
				});
			}
		},
		error: function(error) {
			console.log("deleteReply.js error end");
			Swal.fire({
				icon: 'error',
				title: '댓글 등록 도중 에러 발생',
				text: '댓글 등록 도중 에러가 발생하였습니다. 다시 시도해주세요.',
				confirmButtonText: '확인'
			});
		}
	});
}));