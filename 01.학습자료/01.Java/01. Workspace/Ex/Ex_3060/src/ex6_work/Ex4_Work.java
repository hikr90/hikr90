package ex6_work;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Ex4_Work {
	public static void main(String[] args) throws IOException {

		// 한글 파일
		String path = "C:/JAVA1_0713_KTH/test.txt";
		File f = new File(path);	// 파일 객체화
		byte [] b_read = new byte[(int)f.length()];	// byte 배열을 파일의 사이즈만큼 선언
		
		// heap 영역에는 없는 상태
		FileInputStream fis = null;
		// 
		if(f.exists()) {
			//
			try {
				// heap 영역에 메모리 할당
				fis = new FileInputStream(f);
				
				// read
				// - char stream 방식에서 byte 배열에 파일의 스트림 데이터를 그대로 넣는 메소드
				fis.read(b_read);
			
				// 스트림에 담긴 한글을 String 타입으로 변경해서 확인
				String res = new String(b_read);
				System.out.println(res);
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(fis!=null) {
					// 스트림이 열려있으므로, 종료한다.
					fis.close();
				}
			}
		}
	}
}
