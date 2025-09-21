package ex2_char_stream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex1_Reader_Writer {
	public static void main(String[] args) throws IOException {
		/*	Reader & Writer 
		 *		- ���ڱ�� ��Ʈ��
		 *		- �ѱ��� �� ���ڿ� 2byte�� �����Ǿ� �����Ƿ� InputStream�� ����ϴ� ��� �ѱ��ڸ� �迭�� ������ ��ƾ��Ѵٴ� �������� �ִ�.
		 *		- �Ϲ������δ� 2byte�� ó���� ������ char����� ��Ʈ���� Reader, Writer�� ����Ѵ�.
		 *		- ���� �����͸� �ٷ�µ� �ʿ��� ���� ������ ���ڵ��� �ڹٿ��� ����ϴ� �����ڵ� ���� ��ȯ�� �ڵ������� ó�����ش�.
		 *			(Reader�� Ư�� ���ڵ��� �о �����ڵ�� ��ȯ�ϰ�, Writer�� �����ڵ带 Ư�� ���ڵ����� ��ȯ�Ͽ� �����Ѵ�.)
		 */
		
		// (1) Reader
		String path1 = "C:/JAVA1_0713_KTH/fileOutput.txt";
		File f = new File(path1);
		FileReader fr = null;
		//
		try {
			//
			fr = new FileReader(f);
			int code = -1;
			//
			while((code=fr.read())!=-1) {
				System.out.print((char)code);
			}
			
		} catch (Exception e) {

		} finally {
			fr.close();
		}
	
		// (2) Writer
		String path2 = "C:/JAVA1_0713_KTH/fileWriter����.txt";
		FileWriter fw = null;
		//
		try {
			//
			fw = new FileWriter(path2);
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
	}
}
