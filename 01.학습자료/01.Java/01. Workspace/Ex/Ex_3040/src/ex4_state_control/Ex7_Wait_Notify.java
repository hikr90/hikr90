package ex4_state_control;

import java.util.ArrayList;

public class Ex7_Wait_Notify {
	public static void main(String[] args) throws Exception {		
	/*	Wait & Notify
	 * 		- 쓰레드의 동기화 과정에서 임계 영역의 코드를 수행하다가 더이상 진행할 수 없는 상황을 대비한 기능
	 * 
	 * 		(1) Wait
	 * 			- 쓰레드가 락을 반납하고 기다리게하는 메소드
	 * 			- 해당 메소드가 호출되면 실행 중이던 쓰레드는 해당 객체의 대기실 (waiting pool)에서 기다린다.
	 * 			- notify 통보가 나오면 대기실에서 대기 중이던 여러 쓰레드 중 임의의 쓰레드만 통지를 받는다.
	 * 				(오래 기다린 쓰레드가 우선적으로 통보를 받지 않는다.)
	 * 
	 * 			[참고] 위의 단점을 보완하기위해서 wait(변수)로 작성할 경우, 지정된 시간만큼만 대기하다가 자동적으로 notify가 호출된다.
	 * 
	 * 		(2) Notify
	 * 			- 작업을 중단한 쓰레드가 다시 락을 얻어, 해당 객체에대해서 작업을 수행할 수 있도록 한다.
	 * 			- 위에 설명했듯이, 가장 먼저 대기한 쓰레드가 확정적으로 락을 받지 못한다는 단점이 있다.
	 * 
	 * 		(3) Waiting Pool
	 * 			- 쓰레드가 대기하는 일종의 대기실
	 * 			- 객체마다 존재하므로  notify가 동작한다고 모든 객체가 영향받지는 않는다.
	 * 
	 * 		[참고] wait, notify, notifyAll의 공통점
	 * 			(1) Object에 정의되어 있다.
	 * 			(2) 동기화 블록 (synchronized)내에서만 사용할 수 있다.
	 * 
	 */
		Table table = new Table();
	 
		new Thread(new Cook(table), "COOK1").start();
		new Thread(new Customer(table, "donut"), "CUST1").start();
		new Thread(new Customer(table, "burger"), "CUST2").start();
		
		Thread.sleep(2000);
		System.exit(0);
	}
}

// 손님
class Customer implements Runnable {
	private Table table;
	private String food;
	
	public Customer(Table table, String food) {
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

// 요리
class Cook implements Runnable {
	private Table table;
	
	Cook(Table table) {
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

// 메뉴
class Table {
	String [] dishNames = {"donut", "donut", "burger"};
	final int MAX_FOOD = 6;
	private ArrayList<String> dishes = new ArrayList<>();
	
	// 음식 제공
	public synchronized void add(String dish) {
		while (dishes.size() >= MAX_FOOD) {
			String name = Thread.currentThread().getName();
			System.out.println(name + " is waiting.");
			
			try {
				wait();	// CUST 쓰레드 대기
				Thread.sleep(500);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		//
		dishes.add(dish);
		notify();	// 대기 상태인 CUST 쓰레드 동작 (락 반납)
		System.out.println("Dishes : " + dishes.toString());
	}
	
	// 음식 치우기
	public void remove(String dishName) {
		synchronized(this) {
			String name = Thread.currentThread().getName();
			
			while (dishes.size() == 0) {
				System.out.println(name + " is waiting.");
				
				try {
					wait();			// Customer쓰레드 대기
					Thread.sleep(500);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			
			while(true) {
				for(int i=0;i<dishes.size();i++) {
					if(dishName.equals(dishes.get(i))) {
						dishes.remove(i);
						notify();
						return;
					}
				}
				
				try {
					System.out.println(name + " is waiting.");
					wait();		// 원하는 음식이 없는 customer 쓰레드 대기
					Thread.sleep(500);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}
	
	//
	public int dishNum() { return dishNames.length; }
}