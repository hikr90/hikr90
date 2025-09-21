package ex4_state_control;

public class Ex5_Join {
	public static void main(String[] args) {
		/* �������� �۾� ���
		 * 	- join �޼ҵ�� �ڽ��� �۾��� ��� ���߰� �ٸ� �����尡 ������ �ð����� �۾��� �����ϵ��� �Ѵ�.
		 * 	- ���� �ð��� �������� �ʴ� ��� �ش� �����尡 �۾��� ������ ������ ��ٸ���.
		 * 
		 * 	[����] join �� sleep ����
		 * 		- join ���� sleep ó�� interrupt�� ���� �����¿��� ��� �� ������ try catch ó���� �־���Ѵ�.
		 * 		- sleep�� ���� �����忡�� �����ϴ� static�޼ҵ��̰�, join�� Ư�� �����忡 ���� �����ϹǷ� static �޼ҵ尡 �ƴϴ�.
		 */
		
		// [����] ������ �÷���
		Ex5_1_Thread gc = new Ex5_1_Thread();
		gc.setDaemon(true);
		gc.start();
		
		int requireMemory = 0;
		
		for (int i = 0; i < 20; i++) {
			requireMemory = (int)(Math.random() * 10) * 20;
			
			// (1) �ʿ� �޸𸮰� ��� ������ �޸𸮺��� ���ų�
			// (2) ��ü �޸��� 60% �̻� ��� �� gc ����
			if(gc.freeMemory() < requireMemory || gc.freeMemory() < gc.totalMemory() * 0.4) {
				gc.interrupt();
				try {
					// [����] join �� �־���ϴ� ����
					//		- interrupt�� ���ؼ� gc �����带 ���� ���۽�Ű����
					//		- gc�� ����Ǳ� ���� main�����尡 ���� �����ϹǷ� gc.join �޼ҵ�� main �����尡 gc �������� �۾��� ��ٸ��� �Ѵ�.
					// 	-  join(100)�� 0.1�� ��⸦ ���Ѵ�.
					gc.join(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			//
			gc.usedMemory += requireMemory;
			System.out.println("usedMemory : " + gc.usedMemory);
		}
	}
}

//
class Ex5_1_Thread extends Thread {
	final static int MAX_MEMORY = 1000;
	int usedMemory = 0;
	
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000 * 10);
			} catch (InterruptedException e) {
				System.out.println("Awaken by interrupt().");
			}
			
			// ������ �÷��� ����
			gc();
			System.out.println("Garbage Collected. Free Memory : " + freeMemory());
		}
	}
	
	//
	public void gc() {
		usedMemory -= 300;
		if(usedMemory < 0) usedMemory = 0;
	}
	
	public int totalMemory() { return MAX_MEMORY; }
	public int freeMemory() { return MAX_MEMORY - usedMemory; }
}