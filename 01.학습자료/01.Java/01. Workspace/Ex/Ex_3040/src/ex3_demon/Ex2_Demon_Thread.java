package ex3_demon;

public class Ex2_Demon_Thread implements Runnable{

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
