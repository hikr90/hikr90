package ex1_byte_stream;

import java.io.PrintStream;

public class Ex3_Print_Stream {
	public static void main(String[] args) {
		/*	PrintStream 
		 *		- �ƿ�ǲ ��Ʈ���� ��ǥ���� �ڽ� Ŭ������, ȭ�� (�ܼ�)�� �����͸� ����Ѵ�.
		 */

		// [����] System.out.print();�� ���� ���
		PrintStream ps = null;
		//
		try {
			//
			ps = System.out;
			ps.write(65);
			ps.write('B');
			
		} catch (Exception e) {
		
		}finally {
			// ������ ����Ǿ ���̻� ����� ���� ���ٴ� ���� Ȯ���ؾ��Ѵ�.
			// ������ �����ִ� ������ ������ �� ���� �Ͱ� ����.
			// PrintStream�� close()�� ������ �۾��� �̿ϼ��Ǿ��ٰ� �Ǵ��Ͽ� ȭ�鿡 �����͸� ������� �ʴ´�.
			ps.close();
		}
	}
}
