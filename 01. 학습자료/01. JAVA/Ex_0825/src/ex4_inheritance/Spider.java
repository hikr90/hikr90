package ex4_inheritance;

public class Spider extends Animal{
	String web = "����";
	
	
	// �������̵��� �θ� �޼����� ��Ī ��ҹ��ڳ� �Ķ������ ��Ī���� ���� ���ƾ��Ѵ�.
	@Override
	public int getLeg() {
		return 6;
	}
	
	
	@Override
	public int getEye() {
		return 8;
	}
	
	
	
}
