package ex3_frame_listener;

import java.awt.event.WindowEvent;

public class Ex3_Listener extends Ex1_Listener{
	// ���� �ʿ��� �޼ҵ常 �������Ѵ�.
	@Override
		public void windowClosing(WindowEvent e) {
			System.out.println("�����ư ����!!");
			System.exit(0);
		}
}
