package ex2_throws;

public class Throws2 {
	
	// throws : ���� �޼��忡�� �߻��� �� �ִ� ���ܸ� �ش� ��ü�� ����ϰ� �ִ� Ÿ Ŭ�������� ó���ϵ��� �����ϴ� Ű����
	// �޼��� �ڿ� ��ġ 
	public void test() throws Exception{
		
			// 1�� �� �� ���� �ڵ� ����
			// thread�� �ð��� ����ϴ� Ŭ�����ε� �ð��� ���������� ���ٺ��� ������ �Ͼ �� �ִ�.
			// �׷��� ���������� try-catch�� �־���Ѵ�.
			Thread.sleep(1000);

			System.out.println("Throws2�޼��� ȣ��");
	}
	
}
