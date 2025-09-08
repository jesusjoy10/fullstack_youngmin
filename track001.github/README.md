### 🚀 김영민 | 문제를 비즈니스 기회로 바꾸는 개발자
기능을 만드는 데 그치지 않습니다. 사용자의 **흐름을 설계하고**, **기획부터 배포까지** 주도하며, **결과로 증명하는 개발자**입니다.

컴퓨터공학 기반의 문제 해결력으로 **복잡한 구조**를 **단순하게** 만들고

**협업**과 **커뮤니케이션** 중심의 실전 경험으로 **팀의 생산성**을 끌어올립니다

기술은 수단일 뿐, **비즈니스에 임팩트**를 주는 결과가 목표입니다

<br/>
<br/>
<br/>

---
<!--
1.이미지 (캐리커쳐)
 이름, 이메일, 깃허브주소, 포트폴리오 2*4의 테이블형식으로 -->
## contact & Links


<img src="./track002_web_basic/img/건장한남성.png" alt="프로필" width="300" />


| | |
|-|-|
|NAME|김영민
|EMAIL|dudals5292xn@naver.com|
|GITHUB|https://github.com/jesusjoy10/fullstack_youngmin|

_ _ _
<!-- track001 github -->
## Golds

- JavaScript의 핵심 문법과 흐름 제어를 이해하고 실습 → 변수 선언, 자료형, 연산자, 조건문(if), 반복문(for) 등 기초 로직을 직접 구현하며 동작 원리를 체득

- 사용자 중심의 동적 기능 구현 경험 → 버튼 클릭, 조건 출력, 반복 처리 등 인터랙션 중심 기능을 직접 설계하고 구현

- DOM 조작을 통한 웹 요소 제어 능력 강화 → querySelector, innerText, style 등을 활용해 HTML 요소를 선택하고 동적으로 변경하는 실습 경험

- 콘솔 디버깅과 로직 개선을 통한 문제 해결력 향상 → console.log를 활용한 흐름 추적, 조건 검토, 반복문 오류 수정 등 실습 기반 디버깅 경험
<br/>
<br/>
<br/> 

<!-- cs와 연결지어서 -->

## ✅ JavaScript 기반 웹 개발 역량

| 기술 스택               | 실무 중심 CS 역량 설명 |
|------------------------|------------------------|
| **JavaScript (기초)**   | 웹 동작 제어 / 로직 구현  
변수 선언, 자료형 이해, 연산자 활용 등 기본 문법을 통해 동적인 웹 기능을 구현할 수 있습니다. |
| **제어문 (if / for)**   | 조건 처리 / 반복 로직  
`if`, `for`문을 활용해 조건 분기 및 반복 처리 로직을 작성하며, 사용자 입력이나 데이터 흐름을 제어할 수 있습니다. |
| **DOM 기초 조작**       | 웹 요소 접근 / 동적 변경  
`document.querySelector`, `innerText`, `style` 등을 활용해 HTML 요소를 선택하고 동적으로 변경하는 기초 능력을 갖추고 있습니다. |
| **웹 프로젝트 실습**    | 동적 기능 구현 / 실전 적용  
실습을 통해 버튼 클릭, 조건 출력, 반복 처리 등 간단한 인터랙션 기능을 직접 구현한 경험이 있습니다. |
| **코드 디버깅 및 개선** | 오류 분석 / 로직 수정  
콘솔 출력과 조건 검토를 통해 자바스크립트 오류를 분석하고, 반복문/조건문 로직을 개선하는 경험을 쌓았습니다. |

<br/>
<br/>
<br/> 

___
<!-- java, HTML+CSS+JS/JQUERY-->
<!-- ## 포트폴리오>
<br/>
<br/>
<br/> 

---
<!-- 정리해놓은 day1,day2 -->
## 🔧트러블슈팅 (github에서 발생)

<details>
<summary style= "font-size:18px; font-weight:bold;">🔑트러블슈팅01(커밋오류)</summary>

```bash
$ git commit -m "git 수정 후 다시올리기"
Changes not staged for commit:
  modified:   day001.md
no changes added to commit
```

- **[문제점]** 
수정한 파일이 커밋되지 않음. git add를 해도 반응이 없었음.

- **[해결방안]** 
너무나도 단순한 이유였음 → 파일을 저장하지 않음. 에디터에서 수정 후 저장하지 않은 상태로 커밋을 시도함.

- **[느낀점]** 
기본적인 실수지만, 실무에서도 충분히 발생할 수 있는 상황. 작업 전 저장 습관화가 중요하며, 커밋 전 git status 확인은 필수다.
</details>

<details>
<summary style= "font-size:18px; font-weight:bold;">🔑트러블슈팅02(커밋오류)</summary>

```bash
$ git commit -m "test"
nothing to commit, working tree clean
```

- **[문제점]** 
커밋할 변경사항이 없다는 메시지. 하지만 실제로는 작업한 파일이 존재함.

- **[해결방안]**
 작업한 파일을 워크스페이스에 추가하지 않음. 새 파일을 프로젝트 폴더에 넣지 않아 Git이 인식하지 못함. → 파일을 워크스페이스에 추가 후 정상 커밋.

- **[느낀점]**
 Git은 추적 가능한 경로에 있는 파일만 관리한다는 점을 다시금 인지. 파일 위치와 Git 상태를 항상 함께 확인해야 한다.
</details>


<details>
<summary style= "font-size:18px; font-weight:bold;">🔑트러블슈팅03(병합충돌)</summary>

```bash
$ git pull origin master
Auto-merging day002.md
CONFLICT (content): Merge conflict in day002.md
Automatic merge failed; fix conflicts and then commit the result.
```

- **[문제점]** 
원격 저장소와 로컬 파일 간의 충돌 발생. 자동 병합 실패.

- **[해결방안]**
충돌 파일 비교 후 로컬에서 직접 수정

git add로 변경사항 스테이징

git commit -m "test"로 커밋

git push origin master로 푸시

- **[느낀점]**
 충돌은 협업에서 자주 발생하는 상황. 충돌 메시지를 정확히 읽고, 침착하게 해결하는 능력이 중요하다. Git은 단순한 도구가 아니라 협업의 핵심 시스템이라는 점을 체감함.
</details>
<br/>
<br/>
<br/> 

---
## 참고문헌
- [Git 공식 문서](https://git-scm.com/doc)  
- [Markdown 가이드](https://www.markdownguide.org/basic-syntax/)  
- [VS Code 공식 사이트](https://code.visualstudio.com/)  
- [AI 프롬프트 작성 팁](https://learn.microsoft.com/en-us/azure/ai-services/openai/how-to/prompt-engineering)

