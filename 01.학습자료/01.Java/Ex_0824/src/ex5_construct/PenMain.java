package ex5_construct;

public class PenMain {
	public static void main(String[] args) {
		
		// �޸� ȣ��� ���ÿ� �ʱ�ȭ�� �Ǿ����
		// ���̻� �ٲ� �� ���� setter�� ������ ��� �����Ѵ�. 
		Pen p1 = new Pen();
		
		// Pen���� �̹� �����ڷ� �ʱ�ȭ�� ���װ�, setter�� ������ �ʰ� getter�� ���������
		// ���� Ȯ���ϴ� ���� �����ص�, ���� �������� ������ �� ����. (���ϼ� ����)
		// ������ ���ڽŵ� ���ٲ۴�.
		System.out.println(p1.getCompany());
		System.out.println(p1.getColor());
		System.out.println(p1.getPrice());
		
		System.out.println("-------------");
		
		// �������� �����ϰ�ʹٸ�?
		Pen p3 = new Pen("gold",20000);
		System.out.println(p3.getColor());
		
		
		
		
		
		
		
		
		
		
		
	}
}
