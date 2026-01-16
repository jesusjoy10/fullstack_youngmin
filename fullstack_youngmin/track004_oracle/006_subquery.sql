-- 서브쿼리 select 안에 select  ( 내 안에 너 있다 )

--#1. 단일행(2073) 서브쿼리 - emp 평균 급여보다 많이 받는 사원들
-- step1)
--select ename, sal 
--from emp
--where sal > 2073(평균급여)
--order by sal desc;

-- step2)
select ename, sal 
from emp
where sal > (select avg(sal) from emp)
order by sal desc;

-- #2.  다중행(in )emp deptno가 10인 부서의 job인 사원들 ename, sal
-- step1) 
--select ename, sal 
--from emp
--where job=(deptno가 10인 부서의 job인 사원)
--order by sal desc;

select ename, sal 
from emp
where job in (select job from emp where deptno =10 )
order by sal desc;

--Q001
--EMP 테이블에서 다음과 같이 출력하시오.
--사원이름이 JONES 인 사원의 급여를 출력하시오.
select sal
from emp 
where ename= 'JONES';

--Q002
--EMP 테이블에서 다음과 같이 출력하시오.
--급여가 2975보다 높은 사원정보를 출력하시오.
select empno, ename , job, mgr, hiredate, sal, comm, deptno
from emp 
where sal > 2975;

--Q003
--EMP 테이블에서 다음과 같이 출력하시오.
--JONES의 급여보다
--높은급여를 받는 사원정보를 출력하시오.
select  empno, ename , job, mgr, hiredate, sal, comm, deptno
from emp
where sal > (select sal from emp where ename = 'JONES');

--Q004
--EMP 테이블에서 다음과 같이 출력하시오.
--SCOTT보다 빨리 입사한 사원목록을 출력하시오.
select  empno, ename , job, mgr, hiredate, sal, comm, deptno
from emp
where hiredate < (select hiredate from emp where ename = 'SCOTT');

--Q005
--EMP 테이블에서 다음과 같이 출력하시오.
--20번부서에 속한 사원 중
--전체사원의 평균급여보다 높은 급여를받는 사원정보와 소속부서정보를 출력하시오.
select  empno, ename , job, sal, deptno , dname, loc 
from emp e  natural join dept d
where deptno=20 and sal > (select avg(sal) from emp);

--Q006
--EMP 테이블에서 다음과 같이 출력하시오.
--부서번호가 20이거나 30인 사원의 정보를 출력하시오.
select empno, ename , job, mgr, hiredate , sal, comm, deptno
from emp
where deptno in (20,30);

--Q007
--EMP 테이블에서 다음과 같이 출력하시오.
--각 부서별 최고급여와 동일한 급열르 받는 사원정보를 출력하시오.
select empno, ename , job, mgr, hiredate , sal, comm, deptno
from emp
where sal in (select max(sal) from emp group by deptno);  --뭐뭐 별 이라고하면 group by ㄱㄱ

-- #3. 다중행연산자
-- 1. in "이 값이 목록에 있나요?" deptno in(10,20,30)
-- 2. any,some "하나라도 만족하면 ok "  ■ 최소값 기준비교
-- 컬럼 > any(서브쿼리) 최소값보다 크면 true
-- 컬럼 < any(서브쿼리) 최대값보다 작으면 true
--   컬럼 > any(1,2,3)         |  (1)   |  (2)   |  (3)
--   
--   컬럼 < any(1,2,3)         |  (1)   |  (2)   |  (3)

-- 3. all  "모두 만족해야 ok"          ■ 최대값 기준비교
-- 컬럼 > all(서브쿼리) 최대값보다 크면 true
-- 컬럼 < all(서브쿼리) 최초값보다 작으면 true
--    컬럼 > any(1,2,3)         |  (1)   |  (2)   |  (3)
--   
--    컬럼 < any(1,2,3)         |  (1)   |  (2)   |  (3)

-- 암기) 컬럼>any 1    컬럼 > all 3  
-- 4. exist "서브쿼리가 존재하면 ok"    

    create table atest as     select 1 num from dual
                    union all select 2     from dual
                    union all select 3     from dual
                    union all select 4     from dual
                    union all select 5     from dual
                    union all select 6     from dual;
               
select * from atest;

--컬럼> any>1 최소값보다 크다, 컬럼> all>3 최대값보다 크다
--애니1 올 3
select num  from atest where  num < any(select num from atest  where num in(3,4,5)) order by num; --5보다 작다 1 2 3 4
select num  from atest where  num > any(select num from atest  where num in(3,4,5)) order by num; --3보다 크다 4 5 6  
select num  from atest where  num < all(select num from atest  where num in(3,4,5)) order by num; --3보다 작다 1 2
select num  from atest where  num > all(select num from atest  where num in(3,4,5)) order by num; --5보다 크다 6

--Q008
--EMP 테이블에서 다음과 같이 출력하시오.
--부서번호 별로 최대 급여를 출력하시오.
select max(sal)
from emp
where sal in (select max(sal) from emp group by deptno);

--select *
--from emp
--group by deptno;


--Q009
--EMP 테이블에서 다음과 같이 출력하시오.
--ANY 연산자를 이용하여 다음과같이 출력해보시오 (각부서별 최대급여)
select *
from emp
where sal = any(select max(sal) from emp group by deptno);

--Q010
---EMP 테이블에서 다음과 같이 출력하시오.
--SOME 연산자를 이용하여 다음과같이 출력해보시오 (각부서별 최대급여)
--IN 과 같은결과
select *
from emp
where sal = some(select max(sal) from emp group by deptno);


--Q0011
--EMP 테이블에서 다음과 같이 출력하시오.
--ANY를 이용하여 30번 부서 사원들의 최대 급여보다 적은 급여를 받는 사원정보를 출력하시오.
select *
from emp
where sal < any(select sal from emp where deptno=30);

--Q012
--EMP 테이블에서 다음과 같이 출력하시오.
--부서번호가 30인 사원들의 급여를 출력하시오.
select sal
from emp
where  deptno =30;  --2850 1250 1600 1500 950

--Q013
--EMP 테이블에서 다음과 같이 출력하시오.
--ANY를 이용하여 30번 부서 사원들의 최소 급여보다 많은은 급여를 받는 사원정보를 출력하시오.
select * 
from emp
where sal > any(select sal from emp where deptno=30);

--Q014
--EMP 테이블에서 다음과 같이 출력하시오.
--ALL를 이용하여 30번 부서 사원들의 최소 급여보다 더 적은 급여를 받는 사원정보를 출력하시오.
select *
from emp
where sal < all(select sal from emp where deptno=30);

--Q015
--EMP 테이블에서 다음과 같이 출력하시오.
--ALL를 이용하여 30번 부서 사원들의 최대 급여보다 더 많은 급여를 받는 사원정보를 출력하시오.
select *
from emp
where sal > all(select sal from emp where deptno=30);

--Q016
---EMP 테이블에서 모든 행을 선택하되, 다음 조건을 만족하는 경우에만 출력한다:
--DEPT 테이블에 DEPTNO = 10인 행이 하나라도 존재하는 경우
select *
from emp
where exists(select dname from dept where deptno=10);

--Q017
--EMP 테이블에서 모든 행을 선택하되, 다음 조건을 만족하는 경우에만 출력한다:
--DEPT 테이블에 DEPTNO = 50인 행이 하나라도 존재하는 경우
select *
from emp
where exists(select dname from dept where deptno=50);

--컬럼> any>1 최소값보다 크다, 컬럼> all>3 최대값보다 크다
--애니1 올 3

-- #4. 다중 열 서브쿼리
-- where sal > any , sal in any
select ename, deptno, job
from emp 
where (deptno,job)in ( select deptno, job from emp where sal>2000);

--10	PRESIDENT
--30	MANAGER
--10	MANAGER
--20	MANAGER
--20	ANALYST
--20	ANALYST

-- #5. 인라인뷰 (from 에서 나오면 인라인)
select empno,ename, d.deptno, dname
from (select * from emp where deptno=20)e,
     (select * from dept)d 
where e.deptno = d.deptno;

-- #6. with (단일쿼리)
with
e6 as (select *from emp where deptno=30),
d6 as (select * from dept)
select empno,ename, d.deptno, dname
from e6, d6
where e6.deptno = d6.deptno;

with
e6 as (select *from emp where deptno=30)
select count(*) from e6;

-- #7. 스칼라서브쿼리
-- 데이터가 많은 경우 성능저하 (쓰지마~)
select empno, ename , sal
      ,(select grade from salgrade where emp.sal between losal and hisal) salgrade
      , deptno
      ,(select loc from dept where emp.deptno = dept.deptno) location
from emp;

--Q018
--EMP 테이블에서 다음과 같이 출력하시오.
--다중열 서브쿼리를 이용하여 WHERE (DEPTNO, SAL) IN ( ... )
--부서별 최대급여를 받는 사원정보를 출력하시오.
select *
from emp
where (DEPTNO, SAL) IN (select deptno,max(sal) from emp group by deptno )
order by sal;

--Q019
--인라인 뷰를 이용
--FROM 절에서 사용하는 인라인 뷰를 이용하여
--부서번호가 10인 사용자 정보와 부서정보를 가져와
--EMPNO, ENAME, DEPTNO, DNAME, LOC 를 출력하시오
select  EMPNO, ENAME, e.DEPTNO, DNAME, LOC
from (select * from emp where deptno=10) e ,
      (select * from dept)d
      where e.deptno = d.deptno;

select EMPNO, ENAME, DEPTNO, DNAME, LOC             
from emp e natural join dept
where deptno =10;
--Q020
--WITH 이용
--FROM 절에 명시하는 방식보다 몇십, 몇백줄의 규모가 되었을때 유용하게 사용됨.
--emp 테이블에서 부서번호가 10인 사원정보
--dept 테이블의 모든정보      
with
e as (select * from emp where deptno=10),
d as(select * from dept)
select e.empno, e.ename, e.deptno, d.dname, d.loc from e, d
where e.deptno = d.deptno;

--Q0021
--열에 명시하는 스칼라서브쿼리
--EMP 테이블의 EMPNO, ENAME, JOB, SAL
--EMP 테이블의 SAL을 이용하여 SALGRADE에서 등급(GRADE)을 구하고
--EMP 테이블의 DEPTNO를 이용하여 DEPTNO가 같은 부서명(DNAME)을 구하시오.

select empno, ename , job, sal, (select grade from salgrade where e.sal between losal and hisal)as salgrade,
deptno,(select dname from dept where e.deptno = dept.deptno) as dname 
from emp e;

--EX001
--EMP 테이블에서 다음과 같이 출력하시오.
--전체 사원 중 ALLEN과 같은 직책(JOB)인 사원들의 사원정보, 부서정보를 다음과 같이 출력하시오.

select job, empno, ename, sal, deptno, dname
from emp natural join dept
where job=(select job from emp where ename='ALLEN');

--EX002
--EMP 테이블에서 다음과 같이 출력하시오.
--전체 사원의 평균급여(SAL) 보다 높은 급여를 받는 사원들의 사원정보, 부서정보, 급여등급정보를 출력하시오.
--급여가 많은 순으로 정렬하되 급여가 같은경우에는 사원번호를 기준으로 오름차순으로 정렬
select empno , ename , dname, hiredate, loc , sal ,grade
from emp natural join dept
join salgrade on sal  between losal and hisal
where sal > (select avg(sal) from emp)
order by sal desc , empno asc;

--EX003
--EMP 테이블에서 다음과 같이 출력하시오.
--10번부서에서 근무하는 사원 중 30번부서에는 존재하지 않는 직책을 가진 
--사원들의 사원정보, 부서정보를 다음과 같이 출력하는 SQL문을 작성하시오.
select empno, ename , job, deptno, dname, loc
from emp natural join dept
where deptno= 10 and job not in (select job from emp where deptno=30); 

--EX004
--EMP 테이블에서 다음과 같이 출력하시오.
--직책이 SALESMAN인 사람들의 최고급여보다 높은 급여를 급여를 받는 사원들의 사원정보, 급여등급정보를 다음과 같이 출력하시오.
--다중행 함수 사용하지 않는 방법, 다중행 함수 사용하는 방법 2가지로 작성하시오.
--사원번호를 기준으로 오름차순으로 정렬하시오.
select  empno, ename, sal, grade
from emp e, salgrade s
where e.sal between s.losal and s.hisal
and sal > (select max(sal) from emp where job='SALESMAN')  --max 들어가야함
order by empno;

select  empno, ename, sal, grade
from emp e, salgrade s
where e.sal between s.losal and s.hisal
and sal > all(select sal from emp where job='SALESMAN')   --max 빠짐 
order by empno;