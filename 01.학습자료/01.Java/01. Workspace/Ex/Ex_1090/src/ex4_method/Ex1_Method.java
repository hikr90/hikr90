package ex4_method;

public class Ex1_Method {
	
	public static void main(String[] args) {
		// Ŭ���� ���� �� �޼ҵ� ����
		Ex2_String_Method v1 = new Ex2_String_Method();
		v1.greet();
		
		System.out.println("---------------");
		
		// �Ķ���� ���� �޴� �޼ҵ� ����
		// 	- ���� �Ķ���� �������� ����� �ٸ��� ���´�.
		int su = 100; 
		int su2 = 0;
		v1.test1(su);

		// 	- �޼ҵ�� ���� �����ϴ� �뵵�� ���ȴ�.
		// 	- ������ su �� ���� ���� �޼ҵ忡 �� ���� �ƴϰ� �� ���� �����Ǿ� �޼ҵ�� �� ���̴�.
		// 	- ���� ���� ������ �ʾ����Ƿ� su�� ���� �״���̴�.
		System.out.println("su : "+su);
		
		System.out.println("---------------");

		// ���� Ÿ���� �ִ� �޼ҵ� ����
		// 	- �޼ҵ尡 �����ϴ� ���� ������ �޾��ָ� �޼ҵ� �ȿ��� ���� ���� �״�� �޾Ƽ� ������ �� �ִ�.
		su2 = v1.test0(su);
		System.out.println("su2 : "+su2);
		
		System.out.println("---------------");
		
		// String Ÿ���� ���� �޼ҵ� ����
		String name = "ȫ�浿";
		int age = 19;
		String res = v1.test2(age);
		
		System.out.printf("%s���� %s�Դϴ�.\n",name,res);

		System.out.println("---------------");
		
		// boolean Ÿ���� ���� �޼ҵ� ����
		System.out.println("---���� ����� ������ ����---");
		boolean result = v1.test3("��", 21);
		//
		if(result==true) {
			System.out.println("�հ�");
		} else {
			System.out.println("���հ�");
		}
	}
}
