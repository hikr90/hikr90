package ex4_state_control;

public class Ex4_Yield {
	public static void main(String[] args) {
		/* �������� �纸
		 * 	- yield�� �ڽſ��� �־��� ����ð��� ���� ������ �����忡�� �纸�Ѵ�.
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
			// [����] ���� ���� true�� ��� else�� ���ٸ� ������� ��� ���� �ǹ̾��� while���� ����ؼ� �ݺ��Ѵ�.
			//		(�ٻ� ��� ���¶�� �θ���.)
			if(!suspended) {
				System.out.println(name);
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println(name + " - interrupted");
				}
			} else {
				// �ش� ����� �߰��Ǹ� ��� �ð����� ���� ��� ������ �����忡�� ���� ���� �ð��� �纸�Ѵ�.
				Thread.yield();
			}
		}
	}
	
	// �Ͻ�����
	public void suspend() {
		suspended = true;
		// [����] interrupt�� �߰��� ����
		// - suspend�� stop�� ������ ���¿����� sleep�� �ֱ⿡ �ִ� 1���� �����ð��� �ִ�.
		// - �׷��� sleep�� �ִ� ���¿��� interrupt�� �����ϸ� ���ܰ� �߻��ϹǷ� ��� �Ͻ����� ���¿��� ����� �ȴ�.
		th.interrupt();
		System.out.println(th.getName() + " - interrupt() by suspend()");
	}
	
	// ����
	public void stop() {
		stopped = true;
		th.interrupt();
		System.out.println(th.getName() + " - intterupt() by stop()");
	}
	
	// �����
	public void resume() {
		suspended = false;
	}
	
	// ����
	public void start() {
		th.start();
	}
}