package ex6_overload;

public class OverloadMain {

	public static void main(String[] args) {
		// �޼ҵ� ����
		Ex_Overload ov = new Ex_Overload();
		
		// - ���� �޼ҵ带 ȣ���ϴ���
		// - �Ķ������ ����, �Ķ������ ���� ����� �ٸ� �޼ҵ尡 ����ȴ�.
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
