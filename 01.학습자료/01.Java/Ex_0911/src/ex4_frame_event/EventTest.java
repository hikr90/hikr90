package ex4_frame_event;

import java.awt.Color;
import java.awt.Frame;

public class EventTest {
	public static void main(String[] args) {
		//
		Frame f = new Frame("�̺�Ʈ ������");
		f.setBounds(500, 300, 300, 300);
		f.setBackground(Color.DARK_GRAY);
		// MyClosing ���� �������� �޼ҵ� ���
		f.addWindowListener(new MyClosing());
		f.setVisible(true);
	}
}
