package ex2_fileInput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Ex1_FileInput {
	public static void main(String[] args) {
		
		// ����
		// input
		// fileinput stream
		String path = "C:/JAVA1_0713_KTH/test.txt";
		// ��� ����
		File f = new File(path);
		
		if(f.exists()) {
			
			// FileInputStream : ���ϰ� ����� input stream(���)�� ����
			// path ��α��� �����ؼ�, ���� ������ �о�������� ��θ� �����Ѵ�. fileŬ������ �˷��� ��θ� ������ 
			// file not found exception�̶�� ���ܺ����� ����µ� �̸��� ã������ ����� ����(����)�̴�.
			// ���������ϴ� ���� �ּҰ� ����� ���ɼ��� ������ 
			try {
				
				// ��Ʈ���� ����
				// .... Stream : byte����� ��Ʈ�� (�����͸� �ε��� ��, 1����Ʈ���� ������ �� �ִ�.)
				// .... Reader, .... Writer : char����� ��Ʈ�� (�����͸� �ε��� ��, 2����Ʈ�� ������ �� �ִ�.)
				FileInputStream fis= new FileInputStream(f);
				
				int code = -1;
				
				// �ּҸ� ���� ���ε� �о�, 
				// �д� ���߿� �������ǰų� ���Ӱ� ����Ǹ� �߸� ������ �� �ִٴ� ���ܰ� �ִ�. 
				// read�ø��� �������ھ�.. ��Ʈ���� ���̻� ���� ���� ���� ��Ȳ�϶�  -1�� ��ȯ�Ѵ�. �̰��� EOF(END OF FILE)�̶�� �Ѵ�. 
				// ������ while���� eof�� ���������� �ݺ��ϸ� �ƽ�Ű�ڵ������� �����͸� ������ �о���̰� �ִ�.
				// <�ڵ尡 -1�� �ƴҶ������� �ݺ��ϴ� ���� ���� ������ ���� ������ �о��>
				while((code=fis.read())!= -1) {
					
					// �ȳ��ϼ���abc ���
					// stream�̹Ƿ� 1byte�� �������µ� �ѱ��� 2byte�̹Ƿ� ����������. (��ģ�ٰ� �� ���ڰ� �ƴ�)
					// char(code)�� �ϴ� ���� '��' �ѱ��ڰ� �ΰ��� ������ ���ִ°� ���� �ƽ�Ű�ڵ尡 �Ǽ� �̻��ϰ� ���´�. 
					System.out.print(code+" ");
					
				}	// while
				
				// ��� ����
				// file�� new�� ��������Ƿ� true���̴�.
				if(fis!=null) {
					// ��Ʈ���� new�� ��� ����� �������� close�� ���� �ݵ�� �ݾ�����.
					fis.close();
				}
				
				// ���� fis.read���� �߻��� �� �ִ� ioexception(���� ������ ����Ǿ� ������ ���� �� ����)�� not found(������ ��ã��������)�� ���� �� �� �ֵ��� �ϳ��� ����
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // try-catch
		
		
		
		
		
		
		
		
		
		
	}
}
