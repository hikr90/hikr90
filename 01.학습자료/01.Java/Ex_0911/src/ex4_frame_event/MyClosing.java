package ex4_frame_event;

import java.awt.event.WindowEvent;

// �»�� �̺�Ʈ ���� �������̽� Ŭ������ ��ӹ��� ��, 7���� �������̵� �߿��� ����ϰ����ϴ� �͸� �ڽ� Ŭ�������� ������ ���ѹ�����.
public class MyClosing extends AllListener{

		@Override
		public void windowClosing(WindowEvent e) {
			System.out.println("�����ư ����!!");
			System.exit(0);
		}
	
	
	
}
