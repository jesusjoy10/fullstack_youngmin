### 🚀 김영민 | 문제 해결 중심 풀스택 개발자
**아이디어**를 **서비스로 연결**하는 개발자.
기획 → 개발 → 배포까지 직접 경험하며 실전 역량을 키운 포트폴리오.

**끊임없이 개선점**을 찾고 적용하며
**실제 서비스**와 가까운 프로젝트를 만들어왔습니다.

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

- GitHub 주요 기능을 익히고 프로젝트 관리에 적극 활용

- Markdown 기반 문서화를 통해 가독성 있는 기술 문서 작성 경험 축적

- 팀 협업을 위한 GitHub Flow & Pull Request 프로세스 실무 적용

- 최신 AI 도구를 활용해 개발 생산성과 문제 해결 속도 향상
<br/>
<br/>
<br/> 

<!-- cs와 연결지어서 -->

## ✅ JavaScript 기반 웹 개발 역량

| 기술 스택               | 실무 중심 CS 역량 설명 |
|------------------------|------------------------|
| **Git & GitHub**   | 브랜치 전략과 이슈 관리를 통해 협업 효율을 높이고, 안정적인 코드 통합 및 배포 사이클을 운영한 경험이 있습니다. |
| **Markdown**   | 프로젝트 문서·가이드·회의록을 명확히 정리하여 팀 내 정보 공유와 협업 커뮤니케이션을 원활히 이끌었습니다. |
| **Visual Studio Code**       | 다양한 확장 기능과 디버깅 툴을 활용해 생산적인 개발 환경을 구축하고, 반복 작업을 자동화하여 효율을 높였습니다. |
| **HTML5**    | 시맨틱 태그와 접근성 원칙을 적용하여 사용자 친화적이고 검색 최적화된 웹 페이지를 설계·구현했습니다.|
| **CSS** | 레이아웃과 스타일링 적용 박스 모델과 Flex/Grid 기본을 활용해 웹 페이지 구조를 잡고, 색상·폰트·간단한 전환 효과를 적용하여 깔끔하고 직관적인 디자인을 구현한 경험이 있습니다. |

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

