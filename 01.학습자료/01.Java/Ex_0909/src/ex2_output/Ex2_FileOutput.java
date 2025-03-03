package ex2_output;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex2_FileOutput {
	public static void main(String[] args) throws IOException {
		// 
		String path = "C:/JAVA1_0713_KTH/fileOutput.txt";
		File f = new File(path);
		FileOutputStream fos = null;
		//
		try {
			//
			fos = new FileOutputStream(f);
			//
			String msg = "file Output��Ʈ���� ����";
			String msg2 = "\n�ι�° ��, �ѱ۵� �� ���´�.";
			//
			
			/*	getBytes
			 *		- ���ڿ��� ���� ���ڵ��� �ٸ� ���ڵ����� ��ȯ�ϴ� �޼ҵ�
			 *		- �Ķ���ͷ� �ٸ� Ÿ���� ���ڵ� Ÿ���� �־� ����� �� �ִ�.
			 *
			 *			(1) byte [] utf8_str = "��".getBytes("UTF-8");		// ���ڿ� > UTF-8
			 *			(2) String str = new String(utf8_str, "UTF-8"); 	// byte [ ] > ���ڿ�
			 */
			fos.write(msg.getBytes());		// String > byte [ ] �� ����
			fos.write(msg2.getBytes());
					
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				fos.close();
			}
	}	// main
}
