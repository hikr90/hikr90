package ex1_file;

import java.io.File;

public class Ex3_File {
	public static void main(String[] args) {
		
		String path = "C:/JAVA1_0713_KTH";	// ���� ���
		File f1 = new File(path);	// ���� ��üȭ
		//
		if(f1.isDirectory()) {
			// listFiles �� ���� ��ü �迭 ���·� ���丮 �� ���� ������ ��Ƽ� ��ȯ�Ѵ�.
			File [] ar = f1.listFiles();
			//
			for(int i=0;i<ar.length;i++) {
				// getName �޼ҵ�� ������ ��Ī�� �����´�.
				if(ar[i].isDirectory()) {
					System.out.println(ar[i].getName());
				}
				
				// [����] ���� Ŭ������ �뷮, ����/���� ���� ���� ������ Ȯ�� �����ϳ� ���� ���� ������ �������� ���� �Ұ����ϴ�.
			}
		}
	}
}
