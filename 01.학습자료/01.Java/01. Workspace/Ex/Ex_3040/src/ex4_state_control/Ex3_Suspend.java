package ex4_state_control;

public class Ex3_Suspend {
	public static void main(String[] args) {
		/*	쓰레드의 일시정지
		 * 		- suspend는 쓰레드의 동작을 멈추게 한다.
		 * 		- 정지된 쓰레드는 resume 메소드를 통해서 다시 실행대기 상태로 되돌릴 수 있다.
		 * 		- stop은 즉시 쓰레드가 종료된다.
		 * 
		 * 		[참고] suspend와 stop은 쓰레드의 교착 상태를 발생시키기도 한다.
		 * 			- API 문서 내에서는 사용이 권장되지 않음으로 작성되어있다.
		 */
		
		// 쓰레드 생성 후 동작
		Ex3_1_Thread th1 = new Ex3_1_Thread("*");
		Ex3_1_Thread th2 = new Ex3_1_Thread("**");
		Ex3_1_Thread th3 = new Ex3_1_Thread("***");
		
		th1.start();
		th2.start();
		th3.start();
		
		try {
			//
			Thread.sleep(2000);
			th1.suspend();
			//
			Thread.sleep(2000);
			th2.suspend();
			// 
			Thread.sleep(3000);
			th1.resume();
			//
			Thread.sleep(3000);
			th1.stop();
			th2.stop();
			//
			Thread.sleep(2000);
			th3.stop();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Ex3_1_Thread implements Runnable {
	boolean suspended = false;
	boolean stopped = false;
	
	Thread th;
	
	public Ex3_1_Thread(String name) {
		th = new Thread(this, name);				// Thread(Runnable r, String name)
	}
	
	public void run() {
		while (!stopped) {
			if(!suspended) {
				System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(Thread.currentThread().getName() + " - stopped");
	}
	
	public void suspend() { suspended = true; }
	public void resume() { suspended = false; }
	public void stop() { stopped = true; }
	public void start() { th.start();; }

}