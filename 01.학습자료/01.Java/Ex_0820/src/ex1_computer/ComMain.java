package ex1_computer;

public class ComMain {
	public static void main(String[] args) {
		// Ŭ������ ����ϴ� Ŭ������ ������ �ʿ��ϴ�.
		
		// Computer���� (��ǻ�͸� �ٸ� ���忡�� ������ ��ǻ�͸� ���� ��)
		// stack�� c1(��ü)�� �ּҰ� �� ����� heap��  ��ǻ�Ϳ� �ش��ϴ� Ŭ������ ��� �����Ͱ� ���� �ȴ�. 
		Computer c1 = new Computer();
		
		// Ŭ����. �� c1�� �������ִ� hdd��� �����Ϳ� �����ؼ� hdd�� ���� 500�� ������ �� �ִ�.
		// ���赵������ ������ ������
		System.out.println(c1.hdd);
		System.out.println(c1.ram);
		System.out.println(c1.cpu);
		System.out.println(c1.color);
		
		System.out.println("---------------");
		
		// �ٸ� ģ���� �Ȱ��� ����� ��ǻ�͸� ��� ����
		// �翬�� ���� ����̴� ���� ������ �������´�. 
		Computer c2 = new Computer();
		
		System.out.println(c2.hdd);
		System.out.println(c2.ram);
		System.out.println(c2.cpu);
		System.out.println(c2.color);
		
		System.out.println("---------------");

		// �� new�� �ٸ� ������ �����°�?
		// �� ��ǻ�Ͱ� �������ٰ� �� ģ�� �ĵ� ���������� �ʱ� �����̴�.
		
		// ģ���� �ϵ带 ���׷��̵� ��Ų�ٸ�
		// stack�� c2�� �����Ͽ� �ּҰ��� ���ؼ� heap�� c2�����ͷ� �̵��Ͽ� hdd 500�� 1000���� �����ϰ� �ȴ�.
		// ��, Ư�� ��ü�� �����Ͽ� ��ü�� �����͸� �����ϴ� ���� �����ϴ�. 
		c2.hdd = 1000;
		System.out.println(c2.hdd);
		
		System.out.println("---------------");
		
		// �ݺ��Ǵ� �ڵ� �۾��� ���ϱ����� �뵵�μ� �ż��尡 ���ȴ�. 
		// c2(ģ��)�� hdd�� 1000���� ����Ǿ������� 1000���� ����Ǿ��ִ� ���� Ȯ���� �� �ִ�. 
		c1.getInfo();
		c2.getInfo();
		
		// private�� �ɸ� ������ �ż���� Ÿ Ŭ�������� ����� �� ����.
		//(����)c2.company = "apple";
	
	
	
	}
}
