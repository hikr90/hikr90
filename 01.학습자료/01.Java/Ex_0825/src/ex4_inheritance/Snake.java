package ex4_inheritance;

public class Snake extends Animal{
	String sence = "������ �ߴ�";
	
	// �޼����� �������̵�
	// �޼����� ������
	// �̹� �θ� �������ִ� �޼��带 ������ͼ�, �ڽ� Ŭ�������� ������ �ڽ��� ������ ���缭 ������ �ϴ� ��
	// �ݵ�� ��� ������ ��ü���� �����ϴ�. 
	@Override
	public int getLeg() {
		return 0;
	}
	
}
