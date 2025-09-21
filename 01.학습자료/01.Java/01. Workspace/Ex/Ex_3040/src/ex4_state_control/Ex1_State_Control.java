package ex4_state_control;

public class Ex1_State_Control {
	public static void main(String[] args) {
		/*	쓰레드의 실행제어
		 * 		- 쓰레드 내 주요 실행제어 동작으로는 동기화, 스케쥴링이 있다.
		 * 		
		 * 			(1) 주요 메소드 
		 * 				(1.1) sleep
		 * 					- 지정된 시간만큼 쓰레드를 일시정지 시킨다.
		 * 					
		 * 				(1.2) join
		 * 					- 지정된 시간동안 쓰레드가 동작하도록 한다.
		 * 					
		 * 				(1.3) interrupt
		 * 					- sleep 혹은 join에 의해서 일시정지상태인 쓰레드를 깨워 실행대기 상태로 만든다.
		 * 					
		 * 				(1.4) stop
		 * 					- 쓰레드를 즉시 정지시킨다.
		 * 
		 * 				(1.5) suspend
		 * 					- 쓰레드를 일시정지시킨다.
		 * 					- resume로 다시 실행대기 상태로 변경할 수 있다.
		 * 
		 * 				(1.6) yield
		 * 					- 실행 중에 자신에게 주어진 실행 시간을 다른 쓰레드에 양보한다.
		 * 					- 자신은 메소드 동작과 동시에 실행대기 상태가 된다.
		 * 
		 * 			(2) 쓰레드의 상태
		 * 				(2.1) NEW : 쓰레드가 생성되고 아직 start가 동작하지 않은 상태
		 * 				(2.2) RUNNABLE : 실행 중 혹은 실행 가능한 상태
		 * 				(2.3) BLOCKED : 동기화 블럭에의해서 일시정지 상태 (Lock이 해제될 때까지 대기)
		 * 				(2.4) WATING : 일시정지 상태
		 * 				(2.5) TERMINATED : 쓰레드의 작업이 종료
		 * 
		 * 			(3) 쓰레드의 실행 순서
		 * 				(3.1) 쓰레드가 생성되고 start가 동작
		 * 				(3.2) 실행대기열 (Runnable)에 저장되어 대기 상태
		 * 				(3.3) 자신의 차례가 오면 실행상태로 변경
		 * 				(3.4) 실행시간이 종료되거나, yield 메소드가 동작하면 실행대기상태가 되어 다음 쓰레드가 동작 차례가 된다.
		 * 				(3.5) 일시정지 시간이 종료되거나 resume 등의 함수가 동작하면 일시정지 상태에서 벗어나 다시 실행대기열에 저장되어 대기한다.
		 * 				(3.6) 실행이 전부 완료되거나 stop이 호출되면 쓰레드는 소멸한다.
		 */
		Ex1_1_Thread th1 = new Ex1_1_Thread();
		Ex1_2_Thread th2 = new Ex1_2_Thread();
		
		th1.start();
		th2.start();
		
		try {
			//  실행제어 메소드는 현재 동작 중인 쓰레드에 대해서 동작하므로
			// th1.sleep 으로 했더라도 실제로 영향은 main 메소드가 동작되는 main 쓰레드에서 받는다.
			// 즉, 두 쓰레드는 시간 차이가 없다. 
			// (차이가 있어야할 때는 Thread.sleep 으로 작성해야한다.)
			th1.sleep(2000);
			
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
}

//
class Ex1_1_Thread extends Thread {
	public void run() {
		for(int i=0;i<300;i++) {
			System.out.print("-");
		}
		System.out.println("th1 종료");
	}
}

class Ex1_2_Thread extends Thread {
	public void run() {
		for(int i=0;i<300;i++) {
			System.out.print("|");
		}
		System.out.println("th2 종료");
	}
}