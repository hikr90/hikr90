package ex4_char_stream;

import java.io.FileWriter;
import java.io.IOException;

public class Ex4_FileWriter {
	public static void main(String[] args) throws IOException {
		//
		String path = "C:/JAVA1_0713_KTH/fileWriter����.txt";
		FileWriter fw = null;
		//
		try {
			//
			fw = new FileWriter(path);
			String str1 = "���� FileWriter�� �����Դϴ�.\n";
			String str2 = "���� ���� �����Դϴ�.";
			
			// write �޼ҵ带 ���ؼ� �ܺ���ġ�� ����Ѵ�.
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
