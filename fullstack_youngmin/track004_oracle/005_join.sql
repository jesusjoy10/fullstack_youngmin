-- join
-- 여러테이블을 한개의 테이블처럼 사용하는 것
-- 공통컬럼 기준으로 연결
-- 1-1.내부조인
    -- 등가조인 (=) : where절      emp.deptno = dept.deptno 
    -- 비등가조인 (= X) :          sal between lasal and hisal
    -- 자체조인         : emp el , emp e2 
    -- 1-2. outer join     : 매칭되지 않은 행도 포함. left, right, full outer join


-- ERD : Entity(테이블) , Relationship(관계) , diagram(표)
--       Entity(테이블) , Relationship(관계) , Attribute(속성)

--#1. 내부조인 등가조인
select *
from emp e,dept d
where e.deptno = d.deptno;   --14*4 =56

select *
from emp e join dept d on(e.deptno = d.deptno);  --14*4 =56

select *
from emp e join dept d using(deptno);  --14*4 =56

select *
from emp e natural join dept d; 

-- emp e 별명 , dept d 별명 / empno, ename, deptno , dname
select empno,ename, e.deptno , dname
from emp e , dept d 
where e.deptno = d.deptno;

select empno,ename, e.deptno , dname
from emp e join  dept d on(e.deptno = d.deptno); 

select empno,ename, deptno , dname
from emp e join  dept d using(deptno); 

select empno,ename, deptno , dname
from emp e natural join  dept d ;

--Q001
--EMP, DEPT 테이블을 이용하여 FROM 절에 여러 테이블을 선언해해 다음과 같이 출력하시오
--모든 행과 열이 곱해진 값
select *
from emp ,dept;  -- 이렇게하면 컴퓨터 멈춤


--Q002
--EMP, DEPT 테이블을 이용하여
--EMP의 DEPTNO와 DEPT테이블의 DEPTNO가 같은 데이터를 다음과 같이 출력하시오
select *
from emp, dept
where emp.deptno = dept.deptno;

select *
from emp join dept on(emp.deptno = dept.deptno);

select *
from emp join dept using(deptno);

select *
from emp natural join dept;

--Q003
--EMP, DEPT 테이블을 이용하여
--FROM 절에 EMP 테이블의 별칭은 E, DEPT 테이블의 별칭은 D로 다음과 같이 출력하시오
select *
from emp e ,dept d
where e.deptno = d.deptno;

select *
from emp e, dept d
where e.deptno = d.deptno;

select *
from emp e join dept d on(e.deptno = d.deptno);

--Q004
--EMP, DEPT 테이블을 이용하여
--두테이블에 부서번호가 같은 열의이름이 포함되었을때 다음과 같이 출력하시오 (에러발생)
select EMPNO, ENAME, DEPTNO, DNAME, LOC
from emp e, dept d
where e.deptno = d.deptno;
--Q005
--EMP, DEPT 테이블을 이용하여
--열 이름에 각각의 테이블 이름도 함께 명시시 다음과 같이 출력하시오 ( 위의 문제 해결 )
select EMPNO, ENAME, d.DEPTNO, DNAME, LOC  --겹치는 파트들만 테이블명시 해야함
from emp e, dept d
where e.deptno = d.deptno;
--Q006
--EMP, DEPT 테이블을 이용하여
--급여가 3000이상인 사원의 사원번호, 이름, 급여, 근무부서를 다음과 같이 출력하시오
select e.EMPNO, e.ENAME, e.sal ,d.DEPTNO, d.DNAME, d.LOC
from emp e ,dept d
where e.deptno = d.deptno and sal >= 3000;

select e.EMPNO, e.ENAME, e.sal ,d.DEPTNO, d.DNAME, d.LOC
from emp e join dept d on ( e.deptno = d.deptno)
where e.sal >= 3000;

select EMPNO,ENAME, sal ,DEPTNO, DNAME,LOC
from emp e join dept d using(deptno)
where e.sal >= 3000;

select EMPNO,ENAME, sal ,DEPTNO, DNAME,LOC
from emp e natural join dept d 
where e.sal >= 3000;

--Q007
--EMP, SALGRADE 테이블을 이용하여
--유저 정보, 급여등급 , 그 등급의 최소급여와 최대급여를 다음과 같이 출력하시오
select *
from emp e, SALGRADE s
where e.sal between s.losal and s.hisal;  --비등가 조인

select * 
from emp e join salgrade s on (e.sal >= losal and e.sal <= hisal); --비등가 조인

--select *
--from emp e join salgrade s using 
--using 은 겹치는 필드가 없어서 불가능 

--Q008
--EMP테이블을 2번 이용하여
--사원정보(EMPNO, ENAME, MGR) 와 직속상관(EMPNO, ENAME)의 사원번호를 다음과 같이 출력하시오
select e1.empno, e1.ename , e1.mgr , e2.empno as mgr_empno, e2.ename as mgr_emname
from emp e1 , emp e2
where e1.mgr = e2.empno
order by e1.mgr asc;

select e1.empno, e1.ename , e1.mgr , e2.empno as mgr_empno, e2.ename as mgr_emname
from emp e1 join emp e2 on(e1.mgr = e2.empno)
order by e1.mgr asc;

--select e1.empno, e1.ename , e1.mgr , e2.empno as mgr_empno, e2.ename as mgr_emname
--from emp e1 join emp e2 using(같은필드 x)
--order by e1.mgr asc;


--#2. 외부조인(매칭되지x)
select e1.empno, e1.ename , e1.mgr , e2.empno as mgr_empno, e2.ename as mgr_emname
from emp e1 join emp e2 on(e1.mgr = e2.empno)
order by e1.mgr asc;

select * from dept; --10,20,30,40
select * from emp;

-- 1. 조건(+) oracle 에서만 -- 없는 데이터 null 보충해줄게, (+) 안붙은 테이블의 데이터를 보장
select ename, dname
from emp e,dept d
where e.deptno = d.deptno(+);  --14 emp 테이블 보장, dept 에서 모자라는 데이터 없는 데이터 null 채울게

select ename, dname
from emp e,dept d
where e.deptno(+) = d.deptno;  --15 dept 테이블 보장, emp 에서 모자라는 데이터 없는 데이터 null 채울게

-- 2. left join , right join (ansi조인)
select ename, dname
from emp e inner join dept d on(e.deptno = d.deptno);  -- inner join , 내부조인 , 겹치는 애들만

select ename, dname
from emp e right outer join dept d
on (e.deptno = d.deptno);    -- right 쪽에 있는 테이블 보장

select ename, dname
from dept d left outer join emp e
on (e.deptno = d.deptno);    -- left 쪽에 있는 테이블 보장

--3. full outer join (두 텡블에 있는 모든 데이터를 결합)
select ename, dname
from emp e full outer join dept d
on (e.deptno = d.deptno);  

-- 비표준 =, (+) 
-- 표준 natural join , join on, join using, lefr join , right join, full join




