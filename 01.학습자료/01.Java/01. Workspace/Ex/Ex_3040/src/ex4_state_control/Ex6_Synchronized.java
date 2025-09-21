package ex4_state_control;

public class Ex6_Synchronized {
	public static void main(String[] args) {
		/*	�������� ����ȭ
		 * 		- ��Ƽ ������ ȯ�濡���� ���� �����尡 ���μ��� �� �ڿ��� �����ϹǷ� ������ �۾��� ������ �ش�.
		 * 		- ���� �����ִ� ���� �����ϱ����ؼ� �����忡�� �Ӱ� ������ ����̶�� ������ �����Ѵ�.
		 * 
		 * 		- ���� ���� ���� ����ϴ� �ڵ� ������ �Ӱ� �������� �����صΰ� 
		 * 		- ���� ������(��ü)�� �������ִ� Lock�� ȹ���� �� �ϳ��� �����常 ���� ���� �ڵ带 ������ �� �ְ� �Ѵ�.
		 * 
		 * 		[����] ����ȭ��, �� �����尡 ���� ���� �۾��� �ٸ� �����尡 �������� ���ϵ��� ���� ���̴�.
		 * 
		 * 
		 * 		����ȭ ���
		 * 			(1) �޼ҵ� ��ü�� �Ӱ� �������� ����
		 * 				- ������� ����ȭ �޼ҵ尡 ȣ��� �������� �ش� �޼ҵ尡 ���Ե� ��ü�� Lock�� ��� �۾��� �����ϴٰ� �޼ҵ尡 ����Ǹ� Lock�� ��ȯ�Ѵ�.
		 * 
		 * 				public synchronized void test(){
		 * 			
		 * 				}			
		 * 
		 * 			(2) Ư���� ������ �Ӱ� �������� ����
		 * 				- ���������� ���� �ɰ����ϴ� ��ü�� �����ϴ� ���̿��� �Ѵ�.
		 * 				- { }�� synchronized ���̶�� �θ���, �� ����� ����� Lock�� �ݳ��Ѵ�.
		 * 
		 * 				synchronized(��ü�� ��������) {
		 * 
		 * 				}
		 */
		 Runnable r = new Ex_Runnable();		 
		 new Thread(r).start();
		 new Thread(r).start();
	}
}


// ����
class Account {
	private int balance = 1000;
	
	public int getBalance() {
		return balance;
	}
	// ����ȭ
	// - �� �����忡�� ����� ����Ǹ� �� �޼ҵ尡 ����Ǿ� Lock�� �ݳ��� �������� �ٸ� �����忡�� ȣ���ϴ��� ��� ���°� �ȴ�.
	// - ���� (2)�� ������� �����Ѵٸ� �Ʒ� �ּ�ó�� ����ȴ�.
	public synchronized void withdraw(int money) {
		// synchronized(this) {����}
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

// ������
class Ex_Runnable implements Runnable {
	Account acc = new Account();
	
	public void run() {
		while (acc.getBalance() > 0) {
			// 100, 200, 300 ���� �� ���� ���Ƿ� �����ؼ� ���
			int money = (int)(Math.random() * 3 + 1) * 100;
			acc.withdraw(money);
			System.out.println("balance : " + acc.getBalance());
		}
	}
}