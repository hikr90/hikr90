package ex2_demon;

public class DaemonTest implements Runnable{

	@Override
	public void run() {
		//
		while(true) {
			try {
				Thread.sleep(3000);
				System.out.println("�ڵ� ������...");
				
			} catch (Exception e) {

			}
			
		} // while
		
	}

}
