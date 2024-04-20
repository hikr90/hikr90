package ex4_char_stream;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ex1_FileReader {
	public static void main(String[] args) throws IOException {
		
		String path = "C:/JAVA1_0713_KTH/fileOutput.txt";
		// �� ��θ� ����
		File f = new File(path);
		
		// char ����� ��Ʈ���� FileReader�� �ѱ��� �Է¹ޱ⿡ �����ϴ�.
		// 2byte�̹Ƿ� �ѱ��� �ɰ��� �������� �ʴ´�.
		FileReader fr = null;
		
		try {
			
			fr = new FileReader(f);
			int code = -1;
			
			// char����� ��Ʈ���� read()�޼��尡 ����� 1byte, �ѱ��� 2byte�� �����͸� ���� �� �־�, �ѱ��� ���������� ����� �����ϴ�.
			while((code=fr.read())!=-1) {
				System.out.print((char)code);
			}
			
		} catch (Exception e) {

		}finally {
			fr.close();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
