package ex2_throws;

public class Throws2 {
	
	public void test() throws Exception{
			
		// throws
		// - ���� �޼ҵ忡�� �߻��ϴ� ���ܸ� �ش� ��ü�� ����ϰ� �ִ� Ÿ Ŭ������ �����ϴ� Ű����
		/*	sleep �޼ҵ忡 ����ó���� �־���ϴ� ����
		 *		- sleep�� �Ķ������ �ð���ŭ ����� �� �����ϴ� �޼ҵ��̴�.
		 *		- �ð��� ����ϴ� ����̴ٺ��� �߻��� �� �ִ� ������ �����ϹǷ� ���� ����ó���� �ʿ��ϴ�. 
		 */
		Thread.sleep(1000);
		//
		System.out.println("Throws2�޼��� ȣ��");
	}
}
