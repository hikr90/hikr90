package ex4_state_control;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Ex8_Lock_Condition {
	public static void main(String[] args) throws InterruptedException {
		/*	Lock
		 *		- synchronized�� ������ ������ Ŭ����
		 *		
		 *		�� Ŭ������ ����
		 *			(1) ReentrantLock
		 *				- ���� �Ϲ����� ������ ��
		 *				- Ư�� ���ǿ��� ���� Ǯ�� ���߿� �ٽ� ���� ��� �Ӱ迵������ ������ �������� �����ϴ�.
		 *
		 *				(1.1) ReentrantLock�� ������
		 *					- ReentrantLock() : �������� ���� �ð� ������� ó���Ѵ�. (���� ����)
		 *					- ReentrantLock(boolean fair) : fair�� true�� ��� ���� ���� ��ٸ� �����尡 ���� ���� �� �ֵ��� ó���Ѵ�. (���� ����)
		 *
		 *				(1.2) ReentrantLock�� �޼ҵ�
		 *					- void lock() : ���� ���
		 *					- void unlock() : ���� ���� (�Ӱ迵�� ������ ���ܰ� �߻��� ���ɼ��� �����Ͽ� try-catch-finally�� ���Ѵ�.)
		 *					- boolean isLocked() : ���� ������ Ȯ��
		 *					- boolean tryLock() : �ٸ� �����忡���� ���� �ɷ������� ���� �������� ��ٸ��� �ʰų�
		 *						tryLock(long timeout TimeUnit unit) : Ȥ�� ������ �ð���ŭ�� ��ٸ���. (���� ������ true, ���� ���ϸ� false)
		 *		
		 *
		 *			(2) ReentrantReadWriteLock
		 *				- �б⸦ ���� ���� ���⸦ ���� ���� ����
		 *				- �б� �� ���¿����� �ٸ� �����尡 �б� ���� �ߺ��ؼ� �ɰ� �д� ���� �����ϴ�.
		 *				- ��, �б� �� ���¿��� ���� ���� �Ŵ� ���� ������ �ʴ´�.
		 *
		 *			(3) StampedLock
		 *				- ���� �ɰų� ������ ��, ��������� LongŸ���� ���� ���� ����ϴ� ���
		 *				- �б�� ���� �� �ܿ� ������ �б� ���� �߰��� ����
		 *				- ������ �б� ���̶�, ������ �б� ���� ���� �ʰ� ����� �бⰡ �浹�� ���� ���Ⱑ ���� �Ŀ� �б� ���� �Ŵ� ����� ���Ѵ�.
		 */
		Table_Lock table = new Table_Lock();
		
		new Thread(new Cook_Lock(table), "COOK1").start();
		new Thread(new Customer_Lock(table, "donut"), "CUST1").start();
		new Thread(new Customer_Lock(table, "burger"), "CUST2").start();
		
		Thread.sleep(2000);
		System.exit(0);
	}
}

//�մ�
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

//�丮
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

//�޴�
class Table_Lock {
	String [] dishNames = {"donut", "donut", "burger"};
	final int MAX_FOOD = 6;
	private ArrayList<String> dishes = new ArrayList<>();

	// ������� �̹� ������ �����κ��� newCondition�� ȣ���Ͽ� �����Ѵ�.
	private ReentrantLock lock = new ReentrantLock();
	private Condition forCook = lock.newCondition();
	private Condition forCust = lock.newCondition();
	
	// ���� ����
	public void add(String dish) {
		lock.lock();	// �� ���
		
		try {
			while (dishes.size() >= MAX_FOOD) {
				String name = Thread.currentThread().getName();
				System.out.println(name + " is waiting.");
				
				try {
					forCook.await();	// COOK �����带 ��ٸ����Ѵ�.
					Thread.sleep(500);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}			
			//
			dishes.add(dish);
			forCook.signal();	// ��ٸ��� CUST �����带 �����.
			System.out.println("Dishes : " + dishes.toString());
			
		} finally {
			lock.unlock();	// �� ����
		}				
	}
	
	// ���� ġ���
	public void remove(String dishName) {
		lock.lock();
		String name = Thread.currentThread().getName();
		
		try {
			while (dishes.size() == 0) {
				System.out.println(name + " is waiting.");
				
				try {
					forCust.await();	// CUST �����带 ��ٸ��� �Ѵ�.
					Thread.sleep(500);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			
			while(true) {
				for(int i=0;i<dishes.size();i++) {
					if(dishName.equals(dishes.get(i))) {
						dishes.remove(i);
						forCook.signal(); 	// COOK �����带 �����.
						return;
					}
				}
				
				try {
					System.out.println(name + " is waiting.");
					forCust.await(); // CUST �����带 ��ٸ��� �Ѵ�.
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