package ex4_char_stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex3_BufferedReader {
	public static void main(String[] args) throws IOException {
		
		String path = "C:/JAVA1_0713_KTH/test.txt";
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			// file Ŭ���� ���� path ��θ� ����־ ������ ����.
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			
			// ���� ������ �ѱ��ھ��ϴ� ������ �ܾ�� �ٸ���, �� �پ� ������´�.
			// readline�� ���̻� ���� ���� ���� ��� null�̶�� ���� ��ȯ�ȴ�.
			String msg = "";
			
			while((msg = br.readLine())!=null) {
				// ���پ� ��������� ���� ĳ������ �ʿ䰡 ����.
				System.out.println(msg);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			br.close();
			fr.close();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
