package ex4_work;

import java.io.File;

public class Ex1_Work {
	public static void main(String[] args) {
		//
		String path = "C:/JAVA1_0713_KTH/test.txt";
		File f1 = new File(path);
		
		// isFile
		//	- ��ü�� ���� ���θ� ���������� ��ȯ�Ѵ�.
		//	- ���丮�� ��� isDirectory �޼ҵ� ���
		if(f1.isFile()) {
			// length : ������ ������ ��ȯ
			System.out.println("������ ũ�� : "+f1.length()+"byte");	
		}
		
		String path2 = "C:/JAVA1_0713_KTH";
		File f2 = new File(path2);
		//
		if(!f2.isFile()) {
			// list
			// 	- ���� ���� ���� ����� StringŸ���� �迭�� ��ȯ
			//	- ���ĺ� ������ �����ؼ� ��ȯ�Ѵ�.
			String [] name = f2.list();
			//
			for(int i=0;i<name.length;i++) {
				System.out.println(name[i]);
			}
		}
	}
}
