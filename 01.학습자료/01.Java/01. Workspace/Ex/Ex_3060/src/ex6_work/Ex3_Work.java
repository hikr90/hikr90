package ex6_work;

import java.io.File;

public class Ex3_Work {
	public static void main(String[] args) {
		
		String path = "C:/JAVA1_0713_KTH/abc";		// ���� ���
		File f = new File(path);	// ���� ��üȭ
		
		// exists �޼ҵ�� ���������� �ش� ���丮�� ������ ���� ���θ� ��, �������� ��ȯ�Ѵ�.
		if(!f.exists()) {
			//
			System.out.println("���� ���� �Ϸ�");
			
			// mkdir �޼ҵ�� ���� ��ü�� ��α��� ���丮�� �������� �ʴ� ��� �ֻ��� ������ �ϳ� �����Ѵ�.
			// mkdirs �޼ҵ�� ���� ��ü�� ��α��� ���丮�� �������� �ʴ� ���, �ش� ��α����� ������ ���� �����Ѵ�. (���� ���ȴ�.)
			f.mkdirs();
			
		} else {
			System.out.println("������ �̹� �����մϴ�.");
		}
	} // main
}
