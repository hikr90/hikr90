package ex3_frame_event;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MyEventTest implements WindowListener{

	// WindowListener
	// - 이벤트 감지자를 사용하기위한 인터페이스
	// - 인터페이스니 추상 메소드를 다 구현해야한다.
	
	// 이벤트 감지자
	// - 팝업 상단의 _ ㅁ x 버튼의 클릭 행위
	
	// 감지자
	// - 오버라이딩 메소드를 가지고있는 인터페이스
	
	@Override
	public void windowActivated(WindowEvent e) {
		//  TODO Auto-generated method stub
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// 우상단 x버튼 클릭을 감지하는 메서드
		System.out.println("x버튼 클릭됨!!");
		System.exit(0); // 프레임 종료 (정상종료 : 0 / 오류가 난 상태에서 종료 : -1)
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// 최소화 단계에서 원래 사이즈로 돌아왔을 때 호출되는 메서드
		System.out.println("원래 크기로 돌아옴!!");
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// 최소화 버튼을 클릭했을 때 감지하는 메서드
		System.out.println("최소화 버튼 클릭됨!!");
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
	}
}
