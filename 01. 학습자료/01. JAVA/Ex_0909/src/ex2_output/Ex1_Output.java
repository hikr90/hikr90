package ex2_output;

import java.io.PrintStream;

public class Ex1_Output {
	public static void main(String[] args) {
		
		/*�Ʒ��� ���� syso�� ���� �ڵ�μ� ���� �̷��� ��������� �ʴ´�.*/
		
		// PrintStream�� �ƿ�ǲ��Ʈ���� ��ǥ���� �ڽ�Ŭ�����ν�, ȭ��(�ܼ�â)�� �����͸� ����ϵ����ϴ� Ŭ����
		PrintStream ps = null;
		
		try {
			// system in ���� ����, out �ܼ�â���� ���� ���
			ps = System.out;
			ps.write(65);
			ps.write('B');
			
			// ������ ����Ǿ ���̻� ����� ���� ���ٴ� ���� Ȯ���ؾ��Ѵ�.
			// ������ �����ִ� ������ ������ �� ���� �Ͱ� ����.
			
			
		} catch (Exception e) {

			
		
		
		}finally {
			// PrintStream�� close()�� ������ �۾��� �̿ϼ��Ǿ��ٰ� �Ǵ��Ͽ� ȭ�鿡 �����͸� ������� �ʴ´�.
			ps.close();
		}
		
		
		
		
		
		
		
	}
}
