package ex4_frame_event;

import java.awt.Color;
import java.awt.Frame;

public class EventTest {
	public static void main(String[] args) {
	
		Frame f = new Frame("이벤트 연습중");
		f.setBounds(500, 300, 300, 300);
		f.setBackground(Color.DARK_GRAY);
		
		// 우상단 버튼 선택할건데, 닫기만 할 것이니 myclosing클래스를 가져다 쓰겠다.
		f.addWindowListener(new MyClosing());
		
		f.setVisible(true);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
