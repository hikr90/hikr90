package ex3_interface;

public class InterChild implements InterTest{
	
	// �߻� �޼ҵ��� ������
	@Override
	public int getValue() {
		// - final Ű���带 �ٿ��� ���� Ű����� ����̹Ƿ� ���� ������ �� ����.
		return VALUE;
	}
}
