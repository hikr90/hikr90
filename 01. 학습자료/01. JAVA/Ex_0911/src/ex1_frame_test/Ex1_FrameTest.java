package ex1_frame_test;

import java.awt.Color;
import java.awt.Frame;

public class Ex1_FrameTest {
	public static void main(String[] args) {
		
		// FrameŬ���� �غ� 
		// ()�� ������ �������� ������ �ȴ�.
		Frame frame = new Frame("ù ������");
		
		// �ʺ�� ���� ����
		frame.setSize(400,300);
		
		// �������� ��ġ �»���� �������� x��ǥ�κ��� 500�ȼ� �������� y��ǥ�κ��� 200�ȼ� �������ִ�.
		frame.setLocation(500,200);
		
		// ColorŬ������ blue ���� ����
		// blue�� �޸𸮻� �ϳ����� static�������� ����̴�.
		frame.setBackground(Color.BLUE);
		
		// ������ ���
		frame.setVisible(true);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
