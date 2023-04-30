package ex3_method;

public class MethodMain {
	
	public static void main(String[] args) {
		
		// stack���� v1�̶�� �ּҰ���, heap���� v1�̶�� ��ü�� ������(greet�ż���)�� �����. 
		// �ż��带 ����ϴ� ���� : ������ �ڵ带 �����ϱ����ؼ��̴�.
		ValueTest v1 = new ValueTest();
		v1.greet();
		
		System.out.println("---------------");
		
		
		// �Ķ���� �ż��� 
		// ����, �޼��带 Ŀ�Ǹӽ��̶�� �����ϸ�
		// 1�� ĸ�� -> 1�� Ŀ��
		// 2�� ĸ�� -> 2�� Ŀ��
		
		// ���� �����Ϳ����� ����� �ٸ� �� �ִ�.
		// charAt(x)�� ����, x���� ���� ������� �޶��� �� �ִ�. 
		int su = 100; 
		int su2 = 0;
		v1.test1(su);
		
		// ����� 100�� ���´�.
		// �޼���� ���� �����ϴ� �뵵�� ���δ�, �� su���� ���纻�� ValueTest�� test1�� n���� �Ѿ��.
		// test1���� ���纻�� �޼��峻�뿡���� ��ȭ�ϰ� �� ���ϰ��� �����ش�.
		// �������� ������ �ʾ����Ƿ� su�� ���� �״���̴�.
		System.out.println("su : "+su);
		
		System.out.println("---------------");
		
		// ���纻�� ���� ��������� ���
		// CTRL+SPACE�� ��ȯ�ϴ� ���� int�� �Ǿ��ִ� ���� Ȯ���� �� �ִ�.
		// �޼����� ���ϰ��� n���� �Ǿ������Ƿ� �޼��� �ȿ��� ���� 200�� ������ su2�� �� ���� Ȯ���� �� �ִ�.
		su2 = v1.test0(su);
		System.out.println("su2 : "+su2);
		
		System.out.println("---------------");
		
		String name = "ȫ�浿";
		int age = 19;
		String res = v1.test2(age);
		
		System.out.printf("%s���� %s�Դϴ�.\n",name,res);

		System.out.println("---------------");
		
		// �޴� ���� boolean���� ����
		System.out.println("---���� ����� ������ ����---");
		boolean result = v1.test3("��", 21);
		
		if(result==true) {
			System.out.println("�հ�");
		}else {
			System.out.println("���հ�");
		}
		
		
	} //main
}
