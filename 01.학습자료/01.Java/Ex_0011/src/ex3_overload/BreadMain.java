package ex3_overload;

public class BreadMain {
	
	public static void main(String[] args) {
		
		// ����
		// - ù��° �޼ҵ� ȣ�� : ���� ��������ϴ�.
		
		// - �ι�° �޼ҵ� ȣ��
		// - ���� ��������ϴ�.
		// - ���� ��������ϴ�.
		// - ��û�Ͻ� 2���� ���� ��������ϴ�.
		
		// - ����° �޼ҵ� ȣ��
		// - ũ������ ��������ϴ�.
		// - ũ������ ��������ϴ�.
		// - ũ������ ��������ϴ�.
		// - ��û�Ͻ� 3���� ũ������ ��������ϴ�.
		Bread br = new Bread();
		br.makeBread();
		System.out.println("-------");
		br.makeBread(2);
		System.out.println("-------");
		br.makeBread(3,"ũ����");
	}
}
