package ex1_abstract;

// �θ�
// [����] abstract�� �߻�Ŭ�������� ����ϴ� Ű�����̴�.
public abstract class Ex1_Abstract {
	//
	int value = 100;
	String str = "�ȳ�";

	/*	�߻� Ŭ����
	 * 		- �̿ϼ� Ŭ����
	 * 		- ���ο� �̿ϼ� �޼ҵ带 ������.
	 * 		- �߻� Ŭ�����δ� �ν��Ͻ� ������ �Ұ����ϴ�.
	 * 		
	 * 		(1) �߻� Ŭ������ ��� ���
	 * 			- ���� Ư���� ������ �߻�Ŭ������ �� Ư¡�� �����ϴ� Ŭ������ �����Ͽ� ���ȴ�.
	 * 			- abstract Ű���带 ����Ѵ�.
	 * 			- �߻� Ŭ������ ���ο� �ݵ�� �ϳ� �̻��� �߻� �޼ҵ带 ������.
	 * 
	 *		(2) �߻� �޼ҵ�
	 *			- ����θ� �����Ѵ�.
	 *			- �޼ҵ��� ������ �����ϴ� �ڽĿ� ���� �޶�����. (�ڽĿ��� �߻� �޼ҵ� ������)
	 *			- �θ𿡼� ������ �޼ҵ尡 �ڽĿ��� �������� �ʰ� �ϴµ� ������ �ִ�.
	 *			- abstract ���� Ÿ�� �޼ҵ���� ���·� ���ȴ�.
	 *
	 *		(3) �߻�ȭ & ��üȭ
	 *			(3.1) �߻�ȭ :  Ŭ�������� �������� ã�Ƴ���, ������ ������ ����� �۾�
	 *			(3.2) ��üȭ : ����� ���ؼ� Ŭ���� ����, Ȯ���ϴ� �۾�
	 *
	 *			- �θ� : �߻�ȭ ����, ��üȭ ����
	 *			- �ڽ� : �߻�ȭ ����, ��üȭ ����
	 */
	abstract public void setValue(int value);
	//
	public int getValue() {
		return value;
	}
}

// ����
class Ex1_1_Abstract {
	public static void main(String[] args) {
		// �ڽ� Ŭ���� ��üȭ
		Ex1_2_Abstract c = new Ex1_2_Abstract();
		c.setValue(30);
		//
		System.out.println(c.age);
		System.out.println(c.getValue());
	}
}

// �ڽ�
class Ex1_2_Abstract extends Ex1_Abstract {
	//
	int age = 10; 
	
	// - �߻� Ŭ������ ��ӹ��� �ڽ��� �θ��� �߻� �޼ҵ带 �ݵ�� ������ �ؾ��Ѵ�.
	@Override
	public void setValue(int n) {
		age = n;
	}
}
