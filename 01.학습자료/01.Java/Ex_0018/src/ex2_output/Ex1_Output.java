package ex2_output;

import java.io.PrintStream;

public class Ex1_Output {
	public static void main(String[] args) {
		
		/*	PrintStream 
		 *		- �ƿ�ǲ ��Ʈ���� ��ǥ���� �ڽ� Ŭ����
		 *		- ȭ�� (�ܼ�)�� �����͸� ����Ѵ�.
		 */

		// ���� ���ô�, System.out.print�� ���� �ڵ� ������μ� ����� ���� �̷��� ������� �ʰ� �׳� Syso �� ����Ѵ�.
		PrintStream ps = null;
		//
		try {
			//
			ps = System.out;
			ps.write(65);
			ps.write('B');
			
			// - ������ ����Ǿ ���̻� ����� ���� ���ٴ� ���� Ȯ���ؾ��Ѵ�.
			// - ������ �����ִ� ������ ������ �� ���� �Ͱ� ����.
			
		} catch (Exception e) {
		
		}finally {
			// - PrintStream�� close()�� ������ �۾��� �̿ϼ��Ǿ��ٰ� �Ǵ��Ͽ� ȭ�鿡 �����͸� ������� �ʴ´�.
			ps.close();
		}
	}
}
