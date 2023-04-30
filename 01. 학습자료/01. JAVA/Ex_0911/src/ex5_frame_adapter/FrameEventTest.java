package ex5_frame_adapter;

import java.awt.Frame;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// Allistener와 Myclosing 합친 내용

public class FrameEventTest {
	public static void main(String[] args) {
		
		Frame f = new Frame("어댑터를 사용한 이벤트 처리!");
		f.setBounds(500, 700, 400, 500);
		
		// WindowAdapter를 사용한 우상단 이벤트 처리
		// WindowAdapter는 WindowListener를 상속하고있다.  
		f.addWindowListener(new WindowAdapter() {
			
			// 고로 사용하고자하는 메소드만 재정의하면 된다.
			// 오버라이딩은 ; 하는 습관을 들이는 것이 좋다. (안드로이드에서는 없으면 오류가 난다.)
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			};
		});
		
		f.setVisible(true);
		
		
		
	} // main
}
