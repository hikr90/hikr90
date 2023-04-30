package ex8_work;

public class Test2 extends Thread{
	
	public int cnt = 0;

	@Override
	public void run() {
		
		
	for(int i=0; i<100000000;i++) {
		
		try {
			Thread.sleep(1000);
				cnt++;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	}
}
