package ex1_abstract;

	// �߻� Ŭ���� 
	// �߻� Ŭ������ �߻� �޼��带 �Ѱ��� ������ �ִ� Ŭ������ �ǹ��Ѵ�. 
	// �߻� Ŭ�������� ����ϱ����� �ݵ�� abstractŰ���带 �ٿ�����Ѵ�. 
public abstract class AbsParent {
	int value = 100;
	String str = "�ȳ�";
	
	// �߻� �޼���
	// �߻� �޼���� �� �տ� abstract�� ���̰� body{}�� ����. 
	// �߻� �޼���� ��ü�� �����Ƿ� �̸� "�̿ϼ��� ����"�̶�� �θ��µ�,
	// �߻� �޼��带 �ڽ��� ��ӹ޾� �ϼ���Ű�� ���� ������ �ȴ�.
	abstract public void setValue(int value);
	

	public int getValue() {
		return value;
	}
	
}
