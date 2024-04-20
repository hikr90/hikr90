package ex3_frame_event;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
	// 프레임의 우상단 버튼 이벤트는 반드시 WindowListener라는 인터페이스가 필요하다.
public class MyEventTest implements WindowListener{

	// 뷰어 창에서 x 선택시 바로 꺼지는 경우도, 종료하시겠습니까? 라는 또다른 창이 뜨는 경우도 있기에 이벤트 처리가 되지 않게 기본적으로 되어있다.

	// 이벤트 감지자 : _ㅁx중 어떤 것이 클릭되었는지 확인하는 감지자
	// 감지자 : 오버라이딩 메서드를 가지고있는 인터페이스
	
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
