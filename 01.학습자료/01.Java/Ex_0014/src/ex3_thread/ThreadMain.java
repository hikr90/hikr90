package ex3_thread;

public class ThreadMain {
	public static void main(String[] args) {

		// ������ ���� Ŭ����
		// - �����带 ����ϴ� Ŭ������ ������ ��
		// - start �޼ҵ带 ���ؼ� ���۽�Ų��.
		MyThread mt = new MyThread();
		mt.start();
		//
		for(int i=0;i<5;i++) {
			System.out.println("���ν������� �۾�");
		}
		//
		System.out.println("���α׷� ����");
	}
}
