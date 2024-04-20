package ex5_frame_adapter;

import java.awt.Frame;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// Allistener�� Myclosing ��ģ ����

public class FrameEventTest {
	public static void main(String[] args) {
		
		Frame f = new Frame("����͸� ����� �̺�Ʈ ó��!");
		f.setBounds(500, 700, 400, 500);
		
		// WindowAdapter�� ����� ���� �̺�Ʈ ó��
		// WindowAdapter�� WindowListener�� ����ϰ��ִ�.  
		f.addWindowListener(new WindowAdapter() {
			
			// ��� ����ϰ����ϴ� �޼ҵ常 �������ϸ� �ȴ�.
			// �������̵��� ; �ϴ� ������ ���̴� ���� ����. (�ȵ���̵忡���� ������ ������ ����.)
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			};
		});
		
		f.setVisible(true);
		
		
		
	} // main
}
