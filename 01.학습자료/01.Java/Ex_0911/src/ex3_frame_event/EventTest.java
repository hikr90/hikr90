package ex3_frame_event;

import ex2_frame_test.MyFrame;

public class EventTest extends MyFrame{
	public static void main(String[] args) {
		//
		MyFrame mf = new MyFrame();
		mf.addWindowListener(new MyEventTest());	// �����ӿ� �̺�Ʈ �����ڸ� ����Ѵ�. (MyEventTest �������̽� ���)
	}
}
