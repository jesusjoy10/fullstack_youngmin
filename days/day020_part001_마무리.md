## Track001 -  github

> 1. (~18:00) 깃허브정리 day020.md
> 2. BANK 상담정리
1) Java Control      -  내용바꾸기
2) Java Array(3명)   -  내용바꾸기  
                        ( 동영상, youtube, 깃허브정리  : readme)
3) 자기소개페이지 -  (금)  css - transform / animation  
                     +  js - 아이디어 추가해서 자바스크립트기능  
 
# ■ Github   
### 12. 깃허브 협업 
---
[Paw] 성태훈 - 박현주 , 최상욱, 신준용, 한승현
https://github.com/taehun00/thejoeun.git
[버그헌터] 길상현 - 강서현, 유희재 , 김영민 , 김정민 
https://github.com/shgil0618-glitch/Bug-Hunters.git

■1. 팀 - 깃허브 
■2. 각 팀장포함 팀원들 브랜치만들기  > 초대 : sally03915@gmail.com
todo1) README.md  꾸미기
todo2) 팀명 / 팀원규칙
todo3) 포트폴리오 주제상의
	 1차 : [개인] - 자바포트폴리오 / 자기소개페이지     
     2차 : [팀]   - 미니프로젝트1(JSP)
	 			   주제에 관련된 - B2C 웹(고객중심) 서비스 구축 프로젝트  (커뮤니티)
	 3차 : [팀]   - 정규프로젝트1(Spring)
	 				주제에 관련된 - 수익형 풀 스택 프로젝트   (쇼핑몰)
	 4차 : [팀]   - 미니프로젝트2(React)
	 				주제에 관련된 - 홍보/마케팅이 가능한 SNS 웹사이트프로젝트 (SNS)
	 5차 : [팀]   - 최종프로젝트(Flutter 포함)
	 				주제에 관련된 - FLUTTER 추가 
미니1 & 미니2 = 발표 PPT 띄우고 사진+영상 촬영
정규1 & 최종 = 발표회 진행+사진+영상 촬영

# ■ Java
 
Test001)
	for/while/dowhile
		+,-,*,/ 입력받을때까지 무한반복 

Test002)
	이차원배열
	for + length

	101	102  103
	201 202  203

Test003 ~005) 다음에 해당하는 메서드를 작성하시오.
	public static void main(String[] args) {
		//3
		dog();   //멍멍
		
		//4
		disp(7, '*');  // ****
		

		//5
		System.out.println("당신의 학번은? " + stdId(1111));   //G1111
		
	}


Test006)
	이차원배열
A  B  C
a  b  c


Test007)
메서드 오버로딩  틀린것은?
---------------------------------------
int add(int x, int y) {return x+y;}
---------------------------------------
 
int  add(byte  a , byte  b) {  return a+b; }  //a
int  add(short a , short b) {  return a+b; }  //b
long add(int   a , int   b) {  return a+b; }  //c
long add(long  a , long b) {  return a+b; }   //d



Test008)
 call by value   vs   call by reference

public class Test008 {
	
	public static void print(int[]arr) { for(int i=0; i<arr.length; i++) { arr[i]+=10; } }
	
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		// call by value -   파라미터 ( 기본값 ) - 값을 복사해서 사용
		// public static int   print( int a ) {}
		System.out.println(print(arr[1]));  //2
		

		// call by reference -        파라미터 ( 주소값 ) -  주소를 참조해서(따라가서) 원본의 값을 바꿈
		// public static void   print(     int[] arr ) {}
		print(arr);
		System.out.println(Arrays.toString(arr)); 
	}
	
	public static int print(int i) { return i; }  //###
}



# ■ WebBasic

1. 깃허브에 docs 폴더만들기.   /docs/index.html
2. 레파지토리 Settings 에가서 page 설정
3. docs 에 index.html 파일올리기
4. 자기소개페이지 [5분]
> https://본인아이디.github.io/레파지토리이름/

https://sally03915.github.io/fullstack_20250825/

5. Contact Me
> https://www.emailjs.com/
1) 회원가입
2) 서비스만들기
3) 템플릿만들기
4) 코드 수정
	참고)
	https://www.emailjs.com/docs/sdk/installation/

