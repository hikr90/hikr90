package ex1_thread;

public class Ex2_Start_Run {
	public static void main(String[] args) {
		/*	start & run
		 * 	- 쓰레드 동작 시, run이 아닌 start로 동작한다.
		 * 	- 메인 메소드에서 run으로 동작시키는 것은 쓰레드가 동작하는 것이 아닌 클래스 내 선언된 쓰레드가 동작하는 것이다.
		 * 	
		 * 	(1) Call Stack
		 * 		- 메인 영역에서 프로그램 동작 시, 동작 단위가 쌓이는 영역
		 * 		- 호출 스택에서는 가장 위에 있는 메소드가 현재 실행 중인 메소드이다. (나머지 메소드는 대기 상태)
		 * 		- 스케쥴러는 실행 대기중인 쓰레드드의 우선순위를 고려하여 실행순서와 실행시간을 결정한다.
		 * 		- run이 동작하며 작업 수행이 완료된 쓰레드는 호출 스택에서 비워지면서 해당 쓰레드가 사용하던 호출 스택도 사라진다.
		 * 
		 * 		(1.1) 메인에서 run 동작
		 * 			- (1) main > (2) run
		 * 
		 * 		(1.2) 메인에서 start 동작
		 * 			(1) 새로운 쓰레드 생성
		 * 			(2) 작업 실행에 필요한 호출 스택 생성
		 * 			(3) 호출 스택에서 run이 동작하여 쓰레드가 독립적인 공간에서 작업을 수행
		 * 			(4) main/run 두가지 호출 스택이 스케쥴러가 정한 순서에 의해서 번갈아가면서 실행
		 * 
		 * 		[참고] 메인 메소드도 쓰레드이다.
		 * 			- 만약 다른 쓰레드가 대기 상태라면 메인 쓰레드가 종료되어도 프로그램은 종료되지 않는다.
		 * 
		 */
		
		// [참고] start와 run의 차이
		Ex2_1_Thread t1 = new Ex2_1_Thread();
		
		// (1) start (run > throwException)
		// - at ex2_start_run.Ex2_1_Thread.throwException(Ex1_start_run.java:47)
		// - at ex2_start_run.Ex2_1_Thread.run(Ex1_start_run.java:42)
		t1.start();
		
		// (2) run (throwException > run > main)
		// - at ex2_start_run.Ex2_1_Thread.throwException(Ex1_start_run.java:55)
		// - at ex2_start_run.Ex2_1_Thread.run(Ex1_start_run.java:50)
		// - at ex2_start_run.Ex1_start_run.main(Ex1_start_run.java:43)
		// t1.run();
	}
}

// 쓰레드 예외 발생
class Ex2_1_Thread extends Thread {
	public void run() {
		throwException();
	}
	//
	public void throwException() {
		try {
			throw new Exception();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}