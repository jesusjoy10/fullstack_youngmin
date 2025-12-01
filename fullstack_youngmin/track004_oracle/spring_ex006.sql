desc appuser;
-- create : 회원가입(시퀀스이용)
insert into appuser (App_USER_ID, EMAIL, PASSWORD, MBTI_TYPE_ID)
values (appuser_seq.nextval,'a@a','1111',1);

-- read : 로그인(이메일과 비번이 같으면 로그인), 마이페이지 (세션이용), 전체 유저확인
select count(*) cnt from appuser where email='a@a' and PASSWORD='1111';
select * from appuser order by app_user_id desc;
select * from  appuser where app_user_id=21;

-- update : 마이페이지 정보수정 (mbti와 비밀번호 수정할 수 있게)
update appuser set password='1234', MBTI_TYPE_ID=2 where app_user_id=43;

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


select * 
from (select  row_number() over(order by created_at desc) as rnum,
id, app_user_id, btitle, bcontent,bpass, bfile, bip,bhit,created_at from sboard1) A
where A.rnum between 1 and 10;

SELECT COUNT(*) FROM sboard1;

SHOW USER;

DESC sboard1;




SELECT table_name FROM user_tables;

CREATE TABLE authorities (
    email VARCHAR2(50),
    auth VARCHAR2(30)
);
