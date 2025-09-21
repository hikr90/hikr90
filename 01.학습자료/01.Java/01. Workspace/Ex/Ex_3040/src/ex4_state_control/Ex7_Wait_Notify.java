package ex4_state_control;

import java.util.ArrayList;

public class Ex7_Wait_Notify {
	public static void main(String[] args) throws Exception {		
	/*	Wait & Notify
	 * 		- �������� ����ȭ �������� �Ӱ� ������ �ڵ带 �����ϴٰ� ���̻� ������ �� ���� ��Ȳ�� ����� ���
	 * 
	 * 		(1) Wait
	 * 			- �����尡 ���� �ݳ��ϰ� ��ٸ����ϴ� �޼ҵ�
	 * 			- �ش� �޼ҵ尡 ȣ��Ǹ� ���� ���̴� ������� �ش� ��ü�� ���� (waiting pool)���� ��ٸ���.
	 * 			- notify �뺸�� ������ ���ǿ��� ��� ���̴� ���� ������ �� ������ �����常 ������ �޴´�.
	 * 				(���� ��ٸ� �����尡 �켱������ �뺸�� ���� �ʴ´�.)
	 * 
	 * 			[����] ���� ������ �����ϱ����ؼ� wait(����)�� �ۼ��� ���, ������ �ð���ŭ�� ����ϴٰ� �ڵ������� notify�� ȣ��ȴ�.
	 * 
	 * 		(2) Notify
	 * 			- �۾��� �ߴ��� �����尡 �ٽ� ���� ���, �ش� ��ü�����ؼ� �۾��� ������ �� �ֵ��� �Ѵ�.
	 * 			- ���� �����ߵ���, ���� ���� ����� �����尡 Ȯ�������� ���� ���� ���Ѵٴ� ������ �ִ�.
	 * 
	 * 		(3) Waiting Pool
	 * 			- �����尡 ����ϴ� ������ ����
	 * 			- ��ü���� �����ϹǷ�  notify�� �����Ѵٰ� ��� ��ü�� ��������� �ʴ´�.
	 * 
	 * 		[����] wait, notify, notifyAll�� ������
	 * 			(1) Object�� ���ǵǾ� �ִ�.
	 * 			(2) ����ȭ ��� (synchronized)�������� ����� �� �ִ�.
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

// �մ�
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

// �丮
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

// �޴�
class Table {
	String [] dishNames = {"donut", "donut", "burger"};
	final int MAX_FOOD = 6;
	private ArrayList<String> dishes = new ArrayList<>();
	
	// ���� ����
	public synchronized void add(String dish) {
		while (dishes.size() >= MAX_FOOD) {
			String name = Thread.currentThread().getName();
			System.out.println(name + " is waiting.");
			
			try {
				wait();	// CUST ������ ���
				Thread.sleep(500);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		//
		dishes.add(dish);
		notify();	// ��� ������ CUST ������ ���� (�� �ݳ�)
		System.out.println("Dishes : " + dishes.toString());
	}
	
	// ���� ġ���
	public void remove(String dishName) {
		synchronized(this) {
			String name = Thread.currentThread().getName();
			
			while (dishes.size() == 0) {
				System.out.println(name + " is waiting.");
				
				try {
					wait();			// Customer������ ���
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
					wait();		// ���ϴ� ������ ���� customer ������ ���
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