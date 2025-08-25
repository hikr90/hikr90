package ex1_buffered_input;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Ex1_BufferedInput {
	public static void main(String[] args) throws IOException {
		
		/*	����
		 * 	- ������� ���ؼ� ���õ� ��� ��ġ�� �Ϻκ����μ�, ���ۿ� �ڷḦ �̸� ��Ƶθ� ����� �ӵ� ��� ������ �ȴ�.
		 * 	- (������ ���۸� �۾� = ���� ���۶�� ������ ��Ƽ� ������ �� �̾ �� �� �ְ� ��)
		 * 	
		 * ���۸�
		 * 	- ���� ���� ����� ������(����Ʈ �迭)�� ���۶�� ������ ��Ƽ� �����ϴ� ����
		 * 
		 * ���� ��Ʈ��
		 * 	- ���� ���� ������ ���ؼ� �����͸� �Է�, ����ϴ� �뵵�� ���
		 * 	- �ӵ� ���鿡�� ����.
		 * 	-  ���� ��Ʈ���� ��θ� ���۰� ����ä�� �ش� ��ο� �ִ� �����͸� �޾ƿ� �غ��Ѵ�.
		 * 
		 *  �� ��Ʈ�� ����
		 * 	(1) �Ϲ� ��Ʈ�� : 1����Ʈ ������ �Դٰ����ϸ� ������ ����
		 * 	(2) ���� ��Ʈ�� : �ѹ��� ����Ʈ �迭�� ��Ƽ� �� ��ġ�� ����
		 * 
		 * [����] ��Ʈ���� ������ ���� ������ �������� �ݾ��ش�. (���� - ��Ʈ��)
		 * 
		 */
		
		String path = "C:/JAVA1_0713_KTH/test.txt";
		File f = new File(path);
		byte [] read = new byte[(int)f.length()];
		//
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		//
		try {
			//
			fis = new FileInputStream(f);
			bis = new BufferedInputStream(fis);
			bis.read(read);
			//
			System.out.println(new String(read));

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// �������� �ݾ��ش�.
			bis.close();
			fis.close();
		}
	}
}
