package ex1_frame;

import java.awt.Color;

public class Ex2_Frame {
	public static void main(String[] args) {
		
		// �������� ���
		// - ���ڸ��� ���� ���� �������� �����ؾ��� ��Ȳ�� ����ϱ����ؼ��̴�.
		// - �ڽĸ��� �ʿ��� �Ӽ��鸸 ���� �����ؼ� ����� �� �ִ�.
		// - �������� �κ��� �θ��� �Ӽ���, �� �������� ���̴� �ڽĿ��� �������Ͽ� ����Ѵ�.
		Ex3_Frame mf = new Ex3_Frame();
		mf.setBackground(Color.YELLOW);
		//
		Ex3_Frame mf2 = new Ex3_Frame();
		mf2.setBackground(Color.CYAN);
		mf2.setTitle("���� �������̴�.");
	}
}
