package ex1_thread;

public class Ex2_Start_Run {
	public static void main(String[] args) {
		/*	start & run
		 * 	- ������ ���� ��, run�� �ƴ� start�� �����Ѵ�.
		 * 	- ���� �޼ҵ忡�� run���� ���۽�Ű�� ���� �����尡 �����ϴ� ���� �ƴ� Ŭ���� �� ����� �����尡 �����ϴ� ���̴�.
		 * 	
		 * 	(1) Call Stack
		 * 		- ���� �������� ���α׷� ���� ��, ���� ������ ���̴� ����
		 * 		- ȣ�� ���ÿ����� ���� ���� �ִ� �޼ҵ尡 ���� ���� ���� �޼ҵ��̴�. (������ �޼ҵ�� ��� ����)
		 * 		- �����췯�� ���� ������� ��������� �켱������ ����Ͽ� ��������� ����ð��� �����Ѵ�.
		 * 		- run�� �����ϸ� �۾� ������ �Ϸ�� ������� ȣ�� ���ÿ��� ������鼭 �ش� �����尡 ����ϴ� ȣ�� ���õ� �������.
		 * 
		 * 		(1.1) ���ο��� run ����
		 * 			- (1) main > (2) run
		 * 
		 * 		(1.2) ���ο��� start ����
		 * 			(1) ���ο� ������ ����
		 * 			(2) �۾� ���࿡ �ʿ��� ȣ�� ���� ����
		 * 			(3) ȣ�� ���ÿ��� run�� �����Ͽ� �����尡 �������� �������� �۾��� ����
		 * 			(4) main/run �ΰ��� ȣ�� ������ �����췯�� ���� ������ ���ؼ� �����ư��鼭 ����
		 * 
		 * 		[����] ���� �޼ҵ嵵 �������̴�.
		 * 			- ���� �ٸ� �����尡 ��� ���¶�� ���� �����尡 ����Ǿ ���α׷��� ������� �ʴ´�.
		 * 
		 */
		
		// [����] start�� run�� ����
		Ex2_1_Thread t1 = new Ex2_1_Thread();
		
		// (1) start (run > throwException)
		// - at ex2_start_run.Ex2_1_Thread.throwException(Ex1_start_run.java:47)
		// - at ex2_start_run.Ex2_1_Thread.run(Ex1_start_run.java:42)
		t1.start();
		
		// (2) run (throwException > run > main)
		// - at ex2_start_run.Ex2_1_Thread.throwException(Ex1_start_run.java:55)
		// - at ex2_start_run.Ex2_1_Thread.run(Ex1_start_run.java:50)
		// - at ex2_start_run.Ex1_start_run.main(Ex1_start_run.java:43)
		// t1.run();
	}
}

// ������ ���� �߻�
class Ex2_1_Thread extends Thread {
	public void run() {
		throwException();
	}
	//
	public void throwException() {
		try {
			throw new Exception();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}