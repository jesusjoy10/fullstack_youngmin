--008_object.sql

--1. 시퀀스 : 자동번호 생성기 ★
--2. 뷰    : 가상테이블 (select 문 결과를 저장한 객체) ★
--3. 동의어 : 객체에 대한 별칭
--4. 인덱스 : 검색성능향상 ★
--5. 클러스터: 여러테이블을 물리적으로 같은 공간에 저장

-----------------------------------------------------
--1. 시퀀스 : 자동번호생성기 ★
-----------------------------------------------------
create sequence emp_seq; -- 시작1, 증가단위 1 , 10^27
create sequence dept_seq;

create sequence emp_seq2;
start with 1000 -- 시퀀스 시작값
increment by 1  -- 몇개씩증가?
maxvalue 9999   -- 최대값까지 지정가능
nocache;        -- 메모리에 미리 몇개 값 저장둘지...

-- #1. 시퀀스 만들기
select emp_seq.NEXTVAL from dual;
select dept_seq.nextval from dual;

select table_name from user_table;
desc dept_temp;

insert into dept_temp values(dept_seq.nextval, 'ai' , 'INCHEON');
select * from dept_temp;

--Q  appuser_seq 시퀀스 만들기
desc appuser;
create sequence appuser_seq; 

alter table appuser modify email varchar2(100) unique; --유일한 값

SELECT table_name, constraint_name, column_name
FROM user_cons_columns
WHERE constraint_name IN (
  SELECT constraint_name
  FROM user_constraints
  WHERE constraint_type = 'U'
);

delete * from appuser;

select table_name from user_tables;

SELECT sequence_name FROM user_sequences WHERE sequence_name = 'APPUSER_SEQ';




