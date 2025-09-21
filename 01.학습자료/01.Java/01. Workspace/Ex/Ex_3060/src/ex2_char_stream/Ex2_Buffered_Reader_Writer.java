package ex2_char_stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex2_Buffered_Reader_Writer {
	public static void main(String[] args) throws IOException {
		// (1) Buffered Reader
		String path = "C:/JAVA1_0713_KTH/test.txt";
		FileReader fr = null;
		BufferedReader br = null;
		//
		try {
			// ���� Ŭ�������� �ٷ� ��θ� �־ ������ �߻����� �ʴ´�. 
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			
			// readLine
			// - buffered reader���� ��Ʈ���� �����͸� �� ���ξ� �������� �޼ҵ�
			// - ���̻� ���� �� �ִ� �����Ͱ� ���� ��� null �� ��ȯ�Ѵ�.
			String msg = "";
			//
			while((msg = br.readLine())!=null) {
				// �� ���ξ� �������Ƿ� ���� ����ȯ�� �� �ʿ䰡 ����.
				System.out.println(msg);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			br.close();
			fr.close();
		}
		
		// (2) Buffered Writer
		String path2 = "C:/JAVA1_0713_KTH/BufferedWriter����.txt";
		File f = new File(path2);
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
