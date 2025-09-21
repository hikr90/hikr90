package ex2_thread_type;

public class Ex3_Thread_Priority {
	public static void main(String[] args) {
		/*	�������� �켱����
		 *		- ���� ����, ���� �ð��� �����ϴ� �Ӽ�
		 *		- �켱������ ���α׷��� ���ݿ� ���� ���� �ٸ���.
		 *		- ���� ���۰� ä�� ����� �ִ� �����忡���� ä�� ����� ���� �ٿ�ε庸�� �켱������ ���ƾ��Ѵ�. 
		 *
		 *		�켱���� �Ӽ�
		 *			- setPriority : �������� �켱������ ������ ������ �����Ѵ�.
		 *			- getPriority : �������� �켱������ ��ȯ�Ѵ�.
		 *
		 *			- MAX_PRIORITY : �ִ� �켱����
		 *			- MIN_PRIORITY : �ּ� �켱����
		 *			- NORM_PRIORITY : ���� �켱����
		 *
		 *		[����] �켱������ ������ 1 ~ 10�̸�, ���ڰ� �������� �켱������ ����.
		 *			- �������� �켱������ ������ ������κ��� ��ӹ޴´�.
		 *			- ���÷�, ���� �޼ҵ带 �����ϴ� ������� �켱������ 5�̹Ƿ� ���� ������ �����ϴ� �������� �켱������ 5�� �ȴ�.
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