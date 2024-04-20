package ex1_buffered_input;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Ex1_BufferedInput {
	public static void main(String[] args) throws IOException {
		
		/* ���� ��Ʈ�� : �ڽŸ��� ���� ������ ���ؼ� �����͸� �Է��ϰų� ����ϴ� �뵵�� ����ϴ� ��Ʈ�� (���� �ӵ�)
		    �Ϲ� ��Ʈ���� ���� ��Ʈ���� �����Ͽ� ������ �аų� �� �� ���۸� �۾��� �����ϵ��� �Ѵ�.
		    ���۸� : ����ϰ����ϴ� �����͵��� ���۶�� �޸� ������ ����Ʈ�迭�� �̸� �����صδ� �۾�
			���۶�� ������ ������� ���� ���õ� �����ġ�� �� �κ����μ�, ���ۿ� �ڷḦ ��Ƶθ� ����� �ӵ� ��� ������ �ȴ�. (������ ���۸� �۾� = ���� ���۶�� ������ ��Ƽ� ������ ��, �̾ �� �� ����)
			�Ϲ����� ��Ʈ�� : 1����Ʈ�� �Դٰ��� ������ ����
			���� ��Ʈ�� : �ѹ��� ����Ʈ�迭�� ��Ƶξ��ٰ� �� ��ġ���� ����
			���� ȭ��� : ��Ʈ��
			���� ȭ��� : ���� ��Ʈ�� */
		
		String path = "C:/JAVA1_0713_KTH/test.txt";
		File f = new File(path);
		byte [] read = new byte[(int)f.length()];
		
		FileInputStream fis = null;
		
		// BufferedInputStream
		BufferedInputStream bis = null;
		
		try {
			
			fis = new FileInputStream(f);
			// ���� ��ǲ ��Ʈ���� ��θ� ���۰� �޾Ƽ� �ش� ��ο� �ִ� �����͸� �޾ƿ� �غ� �Ѵ�. (�߰� ��θ� ����ä�� ����)
			// ���� fis2�� �ְ� fis2�� ���۸� �̿��ؼ� ���ԵǸ� fis bis�� ��οʹ� �ٸ� ������ ��ΰ� �� �����.  
			bis = new BufferedInputStream(fis);
			bis.read(read);
			
			System.out.println(new String(read));

		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			// close �Ҷ��� ������ �������� �ݾ��ִ� ���� ����. (���� -> ��ǲ��Ʈ��)
			bis.close();
			fis.close();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
