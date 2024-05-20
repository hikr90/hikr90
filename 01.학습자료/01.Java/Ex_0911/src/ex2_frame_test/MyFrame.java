package ex2_frame_test;

import java.awt.Frame;

public class MyFrame extends Frame{
	// - 프레임을 상속받으면 frame의 기능을 상속받아 사용이 가능하다.
	public MyFrame() {

		// - 상속받았기 때문에, 부모의 메서드를 자기 마음대로 사용이 가능하므로 set으로 바로 가능하다.
		// - setSize(400,400);
		// - setLocation(800,300);
		
		// - Size와 Location 동시에 처리
		// - (Location, Size)
		setBounds(800, 300, 400, 400);
		setVisible(true);
	}
}
