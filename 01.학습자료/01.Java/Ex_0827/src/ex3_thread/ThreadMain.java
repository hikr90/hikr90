package ex3_thread;

// Main�� ���� �����尡 ���� �������� �����ϸ� �ȴ�.
public class ThreadMain {
	public static void main(String[] args) {
		
		// �������� run()�޼��带 ���������� �����Ű�� �޼���
		MyThread mt = new MyThread();
		mt.start();
		
		
		for(int i=0;i<5;i++) {
			System.out.println("���ν������� �۾�");
		}
		
		System.out.println("���α׷� ����");
		
		
		
		
		
		
	}
}
