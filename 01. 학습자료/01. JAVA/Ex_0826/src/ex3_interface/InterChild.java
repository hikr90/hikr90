package ex3_interface;
// �������̽��� ���
// implementsŰ���带 ���ؼ� �������̽��� "����"�Ѵ�.
public class InterChild implements InterTest{
	
	
	@Override
	public int getValue() {
		
		// finalŰ���带 �ٿ��� ���� Ű����� ����̹Ƿ� ���� ������ �� ����.
		// VALUE += 10; 
		
		return VALUE;
	}
	
	
}
