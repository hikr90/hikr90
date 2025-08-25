package ex1_file;

import java.io.File;

public class Ex3_File {
	public static void main(String[] args) {
		
		String path = "C:/JAVA1_0713_KTH";	// 폴더 경로
		File f1 = new File(path);	// 파일 객체화
		//
		if(f1.isDirectory()) {
			// listFiles 는 파일 객체 배열 형태로 디렉토리 내 하위 파일을 담아서 반환한다.
			File [] ar = f1.listFiles();
			//
			for(int i=0;i<ar.length;i++) {
				// getName 메소드로 파일의 명칭을 가져온다.
				if(ar[i].isDirectory()) {
					System.out.println(ar[i].getName());
				}
				
				// [참고] 파일 클래스는 용량, 폴더/파일 여부 등의 정보는 확인 가능하나 파일 내의 내용을 가져오는 것은 불가능하다.
			}
		}
	}
}
