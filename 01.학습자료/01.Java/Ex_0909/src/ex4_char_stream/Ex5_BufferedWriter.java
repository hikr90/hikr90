package ex4_char_stream;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ex5_BufferedWriter {
	public static void main(String[] args) throws IOException {
		//
		String path = "C:/JAVA1_0713_KTH/BufferedWriter����.txt";
		File f = new File(path);
		//
		FileWriter fw = null;
		BufferedWriter bw = null;
		//
		try {
			fw = new FileWriter(f);
			bw = new BufferedWriter(fw);
			//
			String str = "�������abc";
			bw.write(str);
			
			// newLine
			// - �� ������ �ڵ����� ����ִ� ����̴�.
			// - buffered Writer������ ��� �����ϴ�.
			bw.newLine();
			bw.write("�����̿� ������sss");
			bw.flush();
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			bw.close();
			fw.close();
		}
	}
}
