package ex2_frame_test;

import java.awt.Color;

public class Ex2_FrameTest {
	public static void main(String[] args) {
		
		// �������� ���
		// - ���ڸ��� ���� ���� �������� �����ؾ��� ��Ȳ�� ����ϱ����ؼ��̴�.
		// - �ڽĸ��� �ʿ��� �Ӽ��鸸 ���� �����ؼ� ����� �� �ִ�.
		// - �������� �κ��� �θ��� �Ӽ���, �� �������� ���̴� �ڽĿ��� �������Ͽ� ����Ѵ�.
		MyFrame mf = new MyFrame();
		mf.setBackground(Color.YELLOW);
		//
		MyFrame mf2 = new MyFrame();
		mf2.setBackground(Color.CYAN);
		mf2.setTitle("���� �������̴�.");
	}
}
