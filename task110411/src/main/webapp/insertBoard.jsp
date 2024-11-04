<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>글 작성 페이지</title>
    <style>
        /* 미리보기 이미지의 스타일 설정 */
        #previewImage {
            max-width: 300px; /* 최대 너비 설정 */
            max-height: 300px; /* 최대 높이 설정 */
            display: none; /* 초기에는 숨김 */
        }
    </style>
</head>
<body>
    <form action="insertBoard.do" method="POST" id="insertBoard" enctype="multipart/form-data">
        <!-- 작성자 정보 (숨김 필드) -->
        작성자 <input type="text" name="writer" value="${userID}" readonly> <br>
        
        <!-- 내용 입력 필드 -->
        내용 <input type="text" name="content" required> <br>
        
        <!-- 프로필 이미지 업로드 필드 -->
        프로필 이미지 <input type="file" id="file" name="file" onchange="preview(event)">
        
        <!-- 미리보기 이미지 태그 -->
        <img id="previewImage" alt="이미지 미리보기"><br>
        
        <!-- 제출 버튼 -->
        <input type="submit" value="글 작성">
    </form>

    <script>
        // 파일 입력 필드에서 파일이 선택되었을 때 호출되는 함수
        function preview(event) {
            // 선택된 파일을 가져옴
            const file = event.target.files[0];
            // 파일이 선택되지 않았으면 함수 종료
            if (!file) {
                return;
            }
            // FileReader 객체를 생성
            const reader = new FileReader();
            // 파일이 로드되었을 때 실행되는 이벤트 핸들러
            reader.onload = function(e) {
                // 미리보기 이미지 태그의 src 속성을 선택된 파일의 데이터로 설정
                const previewImage = document.getElementById('previewImage'); // ID 수정
                previewImage.src = e.target.result; // 파일의 데이터 URL
                previewImage.style.display = 'block'; // 이미지 태그를 보이도록 설정
            };
            // 파일 읽기 시작
            reader.readAsDataURL(file);
        }
    </script>
    
    <hr>
    <!-- 메인 페이지로 이동하는 링크 -->
    <a href="main.do">메인으로 이동</a>
</body>
</html>