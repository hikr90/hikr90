package ex1_frame;

import java.awt.Frame;

public class Ex3_Frame extends Frame{
	// - �������� ��ӹ����� frame�� ����� ��ӹ޾� ����� �����ϴ�.
	public Ex3_Frame() {

		// - ��ӹ޾ұ� ������, �θ��� �޼��带 �ڱ� ������� ����� �����ϹǷ� set���� �ٷ� �����ϴ�.
		// - setSize(400,400);
		// - setLocation(800,300);
		
		// - Size�� Location ���ÿ� ó��
		// - (Location, Size)
		setBounds(800, 300, 400, 400);
		setVisible(true);
	}
}
