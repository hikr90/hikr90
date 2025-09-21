package ex4_state_control;

public class Ex6_Synchronized {
	public static void main(String[] args) {
		/*	쓰레드의 동기화
		 * 		- 멀티 쓰레드 환경에서는 여러 쓰레드가 프로세스 내 자원을 공유하므로 서로의 작업에 영향을 준다.
		 * 		- 서로 영향주는 일을 방지하기위해서 쓰레드에는 임계 영역과 잠금이라는 개념이 존재한다.
		 * 
		 * 		- 공유 정보 값을 사용하는 코드 영역을 임계 영역으로 지정해두고 
		 * 		- 공유 데이터(객체)가 가지고있는 Lock을 획득한 단 하나의 쓰레드만 영역 내의 코드를 수행할 수 있게 한다.
		 * 
		 * 		[참고] 동기화란, 한 쓰레드가 진행 중인 작업을 다른 쓰레드가 간섭하지 못하도록 막는 것이다.
		 * 
		 * 
		 * 		동기화 방법
		 * 			(1) 메소드 전체를 임계 영역으로 지정
		 * 				- 쓰레드는 동기화 메소드가 호출된 시점부터 해당 메소드가 포함된 객체의 Lock을 얻어 작업을 수행하다가 메소드가 종료되면 Lock을 반환한다.
		 * 
		 * 				public synchronized void test(){
		 * 			
		 * 				}			
		 * 
		 * 			(2) 특정한 영역을 임계 영역으로 지정
		 * 				- 참조변수는 락을 걸고자하는 객체를 참조하는 것이여야 한다.
		 * 				- { }은 synchronized 블럭이라고 부르며, 이 블록을 벗어나면 Lock을 반납한다.
		 * 
		 * 				synchronized(객체의 참조변수) {
		 * 
		 * 				}
		 */
		 Runnable r = new Ex_Runnable();		 
		 new Thread(r).start();
		 new Thread(r).start();
	}
}


// 계좌
class Account {
	private int balance = 1000;
	
	public int getBalance() {
		return balance;
	}
	// 동기화
	// - 한 쓰레드에서 출금이 진행되면 이 메소드가 종료되어 Lock이 반납될 때까지는 다른 쓰레드에서 호출하더라도 대기 상태가 된다.
	// - 만약 (2)의 방식으로 진행한다면 아래 주석처럼 진행된다.
	public synchronized void withdraw(int money) {
		// synchronized(this) {내용}
		if(balance >= money) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			balance -= money;
		}
	}
}

// 쓰레드
class Ex_Runnable implements Runnable {
	Account acc = new Account();
	
	public void run() {
		while (acc.getBalance() > 0) {
			// 100, 200, 300 중의 한 값을 임의로 선택해서 출금
			int money = (int)(Math.random() * 3 + 1) * 100;
			acc.withdraw(money);
			System.out.println("balance : " + acc.getBalance());
		}
	}
}