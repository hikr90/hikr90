package ex3_frame_listener;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Ex1_Listener implements WindowListener{
	
	// 좌상단 이벤트 처리자에서 한가지의 메소드만 사용하는 경우가 있다.
	// 모든 메소드를 적기에는 양이 너무 많으므로 특정 클래스에서 인터페이스를 구현한 뒤
	// 클래스를 하나 더 만들어서 이 클래스를 상속한 뒤 자식클래스에서 필요한 메소드만 재정의해서 사용한다.
	
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
	}
}
