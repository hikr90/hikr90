package ex7_work;

public class Ex2_Work extends Thread{
	//
	public int cnt = 0;

	@Override
	public void run() {
		//	
		for(int i=0; i<100000000;i++) {
			//
			try {
				Thread.sleep(1000);
					cnt++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
