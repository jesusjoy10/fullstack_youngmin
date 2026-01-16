desc appuser;
-- create : 회원가입(시퀀스이용)
insert into appuser (App_USER_ID, EMAIL, PASSWORD, region)
values (appuser_seq.nextval,'a@a','1111','서울');

-- read : 로그인(이메일과 비번이 같으면 로그인), 마이페이지 (세션이용), 전체 유저확인
select count(*) cnt from appuser where email='a@a' and PASSWORD='1111';
select * from appuser order by app_user_id desc;
select * from  appuser where app_user_id=21;

-- update : 마이페이지 정보수정 (mbti와 비밀번호 수정할 수 있게)
update appuser set password='1234', region = '인천' where app_user_id=43;

-- delete : 탈퇴
delete from appuser where app_user_id=43 and password='1234';

ALTER TABLE appuser ADD UFILE VARCHAR2(255);

desc sboard1;

desc emp;

select count(*) from sboard1;

insert into sboard1(ID, APP_USER_ID, btitle , bcontent, bpass, bfile, bip)
select sboard1_seq.nextval, APP_USER_ID, btitle , bcontent, bpass, bfile, bip from sboard1;

SELECT COUNT(*) FROM sboard1;

delete FROM sboard1;
commit;


select * 
from (select  row_number() over(order by created_at desc) as rnum,
id, app_user_id, btitle, bcontent,bpass, bfile, bip,bhit,created_at from sboard1) A
where A.rnum between 1 and 10;

SELECT COUNT(*) FROM sboard1;

SHOW USER;

DESC appuser;
ALTER TABLE appuser ADD MBTI_TYPE_ID NUMBER(3);

-- 휴대폰 번호 컬럼 추가
ALTER TABLE appuser 
  ADD mobile VARCHAR2(50);

-- 닉네임 컬럼 추가
ALTER TABLE appuser 
  ADD nickname VARCHAR2(50);


delete from appuser;
commit;





SELECT table_name FROM user_tables;

CREATE TABLE authorities (
    email VARCHAR2(50),
    auth VARCHAR2(30)
);


ALTER TABLE appuser DROP COLUMN mbti_type_id;

ALTER TABLE appuser ADD region VARCHAR2(50);

SELECT app_user_id, email, password, region, created_at, ufile
FROM appuser
ORDER BY app_user_id DESC;

SELECT app_user_id, email, region FROM appuser;




CREATE TABLE SBOARD2 (
    ID          NUMBER       PRIMARY KEY,
    APP_USER_ID NUMBER       NOT NULL,
    BTITLE      VARCHAR2(1000) NOT NULL,
    BCONTENT    CLOB         NOT NULL,
    BPASS       VARCHAR2(255) NOT NULL,
    BFILE       VARCHAR2(255),
    BHIT        NUMBER DEFAULT 0,
    BIP         VARCHAR2(255) NOT NULL,
    CREATED_AT  DATE default sysdate
);

CREATE SEQUENCE SBOARD2_SEQ;
DESC sboard2;

delete from sboard2;

commit;

drop sequence sboard2_seq;

create sequence sboard2_seq;

insert into sboard2 ( ID    , APP_USER_ID , btitle, bcontent, bpass, bfile,  bip )
select  sboard2_seq.nextval , APP_USER_ID , btitle, bcontent, bpass, bfile,  bip   from sboard2;

commit;


DESC appuser;SELECT table_name 
FROM user_tables 
WHERE table_name = 'SBOARD2';



ALTER TABLE appuser ADD PROVIDER VARCHAR2(50);

ALTER TABLE "APPUSER" ADD ("PROVIDER_ID" VARCHAR2(100));

desc authorities;


ALTER TABLE authorities
MODIFY (
    EMAIL       VARCHAR2(255),
    AUTH        VARCHAR2(255),
    AUTH_ID     NUMBER(5),
    APP_USER_ID NUMBER(5)
);

  
CREATE SEQUENCE authorities_seq;


desc appuser;
DROP table REGION  ;

ALTER TABLE appuser
DROP COLUMN REGION;

ALTER TABLE authorities
MODIFY (
    AUTH_ID NUMBER(5) NOT NULL,
    AUTH    VARCHAR2(255) NOT NULL
);


DROP TABLE authorities CASCADE CONSTRAINTS;

CREATE TABLE authorities (
    EMAIL        VARCHAR2(255)  ,
    AUTH         VARCHAR2(255)   NOT NULL,
    AUTH_ID      NUMBER(5)       NOT NULL,
    APP_USER_ID  NUMBER(5)      
);


select * from appuser;

delete from appuser;
delete from authorities;
commit;


SELECT constraint_name, column_name
FROM user_cons_columns
WHERE table_name = 'APPUSER';

SELECT EMAIL, COUNT(*)
FROM APPUSER
GROUP BY EMAIL
HAVING COUNT(*) > 1;

ALTER TABLE APPUSER ADD CONSTRAINT uq_appuser_email UNIQUE (EMAIL);

DELETE FROM APPUSER WHERE EMAIL = '1@1';

ALTER TABLE APPUSER DROP CONSTRAINT uq_appuser_email;


