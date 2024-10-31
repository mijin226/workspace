$(document).ready($('#insertReply').on('click', function() {
	var memberNum = $('#userNickname').val();
	var boardNum = $('#boardNum').val();
	var replyContent = $('#replyContent').val();

	console.log("insertReply.js start");

	$.ajax({
		url: "addReply.do",
		method: "POST",
		data: {
			memberNum: memberNum,
			boardNum: boardNum,
			replyContent: replyContent
		},
		success: function(data) {
			console.log("[" + data + "]");
			if (data === 'true') {
				console.log("insertReply.js true end");
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
			console.log("insertReply.js error end");
			Swal.fire({
				icon: 'error',
				title: '댓글 등록 도중 에러 발생',
				text: '댓글 등록 도중 에러가 발생하였습니다. 다시 시도해주세요.',
				confirmButtonText: '확인'
			});
		}
	});
}));