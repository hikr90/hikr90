package ex1_file;

import java.io.File;

public class Ex3_File {
	public static void main(String[] args) {
		
		// list�� ���ϰ� ������ �����ؼ� �������� ���� �����ϴ�.
		String path = "C:/JAVA1_0713_KTH";
		File f1 = new File(path);
		
		// ��������� ������ ���
		if(f1.isDirectory()) {
			
			// listFiles�� ����Ŭ������ ��ȯ�ϴµ�, ���Ϸ� �޾ƾ� �뷮�̳� ���� Ȥ�� ������ ������ �ľ��� �� �ֱ� �����̴�.
			// ���� Ŭ�����̱⿡ ���� Ŭ������ �迭�� �޾ƾ��Ѵ�.
			File [] ar = f1.listFiles();
			
			// for������ ���
			for(int i=0;i<ar.length;i++) {
				// isDirectory�� ������ ������ �ľ��Ѵ�.
				// getName���� FileŬ���� �迭�� �̸��� ������ �� �ִ�.
				if(ar[i].isDirectory()) {
					System.out.println(ar[i].getName());
				}
				
				// ����Ŭ������ ���� : �뷮 �ľ� �� ����, ���� ������ Ȯ�� �����ϳ� ���� ���� ������ ��������� ���� �Ұ����ϴ�.
				
			}
			
			
		}
		
		
		
		
		
		
		
	}
}
