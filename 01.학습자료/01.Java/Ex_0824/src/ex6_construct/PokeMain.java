package ex6_construct;

public class PokeMain {
	public static void main(String[] args) {
		// �����ε� �����ڷ� Ŭ���� ����
		Pokemon p1 = new Pokemon("��ī��");
		Pokemon p2 = new Pokemon("������");

		System.out.println("�����ε� ������ : "+p1.getName());
		System.out.println("�����ε� ������ : "+p2.getName());
		
		// �⺻ ������ ȣ���� �Ұ���������.
		// �������̵� �� �⺻ �����ڸ� ���� ���̰� ������ ���ָ� �⺻ �����ڸ� ����� �� �ִ�.
		Pokemon p3 = new Pokemon();
		System.out.println("�⺻ ������ : "+p3.getName());
	}
}
