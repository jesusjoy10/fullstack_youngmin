#### 포트폴리오

※ API 사용
1. 주제
2. 주요역할(CRUD) : API 이용해서 번뜩이는 아이디어
---
3. 흐름도
4. 피그마
5. ERD
 1) 주요기능 - api
 2) 기능 또는 api 맞춰서 테이블(상담)
  create
  read
  update
  delete

6. 개발
- MODEL  (자동테스트)
- SERVICE (자동테스트)
- CONTROLLER 


#8. api






리뷰 댓글

1. 악성댓글/비속어 자동 판별 (모더레이션)
2. 평점 집계 API
4. 맞춤법/문장 교정은 주의
6. 영양성분 API 
7. 제철 재료 API (계절성)
8. 주간 식단(플래너) API
9. 트렌드 및 반응 기반 추천(급상승)
10. 장보기 리스트 + 가격비교/재고/대체품 추천
11. 배달/주문 대체 추천(배달 플랫폼/가맹점)
12. 알림/메시징(재방문 유도)
13. 농산물 유통 가격 API
14. 재료명 기반 검색 URL API (쿠팡)
15. 전체 데이터에서 키워드 검색
16. 유튜브 요리 리뷰 영상 연동 (텍스트 리뷰 보완)
17. 리뷰 요약 API (많은 리뷰를 3줄로)
18. 번역 API (해외 유입/다국어 리뷰)



사용자 : 4, 10, 12
레시피 : 1, 15, 16
추천 : 8, 9, 11
재료 : 6, 7, 13, 14
리뷰 : 2, 17, 18


2. 평점 집계 API
- 외부 API 없음 → 내부 DB 집계로 직접 구현해야 함
- 기술: MySQL/PostgreSQL/Oracle + Redis 캐시


17. 리뷰 요약 API (많은 리뷰를 3줄로) 
- API =  OpenAI API 
- 예시 엔드포인트: GET /reviews/summary/{foodId}

18. 번역 API (해외 유입/다국어 리뷰)
-  API = NAVER Papago NMT

 “리뷰 파트는 내부 집계 API + 외부 AI API(요약, 번역)까지 연동해서 기본 + 차별화 기능을 동시에 제공

[Review 테이블]

review_id    INT PK        -- 리뷰 고유 ID
food_id      INT FK        -- 음식 ID (Foods 테이블 참조)
user_id      INT FK        -- 작성자 ID (Users 테이블 참조)
rating       INT           -- 평점 (1~5)
comment      TEXT          -- 리뷰 내용
created_at   DATETIME      -- 작성일
updated_at   DATETIME      -- 수정일


[ReviewSummary 테이블]  (평점 집계용 캐시)

food_id      INT PK        -- 음식 ID
avg_rating   FLOAT         -- 평균 평점
review_count INT           -- 리뷰 개수
distribution JSON          -- 평점 분포 (예: {"1":2,"2":5,"3":10,"4":20,"5":30})
updated_at   DATETIME      -- 마지막 업데이트 시간


[Comment 테이블]

comment_id   INT PK        -- 댓글 고유 ID
review_id    INT FK        -- 연결된 리뷰 ID (Review 테이블 참조)
user_id      INT FK        -- 작성자 ID (User 테이블 참조)
content      TEXT          -- 댓글 내용
created_at   DATETIME      -- 작성일
updated_at   DATETIME      -- 수정일
status       VARCHAR(20)   -- 상태 (active, deleted, reported 등)
parent_id    INT FK NULL   -- 대댓글일 경우 상위 댓글 ID (자기 참조)



C : 리뷰 작성 / 저장
R : 리뷰 조회 / 기록 확인  
U : 리뷰 수정 / 피드백 변경
D : 리뷰 삭제 / 오래된 기록 제거



[리뷰 CRUD 설계 - 사용자(User)]

Create:
- POST /reviews
- 음식에 대한 리뷰 작성 (foodId, userId, rating, comment)

Read:
- GET /reviews/{foodId}
- 특정 음식의 리뷰 목록 조회 + 평균 평점, 리뷰 개수
- GET /reviews/user/{userId}
- 내가 작성한 리뷰 기록 조회

Update:
- PUT /reviews/{reviewId}
- 본인이 작성한 리뷰 수정 (rating, comment 변경)

Delete:
- DELETE /reviews/{reviewId}
- 본인이 작성한 리뷰 삭제


[리뷰 CRUD 설계 - 관리자(Admin)]

Create:
- (관리자는 직접 리뷰 작성하지 않음)

Read:
- GET /admin/reviews
- 전체 리뷰 목록 조회 (필터: foodId, userId, 기간 등)

Update:
- PUT /admin/reviews/{reviewId}
- 리뷰 내용 수정 가능 (비속어/악성댓글 교정, 모더레이션 목적)

Delete:
- x



[댓글 CRUD 설계 - 사용자(User)]

Create:
- POST /reviews/{reviewId}/comments
- 특정 리뷰에 댓글 작성 (userId, content)

Read:
- GET /reviews/{reviewId}/comments
- 특정 리뷰에 달린 댓글 목록 조회

Update:
- PUT /reviews/{reviewId}/comments/{commentId}
- 본인이 작성한 댓글 수정

Delete:
- DELETE /reviews/{reviewId}/comments/{commentId}
- 본인이 작성한 댓글 삭제


[댓글 CRUD 설계 - 관리자(Admin)]

Create:
- (관리자는 직접 댓글 작성하지 않음)

Read:
- GET /admin/comments
- 전체 댓글 목록 조회 (필터: reviewId, userId, 기간 등)

Update:
- x

Delete:
- DELETE /admin/comments/{commentId}
- 모든 댓글 삭제 가능 (운영 정책 위반, 신고 처리)


## 피그마

[리뷰 목록 조회]
 ├─ 전체 리뷰 조회
 ├─ 최신순 / 평점순 정렬
 ├─ 리뷰 개수 표시
 └─ 평균 평점 계산


 [리뷰 작성 버튼 클릭]
 ├─ 비로그인 → 로그인 페이지 이동
 └─ 로그인
      ├─ 기존 리뷰 없음 → 리뷰 작성 페이지
      └─ 기존 리뷰 있음 → "이미 작성한 리뷰가 있습니다"

      [리뷰 작성]
 ├─ 별점 선택 (필수)
 ├─ 리뷰 내용 입력 (필수)
 ├─ 등록 버튼
 └─ 취소 → 리뷰 목록

 [리뷰 수정/삭제]
 ├─ 작성자 본인
 │    ├─ 수정 가능
 │    └─ 삭제 가능
 └─ 타인 → 버튼 미노출


[댓글 조회]
 ├─ 리뷰별 댓글 조회
 ├─ 댓글 개수 표시
 └─ 최신순 정렬

[댓글 입력]
 ├─ 비로그인 → 로그인 필요 안내
 └─ 로그인
      ├─ 내용 입력
      └─ 등록

[댓글 수정/삭제]
 ├─ 작성자 본인
 │    ├─ 수정 가능
 │    └─ 삭제 가능
 └─ 타인 → 버튼 미노출

