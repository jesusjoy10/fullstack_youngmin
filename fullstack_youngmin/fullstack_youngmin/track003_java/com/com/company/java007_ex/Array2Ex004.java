package com.company.java007_ex;

public class Array2Ex004 {
	public static void main(String[]args) {
		//변수
		char[][] arr= new char[2][3]; // 2층 3칸
                                      // A B C 		
		 //입력                        // B C D
		char ch='A';
		
		//출력
		for (int i = 0; i < arr.length; i++) { //아파트 층개수
			for (int kan = 0; kan < arr[i].length; kan++) { //칸의 개수
				arr[i][kan] = ch++;
			} 
			ch='B'; // 한층이 끝나면 해야할일
		} 
     
		for (int i = 0; i < arr.length; i++) { // 아파트 층 개수
			for (int kan = 0; kan < arr[i].length; kan++) { // 칸의 개수
				System.out.print(arr[i][kan] + "\t");
			}
			System.out.println(); //한층이 끝나면 해야할일
			
		}
	}

}

/*배열을 이용하여 다음의 프로그램을 작성하시오.   
1. new 연산자 이용하여 다차원배열만들기
2. for + length 이용해서 대입   
3. for + length 이용해서 출력 
   A   B   C
   B   C   D
*/
