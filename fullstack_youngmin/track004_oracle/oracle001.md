#1. 저장단위
변수 < 배열 < 클래스 < 콜렉션프레임워크 > file > DB 
※ DB(mysql, oracle, mssql)

> java : jdbc → dbcp → orm (mybatis, jpa)

#2. RDB (Relational Database) ★
-    관계형 데이터 베이스
-    테이블 관계
1. 엔티티(Entity)     - 테이블 - 관리할대상 (고객, 주문, 상품)
2. 속성(Attribute)    - 컬럼 - 대상의 특징 (주민번호, 이름, 주문번호)
3. 관계(Relationship) - 외래키- 대상간의 연결 - 고객은 주문을 한다.

#3. 데이터베이스 언어 ★
1. 정의어(DDL) - create, alter, drop .... cad
2. 조작어(DML) - intsert(삽입) , select(조회), update(수정), delete(지우기).... crud
3. 제어어(DCL) - grant, revoke

<<사원>>
> desc emp;
이름       널?       유형           
-------- -------- ------------ 
EMPNO    NOT NULL NUMBER(4)    
ENAME             VARCHAR2(10) 
JOB               VARCHAR2(9)  
MGR               NUMBER(4)    
HIREDATE          DATE         
SAL               NUMBER(7,2)  
COMM              NUMBER(7,2)  
DEPTNO            NUMBER(2)    

<<부서>>
이름     널?       유형           
------ -------- ------------ 
DEPTNO NOT NULL NUMBER(2)    
DNAME           VARCHAR2(14) 
LOC             VARCHAR2(13) 

> 부서는 많은 사원을 가질 수 있다.
관리대상(table) : dept       emp
속성(attribute): deptno     empno,deptno,,,
연결(Relationship): deptno

#4. SELECT

[실습]
1. 테이블 구조확인 : desc emp
2. 테이블 전체정보확인 : select 8 from emp;

1. 조작어 crd