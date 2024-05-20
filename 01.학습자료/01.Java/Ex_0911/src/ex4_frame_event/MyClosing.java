package ex4_frame_event;

import java.awt.event.WindowEvent;

public class MyClosing extends AllListener{
	// 내가 필요한 메소드만 재정의한다.
	@Override
		public void windowClosing(WindowEvent e) {
			System.out.println("종료버튼 누름!!");
			System.exit(0);
		}
}
