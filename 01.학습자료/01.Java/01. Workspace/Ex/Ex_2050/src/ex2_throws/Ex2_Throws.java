package ex2_throws;

public class Ex2_Throws {
	public static void main(String[] args) {
		// main과 같은 실행 영역에서는 throws를 사용하지 않는다.
		Ex3_Throws t1 = new Ex3_Throws();
		Ex1_Throws t2 = new Ex1_Throws();
		//
		try {
			//
			t1.test();
			t2.test();			
			
		} catch (Exception e) {
			System.out.println("오류 발생");
		}
	}
}
