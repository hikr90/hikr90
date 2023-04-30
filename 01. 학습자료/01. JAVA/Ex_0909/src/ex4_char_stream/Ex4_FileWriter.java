package ex4_char_stream;

import java.io.FileWriter;
import java.io.IOException;

public class Ex4_FileWriter {
	public static void main(String[] args) throws IOException {
		
		String path = "C:/JAVA1_0713_KTH/fileWriter예제.txt";
		FileWriter fw = null;
		
		try {
			
			fw = new FileWriter(path);
			String str1 = "저는 FileWriter의 예제입니다.\n";
			String str2 = "저도 같은 예제입니다.";
			
			// char기반의 출력 스트림(Writer)은 2byte씩 문자열을 전송할 수 있다.
			fw.write(str1);
			fw.write(str2);
			
			fw.flush();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			fw.close();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	} // main
}
