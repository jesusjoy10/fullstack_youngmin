--1
select * 
from emp;

--2.집계 sum , max , min , avg, count
select sum(sal)
from emp; --급여의 합계

select sum(comm)
from emp; --null 값이 있어도 계산가능

--     14줄   1줄 
--select sal, sum(sal), max(sal), min(sal), avg(sal), count(sal)  -에러 남.
--from emp;
select sum(sal) 합 , max(sal) 최대 , min(sal)최소, round(avg(sal),2) 평균, count(sal) 갯수  
from emp;

--3. group by
--select --5
--from  --1
--where  --2
--group by --3 그룹핑
--having  --4 그룹핑안에서 조건(그룹핑 후 필터링)
--order by; --6 
-- 부서[별] 급여의 합
select deptno, sum(sal)
from emp
group by deptno;

--4. having (합계를 구했을 때 9000이상인 그룹)
select deptno, sum(sal), count(*)
from emp
group by deptno
having sum(sal) >= 9000;

--Q001
--EMP 테이블에서 SUM 함수를 이용하여 급여 합계(SAL)를 출력하시오.
select sum(sal)
from emp;

--Q002
--EMP 테이블에서 SUM 함수를 이용하여 사원이름과 급여 합계를 출력하시오.
--에러가 난다면 그이유를 적으시오.  ename 갯수와 급여합 갯수가 안맞아서
--SELECT ENAME, SUM(SAL)
--FROM EMP

SELECT ENAME, SUM(SAL)
FROM EMP
group by ENAME;

--Q003
--EMP 테이블에서 SUM 함수를 이용하여 추가수당(COMM) 합계를 출력하시오.
select sum(comm)
from emp;

--Q004
--EMP 테이블에서 SUM (DISTINCT, ALL)함수를 이용하여 급여 합계를 출력하시오.
select sum(DISTINCT sal), sum(ALL sal), sum(sal)
from emp;

--Q005
--EMP 테이블에서 COUNT를 이용하여 데이터의 갯수를 출력하시오.
select count(*)
from emp;

--Q006
--EMP 테이블에서 COUNT를 이용하여 부서번호가(EMPNO) 30인 데이터의 갯수를 출력하시오.
select count(*)
from emp
where deptno=30;

--Q007
--EMP 테이블에서 COUNT ( DISTINCT, ALL) 를 이용하여 데이터의 갯수를 출력하시오.
select COUNT(DISTINCT sal),count(ALL sal), count(sal)
from emp;

--Q008
--EMP 테이블에서 COUNT를 이용하여 추가수당(COMM) 열의 갯수를 출력하시오.
select count(comm)
from emp;

--Q009
--EMP 테이블에서 COUNT를 이용하여 추가수당(COMM) 열의 갯수를 출력하시오.
--위와 실행결과가 같음
--COUNT는 NULL 처리가 들어가 있음.
select count(comm)
from emp
where comm is not null;

--Q010
--EMP 테이블에서 MAX를 이용하여 부서번호(DEPTNO)가 10번인 사원들의 최대 급여를 출력하시오.
select max(sal)
from emp
where DEPTNO=10;

--Q011
--EMP 테이블에서 부서번호(DEPTNO)가 10번인 사원들의 최소 급여를 출력하시오.
select min(sal)
from emp
where deptno=10;

--Q012
--EMP 테이블에서 부서번호가 20인 사원의 입사일(HIREDATE) 중 제일 최근 입사일을 출력하시오.
select max(HIREDATE)
from emp
where deptno=20;

--Q013
--EMP 테이블에서 부서번호가 20인 사원의 입사일(HIREDATE) 중 제일 오래된 입사일을 출력하시오.
select min(HIREDATE)
from emp
where deptno=20;

--Q014
--EMP 테이블에서 부서번호가 30인 사원의 평균급여를 출력하시오.
select avg(sal)
from emp
where deptno=30;

--Q015
--EMP 테이블에서 부서번호가 30인 사원의 DISTINCT로 중복을 제거한 급여 열의 평균급여를 출력하시오.
select avg(DISTINCT sal)
from emp
where deptno=30;

--Q016
--EMP 테이블에서
--집합연산자(UNION ALL) 를 사용하여 각 부서별 평균급여를 출력하시오.  union all 중복제거 안하고 합집합 , union 중복제거하고 합집합 
SELECT  AVG(sal)  ,10 as deptno
FROM emp
WHERE deptno = 10

UNION ALL

SELECT AVG(sal) ,20
FROM emp
WHERE deptno = 20

UNION ALL

SELECT  AVG(sal),30
FROM emp
WHERE deptno = 30;

--Q017
--EMP 테이블에서 GROUP BY를 사용하여 부서별 평균급여를 출력하시오.
select avg(sal), deptno
from emp
group by deptno;

--Q018
--EMP 테이블에서 부서번호(DEPTNO) 및 직책별(JOB) 평균급여(SAL)로 정렬한 후 출력하시오.
SELECT deptno, job, AVG(sal) 
FROM emp
GROUP BY deptno, job
ORDER BY deptno, job;

--Q019
--EMP 테이블에서 GROUP BY절에 없는 열을 SELECT절에 포함하면 에러가 난다.
--그이유를 적으시오.
SELECT ENAME, DEPTNO, AVG(SAL)
FROM EMP
GROUP BY ENAME ,DEPTNO;

--Q020
--EMP 테이블에서 GROUP BY 와 HAVING 절을이용하여
--각부서의 직책별 평균급여를 구하되 그 평균급여가 2000이상인 그룹만 출력하시오.
SELECT DEPTNO, job, AVG(SAL)
FROM EMP
GROUP BY DEPTNO, job
having avg(sal) >= 2000
order by DEPTNO, job;

--Q021
--다음 코드가 오류나는 이유를 적으시오
--SELECT DEPTNO, JOB, AVG(SAL)
--FROM EMP
--WHERE AVG(SAL) >= 2000
--GROUP BY DEPTNO, JOB
--ORDER BY DEPTNO, JOB;
SELECT DEPTNO, JOB, AVG(SAL)
FROM EMP
GROUP BY DEPTNO, JOB
HAVING AVG(SAL) >= 2000
ORDER BY DEPTNO, JOB;

--Q022
--WHERE 절을 사용하지 않고 HAVING절만 사용한 경우
SELECT DEPTNO, JOB, AVG(SAL)
FROM EMP
GROUP BY DEPTNO, JOB
HAVING AVG(SAL) >= 2450
ORDER BY DEPTNO, JOB;

--Q023
--WHERE절과 HAVING절을 모두 사용한경우
SELECT DEPTNO, JOB, AVG(SAL)
FROM EMP
WHERE SAL <= 3000
GROUP BY DEPTNO, JOB
HAVING AVG(SAL) >= 2000
ORDER BY DEPTNO, JOB; --6

--Q024
--EMP 테이블에서
--부서별(큰그룹) 직책(소그룹)의
--사원수, 가장 높은 급여, 급여의 합, 평균급여를 출력하시오.
select deptno, job,count(*),max(sal),sum(sal),avg(sal)
from emp
GROUP BY deptno, job
ORDER BY deptno, job;

--Q025
--EMP 테이블에서 ROLLUP 함수를 이용하여
--부서별(큰그룹) 직책(소그룹)의
--사원수, 가장 높은 급여, 급여의 합, 평균급여를 출력하시오.
select deptno, job,count(*),max(sal),sum(sal),avg(sal)
from emp
GROUP BY ROLLUP(deptno, job)
ORDER BY deptno, job;
--Q026
--EMP 테이블에서 CUBE(DEPTNO, JOB) 함수를 이용하여
--부서별(큰그룹) 직책(소그룹)의
--사원수, 가장 높은 급여, 급여의 합, 평균급여를 출력하시오.
select deptno, job,count(*),max(sal),sum(sal),avg(sal)
from emp
GROUP BY cube(deptno, job)
ORDER BY deptno, job;
--Q027
--EMP 테이블에서
--DEPTNO를 먼저 그룹화한후 ROLLUP 함수에 JOB을 지정하여
--사원수를 출력하시오.

--Q028
--EMP 테이블에서
--JOB을 먼저 그룹화한후 ROLLUP 함수에 DEPTNO을 지정하여
--사원수를 출력하시오.
--Q029
--EMP 테이블에서
--GROUPING SETS (DEPTNO, JOB) 함수를 사용하여
--열별 그룹으로 묶어어 결과로 출력하시오.
--Q030
--EMP 테이블에서 DEPTNO JOB열의 그룹화결과를 GROUPING 함수로 출력하시오.

