##1. node+react

###1. node.js
- javascript 런타임 환경
- 비동기 이벤트 기반

#### (1) 설치
https://node.js.org/ko

#### (2) 프로젝트 만들기
```js
npm init 
```
■ [실습]
[project]
ㄴ back   # node  ✅
ㄴ front  # react
```js
mkdir back
cd back
npm init
```

■ 구조확인
back/
├── config/
│   └── db.js                   # Oracle Db 설정
├── middlewares/
│   └── isAuthenticated.js      # 로그인 인증 미들웨어
├── models/
│   └── users.js                # 사용자 DB 모델 및 쿼리함수
├── passport/
│   ├── index.js                # Password 초기화
│   └── local.js                # Local 전략 설정
├── routes/
│   └── user.js                 # 사용자 관력 api 라우터
├── node_modules/               # npm 패키지
├── .env                        # 환경변수
├── app.js                      # 서버 진입점
├── package.json                # ✅ 프로젝트 설정 및 스크립트  
├── package-lock.json           # 패키지 버전 고정 
├── test1_model_testUsers.js    # 테스트 스크립트

```js
사용하고자 하는 모듈설정이 들어간 package.json 폴더에 넣기
npm install
```

#### (3) 서버진입점(app.js)
1. app.js 작성
2. 실행
```js
npx nodemon app.js
```

### 개발
### 1. model
```js
이름           null?       유형            
------------ -------- ------------- 
APP_USER_ID  NOT NULL NUMBER        
EMAIL        NOT NULL VARCHAR2(100) 
PASSWORD              VARCHAR2(100) 
MBTI_TYPE_ID          NUMBER        
CREATED_AT            DATE          
UFILE                 VARCHAR2(255) 
NICKNAME              VARCHAR2(50)  
MOBILE                VARCHAR2(20)  
```

(2) db설정 
back/
├── config/
│   └── db.js              #     Oracle Db 설정        
├── .env                   #     환경변수  

2-1. .env  
```js
```

2-2. [config] - db.js
```js
``` 

(3) [models] - [users.js]
(4) 모델함수 테스트

### 2. ROUTE
├── routes/
│   └── user.js                 # 사용자 관련 api 라우터

주소경로
post  : /user/register (requestBody)
post  : /user/login    (requestBody)
post  : /user/logout
get   : /user/
patch : /user/{id}/nickname
※비교 /user/nickname?id=1
delete : /user/{id}

1. [routes] - user.js

### 3. Passport 로그인 흐름 확인
```js
back/
├── middlewares/
│   └── isAuthenticated.js      # 로그인 인증 미들웨어
├── passport/
│   ├── index.js                # Password 초기화
│   └── local.js                # Local 전략 설정
```
1. [passport] - local.js Local 전략 설정
2. [passport] - index.js Password 초기화
3. [router] - user.js
4. app.js

1) 클라이언트 요청 /user/login
2) 라우터         /routes/user.js
3) passport/local.js : db조회 - findUserByEmail 성공 done(null, user)
4) passport/local.js : 로그인 성공시 호출 - user.APP_USER_ID 세션저장
5) app.js : 세션에 저장(exprress) 쿠키(connect.td)
6) passport/local.js 이후 요정마다, deserialiaeUs 세션에 저장된 APP_USER_ID 꺼내 사용자 정보 확인
7) middlew/isAisAuthenticated(로그인 여부 확인)

## ##  PROJECT
[project]
    ㄴback  : boot+jwt+redis+oauth2.0+jpa+mybatis
    ㄴfront : react+next+antd

    
###1. [BACK] boot+security+jwt+redis+oauth2.0+jpa+mybatis

1. JAVA 17
2. SPRING BOOT (gradle)
3. boot+security+jwt+redis+oauth2.0+jpa+mybatis 

- SPRING boot (애플리케이션 기반의 프레임워크/ 내장 tomcat / 자동설정 )
- SPRING security (인증,인가/필터체인의 요청보호/oauth2.0 같은 인증방식으로 쉽게 연동)
- jwt( json web token : 토큰기반의 인증방식 / 토큰안에 사용자 정보와 권한을 담아 전달 ,
       서버가 세션을 직접 관리하지 않고, 클라이언트가 토큰을 보관)
- redis( 캐시/세션을 관리 , refresh token을 저장, 캐싱처리에 활용, 분산환경에서 세션공유 가능 )
- oauth2.0 (외부인증 연동, 구글, 네이버, 카카오로그인)
- jpa(  orm기반의 데이터베이스 접근 , 엔티티클리스와 db테이블 매핑, sql작성없이 객체중심의 데이터 처리)
- mybatis ( 복잡한 쿼리 작성 )

1.  SPRING boot  → 애플리케이션 실행기반
2.  SPRING security + jwt/oauth2.0   → 인증/인가 처리
3.  redis   →  토큰/세션/캐시관리
4.  jpa + mybatis  → 데이터베이스 접근 (orm + sql mapper 병행)

<br/>

##### [실습]  1. 스프링부트 프로젝트 
- [x] 1. 개발개요안내
- [x] 2. java.sun.com - JAVA 17 다운로드 - 설치
- [x] 3. SPRING BOOT   - https://spring.io/ - 다운로드 - 설치
  > 이전버젼
  https://github.com/spring-projects/spring-tools/wiki/Previous-Versions
- [x] 4. SPRING BOOT 프로젝트 만들기
- [x] 5. lombok


<br/>

##### [실습] 2. model  
