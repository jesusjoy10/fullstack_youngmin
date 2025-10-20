package com.company.java016_Javaio;

import java.io.File;

public class JavaIO001_folder_file {

	public static void main(String[] args) {
		// 1. 경로체크		
		String folder_abs="C:\\file\\"; //절대경로 (시스템의 폴더기준-전체경로 c:\)
		String folder_rel="src/com/company/java016_Javaio_ex/"; //상대경로 (현재작업 폴더기준)
		String file_path="io001.txt";
		
		// 2. 폴더 + 파일 준비 
		File folder = new File(folder_rel); //ctrl+shift + o'
		File file   = new File(folder_rel+ file_path);
		// 폴더가 없다면          폴더 만들기 
		try { //시도
			if(!folder.exists()) {folder.mkdirs();}
			if(!file.exists()) {file.createNewFile();}
		}catch(Exception e) {e.printStackTrace();} 
		
		System.out.println("폴더/파일 준비완료"); 
	} // ctlr + f11 / f5(새로고침)	
}
