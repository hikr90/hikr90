package ex1_file;

import java.io.File;

public class Ex2_File {
	public static void main(String[] args) {

		String path = "C:/JAVA1_0713_KTH"; 	// ���� ���
		File f = new File(path);	// ���� ��üȭ
		//
		if(!f.isFile()) {
			// ���� ��ü�� ������ ��� list �޼ҵ�� ���� ������ ����� String Ÿ���� �迭�� ���� �� �ִ�. (list�� ���ĺ� ������ ������´�.)
			String [] name = f.list();
			//
			for(int i=0;i<name.length;i++) {
				System.out.println(name[i]);
			}
		}
	}
}
