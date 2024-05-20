package ex6_runnable;

public class RunnableMain {
	public static void main(String[] args) {
		// Runnable 클래스 선언 
		RunnableTest rt = new RunnableTest();
		// 스레드를 선언하며 Runnable 객체를 파라미터로 넣는다.
		Thread t = new Thread(rt); 
		t.start();
	}
}
