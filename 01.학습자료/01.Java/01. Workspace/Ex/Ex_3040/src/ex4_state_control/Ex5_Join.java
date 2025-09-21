package ex4_state_control;

public class Ex5_Join {
	public static void main(String[] args) {
		/* 쓰레드의 작업 대기
		 * 	- join 메소드는 자신의 작업을 잠시 멈추고 다른 쓰레드가 지정된 시간동안 작업을 수행하도록 한다.
		 * 	- 따로 시간을 지정하지 않는 경우 해당 쓰레드가 작업을 종료할 때까지 기다린다.
		 * 
		 * 	[참고] join 과 sleep 차이
		 * 		- join 역시 sleep 처럼 interrupt에 의해 대기상태에서 벗어날 수 있으며 try catch 처리가 있어야한다.
		 * 		- sleep은 현재 쓰레드에서 동작하는 static메소드이고, join은 특정 쓰레드에 대해 동작하므로 static 메소드가 아니다.
		 */
		
		// [예시] 가비지 컬렉터
		Ex5_1_Thread gc = new Ex5_1_Thread();
		gc.setDaemon(true);
		gc.start();
		
		int requireMemory = 0;
		
		for (int i = 0; i < 20; i++) {
			requireMemory = (int)(Math.random() * 10) * 20;
			
			// (1) 필요 메모리가 사용 가능한 메모리보다 높거나
			// (2) 전체 메모리의 60% 이상 사용 시 gc 동작
			if(gc.freeMemory() < requireMemory || gc.freeMemory() < gc.totalMemory() * 0.4) {
				gc.interrupt();
				try {
					// [참고] join 이 있어야하는 이유
					//		- interrupt를 통해서 gc 쓰레드를 깨워 동작시키더라도
					//		- gc가 수행되기 전에 main쓰레드가 먼저 동작하므로 gc.join 메소드로 main 쓰레드가 gc 쓰레드의 작업을 기다리게 한다.
					// 	-  join(100)은 0.1초 대기를 뜻한다.
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
			
			// 가비지 컬렉터 동작
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