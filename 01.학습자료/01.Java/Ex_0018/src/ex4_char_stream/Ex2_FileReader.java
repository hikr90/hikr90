package ex4_char_stream;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ex2_FileReader {
	public static void main(String[] args) throws IOException {
		
		// ����
		// - test.txt �� ������ file reader�� ���� ��, �빮�ڿ� �ҹ��ڰ� ���� � �ִ��� �����ּ���.
		// - ���
		// - �빮�� : �� ��
		// - �ҹ��� : �� ��
		String path = "C:/JAVA1_0713_KTH/test.txt";
		File f = new File(path);
		FileReader fr = null;
		//
		try {
			//
			fr =  new FileReader(f);
			int code = -1;
			int upper = 0;
			int lower = 0;
			//
			while((code=fr.read())!=-1) {
				//
				if(code>='A'&&code<='Z'){
					upper++;
				}
				//
				if(code>='a'&&code<='z') {
					lower++;
				}
			}
			//
			System.out.println("�빮�� : "+upper);
			System.out.println("�ҹ��� : "+lower);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			fr.close();
		}
	}
}
