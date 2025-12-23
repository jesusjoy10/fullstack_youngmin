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


--Q009
--EMP테이블을 2번 이용하여
--사원정보(EMPNO, ENAME, MGR) 와 직속상관(EMPNO, ENAME)의 사원번호를 다음과 같이 출력하시오
--직속상관이 없는 사원의 정보도 출력하시오
select e1.EMPNO, e1.ENAME, e1.MGR , e2.EMPNO as mgr_empno, e2.ENAME as mgr_ename
from emp e1, emp e2
where e1.mgr = e2.empno (+);

--Q010
--(+)의 위치를 바꿔서 출력해보고 다음이 의미하는 바를 적으시오  empno 테이블 보장 null값 채우기
select e1.EMPNO, e1.ENAME, e1.MGR , e2.EMPNO as mgr_empno, e2.ENAME as mgr_ename
from emp e1, emp e2
where e1.mgr(+) = e2.empno ; -- (+) null 채워줄께, 매니저들의 번호와 이름은 있으나,, 관리하는 사원이 없음.

--Q011 표준문법 (NATURAL JOIN)
--EMP , DEPT 테이블 이용하여
--EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM를 다음과 같이 출력하시오
--NATURAL JOIN
--알아서 두 테이블의 이름과 자료형이 같은 열을 찾은 후
--그 열을 기준으로 등가조인을 해주는 방식
select e.EMPNO, e.ENAME, e.job , e.mgr , e.HIREDATE, e.SAL, e.COMM 
       deptno,d.dname, d.loc
       from emp e  natural join dept d;
       
--Q012 표준문법 (JOIN USING)
--EMP , DEPT 테이블 이용하여
--EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM를 다음과 같이 출력하시오
--JOIN USING
--USING에 조인기준열 명시
--그 열을 기준으로 등가조인을 해주는 방식 
select e.EMPNO, e.ENAME, e.job , e.mgr , e.HIREDATE, e.SAL, e.COMM 
  deptno,d.dname, d.loc
from emp e join dept d using(deptno)
where sal>=3000;

--Q013 표준문법 (JOIN ON)
--EMP , DEPT 테이블 이용하여 EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM를 다음과 같이 출력하시오
--JOIN ON
--ON에 조인기준열 명시
--그 열을 기준으로 등가조인을 해주는 방식
select e.EMPNO, e.ENAME, e.job , e.mgr , e.HIREDATE, e.SAL, e.COMM 
  deptno,d.dname, d.loc
from emp e join dept d on(e.deptno= d.deptno)
where sal<=3000
order by deptno , empno;

--Q014 표준문법 (LEFT OUTER JOIN )
--EMP , DEPT 테이블 이용하여 다음과 같이 출력하시오
--LEFT OUTER JOIN
--왼쪽 외부조인을 기준으로 NULL보장
select e1.empno, e1.ename, e1.mgr, e2.empno as mgr_empno , e2.ename as mgr_ename
from emp e1 left outer join emp e2 on (e1.mgr = e2.empno)
order by e1.empno;

-- Q015 표준문법 (RIGHT OUTER JOIN )
--EMP , DEPT 테이블 이용하여 다음과 같이 출력하시오
--RIGHT OUTER JOIN- 오른른쪽 외부조인을 기준으로 NULL보장
select e1.empno, e1.ename, e1.mgr, e2.empno as mgr_empno , e2.ename as mgr_ename
from emp e1 right outer join emp e2 on(e1.mgr = e2.empno)
order by e1.empno;
--Q016 표준문법 (FULL OUTER JOIN )
--EMP , DEPT 테이블 이용하여 다음과 같이 출력하시오
--FULL OUTER JOIN - 양쪽모두두 외부조인을 기준으로 NULL보장
select e1.empno, e1.ename, e1.mgr, e2.empno as mgr_empno , e2.ename as mgr_ename
from emp e1 FULL OUTER JOIN emp e2 on(e1.mgr = e2.empno)
order by e1.empno;

--EX001
--EMP, DEPT 테이블을 이용하여
--SQL-99 이전 방식=(+)다음 , SQL-99방식 (inner join,left join,righ join, full outer join)두가지 방식으로 다음과 같이 출력하시오.
--급여(SAL)이 2000초과인 사원들의 부서정보, 사원정보를 출력하시오.

--sql-99이전방식
select e.DEPTNO,DNAME, EMPNO, ENAME,  SAL  -- 겹치는 거 없으면 e. 빼도됨
from emp e, dept d
where e.DEPTNO = d.DEPTNO AND e.SAL > 2000
order by deptno;

--sql-99이후방식
select e.DEPTNO,d.DNAME, e.EMPNO, e.ENAME,  e.SAL
from emp e JOIN dept d ON e.DEPTNO = d.DEPTNO
where e.SAL > 2000
order by e.DEPTNO;

select DEPTNO,DNAME, EMPNO, ENAME, SAL
from   dept natural JOIN emp
where SAL > 2000
order by DEPTNO;

--EX002
--EMP, DEPT 테이블을 이용하여
--SQL-99 이전 방식다음 , SQL-99방식 두가지 방식으로 다음과 같이 출력하시오.
--각 부서별 평균급여, 최대급여, 사원수를 출력하시오

--sql-99이전방식
SELECT   d.DEPTNO ,DNAME, trunc(AVG(SAL),0) as avg_sal, MAX(SAL), MIN(SAL), COUNT(*)
FROM     DEPT D , EMP E
WHERE    e.deptno  = d.deptno    --  위의 두 테이블에서 DEPTNO 가 같다면   
GROUP BY d.DEPTNO , d.DNAME;

--sql-99이후방식
SELECT   d.DEPTNO , d.DNAME, trunc(AVG(SAL),0) as avg_sal, MAX(SAL), MIN(SAL), COUNT(*)
FROM     DEPT D JOIN EMP E on  e.deptno  = d.deptno  
GROUP BY d.DEPTNO , d.DNAME;

SELECT   DEPTNO , DNAME, trunc(AVG(SAL),0) as avg_sal, MAX(SAL), MIN(SAL), COUNT(*)
FROM     DEPT D JOIN EMP E using(deptno )
GROUP BY  DEPTNO , DNAME;

SELECT   DEPTNO , DNAME, trunc(AVG(SAL),0) as avg_sal, MAX(SAL), MIN(SAL), COUNT(*)
FROM     DEPT natural JOIN EMP 
GROUP BY DEPTNO , DNAME;
--EX003
--EMP, DEPT 테이블을 이용하여
--SQL-99 이전 방식다음 , SQL-99방식 두가지 방식으로 다음과 같이 출력하시오.
--모든 부서정보와 사원정보를 부서번호, 사원이름 순으로 정렬해 출력하시오.

SELECT   d.DEPTNO ,DNAME, EMPNO, ename JOB, SAL
FROM     DEPT D , EMP E 
where e.deptno = d.deptno(+)   --위의 두 테이블에서 DEPTNO 가 같다면   
order by d.deptno, e.ename;

--힌트)   값 중에 NULL 이 있으므로  OUTER JOIN
SELECT   DEPTNO ,DNAME, EMPNO, ename JOB, SAL
FROM     DEPT D full outer join EMP E using (deptno)   --위의 두 테이블에서 DEPTNO 가 같다면   
order by deptno;

--EX004
--EMP, DEPT 테이블을 이용하여
--SQL-99 이전 방식다음 , SQL-99방식 두가지 방식으로 다음과 같이 출력하시오.
--모든 부서정보와 사원정보, 급여등급정보, 각사원의 직속상관의 정보를
--부서번호, 사원번호 순서로 정렬해 출력하시오.
SELECT   D.DEPTNO ,DNAME, e1.EMPNO, e1.ename , e1.mgr , e1.sal ,e1.deptno, losal ,hisal , grade, e2.empno as mgr_empno ,e2.ename as mgrename
from emp e1, dept d , salgrade s , emp e2
where e1.deptno(+) = d.deptno and e1.sal between losal and hisal and e1.mgr= e2.empno (+)
order by d.deptno,e1.EMPNO;


SELECT   D.DEPTNO ,DNAME, e1.EMPNO, e1.ename , e1.mgr , e1.sal ,e1.deptno, losal ,hisal , grade, e2.empno as mgr_empno ,e2.ename as mgrename
from emp e1 right join dept d on (e1.deptno = d.deptno) 
           left join salgrade s  on (e1.sal between losal and hisal )
           left join emp e2 on (e1.mgr=e2.empno)
order by d.deptno,e1.EMPNO;

--join
--emp(deptno) ,dept(deptno)  한테이블처럼 사용하는 방법
-- (0) 비표준
select empno, ename, d.deptno, dname
from emp e, dept d
where e.deptno = d.deptno ;

-- (1) join on  sql-99 표준
select empno, ename, d.deptno, dname
from emp e join dept d on (e.deptno = d.deptno);

-- (2) join using sql-99 표준
select empno, ename, deptno, dname
from emp e join dept d using(deptno);

-- (3) natural join sql-99 표준
select empno, ename, deptno, dname
from emp e natural join dept d ;

-- (4) (+) null 값 붙여줄께 - sql 99이전
select * from dept;

select empno, ename, d.deptno, dname
from emp e, dept d
where e.deptno(+) = d.deptno ;

-- (5) right outer join
select empno, ename, d.deptno, dname
from emp e right outer join  dept d on(e.deptno = d.deptno);

-- (6) left outer join
select empno, ename, d.deptno, dname
from dept d left outer join emp e on(e.deptno = d.deptno);

-- (7) full outer join
select empno, ename, d.deptno, dname
from dept d full outer join emp e on(e.deptno = d.deptno);
