--007_ddl_dml_tx_user.sql

-- ★ 데이터 베이스언어 
-- crud     (          create,        read ,         update,         delete)
-- 1. dml 조작어(데이터) insert(삽입)   select(조회)    update(수정)     delete(지우기)  → CRUD
-- 2. ddl 정의어(구조) create(만들기)  alter(테이블수정) drop(삭제:복구안됨) →CAD
-- 3. dcl 제어어(접근권한) grant(주세요), revoke(권한빼기)
-- 4. tcl 제어어(트랜잭션)  commit(반영), rollback(되돌리기), savepoint(지점)

------------------------------------------------------------------------------------------
-- 1. dml 조작어(데이터) ■insert(삽입)   select(조회)    update(수정)     delete(지우기)  → CRUD

-- #1. 테이블 복사해오기
create table dept_temp as select * from dept; 
desc dept_temp;
select *from dept_temp;

-- #2. insert
-- insert into 테이블명 (필드1, 필드2,,,) valuse (값1, 값2,,,)

insert  into dept_temp (  deptno, dname, loc  )  values ( 50 , 'DATABASE' , 'SEOUL'   );
insert  into dept_temp                           valueS ( 60 , 'NETWORK'  , 'BUSAN'   );
insert  into dept_temp                           values ( 70 , 'WEB'      , NULL      );
insert  into dept_temp ( deptno, loc, dname  )   values ( 80 ,  ''        , 'FRONT'  );
insert  into dept_temp ( loc, dname ,deptno  )   values (  'INCHEON'      , 'BACK' , 90  );
insert  into dept_temp ( deptno , dname      )   values ( 99 , 'MOBILE' );

commit; -- 반영

select * from dept_temp;




-- Q1.  EMP테이블을 복사해 EMP_TEMP 테이블을 만드시오. ( 구조확인, 전체데이터 확인)
create table emp_temp as select * from emp;
desc emp_temp;
select * from emp_temp;

-- Q2.  모든필드 명시하는 방법이용해서   다음의 값 넣기 - 9999, '홍길동', 'PRESIDENT', NULL, '2001/01/01', 5000, 1000, 10
insert into emp_temp (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) values( 9999, '홍길동', 'PRESIDENT', NULL, '2001/01/01', 5000, 1000, 10);
-- Q3.  필드 명시 안하는 방법이용해서 다음의 값 넣기    - 1111, '성춘향', 'MANAGER', 9999, '2001-01-05', 4000, NULL, 20
insert into emp_temp values(1111, '성춘향', 'MANAGER', 9999, '2001-01-05', 4000, NULL, 20);

commit;

select * from emp_temp;

------------------------------------------------------------------------------------------
-- 1. dml 조작어(데이터) insert(삽입)   select(조회)    ■update(수정)     delete(지우기)  → CRUD


select * from dept_temp;

--#1. update
update 테이블명
set 바꿀필드1 = 바꿀값1, 바꿀필드2 = 바꿀값2 ,,,
where 조건;

--#2. 전체데이터 업데이트
update dept_temp set LOC = 'INCHEON'; -- 전체데이터 업데이트
update dept_temp set LOC = 'NEWYORK' where deptno=10; --해당하는 조건
update dept_temp set LOC = 'DALLAS' where deptno =20; and dname= 'RESEARCH';

select * from dept_temp; 

--#3. delete 

DELETE FROM dept_temp;  --전체 데이터 삭제
delete from dept_temp where deptno=10;
delete from dept_temp where deptno >=30;

commit;
select * from dept_temp;
select * from dept;
insert into dept_temp (deptno,dname,loc)
                    select deptno,dname,loc from dept;

--Q1. dept_emp 모든데이터 삭제
delete from dept_temp;
--Q2. insert 이용해서 데이터 삽입, 반영
insert into dept_temp (deptno,dname,loc)  select deptno,dname,loc from dept;

select *  from dept_temp;
rollback;

commit;
--Q3. 40번 부서의 이름을 DATABASE, 지역을 SEOUL로 수정하시오
update dept_temp
set dname = 'DATABASE',loc = 'SEOUL'
where deptno = 40;
select *  from dept_temp;

commit;

--Q4. 위 데이터 되돌리기 
rollback; --커밋 전으로 돌아감 

-- #0. 준비 -  다음 문제들을 풀으시오
-- Q1. DEPT 테이블을 복사해 DEPT_TCL테이블을 작성하시오.
create table dept_TCL as select * from dept; 
desc dept_TCL;
select *from dept_TCL;
-- Q2. DEPT_TCL 테이블에 다음과 같이 데이터를 입력, 수정, 삭제 하시오.
--    2-1.  데이터 삽입   50, 'DATABASE', 'SEOUL'
insert into dept_TCL (deptno,dname,loc) values ( 50, 'DATABASE', 'SEOUL');
--    2-2.  부서번호가 40인  LOC를 INCHEON 으로 수정
update dept_TCL
set loc = 'INCHEON'
where deptno=40;
--    2-3.  DNAMD이 RESEARCH 인데이터 삭제
delete from dept_tcl where DNAME='RESEARCH';
--    2-4.  전체데이터 확인
select * from dept_tcl;

-- #1. 데이터 반영 (insert , update, delete)
commit;

-- #2. 데이터 되돌리기 (commit 이후에는 효과 없음)
rollback;

insert into dept_tcl dept_tcl values (20,'AI','INCHEON');

rollback;
select * from dept_tcl;

-- #3. SAVEPOINT
INSERT INTO DEPT_TCL VALUES (60,'AI','INCHEON' ); --insert  (작업하고 저장)
SAVEPOINT sp_insert; ----------- 기준점1

UPDATE DEPT_TCL set deptno=20 where deptno=60; --update 설정  (작업하고 저장)
SAVEPOINT sp_update; ----------기준점설정2 

rollback to sp_insert;

select * from dept tcl;


------------------------------------------------------------------------------------------
-- 2. ddl 정의어(구조) create(만들기)  alter(테이블수정) drop(삭제:복구안됨) →CAD
--#1. CREATE
---------------------
CREATE TABLE 테이블명 (
 필드명1  자료형 옵션,
 필드명2  자료형 옵션,
 필드명3  자료형 옵션,
 )
 ---------------------
 필드명 - 영문소문자
 자료형 - 숫자는 NUMBER, 문자열 VARCHAR2(갯수), 날짜 DATE
 옵션  -  NOT NULL 필수입력, 기본값 PRIMARY KEY
 
 CREATE TABLE DEPT_DDL(
    DEPTNO NUMBER(2) PRIMARY KEY,
    DNAME VARCHAR(50) NOT NULL,
    LOC   VARCHAR(50)
 );
 
 DESC DEPT_DDL;
 
 ------------------------------
ALTER TABLE 테이블명 ADD   필드명 자료형
                  /DROP  COLUMN 필드명 
                /MODIFY  필드명 자료형
------------------------------
--컬럼추가
ALTER TABLE DEPT_DDL ADD ADMIN VARCHAR(50);
--컬럼수정
ALTER TABLE DEPT_DDL MODIFY ADMIN VARCHAR(100) NOT NULL;
--컬럼삭제
ALTER TABLE DEPT_DDL DROP COLUMN ADMIN;

------------------------------
DROP TABLE 테이블명
------------------------------
DROP TABLE DEPT_DDL;
ROLLBACK;
DESC DEPT_DDL;


--✅ 문제 1:  다음과 같이 테이블을 작성하고 데이터를 삽입하세요
--※AppUser 의 FK는 무시하세요.
--
--#### 1. `MbtiType`
--| 필드명 | 타입 | 설명 |
--|--------|------|------|
--| mbti_type_id | INT (PK) | MBTI 유형 ID |
--| name | VARCHAR(10) | 유형 이름 (예: ENFP) |
--| description | TEXT | 성향 설명 |
--
--**예시 데이터**
--```sql
--(3, 'ENFP', '열정적이고 창의적인 성향')
--(7, 'INTJ', '논리적이고 전략적인 성향')
--```
create table MbtiType(
 mbti_type_id NUMBER PRIMARY KEY, 
 name VARCHAR2(10), 
 description VARCHAR2(100)
);
INSERT INTO MbtiType (mbti_type_id, name, description)
VALUES (3, 'ENFP', '열정적이고 창의적인 성향');
INSERT INTO MbtiType (mbti_type_id, name, description)
VALUES (7, 'INTJ', '논리적이고 전략적인 성향');



--#### 2. `AppUser`
--| 필드명 | 타입 | 설명 |
--|--------|------|------|
--| app_user_id | INT (PK) | 사용자 고유 ID |
--| email | VVARCHAR | 이메일 주소 |
--| password | VARCHAR(255) | 암호화된 비밀번호 |
--| mbti_type_id | INT (FK → MbtiType.mbti_type_id) | 연결된 MBTI 유형 |
--| created_at | DATETIME | 가입일 |
--
--**예시 데이터**
--```sql
--(1, 'alice@example.com', 'hashed_pw_123', 3, 2, '2025-10-01 10:00:00')
--(2, 'bob@example.com', 'hashed_pw_456', 7, 1, '2025-10-02 14:30:00')
--```
CREATE  TABLE  AppUser(
    app_user_id   NUMBER(5)  PRIMARY KEY, 
    email         VARCHAR2(100) , 
    password      VARCHAR2(255) ,
    mbti_type_id  NUMBER(3), 
    created_at    DATE
);

INSERT INTO AppUser VALUES (1, 'alice@example.com', 'hashed_pw_123', 3, TO_DATE('2025-10-01 10:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO AppUser VALUES (2, 'bob@example.com', 'hashed_pw_456', 7, TO_DATE('2025-10-02 14:30:00', 'YYYY-MM-DD HH24:MI:SS'));

-- part) alter
--✅ 문제 1: AppUser 테이블에 사용자 이름(name) 컬럼을 추가하세요.
--컬럼 타입은 VARCHAR2(50)이며 NULL 허용
ALTER TABLE AppUser ADD name VARCHAR2(50);
desc APPUser;
--✅ 문제 2: AppUser 테이블의 email 컬럼에 NOT NULL 제약을 추가하세요.
ALTER TABLE AppUser MODIFY email VARCHAR2(100) NOT NULL;

--✅ 문제 3: AppUser 테이블의 password 컬럼 길이를 255 → 100으로 줄이세요.
ALTER TABLE AppUser MODIFY password VARCHAR2(100);

--✅ 문제 4: MbtiType 테이블에 컬럼 category를 추가하세요.
--타입은 VARCHAR2(20)이며 기본값은 '기본'
ALTER TABLE MbtiType ADD category VARCHAR2(20) DEFAULT '기본';

--✅ 문제 5: MbtiType 테이블의 description 컬럼 이름을 details로 변경하세요.
-- https://www.oracletutorial.com/oracle-basics/oracle-rename-column/
--ALTER TABLE table_name RENAME COLUMN column1 TO new_column;
ALTER TABLE MbtiType RENAME COLUMN description TO details;

--✅ 문제 6: AppUser 테이블의 name 컬럼을 삭제하세요.
ALTER TABLE AppUser DROP  COLUMN name;
desc AppUser;

--✅ 문제 7:  MbtiType 테이블 이름을 MbtiInfo로 변경하세요.
ALTER TABLE MbtiType RENAME TO MbtiInfo;
desc MbtiInfo;

ALTER TABLE MbtiInfo RENAME TO MbtiType;

------------------------------------------------------------------------------------------