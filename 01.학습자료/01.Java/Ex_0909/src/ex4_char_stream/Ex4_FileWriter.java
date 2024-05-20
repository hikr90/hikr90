package ex4_char_stream;

import java.io.FileWriter;
import java.io.IOException;

public class Ex4_FileWriter {
	public static void main(String[] args) throws IOException {
		//
		String path = "C:/JAVA1_0713_KTH/fileWriter예제.txt";
		FileWriter fw = null;
		//
		try {
			//
			fw = new FileWriter(path);
			String str1 = "저는 FileWriter의 예제입니다.\n";
			String str2 = "저도 같은 예제입니다.";
			
			// write 메소드를 통해서 외부장치에 출력한다.
			fw.write(str1);
			fw.write(str2);
			//
			fw.flush();
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			fw.close();
		}
	} // main
}
