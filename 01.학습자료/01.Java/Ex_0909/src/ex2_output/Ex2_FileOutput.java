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
			fos.write(msg.getBytes());		// getBytes는 String을 바이트 배열로 변환하는 메소드이다.
			fos.write(msg2.getBytes());
					
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				fos.close();
			}
	}	// main
}
