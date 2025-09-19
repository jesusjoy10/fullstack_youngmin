package com.company.java100_Test;

public class Test2 {
	public static void main(String[] args) {
		int [][] arr = new int[2][3];   // 00 01 02 / 10 11 12
		int data = 101;
		
		
		for(int ch = 0;  ch<arr.length; ch++) {  
			for(int kan = 0;  kan<arr[ch].length; kan++) {
				arr[ch][kan] =  data++;
			}			
			data = 201;
		}	
		for (int ch = 0; ch < arr.length; ch++) {
			for (int kan = 0; kan < arr[ch].length; kan++) {
				System.out.print( arr[ch][kan] + "\t");
			}System.out.println();
		}

    } //end main 
}//end class
