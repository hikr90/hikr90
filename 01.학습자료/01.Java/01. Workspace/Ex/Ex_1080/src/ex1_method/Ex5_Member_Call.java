package ex1_method;

public class Ex5_Member_Call {
	/*	[����] Ŭ���� ���, �ν��Ͻ� ��� �� ������ ȣ��
	 *		- ���� Ŭ������ ���� ��� (����, �޼ҵ�) �� ������ ������ �ν��Ͻ� �������� ���� ����, ȣ���� �����ϴ�.
	 *		- ��, Ŭ���� ����� �ν��Ͻ� ����� ȣ���ϰ����ϴ� ��� �ν��Ͻ��� �����ؾ� �Ѵ�. 
	 *			(Ŭ���� ��� ȣ�� �ÿ�, �ν��Ͻ� ����� �������� ���� ���� �����Ƿ�) 
	 */
	int iv = 10;
	static int cv = 20;
	
	int iv2 = cv;
	// static int cv2 = iv;	// [����] Ŭ���� ������ �ν��Ͻ� ������ ����� �� ����
	static int cv2 = new Ex5_Member_Call().iv;	// ��ü�� �����ϴ� ������δ� �����ϴ�. (�ν��Ͻ��� ������ �Ŀ��� �����ϴ�.)
	
	// Ŭ���� �޼ҵ�
	static void staticMethod1() {
		System.out.println(cv);
		// System.out.println(iv);	// [����] Ŭ���� �޼ҵ忡�� �ν��Ͻ� ���� ��� �Ұ�

		Ex5_Member_Call c = new Ex5_Member_Call();	// �ν��Ͻ� ���� �Ŀ��� ��� ����
		System.out.println(c.iv);
	}
	
	// �ν��Ͻ� �޼ҵ�
	void instanceMethod1() {
		System.out.println(cv);
		System.out.println(iv);		// �ν��Ͻ� �޼ҵ忡���� �ν��Ͻ� ���� ��� ����
	}
	
	// Ŭ���� �޼ҵ�
	static void staticMethod2() {
		staticMethod1();
		// instanceMethod1();		// [����] Ŭ���� �޼ҵ忡���� �ν��Ͻ� �޼ҵ� ��� �Ұ�
		
		Ex5_Member_Call c = new Ex5_Member_Call();	// �ν��Ͻ� ���� �� ��� ����
		c.instanceMethod1();
	}
	
	// �ν��Ͻ� �޼ҵ�
	void instanceMethod2() {
		staticMethod1();		// �ν��Ͻ� �޼ҵ忡���� Ŭ����, �ν��Ͻ� �޼ҵ� ��� �ν��Ͻ� ���� ���� ���� ȣ�� �����ϴ�.
		instanceMethod1();
	}
	
}
