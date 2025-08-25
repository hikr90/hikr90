package ex3_thread;

public class ThreadMain {
	public static void main(String[] args) {

		// 스레드 실행 클래스
		// - 스레드를 상속하는 클래스를 선언한 뒤
		// - start 메소드를 통해서 동작시킨다.
		MyThread mt = new MyThread();
		mt.start();
		//
		for(int i=0;i<5;i++) {
			System.out.println("메인스레드의 작업");
		}
		//
		System.out.println("프로그램 종료");
	}
}
