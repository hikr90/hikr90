package ex6_runnable;

// Runnable�̶�� �������̽� ����
public class RunnableTest implements Runnable{

	// �߻� �޼���� �������̵尡 �־���Ѵ�.
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
