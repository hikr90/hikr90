package ex2_output;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex2_FileOutput {
	public static void main(String[] args) throws IOException {
		
		String path = "C:/JAVA1_0713_KTH/fileOutput.txt";
		File f = new File(path);
		
		FileOutputStream fos = null;
					
			// 쓰는 순간 파일이 날아갈 수 있으니 동일하게 try-catch한다.
			try {
				
				fos = new FileOutputStream(f);
				// fileOutput에 넣을 내용
				String msg = "file Output스트림의 예제";
				String msg2 = "\n두번째 줄, 한글도 잘 나온다.";
				
				// Stream은 바이트 기반의 스트림이기 때문에 기록하고자하는 문자열 msg를 바이트의 배열로 변환하여 기록해야한다.
				// String타입.getBytes() : String 데이터를 바이트 배열로 변환 
				fos.write(msg.getBytes());
				fos.write(msg2.getBytes());
					
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				fos.close();
			}
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}	// main
}
