package ex3_overload;

public class Ex1_Overload {

	public static void main(String[] args) {
		/* �����ε�
		 * 	- �� Ŭ���� ��, ���� �̸��� �޼ҵ带 ������ �����ϴ� ��.
		 * 	- �����ε��� �޼ҵ��� �Ķ������ ���̿� ���ؼ��� �����̵Ǹ� ��ȯ Ÿ���� � ���⵵ ����.
		 * 	- ��ǥ������ println �޼ҵ尡 �ִ�.
		 * 	- ���� ����� ���� �޼ҵ尡 �ϳ��� ��Ī���� ���ǵǾ� ������ �߻��� ���̰� �޼ҵ� ��Ī�� ������ �Ǿ� ����� ���̴µ� ������ �ȴ�.
		 * 
		 * 	�ۼ� ��Ģ
		 *  	(1) �޼ҵ��� �̸��� ��ҹ��ڸ� �����Ͽ� �ݵ�� ���ƾ��Ѵ�.
		 * 		(2) �޼ҵ��� �̸��� ���⿡ ������ ���� �޶���Ѵ�.
		 * 		(3) ������ ������ ���� ��� Ÿ���� �޶���Ѵ�.
		 * 		(4) ������ ������ 2�� �̻��� ��� ������ �޶���Ѵ�.
		 */
		
		// �޼ҵ� ����
		Ex2_1_Overload ov = new Ex2_1_Overload();
		
		// - ���� �޼ҵ� ���� ��, �Ķ������ ����, �Ķ������ ���� ����� �ٸ� �޼ҵ尡 ���ȴ�.
		ov.result();
		ov.result(20);
		ov.result('A');
		ov.result("dd",10);
		ov.result(10,"dd");
		
		// - System.out.println ���� �����ε��� ��ǥ���� �޼ҵ��̴�.
		// - ���� Ÿ���� �Ķ���͸� ���� �� ������ ������ ���� ���� ��쵵 ���� �� �ִ�.
		System.out.println();
	}
}

class Ex2_1_Overload {
	public void result() {System.out.println("���ڰ� ���� �޼���");}
	public void result(int n) {System.out.println("������ ���ڷ� �޴� �޼���");}
	public void result(char c) {System.out.println("���ڸ� ���ڷ� �޴� �޼���");}
	public void result(String s, int n) {System.out.println("���ڿ�, ���� ������ �޴� �޼���");}
	public void result(int i, String s) {System.out.println("����, ���ڿ� ������ �޴� �޼���");}
}