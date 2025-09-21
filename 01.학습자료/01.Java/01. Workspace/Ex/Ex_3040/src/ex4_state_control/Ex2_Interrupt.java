package ex4_state_control;

import javax.swing.JOptionPane;

public class Ex2_Interrupt {
	public static void main(String[] args) {
		/* 쓰레드의 작업 취소
		 * 	- interrupt 는 쓰레드의 작업을 취소시키나 쓰레드를 강제로 정지시키지는 못한다.
		 * 	- interrupted는 쓰레드에 interrupt가 동작되었는지를 확인한다.
		 */
		Ex2_1_Thread th1 = new Ex2_1_Thread();
		th1.start();
		
		String s = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
		System.out.println("입력하신 값은 " + s + "입니다.");
		th1.interrupt();			// 일시정지
		System.out.println("isInterrupted : " + th1.isInterrupted());			// true
	}
}

//
class Ex2_1_Thread extends Thread {
	public void run() {
		int i = 10;
		//
		while (i != 0 && !isInterrupted()) {
			System.out.println(i--);
			// 1초 대기
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// [참고] 시간 지연 대신 sleep을 넣었을 때 에러 발생과 함께 시간이 멈추지 않는 이유?
				//		- sleep에 의해서 쓰레드가 멈춰있을 때, interrupt 을 호출하면 InterruptedException이 발생한다.
				// 	- 해당 예외가 발생하면서 interrupted 가 false (동작) 상태로 변경된다.
				// 	- 시간을 지연시키고자한다면 따로 interrupt() 가 있어야 한다.
				//e.printStackTrace();
				interrupt();
			}
			//
			// for(long x=0;x<2500000000L;x++);	// 시간 지연
		}
		System.out.println("카운트 종료");
	}
}