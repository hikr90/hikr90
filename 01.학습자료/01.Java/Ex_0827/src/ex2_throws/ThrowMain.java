package ex2_throws;

public class ThrowMain {

	// main������ throws�� ���� ������� �ʴ´�.
	public static void main(String[] args) {
		
		
		Throws1 t1 = new Throws1();
		Throws2 t2 = new Throws2();
		
		try {
			t1.test();
			t2.test();			
		} catch (Exception e) {
			System.out.println("���� �߻�");
		}
		
	}
}
