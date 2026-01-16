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
insert into dept_temp;
select *  from dept;

commit;
--Q3. 40번 부서의 이름을 DATABASE, 지역을 SEOUL로 수정하시오
update dept_temp
set dname = 'DATABASE',
    loc = 'SEOUL'
where deptno = 40;

commit;

--Q4. 위 데이터 되돌리기 #


