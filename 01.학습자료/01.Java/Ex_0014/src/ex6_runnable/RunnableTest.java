package ex6_runnable;

public class RunnableTest implements Runnable{

	/*	Runnable
	 *		- 상속 방식으로 사용하는 스레드와 다르게 Runnable은 인터페이스의 추상 메소드로 구현한다.
	 *		- run 메소드를 재정의하여 사용한다.
	 * 
	 */
	// 추상 메서드는 오버라이드가 있어야한다.
	@Override
	public void run() {
		//
		for(int i=0;i<10;i++) {
			try {
				//
				Thread.sleep(500);
				System.out.println(i);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
