package ex1_abstract;

public class AbsChild extends AbsParent{
	//
	int age = 10; 
	
	// - �߻� Ŭ������ ��ӹ��� �ڽ��� �θ��� �߻� �޼ҵ带 �ݵ�� ������ �ؾ��Ѵ�.
	@Override
	public void setValue(int n) {
		age = n;
	}
}
