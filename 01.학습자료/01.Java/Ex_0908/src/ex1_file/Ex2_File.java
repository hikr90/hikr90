package ex1_file;

import java.io.File;

public class Ex2_File {
	public static void main(String[] args) {

		// ��λ� �ִ� ���� ����� ��Ī�� ��������� ���
		String path = "C:/JAVA1_0713_KTH"; // ����
		File f = new File(path);
		
		// FileŬ������ ���ٰ�ΰ� ���� ������ �ƴ� ���� ������ ��� 
		if(!f.isFile()) {
			
			// f.list()�� ���� ������ ����� ������� �� �ִ�.
			// list�� StringŸ���� �迭���·� ��ȯ�Ѵ�.
			// list�� ���ĺ� ������ �����Ѵ�.
			String [] name = f.list();

			for(int i=0;i<name.length;i++) {
				System.out.println(name[i]);
			}
					
		
		}
	
	
	
	
	
	
	
	
	
	
	
	}
}
