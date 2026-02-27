-- 003_select_function.sql
-- 1. 문자열
-- 2. 숫자
-- 3. 날짜
-- 4. 변환
-- 5. 조건
---------------------------------------------------------------------
-- 003_select_function.sql
-- 1. 문자열
-- 1-1 upper 대문자, lower 소문자, initcap 대소문자 변환 
-- 1-2 length 문자열길이
-- 1-3 subster 부분문자열, instr 위치문자열
-- 1-4 replace 바꾸기 , lpad, rpad [123** ]
-- 1-5 trim 공백빼기, ltrim, rtrim 공백빼기
-- 1-6 concat 문자열

-- #1. 대소문자
select ename, upper(ename), lower(ename), initcap(ename)
from    emp;

-- #2. 문자열길이
select ename, length(ename) , lengthb(ename), '킹'  , length('킹') , lengthb('킹')
from emp;

-- #3. substr(문자열, 어디서부터 , 몇개)  부분문자열, instr 위치문자열
select ename , substr(ename,1,2) , substr(ename,1,3), substr(ename,2,2), substr (ename,3,2)  from emp; 
select substr('oracle' ,-1) , substr('oracle' ,-3) , substr('oracle' ,-3,2)from dual;
--             뒤부터 1번째           뒤부터 3번째            뒤부터 3번째 글자에서 2번째까지
select substr('oracle' ,-2) , substr('oracle' ,-2,1) from dual;

select instr('oracle' , 'a') from dual; -- o(1) r(2) a(3) c(4) l(5) e(6)
select ename, instr(ename, 'A') from emp; --있으면 위치, 없으면 0

-- #4. replace 어떤 문자열을 찾아서 바꾸기 , lpad, rpad 채우기
select replace('010-1234-5678', '-',' ') from dual; 
select lpad('oracle', 10 , '#'), rpad('oracle', 10 , '#') from dual; -- (left 채우기)

-- #5. trim, ltrim, rtrim 공백빼기
select trim(' *oracle* ') , ltrim(' *oracle* ') , rtrim(' *oracle* ') from dual;

-- #6. concat 문자열연결- 두개 문자열만 연결가능
select concat('Hello','oracle') from dual;
select concat(concat('Hello','oracle'), '★') from dual;  -- concat 중첩해서 사용

select 'Hello' || 'oracle' || '♥' from dual;

-- ##1. 문자열 연습문제

--Q001 EMP 테이블에서 ENAME을 대문자, 소문자, 첫글자만 대문자로 조회하시오.
select ename, upper(ename), lower(ename), initcap(ename)
from    emp;

--Q002 EMP 테이블에서 UPPER를 이용하여 ENAME이 KING인 데이터를 조회하시오.
select ename , upper(ename) 
from emp
where upper(ename)= upper('king');

--Q003EMP 테이블에서 UPPER를 이용하여 ENAME에 KING인 포함된 데이터를 조회하시오.
--대소문자 상관없이 KING인 사람을 조회하는 것이 가능해짐.
select ename , upper(ename) 
from emp
where upper(ename)like upper('%king%');

--Q004 EMP 테이블에서 LENGTH를 이용하여 ENAME의 문자열 길이를 조회하시오.
select ename, length(ename)
from emp;

--Q005 EMP 테이블에서 ENAME의 문자열 길이가 5이상인 데이터를 조회하시오.
select ename, length(ename)
from emp
where length(ename)>=5;

--Q006 LENGTH('한글'), LENGTHB('한글') 문자열길이반환, 문자열 바이트 수 반환환
select LENGTH('한글'), LENGTHB('한글')
from dual;

--Q007 문자열 일부분을 추출 SUBSTR( 문자열 , 시작위치, 추출길이)
select job ,SUBSTR(job ,1,2) ,SUBSTR(job ,3,2) ,SUBSTR(job ,5)
from emp;

--Q008-의 의미는? C(-5)L(-4)E(-3)R(-2)K(-1)
select job , substr(job,-length(job)), substr(job,-length(job),2) , substr(job,-3)
from emp;

--Q009특정문자위치 찾기 INSTR(문자열, 찾을거, 시작위치, 몇번째째) 'HELLO, ORACLE!' 문자열에서 다음과 같이 찾으시오
1. 해당위치의 글자가 뭔지 확인 3,12,4 (L)
select 'HELLO, ORACLE!' 
, instr('HELLO, ORACLE!','L') as instr_1 
, instr('HELLO, ORACLE!','L',5) as instr_2 
, instr('HELLO, ORACLE!','L',2,2) as instr_3 
from dual;
--Q010 EMP테이블에서 INSTR 함수로 사원이름에 S가 있는 데이터를 조회하시오
select *
from emp
where instr(ename,'S')>0; -- instr은 못찾으면 0
--Q011 EMP테이블에서 LIKE를 이용하여 사원이름에 S가 있는 데이터를 조회하시오
select *
from emp
where ename like '%S%';

--Q012 REPLACE를 이용하여 연락처의 -을 공백으로, -을 뺀데이터로 조회하시오
select '010-1234-5678' as BEFORE ,replace('010-1234-5678', '-',' '), replace('010-1234-5678', '-')
from dual; 

--Q013 LPAD, RPAD를 이용하여 다음과 같이 데이터를 출력하시오오
select 'ORACLE' , lpad('Oracle',10,'#')lpad_1 , RPAD('Oracle',10,'*') rapd_1 ,  lpad('Oracle',10) lapd_2 , Rpad('Oracle',10) Rapd_2
from dual;
--Q014 RPAD를 이용하여 개인정보뒷자리 *로 출력하시오.
select RPAD('000224-',14,'*') as RPAD_JMNO ,RPAD('010-6351-',13,'*') 
from dual;
--Q015
--EMP 테이블에서 EMPNO와 ENAME 사이에 :을 넣고 문자열을 연결하시오.
select concat (empno,ename) , concat(empno , concat(':', ename))
from emp
where ename = upper('scott');
--Q016 TRIM을 이용하여 다음과 같이 공백을 제거하고 출력하시오.
select 
'[' || trim(' _ _oracle_ _ ') || ']' as trim -- 양쪽 공백제거 (중간에 있는 공백은 제거하지않음 )
, '[' || ltrim(' _ _oracle_ _ ') || ']' as trim -- 왼쪽 공백 제거
, '[' || rtrim(' _ _oracle_ _ ') || ']' as trim  -- 오른쪽 공백 제거
, '[' || trim(' _ _oracle_ _ ') || ']' as trim  --양쪽공백제거
from dual;

--Q017 TRIM을 이용하여 삭제할 문자 삭제후 출력가능능
-- TRIM을 이용하여 다음과 같이 공백을 제거하고 출력하시오.
select
   '[' ||  trim(' * *Oracle* * ') || ']' as trim  -- 양쪽공백제거 (중간에 있는공백은 제거하지 않음)
,  '[' ||  trim( LEADING   '*'FROM   '* *Oracle* *') || ']' as trim --  앞쪽공백제거
,  '[' ||  trim( TRAILING '*' FROM   '* *Oracle* *') || ']' as trim   --  뒤쪽공백제거
,  '[' ||  trim( BOTH     '*' FROM   '* *Oracle* *') || ']' as trim  -- 양쪽공백제거
from   dual;
--Q018 TRIM, LTRIM, RTRIM 사용하여 문자열 출력하기
select 
'[' ||         trim(' * *oracle* * ') || ']' as trim0  --양쪽공백없애기
, '[' ||       ltrim(' * *oracle* * ') || ']' as ltrim  -- 왼쪽공백없애기
, '[' ||       ltrim('*-oracle-*','*') || ']' as ltrim2 --원하는문자열없애기
, '[' ||       rtrim(' * *oracle* * ') || ']' as rtrim1  --오른쪽공백없애기
, '[' ||       rtrim('*-oracle-*','*') || ']' as rtrim2  -- 원하는문자열없애기
from dual;







