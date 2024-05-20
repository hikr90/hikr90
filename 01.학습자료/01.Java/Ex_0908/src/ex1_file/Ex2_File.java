package ex1_file;

import java.io.File;

public class Ex2_File {
	public static void main(String[] args) {

		String path = "C:/JAVA1_0713_KTH"; 	// 폴더 경로
		File f = new File(path);	// 파일 객체화
		//
		if(!f.isFile()) {
			// 파일 객체가 폴더인 경우 list 메소드로 하위 폴더의 목록을 String 타입의 배열로 받을 수 있다. (list는 알파벳 순서로 가지고온다.)
			String [] name = f.list();
			//
			for(int i=0;i<name.length;i++) {
				System.out.println(name[i]);
			}
		}
	}
}
