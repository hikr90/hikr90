package ex3_inheritance;

public class ExtendsMain {
	
	public static void main(String[] args) {
		
		// Child ��ü ����
		// Child�� Parents�� ��ӹ޾ұ� ������ money��, str�� ȣ���Ͽ� ����� �� �ִ�.
		// ��� ������ �ڽ� ��ü�� �θ� ���� �Ӽ����� ������� ������ ����� �� �ִ�. 
		Child c = new Child();
		System.out.println(c.money);
		System.out.println(c.car);

		// ���� ��ü�� ���� Ŭ������ �ڽ������� Ȯ���ϴ� ������
		// �ν��Ͻ� : c.���� ������ ��, c(��ü)�� �ּҰ��� �θ�Ŭ������ �ּҰ��� ������?
		// �ν��Ͻ��� ���� = �ּҰ��� ����.
		// c�� Parents�� �ڽ�Ŭ�����Դϱ�?
		if(c instanceof Parents) {
			System.out.println("c�� Parents�� �ڽ��Դϴ�.");
		}
	
		System.out.println("-------------------");
		
		// �θ�Ŭ������ ��üȭ
		// ��Ӱ����� ��ü��� ������ �θ�Ŭ������ �ڽ��� �ʵ�(�Ӽ�)�� ������� ����� �� ����.
		Parents p = new Parents();
		
		
		// java.lang.object�� �ֻ��� Ŭ�����μ�, extends�� ������� �ʾƵ� �⺻���� �ִ�.
		// ��, �ڽ�Ŭ������ ��üȭ�� �� �����δ� heap������ object�� ���� ���������.
		// �� �ּҰ��� Ÿ�� ���� parents -> �θ��� �ּҰ��� Ÿ����� -> �ڽ��� Ŭ���� ������ �����ȴ�.
		
		if(c instanceof Object) {
			System.out.println("�ڽ� Ŭ������ �θ�Ŭ������ objectŬ������ ��ӵǾ��ִ�.");
		}
		
	
		// ������ : �޸� ����
		// ����� ���� : ��ü���� �������� �������ִ� ��쿡 �޸𸮸� �����ϰ� �θ� �������ִ� �Ӽ����� ������ �ڽ��� ���������� ������ ����� �� �ִ�.

		Child c2 = new Child();
		Parents p2 = new Child(); 
		
		// ����
		// �������̽� è�Ǿ� (q, w, e, r) �߻�޼��� 
		// ����, �ٸ��콺, ���ӽ� 
		// ���� garen (q,w,e,r)
		// �ٸ��콺 (q,w,e,r)
		// ���ӽ� (q,w,e,r)
		// �������� ����� ����� �� �ִ�.
		// ch g1 = new garen();
		// ch g2 = new dari();
		// ch g3 = new ramus();
		
	}
}
