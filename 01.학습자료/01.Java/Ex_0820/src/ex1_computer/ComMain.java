package ex1_computer;

public class ComMain {
	public static void main(String[] args) {
		
		/* Ŭ����
		 *		- ��ü�� �����ϴ� Ʋ, �Ǵ� ���赵
		 *		- ��ü�� ���¸� ���ϴ� �ʵ�� ��ü�� �ൿ�� ���ϴ� �޼ҵ�� �����Ǿ��ִ�.
		 *
		 *		- Ŭ������ ����ϴ� Ŭ������ ������ �ʿ��ϴ�.
		 */
		// Ŭ���� ����
		Computer c1 = new Computer();	// ���忡�� ������ ��ǻ�͸� ���� ����
		
		// ��ü c1�� �����Ǿ����Ƿ� �ش� ��ü �����Ͽ� hdd ���� ������ ������ �� �ִ�.
		System.out.println(c1.hdd);
		System.out.println(c1.ram);
		System.out.println(c1.cpu);
		System.out.println(c1.color);
		
		System.out.println("---------------");
		
		// Ŭ���� ����
		Computer c2 = new Computer();	// ģ���� ���忡�� ������ ������ ��ǻ�͸� ����
		
		// ���� ��ǰ�̴� ���� ������ ������ �� �ִ�.
		System.out.println(c2.hdd);
		System.out.println(c2.ram);
		System.out.println(c2.cpu);
		System.out.println(c2.color);
		
		System.out.println("---------------");
		
		
		// Ŭ������ �Ӽ� ���� �����Ѵ�.
		c2.hdd = 1000;		// ģ���� �ڱ� ��ǻ���� hdd�� ���׷��̵��ߴ�.
		System.out.println(c2.hdd);
		
		System.out.println("---------------");
		
		// Ŭ������ ��ü
		// - �� ��ǻ�Ϳ� ģ���� ��ǻ�ʹ� ���� ���赵�� ���۵Ǿ����� ���� �ٸ� �����̴�.
		// - �ϳ��� ���赵 (Ŭ����) �� �ΰ��� ��ǰ (��ü) �� ������ ���̴�.
		c1.getInfo();
		c2.getInfo();
		
		// - ���������� private�� �ִ� ������ �޼ҵ�� Ÿ Ŭ�������� ������ �� ����.
		//c2.company = "apple";
	}
}
