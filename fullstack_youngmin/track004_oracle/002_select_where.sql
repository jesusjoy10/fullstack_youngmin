-- 조건에 맞는 데이터 조회
-- #1. where    
-- #2. 비교연산자 : =(같다), !=, <> , ^= (다르다)  
-- #3. 논리연산자 : AND / BETWEEN    AND (범위지정) OR / IN ,    NOT 
-- #4. like : 패턴검색 
-- #5. null 처리 : null 여부확인
-- #6. 집합연산자 : union (중복제거하고 합집합), union all (중복포함하고 합집합),minus(차집합), intersect(교집합)

-- #1. 전체데이터 조회 ( emp 테이블에서)
select  * from emp;

-- #2. where 조건조회
select * from emp where empno=7839;  -- 같다 = 
select * from emp where empno!=7839;  -- 다르다 != 
select * from emp where empno<>7839;  -- 다르다 <> 
select * from emp where empno^=7839;  -- 다르다 ^=

select * from emp where empno= '7839' and ename= 'KING'; -- and 두가지다 조건이 맞아야함
select * from emp where empno= '7839' and ename='SCOTT'; -- x
select * from emp where empno= '7839' or ename='SCOTT'; -- or 둘중에 하나

select * from emp where sal*12 = 36000;
select * from emp where sal >= 3000;
select * from emp where ename >= 'S';
select * from emp where empno= '7839' and ename='SCOTT';

select * from emp where ename >= 'S';
select * from emp where ename <= 'SOR';

select * from emp where deptno>=20 and deptno<=30;  -- >= , <=
select * from emp where deptno between 20  and 30; -- between and는 이상과 이하 
select * from emp where deptno between 20  and 30;
select * from emp where deptno>=20 or deptno<=30;

select * from emp where deptno>=10 or deptno<=30;

select * from emp where deptno in (10,30);

select * from emp where ename = 'KING';  -- 이름이 알때
select * from emp where ename LIKE 'A%'; -- 이름이 A로 시작할때
select * from emp where ename LIKE '%A%'; -- 이름이 A가 중간
select * from emp where ename LIKE '%G'; -- G로 끝나는 
select * from emp where ename LIKE '_I%'; -- _첫글자 두번째 글자가 I 

select * from emp where comm= null; -- null (사실 빈칸임 데이터가 없음 - 상태) 
select * from emp where comm is null;
select * from emp where comm is not null;

--Q1. EMP 테이블의 모든 열을 조회하시오
select * from emp

--Q2. 부서번호가 30인데이터
select * from emp where deptno=30;

--Q3. 부서번호가 30 이고 job = 'SALESMAN'
select * from emp where deptno=30 and job = 'SALESMAN'

--Q4. or 이용해서 부서번호가 30이거나 job-CLERK 인 데이터만 조회하시오
select * from emp where deptno = 30 or job = 'CLERK'; 

--Q5. sal 12를 곱한 값이 36000d인행을 조회
select * from emp where sal*12=36000;

--SQL 처리순서
-- select                  3) * (모든컬럼값)
-- from   emp              1) emp 테이블 읽어오기
-- where sal * 12 =36000   2) 각행에 대해 (한 명 자료묶음) sal * 12 =36000  조건평가

--Q6. sal 3000이상인 행
select * from emp where sal>=3000;

--Q7. ENAME 열의 첫문자가 F와 같거나 뒤에 있는 행을 조회하시오
select * from emp where ENAME >= 'F';

--Q8. EMP테이블에서 ENAME 열의 문자열이 첫문자 F, 두번째 문자 O, 세번째 문자 R, 네번째문자열이 Z 인 문자열보다 앞에 있는 행을 조회하시오
SELECT *  FROM EMP WHERE ENAME <= 'FORZ';

--Q9. EMP테이블에서 != 를 이용하여 SAL열이 3000이 아닌 행을 조회하시오.
SELECT *  FROM EMP WHERE SAL != 3000;

--Q10. EMP테이블에서 <> 를 이용하여 SAL열이 3000이 아닌 행을 조회하시오.
SELECT *  FROM EMP WHERE SAL <> 3000;

-- Q11. EMP 테이블에서 ^= 를 이용하여 SAL열이 아닌 3000이 아닌 행을 조회하시오.
select * from emp where sal ^= 3000;

-- Q12. EMP 테이블에서 not 를 이용하여 SAL열이 아닌 3000이 아닌 행을 조회하시오.
select * from emp where NOT sal = 3000;

-- Q13. EMP 테이블에서 OR 를 이용하여 JOB 열이 'MANAGER','SALESMAN','CLERK' 중 하나라도 포함되는 행을 조회하시오
select * from emp where JOB = 'MANAGER' OR JOB='SALESMAN' OR JOB= 'CLERK';

-- Q14. EMP 테이블에서 IN를 이용하여 JOB 열이 'MANAGER','SALESMAN','CLERK' 중 하나라도 포함되는 행을 조회하시오 from ->where -> select
select * from emp where JOB IN ( 'MANAGER' ,'SALESMAN' , 'CLERK');

-- Q15. EMP 테이블에서 등가연산자와 AND 를 이용하여 JOB 열이 'MANAGER','SALESMAN','CLERK' 중 하나라도 포함되지 않는 행을 조회하시오
select * from emp where JOB !='MANAGER'  AND JOB ^= 'SALESMAN' AND JOB <> 'CLERK' ;

-- Q16. EMP 테이블에서 NOT IN 를 이용하여 JOB 열이 'MANAGER','SALESMAN','CLERK' 중 하나라도 포함되지 않는 행을 조회하시오
select * from emp where JOB NOT IN ( 'MANAGER' ,'SALESMAN' , 'CLERK');

-- Q17. EMP 테이블에서 대소비교연산자 (<= , >=) and를 이용하여 sal 열이 2000이상 3000이하인 행을 조회하시오
select * from emp where sal >=2000 and sal <=3000;

-- Q18. EMP 테이블에서 BETWEEN AND 를 이용하여 SAL 열이 2000이상 3000이하인 행을 조회하시오
select * from emp where sal BETWEEN 2000 and 3000;

-- Q19. EMP 테이블에서 NOT BETWEEN AND 를 이용하여 SAL 열이 2000이상 3000이하인 사이 이외의 행을 조회하시오
select * from emp where sal NOT BETWEEN 2000 and 3000; 

-- Q20. EMP 테이블에서 ENAME이 S로 시작하는 행을 조회하시오
select * from emp where ENAME LIKE 'S%';

-- Q21. EMP 테이블에서 ENAME이 두번째 글자가 L로 시작하는 행을 조회하시오
select * from emp where ENAME LIKE '_L%';

-- Q22. EMP 테이블에서 ENAME이 AN이 포함되어 있는 행을 조회하시오
select * from emp where ENAME LIKE '%AM%';

-- Q23. EMP 테이블에서 ENAME에 AM이 포함되어 있지 않은 행을 조회하시오
select * from emp where ENAME NOT LIKE '%AM%';

-- Q24. EMP 테이블에서 별칭을 사용하여 다음과 같이 '연간총수입' 행을 조회하시오
SELECT ENAME, SAL, SAL*12+COMM AS ANNSAL, COMM FROM EMP;

-- Q25.-- null (사실 빈칸임 데이터가 없음 - 상태) 
SELECT * FROM EMP WHERE COMM = NULL;

--Q26. IS NULL
SELECT *  FROM EMP WHERE COMM IS NULL;

--Q27. EMP테이블에서 직송상관이 있는데이터만 조회하시오
SELECT * FROM EMP WHERE MGR IS NOT NULL;

--Q28. - 되는 코드는? X -- null (사실 빈칸임 데이터가 없음 - 상태) 
SELECT * FROM EMP WHERE SAL > NULL  AND COMM IS NULL;

--Q29. - 되는 코드는?
SELECT *  FROM EMP WHERE SAL > NULL    OR COMM IS NULL;

--2025/10/15 복습문제

-- Ex1  emp 테이블에서 job 데이터 중복없이 조회 
select distinct job from emp;
-- Ex2
--조회할 테이블은 EMP 테이블이며 모든 열을 출력하시오.
--별칭 (AS)
--EMPNO → EMPLOYEE_NO,
--ENAME → EMPLOYEE_NAME,
--MGR → MANAGER,
--SAL → SALARY,
--COMM → COMMISSION,
--DEPTNO → DEPARTMENT_NO

--부서번호를 기준으로 내림차순으로 정렬하되,
--부서번호가 같다면 사원이름을 기준으로 오름차순 정렬하시오.
select  empno AS employee_no, ename  AS employee_name, job, mgr AS manager,  sal AS salary,  comm AS commission,  deptno  AS department_no from emp ORDER BY deptno DESC, ename ASC;

-- Ex3  
-- EMP테이블에서 대소비교연산자(<= , >= ) and 를 이용하여 sal 열이 2000이상 3000이하인인 행을 조회
select * from emp where sal >= 2000 and sal<=3000;
 

-- Ex4  
--  EMP테이블에서 BETWEEN AND 를 이용하여 sal 열이 2000이상 3000이하인인 행을 조회
select * from emp where sal between 2000 and 3000;
 
-- Ex5
-- EMP테이블에서 OR 를 이용하여 
-- JOB 열이 'MANAGER' ,'SALESMAN' , 'CLERK' 중 하나라도 포함되는 행을 조회
 select
 * from emp 
 where job= 'MANAGER'or job='SALESMAN' or job='CLERK';
 
-- Ex6
-- EMP테이블에서 IN 를 이용하여 
-- JOB 열이 'MANAGER' ,'SALESMAN' , 'CLERK' 중 하나라도 포함되는 행을 조회
-- from → where  → select  
select *
from emp 
where job in ( 'MANAGER' ,'SALESMAN' , 'CLERK');

-- Ex7. EMP테이블에서 ENAME이 S로 시작하는 행
 select *
 from emp 
 where ename like 'S%';
 
-- Ex8. EMP테이블에서 ENAME의 두번째 글자가 L인 행을 조회
  select *
  from emp 
  where ename like '_L%';
  
-- Ex9. EMP테이블에서 ENAME에 AN이 포함되어 있는 행을 조회
 select * 
 from emp 
 where ename like '%AM%';
 
