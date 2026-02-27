-- 테스트용 질문 데이터 하나 넣어보기
INSERT INTO RECIPE_QUESTIONS (Q_ID, STEP_NO, TITLE, DESCRIPTION)
VALUES (seq_rec_q.NEXTVAL, 1, '어떤 식사를 원하시나요?', '오늘의 첫 끼니를 골라보세요.');

COMMIT;




-- 추천 질문 테이블	
CREATE TABLE RECIPE_QUESTIONS (	
Q_ID        NUMBER PRIMARY KEY,	
STEP_NO     NUMBER NOT NULL,      -- 1, 2, 3, 4 순서	
TITLE       VARCHAR2(255) NOT NULL, -- 질문 (예: 어떤 식사를 원하시나요?)	
DESCRIPTION VARCHAR2(500),         -- 설명	
 NEXT_STEP   NUMBER,                 -- 클릭 시 이동할 다음 STEP_NO
CREATED_AT  DATE DEFAULT SYSDATE	
);	


	
-- 추천 선택지 테이블	
CREATE TABLE RECIPE_OPTIONS (	
OPT_ID      NUMBER PRIMARY KEY,	
Q_ID        NUMBER NOT NULL,	
OPT_LABEL   VARCHAR2(100) NOT NULL, -- 화면 표시 (예: 아침 식사)	
OPT_VALUE   VARCHAR2(100) NOT NULL, -- 로직용 값 (예: BREAKFAST)	
FOREIGN KEY (Q_ID) REFERENCES RECIPE_QUESTIONS(Q_ID) ON DELETE CASCADE	
);	
	
CREATE SEQUENCE seq_rec_q START WITH 1 INCREMENT BY 1;	
CREATE SEQUENCE seq_rec_opt START WITH 1 INCREMENT BY 1;	
	
	
-- 레시피-선택지 매핑 테이블	
CREATE TABLE RECIPE_TAG_MAP (	
MAP_ID      NUMBER PRIMARY KEY,	
RECIPE_ID   NUMBER NOT NULL,	
OPT_VALUE   VARCHAR2(100) NOT NULL, -- 'BREAKFAST', 'KOREAN' 등	
FOREIGN KEY (RECIPE_ID) REFERENCES RECIPES3(RECIPE_ID) ON DELETE CASCADE	
);	
	
CREATE SEQUENCE seq_rec_tag_map START WITH 1 INCREMENT BY 1;	
	
	
-- 사용자 추천 로그 테이블	
CREATE TABLE RECIPE_SURVEY_LOG (	
LOG_ID      NUMBER PRIMARY KEY,	
APPUSERID   NUMBER NOT NULL,	
SELECTED_OPTS VARCHAR2(1000),     -- 선택한 옵션들 (JSON이나 콤마 구분자)	
RESULT_COUNT  NUMBER,             -- 당시 추천된 레시피 개수	
CREATED_AT  DATE DEFAULT SYSDATE,	
FOREIGN KEY (APPUSERID) REFERENCES BUG3(APPUSERID) ON DELETE CASCADE	
);	
	
CREATE SEQUENCE seq_rec_survey_log START WITH 1 INCREMENT BY 1;	


SELECT * FROM RECIPE_QUESTIONS;

-- 기존에 만드신 OPT_LABEL, OPT_VALUE 컬럼명에 맞춰서 넣기
INSERT INTO RECIPE_OPTIONS (OPT_ID, Q_ID, OPT_LABEL, OPT_VALUE)
VALUES (seq_rec_opt.NEXTVAL, 1, '아침 식사', 'BREAKFAST');

INSERT INTO RECIPE_OPTIONS (OPT_ID, Q_ID, OPT_LABEL, OPT_VALUE)
VALUES (seq_rec_opt.NEXTVAL, 1, '점심 식사', 'LUNCH');

INSERT INTO RECIPE_OPTIONS (OPT_ID, Q_ID, OPT_LABEL, OPT_VALUE)
VALUES (seq_rec_opt.NEXTVAL, 1, '저녁 식사', 'DINNER');

INSERT INTO RECIPE_OPTIONS (OPT_ID, Q_ID, OPT_LABEL, OPT_VALUE)
VALUES (seq_rec_opt.NEXTVAL, 1, '간식/디저트', 'DESSERT');

DELETE FROM RECIPE_OPTIONS WHERE OPT_LABEL IN ('간단한 아침', '든든한 점심', '특별한 저녁');
COMMIT;

COMMIT;

ALTER TABLE RECIPE_OPTIONS ADD NEXT_STEP NUMBER;
COMMIT;


CREATE TABLE MY_RECIPE (  -- 이름을 MY_RECIPE로 변경
    id NUMBER PRIMARY KEY,
    title VARCHAR2(100),
    category VARCHAR2(50),
    image VARCHAR2(500)
);


-- 테이블 이름이 RECIPE라면 (만약 이름을 바꾸셨다면 바꾼 이름으로!)
INSERT INTO MY_RECIPE (id, title, category, image) 
VALUES (1, '얼큰한 김치찌개', '한식', 'https://images.unsplash.com/photo-1583177724763-800124a3f399?w=300');

INSERT INTO MY_RECIPE (id, title, category, image) 
VALUES (2, '바삭한 돈카츠', '일식', 'https://images.unsplash.com/photo-1591814441348-268e64812566?w=300');

-- ⭐️ 중요: 반드시 COMMIT을 해야 스프링이 데이터를 읽어갈 수 있습니다!
COMMIT;

-- 예시: 실제 요리 사진 주소로 업데이트
UPDATE MY_RECIPE 
SET image = 'https://images.unsplash.com/photo-1583177724763-800124a3f399?w=400'
WHERE id = 1;

COMMIT; -- 👈 잊지 마세요!


UPDATE MY_RECIPE 
SET image = 'https://via.placeholder.com/300' 
WHERE id = 1;

COMMIT;

-- 테스트용 이미지 (이 주소는 보통 잘 허용됩니다)
UPDATE MY_RECIPE 
SET image = 'https://picsum.photos/300/200' 
WHERE id = 1;

COMMIT;


-- 1번 유저가 올린 '한식(2)', '30분', '쉬움' 레시피
INSERT INTO RECIPES3 (RECIPE_ID, APPUSERID, TITLE, CATEGORY, COOK_TIME, DIFFICULTY, IMAGE)
VALUES (seq_recipe3.NEXTVAL, 1, '디자인 시안 김치찌개', 2, 30, '쉬움', 'https://picsum.photos/300/200');

COMMIT;

SELECT IMAGE FROM RECIPES3;

-- 1. 테이블의 모든 데이터를 삭제 (구조는 유지)
TRUNCATE TABLE POSTS;

-- 2. 혹시 모르니 커밋도 한 번 해주세요 (오라클 환경에 따라)
COMMIT;



-- 1. 관계 테이블 및 하위 테이블 삭제
DROP TABLE POST_HASHTAG;
DROP TABLE POST_LIKES;   -- 엔티티에 PostLike가 있다면 삭제
DROP TABLE COMMENTS;     -- 엔티티에 Comment가 있다면 삭제
DROP TABLE IMAGES;       -- 엔티티에 Image가 있다면 삭제
DROP TABLE RETWEETS;     -- 엔티티에 Retweet이 있다면 삭제

-- 2. 메인 테이블 삭제
DROP TABLE POSTS CASCADE CONSTRAINTS;

-- 3. 시퀀스 삭제 (깔끔하게 1번부터 다시 시작하기 위함)
DROP SEQUENCE post_seq;