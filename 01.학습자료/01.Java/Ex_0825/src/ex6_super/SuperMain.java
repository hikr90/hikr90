package ex6_super;

public class SuperMain {
	
	public static void main(String[] args) {
		
		Child c = new Child();
		
		// �ڽ��� �θ𿡰Լ� ��ӹ޾ұ⿡ �θ� �������ִ� 10�� ���´�. 
		System.out.println(c.getNumber());
		
		
		// child������ int number;������ ���⿡ �θ��� int�� ����.
		// �ڽ����״� set number�� ���ؼ� ���� ����ֱ����� this.number�� ���µ� �׷����ؼ� �Ķ���ͷ� �Ѿ ���� �θ������� �� ���̴�.
		// �� ��쿡�� ������ this�� �ƴ� super�� ������Ѵ�. 
		c.setNumber(500);
		System.out.println(c.number);
		
		
		
	}
}
