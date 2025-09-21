package ex4_state_control;

public class Ex4_Yield {
	public static void main(String[] args) {
		/* 쓰레드의 양보
		 * 	- yield는 자신에게 주어진 실행시간을 다음 차례의 쓰레드에게 양보한다.
		 */
		Ex4_1_Thread th1 = new Ex4_1_Thread("*");
		Ex4_1_Thread th2 = new Ex4_1_Thread("**");
		Ex4_1_Thread th3 = new Ex4_1_Thread("***");
		
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

//
class Ex4_1_Thread implements Runnable {
	boolean suspended = false;
	boolean stopped = false;
	
	Thread th;
	
	public Ex4_1_Thread(String name) {
		th = new Thread(this, name);
	}
	
	public void run() {
		String name = th.getName();
		
		while (!stopped) {
			// [참고] 조건 값이 true인 경우 else가 없다면 쓰레드는 대기 동안 의미없이 while문을 계속해서 반복한다.
			//		(바쁜 대기 상태라고 부른다.)
			if(!suspended) {
				System.out.println(name);
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println(name + " - interrupted");
				}
			} else {
				// 해당 기능이 추가되며 대기 시간동안 다음 대기 차례인 쓰레드에게 남은 실행 시간을 양보한다.
				Thread.yield();
			}
		}
	}
	
	// 일시정지
	public void suspend() {
		suspended = true;
		// [참고] interrupt가 추가된 이유
		// - suspend나 stop이 동작한 상태에서도 sleep이 있기에 최대 1초의 지연시간이 있다.
		// - 그러나 sleep이 있는 상태에서 interrupt가 동작하면 예외가 발생하므로 즉시 일시정지 상태에서 벗어나게 된다.
		th.interrupt();
		System.out.println(th.getName() + " - interrupt() by suspend()");
	}
	
	// 정지
	public void stop() {
		stopped = true;
		th.interrupt();
		System.out.println(th.getName() + " - intterupt() by stop()");
	}
	
	// 재시작
	public void resume() {
		suspended = false;
	}
	
	// 동작
	public void start() {
		th.start();
	}
}