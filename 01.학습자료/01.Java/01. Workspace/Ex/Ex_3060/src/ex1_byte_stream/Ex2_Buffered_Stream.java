package ex1_byte_stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex2_Buffered_Stream {
	public static void main(String[] args) throws IOException {
		/*	���� ��Ʈ��
		 * 		- ��Ʈ���� ����� ����Ű�ų� ���ο� ����� �����ϴ� ���� ������ ��Ʈ���� ���Ѵ�.
		 * 		- �������� ����� ����� �����Ƿ� ��Ʈ���� ���� ������ �ڿ� �̸� �̿��ؼ� ���� ��Ʈ���� �����Ѵ�.
		 * 		
		 * 		(1) �ֿ� ���� ��Ʈ��
		 * 			(1.1) FilterInputStream, FilterOutputStream : ���͸� �̿��� ����� ó��
		 * 			(1.2) BufferedInputStream, BufferedOutputStream : ���۸� �̿��� ����� ��� �⼧
		 * 			(1.3) SequenceInputStream : �ΰ��� ��Ʈ���� �ϳ��� ����
		 * 			(1.4) ObjectInputStream, ObjectOutputStream : �����͸� ��ü ������ �а� ���µ� ��� (��ü ����ȭ�� ����)
		 * 			(1.5) PrintStream : ���۸� �̿��ϸ� �߰����� print���� ���
		 * 
		 * 		(2) ����
		 * 			- ������� ���ؼ� ���õ� ��� ��ġ�� �Ϻκ�
		 * 			- �ش� ������ �ڷḦ ���� ��Ƶθ� ����� �ӵ� ���
		 * 				(ex.������ ���۸� �۾� : ���� ���� ����� �����͸� ���ۿ� ��Ƽ� �����Ͽ� ���ͳ� �ӵ� ������� �̾ �� �� �ְ� ��)
		 * 
		 * 		(3) ���� ��Ʈ��
		 * 			- ���� ���� ������ ���ؼ� �����͸� �Է�/����ϴ� �뵵�� ���
		 * 			- ���� ��Ʈ�� �� �ϳ��μ� ��Ʈ���� �ӵ� ����� ���´�.
		 * 				(���� ��Ʈ���� ��θ� ���۰� ����æ �� �ش� ��ο� �ִ� �����͸� ��� �޾ƿ´�.)
		 * 			- ���� ��Ʈ�� ���� �� ��Ʈ�� ������ �������� �ݾ��ش�. (���� > ��Ʈ��)
		 * 
		 * 			[����] �Ϲݰ� ���� ��Ʈ���� ����
		 * 				- �Ϲ� : 1byte ������ �Դٰ����ϸ鼭 ������ ����
		 * 				- ���� : byte[]�� �ѹ��� ��Ƽ� �� ��ġ�� ����
		 * 
		 * 		(4) ���� ��Ʈ�� ������
		 * 			(4.1) BufferdInputStream(InputStream in), BufferdOutputStream(OutputStream out)
		 * 				- �־��� ��Ʈ���� �ν��Ͻ��� �Է� �ҽ����ϸ� ������ ũ�⸦ ���������� �����Ƿ� �⺻������ 8192byte ũ���� ���۸� ���´�.
		 * 
		 * 			(4.2) BufferdInputStream(InputStream in, int size), BufferdOutputStream(OutputStream out, int size)
		 * 				- �־��� ��Ʈ���� �ν��Ͻ��� �Է� �ҽ����ϸ� ������ ũ�� (byte)�� ���۸� ���� ���� ��Ʈ���� �ν��Ͻ��� �����Ѵ�.
		 */
		
		// (1) BuffredInputStream
		String p1 = "C:/JAVA1_0713_KTH/test.txt";
		File f1 = new File(p1);
		byte [] read = new byte[(int)f1.length()];
		//
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		//
		try {
			//
			fis = new FileInputStream(f1);
			bis = new BufferedInputStream(fis);
			bis.read(read);
			//
			System.out.println(new String(read));

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			//
			bis.close();
			fis.close();
		}
		
		// (2) BuffredOutputStream
		String p2 = "C:/JAVA1_0713_KTH/bufferedOutput.txt";
		File f2 = new File(p2);
		//
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		//
		try {
			// ���� ����
			fos = new FileOutputStream(f2);
			bos = new BufferedOutputStream(fos);
			//
			String msg  = "Buf�ƿ�ǲ ��Ʈ���� exam";
			bos.write(msg.getBytes());
			
			// [����] flush�� ���� �� �������� ���� ������� ������ ����� �۾� �Ϸ� ��Ű�� �޼ҵ��̴�.
			bos.flush();
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// [����] flush�� close�� �������� ����� ���� ���� ��Ȳ�� ����Ѵ�.
			//	- (1) �������� �ݴ´�. (2) flush�� �о��.
			bos.close();
			fos.close();
		}
	}
}
