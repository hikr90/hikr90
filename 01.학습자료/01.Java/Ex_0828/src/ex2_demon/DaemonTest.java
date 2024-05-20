package ex2_demon;

public class DaemonTest implements Runnable{

	@Override
	public void run() {
		//
		while(true) {
			try {
				Thread.sleep(3000);
				System.out.println("자동 저장중...");
				
			} catch (Exception e) {

			}
			
		} // while
		
	}

}
