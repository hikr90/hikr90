package ex1_set_get;

public class Ex2_Set_Get {
	public static void main(String[] args) {
		// 	- setName �޼ҵ带 ���ؼ� name�� ���� ����
		Ex1_Set_Get p1 = new Ex1_Set_Get();
		p1.setName("ȫ�浿");
		
		// 	- �̸��� ����Ǹ� ���� ������� ������ �� �ִ�.
		p1.setName("ȫ���");
		
		// 	- setAge �ż��嵵 �����Ͽ� ���̸� ����
		p1.setAge(22);
		
		// getName���� ���� ��ȸ
		System.out.println(p1.getName());
		System.out.println(p1.getAge());
		
		// 	- p1.name ���� ���� ���� ������ ���� ������
		// 	- setName �� getName���� ���� ��ȸ�ϰų� �����ϴ� ���� ��� �����ϴ�.
		
		// [����] �޼ҵ�� ��Ī ��ü�� ���� �ִ� ��Ī�� ����ϰų� �ּ����� ������ �߰��ϴ� ���� �����Ѵ�.
		Ex1_Set_Get p2 = new Ex1_Set_Get();
		p2.setProperty("����浿", 40);
		//
		System.out.println(p2.getName());
		System.out.println(p2.getAge());
	}
}
