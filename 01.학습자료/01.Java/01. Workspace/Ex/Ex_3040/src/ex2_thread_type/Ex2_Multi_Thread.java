package ex2_thread_type;

public class Ex2_Multi_Thread {
	//
	static long stm = 0;
	
	public static void main(String[] args) {
		Ex2_1_multi_thread t1 = new Ex2_1_multi_thread();
		t1.start();
		
		stm = System.currentTimeMillis();
		
		for(int i=0;i<300;i++) {
			System.out.printf("%s : ", new String("-"));
		}
		System.out.println();
		System.out.println("�ҿ� �ð�1 : " + (System.currentTimeMillis() - Ex2_Multi_Thread.stm));

	}
}

//
class Ex2_1_multi_thread extends Thread {
	public void run() {
		for(int i=0;i<300;i++) {
			System.out.printf("%s : ", new String("|"));
		}
		System.out.println();
		System.out.println("�ҿ� �ð�2 : " + (System.currentTimeMillis() - (System.currentTimeMillis() - Ex2_Multi_Thread.stm)));
	}
}