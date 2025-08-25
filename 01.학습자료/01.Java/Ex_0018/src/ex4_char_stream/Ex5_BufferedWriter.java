package ex4_char_stream;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ex5_BufferedWriter {
	public static void main(String[] args) throws IOException {
		//
		String path = "C:/JAVA1_0713_KTH/BufferedWriter예제.txt";
		File f = new File(path);
		//
		FileWriter fw = null;
		BufferedWriter bw = null;
		//
		try {
			fw = new FileWriter(f);
			bw = new BufferedWriter(fw);
			//
			String str = "기억하자abc";
			bw.write(str);
			
			// newLine
			// - 한 라인을 자동으로 띄워주는 기능이다.
			// - buffered Writer에서만 사용 가능하다.
			bw.newLine();
			bw.write("갑돌이와 갑순이sss");
			bw.flush();
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			bw.close();
			fw.close();
		}
	}
}
