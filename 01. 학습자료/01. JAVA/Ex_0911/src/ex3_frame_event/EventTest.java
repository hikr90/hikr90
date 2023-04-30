package ex3_frame_event;
// 다른 패키지에 있는 경우, import필요
import ex2_frame_test.MyFrame;

public class EventTest extends MyFrame{
	public static void main(String[] args) {
		
		MyFrame mf = new MyFrame();
		
		// 생성된 frame에 이벤트 우상단 감지자 등록
		// 버튼 감지자를 사용하는데 MyeventTest안에 있는 인터페이스를 사용하겠어
		mf.addWindowListener(new MyEventTest());
		
		
	}
}
