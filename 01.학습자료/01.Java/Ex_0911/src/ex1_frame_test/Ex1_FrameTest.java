package ex1_frame_test;

import java.awt.Color;
import java.awt.Frame;

public class Ex1_FrameTest {
	public static void main(String[] args) {
		/*	Frame
		 *		- �������� �����ϴ� Ŭ����
		 */
		Frame frame = new Frame("ù ������");	// �Ķ���ʹ� �������� �����̴�.
		//
		frame.setSize(400,300);			// �ʺ�� ���� ����
		frame.setLocation(500,200);		// �� ����� �������� x��ǥ�κ��� 500 �ȼ�, y��ǥ�κ��� 200�ȼ� ������ ��ġ
		frame.setBackground(Color.BLUE);	// ������ ����
		frame.setVisible(true);	// ������ ���
	}
}
