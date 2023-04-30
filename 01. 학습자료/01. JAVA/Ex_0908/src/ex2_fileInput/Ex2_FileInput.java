package ex2_fileInput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ex2_FileInput {
	public static void main(String[] args) throws IOException {
		
		/*�ѱ� �о������ ����*/
		String path = "C:/JAVA1_0713_KTH/test.txt";		
		File f = new File(path);
		// byte�迭�� ������� �ʵ��� �������� �ƴ� ������ �뷮���� ���ߴ� ���� ����.
		byte [] b_read = new byte[(int)f.length()];
		
		// ���� heap�޸𸮿��� ������ ���� ����
		FileInputStream fis = null;
		
		if(f.exists()) {
			 
			try {
				fis = new FileInputStream(f);
				
				// byte �迭�� �޴´�.
				// byte �迭���� 2����Ʈ(��ĭ)�� ���ļ� �ѱ��� �����Ѵ�. 
				fis.read(b_read);
			
				// ���
				// �ѱ��� ��� byte[]�� String Ÿ������ �����Ͽ� ����� �����ϴ�. 
				String res = new String(b_read);
				System.out.println(res);
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(fis!=null) {
					// ��ΰ� ��� ���ݴ� ������ �߻��� ���ɼ��� �ִ�.
					// try-catch�� ��Ƶ� ������, �������� ������ ������ add  IOException ó���ϴ� ���̴�.
					fis.close();
				}
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
