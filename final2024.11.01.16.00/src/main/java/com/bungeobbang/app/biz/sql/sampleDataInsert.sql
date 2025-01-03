-- 상품 카테고리 데이터
INSERT INTO bb_product_category (PRODUCT_CATEGORY_NAME)
VALUES ('문구/사무'),
       ('리빙'),
       ('패션/잡화'),
       ('디지털/IT'),
       ('홈데코');
-- 상품 데이터(크롤링)
INSERT INTO bb_product (PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_PROFILE_WAY, PRODUCT_CATEGORY_NUM)
VALUES 
('붕어빵 기계', 150000, 'DEFAULT.PNG', 1), -- 문구/사무
('붕어빵 모양 쿠션', 25000, 'DEFAULT.PNG', 2), -- 리빙
('붕어빵 패턴 가방', 30000, 'DEFAULT.PNG', 3), -- 패션/잡화
('붕어빵 전자레인지', 80000, 'DEFAULT.PNG', 4), -- 디지털/IT
('붕어빵 장식품', 50000, 'DEFAULT.PNG', 5), -- 홈데코
('붕어빵 모양 머그컵', 12000, 'DEFAULT.PNG', 2), -- 리빙
('붕어빵 향수', 35000, 'DEFAULT.PNG', 3), -- 패션/잡화
('붕어빵 만들기 책', 20000, 'DEFAULT.PNG', 1), -- 문구/사무
('붕어빵 원피스', 45000, 'DEFAULT.PNG', 3), -- 패션/잡화
('붕어빵 굽기 팬', 22000, 'DEFAULT.PNG', 4); -- 디지털/IT


-- Member 데이터
INSERT INTO bb_member (MEMBER_EMAIL, MEMBER_PASSWORD, MEMBER_NAME, MEMBER_NICKNAME, MEMBER_PHONE, MEMBER_PROFILE_WAY, MEMBER_ROLE)
VALUES ('admin', '123123123', '관리자', '관리자닉네임', '010-1111-1111', 'default_profile.png', 'ADMIN'),
       ('admin2', 'admin456!', '부관리자', '부관리자닉네임', '010-1111-1112', 'default_profile.png', 'ADMIN'),
       ('bungeobbang@test.com', 'testpassword', '김붕어빵', '붕어빵원정대', '010-2222-2222', 'default_profile.png', 'USER'),
       ('owner2@test.com', 'owner456!', '이사장', '붕어빵장인2', '010-3333-3333', 'default_profile.png', 'USER'),
       ('owner3@test.com', 'owner789!', '박사장', '붕어빵장인3', '010-3333-3334', 'default_profile.png', 'USER'),
       ('owner4@test.com', 'owner101!', '정대표', '붕어빵장인4', '010-3333-3335', 'default_profile.png', 'USER'),
       ('owner5@test.com', 'owner102!', '최사장', '붕어빵장인5', '010-3333-3336', 'default_profile.png', 'USER'),
       ('owner6@test.com', 'owner103!', '강대표', '붕어빵장인6', '010-3333-3337', 'default_profile.png', 'USER'),
       ('user1@test.com', 'user123!', '강아지', '붕어빵러버1', '010-4444-4444', 'default_profile.png', 'USER'),
       ('user2@test.com', 'user456!', '고양이', '붕어빵러버2', '010-5555-5555', 'default_profile.png', 'USER'),
       ('user3@test.com', 'user789!', '개구리', '붕어빵러버3', '010-5555-5556', 'default_profile.png', 'USER'),
       ('user4@test.com', 'user101!', '두더지', '붕어빵러버4', '010-5555-5557', 'default_profile.png', 'USER'),
       ('user5@test.com', 'user102!', '잠자리', '붕어빵러버5', '010-5555-5558', 'default_profile.png', 'USER'),
       ('user6@test.com', 'user103!', '송아지', '붕어빵러버6', '010-5555-5559', 'default_profile.png', 'USER'),
       ('user7@test.com', 'user104!', '바둑이', '붕어빵러버7', '010-5555-5560', 'default_profile.png', 'USER'),
       ('user8@test.com', 'user105!', '누렁이', '붕어빵러버8', '010-5555-5561', 'default_profile.png', 'USER');


-- BB_STORE 샘플 데이터 (역삼역 부근 도로명주소)
INSERT INTO bb_store (STORE_NAME, STORE_ADDRESS, STORE_ADDRESS_DETAIL, STORE_CONTACT, STORE_CLOSED, STORE_SECRET)
VALUES ('달콤붕어빵', '서울특별시 강남구 테헤란로 152', '1층 키오스크 앞', '02-555-5555', 'N', 'N'),
       ('호호붕어빵', '서울특별시 강남구 테헤란로 142', '역삼역 3번출구 앞', '02-666-6666', 'N', 'N'),
       ('사랑붕어빵', '서울특별시 강남구 역삼로 166', '역삼역 4번출구 앞', '02-777-7777', 'N', 'N'),
       ('행복붕어빵', '서울특별시 강남구 테헤란로 129', 'GFC 건물 앞', '02-888-8888', 'N', 'N'),
       ('즐거운붕어빵', '서울특별시 강남구 논현로 508', '2층 카페 앞', '02-999-9999', 'N', 'N'),
       ('맛있는붕어빵', '서울특별시 강남구 역삼로 170', '역삼동 주민센터 맞은편', '02-111-1111', 'N', 'N'),
       ('황금붕어빵', '서울특별시 강남구 테헤란로 146', 'SK허브블딩 1층', '02-222-2222', 'Y', 'N'),
       ('은빛붕어빵', '서울특별시 강남구 역삼로7길 16', '역삼역 캄피나폴리스 앞', '02-333-3333', 'N', 'N'),
       ('동네붕어빵', '서울특별시 강남구 테헤란로 134', '포스코P&S타워 앞', '02-444-4444', 'N', 'Y'),
       ('정성붕어빵', '서울특별시 강남구 역삼로 155', '강남역삼푸르지오 앞', '02-555-5556', 'N', 'N'),
       ('왕붕어빵', '서울특별시 강남구 테헤란로25길 10', '역삼역 푸드코트 옆', '02-666-6667', 'N', 'N'),
       ('명품붕어빵', '서울특별시 강남구 역삼로3길 12', '역삼초등학교 정문 앞', '02-777-7778', 'N', 'N');

-- BB_DECLARE
INSERT INTO BB_DECLARE (STORE_NUM, DECLARE_CONTENT)
values (7, '폐점 신고'),(7, '폐점 신고'),(7, '폐점 신고');

INSERT INTO bb_payment (MEMBER_NUM, PAYMENT_AMOUNT, PAYMENT_NAME, IMP_UUID)
VALUES (9, 10000, '10000 포인트 구매', 'e7a1c1bc-1c4e-4d84-8b95-9b2aaffffac0'),
       (10, 15000, '15000 포인트 구매', 'e0f25d5e-31bb-4f5d-a5e0-01c7fc3c7b20'),
       (11, 20000, '20000 포인트 구매', '3c8a31a1-ec45-4d41-b12f-e6a60c0c6c80'),
       (12, 25000, '25000 포인트 구매', 'bcb68c74-6a87-4b67-b51f-ecf69cc6e600'),
       (13, 30000, '30000 포인트 구매', '11d1c063-b46d-4937-91f1-5e5a3fdc9c6e'),
       (14, 35000, '35000 포인트 구매', '583abb30-5248-4db8-a5b1-80b69f7b3e5e'),
       (15, 40000, '40000 포인트 구매', '682da79c-50f4-4c64-b4b4-f7dc54f9a134'),
       (16, 45000, '45000 포인트 구매', 'e6f12b6c-bf46-4e5f-b5b8-cfd79ec9f4bb'),
       (9, 50000, '50000 포인트 구매', 'b3e3f12c-e9c1-47ee-b6af-e0b13eabcfb3'),
       (10, 55000, '55000 포인트 구매', 'd4ac2f54-fb3c-4f1e-9a8c-1b4f1cb74d00'),
       (11, 60000, '60000 포인트 구매', 'c8f50c02-86e1-4cde-88d5-8cdb22f3e47c'),
       (12, 65000, '65000 포인트 구매', '501eecc6-fec8-45a0-b3e0-efc1a0c7f3b6');


-- BB_POINT 샘플 데이터(충전, 상품 구매 TRIGGER)
INSERT INTO bb_point (MEMBER_NUM, POINT_PLUS, POINT_MINUS, POINT_CONTENT)
VALUES (9, 1000, NULL, '회원가입 보너스'),
       (10, 2000, NULL, '이벤트 당첨'),
       (11, 3000, NULL, '리뷰 작성 보너스'),
       (12, 4000, NULL, '출석 체크 보너스'),
       (13, 5000, NULL, '친구 추천 보너스'),
       (15, 6000, NULL, '이벤트 참여 보너스');
      
-- BB_STORE_MENU 샘플 데이터
INSERT INTO bb_store_menu (STORE_NUM, STORE_MENU_NORMAL, STORE_MENU_VEG, STORE_MENU_MINI, STORE_MENU_POTATO,
                           STORE_MENU_ICE, STORE_MENU_CHEESE, STORE_MENU_PASTRY, STORE_MENU_OTHER)
VALUES (1, 'Y', 'Y', 'N', 'Y', 'Y', 'Y', 'N', 'N'),
       (2, 'Y', 'N', 'Y', 'Y', 'N', 'Y', 'Y', 'N'),
       (3, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y'),
       (4, 'Y', 'Y', 'N', 'N', 'Y', 'Y', 'N', 'Y'),
       (5, 'Y', 'N', 'Y', 'Y', 'N', 'N', 'Y', 'N'),
       (6, 'Y', 'Y', 'Y', 'N', 'Y', 'Y', 'N', 'Y'),
       (7, 'Y', 'N', 'N', 'Y', 'Y', 'N', 'Y', 'N'),
       (8, 'Y', 'Y', 'Y', 'Y', 'N', 'Y', 'N', 'Y'),
       (9, 'Y', 'N', 'Y', 'N', 'Y', 'Y', 'Y', 'N'),
       (10, 'Y', 'Y', 'N', 'Y', 'Y', 'N', 'Y', 'Y'),
       (11, 'Y', 'N', 'Y', 'Y', 'N', 'Y', 'N', 'N'),
       (12, 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'Y');

-- BB_STORE_PAYMENT 샘플 데이터
INSERT INTO bb_store_payment (STORE_NUM, STORE_PAYMENT_CASHMONEY, STORE_PAYMENT_CARD, STORE_PAYMENT_ACCOUNT)
VALUES (1, 'Y', 'Y', 'N'),
       (2, 'Y', 'Y', 'Y'),
       (3, 'N', 'Y', 'Y'),
       (4, 'Y', 'Y', 'N'),
       (5, 'N', 'Y', 'Y'),
       (6, 'Y', 'Y', 'Y'),
       (7, 'Y', 'N', 'Y'),
       (8, 'N', 'Y', 'Y'),
       (9, 'Y', 'Y', 'N'),
       (10, 'Y', 'Y', 'Y'),
       (11, 'N', 'Y', 'Y'),
       (12, 'Y', 'Y', 'Y');

-- BB_STORE_WORK 샘플 데이터
INSERT INTO bb_store_work (STORE_NUM, STORE_WORK_WEEK, STORE_WORK_OPEN, STORE_WORK_CLOSE)
VALUES (1, 'MON', '2024-10-29 09:00:00', '2024-10-29 18:00:00'),
       (1, 'TUE', '2024-10-29 09:00:00', '2024-10-29 18:00:00'),
       (1, 'WED', '2024-10-29 09:00:00', '2024-10-29 18:00:00'),
       (2, 'MON', '2024-10-29 10:00:00', '2024-10-29 19:00:00'),
       (2, 'TUE', '2024-10-29 10:00:00', '2024-10-29 19:00:00'),
       (2, 'WED', '2024-10-29 10:00:00', '2024-10-29 19:00:00'),
       (3, 'THU', '2024-10-29 11:00:00', '2024-10-29 20:00:00'),
       (3, 'FRI', '2024-10-29 11:00:00', '2024-10-29 20:00:00'),
       (3, 'SAT', '2024-10-29 11:00:00', '2024-10-29 20:00:00'),
       (4, 'MON', '2024-10-29 08:00:00', '2024-10-29 17:00:00'),
       (4, 'TUE', '2024-10-29 08:00:00', '2024-10-29 17:00:00'),
       (5, 'WED', '2024-10-29 09:30:00', '2024-10-29 18:30:00'),
       (5, 'THU', '2024-10-29 09:30:00', '2024-10-29 18:30:00'),
       (6, 'FRI', '2024-10-29 10:30:00', '2024-10-29 19:30:00'),
       (6, 'SAT', '2024-10-29 10:30:00', '2024-10-29 19:30:00'),
       (7, 'SUN', '2024-10-29 12:00:00', '2024-10-29 21:00:00'),
       (8, 'MON', '2024-10-29 11:30:00', '2024-10-29 20:30:00'),
       (9, 'TUE', '2024-10-29 10:00:00', '2024-10-29 19:00:00'),
       (10, 'WED', '2024-10-29 09:00:00', '2024-10-29 18:00:00'),
       (10, 'THU', '2024-10-29 09:00:00', '2024-10-29 18:00:00'),
       (11, 'FRI', '2024-10-29 10:00:00','2024-10-29 19:00:00'),
       (11, 'SAT', '2024-10-29 10:00:00','2024-10-29 19:00:00'),
       (12, 'SUN', '2024-10-29 11:00:00','2024-10-29 20:00:00'),
       (12, 'MON', '2024-10-29 11:00:00','2024-10-29 20:00:00');

-- 게시글 카테고리 데이터
INSERT INTO bb_board_category (BOARD_CATEGORY_NUM, BOARD_CATEGORY_NAME)
VALUES (1, 'noticeBoard'),
       (2, 'boardList');

-- BB_BOARD 샘플 데이터
INSERT INTO bb_board (BOARD_TITLE, BOARD_CONTENT, BOARD_FOLDER, MEMBER_NUM, BOARD_OPEN, BOARD_DELETE, STORE_NUM)
VALUES ('맛있는 붕어빵 후기', '정말 맛있었어요! 특히 팥앙금이 일품이에요', '/uploads/review1', 9, 'Y', 'N', 1),
       ('붕어빵 맛집 발견', '여기 붕어빵이 최고예요. 크기도 크고 맛도 좋아요', '/uploads/review2', 10, 'Y', 'N', 2),
       ('신메뉴 출시했습니다', '치즈붕어빵 새로 나왔어요. 많이 찾아주세요!', '/uploads/notice1', 3, 'Y', 'N', 2),
       ('역삼역 최고의 붕어빵', '퇴근길에 항상 들러서 먹고 있어요', '/uploads/review3', 11, 'Y', 'N', 3),
       ('가격 인상 안내', '원재료 가격 상승으로 인한 가격 인상 안내드립니다', '/uploads/notice2', 4, 'Y', 'N', 4),
       ('크림붕어빵 맛집', '크림붕어빵 여기가 진짜예요!', '/uploads/review4', 12, 'Y', 'N', 5),
       ('휴무 안내', '내일 임시 휴무입니다', '/uploads/notice3', 5, 'Y', 'N', 5),
       ('붕어빵 시식 이벤트', '오늘 5시부터 신메뉴 무료 시식회 있습니다', '/uploads/event1', 6, 'Y', 'N', 6),
       ('대박맛집 인증', '정말 맛있어서 재방문했어요', '/uploads/review5', 13, 'Y', 'N', 7),
       ('영업시간 변경 안내', '다음 주부터 영업시간이 변경됩니다', '/uploads/notice4', 7, 'Y', 'N', 8),
       ('붕어빵 최고!', '여기 붕어빵 강추합니다', '/uploads/review6', 14, 'Y', 'N', 9),
       ('이번주 할인 이벤트', '금주 전 메뉴 20% 할인합니다', '/uploads/event2', 8, 'Y', 'N', 10),
       ('맛있는 붕어빵 인증', '너무 맛있어서 후기 남깁니다', '/uploads/review7', 15, 'Y', 'N', 11),
       ('신메뉴 투표해주세요', '다음 신메뉴 설문조사 이벤트', '/uploads/event3', 3, 'Y', 'N', 12),
       ('직접 만든 팥앙금', '팥앙금을 직접 만들어서 더 맛있어요', '/uploads/review8', 16, 'Y', 'N', 1),
       ('가게 이전 안내', '다음달부터 이전된 장소에서 영업합니다', '/uploads/notice5', 4, 'Y', 'N', 2);

-- BB_LIKE 샘플 데이터
INSERT INTO bb_like (BOARD_NUM, MEMBER_NUM)
VALUES (1, 10),
       (1, 11),
       (1, 12),
       (2, 9),
       (2, 11),
       (2, 12),
       (3, 9),
       (3, 10),
       (3, 12),
       (4, 9),
       (4, 10),
       (4, 11),
       (5, 13),
       (5, 14),
       (5, 15),
       (6, 13),
       (6, 14),
       (6, 16),
       (7, 9),
       (7, 10),
       (8, 11),
       (8, 12),
       (9, 13),
       (9, 14);

-- BB_ORDER 샘플 데이터
 INSERT INTO bb_order (MEMBER_NUM, PRODUCT_NUM, ORDER_STATUS)
 VALUES (9, 1, 'Y'),
       (10, 2, 'N'),
        (11, 3, 'N'),
        (12, 3, 'N'),
        (13, 10, 'Y'),
        (14, 5, 'N'),
        (15, 1, 'N'),
        (16, 3, 'N'),
        (9, 7, 'Y'),
        (10, 9, 'Y'),
        (11, 8, 'N'),
        (12, 4, 'N'),
       (13, 1, 'Y'),
       (14, 2, 'Y'),
        (15, 3, 'N'),
        (16, 1, 'Y');

-- BB_REPLY 샘플 데이터
INSERT INTO bb_reply (REPLY_CONTENT, MEMBER_NUM, BOARD_NUM)
VALUES ('저도 가보고 싶네요!', 10, 1),
       ('맛있어 보이네요~', 9, 2),
       ('기대됩니다!!', 11, 3),
       ('저도 자주 가는 곳이에요', 12, 4),
       ('가격이 올라도 맛있으면 괜찮아요', 13, 5),
       ('크림붕어빵 진짜 맛있어요', 14, 6),
       ('아쉽네요ㅠㅠ', 15, 7),
       ('시식회 꼭 가볼게요!', 16, 8),
       ('저도 동의합니다', 9, 9),
       ('영업시간 참고할게요', 10, 10),
       ('주말에 가보려구요', 11, 11),
       ('할인 소식 감사합니다', 12, 12),
       ('사진이 너무 맛있어보여요', 13, 13),
       ('투표 참여했습니다', 14, 14),
       ('팥앙금이 특히 맛있었어요', 15, 15),
       ('새로운 위치도 기대되네요', 16, 16),
       ('오늘 저녁에 가보려구요!', 9, 1),
       ('이번 주말에 꼭 가봐야겠어요', 10, 2),
       ('신메뉴 먹어보고 싶네요', 11, 3),
       ('역시 맛집이죠!!', 12, 4);



