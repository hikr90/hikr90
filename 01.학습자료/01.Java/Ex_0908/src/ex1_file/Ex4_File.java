package ex1_file;

import java.io.File;

public class Ex4_File {
	public static void main(String[] args) {
		
		// FileŬ������ ������ ���� �� �ִµ�, ������ ���� �� ����.
		String path = "C:/JAVA1_0713_KTH/abc";		
		File f = new File(path);
		
		// exists�� ���� Ŭ������ ������ path��α��� ���������� �������� �����̳� ������ ������ ��� ���� ��ȯ�Ѵ�.
		if(!f.exists()) {
			System.out.println("���� ���� �Ϸ�");
			// mkdir�� ���� �ϳ��� ������ ���������� �������ش�. 
			// mkdirs�� ���� ������ ������ �������ش�. 
			//f.mkdir();
			// �Ѱ��� �� ���� mkdirs�� ����� ��� mkdirs�� ����ص� �ȴ�.
			f.mkdirs();
		}else {
			System.out.println("������ �̹� �����մϴ�.");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	} // main
}
