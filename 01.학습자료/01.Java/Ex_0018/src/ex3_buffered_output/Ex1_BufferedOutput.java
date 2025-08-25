package ex3_buffered_output;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex1_BufferedOutput {
	public static void main(String[] args) throws IOException {
		//
		String path = "C:/JAVA1_0713_KTH/bufferedOutput.txt";
		File f = new File(path);
		//
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		//
		try {
			// ���� ����
			fos = new FileOutputStream(f);
			bos = new BufferedOutputStream(fos);
			//
			String msg  = "Buf�ƿ�ǲ ��Ʈ���� exam";
			bos.write(msg.getBytes());
			
			/*	flush 
			 *		- ���ۿ� �����Ͱ� �ִ� ���� ������� ���ۿ��� ������ �о�� �޼ҵ�
			 *		- �о�ٴ� �ǹ̴� �Է�, ��¿��� �����ִ� �����͸� ������ ������ �۾� �Ϸ� ��Ų�ٴ� ���̴�.
			 *		- ������ ���������� ����ϱ����� ������ ������ġ�̴�.
			 */
			bos.flush();
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// - flush�� close�� �������� ����� ���� ���� ��Ȳ�� ����Ѵ�.
			// - ��Ʈ�� ��� �ÿ��� �� (1) �������� ���� �� (2) flush�� �о �� �� �������.
			bos.close();
			fos.close();
		}
	}
}
