package ex5_construct;

public class PenMain {
	public static void main(String[] args) {
		
		// �����ڰ� ȣ��Ǹ鼭 ���� �ʱ�ȭ �� ����
		Pen p1 = new Pen();
		
		// - �̹� setter�� ������ ����Ǿ����Ƿ� ���� ������ ���� ����.
		// - (���ϼ� ������ �� �ڽŵ� ���ٲ۴�.)
		System.out.println(p1.getCompany());
		System.out.println(p1.getColor());
		System.out.println(p1.getPrice());
		
		System.out.println("-------------");
		
		// - �����ڸ� �Ķ���͸� �޾Ƽ� �����ϴ� �����ε� �����ڸ� ���������
		// - ���ο� ��ü�� �Ķ���Ϳ� �Բ� ���Ӱ� ȣ��
		Pen p3 = new Pen("gold",20000);
		System.out.println(p3.getColor());
	}
}
