package ex3_frame_listener;

import java.awt.Color;
import java.awt.Frame;

public class Ex2_Listener {
	public static void main(String[] args) {
		//
		Frame f = new Frame("�̺�Ʈ ������");
		f.setBounds(500, 300, 300, 300);
		f.setBackground(Color.DARK_GRAY);
		// MyClosing ���� �������� �޼ҵ� ���
		f.addWindowListener(new Ex3_Listener());
		f.setVisible(true);
	}
}
