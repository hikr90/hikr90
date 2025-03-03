package ex2_output;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex2_FileOutput {
	public static void main(String[] args) throws IOException {
		// 
		String path = "C:/JAVA1_0713_KTH/fileOutput.txt";
		File f = new File(path);
		FileOutputStream fos = null;
		//
		try {
			//
			fos = new FileOutputStream(f);
			//
			String msg = "file Output스트림의 예제";
			String msg2 = "\n두번째 줄, 한글도 잘 나온다.";
			//
			
			/*	getBytes
			 *		- 문자열의 문자 인코딩을 다른 인코딩으로 변환하는 메소드
			 *		- 파라미터로 다른 타입의 인코딩 타입을 넣어 사용할 수 있다.
			 *
			 *			(1) byte [] utf8_str = "가".getBytes("UTF-8");		// 문자열 > UTF-8
			 *			(2) String str = new String(utf8_str, "UTF-8"); 	// byte [ ] > 문자열
			 */
			fos.write(msg.getBytes());		// String > byte [ ] 로 변경
			fos.write(msg2.getBytes());
					
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				fos.close();
			}
	}	// main
}
