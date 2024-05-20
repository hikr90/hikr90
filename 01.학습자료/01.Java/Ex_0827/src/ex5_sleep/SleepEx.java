package ex5_sleep;

public class SleepEx extends Thread{
	//
	int [] arr = new int[10];
	//
	public SleepEx() {
		for(int i=0;i<arr.length;i++) {
			arr[i] = (i+1);
		}
	}
	
	@Override
	public void run() {
		for(int i=0;i<arr.length;i++) {
			//
			try {
				//
				Thread.sleep(1000);
				System.out.println(arr[i]);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
