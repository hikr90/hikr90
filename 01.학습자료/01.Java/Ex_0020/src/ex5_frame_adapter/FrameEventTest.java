package ex5_frame_adapter;

import java.awt.Frame;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameEventTest {
	public static void main(String[] args) {
		//
		Frame f = new Frame("����͸� ����� �̺�Ʈ ó��!");
		f.setBounds(500, 700, 400, 500);
		// WindowAdapter
		// - WindowListener�� ����ϴ� Ŭ����
		f.addWindowListener(new WindowAdapter() {
			// ����ϴ� �޼ҵ常 �������Ѵ�.
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			};	// �������̵��� ���ῡ�� ; ó���� ���ִ� ������ ������. (�ȵ���̵� ��Ʃ��������� ���� �߻�)
		});
		//
		f.setVisible(true);
	} // main
}
