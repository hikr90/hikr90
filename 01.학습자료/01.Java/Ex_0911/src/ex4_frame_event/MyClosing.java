package ex4_frame_event;

import java.awt.event.WindowEvent;

// 좌상단 이벤트 관리 인터페이스 클래스를 상속받은 뒤, 7개의 오버라이딩 중에서 사용하고자하는 것만 자식 클래스에서 재정의 시켜버린다.
public class MyClosing extends AllListener{

		@Override
		public void windowClosing(WindowEvent e) {
			System.out.println("종료버튼 누름!!");
			System.exit(0);
		}
	
	
	
}
