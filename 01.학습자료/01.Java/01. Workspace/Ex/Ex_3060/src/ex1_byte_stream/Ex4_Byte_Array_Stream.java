package ex1_byte_stream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class Ex4_Byte_Array_Stream {
	public static void main(String[] args) {
		/*	ByteArrayStream
		 * 		- ����Ʈ �迭(�޸�)�� �����͸� ������ϴµ� ���Ǵ� ��Ʈ��
		 * 		- �ַ� �ٸ� ���� ������ϱ� ���� �����͸� �ӽ÷� ����Ʈ �迭�� ��Ƽ� ��ȯ ���� �۾��� �ϴµ� ���ȴ�.
		 */
		byte [] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte [] outSrc = null;
		byte [] temp = new byte[4];
		
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		
		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();
		
		try {
			//
			while (input.available() > 0) {
				int len = input.read(temp);		// �о�� �������� ������ ��ȯ
				output.write(temp, 0, len); 	// �о�¸�ŭ�� ����.
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		//
		outSrc = output.toByteArray();
		System.out.println("Input Source : " + Arrays.toString(inSrc));
		System.out.println("Temp : " + Arrays.toString(temp));
		System.out.println("Output Source : " +  Arrays.toString(outSrc));

	}
}
