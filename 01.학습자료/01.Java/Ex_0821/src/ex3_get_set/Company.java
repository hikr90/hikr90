package ex3_get_set;

public class Company {

	public static void main(String[] args) {

		// Ŭ���� ����
		// - setName �޼ҵ带 ���ؼ� name�� ���� ����
		Person p1 = new Person();
		p1.setName("ȫ�浿");
		
		// - �̸��� ����Ǹ� ���� ������� ������ �� �ִ�.
		p1.setName("ȫ���");
		
		// - setAge �ż��嵵 �����Ͽ� ���̸� ����
		p1.setAge(22);
		
		// getName���� ���� ��ȸ
		System.out.println(p1.getName());
		System.out.println(p1.getAge());
		
		// - p1.name ���� ���� ���� ������ ���� ������
		// - setName �� getName���� ���� ��ȸ�ϰų� �����ϴ� ���� ��� �����ϴ�.
		
		// [����] setProperty �޼ҵ� ��� ��, �Ķ���ͷ� � ���� ������ ȥ���� ���� �� �ִ�.
		// - �׷��� �޼ҵ� ��ü�� ���� �ִ� �ܾ ����ϰų�
		// - �ּ����� ���� ���� ������ �־��ִ� ���� ����.
		Person p2 = new Person();
		p2.setProperty("����浿", 40);
		//
		System.out.println(p2.getName());
		System.out.println(p2.getAge());
	}
}
