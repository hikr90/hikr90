package ex4_frame_event;

import java.awt.event.WindowEvent;

public class MyClosing extends AllListener{
	// ���� �ʿ��� �޼ҵ常 �������Ѵ�.
	@Override
		public void windowClosing(WindowEvent e) {
			System.out.println("�����ư ����!!");
			System.exit(0);
		}
}
