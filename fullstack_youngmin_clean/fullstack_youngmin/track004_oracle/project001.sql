CREATE TABLE users (
    id          VARCHAR2(30)     PRIMARY KEY,                 -- 사용자 고유 ID
    password    VARCHAR2(100)    NOT NULL,                -- 비밀번호 (암호화 저장)
    nickname    VARCHAR2(50)     NOT NULL,                -- 닉네임
    email         VARCHAR2(100)    UNIQUE,                      -- 이메일 (로그인용)
    mobile      VARCHAR2(20)    UNIQUE,                      -- 이메일 (로그인용)
    joinDate   DATE            DEFAULT SYSDATE               -- 가입일   ###
);

CREATE TABLE FOOD_TB (
    foodId          NUMBER(6)        PRIMARY KEY,       -- 음식 고유번호 (PK)
    name            VARCHAR2(100)    NOT NULL,          -- 음식명
    categoryId      NUMBER(3),                          -- 음식 카테고리 (1,2,3,4,5)
    kcal            NUMBER(5),                          -- 칼로리
    protein         NUMBER(5,1),                        -- 단백질(g)
    carb            NUMBER(5,1),                        -- 탄수화물(g)
    fat             NUMBER(5,1),                        -- 지방(g)
    recipe          CLOB,                               -- 음식 설명 (긴 텍스트)
    imageUrl        VARCHAR2(200),                      -- 음식 이미지 경로 
    regDate         DATE             DEFAULT SYSDATE,    -- 등록일 
    FOREIGN KEY (categoryId) REFERENCES CATEGORY_TB(categoryId)
);
--CREATE TABLE RECOMMEND_TB ( recId NUMBER(8) PRIMARY KEY,        -- 추천 고유번호
--id VARCHAR2(30) NOT NULL,       -- 사용자 ID foodId NUMBER(6) ,          -- 추천된 음식, 아직 확정되지않아 NULL가능으로 만듦. type VARCHAR2(30) NOT NULL,         -- 추천 유형 (선호식단, AI, 재료기반) feedback VARCHAR2(200),             -- AI 피드백 (예: 단백질 부족)
--createdAt DATE DEFAULT SYSDATE,      -- 추천 일시
--FOREIGN KEY (id) REFERENCES users(id), FOREIGN KEY (foodId) REFERENCES FOOD_TB(foodId)
--);

CREATE TABLE RECOMMEND_TB (
    tableId NUMBER PRIMARY KEY,        -- 추천 고유번호  
    id NUMBER NOT NULL,       -- 사용자 ID
    foodId NUMBER ,          -- 추천된 음식, 아직 확정되지않아 NULL가능으로 만듦.
    type VARCHAR2(30) NOT NULL,         -- 추천 유형 (선호식단, AI, 재료기반)
    feedback VARCHAR2(200),             -- AI 피드백 (예: 단백질 부족)   
    createdAt DATE DEFAULT SYSDATE,      -- 추천 일시  
    FOREIGN KEY (id) REFERENCES users(id),
    FOREIGN KEY (foodId) REFERENCES FOOD_TB(foodId)        
);
create sequence RECOMMEND_TB_seq;

SELECT * FROM RECOMMEND_TB where id ='user01';

CREATE TABLE COMMUNITY_TB (
    postId      NUMBER(8) PRIMARY KEY,      -- 게시글 ID
    id      VARCHAR2(30) NOT NULL,      -- 작성자
    title        VARCHAR2(200) NOT NULL,    -- 제목
    content      CLOB NOT NULL,             -- 본문
    categoryId  NUMBER(3) NOT NULL,           -- 카테고리 번호
    views        NUMBER(6) DEFAULT 0,       -- 조회수
    createdAt   DATE DEFAULT SYSDATE,       -- 작성일
    updatedAt   DATE,                       -- 수정일
    FOREIGN KEY (id) REFERENCES users(id),
    FOREIGN KEY (categoryId) REFERENCES CATEGORY_TB(categoryId)
);



CREATE TABLE CATEGORY_TB (
    categoryId   NUMBER(3)       PRIMARY KEY,   -- 카테고리 ID
    categoryName VARCHAR2(50)    NOT NULL       -- 카테고리명 (예: 한식, 양식, 중식, 일식)
);

INSERT INTO CATEGORY_TB (categoryId, categoryName)
VALUES (1, '샐러드');


-- 사용자 추가
INSERT INTO users (id, password, nickname, email, mobile)
VALUES ('user01', '1234', '홍길동', 'user01@example.com', '01012345678');

-- 음식 추가
INSERT INTO FOOD_TB (foodId, name, categoryId, kcal, protein, carb, fat, recipe, imageUrl)
VALUES (100001, '닭가슴살 샐러드', 1, 250, 30.5, 10.0, 5.0, '닭가슴살과 채소를 섞어 만든 샐러드입니다.', 'salad.jpg');

COMMIT;

INSERT INTO RECOMMEND_TB (recId, id, foodId, type, feedback)
VALUES (1, 'user01', 100001, 'AI', '단백질이 부족합니다');

COMMIT;

SELECT * FROM RECOMMEND_TB;

SELECT * FROM RECOMMEND_TB WHERE id = 'user01';


------------------------------------------------------------------------
INSERT INTO Recommend_tb (recId, id, foodId, type, feedback)  
VALUES (RECOMMEND_TB_seq.nextval, 1, 100001, '한식', '단백질부족' );

SELECT * FROM Recommend_tb order BY createdAt desc;

SELECT * FROM Recommend_tb where id = 'user01' ;

DELETE  FROM Recommend_tb where recId = 5;
--SELECT * FROM Recommend_tb WHERE recId = 4 AND id = 'user01';
------------------------------------------------------------------------

desc RECOMMEND_TB;



/*
이름        널?       유형            
--------- -------- ------------- 
RECID     NOT NULL NUMBER(8)     
ID        NOT NULL VARCHAR2(30)  
FOODID             NUMBER(6)     
TYPE      NOT NULL VARCHAR2(30)  
FEEDBACK           VARCHAR2(200) 
CREATEDAT          DATE 
*/



desc COMMUNITY_TB;

------------------------------------------------------------------------
```sql

CREATE TABLE COMMUNITY_TB (
    postId      NUMBER(8) PRIMARY KEY,      -- 게시글 ID
    id           NUMBER(30) NOT NULL,      -- 작성자
    title        VARCHAR2(200) NOT NULL,    -- 제목
    content      CLOB NOT NULL,             -- 본문
    categoryId  NUMBER(3) NOT NULL,           -- 카테고리 번호
    views        NUMBER(6) DEFAULT 0,       -- 조회수
    createdAt   DATE DEFAULT SYSDATE,       -- 작성일
    updatedAt   DATE DEFAULT SYSDATE,                       -- 수정일
    FOREIGN KEY (id) REFERENCES users(APPUSERID),
    FOREIGN KEY (categoryId) REFERENCES CATEGORY_TB(categoryId)
);

select * from users;
create sequence COMMUNITY_TB_seq;

```

INSERT INTO COMMUNITY_TB (
    postId,
    id,
    title,
    content,
    categoryId,
    views,
    createdAt,
    updatedAt
) VALUES (
    1,               -- postId (NUMBER)
    1,               -- id (NUMBER, users.id 외래키)
    '테스트 제목',    -- title (VARCHAR2)
    '테스트 내용',    -- content (CLOB)
    1,               -- categoryId (NUMBER, CATEGORY_TB 외래키)
    0,               -- views (NUMBER)
    SYSDATE,         -- createdAt (DATE)
    SYSDATE          -- updatedAt (DATE)
);

commit;

===

CREATE TABLE CATEGORY_TB (
    categoryId   NUMBER(3)       PRIMARY KEY,   -- 카테고리 ID
    categoryName VARCHAR2(50)    NOT NULL       -- 카테고리명 (예: 한식, 양식, 중식, 일식)
);

CREATE TABLE users (
    APPUSERID         NUMBER(8)     PRIMARY KEY,                 -- 사용자 고유 ID
    password    VARCHAR2(100)    NOT NULL,                -- 비밀번호 (암호화 저장)
    nickname    VARCHAR2(50)     NOT NULL,                -- 닉네임
    email         VARCHAR2(100)    UNIQUE,                      -- 이메일 (로그인용)
    mobile      VARCHAR2(20)    UNIQUE,                      -- 이메일 (로그인용)
    joinDate   DATE            DEFAULT SYSDATE               -- 가입일   ###
);

INSERT INTO users (APPUSERID, password, nickname, email, mobile,joinDate)
VALUES (1, '1234', '테스트유저', 'test@example.com', '010-1234-5678','');

------------------------------------------------------------------------

DROP TABLE RECOMMEND_TB;




------------------------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE RECOMMEND_TB (
    tableId     NUMBER PRIMARY KEY,           -- 추천 고유번호
    id          NUMBER NOT NULL,              -- 사용자 ID 
    foodId      NUMBER,                       -- 추천된 음식 ID (nullable)
    type        VARCHAR2(30) NOT NULL,        -- 추천 유형 (예: AI, 선호식단)
    category    VARCHAR2(30),                 -- 음식 대분류 (한식, 양식 등)
    kind        VARCHAR2(30),                 -- 음식 종류 (육류, 해산물 등)
    method      VARCHAR2(30),                 -- 조리 방식 (볶음, 구이 등)
    feedback    VARCHAR2(200),                -- AI 피드백
    createdAt   DATE DEFAULT SYSDATE,         -- 추천 일시

    FOREIGN KEY (id) REFERENCES USERS(id),       -- 사용자 테이블 참조
    FOREIGN KEY (foodId) REFERENCES FOOD_TB(foodId) -- 음식 테이블 참조
);



CREATE SEQUENCE RECOMMEND_TB_SEQ START WITH 1 INCREMENT BY 1;

INSERT INTO RECOMMEND_TB (
    tableId, id, foodId, type, category, kind, method, feedback
) VALUES (
    RECOMMEND_TB_SEQ.NEXTVAL, 101, 100001, 'AI', '한식', '육류', '구이', '단백질 부족'
);
------------------------------------------------------------------------------------------------------------------------------------------------

SELECT * FROM RECOMMEND_TB ORDER BY CREATEDAT DESC;


INSERT INTO RECOMMEND_TB (tableId, id, foodId, type, category, kind, method, feedback, createdAt)
VALUES (RECOMMEND_TB_seq.nextval, 1, 1001, 'AI', '한식', '육류', '구이', '단백질 부족', SYSDATE);
SELECT * FROM RECOMMEND_TB ORDER BY CREATEDAT DESC;







SELECT sequence_name, last_number
FROM user_sequences
WHERE sequence_name = 'RECOMMEND_TB_SEQ';

