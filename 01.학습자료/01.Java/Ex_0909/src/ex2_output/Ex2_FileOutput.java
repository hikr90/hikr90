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
			fos.write(msg.getBytes());		// getBytes�� String�� ����Ʈ �迭�� ��ȯ�ϴ� �޼ҵ��̴�.
			fos.write(msg2.getBytes());
					
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				fos.close();
			}
	}	// main
}
