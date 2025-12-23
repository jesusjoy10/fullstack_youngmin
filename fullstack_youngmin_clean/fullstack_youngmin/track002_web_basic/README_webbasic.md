### 🎯 김영민 | 단순한 기능 구현을 넘어, 사용자 흐름을 설계하고 전 과정을 이끄는 개발자입니다.

**복잡한 구조를 단순하게**, **팀의 생산성**을 높이는 **커뮤니케이션**이 저의 강점입니다.

기술은 수단입니다. **목표**는 **비즈니스에 임팩트를 주는 결과**입니다.

<br/>
<br/>
<br/>

## contact & Links

<img src="./track002_web_basic/img/정장입은남성.png" alt= "프로필사진" width="300"/>

| | |
|-|-|
|NAME|김영민
|EMAIL|dudals5292xn@naver.com|
|GITHUB|https://github.com/jesusjoy10/fullstack_youngmin|

---

## Golds

- **웹 문서 구조 작성 HTML**을 활용해 웹 페이지의 기본 구조를 설계하고 콘텐츠를 적절히 배치할 수 있음

- 정보 구획 및 시각적 구성 **HTML 요소와 CSS 속성**을 활용해 콘텐츠를 논리적으로 나누고 **시각적으로** 구분할 수 있음

- 텍스트 및 레이아웃 스타일링 **CSS를 이용해 글자 색상, 크기, 정렬, 여백** 등을 조절하여 일관된 디자인을 구현할 수 있음

- 기초 웹페이지 디자인 구현 **HTML과 CSS를 연계해 간단한 웹페이지를 직접 제작**할 수 있음
<br/>
<br/>
<br/> 

## ✅ HTML & CSS 기반 웹 개발 역량

| 기술 스택             | 실무 중심 CS 역량 설명 |
|----------------------|------------------------|
| **HTML5**            | 웹 문서 구조 설계 / 콘텐츠 구성 HTML 태그를 활용해 문서 구조를 설계하고, 텍스트·이미지·링크 등 콘텐츠를 적절히 배치할 수 있습니다. |
| **CSS3**             | 스타일링 / 레이아웃 구현 선택자, 색상, 글꼴, 박스 모델 등을 활용해 시각적 디자인과 기본 레이아웃을 구성할 수 있습니다. |
| **웹 프로젝트 실습** | 페이지 구현 / 실전 적용 HTML과 CSS를 연계하여 실습 프로젝트 기반의 웹 페이지를 직접 설계하고 구현한 경험이 있습니다. |
| **디버깅 및 문제 해결** | 코드 검토 / 오류 수정 HTML/CSS 코드의 구조적 오류나 스타일 충돌을 분석하고 수정하는 기본적인 디버깅 능력을 갖추고 있습니다. |
| **반응형 디자인 기초** | 화면 크기 대응 / 콘텐츠 배치 다양한 디바이스 환경에 맞춰 콘텐츠를 재배치하고, 기본적인 반응형 레이아웃을 적용할 수 있습니다. |


<br/>
<br/>
<br/> 

###  web basic 트러블 슈팅


<details>
<summary style= "font-size:18px; font-weight:bold;">🔑트러블슈팅01(문법오류)</summary>

```bash
<p class="text">안녕하세요</p>
css
코드 복사
.text {
  color: blue}

```

[문제점]: CSS 스타일이 페이지에 적용되지 않음.
<br>

[해결방안]: CSS 문법 오류 확인. 세미콜론(;) 누락으로 스타일 적용 실패.→ color: blue; 로 수정 후 정상 적용.
<br>

[느낀점]: 기본 문법 실수도 렌더링 문제로 이어질 수 있음. CSS 작성 후 항상 문법 체크 필요.
</details>

<details>
<summary style= "font-size:18px; font-weight:bold;">🔑트러블슈팅02(문법오류)</summary>

```bash
코드 복사
<h1>제목</h1>
<p>내용</p>
css
코드 복사
h1 {
  font-size: 24px}
  ``` 

[문제점]: 글자 크기가 적용되지 않음.
<br>

[해결방안]: CSS 문법 확인. 세미콜론(;) 누락으로 스타일 적용 실패.
→ font-size: 24px; 로 수정 후 정상 적용.
<br>

[느낀점]: 작은 문법 실수도 스타일 적용 실패로 이어질 수 있음. 브라우저에서 항상 확인 필요.
</details>


<details>
<summary style= "font-size:18px; font-weight:bold;">🔑트러블슈팅03(문법오류)</summary>

```bash
코드 복사
<img src="images/picture.png" alt="사진">
```

[문제점]: 이미지가 화면에 나타나지 않음.
<br>

[해결방안]: 파일 경로 확인. 경로 오타나 폴더 위치 오류로 인해 이미지 로드 실패.
→ 실제 이미지 경로 확인 후 src="img/picture.png" 등 올바르게 수정.
<br>

[느낀점]: HTML 요소가 안 보일 때는 항상 파일 경로와 브라우저 콘솔 오류 먼저 체크. 

</details>

<details>
<summary style= "font-size:18px; font-weight:bold;">🔑트러블슈팅04(레이아웃오류)</summary>

```bash
/* Q3: 콘텐츠 박스를 가운데 배치하고 너비를 50%로 설정하려면?
   - 너비: 50%
   - 좌우 자동 마진으로 가운데 정렬 */
   .container{
    width: 50%; 
    margin:auto;}


**<div class="container">**
        <h1>나의 포트폴리오</h1>
        <div class="card">
            <p><img src="./img/portfolio1.jpg" alt="웹앱사진"></p>
            <h2>쇼핑몰 웹앱</h2>
            <p>React + Firebase 기반의 쇼핑몰 웹 애플리케이션</p>
            <p>사용 기술: React, Firebase, Styled-components</p>
            <a href="#" class= "more-btn" title="더보기 새창열기" > 더보기</a>
```

[문제점]: card가 화면에 나타나지 않음.
<br>

[해결점]: **<div class= "container">** 기입했더니 카드가 다시 생김!
<br>

[느낀점]: HTML 구조와 CSS 스타일이 서로 연결되어야 화면에 요소가 제대로 표시된다는 점을 깨달음.

</details>




<details>
<summary style= "font-size:18px; font-weight:bold;">🔑트러블슈팅05(레이아웃오류)</summary>

```bash
/* Q7: 카드에 마우스를 올렸을 때 그라디언트 테두리를 나타내려면?
   - 위치: 카드 바깥쪽 (-3px)
   - 배경: 45도 방향의 그라디언트 (#00c9ff → #92fe9d)
   - 둥근 테두리: 18px
   - 투명도: hover 시 1로 변경

    :: before 가상요소 카드보다 살짝 크게 만들기 */
   .card::before{
    content: "";
    position: absolute;
    top:-3px; left: -3px; right: -3px; bottom: -3px;
    background-image: linear-gradient(45deg, #00c9ff,#92fe9d);
    border-radius: 15px;
    opacity:0;
    transition: opacity 0.5 ease;
   }
   .card:hover:before{
    opacity:1;
   }
   ```

[문제점]: 카드 위 마우스 올렸을 시 백그라운드 색상이 모두 덮여서 내용이 안보임
<br>

[해결점]: **z-index**: -1  코드 추가 (카드 바깥쪽에 그라디언트 테두리 효과를 만들면서 → z-index: -1로 카드 내용보다 뒤에 배치해 내용을 가리지 않게 함)
<br>

[느낀점]: hover 효과를 구현할 때, 내용을 가리지 않으면서 시각 효과를 넣는 방법을 이해함.
</details>


<details>
<summary style= "font-size:18px; font-weight:bold;">🔑트러블슈팅06(문법오류)</summary>

```bash
   .card::before
    content: "";
    position: absolute;
    top:-3px; left: -3px; right: -3px; bottom: -3px;
    background-image: linear-gradient(45deg, #00c9ff,#92fe9d);
    border-radius: 15px;
    opacity:0;
    z-index: -1;
    **transition: opacity 0.5 ease;**
  ```

[문제점] : 0.5는 단순 숫자 → 시간 단위(s)가 빠져서 CSS가 인식하지 못함 (transition: opacity 0.5 ease; )
<br>

[해결점]: 0.5s로 시간 단위(s)를 명시해야 CSS가 정상적으로 처리함  (ease는 속도 곡선으로, 부드럽게 시작하고 끝나는 애니메이션을 의미함)
<br>

[느낀점]: hover 효과를 구현할 때, 내용을 가리지 않으면서 시각 효과를 넣는 방법을 이해함.
</details>
