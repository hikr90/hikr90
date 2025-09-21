package ex4_work;

import java.io.File;

public class Ex1_Work {
	public static void main(String[] args) {
		//
		String path = "C:/JAVA1_0713_KTH/test.txt";
		File f1 = new File(path);
		
		// isFile
		//	- 객체의 파일 여부를 참거짓으로 반환한다.
		//	- 디렉토리의 경우 isDirectory 메소드 사용
		if(f1.isFile()) {
			// length : 파일의 사이즈 반환
			System.out.println("파일의 크기 : "+f1.length()+"byte");	
		}
		
		String path2 = "C:/JAVA1_0713_KTH";
		File f2 = new File(path2);
		//
		if(!f2.isFile()) {
			// list
			// 	- 폴더 내의 하위 목록을 String타입의 배열로 반환
			//	- 알파벳 순서로 정렬해서 반환한다.
			String [] name = f2.list();
			//
			for(int i=0;i<name.length;i++) {
				System.out.println(name[i]);
			}
		}
	}
}
