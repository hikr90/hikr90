package ex3_thread;

// Main을 가진 스레드가 실행 스레드라고 생각하면 된다.
public class ThreadMain {
	public static void main(String[] args) {
		
		// 스레드의 run()메서드를 독립적으로 실행시키는 메서드
		MyThread mt = new MyThread();
		mt.start();
		
		
		for(int i=0;i<5;i++) {
			System.out.println("메인스레드의 작업");
		}
		
		System.out.println("프로그램 종료");
		
		
		
		
		
		
	}
}
