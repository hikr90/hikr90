package ex1_byte_stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex1_Stream {
	public static void main(String[] args) throws IOException {
		
		/*	�����
		 * 		- �Է� (Input)�� ��� (Output)���� �ٿ��� ����� (IO)��� �θ���.
		 * 		- ��ǻ�� ���� Ȥ�� �ܺ��� ��ġ�� ���α׷� ���� �����͸� �ְ� �޴� �۾��� ���Ѵ�.
		 * 
		 * 		[����] ����¿��� ������ Jvm�̴�.
		 * 			- output : �ַܼ� ������ �����ϴ� �۾�, input : �ܺο� �ִ� �����͸� ��Ŭ������ �ַܼ� �������� �۾�
		 * 			- �ܺ��� �ܼ��� ����޸�, sdī��, c����̺� ���� ���Ѵ�.
		 * 
		 * 		(1) ��Ʈ��
		 * 			- �ڹٿ��� ������� �����ϱ� ���ؼ� �����͸� �ְ� ���� �� ����� �����ϰ� �����͸� ������ �� �ִ� ������ ��θ� ���Ѵ�.
		 * 				(�����͸� �����ϴµ� ���Ǵ� ���� ���)
		 * 
		 * 			- �ܹ��� ��Ÿ� �����ϹǷ� ������� �����ϱ����ؼ��� �Է� ��Ʈ���� ��� ��Ʈ���� �ʿ��ϴ�.
		 * 			- ���� ���� �����͸� ���� �ް� �Ǿ������� �߰��� �ǳʶܾ��� ���������� �����͸� �ְ� �޴´�.
		 * 		  	- ���޵Ǵ� �����ʹ� �⺻������ ����Ʈ (byte)�̴�.
		 * 			- ��ü (��Ʈ��) �������� ��θ� �����ϰ�, close �޼ҵ带 ���ؼ� ��θ� �ݴ´�.
		 * 			- ������ ã�� ���ϰų� ������ �д� ���߿� �����ǰų� �߸� ������ ���ɼ��� �����Ƿ� try-catch�� ����Ѵ�.
		 * 			
		 * 			(1.1) ����Ʈ ��� ��Ʈ�� (InputStream, OutputStream)
		 * 				- ���� :FileInputStream, FileOutputStream
		 * 				- �޸� (byte�迭) : ByteArrayInputStream, ByteArrayOutputStream
		 * 				- ���μ��� (���μ����� ���) : PipedInputStream, PipedOutputStream 
		 * 				- ����� ��ġ : AudioInputStream, AudioOutputStream
		 * 
		 * 				[����] byte����� ��Ʈ���� 1byte�� �����͸� �����´�.
		 * 
		 * 		(2) ��Ʈ���� �а� ���� �޼ҵ�
		 * 			- abstract int read() / abstract void write(int b)
		 * 			- int read(byte[] b) / void write(byte[] b)
		 * 			- int read(byte[] b, int off, int len) / void write(byte[] b, int off, int len)
		 * 
		 * 			[����] ������ ��Ʈ������ Input/Output Stream�� �ڼյ��̸� �а� ���µ� �ʿ��� �߻�޼ҵ带 �ڽſ� �°� �����صξ���. 
		 * 
		 * 		(3) FileStream ������
		 * 			(3.1) FileInputStream(String name), FileOuputStream(String name)
		 * 				 - ������ �����̸�(name)�� ���� ���� ���ϰ� ����� ��Ʈ���� �����Ѵ�.
		 * 				
		 * 			(3.2) FileInputStream(File file), FileOutputStream(File file)
		 * 				- ������ �̸��� String�� �ƴ� File�ν��Ͻ��� �������־���ϴ� ���� �����ϰ� (String name)�� ����.
		 */
		
		// (1) FileInputStream
		String p1 = "C:/JAVA1_0713_KTH/test.txt";
		File f1 = new File(p1);
		//
		if(f1.exists()) {
			//
			try {
				//
				FileInputStream fis= new FileInputStream(f1);
				int code = -1;
				
				/* read �޼ҵ� 
				 * 		- ��Ʈ���� �����͸� �а� ��ȯ�ϴ� �޼ҵ�
				 * 		- ���̻� ���� ���� ���� ��Ȳ���� -1�� ��ȯ�ϸ� �� ������ eof (End Of File)�̶�� �θ���.
				 * 		- ��, �Ʒ��� while���� ���ؼ� ������ eof�� ���� ������ �ݺ��Ͽ� ��Ʈ���� �����͸� ������ �о��.
				 */
				while((code=fis.read())!= -1) {
					System.out.print(code+" ");
				}
				//
				if(fis!=null) {
					// ��Ʈ���� ��� �� �ݵ�� �ݾ���� �Ѵ�.
					fis.close();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// (2) FileOutputStream
		String p2 = "C:/JAVA1_0713_KTH/fileOutput.txt";
		File f2 = new File(p2);
		FileOutputStream fos = null;
		//
		try {
			//
			fos = new FileOutputStream(f2);
			//
			String msg = "file Output��Ʈ���� ����";
			String msg2 = "\n�ι�° ��, �ѱ۵� �� ���´�.";
			
			/*	getBytes
			 *		- ���ڿ��� ���� ���ڵ��� �ٸ� ���ڵ����� ��ȯ�ϴ� �޼ҵ�
			 *		- �Ķ���ͷ� �ٸ� Ÿ���� ���ڵ� Ÿ���� �־� ����� �� �ִ�.
			 *
			 *			(1) byte [] utf8_str = "��".getBytes("UTF-8");		// ���ڿ� > UTF-8
			 *			(2) String str = new String(utf8_str, "UTF-8"); 	// byte [ ] > ���ڿ�
			 */
			fos.write(msg.getBytes());		// String > byte [ ] �� ����
			fos.write(msg2.getBytes());
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fos.close();
		}
	}
}
