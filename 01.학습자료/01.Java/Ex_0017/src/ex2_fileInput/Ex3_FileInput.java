package ex2_fileInput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ex3_FileInput {
	public static void main(String[] args) throws IOException {
		
		// ����
		// - ���������� test.txt �� �о
		// - ���� ���� ������ ȸ�������� �ƴ����� �Ǵ��ϼ���.

		String path = "C:\\JAVA1_0713_KTH/test.txt";
		File f = new File(path);	// ���� ��üȭ
		//
		FileInputStream fis = null;
		byte [] b_read = new byte[(int)f.length()];
		String rev = "";
		//
		if(f.exists()) {
			//
			try {
				fis = new FileInputStream(f); // ��Ʈ�� ����
				fis.read(b_read); // ����
				//
				String ori = new String(b_read);
				//
				for(int i=ori.length()-1;i>=0;i--) {
					rev += ori.charAt(i);
				}
				//
				if(ori.equals(rev)) {
					System.out.println(ori+"(��)�� ȸ�����Դϴ�.");
				}else {
					System.out.println(ori+"(��)�� ȸ������ �ƴմϴ�.");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(fis!=null) {
					fis.close(); // ��� ����
				}
			}
		}
	}
}
