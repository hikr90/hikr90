package ex4_inheritance;

public class Snake extends Animal{
	// Animal�� ��ӹ޴� Snake Ŭ���� 
	String sence = "������ �ߴ�";
	
	/*	�������̵�
	 * 	- �޼ҵ��� ������
	 * 	- �̹� �θ� �������ִ� �޼ҵ带 �����ͼ�, �ڽ� Ŭ�������� �������Ͽ� ����� ������ ���Ѵ�.
	 * 	- ����� ���迡���� �����ϴ�.
	 * 
	 */
	@Override
	public int getLeg() {
		return 0;
	}
}
