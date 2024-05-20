package ex5_frame_adapter;

import java.awt.Frame;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameEventTest {
	public static void main(String[] args) {
		//
		Frame f = new Frame("어댑터를 사용한 이벤트 처리!");
		f.setBounds(500, 700, 400, 500);
		// WindowAdapter
		// - WindowListener를 상속하는 클래스
		f.addWindowListener(new WindowAdapter() {
			// 사용하는 메소드만 재정의한다.
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			};	// 오버라이딩의 종료에는 ; 처리를 해주는 습관을 들이자. (안드로이드 스튜디오에서는 오류 발생)
		});
		//
		f.setVisible(true);
	} // main
}
