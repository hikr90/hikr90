package ex1_file;

import java.io.File;

public class Ex1_File {
	public static void main(String[] args) {
		
		/*	�����
		 *		- ����� ��Ʈ���� ���Ѵ�.
		 *		- ��Ʈ���̶�, ����ӽſ��� �����͸� ������ϱ����� ��ημ� ������ �о���̰ų� �ܼ��� ���� �������� ������ �Ѵ�.
		 *		- (�ܼ��� ��Ŭ������ �ܺ� ������ ����޸�, sdī��, Ű����, ���콺, c����̺� ���� ���Ѵ�.) 
		 * 
		 * 	- ����¿��� ������ jvm�̴�.
		 * 		output : �ַܼ� �����͸� �����ϴ� �۾�
		 * 		input : �ܺο� �ִ� �����͸� ��Ŭ������ �ַܼ� �������� �۾�
		 */
		//
		String path = "C:/JAVA1_0713_KTH/test.txt"; 		// ���� ���
		File f = new File(path);		// ���� Ŭ���� ��üȭ
		
		// isFile�� �ش� ��ü�� ���������� ��, �������� ��ȯ�Ѵ�. (���丮�� ��� isDirectory �޼ҵ�� �Ǻ��Ѵ�.)
		if(f.isFile()) {
			System.out.println("������ ũ�� : "+f.length()+"byte");	// length �Լ��� ������ ����� ��ȯ�Ѵ�.
		}
	}
}
