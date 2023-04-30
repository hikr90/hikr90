package ex3_buffered_output;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex1_BufferedOutput {
	public static void main(String[] args) throws IOException {
		
		String path = "C:/JAVA1_0713_KTH/bufferedOutput.txt";
		File f = new File(path);
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			
			// ���� ����
			fos = new FileOutputStream(f);
			
			bos = new BufferedOutputStream(fos);
			
			String msg  = "Buf�ƿ�ǲ ��Ʈ���� exam";
			bos.write(msg.getBytes());
			
			// bos�� close�� ��, �˾Ƽ� flush(������ ���������� ����ϱ����� �޼���)�޼��尡 ���������� ȣ��ȴ�. 
			// �����̿���, ����� �ȵǴ� ��Ȳ�� �߻����� �ʵ��� �̸� ���������� �����͸� �����ϴ� ��� (������ġ)
			// �������� �ݾƵ� ���� ����� �ȴ�.
			bos.flush();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			// fos�� ��θ� bos�� �ѱ�µ�, ���� fos�� ���� �ݾƹ����� ��� ��η� ������ � ���� �Է��ϴ��� �˼��� ������ ������ ����.
			// ��Ʈ���� ����, �������� ���ݴ� ��쵵 �ִ�. 
			// close���� ���������� ���� �ԷµǸ� �������Ǵµ� �����Ͱ� ��ϵ��� �ʵ��� ����, flush�� �׻� �����.
			bos.close();
			fos.close();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
