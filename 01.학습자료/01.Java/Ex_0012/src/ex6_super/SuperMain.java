package ex6_super;

public class SuperMain {
	
	public static void main(String[] args) {
		// �ڽ� Ŭ���� ��üȭ
		Child c = new Child();
		
		System.out.println(c.getNumber());
		
		// - �ڽ�Ŭ���������� number ������ �����Ƿ� �θ��� int�� ����.
		c.setNumber(500);
		System.out.println(c.number);
	}
}
