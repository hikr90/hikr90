package ex1_thread;

public class Ex1_Thread {
	public static void main(String[] args) {
		/*	프로세스 & 쓰레드
		 * 	(1) 프로세스
		 * 		- 실행 중인 프로그램을 뜻한다.
		 * 		- 프로그램을 실행하면 OS으로부터 프로그램 실행에 필요한 자원(메모리)을 할당받아 프로세스가 된다.
		 * 		
		 * 		(1.1) 프로세스의 구성
		 * 			- 데이터, 메모리, 쓰레드
		 * 			- 모든 프로세스에는 최소한 하나 이상의 쓰레드가 존재
		 * 			- 둘 이상의 쓰레드가 존재하는 경우 멀티쓰레드 프로세스라고 부른다.
		 * 		
		 * 	(2) 멀티태스킹 & 멀티쓰레딩
		 * 			(2.1) 멀티태스킹
		 * 				- 다중 작업을 뜻하며, 여러개의 프로세스가 동시에 동작하는 형태
		 * 				- window, uninx 에서 사용
		 * 
		 * 			(2.2) 멀티쓰레딩
		 * 				- 하나의 프로세스 안에서 여러 쓰레드가 동시에 작업을 수행 (채팅하면서 다운로드 받기 등...) 
		 * 				- CPU의 코어가 한 번에 하나의 작업만을 수행할 수 있으므로 실제로 동시에 처리되는 작업의 개수는 코어의 개수와 일치하는 것이 정석이나
		 * 				- 실제로는 아주 짧은 시간동안 여러 작업을 번갈아가며 수행함으로써 여러 작업들이 동시에 수행되는 것처럼 보이게 한다.
		 * 		
		 * 				(2.2.1) 멀티쓰레딩의 장점
		 * 					- CPU의 사용률을 향상시킨다.
		 * 					- 자원을 보다 효율적으로 사용할 수 있다.
		 * 					- 사용자에대한 응답성이 향상된다.
		 * 					- 작업이 분리되어 코드가 간결해진다.
		 * 
		 * 	(3) 쓰레드
		 * 		- 독립적인 실행 단위
		 * 		- 한번에 두가지 이상의 프로세스 동작시키는 기능
		 * 		- 사용자 쓰레드와 데몬 쓰레드 두가지 방식이 존재한다.
		 * 		
		 * 			(3.1) 싱글 쓰레드 : 메인으로 동작하는 쓰레드 외에 하나의 쓰레드가 동작하는 구조
		 * 			(3.2) 멀티 쓰레드 : 메인으로 동작한느 쓰레드 외에 두가지 이상의 쓰레드가 동작하는 구조
		 * 
		 * 	[참고] 한 번 실행이 종료된 쓰레드는 다시 실행할 수 없다.
		 * 		- 한번의 쓰레드에 start는 한번만 동작
		 * 		- 만약 여러번 수행되어야 한다면 t1 = new Ex1_1_Thread(); 처럼 새로운 쓰레드가 생성된 뒤에 다시 start가 동작되어야 한다.
		 */
		
		// 쓰레드의 구현
		// (1) Tread 클래스 상속
		Thread t1 = new Ex1_1_Thread();
		t1.start();
		System.out.println("---------------------------------");
		
		// (2) Runnable 인터페이스 구현 (일반적)
		Runnable r1 = new Ex1_2_Runnable();
		Thread t2 = new Thread(r1);
		t2.start();				// start는 바로 실행이 아니라, 실행 대기 상태에 진입한다. (본 예시에서는 실행대기가 없어, 바로 동작한다.)
		
		// [참고] 쓰레드의 명칭은 아래의 생성자, 메소드로 지정 또는 수정 가능하다.
		// - Thread(Runnable target, String name);
		// - Thread(String name);
		// - void setName(String name);
		
		/* [참고] 상속과 구현의 인스턴스 생성 차이
		 * 	(1) 상속
		 * 		- 자손 클래스에서 조상인 Thread 클래스의 메소드 직접 동작 
		 * 
		 * 	(2) 구현
		 * 		- Runnable 인터페이스 구현 클래스의 인스턴스 생성
		 * 		- Thread 클래스의 생성자로 해당 인스턴스의 인스턴스 제공
		 * 		- run 동작 시 참조변수 r을 통해서 Runnable 인터페이스 구현 인스턴스의 run 동작 
		 */
	}
}

// Thread 상속
class Ex1_1_Thread extends Thread {
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println("Thread : " + getName());
		}
	}
}

// Runnable 구현
class Ex1_2_Runnable implements Runnable {
	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println("Runnable : " + Thread.currentThread());
		}
	}	
}