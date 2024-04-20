package ex6_runnable;

// Runnable이라는 인터페이스 구현
public class RunnableTest implements Runnable{

	// 추상 메서드는 오버라이드가 있어야한다.
	@Override
	public void run() {
		
		for(int i=0;i<10;i++) {
			try {
				Thread.sleep(500);
				System.out.println(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
