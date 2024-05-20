package ex2_fileInput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Ex1_FileInput {
	public static void main(String[] args) {
		
		// ���� ���� ����
		String path = "C:/JAVA1_0713_KTH/test.txt";	
		File f = new File(path);	// ���� ��üȭ
		//
		if(f.exists()) {
			
			/*	��Ʈ��
			 *		- ����� ��ġ�� ���α׷� ������ �帧����, �ΰ����� �����ϴ� �ܹ����� ����̴�.
			 *		- ���޵Ǵ� �����ʹ� �⺻������ ����Ʈ (byte) �̴�.
			 *		- �Է��� ����ϴ� input file stream�� ����� ����ϴ� output file stream�� �����Ѵ�.
			 *		- ��Ʈ�� ��ü �������� ��θ� �����ϰ�, close �޼ҵ带 ���ؼ� ��θ� �ݴ´�.
			 *		- ������ ã�� ���ϰų�, ������ �д� ���߿� �����ǰų� �߸� ������ ���ɼ��� �����Ƿ� try - catch �� ���μ� ����Ѵ�.
			 *		
			 *		(1) file steam
			 *				- byte ����� ��Ʈ������ 1byte�� �����͸� �����´�.
			 *				- file input stream, buffered input stream, file output stream, buffered output stream
			 * 
			 * 	(2) char stream
			 *				- char ����� ��Ʈ������ 2byte�� �����͸� �����´�.
			 *				- file input stream, buffered input stream, file output stream, buffered output stream
			 * 	
			 * 	[����] �ѱ��� �� �ڿ� 2byte �� �����Ǿ������Ƿ� input stream �� ����ϴ� ��� �� ���ڸ� �迭�� ������ ������ �����Ƿ�, char stream�� ���� ����Ѵ�.
			 * 
			 */
			try {
				//
				FileInputStream fis= new FileInputStream(f);
				int code = -1;
				
				//  read
				// - ��Ʈ���� �����͸� �а� ��ȯ�ϴ� �޼ҵ�
				// - read �޼ҵ�� ���̻� ���� ���� ���� ��Ȳ�� �� -1�� ��ȯ�Ѵ�.
				// - �� ���� eof (end of file) �̶�� �θ���.
				// - �Ʒ� �ڵ��� while���� ��Ʈ���� eof �� ���� ������ �ݺ��Ͽ� ��Ʈ���� �����͸� ������ �д´�.
				// - ��, ������ ������ �о��. ��� ���̴�. 
				while((code=fis.read())!= -1) {
					System.out.print(code+" ");
				}	// while
				
				// ��Ʈ���� New Ű����� ���������Ƿ�, true ��
				if(fis!=null) {
					// ��Ʈ���� ��� �� �ݵ�� �ݾ���� �Ѵ�.
					fis.close();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // try-catch
	}
}
