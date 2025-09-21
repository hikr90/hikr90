package ex2_thread_type;

public class Ex3_Thread_Priority {
	public static void main(String[] args) {
		/*	쓰레드의 우선순위
		 *		- 실행 순서, 실행 시간을 결정하는 속성
		 *		- 우선순위는 프로그램의 성격에 따라 각기 다르다.
		 *		- 파일 전송과 채팅 기능이 있는 쓰레드에서는 채팅 기능이 파일 다운로드보다 우선순위가 높아야한다. 
		 *
		 *		우선순위 속성
		 *			- setPriority : 쓰레드의 우선순위를 지정한 값으로 변경한다.
		 *			- getPriority : 쓰레드의 우선순위를 반환한다.
		 *
		 *			- MAX_PRIORITY : 최대 우선순위
		 *			- MIN_PRIORITY : 최소 우선순위
		 *			- NORM_PRIORITY : 보통 우선순위
		 *
		 *		[참고] 우선순위의 범위는 1 ~ 10이며, 숫자가 높을수록 우선순위가 높다.
		 *			- 쓰레드의 우선순위는 생성한 쓰레드로부터 상속받는다.
		 *			- 예시로, 메인 메소드를 실행하는 쓰레드는 우선순위가 5이므로 메인 내에서 생성하는 쓰레드의 우선순위는 5가 된다.
		 */
		Ex3_1_thread t1 = new Ex3_1_thread();
		Ex3_2_thread t2 = new Ex3_2_thread();
		
		t2.setPriority(7);
		
		System.out.println("Priority of t1 (-) : " + t1.getPriority());
		System.out.println("Priority of t2 (|) : " + t2.getPriority());
		
		t1.start();
		t2.start();
	}
}


class Ex3_1_thread extends Thread{
	public void run() {
		for(int i=0;i<300;i++) {
			System.out.print("-");
			for(int j=0;j<10000000;j++);
		}
	}
}

class Ex3_2_thread extends Thread{
	public void run() {
		for(int i=0;i<300;i++) {
			System.out.print("|");
			for(int j=0;j<10000000;j++);
		}
	}	
}