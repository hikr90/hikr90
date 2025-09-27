package ex6_work;

import java.io.File;

public class Ex3_Work {
	public static void main(String[] args) {
		
		String path = "C:/JAVA1_0713_KTH/abc";		// 파일 경로
		File f = new File(path);	// 파일 객체화
		
		// exists 메소드는 물리적으로 해당 디렉토리나 파일의 존재 여부를 참, 거짓으로 반환한다.
		if(!f.exists()) {
			//
			System.out.println("폴더 생성 완료");
			
			// mkdir 메소드는 파일 객체의 경로까지 디렉토리가 존재하지 않는 경우 최상위 폴더를 하나 생성한다.
			// mkdirs 메소드는 파일 객체의 경로까지 디렉토리가 존재하지 않는 경우, 해당 경로까지의 폴더를 전부 생성한다. (자주 사용된다.)
			f.mkdirs();
			
		} else {
			System.out.println("폴더가 이미 존재합니다.");
		}
	} // main
}
