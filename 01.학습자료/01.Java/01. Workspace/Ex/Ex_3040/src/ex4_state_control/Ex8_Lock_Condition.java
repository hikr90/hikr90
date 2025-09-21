package ex4_state_control;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Ex8_Lock_Condition {
	public static void main(String[] args) throws InterruptedException {
		/*	Lock
		 *		- synchronized의 단점을 개선한 클래스
		 *		
		 *		락 클래스의 종류
		 *			(1) ReentrantLock
		 *				- 가장 일반적인 형태의 락
		 *				- 특정 조건에서 락을 풀고 나중에 다시 락을 얻어 임계영역으로 들어오는 재진입이 가능하다.
		 *
		 *				(1.1) ReentrantLock의 생성자
		 *					- ReentrantLock() : 쓰레드의 생성 시간 상관없이 처리한다. (성능 높음)
		 *					- ReentrantLock(boolean fair) : fair가 true인 경우 가장 오래 기다린 쓰레드가 락을 얻을 수 있도록 처리한다. (성능 낮음)
		 *
		 *				(1.2) ReentrantLock의 메소드
		 *					- void lock() : 락을 잠금
		 *					- void unlock() : 락을 해지 (임계영역 내에서 예외가 발생할 가능성을 염두하여 try-catch-finally로 감싼다.)
		 *					- boolean isLocked() : 락이 잠겼는지 확인
		 *					- boolean tryLock() : 다른 쓰레드에의해 락이 걸려있으면 락을 얻으려고 기다리지 않거나
		 *						tryLock(long timeout TimeUnit unit) : 혹은 지정된 시간만큼만 기다린다. (락을 얻으면 true, 얻지 못하면 false)
		 *		
		 *
		 *			(2) ReentrantReadWriteLock
		 *				- 읽기를 위한 락과 쓰기를 위한 락을 제공
		 *				- 읽기 락 상태에서는 다른 쓰레드가 읽기 락을 중복해서 걸고 읽는 것이 가능하다.
		 *				- 단, 읽기 락 상태에서 쓰기 락을 거는 것은 허용되지 않는다.
		 *
		 *			(3) StampedLock
		 *				- 락을 걸거나 해지할 때, 스탬프라는 Long타입의 정수 값을 사용하는 방식
		 *				- 읽기와 쓰기 락 외에 낙관적 읽기 락이 추가된 형태
		 *				- 낙관적 읽기 락이란, 무조건 읽기 락을 걸지 않고 쓰기와 읽기가 충돌할 때만 쓰기가 끝난 후에 읽기 락을 거는 방식을 뜻한다.
		 */
		Table_Lock table = new Table_Lock();
		
		new Thread(new Cook_Lock(table), "COOK1").start();
		new Thread(new Customer_Lock(table, "donut"), "CUST1").start();
		new Thread(new Customer_Lock(table, "burger"), "CUST2").start();
		
		Thread.sleep(2000);
		System.exit(0);
	}
}

//손님
class Customer_Lock implements Runnable {
	private Table_Lock table;
	private String food;
	
	public Customer_Lock(Table_Lock table, String food) {
		this.table = table;
		this.food = food;
	}
	
	public void run() {
		while (true) {
			try {
				//
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			String name = Thread.currentThread().getName();
			table.remove(food);
			System.out.println(name + " ate a " + food);
		}
	}
}

//요리
class Cook_Lock implements Runnable {
	private Table_Lock table;
	
	Cook_Lock(Table_Lock table) {
		this.table = table;
	}
	
	public void run() {
		while (true) {
			int idx = (int)(Math.random() * table.dishNum());
			table.add(table.dishNames[idx]);
			
			try {
				Thread.sleep(10);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}

//메뉴
class Table_Lock {
	String [] dishNames = {"donut", "donut", "burger"};
	final int MAX_FOOD = 6;
	private ArrayList<String> dishes = new ArrayList<>();

	// 컨디션은 이미 생성된 락으로부터 newCondition을 호출하여 생성한다.
	private ReentrantLock lock = new ReentrantLock();
	private Condition forCook = lock.newCondition();
	private Condition forCust = lock.newCondition();
	
	// 음식 제공
	public void add(String dish) {
		lock.lock();	// 락 잠금
		
		try {
			while (dishes.size() >= MAX_FOOD) {
				String name = Thread.currentThread().getName();
				System.out.println(name + " is waiting.");
				
				try {
					forCook.await();	// COOK 쓰레드를 기다리게한다.
					Thread.sleep(500);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}			
			//
			dishes.add(dish);
			forCook.signal();	// 기다리는 CUST 쓰레드를 깨운다.
			System.out.println("Dishes : " + dishes.toString());
			
		} finally {
			lock.unlock();	// 락 해제
		}				
	}
	
	// 음식 치우기
	public void remove(String dishName) {
		lock.lock();
		String name = Thread.currentThread().getName();
		
		try {
			while (dishes.size() == 0) {
				System.out.println(name + " is waiting.");
				
				try {
					forCust.await();	// CUST 쓰레드를 기다리게 한다.
					Thread.sleep(500);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			
			while(true) {
				for(int i=0;i<dishes.size();i++) {
					if(dishName.equals(dishes.get(i))) {
						dishes.remove(i);
						forCook.signal(); 	// COOK 쓰레드를 깨운다.
						return;
					}
				}
				
				try {
					System.out.println(name + " is waiting.");
					forCust.await(); // CUST 쓰레드를 기다리게 한다.
					Thread.sleep(500);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}

		} finally {
			lock.unlock();
		}
		
	}
	
	//
	public int dishNum() { return dishNames.length; }
}