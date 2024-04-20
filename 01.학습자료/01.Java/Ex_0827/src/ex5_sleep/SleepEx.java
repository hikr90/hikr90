package ex5_sleep;

public class SleepEx extends Thread{
	
	int [] arr = new int[10];
	
	public SleepEx() {
		for(int i=0;i<arr.length;i++) {
			arr[i] = (i+1);
		}
	}
	
	
	@Override
	public void run() {
		for(int i=0;i<arr.length;i++) {
			
			try {
				// 여러 스레드로 작업을 번갈아주다가 강제적으로 쉬는 시간이 있으면 예외(오류) 발생 가능성이 있으니 try-catch로 묶어줘야한다.
				Thread.sleep(1000);
				System.out.println(arr[i]);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
