package ex3_demon;

public class Ex1_Demon_Thread {
	
	public static void main(String[] args) {
		/* 데몬스레드
		 *		- 메인 스레드의 작업을 돕는 보조적인 역할을 수행하는 스레드
		 *		- 메인 스레드가 종료되면 실행 중인 데몬 스레드도 같이 종료된다. 
		 *				(가비지 컬렉터, 워드프로세서 자동저장, 화면 자동 갱신)
		 *
		 *			[참고] 주요 메소드
		 *				- isDemon : 쓰레드가 데몬 쓰레드인지 구분
		 *				- setDemon : 쓰레드에서 데몬 쓰레드 혹은 사용자 쓰레드로 변경
		 *					(데몬 쓰레드 변경은 쓰레드가 동작하기 전에 진행되어야 한다.)
		 */
		Ex2_Demon_Thread dt = new Ex2_Demon_Thread();
		Thread t = new Thread(dt);
		t.setDaemon(true);		
		t.start();
		
		// 메인에서의 작업
		for(int i=1; i<=20;i++) {
			//
			try {
				Thread.sleep(1000);
				System.out.println("게임중"+i);
				
			} catch (Exception e) {

			}
		}
		//
		System.out.println("메인 스레드 종료");
	}	
}
