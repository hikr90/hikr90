package ex4_state_control;

public class Ex3_Suspend {
	public static void main(String[] args) {
		/*	�������� �Ͻ�����
		 * 		- suspend�� �������� ������ ���߰� �Ѵ�.
		 * 		- ������ ������� resume �޼ҵ带 ���ؼ� �ٽ� ������ ���·� �ǵ��� �� �ִ�.
		 * 		- stop�� ��� �����尡 ����ȴ�.
		 * 
		 * 		[����] suspend�� stop�� �������� ���� ���¸� �߻���Ű�⵵ �Ѵ�.
		 * 			- API ���� �������� ����� ������� �������� �ۼ��Ǿ��ִ�.
		 */
		
		// ������ ���� �� ����
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