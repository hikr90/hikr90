package ex3_get_set;

public class Company {

	public static void main(String[] args) {
		
		// Set�� ����� ȣ��
		// Person�� setName���� ����. -> setName�� �޼��忡���ؼ� name�� "ȫ�浿�� ����."
		// ����ó�� p1.nameó�� ���� ���� �� ���輺�� ����.
//		Person p1 = new Person();
//		p1.setName("ȫ�浿");
//		
//		// �̸��� ����Ǹ� ���� ������� ������ �� �ִ�. 
//		p1.setName("ȫ���");
//		
//		// setAge �ż��嵵 �����Ͽ� ���̸� ����
//		p1.setAge(22);
//		
//		// Setter�� ȣ���� ���, ����ϴ� ���
//		// ����ϱ����ؼ��� �޼��尡 ��ȯ������ �Ǿ��־���Ѵ�. 
//		// ��ȯ�ϴ� �������δ� get�� ����Ѵ�.
//		// ���� ���� : Setter
//		// ���� ��ȯ : Getter
//		System.out.println(p1.getName());
//		System.out.println(p1.getAge());
		

		// ���̿� �̸��� ���� ������ �� �־� �߸��� �Է°��� �� �� �ִ�.
		// �׷��� Person���� private�� �ɰԵǸ� Company���� ������ ����� �ǵ帱 �� ������ ���ο� ����� ���� �� ����.
		// ������ ���� ������ �� �����鼭 ������ �����ο� ����� setter�̴�. 
		
		
		// ����
		// Ÿ�����׼� setProperty�� �ִ� Ŭ������ �޾� ����� ��, �Ķ���ͷ� �� �־������ �𸥴�.
		// �׷��� �޼��忡�� ���� �ִ� �ܾ�� ������Ѵ�.
		Person p2 = new Person();
		p2.setProperty("����浿", 40);
		
		// null�� 0���� ���´�. 
		// �̶��� void�ʿ��� this�� ������ ��������Ѵ�.
		System.out.println(p2.getName());
		System.out.println(p2.getAge());
		

		
		
		
		
		
		
		
		
		
	}
}
