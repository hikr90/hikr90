package ex1_file;

import java.io.File;

public class Ex4_File {
	public static void main(String[] args) {
		
		// File클래스는 폴더는 만들 수 있는데, 파일은 만들 수 없다.
		String path = "C:/JAVA1_0713_KTH/abc";		
		File f = new File(path);
		
		// exists는 파일 클래스가 접근한 path경로까지 물리적으로 빠짐없이 파일이나 폴더가 존재할 경우 참을 반환한다.
		if(!f.exists()) {
			System.out.println("폴더 생성 완료");
			// mkdir은 없는 하나의 폴더를 물리적으로 생성해준다. 
			// mkdirs는 없는 폴더를 복수로 생성해준다. 
			//f.mkdir();
			// 한개만 할 때도 mkdirs는 상관이 없어서 mkdirs만 사용해도 된다.
			f.mkdirs();
		}else {
			System.out.println("폴더가 이미 존재합니다.");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	} // main
}
