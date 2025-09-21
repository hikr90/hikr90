package ex4_state_control;

import javax.swing.JOptionPane;

public class Ex2_Interrupt {
	public static void main(String[] args) {
		/* �������� �۾� ���
		 * 	- interrupt �� �������� �۾��� ��ҽ�Ű�� �����带 ������ ������Ű���� ���Ѵ�.
		 * 	- interrupted�� �����忡 interrupt�� ���۵Ǿ������� Ȯ���Ѵ�.
		 */
		Ex2_1_Thread th1 = new Ex2_1_Thread();
		th1.start();
		
		String s = JOptionPane.showInputDialog("�ƹ� ���̳� �Է��ϼ���.");
		System.out.println("�Է��Ͻ� ���� " + s + "�Դϴ�.");
		th1.interrupt();			// �Ͻ�����
		System.out.println("isInterrupted : " + th1.isInterrupted());			// true
	}
}

//
class Ex2_1_Thread extends Thread {
	public void run() {
		int i = 10;
		//
		while (i != 0 && !isInterrupted()) {
			System.out.println(i--);
			// 1�� ���
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// [����] �ð� ���� ��� sleep�� �־��� �� ���� �߻��� �Բ� �ð��� ������ �ʴ� ����?
				//		- sleep�� ���ؼ� �����尡 �������� ��, interrupt �� ȣ���ϸ� InterruptedException�� �߻��Ѵ�.
				// 	- �ش� ���ܰ� �߻��ϸ鼭 interrupted �� false (����) ���·� ����ȴ�.
				// 	- �ð��� ������Ű�����Ѵٸ� ���� interrupt() �� �־�� �Ѵ�.
				//e.printStackTrace();
				interrupt();
			}
			//
			// for(long x=0;x<2500000000L;x++);	// �ð� ����
		}
		System.out.println("ī��Ʈ ����");
	}
}