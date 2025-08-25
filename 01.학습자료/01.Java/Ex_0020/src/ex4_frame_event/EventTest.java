package ex4_frame_event;

import java.awt.Color;
import java.awt.Frame;

public class EventTest {
	public static void main(String[] args) {
		//
		Frame f = new Frame("이벤트 연습중");
		f.setBounds(500, 300, 300, 300);
		f.setBackground(Color.DARK_GRAY);
		// MyClosing 에서 재정의한 메소드 사용
		f.addWindowListener(new MyClosing());
		f.setVisible(true);
	}
}
