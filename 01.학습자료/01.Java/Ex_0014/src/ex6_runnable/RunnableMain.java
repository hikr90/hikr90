package ex6_runnable;

public class RunnableMain {
	public static void main(String[] args) {
		// Runnable Ŭ���� ���� 
		RunnableTest rt = new RunnableTest();
		// �����带 �����ϸ� Runnable ��ü�� �Ķ���ͷ� �ִ´�.
		Thread t = new Thread(rt); 
		t.start();
	}
}
