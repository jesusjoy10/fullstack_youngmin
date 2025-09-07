###  web basic 트러블 슈팅


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