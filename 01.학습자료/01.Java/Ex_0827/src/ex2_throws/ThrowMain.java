package ex2_throws;

public class ThrowMain {

	// main에서는 throws를 거의 사용하지 않는다.
	public static void main(String[] args) {
		
		
		Throws1 t1 = new Throws1();
		Throws2 t2 = new Throws2();
		
		try {
			t1.test();
			t2.test();			
		} catch (Exception e) {
			System.out.println("오류 발생");
		}
		
	}
}
