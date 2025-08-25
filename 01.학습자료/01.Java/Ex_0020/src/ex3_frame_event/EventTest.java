package ex3_frame_event;

import ex2_frame_test.MyFrame;

public class EventTest extends MyFrame{
	public static void main(String[] args) {
		//
		MyFrame mf = new MyFrame();
		mf.addWindowListener(new MyEventTest());	// 프레임에 이벤트 감지자를 등록한다. (MyEventTest 인터페이스 사용)
	}
}
