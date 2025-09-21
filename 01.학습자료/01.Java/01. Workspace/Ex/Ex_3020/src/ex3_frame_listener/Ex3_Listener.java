package ex3_frame_listener;

import java.awt.event.WindowEvent;

public class Ex3_Listener extends Ex1_Listener{
	// 내가 필요한 메소드만 재정의한다.
	@Override
		public void windowClosing(WindowEvent e) {
			System.out.println("종료버튼 누름!!");
			System.exit(0);
		}
}
