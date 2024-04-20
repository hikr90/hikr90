package ex2_demon;

public class DaemonMain {
	
	public static void main(String[] args) {
		
		/* 데몬스레드
		 * 메인 스레드의 작업을 돕는 보조적인 역할을 수행하는 스레드이다.
		 * 나(데몬)를 호출한 메인스레드가 종료되면 실행중인 데몬 스레드도 함께 강제 종료될 수 있도록 처리한다. 
		*/
		
		
		DaemonTest dt = new DaemonTest();
		Thread t = new Thread(dt);
		
		// (중요!)start전에 해줘야한다.
		// t라는 스레드가 데몬임을 명시해준다.
		// t는 데몬 스레드로서, 스타트시킨 메인의 스레드가 종료되면 t역시 종료된다.
		t.setDaemon(true);		
		t.start();
		
		// 메인에서의 작업
		for(int i=1; i<=20;i++) {
		
			try {
				Thread.sleep(1000);
				System.out.println("게임중"+i);
			} catch (Exception e) {

			}
		}
		
		System.out.println("메인 스레드 종료");
		
		
	}	
}
