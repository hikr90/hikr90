package ex6_work;

import java.io.FileInputStream;

public class Ex6_Work {
	public static void main(String[] args) {
		
		// ��ĳ�� ���� �Է� �� ����
		// - ��� : C:\\JAVA1_0713_KTH/test.txt
		// - �� : ab�����̹ڼ�ba
		FileInputStream fis = null;
		byte [] read = new byte[100]; 
		byte [] console = new byte[100]; 
		//
		try {
			System.out.println("��� : ");
			// - Ű���忡�� �Ѿ�� ���� byte []�� ��´�. 
			// - ǥ���Է���ġ���� �Ѿ�� ���� system.in ��Ʈ���� ���ؼ� �ٷ� �о�� �� �ִ�.
			System.in.read(console);
			
			// ���ڿ��� ����
			String path = new String(console); // Ű���忡�� ���� ���� 
			
			// ���ڿ��� �޾Ƽ� ����
			fis = new FileInputStream(path.trim());
			fis.read(read);
			//
			String res = new String (read);
			System.out.println(res);
			
		} catch (Exception e) {

		}
	}
}
