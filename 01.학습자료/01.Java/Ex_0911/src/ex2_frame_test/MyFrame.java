package ex2_frame_test;

import java.awt.Frame;

public class MyFrame extends Frame{
	// - �������� ��ӹ����� frame�� ����� ��ӹ޾� ����� �����ϴ�.
	public MyFrame() {

		// - ��ӹ޾ұ� ������, �θ��� �޼��带 �ڱ� ������� ����� �����ϹǷ� set���� �ٷ� �����ϴ�.
		// - setSize(400,400);
		// - setLocation(800,300);
		
		// - Size�� Location ���ÿ� ó��
		// - (Location, Size)
		setBounds(800, 300, 400, 400);
		setVisible(true);
	}
}
