package ex1_abstract;

public class AbsChild extends AbsParent{
	
	int age = 10; 
	
	// �߻� Ŭ������ ��ӹ��� �ڽ��� �θ��� �߻� �޼��带 ������ �������̵�(������)�ؾ��Ѵ�.
	// �ڽ� ������ �µ��� ������� �� ������ �ʿ�� ������, �޼��� ��ü�� �ݵ�� ����־���Ѵ�. 
	@Override
	public void setValue(int n) {
		age = n;
	}

	
	
	
}
