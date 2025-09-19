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

<details> <summary style="font-size:18px; font-weight:bold;">🔑트러블슈팅01(문자+숫자 연산)</summary>

```bash
System.out.println(10 + 3 + "+" + 1 + "+" + 3);
```

[문제점]: 예상 출력이 "103+13"일 것이라 생각했지만, 실제 출력은 "13+1+3"임.
<br>

[해결방안]: 자바에서는 연산 순서가 왼쪽에서 오른쪽, 숫자 + 숫자 → 산술 연산, 숫자 + 문자열 → 문자열 결합임.

10+3 → 13

13 + "+" → "13+"

"13+" + 1 → "13+1"

"13+1" + "+" → "13+1+"

"13+1+" + 3 → "13+1+3"

<br>

[느낀점]: 숫자와 문자열을 혼합한 연산에서는 연산 순서와 타입 변환 규칙을 반드시 이해해야 함.
잘못된 예상 출력은 대부분 연산 순서와 타입 변환 이해 부족에서 발생.

</details>

<details> <summary style="font-size:18px; font-weight:bold;">🔑트러블슈팅02(short끼리 덧셈 시 타입 오류)</summary>

```bash
short sh1 = 1;
short sh2 = 2;

// 산술연산시 자동으로 int 변환
short result1 = (sh1 + sh2); // 오류 발생
int result2 = sh1 + sh2;     // 정상
```

[문제점]:

short + short 연산 시 자동으로 int로 변환됨

따라서 short result1 = sh1 + sh2; 는 컴파일 오류 발생

[해결방안]:

연산 결과를 short로 다시 캐스팅하거나, 결과 타입을 int로 변경:

short result1 = (short)(sh1 + sh2); // 캐스팅 후 정상
int result2 = sh1 + sh2;            // 기존 코드 정상


[느낀점]:

자바에서 정수형 산술연산은 자동으로 int로 변환됨

타입 변환 규칙을 이해하지 못하면 오류를 쉽게 겪을 수 있음

</details>





<details> <summary style="font-size:18px; font-weight:bold;">🔑트러블슈팅03(문법 오류)</summary>

```bash
if(i==1) {System.out.println("one");}
else if(i==2) {System.out.println("two");}
else if(i==3) {System.out.println("three");}
else if {System.out.println("1,2,3이 아니다");} // 오류 발생 부분
```

[문제점]:

else if { ... } 는 조건식이 없음 → 컴파일 오류 발생

초보자는 else if 와 else의 차이를 혼동하기 쉬움.

[해결방안]:

조건이 없는 경우는 else 를 사용해야 함:

if(i==1) {System.out.println("one");}
else if(i==2) {System.out.println("two");}
else if(i==3) {System.out.println("three");}
else {System.out.println("1,2,3이 아니다");} // 수정 완료


[느낀점]:

if-else if-else 문법을 정확히 이해해야 오류를 피할 수 있음.

조건 없는 마지막 경우는 항상 else 를 사용해야 함.

</details>

<details>
<summary style="font-size:18px; font-weight:bold;">🔑트러블슈팅04(switch 문 오류)</summary>

```java
public class Test006 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("숫자를입력하세요>");
		int num1 = scanner.nextInt();

		switch (num1) 
		case 1 : System.out.println("mango"); break;
		case 2 : System.out.println("noodle"); break;
		case 3 : System.out.println("orange"); break;
		default : System.out.println("1,2,3이 아닙니다"); break;
	}
}
[문제점]
switch 문에 중괄호 {}가 없어, case 구문이 블록 외부에 위치함. → 문법 오류 발생.

[해결방안]
switch 문은 중괄호 {}로 감싸야 하며, 모든 case 구문은 그 안에 작성해야 함.

switch (num1) {
  case 1: System.out.println("mango"); break;
  case 2: System.out.println("noodle"); break;
  case 3: System.out.println("orange"); break;
  default: System.out.println("1,2,3이 아닙니다"); break;
}
[느낀점]
Java에서 switch는 구조가 간단해 보여도 기본 문법을 어기면 치명적인 에러가 발생한다. 항상 중괄호 포함 여부를 확인해야 함.

</details> ```

<details> <summary style="font-size:18px; font-weight:bold;">🔑트러블슈팅05(for문 세미콜론 실수)</summary>
for (int i = 0; i < 5; i++); {
    System.out.println("Hello");
}


[문제점]
for문 끝에 세미콜론(;)이 있어서, 반복문이 빈 실행문으로 처리되어 "Hello"가 한 번만 출력됨.

[해결방안]
for문 끝 세미콜론을 제거하고 중괄호{}를 붙여서 반복문 블록을 올바르게 작성한다.

for (int i = 0; i < 5; i++) {
    System.out.println("Hello");
}


[느낀점]
세미콜론 하나로 인해 반복문이 무력화될 수 있으니, for문 뒤에 세미콜론이 없는지 항상 주의해야 한다.

</details>
