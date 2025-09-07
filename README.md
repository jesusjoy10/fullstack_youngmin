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

- GitHub의 **핵심 도구 활용법**을 익히고 실습

- Markdown을 활용한 **기술 문서 작성 역량** 강화

- 협업 중심의 **GitHub 프로젝트 운영 흐름** 학습

- AI 기반의 **스마트 개발 환경 실습**
<br/>
<br/>
<br/> 
___
<!-- cs와 연결지어서 -->
## 기술스택 기반 cs역량
기술스택 기반 CS 역량 및 실무 활용 능력

- **Git & GitHub** → 소프트웨어 공학 / 버전 관리 / 협업 모델링 브랜치 전략, 병합 충돌 해결, 이슈 기반 개발 등 실무 중심의 협업 능력을 직접 적용할 수 있습니다.

- **Markdown** → 기술 문서화 / 정보 구조화 능력 README, 개발 문서, API 문서 등을 명확하고 구조적으로 작성하여 팀 내 커뮤니케이션을 강화합니다.

- **VS Code** → 개발 생산성 / IDE 활용 능력 디버깅, 확장 기능, 자동화 설정 등 실무에서 즉시 활용 가능한 개발 환경 최적화 능력을 갖추고 있습니다.

- **HTML5** → 웹 구조 설계 / 컴퓨터 구조 이해 시맨틱 태그를 활용한 정보 구조화와 브라우저 렌더링 원리를 이해하여 사용자 중심의 웹 설계가 가능합니다.

- **CSS3** → UI/UX 설계 / 렌더링 최적화 반응형 디자인, 애니메이션, 스타일 최적화를 통해 실무에서 요구되는 사용자 경험을 구현할 수 있습니다.

- **AI- 프롬프트 활용** → 문제 해결 능력 / 정보 검색 최적화 / 창의적 사고 AI 도구를 활용해 반복 작업을 자동화하고, 실시간 문제 해결 및 아이디어 도출에 능숙하게 대응합니다.

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

- **[문제점]** 수정한 파일이 커밋되지 않음. git add를 해도 반응이 없었음.

- **[해결방안]** 너무나도 단순한 이유였음 → 파일을 저장하지 않음. 에디터에서 수정 후 저장하지 않은 상태로 커밋을 시도함.

- **[느낀점]** 기본적인 실수지만, 실무에서도 충분히 발생할 수 있는 상황. 작업 전 저장 습관화가 중요하며, 커밋 전 git status 확인은 필수다.
</details>

<details>
<summary style= "font-size:18px; font-weight:bold;">🔑트러블슈팅02(커밋오류)</summary>

```bash
$ git commit -m "test"
nothing to commit, working tree clean
```

- **[문제점]** 커밋할 변경사항이 없다는 메시지. 하지만 실제로는 작업한 파일이 존재함.

- **[해결방안]** 작업한 파일을 워크스페이스에 추가하지 않음. 새 파일을 프로젝트 폴더에 넣지 않아 Git이 인식하지 못함. → 파일을 워크스페이스에 추가 후 정상 커밋.

- **[느낀점]** Git은 추적 가능한 경로에 있는 파일만 관리한다는 점을 다시금 인지. 파일 위치와 Git 상태를 항상 함께 확인해야 한다.
</details>


<details>
<summary style= "font-size:18px; font-weight:bold;">🔑트러블슈팅03(병합충돌)</summary>
```bash
$ git pull origin master
Auto-merging day002.md
CONFLICT (content): Merge conflict in day002.md
Automatic merge failed; fix conflicts and then commit the result.
```

- **[문제점]** 원격 저장소와 로컬 파일 간의 충돌 발생. 자동 병합 실패.

- **[해결방안]**
충돌 파일 비교 후 로컬에서 직접 수정

git add로 변경사항 스테이징

git commit -m "test"로 커밋

git push origin master로 푸시

- **[느낀점]** 충돌은 협업에서 자주 발생하는 상황. 충돌 메시지를 정확히 읽고, 침착하게 해결하는 능력이 중요하다. Git은 단순한 도구가 아니라 협업의 핵심 시스템이라는 점을 체감함.
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

