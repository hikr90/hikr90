package ex2_frame_event;

import ex1_frame.Ex3_Frame;

public class Ex1_Frame_Event extends Ex3_Frame{
	public static void main(String[] args) {
		//
		Ex3_Frame mf = new Ex3_Frame();
		mf.addWindowListener(new Ex2_Frame_Event());	// 프레임에 이벤트 감지자를 등록한다. (MyEventTest 인터페이스 사용)
	}
}
