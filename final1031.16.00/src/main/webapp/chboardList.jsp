<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.ArrayList, java.util.HashMap, java.util.Map, java.util.List"%>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<% 
    // 예시 댓글 목록 생성
    List<Map<String, String>> replies = new ArrayList<>();
    
   for(int i =0; i<500; i++){
    Map<String, String> reply = new HashMap<>();
    reply.put("author", "user" + i);
    reply.put("date", "2024-10-2" + (i % 10)); // 날짜를 0-9 사이로 순환
    reply.put("content", "이 게시글 정말 유익해요! 댓글 내용 " + i);
    reply.put("canDelete", (i % 2 == 0) ? "true" : "false"); // 짝수 댓글은 삭제 가능
    replies.add(reply);
   }

    
    // JSP에서 사용할 수 있도록 설정
    request.setAttribute("commentsList", replies);
%>

<!DOCTYPE html>
<html>
<head>
<!-- css 변경을 위한 캐시 방지 -->
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="0">

<title>게시글</title>
<meta charset="utf-8" />

<link rel="stylesheet" href="${path}/resources/assets/css/main.css">
<link rel="stylesheet" href="${path}/resources/assets/css/boardlist.css">
<link rel="stylesheet" href="${path}/resources/assets/css/searchbar.css">
<link rel="stylesheet" href="${path}/resources/assets/css/pagination.css">

<!-- bootstrap -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
    crossorigin="anonymous">
<style>
#post-title {
    font-size: 28px;
    font-weight: bold;
    color: #333;
    margin-bottom: 10px; /* 제목과 날짜 간격 */
}

#post-content {
    background-color: #f8f9fa; /* 연한 회색 배경 */
    padding: 15px; /* 내용 부분 여백 */
    border-radius: 5px; /* 모서리 둥글게 */
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1); /* 약간의 그림자 */
}

.button-container {
    display: flex;
    justify-content: space-between;
    margin-top: 15px; /* 버튼과 내용 간격 */
}

#back-button {
    font-size: 14px; /* 돌아가기 버튼 크기 조정 */
}

#comment-input {
    height: 100px; /* 고정 높이 설정 */
    overflow-y: auto; /* 내용이 넘칠 경우 스크롤 가능 */
    resize: none; /* 사용자가 크기를 조절할 수 없도록 설정 */
}

#comments-section {
    margin-top: 20px;
}

.comment {
    background-color: #f8f9fa;
    padding: 15px;
    border-radius: 5px;
    margin-bottom: 10px;
    box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
}

.comment-header {
    margin-bottom: 5px;
}
</style>
</head>
<body>

    <custom:header />

    <div class="container">
        <!-- 첫 번째 행 -->
        <div class="row">
            <c:if test="true">
                <custom:pageTilte>일반 게시판</custom:pageTilte>
            </c:if>
            <c:if test="false">
                <custom:pageTilte>문의 게시판</custom:pageTilte>
            </c:if>
        </div>

        <!-- 두 번째 행 -->
        <div class="row align-items-center">
            <div class="col-12">
                <div class="post-header d-flex align-items-center justify-content-between">
                    <div class="d-flex flex-grow-1">
                        <h1 id="post-title" class="mb-0">게시글 제목</h1>
                        <p id="post-author" class="mb-0 ms-3">작성자: 사용자 이름</p>
                    </div>
                    <button id="like-button" class="btn btn-outline-primary">❤️ 좋아요</button>
                </div>
                <p id="post-date">작성일: 2024-10-27</p>
                <div id="post-content">게시글 내용...</div>
            </div>

            <!-- 버튼 컨테이너 -->
            <div class="button-container col-12">
                <div id="edit-button-container" style="display: inline;">
                    <button id="edit-post-button" class="btn btn-secondary">게시물 수정</button>
                </div>
                <button id="back-button" class="btn btn-light">게시물 돌아가기</button>
            </div>
        </div>
        <hr>

        <!-- 댓글 섹션 -->
        <div class="row">
            <div class="col-12">
                <h2>댓글쓰기</h2>
                <div class="d-flex justify-content-end align-items-center">
                    <p>댓글 ${commentsList.size()}개</p>
                </div>
                <!-- 댓글 작성 부분 -->
                <div id="comment-form">
                    <textarea id="comment-input" placeholder="댓글을 입력하세요..." class="form-control"></textarea>
                    <div class="d-flex justify-content-end">
                        <button id="submit-comment" class="btn btn-secondary mt-2">댓글 작성</button>
                    </div>
                </div>
                <div id="comments-section">
                    <c:forEach var="comment" items="${commentsList}">
                        <div class="comment">
                            <div class="comment-header d-flex justify-content-between">
                                <span class="comment-author">작성자: ${comment.author}</span>
                                <span class="comment-date">작성일: ${comment.date}</span>
                            </div>
                            <div class="d-flex justify-content-between align-items-center">
                                <div class="comment-content">${comment.content}</div>
                                <button class="btn btn-danger btn-sm comment-delete-button" 
                                    style="${comment.canDelete ? 'display: inline;' : 'display: none;'}">삭제</button>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <script>
                    let page = 1; // 현재 페이지
                    let loading = false; // 로딩 상태

                    function loadComments() {
                        if (loading) return; // 로딩 중이면 중복 요청 방지
                        loading = true;
                        document.getElementById('loading').style.display = 'block'; // 로딩 메시지 표시

                        fetch(`/loadComments?page=${page}`)
                            .then(response => response.text())
                            .then(data => {
                                const commentsSection = document.getElementById('comments-section');
                                commentsSection.innerHTML += data; // 새로운 댓글 추가
                                loading = false;
                                document.getElementById('loading').style.display = 'none'; // 로딩 메시지 숨김
                                page++; // 페이지 증가
                            })
                            .catch(error => {
                                console.error('Error loading comments:', error);
                                loading = false;
                                document.getElementById('loading').style.display = 'none'; // 로딩 메시지 숨김
                            });
                    }

                    // 스크롤 이벤트 리스너
                    window.addEventListener('scroll', () => {
                        if (window.innerHeight + window.scrollY >= document.body.offsetHeight - 500) { // 500px 남았을 때
                            loadComments();
                        }
                    });

                    // 초기 로드
                    loadComments();
                </script>
            </div>
        </div>
    </div>

    <custom:footer />
</body>
</html>
