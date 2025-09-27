package ex6_work;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Ex4_Work {
	public static void main(String[] args) throws IOException {

		// �ѱ� ����
		String path = "C:/JAVA1_0713_KTH/test.txt";
		File f = new File(path);	// ���� ��üȭ
		byte [] b_read = new byte[(int)f.length()];	// byte �迭�� ������ �����ŭ ����
		
		// heap �������� ���� ����
		FileInputStream fis = null;
		// 
		if(f.exists()) {
			//
			try {
				// heap ������ �޸� �Ҵ�
				fis = new FileInputStream(f);
				
				// read
				// - char stream ��Ŀ��� byte �迭�� ������ ��Ʈ�� �����͸� �״�� �ִ� �޼ҵ�
				fis.read(b_read);
			
				// ��Ʈ���� ��� �ѱ��� String Ÿ������ �����ؼ� Ȯ��
				String res = new String(b_read);
				System.out.println(res);
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(fis!=null) {
					// ��Ʈ���� ���������Ƿ�, �����Ѵ�.
					fis.close();
				}
			}
		}
	}
}
