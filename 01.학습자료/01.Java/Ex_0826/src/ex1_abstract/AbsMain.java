package ex1_abstract;

public class AbsMain {

	public static void main(String[] args) {
		
		// heap������ ���� ������ object -> parents -> child�ε� 
		// child�� �޼��尡 ������ ���� ������ ���� �ʾƼ� �ؿ� �ڵ����� �������̵��� ���.
		
		// �߻� Ŭ������ �ν��Ͻ� �ּҸ� ���� ���� �� ����. (�� ��üȭ�� �Ұ����ϴ�.)
		// AbsParent a1 = new AbsParent() {
			
//			@Override
//			public void setValue(int value) {
//				// TODO Auto-generated method stub
//				
//			}
//		};
		
		// �߻� Ŭ������ �ڽ��� �ϼ����� ���� ����� �ڽ��� �ϼ���Ű����
		// ���Ǻ� ����Ͽ� �ڽ�Ŭ������ ������ ��, �Բ� ��üȭ �ȴ�. 
		AbsChild c = new AbsChild();
		c.setValue(30);
		System.out.println(c.age);
		System.out.println(c.getValue());
	}
}
