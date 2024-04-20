package ex4_thread;

public class ThreadMain {

	public static void main(String[] args) {
		
		Thread01 t1 = new Thread01();
		Thread02 t2 = new Thread02();
		Thread03 t3 = new Thread03();
		
		t1.start();
		t2.start();
		t3.start();
		
		// main이 끝났음에도 스레드들은 자신의 작업이 완료될 때까지 계속해서 작업한다.
		System.out.println("메인 종료");
		
		
		
		
		
		
		
		
		
		
	}
}
