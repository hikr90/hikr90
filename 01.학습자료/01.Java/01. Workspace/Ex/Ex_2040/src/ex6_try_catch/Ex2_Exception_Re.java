package ex6_try_catch;

public class Ex2_Exception_Re {
	public static void main(String[] args) {
		/* ���� �Ǵ�����
		 *		- ���� ó�� �� ���������� �ٽ� �߻���Ű�� ���
		 *		- �� �޼ҵ忡�� �߻��� �� �ִ� ���ܰ� ���������� ���, �� ���� try������ ��ü ó���ϰ� �������� ����ο� �����Ͽ� ��û�� �޼ҵ忡�� ó���ϴ� ��� 
		 *		
		 *			(1) ���ܰ� �߻��� ���ɼ��� �ִ� �޼ҵ忡�� try�� ���
		 *			(2) catch ��Ͽ��� �ʿ��� �۾� ����
		 *			(3) throw ���� ���ؼ� ���� �� �߻��Ͽ� (1)���� ���� ����
		 *			(4) �޼ҵ忡�� ���� �� ó��
		 */
		
		try {
			//
			method1();
		} catch (Exception e) {
			//
			System.out.println("main�޼ҵ忡�� ���� ó��");
		}
	}
	
	static void method1() throws Exception{
		//
		try {
			//
			throw new Exception();
		} catch (Exception e) {
			System.out.println("method1 �޼ҵ忡�� ���� �߻�");
			throw e;
		}
	}
}
